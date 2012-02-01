package ru.hh.school.example;

public class TestException extends Exception {

  private final String testString;
  private final Long testLong;

  public TestException(String testString, Long testLong) {
    super("test String");
    this.testString = testString;
    this.testLong = testLong;
  }

  public TestException(Long testLong) {
    super("test id");
    this.testLong = testLong;
    this.testString = "test long";
  }

  public String getTestString() {
    return testString;
  }

  public Long getTestLong() {
    return testLong;
  }

}
