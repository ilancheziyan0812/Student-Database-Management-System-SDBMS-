package com.sorticlogic;

import java.util.Comparator;

import com.student.Student;

public class SortByName  implements Comparator<Student>{

	

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return x.getName().compareTo(y.getName());
	}

	
}
