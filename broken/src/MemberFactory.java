
public class MemberFactory extends AbstractFactory {
	
	@Override
	public Member getMember(String membershipType) {
		// memberfactory creates a member of the type passed to it via string
		if (membershipType == null) {
			return null; 
		}
		if (membershipType.equalsIgnoreCase("Registered")) {
			return new Registered(); 
		}
		if (membershipType.equalsIgnoreCase("Member")) {
			return new BasicMember();
		}
		
		if (membershipType.equalsIgnoreCase("Loyalty")) {
			return new LoyaltyMember();
		}
		return null; 
	}
}


