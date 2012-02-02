package ru.hh.school.example.impl;

import ru.hh.school.example.UserRecommendRequests;
import ru.hh.school.example.UserRecommendRequestsRepository;
import org.springframework.stereotype.Component;


@Component
public class MemUserRecommendRequestsRepository extends MemRepository<UserRecommendRequests>
    implements UserRecommendRequestsRepository {

  public UserRecommendRequests byUserId(Long userId) {
    for (UserRecommendRequests uRR : all())
      if (uRR.getUserId() == userId)
        return uRR;
    return null;
  }

  public Boolean containUser(Long userId) {
    for (UserRecommendRequests uRR : all())
      if (uRR.getUserId() == userId)
        return true;
    return false;
  }

}
