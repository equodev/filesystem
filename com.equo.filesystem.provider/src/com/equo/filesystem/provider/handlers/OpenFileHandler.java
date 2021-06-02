package com.equo.filesystem.provider.handlers;

import java.io.File;

import com.equo.filesystem.provider.responses.ErrResponse;
import com.google.gson.JsonObject;

/**
 * Handler responsible to open a file.
 */
public class OpenFileHandler extends FileSystemHandler {
  @Override
  protected Object execute(JsonObject payload) {
    File file = equoFileSystem.openFile();
    if (file == null) {
      return new ErrResponse();
    }
    return ReadFileHandler.readFile(file, equoFileSystem);
  }

  @Override
  protected String getCommandName() {
    return "_OpenFile";
  }
}
