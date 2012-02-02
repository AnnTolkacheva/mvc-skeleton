package ru.hh.school.example;

import ru.hh.school.example.ddd.Entity;

public class User extends Entity {

  private String email;
  private String password;
  private String fullName;
  private Resume resume;

  public User(String email, String password, String fullName) {
    this.email = email;
    this.password = password;
    this.fullName = fullName;
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
