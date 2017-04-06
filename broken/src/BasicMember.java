import javax.swing.JTable;

public class BasicMember implements Member {
	// attributes that align with the attributes for a member in the database
	public String name;
	public String surname;
	public String M_Status;
	public String email;
	public String contactNumber;
	public String DOB;
	public String sessions;
	public String ID;
	DataPersistence data = new DataPersistence(); // datapersistence object, gives connectivity to the database
	
	@Override
	public String getName() {
		this.name = data.read(2);
		return this.name;
	}

	@Override
	public String getSurname() {
		this.surname = data.read(3);
		return this.surname;
		
	}

	@Override
	public String getM_Status() {
		this.M_Status = data.read(5);
		return this.M_Status;
		
	}

	@Override
	public String getEmail() {
		this.email = data.read(8);
		return this.email;
		
	}

	@Override
	public String getContactNumber() {
		this.contactNumber = data.read(9);
		return this.contactNumber;
		
	}
	
	@Override
	public String getDOB() {
		this.DOB = data.read(4);
		return this.DOB;
	}
	
	@Override
	public void setM_Status(String membershipType) {
		data.amendMembership(this, membershipType);
		
	}

	@Override
	public void setEmail(String email) {
		data.amendEmail(this, email);
		
	}

	@Override
	public void setContactNumber(String contactNumber) {
		data.amendContact(this, contactNumber);
		
	}

	@Override
	public void databaseConnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSessionID() {
		this.sessions = data.read(1);
		return this.sessions;
	}

	@Override
	public String getIDNum() {
		this.ID = data.read(0);
		return this.ID;
	}



}
