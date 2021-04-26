package com.make.equo.filesystem.provider.responses;

/**
 * 
 * Represents a container for the ok response.
 *
 */
public class OkResponse {
	private String ok = "ok";
	/**
	 * 
	 * @return ok message from response.
	 */
	public String getOk() {
		return ok;
	}
	/**
	 * 
	 * @param ok Set ok message from response.
	 */
	public void setOk(String ok) {
		this.ok = ok;
	}
}
