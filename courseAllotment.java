import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

public class courseAllotment {
	
	
	public static void courseAllotmentList(String courseId) {
		
		if(registerForTheCourse.totalCourseList.containsKey(courseId)) {
			
			String courseName = AddCourseOffering.getCourseName(courseId);
			String instructor = AddCourseOffering.getCourseInstructor(courseId);
			LocalDate startDate = AddCourseOffering.getCourseStartDate(courseId);
			HashMap<String, registerForTheCourse> ans = registerForTheCourse.totalCourseList.get(courseId);

			for(Entry<String, registerForTheCourse> entry: ans.entrySet()) {
				String courseRegistrationId = entry.getKey();
				registerForTheCourse registerForTheCourseObj = entry.getValue().empListForACourseId.get(courseRegistrationId);
				String email = registerForTheCourseObj.empEmail;
				String status = registerForTheCourseObj.status;
				
				System.out.println(courseRegistrationId+" "+email+" "+courseId+" "+courseName+" "+instructor+" "+startDate+" "+status);
			}
		    
		}else {
			System.out.println("No list");
		}
	
	}
	
	
}
