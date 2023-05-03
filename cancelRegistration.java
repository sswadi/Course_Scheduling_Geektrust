import java.time.LocalDate;


public class cancelRegistration {


	public static void cancelReg(String courseRegistrationId) {

		String courseId = registerForTheCourse.totalCourseList.keySet().toString(); //fetch courseId
		LocalDate courseStartDate = AddCourseOffering.getCourseStartDate(courseId); //fetch course start date using courseId
		LocalDate todaysDate = LocalDate.now(); //fetch today's date
		
		registerForTheCourse ans = registerForTheCourse.empListForACourseId.get(courseRegistrationId);

		if(courseStartDate.compareTo(todaysDate)<=0 && ans.status == "ACCEPTED") {
			System.out.println(" CANCEL_REJECTED");
		}else {
			registerForTheCourse.empListForACourseId.remove(courseRegistrationId);
		}

	}

}
