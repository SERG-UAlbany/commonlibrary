/*
 * CFileElement.java
 * Created on 2010/02/12 by macchan
 * Copyright(c) 2010 Yoshiaki Matsuzawa, Shizuoka University
 */
package clib.common.filesystem;

import java.io.File;
import java.net.URI;

import clib.common.time.CTime;

/**
 * CFileElement
 */
public abstract class CFileElement {

	private File javaFile;

	protected CFileElement(CPath path) {
		this(new File(path.toString()));
	}

	protected CFileElement(File javaFile) {
		if (!javaFile.exists()) {
			throw new RuntimeException("File Not Found: "
					+ javaFile.getPath().toString());
		}
		this.javaFile = javaFile;
	}

	protected File getJavaFile() {
		return this.javaFile;
	}

	public boolean exists() {
		if (javaFile == null) {
			return false;
		}
		return this.javaFile.exists();
	}

	/**
	 * @return
	 */
	public boolean deleted() {
		return !exists();
	}

	/**
	 * @return
	 */
	public CFilename getName() {
		return getAbsolutePath().getName();
	}

	/**
	 * @return
	 */
	public String getNameByString() {
		return getName().toString();
	}

	/**
	 * @return
	 */
	public CTime getLastModifiedTime() {
		return new CTime(getLastModified());
	}

	/**
	 * @return
	 */
	public long getLastModified() {
		return this.javaFile.lastModified();
	}

	/**
	 * @return
	 */
	public CPath getAbsolutePath() {
		return new CPath(javaFile.getAbsolutePath());
	}

	/**
	 * @param baseDirectory
	 * @return
	 */
	public CPath getRelativePath(CDirectory baseDirectory) {
		return this.getAbsolutePath().getRelativePath(
				baseDirectory.getAbsolutePath());
	}

	/**
	 * @return
	 */
	public CPath getRelativePathFromExecuteDirectory() {
		return getRelativePath(CFileSystem.getExecuteDirectory());
	}

	public CDirectory getParentDirectory() {
		return new CDirectory(new CPath(this.javaFile.getParentFile()
				.getAbsolutePath()));
	}

	public boolean deleteWithMessage() {
		return delete(true);
	}

	public boolean delete() {
		return delete(false);
	}

	protected boolean delete(boolean message) {
		boolean result = this.javaFile.delete();
		if (message) {
			if (result) {
				System.out.println(this.getAbsolutePath()
						+ " has been deleted!");
			} else {
				System.err.println(this.getAbsolutePath()
						+ " could not delete!");
			}
		}
		return result;
	}

	public URI getURI() {
		return this.javaFile.toURI();
	}

	public File toJavaFile() {
		return getJavaFile();
	}

	abstract public boolean isFile();

	abstract public boolean isDirectory();

	@Override
	public boolean equals(Object another) {
		if (another == null) {
			return false;
		}

		if (!(another instanceof CFileElement)) {
			return false;
		}

		return ((CFileElement) another).getAbsolutePath().equals(
				this.getAbsolutePath());
	}

	@Override
	public int hashCode() {
		return getAbsolutePath().hashCode();
	}

	public boolean renameTo(String name) {
		return getJavaFile().renameTo(
				getParentDirectory().getAbsolutePath().appendedPath(name)
						.toJavaFile());
	}

	public CFileElement copyTo(CFilename name) {
		return copyTo(name.toString());
	}

	public CFileElement copyTo(String name) {
		return copyTo(getParentDirectory(), name);
	}

	public CFileElement copyTo(CDirectory toDir) {
		if (toDir.equals(getParentDirectory())) {
			throw new IllegalArgumentException("Same directory!");
		}
		return copyTo(toDir, getName().toString());
	}

	public CFileElement copyTo(CDirectory toDir, CFilename name) {
		return copyTo(toDir, name.toString());
	}

	public CFileElement copyTo(CDirectory toDir, String name) {
		return copyTo(toDir, new CPath(name));
	}

	public abstract CFileElement copyTo(CDirectory toDir, CPath path);

	public String toString() {
		return this.getNameByString();
	}

}
