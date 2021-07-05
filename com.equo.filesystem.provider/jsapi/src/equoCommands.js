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

(function (equo) {

    /**
     * @Function "equo.saveFile"
     * @param filePath path of the file to be saved
     * @param content content to save
     * @param callback function to be called once the operation has completed
     */
    equo.saveFile = function (filePath, content, callback) {
        sendFileSystemCommand(callback, "_SaveFile", filePath, content);
    };

    /**
     * @Function "equo.saveFileAs"
     * @description prompts a dialog to select where to save the file
     * @param content content to save
     * @param callback function to be called once the operation has completed
     */
    equo.saveFileAs = function (content, callback) {
        sendFileSystemCommand(callback, "_SaveFileAs", null, content);
    };

    /**
     * @Function "equo.newFolder"
     * @param path path of the folder to be created
     * @param callback function to be called once the operation has completed
     */
    equo.newFolder = function (path, callback) {
        sendFileSystemCommand(callback, "_NewFolder", path);
    };

    /**
     * @Function "equo.renameFile"
     * @param filePath path to actual file
     * @param newName new file name
     * @param callback function to be called once the operation has completed
     */
    equo.renameFile = function (filePath, newName, callback) {
        sendFileSystemCommand(callback, "_RenameFile", filePath, newName);
    };

    /**
     * @Function "equo.moveFile"
     * @param filePath path to actual file
     * @param directoryDest folder to move it to
     * @param callback function to be called once the operation has completed
     */
    equo.moveFile = function (filePath, directoryDest, callback) {
        sendFileSystemCommand(callback, "_MoveFile", filePath, directoryDest);
    };

    /**
     * @Function "equo.copyFile"
     * @param filePath path to actual file
     * @param directoryDest folder to copy it to
     * @param callback function to be called once the operation has completed
     */
    equo.copyFile = function (filePath, directoryDest, callback) {
        sendFileSystemCommand(callback, "_CopyFile", filePath, directoryDest);
    };

    /**
     * @Function "equo.openFile"
     * @description prompts a dialog to open a file
     * @param callback function to be called with the path of the chosen file passed as parameter
     */
    equo.openFile = function (callback) {
        sendFileSystemCommand(callback, "_OpenFile");
    };

    /**
     * @Function "equo.readFile"
     * @param filePath path to file to be readed
     * @param callback function to be called with the file content passed as parameter
     */
    equo.readFile = function (filePath, callback) {
        sendFileSystemCommand(callback, "_ReadFile", filePath);
    };

    /**
     * @Function "equo.deleteFile"
     * 
     * @param filePath path to file to be deleted
     * @param callback function to be called once the operation has completed
     */
    equo.deleteFile = function (filePath, callback) {
        sendFileSystemCommand(callback, "_DeleteFile", filePath);
    };

    /**
     * @Function "equo.fileInfo"
     * @description gets info about a file or folder, such as what children it has, read and write permissions, etc.
     * @param filePath path to the file from which information is to be retrieved
     * @param callback function to be called with the file info passed as parameter
     */
    equo.fileInfo = function (filePath, callback) {
        sendFileSystemCommand(callback, "_FileInfo", filePath);
    };

    /**
     * @Function "equo.openFolder"
     * @description prompts a dialog to open a folder
     * @param callback function to be called with the path of the chosen folder passed as parameter
     */
    equo.openFolder = function (callback) {
        sendFileSystemCommand(callback, "_OpenFolder");
    };

}(equo));
