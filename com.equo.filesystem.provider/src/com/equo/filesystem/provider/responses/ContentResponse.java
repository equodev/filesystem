package com.equo.filesystem.provider.responses;

/**
 * Represents a container for the content response.
 */
public class ContentResponse {
  private String content;

  /**
   * Creates empty ContentResponse instance.
   */
  public ContentResponse() {
  }

  /**
   * Creates ContentResponse instance with content.
   * @param content the content from response.
   */
  public ContentResponse(String content) {
    this.content = content;
  }

  /**
   * Gets the content from a response.
   * @return the content from response.
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets the content from a response.
   * @param content the content from response.
   */
  public void setContent(String content) {
    this.content = content;
  }
}
