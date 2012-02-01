package ru.hh.school.example.web;

public class RecommendationInfo {
  private final Long userId;
  private final String userName;
  private final boolean isWritten;
  private final String text;

  public RecommendationInfo(Long id, String name, String text) {
    if (text == null) {
      isWritten = false;
    } else {
      isWritten = true;
    }
    userId = id;
    userName = name;
    this.text = text;
  }

  public String getUserName() {
    return userName;
  }

  public Long getUserId() {
    return userId;
  }

  public boolean getIsWritten() {
    return isWritten;
  }
  
  public String getText() {
    return text;
  }
}
