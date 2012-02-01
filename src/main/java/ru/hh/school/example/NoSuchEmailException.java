package ru.hh.school.example;

public class NoSuchEmailException extends Exception {

  private final String email;

  public NoSuchEmailException(String email) {
    super(email);
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

}
