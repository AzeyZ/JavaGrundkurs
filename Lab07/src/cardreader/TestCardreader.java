package cardreader;

public class TestCardreader {
	public static void main(String[] args) {
		UserTable ut = new UserTable();
		User u1 = ut.find(24073);
		User u2 = ut.find(24074);
		User u3 = ut.findByName("Jens Holmgren");
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
		System.out.println(ut.testFind());
		User u4 = new User(1234, "TESTER");
		ut.add(u4);
		User u5 = ut.find(1234);
		System.out.println(u5);
		//ut.print();
	}
}
