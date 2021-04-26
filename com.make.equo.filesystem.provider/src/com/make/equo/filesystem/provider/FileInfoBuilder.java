package com.make.equo.filesystem.provider;

import java.util.Collection;

import com.make.equo.filesystem.api.FileInfo;

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
	 * 
	 * @param Set whether the folder exists.
	 */
	protected void setExists(boolean exists) {
		this.exists = exists;
	}
	/**
	 * 
	 * @param path Set path to folder.
	 */
	protected void setPath(String path) {
		this.path = path;
	}
	/**
	 * 
	 * @param name Set folder name.
	 */
	protected void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param canRead Set if it have read permission.
	 */
	protected void setCanRead(boolean canRead) {
		this.canRead = canRead;
	}
	/**
	 * 
	 * @param canWrite Set it have write permission.
	 */
	protected void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}
	/**
	 * 
	 * @param canExecute Set If it can executed.
	 */
	protected void setCanExecute(boolean canExecute) {
		this.canExecute = canExecute;
	}
	/**
	 * 
	 * @param isDirectory Set if it is a directory.
	 */
	protected void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	/**
	 * 
	 * @param children Set childrens.
	 */
	protected void setChildren(Collection<FileInfo> children) {
		this.children = children;
	}
	/**
	 * 
	 * @return Fileinfo instance created through FileInfoBuilder data.
	 */
	protected FileInfo build() {
		return new FileInfo(exists, path, name, canRead, canWrite, canExecute, isDirectory, children);
	}
}
