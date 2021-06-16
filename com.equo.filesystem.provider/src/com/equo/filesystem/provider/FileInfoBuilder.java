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

import java.util.Collection;

import com.equo.filesystem.api.FileInfo;

/**
 * Builder for {@link com.equo.filesystem.api.FileInfo}.
 */
public class FileInfoBuilder {
  private boolean exists;
  private String path;
  private String name;
  private boolean canRead;
  private boolean canWrite;
  private boolean canExecute;
  private boolean isDirectory;
  private Collection<FileInfo> children;

  /**
   * Sets whether the file/folder exists or not.
   */
  protected void setExists(boolean exists) {
    this.exists = exists;
  }

  /**
   * Sets the file/folder path.
   */
  protected void setPath(String path) {
    this.path = path;
  }

  /**
   * Sets the file/folder name.
   */
  protected void setName(String name) {
    this.name = name;
  }

  /**
   * Sets whether the file/folder has read permission.
   */
  protected void setCanRead(boolean canRead) {
    this.canRead = canRead;
  }

  /**
   * Sets whether the file/folder has write permission.
   */
  protected void setCanWrite(boolean canWrite) {
    this.canWrite = canWrite;
  }

  /**
   * Sets whether it can be executed.
   */
  protected void setCanExecute(boolean canExecute) {
    this.canExecute = canExecute;
  }

  /**
   * Sets whether this resource is a directory or not.
   */
  protected void setDirectory(boolean isDirectory) {
    this.isDirectory = isDirectory;
  }

  /**
   * Sets the children of this resource.
   */
  protected void setChildren(Collection<FileInfo> children) {
    this.children = children;
  }

  /**
   * Creates the {@link com.equo.filesystem.api.FileInfo} instance created through
   * FileInfoBuilder data.
   */
  protected FileInfo build() {
    return new FileInfo(exists, path, name, canRead, canWrite, canExecute, isDirectory, children);
  }
}
