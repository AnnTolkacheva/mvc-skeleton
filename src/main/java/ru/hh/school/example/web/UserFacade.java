package ru.hh.school.example.web;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.hh.school.example.*;

@Component
public class UserFacade {

  private final UserRepository users;
  private final UserService userService;
  private final RecommendationService recommendationService;

  @Autowired
  public UserFacade(UserRepository users, UserService userService,
      RecommendationService recommendationService) {
    this.users = users;
    this.userService = userService;
    this.recommendationService = recommendationService;
  }

  public Iterable<UserInfo> listUsers() {
    List<UserInfo> users = new ArrayList<UserInfo>();
    for (User user : this.users.all())
      users.add(new UserInfo(user));
    return users;
  }

  public String userNameById(Long userId) {
      return userService.userById(userId).getFullName();
    }

  public Iterable<RecommendRequestInfo> allRecommendRequestsOfUser(Long userId) {
    List<RecommendRequestInfo> recommendInfo = new ArrayList<RecommendRequestInfo>();
    for (Recommendation recommendation : recommendationService.getAllRecommendationsOfUser(userId)) {
      recommendInfo.add(new RecommendRequestInfo(recommendation));
    }
	  return recommendInfo;
	}

  public Iterable<RecommendRequestInfo> allRecommendRequestsToUser(Long userId) {
    List<RecommendRequestInfo> recommendInfo = new ArrayList<RecommendRequestInfo>();
    for (Recommendation recommendation : recommendationService.getAllRecommendationsToUser(userId)) {
      recommendInfo.add(new RecommendRequestInfo(recommendation));
    }
    return recommendInfo;
  }

  public void setRecommendationRequest(Long recommendatorId, Long userId) {
    recommendationService.setRecommendRequest(userService.userById(userId),
        userService.userById(recommendatorId));
  }

 /* public void setRecommendatorRequest(Long userId, Long recommendatorId) {
    userService.setRecommendatorRequest(userId, recommendatorId);
  }*/

  public Long registerUser(String email, String password, String fullName)
          throws EmailAlreadyBoundException, EmailNotValidException {
    return userService.registerUser(email, password, fullName).getId();
  }

  //переделать!!! название
  public Long findUser(String email, String password)
          throws NoSuchEmailException, PasswordNotCorrectException {
    return userService.findUser(email, password);
  }
  
  public Resume addResume(Long userId, String work, String salary, String standing,
          String text) throws NumberFormatException {
    return userService.addResume(userId, work, salary, standing, text);
  }
  
  public ResumeForm getResumeForm (Long userId) {
    Resume resume = userService.getResume(userId);
    if (resume == null) {
      return new ResumeForm();
    }
    return new ResumeForm(resume.getWork(), resume.getSalary(),
    		String.valueOf(resume.getStanding()), resume.getText());
  }

  public RecommendationForm getRecommendationForm(Long recommendatorId, Long recommendationId)
      throws NoSuchElementException {
    Recommendation recommendation = recommendationService.getRecommendationSequred(recommendatorId,
        recommendationId);
    return new RecommendationForm(recommendation);
  }

  public RecommendationInfo getRecommendationInfo(Long recommendationId) {
    Recommendation recommendation = recommendationService.getRecommendation(recommendationId);
    return new RecommendationInfo(recommendation);
  }

  public void setRecommendation(RecommendationForm recommendationForm) {
    recommendationService.setRecommendationText(recommendationForm.getId(), recommendationForm.getText());
  }
}
