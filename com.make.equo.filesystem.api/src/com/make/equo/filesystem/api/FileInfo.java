package com.make.equo.filesystem.api;

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
	 * Create FileInfo instance.
	 * 
	 * @param exists If folder exists.
	 * @param path Path to folder.
	 * @param name File name.
	 * @param canRead Permission to read.
	 * @param canWrite Permission to write.
	 * @param canExecute
	 * @param isDirectory 
	 * @param children
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
	 * 
	 * @return If folder exists.
	 */
	public boolean exists() {
		return exists;
	}
	/**
	 * 
	 * @return Path to file.
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 
	 * @return File name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return If it have read permission.
	 */
	public boolean canRead() {
		return canRead;
	}
	/**
	 * 
	 * @return If it have write permission.
	 */
	public boolean canWrite() {
		return canWrite;
	}
	/**
	 * 
	 * @return If it can executed.
	 */
	public boolean canExecute() {
		return canExecute;
	}
	/**
	 * 
	 * @return If it is a directory.
	 */
	public boolean isDirectory() {
		return isDirectory;
	}

	/**
	 * 
	 * @return A non-recursive collection of childrens. To know the childrens of
	 *         your childrens, you will have to obtain a new FileInfo for them
	 */
	public Collection<FileInfo> getChildren() {
		return children;
	}
}
