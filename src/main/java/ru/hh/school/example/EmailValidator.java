package ru.hh.school.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

  public static final Pattern pattern = Pattern.compile
          ("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}([a-zA-Z]{1,3})");
	
    public static boolean isValid(String word) {
        Matcher matcher = pattern.matcher(word);
        if (matcher.matches())
        	return true;
        else
        	return false;
    }
}
