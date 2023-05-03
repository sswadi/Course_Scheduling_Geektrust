import java.time.LocalDate;
import java.util.*;


public class AddCourseOffering {
	
	private String courseName;
	private String courseInstructor;
	LocalDate courseStartDate;
	private int minEmp;
	private int maxEmp;
	public static Map<String, AddCourseOffering> courseList = new HashMap<>();
	
	public AddCourseOffering(String courseName, String courseInstructor, LocalDate courseStartDate, int minEmp, int maxEmp) {
		this.courseName = courseName;
		this.courseInstructor = courseInstructor;
		this.courseStartDate = courseStartDate;
		this.minEmp = minEmp;
		this.maxEmp = maxEmp;
	}
	
	Scanner sc = new Scanner(System.in);

	public static int getMinEmp(String id) {
		return AddCourseOffering.findCourseUsingId(id).minEmp;
	}

	public static LocalDate getCourseStartDate(String id) {
		return courseList.get(id).courseStartDate;
	}

	public static int getMaxEmp(String id) {
		return AddCourseOffering.findCourseUsingId(id).maxEmp;
	}
	
	public static String getCourseInstructor(String id) {
		return AddCourseOffering.findCourseUsingId(id).courseInstructor;
	}

	public static String getCourseName(String id) {
		return AddCourseOffering.findCourseUsingId(id).courseName;
	}

	public Map<String, AddCourseOffering> getCourseList() {
		return courseList;
	}
	
	public static boolean findCourse(String id) {
		
		if(courseList.containsKey(id)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static AddCourseOffering findCourseUsingId(String id) {
		
		if(courseList.containsKey(id)) {
			return courseList.get(id);
		}else {
			return null;
		}
	}

	public void setCourseList(Map<String, AddCourseOffering> courseList) {
		this.courseList = courseList;
	}

	private static String createCourseId(String courseName, String courseInstructor) {
		return "OFFERING-"+"courseName"+"-"+"courseInstructor";
	}
	
	//starting point
	public static String createCourseOffering(String courseName,String courseInstructor,LocalDate courseStartDate,int minEmp,int maxEmp) {
//		System.out.println("Hi, to add a new course please enter the below details: ");
//		
//		String courseName = sc.next();
//        String courseInstructor = sc.next();
//        LocalDate courseStartDate = LocalDate.parse(sc.next());
//        int minEmp = sc.nextInt();
//        int maxEmp = sc.nextInt();
        
        AddCourseOffering addCourse = new AddCourseOffering(courseName, courseInstructor, courseStartDate, minEmp, maxEmp);

        String courseId = createCourseId(addCourse.courseName, addCourse.courseInstructor);
		courseList.put(courseId, addCourse);
		return courseId;
		
	}
	
	
	
	
	

}
