/**
 * Project 1 - Course class
 * @author fmeade
 * 
 * Creates a single Course object
 */
public class Course
{
	protected String department;
	protected int number;
	private int credit;
	private String title;
	private String grade;

	/**
	 * Course constructor used to read in the information from an existing file
	 * 
	 * @param _department sets the department of the Course
	 * @param _number sets the number of the Course
	 * @param _credit sets the credit of the Course
	 * @param _title sets the title of the Course
	 * @param _grade sets the grade of the Course
	 */
	public Course(String _department, int _number, int _credit, String _title, String _grade)
	{
		department = _department;
		number = _number;
		credit = _credit;
		title = _title;
		grade = _grade;
	}

	/**
	 * Course constructor used to read in the information from a Template file
	 * 
	 * @param _department sets the department of the Course
	 * @param _number sets the number of the Course
	 * @param _credit sets the credit of the Course
	 * @param _title sets the title of the Course
	 */
	public Course(String _department, int _number, int _credit, String _title)
	{
		department = _department;
		number = _number;
		credit = _credit;
		title = _title;
		grade = "N";
	}

	/**
	 * Sets a null Course
	 */
	public Course()
	{
		department = "";
		number = 0;
		credit = 0;
		grade = "N";
		title = "";

	}

	/**
	 * Puts the value of _grade into the instance grade
	 */
	public void setGrade(String _grade)
	{
		grade = _grade;
	}

	/**
	 * Returns the String for each Course
	 */
	public String toString()
	{
		String str = department + " " + number + " " + credit + " "  + grade + " " + title ;
		return str;
	}
}

