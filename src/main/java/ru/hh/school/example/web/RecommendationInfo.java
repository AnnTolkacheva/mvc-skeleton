package ru.hh.school.example.web;

import ru.hh.school.example.Recommendation;

public class RecommendationInfo {

  private final String recommendatorName;
  private final String userName;
  private final String text;
  
  public RecommendationInfo(Recommendation recommendation) {
    this.recommendatorName = recommendation.getRecommendatorName();
    this.userName = recommendation.getUserName();
    this.text = recommendation.getText();
  }

  public String getText() {
    return text;
  }

  public String getRecommendatorName() {
    return recommendatorName;
  }


  public String getUserName() {
    return userName;
  }
}
