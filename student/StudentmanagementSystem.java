package com.student;

public interface StudentmanagementSystem {

	void addStudent();
	void displayStudent();
	void displayAllStudent();
	void removeStudent();// check --> db.remove() 
	void removeAllStudent();//db.remove(map);
	void updateStudent();
	void countStudent();// db.size()
	void sortStudent();// sortbyId,sortbyName,sortbyMark
	//All the above methods are automatically public and abstract
	//variable --> public ,static , final
}
