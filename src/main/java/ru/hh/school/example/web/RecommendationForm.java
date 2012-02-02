package ru.hh.school.example.web;

import ru.hh.school.example.Recommendation;

public class RecommendationForm {

  private Long id;
  private String recommendatorName;
  private String userName;
  private String text;

  public RecommendationForm() {
  }

  public RecommendationForm(Recommendation recommendation) {
    this.id = recommendation.getId();
    this.recommendatorName = recommendation.getRecommendatorName();
    this.userName = recommendation.getUserName();
    this.text = recommendation.getText();
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setRecommendatorName(String recommendatorName) {
    this.recommendatorName = recommendatorName;
  }

  public String getRecommendatorName() {
    return recommendatorName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
