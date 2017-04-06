import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class amendMembershipController {
	public void amendMembership(Member member, String membershipType, String email, String contactNumber) {
		// function that makes three method calls to the member interface 
		// sets the membership type, the email and the contact number
		member.setM_Status(membershipType);
		member.setEmail(email);
		member.setContactNumber(contactNumber);
		
	}
}
