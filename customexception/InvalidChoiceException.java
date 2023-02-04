package com.customexception;

public class InvalidChoiceException extends RuntimeException{
 String message;
 public InvalidChoiceException(String message)
 {
	 super(message);
	 
	 
 }

}
