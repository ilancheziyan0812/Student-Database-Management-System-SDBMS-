package com.sorticlogic;

import java.util.Comparator;

import com.student.Student;

public class SortByMarks implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		return x.getMarks().compareTo(y.getMarks());
	}

}
