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

window.equo = window.equo || {};

function sendFileSystemCommand(callback, commandId, filePath = null, content = null) {
    let responseId = (Math.random() + 1).toString(36).substring(7);
    equo.on(responseId, callback);
    equo.sendToCommServer(commandId, {
        commandId: commandId + ".command",
        responseId: responseId,
        filePath: filePath,
        content: content
    });
};

/**
 * @namespace
 * @description Equo-FileSystem is a link:./../../developing/equo-contributions.html[Equo Contribution] that allows the basic handling of files from Javascript.
 */
 export var equo;
(function (equo) {

    /**
     * Saves content into the given file.
     * @function
     * @name equo.saveFile
     * @param {string} filePath path of the file to be saved
     * @param {string} content content to save
     * @param {Function} callback function to be called once the operation is completed
     * @returns {void}
     */
     equo.saveFile = function (filePath, content, callback) {
        sendFileSystemCommand(callback, "_SaveFile", filePath, content);
    };

    /**
     * Prompts a dialog to select where to save the file
     * @function
     * @name equo.saveFileAs
     * @param {string} content content to save
     * @param {Function} callback function to be called once the operation is completed
     * @returns {void}
     */
    equo.saveFileAs = function (content, callback) {
        sendFileSystemCommand(callback, "_SaveFileAs", null, content);
    };

    /**
     * Creates a new folder.
     * @function
     * @name equo.newFolder
     * @param {string} path path of the folder to be created
     * @param {Function} callback function to be called once the operation is completed
     * @returns {void}
     */
    equo.newFolder = function (path, callback) {
        sendFileSystemCommand(callback, "_NewFolder", path);
    };

    /**
     * Renames the file.
     * @function
     * @name equo.renameFile
     * @param {string} filePath path to actual file
     * @param {string} newName new file name
     * @param {Function} callback function to be called once the operation is completed
     * @returns {void}
     */
    equo.renameFile = function (filePath, newName, callback) {
        sendFileSystemCommand(callback, "_RenameFile", filePath, newName);
    };

    /**
     * Moves the file into a new destination.
     * @function
     * @name equo.moveFile
     * @param {string} filePath path to actual file
     * @param {string} directoryDest folder to move it to
     * @param {Function} callback function to be called once the operation is completed
     * @returns {void}
     */
    equo.moveFile = function (filePath, directoryDest, callback) {
        sendFileSystemCommand(callback, "_MoveFile", filePath, directoryDest);
    };

    /**
     * Copies the file into a new destination.
     * @function
     * @name equo.copyFile
     * @param {string} filePath path to actual file
     * @param {string} directoryDest folder to copy it to
     * @param {Function} callback function to be called once the operation is completed
     * @returns {void}
     */
    equo.copyFile = function (filePath, directoryDest, callback) {
        sendFileSystemCommand(callback, "_CopyFile", filePath, directoryDest);
    };

    /**
     * Prompts a dialog to open a file.
     * @function
     * @name equo.openFile
     * @param {Function} callback function to be called with the path of the chosen file passed as parameter
     * @returns {void}
     */
    equo.openFile = function (callback) {
        sendFileSystemCommand(callback, "_OpenFile");
    };

    /**
     * Reads the file content.
     * @function 
     * @name equo.readFile
     * @param {string} filePath path to file to be readed
     * @param {Function} callback function to be called with the file content passed as parameter
     * @returns {void}
     */
    equo.readFile = function (filePath, callback) {
        sendFileSystemCommand(callback, "_ReadFile", filePath);
    };

    /**
     * Deletes the file.
     * @function
     * @name equo.deleteFile
     * @param {string} filePath path to file to be deleted
     * @param {Function} callback function to be called once the operation is completed
     * @returns {void}
     */
    equo.deleteFile = function (filePath, callback) {
        sendFileSystemCommand(callback, "_DeleteFile", filePath);
    };

    /**
     * Gets info about a file or folder, such as what children it has, read and write permissions, etc.
     * @function
     * @name equo.fileInfo
     * @param {string} filePath path to the file from which information is to be retrieved
     * @param {Function} callback function to be called with the file info passed as parameter
     * @returns {void}
     */
    equo.fileInfo = function (filePath, callback) {
        sendFileSystemCommand(callback, "_FileInfo", filePath);
    };

    /**
     * Prompts a dialog to open a folder
     * @function
     * @name equo.openFolder
     * @param {Function} callback function to be called with the path of the chosen folder passed as parameter
     * @returns {void}
     */
    equo.openFolder = function (callback) {
        sendFileSystemCommand(callback, "_OpenFolder");
    };

}(equo));
