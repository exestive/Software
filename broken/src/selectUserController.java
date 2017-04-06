import javax.swing.JOptionPane;
import javax.swing.JTable;

public class selectUserController {
	
	DataPersistence data = new DataPersistence();
	
	public Member selectUser(JTable table) {
		String theMembershipType = data.selectUser(table);
		
		AbstractFactory memberFactory = FactoryProducer.getFactory("Member"); // create a new memberFactory 
		Member member1 = memberFactory.getMember(theMembershipType); // create a member of the type passed as a parameter
		return member1; // return the member to the calling function 
		
	}
}