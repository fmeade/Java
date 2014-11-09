import java.util.Scanner;
import java.io.*;

public class View
{
	/**
	 * asks for an existing file
	 */
	public Boolean existingFile()
	{
		String ans = "";
		Scanner scan = new Scanner(System.in);

		System.out.print("Is there an existing Program of Study (y or n)? ");
		ans = scan.next();

		while((! ans.equals("y")) && (! ans.equals("n")))
		{
			System.out.print("Is there an existing Program of Study (y or n)? ");
			ans = scan.next();
		}

		if(ans.equals("y"))
		{
			return (true);
		}
		else
		{
			return (false);
		}
	}

	/**
	 * Asks for the filename of existing file
	 */
	public String getExistingFileName()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the filename for the existing file: ");
		return (scan.next());
	}
	
	/**
	 * Prints File Not Found
	 */
	public void printFileNotFound()
	{
		System.out.println();
		System.out.println("File Not Found");
		System.out.println();
	}

	/**
	 * Gets major
	 */
	public String getTemplateFileName()
	{
		Scanner scan = new Scanner(System.in);

		String major = getMajor();

		return major;
	}

	/**
	 * Prints Menu
	 */
	public void displayMenu()
	{	
		System.out.println("Find a course in the Program of Study (find)");
		System.out.println();
		System.out.println("Add or change a course in the Program of Study (add)");
		System.out.println();
		System.out.println("Add a grade for a course in the Program of Study (grade)");
		System.out.println();
		System.out.println("Output the courses in a particular semester (printSem)");
		System.out.println();
		System.out.println("Output the entire Program of Study (printPOS)");
		System.out.println();
		System.out.println("Save the Program of Study to a file (save)");
		System.out.println();
		System.out.println("Exit the system (exit)");
		System.out.println();
	}

	/**
	 * Gets menu choice
	 */
	public String getChoice()
	{
		String choice = "";
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();

		displayMenu();

		choice = scan.next();

		return choice;
	}

	/**
	 * Gets major
	 */
	public String getMajor()
	{
		Scanner scan = new Scanner(System.in);

		String major;
		System.out.println();
		System.out.println("Enter your major:");
		System.out.println();
		System.out.println("Computer Science (CS)");
		System.out.println();
		System.out.println("Database (DB)");
		System.out.println();
		System.out.println("Networks (NW)");
		System.out.println();
		System.out.println("Software Engineering (SE)");
		System.out.println();
		System.out.println("Information Systems (IS)");
		System.out.println();
		System.out.println("Web Developement (WD)");
		System.out.println();
		major = scan.next();

		return major;
	}
	/**
	 * Gets semester 
	 */
	public int getSemester()
	{
		Scanner scan = new Scanner(System.in);
		int sem = 99;

		System.out.print("What is the semester? ");
		sem = scan.nextInt();
		System.out.println();

		return sem;
	}
	
	/**
	 * Gets Course Location
	 */
	public int getCourseLocation()
	{
		Scanner scan = new Scanner(System.in);
		int courseLocation = 99;

		System.out.print("What is the course location? ");
		courseLocation = scan.nextInt();
		System.out.println();

		return courseLocation;
	}
	/**
	 * Prints Course Not Found 
	 */
	public void courseNotFound()
	{
		System.out.println();
		System.out.println("This course could not be found.");
		System.out.println();
	}
	
	/**
	 * Prints no Course 
	 */
	public void noCourse()
	{
		System.out.println();
		System.out.println("There is no course in ths location.");
		System.out.println();
	}
	
	public void error()
	{
		System.out.println();
		System.out.println("Invalid Input.");
		System.out.println();
	}

	public String getDepartment()
	{
		String department = "";
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("What is the department? ");
		department = scan.nextLine();

		System.out.println();

		return department;
	}

	public int getNumber()
	{
		int number = 0;
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("What is the course number? ");
		number = scan.nextInt();

		System.out.println();

		return number;
	}

	public int getCredit()
	{
		int credit = 0;
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("What is the amount of credits? ");
		credit = scan.nextInt();

		System.out.println();

		return credit;
	}

	public String getTitle()
	{
		String title = "";
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("What is the title? ");
		title = scan.nextLine();

		System.out.println();

		return title;
	}

	public String getGrade()
	{
		Scanner scan = new Scanner(System.in);
		String grade = "";

		System.out.print("What is the grade? ");
		grade = scan.next();
		System.out.println();

		return grade;
	}

	public int findSemester(int _semester)
	{
		return _semester;
	}

	public void printSemester(String _semester)

	{
		System.out.println(_semester);
	}

	public void printPOS(String result)
	{
		System.out.println(result);
	}

	public String save()
	{
		Scanner scan = new Scanner(System.in);
		String file = "";

		System.out.print("What is the filename? ");
		file = scan.next();
		System.out.println();

		return file;
	}
}
