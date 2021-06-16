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
