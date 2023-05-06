import java.util.*;
import java.time.LocalDate;

public class registerForTheCourse {
	
	public String empEmail;
	public String courseId;
	public String empName;
	public String status;

	public static Map<String,HashMap<String,registerForTheCourse>> totalCourseList = new HashMap<String, HashMap<String,registerForTheCourse>>();
	public static HashMap<String, registerForTheCourse> empListForACourseId = new HashMap<String,registerForTheCourse>();
	
	public registerForTheCourse(String empEmail, String courseId, String empName, String status) {
		this.empEmail = empEmail;
		this.courseId = courseId;
		this.empName = empName;
		this.status = status;
	}

	public static String register(String empEmail, String courseId, String empName) {
		
		//if a course with this id is present
		if(AddCourseOffering.findCourse(courseId)) {
			
			String courseName = AddCourseOffering.getCourseName(courseId); //fetch course name
			LocalDate courseStartDate = AddCourseOffering.getCourseStartDate(courseId); //fetch course start date
			LocalDate todaysDate = LocalDate.now(); //fetch today's date
			
			int maxCount = AddCourseOffering.getMaxEmp(courseId);
			int minCount = AddCourseOffering.getMinEmp(courseId);
			int sizeEmp = empListForACourseId.size();
				
//			if the list is empty initially; adds in the first entry
			if(totalCourseList.get(courseId)==null && courseStartDate.compareTo(todaysDate)>=0) {
				String crcRegisteredId = createRegisteredId(empName, AddCourseOffering.getCourseName(courseId));
				registerForTheCourse reg = new registerForTheCourse(empEmail,courseId, courseName, "ACCEPTED");
				empListForACourseId.put(crcRegisteredId, reg);
				totalCourseList.put(courseId, empListForACourseId);
				return crcRegisteredId+" "+"ACCEPTED";
			}else {
				//if the the min number has not been fulfilled, cancel the course
				if(sizeEmp<maxCount && sizeEmp+1<minCount && courseStartDate.compareTo(todaysDate)>=0) {
					return "COURSE_CANCELED";
				}
				
				else if(sizeEmp==maxCount && courseStartDate.compareTo(todaysDate)>=0) {
					return "COURSE_FULL_ERROR";
				}
				
				if(sizeEmp<maxCount && courseStartDate.compareTo(todaysDate)>=0) {
					String crcRegisteredId = createRegisteredId(empName, AddCourseOffering.getCourseName(courseId));
					registerForTheCourse reg = new registerForTheCourse(empEmail,courseId, courseName, "ACCEPTED");
					empListForACourseId.put(crcRegisteredId, reg);
					totalCourseList.put(courseId, empListForACourseId);
					return crcRegisteredId+" "+"ACCEPTED";
				}
			}
		}
		else {
			System.out.println("The course for the given id could not be found. Please enter a valid course Id");
			return null;
		}
		return "OOPS, THE COURSE HAS ALREADY STARTED!";

	}
	
	public static String createRegisteredId(String empName, String courseName ) {
		
		return "REG-COURSE-"+empName+"-"+courseName;
	}


}


