package ru.hh.school.example.web;

import java.util.NoSuchElementException;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class UserSecurity {

  public static Long getCurrentUserId() throws NoSuchElementException {
  	Long userId = (Long) RequestContextHolder.currentRequestAttributes().
  	               getAttribute("userId", RequestAttributes.SCOPE_SESSION);
  	if (userId == null) {
  		NoSuchElementException e = new NoSuchElementException("unknown user");
  		throw e;
  	}
  	return userId;
  }

  public static void setCurrentUserId(Long userId) {
    RequestContextHolder.currentRequestAttributes().
	  	                  setAttribute("userId", userId, RequestAttributes.SCOPE_SESSION);
  }

  public static void removeCurrentUserId() {
    RequestContextHolder.currentRequestAttributes().
	  	                  removeAttribute("userId", RequestAttributes.SCOPE_SESSION);
  }
}
