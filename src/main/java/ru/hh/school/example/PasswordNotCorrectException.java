package ru.hh.school.example;

public class PasswordNotCorrectException extends Exception {

  private final String password;

  public PasswordNotCorrectException(String password) {
    super(password);
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

}
