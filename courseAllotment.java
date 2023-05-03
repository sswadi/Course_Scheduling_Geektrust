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
	
	
	
	//chatGTP
	
//	public static List<String> courseAllotmentList(String courseId) {
//	    AddCourseOffering course = AddCourseOffering.findCourseUsingId(courseId);
//	    if (course == null) {
//	        return null; // Course not found
//	    }
//	    List<String> allotmentList = new ArrayList<>();
////	    for (Map.Entry<String, registerForTheCourse> entry : registerForTheCourse.entrySet()) {
//	    for (Map.Entry<String, registerForTheCourse> entry : course.entrySet()) {
//	        String registrationId = entry.getKey();
//	        registerForTheCourse registration = entry.getValue();
//	        if (registration.getCourseId().equals(courseId)) {
//	            String email = registration.getEmail();
//	            String name = registration.getName();
//	            String status = registration.getStatus();
//	            String allotmentStatus = (status.equals("CONFIRMED")) ? "ALLOTTED" : "NOT ALLOTTED";
//	            String allotment = String.format("%s, %s, %s, %s, %s, %s, %s, %s",
//	                                              registrationId, name, email, courseId,
//	                                              course.getCourseName(), course.getCourseInstructor(),
//	                                              course.getCourseStartDate(), allotmentStatus);
//	            allotmentList.add(allotment);
//	        }
//	    }
//	    // Sort the allotmentList by registration number
//	    Collections.sort(allotmentList);
//	    return allotmentList;
//	}


//	public static void courseAllotmentList(String courseId) {
//		
//		
//		if(registerForTheCourse.totalCourseList.containsKey(courseId)) {
//			
//			HashMap<String, registerForTheCourse> ans = registerForTheCourse.totalCourseList.get(courseId);
//			
//			System.out.println(courseId);
//			
//			for (Map.Entry<String, registerForTheCourse> entry : ans.entrySet()) {
//				System.out.println(entry.getKey(),+entry.getValue(). );
//			}
//			
//		}else {
//			System.out.println( "ERROR: Course offering not found");
//		}
		
//		course-registration-id, 
//		email-id, --->
//		course-offering-id, 
//		course-name,
//		instructor, 
//		date-in-ddmmyyyy,
//		status 
//	}
}
