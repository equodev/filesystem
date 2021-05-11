package com.equo.filesystem.api;

import java.util.Collection;
import java.util.Collections;

public class FileInfo {
	private boolean exists;
	private String path;
	private String name;
	private boolean canRead;
	private boolean canWrite;
	private boolean canExecute;
	private boolean isDirectory;
	private Collection<FileInfo> children;

	/**
	 * Creates the FileInfo instance.
	 * 
	 * @param exists if folder exists.
	 * @param path the path to folder.
	 * @param name the file name.
	 * @param canRead permission to read.
	 * @param canWrite permission to write.
	 * @param canExecute whether it can be executed.
	 * @param isDirectory whether this resource is a directory or not.
	 * @param children the children of this resource.
	 */
	public FileInfo(boolean exists, String path, String name, boolean canRead, boolean canWrite, boolean canExecute,
			boolean isDirectory, Collection<FileInfo> children) {
		this.exists = exists;
		this.path = path;
		this.name = name;
		this.canRead = canRead;
		this.canWrite = canWrite;
		this.canExecute = canExecute;
		this.isDirectory = isDirectory;
		if (children == null) {
			this.children = Collections.emptyList();
		} else {
			this.children = children;
		}
	}
	/**
	 * Returns whether the folder exists or not.
	 * @return whether the folder exists or not.
	 */
	public boolean exists() {
		return exists;
	}
	/**
	 * Gets the folder path.
	 * @return the folder path.
	 */
	public String getPath() {
		return path;
	}
	/**
	 * Gets the file name.
	 * @return the file name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns whether the folder has read permission.
	 * @return whether the folder has read permission.
	 */
	public boolean canRead() {
		return canRead;
	}
	/**
	 * Returns whether the folder has write permission.
	 * @return whether the folder has write permission.
	 */
	public boolean canWrite() {
		return canWrite;
	}
	/**
	 * Returns whether it can be executed or not.
	 * @return whether it can be executed or not.
	 */
	public boolean canExecute() {
		return canExecute;
	}
	/**
	 * Returns whether it can be executed.
	 * @return whether it can be executed.
	 */
	public boolean isDirectory() {
		return isDirectory;
	}

	/**
	 * Gets a non-recursive collection of childrens. To know the childrens of
	 *         your childrens, it will have to obtain a new FileInfo for them.
	 * @return A non-recursive collection of childrens.
	 */
	public Collection<FileInfo> getChildren() {
		return children;
	}
}
