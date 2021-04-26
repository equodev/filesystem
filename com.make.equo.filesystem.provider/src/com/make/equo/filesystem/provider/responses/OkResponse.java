package com.make.equo.filesystem.provider.responses;

/**
 * 
 * Represents a container for the ok response.
 *
 */
public class OkResponse {
	private String ok = "ok";
	/**
	 * Gets the ok message from response.
	 * @return the ok message from response.
	 */
	public String getOk() {
		return ok;
	}
	/**
	 * Sets the ok message from response.
	 * @param ok the ok message from response.
	 */
	public void setOk(String ok) {
		this.ok = ok;
	}
}
