package com.student;

import java.util.Scanner;

import com.customexception.InvalidChoiceException;

public class Solution 
{
	public static void main(String[] args) 
	{
		//Menu Driven Program
		//UPCASTING
		//switchcase
		//System.exit(0)
		//Infinite loop -->while(true)

		// toAccept input From User
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Student DataBase\n");
		//Upcasting for Achieving Abstrction
		StudentmanagementSystem s1 = new StudentManagementSystemImpl();
		while(true)
		{
			System.out.println("1:Add Student\n2:Dispaly Student\n3:DisplayAllStudent\n4:Remove Student\n5:RemoveAllStudent\n6:Update Student\n7:Count Student\n8:Sort Student\n9:Exit\n\n^Enter Your Choice");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
			{
				s1.addStudent();
				break;
			}
			case 2:
			{
				s1.displayStudent();
				break;
			}
			case 3:
			{
				s1.displayAllStudent();
				break;
			}
			case 4:
			{
				s1.removeStudent();
				break;
			}
			case 5:
			{
				s1.removeAllStudent();
				break;
			}
			case 6:
			{
				s1.updateStudent();
				break;
			}
			case 7:
			{
				s1.countStudent();
				break;
			}
			case 8:
			{
				s1.sortStudent();
				break;
			}
			case 9:
			{
				System.out.println("Thk u");
				System.exit(0);
				
			}
			default :
			{
				try
				{
					throw new InvalidChoiceException("\nInvalid Choice,Please Choose Valid Choice\n");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			}
			System.out.println("----------------");
		}
	}
}
// Custom Exception & Invoke it  --> Invalid ChoiceException
