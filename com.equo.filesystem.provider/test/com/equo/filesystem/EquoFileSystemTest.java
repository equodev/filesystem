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

package com.equo.filesystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.equo.filesystem.api.FileInfo;
import com.equo.filesystem.api.IEquoFileSystem;
import com.equo.filesystem.provider.EquoFileSystemImpl;

/**
 * 
 * @hidden
 *
 */
public class EquoFileSystemTest {
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	IEquoFileSystem equoFileSystem = new EquoFileSystemImpl();

	private static final String FOLDER1 = "folder1";
	private static final String FILE1 = "file1";
	private static final String FILE2 = "file2";

	private File folder1;

	@Before
	public void fillFolder() {
		File tmpFolder = folder.getRoot();
		folder1 = new File(tmpFolder, FOLDER1);
		equoFileSystem.newFolder(folder1);
		equoFileSystem.saveFile(new File(folder1, "someFile"), "");
		equoFileSystem.saveFile(new File(tmpFolder, FILE1), "");
		equoFileSystem.saveFile(new File(tmpFolder, FILE2), "");
	}

	@Test
	public void writeReadTest() throws IOException {
		File createdFile = folder.newFile("myfile.txt");
		String content = "Some test content";
		equoFileSystem.saveFile(createdFile, content);
		assertThat(equoFileSystem.readFile(createdFile)).isEqualTo(content);
	}

	@Test
	public void moveFileTest() throws IOException {
		String nameOfFile = "myfiletomove.txt";
		File createdFile = folder.newFile(nameOfFile);
		String content = "Content of moved file";
		equoFileSystem.saveFile(createdFile, content);

		equoFileSystem.moveFile(createdFile, folder1);

		File movedFile = new File(folder1, nameOfFile);
		assertTrue(!equoFileSystem.fileInfo(createdFile).exists());
		assertTrue(equoFileSystem.fileInfo(movedFile).exists());
		assertThat(equoFileSystem.readFile(movedFile)).isEqualTo(content);
	}

	@Test
	public void renameFileTest() throws IOException {
		String oldName = "myfiletorename.txt";
		File createdFile = folder.newFile(oldName);
		String content = "Content of renamed file";
		equoFileSystem.saveFile(createdFile, content);

		String newName = "renamedfile.txt";
		equoFileSystem.renameFile(createdFile, newName);

		File renamedFile = new File(folder.getRoot(), newName);
		assertTrue(!equoFileSystem.fileInfo(createdFile).exists());
		assertTrue(equoFileSystem.fileInfo(renamedFile).exists());
		assertThat(equoFileSystem.readFile(renamedFile)).isEqualTo(content);
	}

	@Test
	public void fileInfoOfFolder() throws IOException {
		FileInfo info = equoFileSystem.fileInfo(folder.getRoot());
		assertTrue(info.exists());
		assertTrue(info.isDirectory());

		boolean isFolder1 = false;
		boolean isFile1 = false;
		boolean isFile2 = false;

		for (FileInfo children : info.getChildren()) {
			assertThat(children.getChildren()).isEmpty();
			if (children.getName().equals(FOLDER1)) {
				assertTrue(children.isDirectory());
				isFolder1 = true;
			} else {
				assertTrue(!children.isDirectory());
				if (children.getName().equals(FILE1))
					isFile1 = true;
				if (children.getName().equals(FILE2))
					isFile2 = true;
			}
		}
		assertTrue(isFolder1 && isFile1 && isFile2);
	}
}
