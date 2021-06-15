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

package com.equo.filesystem.api;

import java.io.File;

/**
 * Defines operations for folder.
 */

public interface IEquoFileSystem {

  /**
   * Prompts a dialog to open a file.
   * @return the selected file. Null if it's canceled.
   */
  public File openFile();

  /**
   * Prompts a dialog to open a folder.
   * @return the selected folder. Null if it's canceled.
   */
  public File openFolder();

  /**
   * Gets file details.
   * @param  file file to get info from
   * @return      the information from file.
   */
  public FileInfo fileInfo(File file);

  /**
   * Creates a new folder.
   * @param  folder the folder to be created.
   * @return        true if the folder was created, false otherwise.
   */
  public boolean newFolder(File folder);

  /**
   * Saves content into the given file.
   * @param  file    the file where to save content.
   * @param  content the content to save.
   * @return         true if the file was saved, false otherwise.
   */
  public boolean saveFile(File file, String content);

  /**
   * Prompts a dialog to select where to save the file.
   * @param  content the content to be saved in the selected file.
   * @return         the file that was selected and saved. Null if it's canceled
   *                 or there was an error.
   */
  public File saveFileAs(String content);

  /**
   * Reads the file content.
   * @param  file the file to be readed.
   * @return      the content of the file. Null if there was an error.
   */
  public String readFile(File file);

  /**
   * Renames the file.
   * @param  file    the file to be renamed.
   * @param  newName the new file name.
   * @return         the absolute path of the renamed file. Null if there was an
   *                 error.
   */
  public String renameFile(File file, String newName);

  /**
   * Deletes the file.
   * @param  file the file to be deleted.
   * @return      true if the file was deleted, false otherwise.
   */
  public boolean deleteFile(File file);

  /**
   * Moves the file to a new destination.
   * @param  file       the file to be moved.
   * @param  folderDest the destination folder.
   * @return            the absolute path of the moved file. Null if there was an
   *                    error.
   */
  public String moveFile(File file, File folderDest);

  /**
   * Copies the file to a new destination.
   * @param  file       the file to be copied.
   * @param  folderDest the destination folder.
   * @return            the absolute path of the copied file. Null if there was an
   *                    error.
   */
  public String copyFile(File file, File folderDest);
}
