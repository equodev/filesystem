package com.equo.filesystem.provider.handlers;

import java.io.File;

import com.equo.filesystem.api.IEquoFileSystem;
import com.equo.filesystem.provider.responses.ContentResponse;
import com.equo.filesystem.provider.responses.ErrResponse;
import com.google.gson.JsonObject;

/**
 * Handler responsible to read files.
 */
public class ReadFileHandler extends FileSystemHandler {
  @Override
  protected Object execute(JsonObject payload) {
    File file = new File(getPathParam(payload));
    return readFile(file, equoFileSystem);
  }

  protected static Object readFile(File file, IEquoFileSystem equoFileSystem) {
    String content = equoFileSystem.readFile(file);
    if (content == null) {
      return new ErrResponse();
    }
    ContentResponse response = new ContentResponse(content);
    return response;
  }

  @Override
  protected String getCommandName() {
    return "_ReadFile";
  }
}
