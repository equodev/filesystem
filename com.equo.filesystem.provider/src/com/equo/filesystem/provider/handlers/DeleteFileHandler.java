package com.equo.filesystem.provider.handlers;

import java.io.File;

import com.equo.filesystem.provider.responses.ErrResponse;
import com.equo.filesystem.provider.responses.OkResponse;
import com.google.gson.JsonObject;

/**
 * Handler responsible for deleting actions.
 */
public class DeleteFileHandler extends FileSystemHandler {
  @Override
  protected String getCommandName() {
    return "_DeleteFile";
  }

  @Override
  protected Object execute(JsonObject payload) {
    if (equoFileSystem.deleteFile(new File(getPathParam(payload)))) {
      return new OkResponse();
    }
    return new ErrResponse();
  }

}