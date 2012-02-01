package ru.hh.school.example.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.hh.school.example.*;

@Component
public class UserFacade {

  private final UserRepository users;
  private final UserService userService;

  @Autowired
  public UserFacade(UserRepository users, UserService userService) {
    this.users = users;
    this.userService = userService;
  }

  public Iterable<UserInfo> listUsers() {
    List<UserInfo> users = new ArrayList<UserInfo>();
    for (User user : this.users.all())
      users.add(new UserInfo(user));
    return users;
  }

  public Iterable<RecommendationInfo> listRecommendators(Long userId) {
    List<RecommendationInfo> recommendationInfo = new ArrayList<RecommendationInfo>();
    for (Recommendation recommendation : userService.listRecommendationsToMe(userId)) {
      recommendationInfo.add(new RecommendationInfo(recommendation.getId(),recommendation.getUserName(),
       recommendation.getText()));
    }
	  return recommendationInfo;
	}

  public Iterable<RecommendationInfo> listRecommendations(Long userId) {
    List<RecommendationInfo> recommendationInfo = new ArrayList<RecommendationInfo>();
    for (Recommendation recommendation : userService.listMyRecommendations(userId)) {
      recommendationInfo.add(new RecommendationInfo(recommendation.getId(),recommendation.getUserName(),
       recommendation.getText()));
    }
    return recommendationInfo;
  }

  public void setRecommendationRequest(Long userId, Long recommendatorId) {
    userService.setRecommendationRequest(userId, recommendatorId);
  }

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

  public RecommendationForm getRecommendationForm (Long userId, Long recommendatorId) {
    Recommendation recommendation = userService.getRecommendation(userId, recommendatorId);
    return new RecommendationForm(recommendation.getUserId(), recommendation.getUserName(),
        recommendation.getText());
  }
  
  public String userNameById(Long userId) {
	    return userService.userNameById(userId);
	  }
}
