package com.equo.filesystem.provider.handlers;

import org.eclipse.swt.widgets.Display;

import com.equo.filesystem.api.IEquoFileSystem;
import com.equo.filesystem.provider.util.ICommandConstants;
import com.equo.ws.api.IEquoEventHandler;
import com.google.gson.JsonObject;

/**
 * Abstraction for every file system handler. Implements the handler
 * registration logic.
 */
public abstract class FileSystemHandler {
  protected IEquoFileSystem equoFileSystem;

  /**
   * Executes the action corresponding to the command.
   * @param  payload ws event payload
   * @return         the output of the command execution.
   */
  protected abstract Object execute(JsonObject payload);

  /**
   * Gets the command name.
   * @return the command name.
   */
  protected abstract String getCommandName();

  /**
   * Registers in the handler the command along with its executable action.
   * @param equoFileSystem The IEquoFileSystem instance implementation.
   * @param eventHandler   The IEquoEventHandler instance implementation.
   */
  public void register(IEquoFileSystem equoFileSystem, IEquoEventHandler eventHandler) {
    this.equoFileSystem = equoFileSystem;
    eventHandler.on(getCommandName(), (JsonObject payload) -> {
      Display.getDefault().asyncExec(() -> {
        String idResponse = payload.get(ICommandConstants.PARAM_RESPONSE_ID).getAsString();
        Object response = execute(payload);
        eventHandler.send(idResponse, response);
      });
    });
  }

  protected String getPathParam(JsonObject payload) throws ClassCastException {
    return payload.get(ICommandConstants.PARAM_FILE_PATH).getAsString();
  }

  protected String getContentParam(JsonObject payload) throws ClassCastException {
    return payload.get(ICommandConstants.PARAM_CONTENT).getAsString();
  }
}
