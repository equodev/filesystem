/****************************************************************************
**
** Copyright (C) 2021 Equo
**
** This file is part of Equo Framework.
**
** Commercial License Usage
** Licensees holding valid commercial Equo licenses may use this file in
** accordance with the commercial license agreement provided with the
** Software or, alternatively, in accordance with the terms contained in
** a written agreement between you and Equo. For licensing terms
** and conditions see https://www.equoplatform.com/terms.
**
** GNU General Public License Usage
** Alternatively, this file may be used under the terms of the GNU
** General Public License version 3 as published by the Free Software
** Foundation. Please review the following
** information to ensure the GNU General Public License requirements will
** be met: https://www.gnu.org/licenses/gpl-3.0.html.
**
****************************************************************************/

package com.equo.filesystem.provider.handlers;

import org.eclipse.swt.widgets.Display;

import com.equo.comm.api.IEquoEventHandler;
import com.equo.filesystem.api.IEquoFileSystem;
import com.equo.filesystem.provider.util.ICommandConstants;
import com.google.gson.JsonObject;

/**
 * Abstraction for every file system handler. Implements the handler
 * registration logic.
 */
public abstract class FileSystemHandler {
  protected IEquoFileSystem equoFileSystem;

  /**
   * Executes the action corresponding to the command.
   * @param  payload comm event payload
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
    eventHandler.on(getCommandName(), JsonObject.class, payload -> {
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
