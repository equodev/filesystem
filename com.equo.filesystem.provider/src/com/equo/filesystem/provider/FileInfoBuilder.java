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
