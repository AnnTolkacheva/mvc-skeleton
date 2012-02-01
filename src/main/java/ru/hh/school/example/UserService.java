package ru.hh.school.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  private final UserRepository users;

  @Autowired
  public UserService(UserRepository users) {
    this.users = users;
  }

  public User registerUser(String email, String password, String fullName) 
          throws EmailAlreadyBoundException, EmailNotValidException {
    if (!EmailValidator.isValid(email)) { 
      throw new EmailNotValidException(email);
    }
    User existing = users.byEmail(email);
    if (existing != null) {
      throw new EmailAlreadyBoundException(email);
    }
    User user = new User(email, password, fullName);
    users.put(user);
    return user;
  }
// ���������� ���!!!
  public Long findUser (String email, String password)
          throws NoSuchEmailException, PasswordNotCorrectException {
    User existing = users.byEmail(email);
    if (existing == null) {
      throw new NoSuchEmailException(email);
    }
    if (!existing.getPassword().equals(password)) {
      throw new PasswordNotCorrectException(password);
    }
    return existing.getId();
  }

  public String userNameById(Long userId) {
    User user = this.users.byId(userId);
    return user.getFullName();
  }

  public Resume addResume(Long userId, String work, String salary, String standing,
          String text) throws NumberFormatException {
    int yearsStanding = Integer.parseInt(standing);
    User user = this.users.byId(userId);
    Resume resume = new Resume(work, salary, yearsStanding, text);
    user.setResume(resume);
    return user.getResume();
  }

  public Resume getResume (Long userId) {
    User user = this.users.byId(userId);
    Resume resume = user.getResume();
    if (resume == null) {
        resume = new Resume();
    }
    return resume;
  }

  public Resume changeResume(Long userId, Resume resume) {
    User user = this.users.byId(userId);
    user.changeResume(resume);
    return user.getResume();
  }

  public void setRecommendationRequest(Long userId, Long recommendatorId) {
    User user = this.users.byId(userId);
    user.setRecommendRequest(recommendatorId, this.users.byId(recommendatorId).getFullName());
  }

  public Recommendation getRecommendation (Long userId, Long recommendatorId) {
    User user = this.users.byId(userId);
    Recommendation recommendation = user.getRecommendation(recommendatorId);
    return recommendation;
  }

  public Iterable<Recommendation> listRecommendationsToMe(Long userId) {
    User user = this.users.byId(userId);
    return user.getAllRecommendRequests();
  }

  public Iterable<Recommendation> listMyRecommendations(Long userId) {
    User user = this.users.byId(userId);
    return user.getAllRecommendRequests();
  }
}
