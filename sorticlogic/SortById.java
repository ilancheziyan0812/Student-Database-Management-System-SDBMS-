package com.sorticlogic;

import java.util.Comparator;

import com.student.Student;

public class SortById  implements Comparator<Student>{

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return y.getId().compareTo(x.getId()); // id is String so using compareTO()
	}

}
