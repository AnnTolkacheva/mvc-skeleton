package ru.hh.school.example;

import ru.hh.school.example.ddd.Repository;

public interface UserRecommendRequestsRepository extends Repository<UserRecommendRequests> {
  public UserRecommendRequests byUserId(Long userId);
  public Boolean containUser(Long userId);
}
