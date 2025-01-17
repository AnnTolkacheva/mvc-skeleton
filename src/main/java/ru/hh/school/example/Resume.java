package ru.hh.school.example;

import ru.hh.school.example.ddd.Entity;

public class Resume extends Entity {

  private String work;
  private String salary;
  private String standing;
  private String text;

  public Resume(String work, String salary, String standing, String text) {
    this.work = work;
    this.salary = salary;
    this.standing = standing;
    this.text = text;
  }

  public Resume() {
  }

  public void setWork(String work) {
    this.work = work;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public void setStanding(String standing) {
    this.standing = standing;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void change(Resume resume) {
    work = resume.work;
    salary = resume.salary;
    standing = resume.standing;
    text = resume.text;
  }

  public String getWork() {
	  return work;
  }

  public String getSalary() {
    return salary;
  }

  public String getStanding() {
    return standing;
  }

  public String getText() {
    return text;
  }
}
