import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;


public class cancelRegistration {


	public static void cancelReg(String courseRegistrationId) {


		String courseId = null;
		for (Map.Entry<String, HashMap<String, registerForTheCourse>> entry : registerForTheCourse.totalCourseList.entrySet()) {
			HashMap<String, registerForTheCourse> innerMap = entry.getValue();
			if (innerMap.containsKey(courseRegistrationId)) {
				courseId = entry.getKey();
				break;
			}
		}

		LocalDate courseStartDate = AddCourseOffering.getCourseStartDate(courseId); //fetch course start date using courseId

		LocalDate todaysDate = LocalDate.now(); //fetch today's date

		registerForTheCourse ans = registerForTheCourse.empListForACourseId.get(courseRegistrationId);

		if(courseStartDate.compareTo(todaysDate)<=0 && ans.status == "ACCEPTED") {
			System.out.println("CANCEL_REJECTED");
		}else {
			registerForTheCourse.empListForACourseId.remove(courseRegistrationId);
			System.out.println(courseRegistrationId+" " +"CANCEL_ACCEPTED");
		}

	}

}
