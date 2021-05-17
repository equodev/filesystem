package com.equo.filesystem.provider;

import java.util.Collection;

import com.equo.filesystem.api.FileInfo;

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
	 * Sets whether the folder exists or not.
	 * @param exists
	 */
	protected void setExists(boolean exists) {
		this.exists = exists;
	}
	/**
	 * Sets the folder path.
	 * @param path
	 */
	protected void setPath(String path) {
		this.path = path;
	}
	/**
	 * Sets the folder name.
	 * @param name
	 */
	protected void setName(String name) {
		this.name = name;
	}
	/**
	 * Sets whether the folder has read permission.
	 * @param canRead
	 */
	protected void setCanRead(boolean canRead) {
		this.canRead = canRead;
	}
	/**
	 * Sets whether the folder has write permission.
	 * @param canWrite
	 */
	protected void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}
	/**
	 * Sets whether it can be executed.
	 * @param canExecute
	 */
	protected void setCanExecute(boolean canExecute) {
		this.canExecute = canExecute;
	}
	/**
	 * Sets whether this resource is a directory or not.
	 * @param isDirectory
	 */
	protected void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	/**
	 * Sets the children of this resource.
	 * @param children
	 */
	protected void setChildren(Collection<FileInfo> children) {
		this.children = children;
	}
	/**
	 * Creates the Fileinfo instance created through FileInfoBuilder data.
	 * @return the Fileinfo instance created through FileInfoBuilder data.
	 */
	protected FileInfo build() {
		return new FileInfo(exists, path, name, canRead, canWrite, canExecute, isDirectory, children);
	}
}
