package com.make.equo.filesystem.provider.responses;

/**
 * 
 * Represents a container for the error response.
 *
 */
public class ErrResponse {
	private int err = 1;
	/**
	 * 
	 * @return Error from response.
	 */
	public int getErr() {
		return err;
	}
	/**
	 * 
	 * @param err Set error from response.
	 */
	public void setErr(int err) {
		this.err = err;
	}
}
