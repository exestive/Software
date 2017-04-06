
public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("MEMBER")) {
			return new MemberFactory();
			// if choice = "member" string create a new MemberFactory
		}
		return null; 
	}
}
