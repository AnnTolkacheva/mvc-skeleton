package ru.hh.school.example;

import ru.hh.school.example.ddd.Entity;

public class Recommendation extends Entity {
  
//  sprivate final Long userId;
  private final String recommendatorName;
  private final String userName;
  private String text;

  public Recommendation(String recomendatorName, String userName) { //Long userId, String userName) {
//    this.userId = userId;
    this.userName = userName;
    this.recommendatorName = recomendatorName;
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

  public String getRecommendatorName() {
    return recommendatorName;
  }
}
