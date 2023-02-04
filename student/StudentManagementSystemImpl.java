package com.student;

import java.util.ArrayList;

/**
 * 
 * @author uday
 * @since 2022
 * 
 * we during project for mainly Sorting 
 * 
 * 
 * 
 * 
 */
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InvalidChoiceException;
import com.customexception.StudentNotFoundException;
import com.sorticlogic.SortByAge;
import com.sorticlogic.SortById;
import com.sorticlogic.SortByMarks;
import com.sorticlogic.SortByName;

public class StudentManagementSystemImpl implements StudentmanagementSystem 
{ // upcasting

	// Collection -> Database -> Map & LinkedHashMap -> Key(String) -> value(Student)   
	// Scanner Object
	// JSP101 --> s1
	Map<String,Student> db = new LinkedHashMap<String,Student>(); // linkedhashmap follow the insection order
	Scanner scan = new Scanner(System.in);

	public void addStudent()
	{
		/**
		 * how to store the data --> create one map and store it
		 * how to get the id ------> create class object- referencevaraiable.getId() 
		 */
		// Accept name, Age & marks from user
		// Student object
		System.out.println("Enter name ");
		String name = scan.next();
		System.out.println("Enter  Age ");
		int age = scan.nextInt();
		System.out.println("Enter marks ");
		int marks = scan.nextInt();

		Student s = new Student (name,age,marks);// id not initilize  constructor
		db.put(s.getId(), s);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("your Student id+ "+s.getId());
	}
	public void displayStudent()
	
	
	{
		System.out.println("Enter Student id");
		String id = scan.next();// id is name so using next()
		id = id.toUpperCase();  // in Student class JSP so change input uppercase()

		if(db.containsKey(id))// data present or not
		{
			Student obj = db.get(id);
			System.out.println("Sudent id "+obj.getId());
			System.out.println("Sudent name "+obj.getName());
			System.out.println("Sudent Age "+obj.getAge());
			System.out.println("Sudent Marks "+obj.getMarks());
			// System.out.println(obj);  toString() is Overridden  --> optional
		}
		else
		{
//			try
//			{
//				throw new StudentNotFoundException("Student Record not available");
//			}
//			catch(StudentNotFoundException e)
//			{
//				System.out.println(e.getMessage());
//			}
			System.out.println("Student Record not available");
		}
	}
	public void displayAllStudent()
	{
		/**
		 * keySet() method in Java is used to create a set out of the 
		 * key elements contained in the hash map. 
		 */
		
		//Map - Set Of Key
		//for - get()
		Set<String> keys = db.keySet(); // generic String see map object   / keys group of Student id --> 101,102
		System.out.println(" Student Records are as follows");
		System.out.println("-------------------------------");
		if(db.size()!=0)
		
		{
			for (String key : keys)
			{
				System.out.println(db.get(key));// printing reference variable
			}
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student Record not available");
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	public void removeStudent()
	{
		// Accecpt id
		// Uppercase
		// Check id constainsKey()
		//  remove()
		// else -> SNFE -> handle
		System.out.println("Enter the id");
		String id = scan.next();
		id = id.toUpperCase();// String id = scan.next().toUpperCase();

		if(db.containsKey(id))
		{
			db.remove(id);
			System.out.println("delete student record  successfully");
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student record not found");
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}



	}
	public void removeAllStudent()
	{
		System.out.println(db.size()+" data Student present");
		db.remove(db);
		System.out.println("Delete all student record");
	}
	public void updateStudent()
	{
		// Accecpt id & uppercase ,containskey ,get the student objct 
		//switch case 1.updatename ,age
		//invoke exception
		System.out.println("Enter student id");
		String id = scan.next();
		id = id.toUpperCase();

		if(db.containsKey(id))
		{
			Student stu = db.get(id);
			System.out.println("1:UpdateName\n2:UpdateAge\n3:UpdateMarks");
			System.out.println("Enter choice");
			int choice = scan.nextInt();

			switch(choice)
			{
			case 1:
			{ System.out.println("Enter Student name");
			String name = scan.next();
			stu.setName(name);   // stu.setName(scan.next());
			System.out.println("Name updated successfully");
			break;

			}
			case 2:
			{
				System.out.println("Enter Student Age");
				int age = scan.nextInt();
				stu.setAge(age); // stu.setAge(sc.nextInt());
				System.out.println("Age updated Successfully");

				break;

			}
			case 3:
			{
				System.out.println("Enter Student Marks");
				int marks = scan.nextInt();
				stu.setMarks(marks); // stu.setMarks(scan.nextInt());
				System.out.println("Mark updated successfull");

				break;
			}
			default :
			{
				try
				{
					throw new InvalidChoiceException("Inavlid choice,please enter valid choice");
				}
				catch(InvalidChoiceException e)
				{
					System.out.println(e.getMessage());
				}
			}
			}
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student not Found");
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	public void countStudent()
	{
		System.out.println("no of student "+db.size());
	}
	public void sortStudent()
	
	/**
	 *  
	 *  converting Map into Set
	 *  keys are Student  Id  and Datatype is String
	 * 
	 * 
	 */
	{
		Set<String> keys = db.keySet();// convert map in to set of keys / <String> set of key is String
  /**
   * Achieving upcasting between List & ArrayList
   * list can Store Student object
   */
		List<Student> list = new ArrayList<Student>();
		// add object in to ArrayaList using foreach loop

		for(String key : keys)
		{
			list.add(db.get(key)); // Adding Student objects from map to List
		}
		// create one package name --> sort


		System.out.println("1:Student record sortById\n2:Student record sortByName\n3:Student record sortByAge\n4:Student record SortByMarks");
		System.out.println("Enter your choice");
		switch(scan.nextInt())
		{
		case 1:
		{
			Collections.sort(list , new SortById());  
			display( list);
			break;

		}
		case 2:
		{
			Collections.sort(list , new SortByName());

			display( list);
			break;

		}
		case 3:
		{
			Collections.sort(list , new SortByAge());
			display( list);
			break;
		}
		case 4:
		{
			Collections.sort(list , new SortByMarks());
			display( list);
			
			break;
		}
		
		default :
		{
			try
			{
				throw new InvalidChoiceException("Invalid choice, Please Enter valid choice");
			}
			catch(InvalidChoiceException e)
			{
				System.out.println(e.getMessage());
			}

		}

		}
	}
	public static void display(List<Student> list)
	{
		for(Student stu : list )
		{
			System.out.println(stu);
		}
	}
}


























