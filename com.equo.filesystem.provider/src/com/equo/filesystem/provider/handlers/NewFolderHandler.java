package com.equo.filesystem.provider.handlers;

import java.io.File;

import com.equo.filesystem.provider.responses.ErrResponse;
import com.equo.filesystem.provider.responses.OkResponse;
import com.google.gson.JsonObject;

/**
 * Handler responsible to create a new folder.
 */
public class NewFolderHandler extends FileSystemHandler {
  @Override
  protected Object execute(JsonObject payload) {
    File newFolder = new File(getPathParam(payload));
    if (equoFileSystem.newFolder(newFolder)) {
      return new OkResponse();
    }
    return new ErrResponse();
  }

  @Override
  protected String getCommandName() {
    return "_NewFolder";
  }
}
