import java.io.*;
import java.util.*;

public class POS
{
	/**
	 * Creates a Course object of 10 semesters and 8 classes per semester
	 */
	private Course[][] pos = new Course[10][8];

	/**
	 * Reads from an existing file
	 * Scans each piece and puts into array respectively
	 */
	public Boolean loadExistingFile(String __file)
	{
		Boolean _file = false;
		try
		{
			File file = new File(__file);
			Scanner scan = new Scanner(file);

			while(scan.hasNext())
			{
				int semester = scan.nextInt();
				int course = scan.nextInt();
				String department = scan.next();
				int number = scan.nextInt();
				int credit = scan.nextInt();
				scan.skip(" ");
				String restOfLine = scan.nextLine();
				String grade = restOfLine.substring(0,1);
				String title = restOfLine.substring(2);
				pos[semester][course] = new Course();
				pos[semester][course] = new Course(department,number,credit,title,grade);
				_file = true;
			}
		}
		catch(IOException e)
		{
			
			_file = false;
			return _file;
		}
		return _file;
	}

	/**
	 * Finds which template file needed
	 * Reads the file
	 * Scans the information into the array respectively
	 */
	public void loadTemplateFile(String __file)
	{
		Scanner scan = new Scanner(System.in);
		String _file;


		if(__file.equals("Computer Science") || __file.equals("CS"))
		{
			_file = "ComputerScience.dat";
		}
		else if(__file.equals("Database") || __file.equals("DB"))
		{
			_file = "Database.dat";
		}
		else if(__file.equals("Networks") || __file.equals("NW"))
		{
			_file = "Networks.dat";
		}
		else if(__file.equals("Software Engineering") || __file.equals("SE"))
		{
			_file = "SoftwareEngineering.dat";
		}
		else if(__file.equals("Information Systems") || __file.equals("IS"))
		{
			_file = "InformationSystems.dat";
		}
		else if(__file.equals("Web Developement") || __file.equals("WD"))
		{
			_file = "WebDevelopement.dat";
		}
		else
		{
			_file = "";
		}

		try
		{
			File file = new File(_file);
			scan = new Scanner(file);

			while(scan.hasNext())
			{
				int semester = scan.nextInt();
				int course = scan.nextInt();
				String department = scan.next();
				int number = scan.nextInt();
				int credit = scan.nextInt();
				scan.skip(" ");
				String title = scan.nextLine();
				pos[semester][course] = new Course();
				pos[semester][course] = new Course(department,number,credit,title);		
			}
		}

		catch (FileNotFoundException e)
		{
			File fileError = new File("File not Found");
		}

	}

	/**
	 * Scans through the array an tries to find a Course that matches the department and Course number
	 * 
	 * @param _department gets the department of the Course from the user
	 * @param _number gets the Course number from the user
	 * 
	 * @return the semester number of the Course, or -1 if not found
	 */
	public int find(String _department,int _number)
	{
		int semester = -1;

		for(int i = 0; i < pos.length;i++)
		{
			for(int j = 0;j < pos[i].length;j++)
			{
				if(pos[i][j] != null && pos[i][j].department.equals(_department) && pos[i][j].number == _number)
				{
					semester = i;
					return semester;
				}
			}
		}
		return semester;
	}

	/**
	 * Gets the semester index from the user then returns the Strings of that semesters Course in the array
	 * 
	 * @param _semester gets the semester index
	 * 
	 * @return the entire String of the semester
	 */
	public String getSemester(int _semester)
	{
		String semester = "";

		for(int i = 0;i < pos.length;i++)
		{
			if(i == _semester)
			{
				for(int j = 0;j < pos[i].length;j++)
				{
					semester += pos[i][j] + "\n";
				}
			}
		}
		return semester;
	}

	/**
	 * Finds the course in the array
	 * 
	 * @param _semester gets the semester index
	 * @param_courseLocation gets the Course index
	 * 
	 * @return Returns the Course at the specified idex
	 */
	public Course getCourse(int _semester,int _courseLocation)
	{
		Scanner scan = new Scanner(System.in);
		Course course = new Course();

		for(int i = 0; i < pos.length;i++)
		{
			for(int j = 0;j < pos[i].length;j++)
			{
				if(_semester == i && _courseLocation == j)
				{
					course = pos[i][j];
					return course;
				}
			}
		}
		return course;
	}

	/**
	 * Finds Course and adds new Course information
	 * 
	 * @param _semester gets semester index
	 * @param _courseLocation gets Course index
	 * @param _inputs Course information into the index of the array
	 */
	public void addCourse(int _semester, int _courseLocation, Course _course)
	{
		for(int i = 0;i < pos.length;i++)
		{
			for(int j = 0;j < pos.length;j++)
			{
				if(i == _semester && j == _courseLocation)
				{
					pos[i][j] = _course;
				}
			}
		}	
	}

	/**
	 * Assigns a grade to specified Course
	 * 
	 * @param _grade gets grade
	 * @param _course gets the Course
	 */
	public void addGrade(String _grade,Course _course)
	{
		_course.setGrade(_grade);
	}

	/**
	 * Prints a specified semester
	 * 
	 * @param _sem gets the semester index
	 */
	public String printSemester(int _sem)
	{
		String result = "";

		for(int j = 0; j < pos[_sem].length;j++)
		{
			if(pos[_sem][j] != null)
			{
				result = result + _sem + " " + j + " " + pos[_sem][j] + "\n";
			}
		}
		return result;
	}

	/**
	 * Prints every semester
	 */
	public String printPOS()
	{
		String result = "";
		for(int i = 0; i < pos.length;i++)
		{
			result += printSemester(i);
			result += "\n";
		}
		return result;
	}

	/**
	 * Writes a file
	 * Saves every element of the array as Strings
	 * 
	 * @param __file gets file name
	 */
	public void save(String __file)
	{
		try
		{
			String theFile = "";
			FileWriter _file  = new FileWriter(__file);

			BufferedWriter file = new BufferedWriter(_file);

			for(int i = 0; i < pos.length;i++)
			{
				for(int j = 0; j < pos[i].length;j++)
				{
					if(pos[i][j] != null)
					{
						theFile = theFile + i + " " + j + " " + pos[i][j] + "\n";
					}
				}
			}

			file.write(theFile);

			file.close();
		}
		catch (IOException e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}

}
