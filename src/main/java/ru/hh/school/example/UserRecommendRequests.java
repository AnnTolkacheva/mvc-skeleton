package ru.hh.school.example;

import java.util.HashMap;
import java.util.Map;

import ru.hh.school.example.ddd.Entity;

public class UserRecommendRequests extends Entity {

  private final Long userId;
  private final Map<Long, Long> recommendationToUserIds;
  private final Map<Long, Long> recommendationOfUserIds;

  public UserRecommendRequests(Long userId) {
    this.userId = userId;
    this.recommendationToUserIds = new HashMap<Long, Long>();
    this.recommendationOfUserIds = new HashMap<Long, Long>();
  }

  public Long setRecommendationIdToUser(Long recommendatorId, Long recommendationId) {
    recommendationToUserIds.put(recommendatorId, recommendationId);
    return recommendationId;
  }

  public Long setRecommendationIdOfUser(Long recommendatorId, Long recommendationId) {
    recommendationOfUserIds.put(recommendatorId, recommendationId);
    return recommendationId;
  }

  public Long getRecommendationIdToUser(Long recommendatorId) {    
    return recommendationToUserIds.get(recommendatorId);
  }

  public Long getRecommendationIdOfUser(Long recommendatorId) {
    return recommendationOfUserIds.get(recommendatorId);
  }

  public Iterable<Long> getAllRecommendationIdsToUser() {    
    return recommendationToUserIds.values();
  }

  public Iterable<Long> getAllRecommendationIdsOfUser() {
    return recommendationOfUserIds.values();
  }

  public Long getUserId() {
    return userId;
  }

  public Boolean existRecommendRequestOfUser(Long recommendatorId) {
    return recommendationOfUserIds.containsKey(recommendatorId);
  }

  public Boolean existRecommendRequestToUser(Long recommendatorId) {
    return recommendationToUserIds.containsKey(recommendatorId);
  }
  
  public Boolean canWrite(Long recommendationId) {
    return recommendationOfUserIds.containsValue(recommendationId);
  }
}
