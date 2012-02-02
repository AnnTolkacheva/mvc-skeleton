package ru.hh.school.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommendationService {

  private final RecommendationRepository recommendations;
  private final UserRecommendRequestsRepository userRecommendRequests;

  @Autowired
  public RecommendationService(RecommendationRepository recommendations,
          UserRecommendRequestsRepository userRecommendRequests) {
    this.recommendations = recommendations;
    this.userRecommendRequests = userRecommendRequests;
  }

  public void setRecommendRequest(User recommendator, User user) {
    UserRecommendRequests uRR;
    if (!userRecommendRequests.containUser(user.getId()))
      userRecommendRequests.put(new UserRecommendRequests(user.getId()));
    if (!userRecommendRequests.containUser(recommendator.getId()))
      userRecommendRequests.put(new UserRecommendRequests(recommendator.getId()));
    uRR = userRecommendRequests.byUserId(user.getId());
    if (!uRR.existRecommendRequestToUser(recommendator.getId())) {
      Recommendation recommendation = new Recommendation(recommendator.getFullName(),
          user.getFullName());
      recommendations.put(recommendation);
      Long recommendationId = recommendation.getId();      
      uRR.setRecommendationIdToUser(recommendator.getId(), recommendationId);
      uRR = userRecommendRequests.byUserId(recommendator.getId());
      uRR.setRecommendationIdOfUser(user.getId(), recommendationId);
    }
  }

  public Iterable<Recommendation> getAllRecommendationsToUser(Long userId) {
    List<Recommendation> recommendations = new ArrayList<Recommendation>();
    if (userRecommendRequests.containUser(userId)) {
      for (Long recommendationId : userRecommendRequests.byUserId(userId).
          getAllRecommendationIdsToUser())
        recommendations.add(this.recommendations.byId(recommendationId));
      return recommendations;
    }
    return recommendations;
  }

  public Iterable<Recommendation> getAllRecommendationsOfUser(Long userId) {
    List<Recommendation> recommendations = new ArrayList<Recommendation>();
    if (userRecommendRequests.containUser(userId)) {
      for (Long recommendationId : userRecommendRequests.byUserId(userId).getAllRecommendationIdsOfUser())
        recommendations.add(this.recommendations.byId(recommendationId));
      return recommendations;
    }
    return recommendations;
  }

  public void setRecommendationText(Long recommendationId, String text) {
    Recommendation recommendation = recommendations.byId(recommendationId);
    recommendation.setText(text);
  }

  public String getRecommendationText(Long recommendationId) {
    Recommendation recommendation = recommendations.byId(recommendationId);
    String text = recommendation.getText();
    return text;
  }

  public Recommendation getRecommendation(Long recommendationId) {
        return recommendations.byId(recommendationId);
  }

  public Recommendation getRecommendationSequred(Long recommendatorId, Long recommendationId) 
      throws NoSuchElementException {
    if(userRecommendRequests.byUserId(recommendatorId).canWrite(recommendationId))
        return recommendations.byId(recommendationId);
    else 
      throw new NoSuchElementException();
  }
}
