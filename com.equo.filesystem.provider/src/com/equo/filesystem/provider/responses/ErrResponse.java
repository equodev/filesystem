package com.equo.filesystem.provider.responses;

/**
 * Represents a container for the error response.
 */
public class ErrResponse {
  private int err = 1;

  /**
   * Gets the error from response.
   * @return the error from response.
   */
  public int getErr() {
    return err;
  }

  /**
   * Sets the error from response.
   * @param err the error from response.
   */
  public void setErr(int err) {
    this.err = err;
  }
}
