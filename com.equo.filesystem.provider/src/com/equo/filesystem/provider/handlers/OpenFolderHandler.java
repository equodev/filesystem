package com.equo.filesystem.provider.handlers;

import java.io.File;

import com.equo.filesystem.provider.responses.ErrResponse;
import com.google.gson.JsonObject;

/**
 * Handler responsible to open a folder.
 */
public class OpenFolderHandler extends FileSystemHandler {
  @Override
  protected Object execute(JsonObject payload) {
    File folder = equoFileSystem.openFolder();
    if (folder == null) {
      return new ErrResponse();
    }
    return equoFileSystem.fileInfo(folder);
  }

  @Override
  protected String getCommandName() {
    return "_OpenFolder";
  }
}
