package com.equo.filesystem.provider.handlers;

import java.io.File;

import com.equo.filesystem.provider.responses.ContentResponse;
import com.equo.filesystem.provider.responses.ErrResponse;
import com.google.gson.JsonObject;

/**
 * Handler responsible for copying actions.
 */
public class CopyFileHandler extends FileSystemHandler {

  @Override
  protected Object execute(JsonObject payload) {
    File actualFile = new File(getPathParam(payload));
    File folderDest = new File(getContentParam(payload));
    String response = equoFileSystem.copyFile(actualFile, folderDest);
    if (response != null) {
      return new ContentResponse(response);
    }
    return new ErrResponse();
  }

  @Override
  protected String getCommandName() {
    return "_CopyFile";
  }

}
