package com.sorticlogic;
//
/**
 * 
 * 
 * 
 * 
 */
import java.util.Comparator;

import com.student.Student;

public class SortByAge implements Comparator <Student> {

	
	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
	    
		
		return  x.getAge()-(y.getAge());
	}
	
}
