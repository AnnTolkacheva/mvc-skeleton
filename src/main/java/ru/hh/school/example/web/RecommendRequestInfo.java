package ru.hh.school.example.web;

import ru.hh.school.example.Recommendation;

public class RecommendRequestInfo {
  private final Long recommendationId;
  private final String recommendatorName;
  private final String userName;
  private final boolean isWritten;
//  private final String text;

  public RecommendRequestInfo(Recommendation recommendation) {
    this.recommendationId = recommendation.getId();
    this.recommendatorName = recommendation.getRecommendatorName();
    this.userName = recommendation.getUserName();
    if (recommendation.getText() != null)
      isWritten = true;
    else
      isWritten = false;
  }

/*  public RecommendationInfo(Long id, String name, String text) {
    if (text == null) {
      isWritten = false;
    } else {
      isWritten = true;
    }
    userId = id;
    userName = name;
    this.text = text;
  }
*/
  public String getUserName() {
    return userName;
  }

  public String getRecommendatorName() {
    return recommendatorName;
  }

  public Long getRecommendationId() {
    return recommendationId;
  }

  public boolean getIsWritten() {
    return isWritten;
  }
  
 /* public String getText() {
    return text;
  }*/
}
