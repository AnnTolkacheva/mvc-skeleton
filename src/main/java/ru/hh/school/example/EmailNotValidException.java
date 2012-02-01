package ru.hh.school.example;

public class EmailNotValidException extends Exception {

  private final String email;

  public EmailNotValidException(String email) {
    super(email);
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

}
