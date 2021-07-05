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

package com.equo.filesystem.provider;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.equo.comm.api.IEquoEventHandler;
import com.equo.contribution.api.EquoContributionBuilder;
import com.equo.contribution.api.resolvers.EquoGenericUrlResolver;
import com.equo.filesystem.api.IEquoFileSystem;
import com.equo.filesystem.provider.handlers.CopyFileHandler;
import com.equo.filesystem.provider.handlers.DeleteFileHandler;
import com.equo.filesystem.provider.handlers.FileInfoHandler;
import com.equo.filesystem.provider.handlers.MoveFileHandler;
import com.equo.filesystem.provider.handlers.NewFolderHandler;
import com.equo.filesystem.provider.handlers.OpenFileHandler;
import com.equo.filesystem.provider.handlers.OpenFolderHandler;
import com.equo.filesystem.provider.handlers.ReadFileHandler;
import com.equo.filesystem.provider.handlers.RenameFileHandler;
import com.equo.filesystem.provider.handlers.SaveFileAsHandler;
import com.equo.filesystem.provider.handlers.SaveFileHandler;

/**
 * Contribution that provides the filesystem javascript API.
 */
@Component
public class EquoFileSystemContribution {
  private static final String FILE_SYSTEM_CONTRIBUTION_NAME = "equofilesystem";
  private static final String COMMANDS_JS_API = "equoCommands.js";

  private EquoContributionBuilder builder;

  @Reference
  IEquoEventHandler equoEventHandler;

  @Reference
  IEquoFileSystem equoFileSystem;

  @Activate
  protected void activate() {
    registerHandlers();

    builder.withContributionName(FILE_SYSTEM_CONTRIBUTION_NAME).withScriptFile(COMMANDS_JS_API)
        .withUrlResolver(
            new EquoGenericUrlResolver(EquoFileSystemContribution.class.getClassLoader()))
        .build();
  }

  private void registerHandlers() {
    new FileInfoHandler().register(equoFileSystem, equoEventHandler);
    new DeleteFileHandler().register(equoFileSystem, equoEventHandler);
    new MoveFileHandler().register(equoFileSystem, equoEventHandler);
    new CopyFileHandler().register(equoFileSystem, equoEventHandler);
    new NewFolderHandler().register(equoFileSystem, equoEventHandler);
    new OpenFileHandler().register(equoFileSystem, equoEventHandler);
    new OpenFolderHandler().register(equoFileSystem, equoEventHandler);
    new ReadFileHandler().register(equoFileSystem, equoEventHandler);
    new RenameFileHandler().register(equoFileSystem, equoEventHandler);
    new SaveFileAsHandler().register(equoFileSystem, equoEventHandler);
    new SaveFileHandler().register(equoFileSystem, equoEventHandler);
  }

  @Reference
  void setEquoBuilder(EquoContributionBuilder builder) {
    this.builder = builder;
  }

  void unsetEquoBuilder(EquoContributionBuilder builder) {
    this.builder = null;
  }
}
