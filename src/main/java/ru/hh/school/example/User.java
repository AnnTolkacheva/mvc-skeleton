package ru.hh.school.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.hh.school.example.ddd.Entity;
import ru.hh.school.example.web.UserInfo;

public class User extends Entity {

  private String email;
  private String password;
  private String fullName;
  private Resume resume;
  private Map<Long, Recommendation> recommendationsIn;
  private Map<Long, Recommendation> recommendationsOut;

  public User(String email, String password, String fullName) {
    this.email = email;
    this.password = password;
    this.fullName = fullName;
    recommendationsIn = new HashMap<Long, Recommendation>();
    recommendationsOut = new HashMap<Long, Recommendation>();
  }
  
  public void setResume(Resume resume) {
    this.resume = resume;
  }
  
  public Resume getResume() {
    return resume;
  }

  public void changeResume(Resume resume) {
    if (this.resume == null) {
      this.resume = resume;
    } else {
      this.resume.change(resume);
    }
  }
  
  public void setRecommendationIn(Long userId, Recommendation recommendation) {
    this.recommendationsIn.put(userId, recommendation);
  }

  public Recommendation getRecommendationIn(Long userId) {
    return recommendationsIn.get(userId);
  }

  public void changeRecommendationIn(Long userId, String text) {
    if (recommendationsIn.containsKey(userId)) {
      Recommendation recommendation = recommendationsIn.remove(userId);
      recommendation.setText(text);
      recommendationsIn.put(userId, recommendation);
    } 
  }

  public Iterable<Recommendation> getAllRecommendationsIn() {
    return recommendationsIn.values();
  }

  public void setRecommendationInRequest(Long userId, String userName) {
    if (!recommendationsIn.containsKey(userId)) {
      Recommendation recommendation = new Recommendation(userId, userName);
      recommendationsIn.put(userId, recommendation);
    }
  }

  public void setRecommendationOutRequest(Long userId, String userName) {
    if (!recommendationsOut.containsKey(userId)) {
      Recommendation recommendation = new Recommendation(userId, userName);
      recommendationsOut.put(userId, recommendation);
    }
  }

  public void changeRecommendationsOut(Long userId, String text) {
    if (recommendationsOut.containsKey(userId)) {
      Recommendation recommendRequest = recommendationsOut.remove(userId);
      recommendRequest.setText(text);
      recommendationsOut.put(userId, recommendRequest);
    } 
  }

  public Iterable<Recommendation> getAllRecommendationsOut () {//Requests() {
    return recommendationsOut.values();
  }


  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getFullName() {
    return fullName;
  }
}
