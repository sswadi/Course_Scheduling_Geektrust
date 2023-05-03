import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class main {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			String[] parts = input.split(" ");
			String command = parts[0];

			switch (command) {
			case "ADD-COURSE-OFFERING":
				String courseName = parts[1];
				String instructor = parts[2];
				LocalDate date = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("ddMMyyyy"));
				int minEmp = Integer.parseInt(parts[4]);
				int maxEmp = Integer.parseInt(parts[5]);
				String addNewCourseId = AddCourseOffering.createCourseOffering(courseName, instructor, date, minEmp, maxEmp);
				System.out.println(addNewCourseId);
				break;

			case "REGISTER":
				String email = parts[1];
				String offeringId = parts[2];
				int atIndex = email.indexOf('@');
				String name = email.substring(0, atIndex); 

				String courseRegistrationID = registerForTheCourse.register(email, offeringId, name);
				break;
				
			case "ALLOT-COURSE":
				String courseId = parts[1];
				courseAllotment.courseAllotmentList(courseId);
				break;
				
			case "CANCEL":
				String courseRegistrationId = parts[1];
				cancelRegistration.cancelReg(courseRegistrationId);
				break;
			default:
				System.out.println("INVALID_COMMAND_ERROR");
			}
		}
	}


}
