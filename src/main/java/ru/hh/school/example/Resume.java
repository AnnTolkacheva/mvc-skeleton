package ru.hh.school.example;

import java.util.Date;

import ru.hh.school.example.ddd.Entity;

public class Resume extends Entity {

  private String work;
  private String salary;
  private int standing;
  private String text;
  private Date dateCreating;
  private Date dateLastMod;

  public Resume(String work, String salary, int standing, String text) {
	  this.work = work;
	  this.salary = salary;
	  this.standing = standing;
	  this.text = text;
	  this.dateCreating = new Date();
	  this.dateLastMod = dateCreating;
  }

  public Resume() {
  }

  public void setWork(String work) {
	  this.work = work;
  }

  public void setSalary(String salary) {
	  this.salary = salary;
  }

  public void setStanding(int standing) {
	  this.standing = standing;
  }

  public void setText(String text) {
	  this.text = text;
  }

  public void setDateLastMod() {
	  dateLastMod = new Date();
  }

  public void change(Resume resume) {
    work = resume.work;
    salary = resume.salary;
    standing = resume.standing;
    text = resume.text;
    dateLastMod = new Date();
  }
  public String getWork() {
	  return work;
  }
  
  public String getSalary() {
	  return salary;
  }
  
  public int getStanding() {
	  return standing;
  }
  
  public String getText() {
	  return text;
  }
  
  public Date getDateLastMod() {
	  return dateLastMod;
  }
  
  public Date getDateCreating() {
	  return dateCreating;
  }
}
