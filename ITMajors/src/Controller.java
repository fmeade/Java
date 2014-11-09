public class Controller
{
	private String choice;
	private View view;
	private POS pos;

	/**
	 * Determines whether the user has an existiong file or not
	 * 
	 * Then repeatedly askes the user for their choice
	 */
	public void start()
	{	
		view = new View();
		pos = new POS();

		Boolean EF;
		EF = view.existingFile();

		String filename;
		Boolean result;

		if(EF)
		{
			filename = view.getExistingFileName();
			result = pos.loadExistingFile(filename);
			
			while(result == false)
			{
				view.printFileNotFound();
				filename = view.getExistingFileName();
				result = pos.loadExistingFile(filename);
			}
		}
		else
		{
			filename = view.getTemplateFileName();
			pos.loadTemplateFile(filename);
		}

		choice = view.getChoice();
		doChoice(choice);

		while(! choice.equals("exit"))
		{
			choice = view.getChoice();
			doChoice(choice);
		}
	}

	/**
	 * Runs the choice chosen by the user
	 * 
	 * @param choice is the users choice input
	 */
	public void doChoice(String choice)
	{
		if(choice.equals("find"))
		{
			String department = view.getDepartment();
			int course = view.getNumber();
			int semester = pos.find(department,course);
			
			if(semester == -1)
			{
				view.courseNotFound();
			}
			else
			{
				view.printSemester(pos.printSemester(semester));
			}
		}
		else if(choice.equals("add"))
		{
			int semester = view.getSemester();
			int courseLocation = view.getCourseLocation();

			String department = view.getDepartment();
			int number = view.getNumber();
			int credit = view.getCredit();
			String title = view.getTitle();

			Course course = new Course(department,number,credit,title);

			pos.addCourse(semester,courseLocation,course);

		}
		else if(choice.equals("grade"))
		{
			int semester = view.getSemester();
			int courseLocation = view.getCourseLocation();
			Course course = pos.getCourse(semester,courseLocation);
			if(course != null)
			{
				String grade = view.getGrade();
				pos.addGrade(grade,course);
			}
			else
			{
				view.noCourse();
			}

		}
		else if(choice.equals("printSem"))
		{
			int semester = view.getSemester();
			view.printSemester(pos.printSemester(semester));
		}
		else if(choice.equals("printPOS"))
		{
			view.printPOS(pos.printPOS());
		}
		else if(choice.equals("save"))
		{
			pos.save(view.save());
		}
		else if(choice.equals("exit"))
		{
			
		}
		else
		{
			view.error();
		}
	}
}