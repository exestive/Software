
public interface Member {
	// member interface, registered/basic membership/loyalty member inherit this class, must implement the functions below
	void databaseConnect(); 
	String getName();
	String getSurname();
	String getM_Status();
	String getEmail();
	String getContactNumber();
	String getDOB();
	String getIDNum();
	String getSessionID();
	void setM_Status(String membershipType);
	void setEmail(String email);
	void setContactNumber(String contactNumber);
	
}
