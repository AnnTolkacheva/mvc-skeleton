package ru.hh.school.example;

import ru.hh.school.example.ddd.Entity;

public class Recommendation extends Entity {
  
//  private final Long userId;
//  private final String userName;
  private final String text;

  public Recommendation(String text) { //Long userId, String userName) {
//    this.userId = userId;
//    this.userName = userName;
    this.text = text;
  }

 /* public void setText(String text) {
    this.text = text;
  }*/

  public String getText() {
    return text;
  }
  
 /* public String getUserName() {
    return userName;
  }
  
  public Long getUserId() {
    return userId;
  }*/
}
