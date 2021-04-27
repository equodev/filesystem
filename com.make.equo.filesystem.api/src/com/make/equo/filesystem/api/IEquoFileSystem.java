package com.make.equo.filesystem.api;

import java.io.File;

/**
 * Defines operations for folder.
 *
 */

public interface IEquoFileSystem {

	/**
	 * Opens the selected file.
	 * @return the selected file. Null if it's canceled.
	 */
	public File openFile();

	/**
	 * Opens the selected folder.
	 * @return the selected folder. Null if it's canceled.
	 */
	public File openFolder();

	/**
	 * Gets the information from file.
	 * @param file
	 * @return the information from file.
	 */
	public FileInfo fileInfo(File file);

	/**
	 * Creates a new folder.
	 * @param folder the folder to creates the directory.
	 * @return if the folder was created.
	 */
	public boolean newFolder(File folder);

	/**
	 * Saves the file.
	 * @param file the file to save.
	 * @param content the content to save.
	 * @return if the file was saved.
	 */
	public boolean saveFile(File file, String content);

	/**
	 * Saves the file with custom folder path.
	 * @param content the file content.
	 * @return the file that was selected and saved. Null if it's canceled or there
	 *         was an error.
	 */
	public File saveFileAs(String content);

	/**
	 * Reads the file.
	 * @param file the file to read.
	 * @return the content of the file. Null if there was an error.
	 */
	public String readFile(File file);

	/**
	 * Renames the file.
	 * @param file the file to rename.
	 * @param newName the new name for file.
	 * @return the absolute path of the renamed file. Null if there was an error.
	 */
	public String renameFile(File file, String newName);

	/**
	 * Deletes the file.
	 * @param file the file to delete.
	 * @return if file was deleted.
	 */
	public boolean deleteFile(File file);

	/**
	 * Moves the file to new destination.
	 * @param file the file to move.
	 * @param folderDest the destination folder.
	 * @return the absolute path of the moved file. Null if there was an error.
	 */
	public String moveFile(File file, File folderDest);

	/**
	 * Copies the file to new destination.
	 * @param file the file to copy.
	 * @param folderDest the destination folder.
	 * @return the absolute path of the copied file. Null if there was an error.
	 */
	public String copyFile(File file, File folderDest);
}
