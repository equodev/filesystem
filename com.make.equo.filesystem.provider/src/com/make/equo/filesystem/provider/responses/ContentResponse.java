package com.make.equo.filesystem.provider.responses;

/**
 * 
 * Represents a container for the content response.
 *
 */
public class ContentResponse {
	private String content;
	/**
	 * Create empty ContentResponse instance.
	 */
	public ContentResponse() {
	}
	/**
	 * 
	 * @param content Create ContentResponse instance with content.
	 */
	public ContentResponse(String content) {
		this.content = content;
	}
	/**
	 * 
	 * @return content from response.
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 
	 * @param content Set content from response.
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
