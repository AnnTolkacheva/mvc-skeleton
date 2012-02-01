package ru.hh.school.example.web;

public class RecommendationForm {

  private Long userId;
  private String userName;
  private String text;

  public RecommendationForm(Long userId, String userName, String text) {
    this.userId = userId;
    this.userName = userName;
    this.text = text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public String getUserName() {
    return userName;
  }

  public Long getUserId() {
    return userId;
  }
}
