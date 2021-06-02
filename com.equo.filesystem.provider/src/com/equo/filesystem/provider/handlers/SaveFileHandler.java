package com.equo.filesystem.provider.handlers;

import java.io.File;

import com.equo.filesystem.provider.responses.ErrResponse;
import com.equo.filesystem.provider.responses.OkResponse;
import com.google.gson.JsonObject;

/**
 * Handler responsible to save file content.
 */
public class SaveFileHandler extends FileSystemHandler {
  @Override
  protected Object execute(JsonObject payload) {
    File file = new File(getPathParam(payload));
    String content = getContentParam(payload);
    if (equoFileSystem.saveFile(file, content)) {
      return new OkResponse();
    }
    return new ErrResponse();
  }

  @Override
  protected String getCommandName() {
    return "_SaveFile";
  }
}
