package com.make.equo.filesystem.api;

import java.io.File;

/**
 * Defines operations for folder.
 *
 */

public interface IEquoFileSystem {

	/**
	 * @return The file selected. Null if it's canceled
	 */
	public File openFile();

	/**
	 * @return The folder selected. Null if it's canceled
	 */
	public File openFolder();

	/**
	 * @param file
	 * @return Information from file.
	 */
	public FileInfo fileInfo(File file);

	/**
	 * @param folder Folder to creates the directory.
	 * @return If folder was created.
	 */
	public boolean newFolder(File folder);

	/**
	 * @param file File to save.
	 * @param content Content to save.
	 * @return If file was saved.
	 */
	public boolean saveFile(File file, String content);

	/**
	 * @param content File content.
	 * @return The file that was selected and saved. Null if it's canceled or there
	 *         was an error.
	 */
	public File saveFileAs(String content);

	/**
	 * @param file File to read.
	 * @return The content of the file. Null if there was an error.
	 */
	public String readFile(File file);

	/**
	 * @param file File to rename
	 * @param newName New name for file.
	 * @return The absolute path of the renamed file. Null if there was an error.
	 */
	public String renameFile(File file, String newName);

	/**
	 * @param file File to delete.
	 * @return If file was deleted.
	 */
	public boolean deleteFile(File file);

	/**
	 * @param file File to move.
	 * @param folderDest Destination folder.
	 * @return The absolute path of the moved file. Null if there was an error.
	 */
	public String moveFile(File file, File folderDest);

	/**
	 * @param file File to copy.
	 * @param folderDest Destination folder.
	 * @return The absolute path of the copied file. Null if there was an error.
	 */
	public String copyFile(File file, File folderDest);
}
