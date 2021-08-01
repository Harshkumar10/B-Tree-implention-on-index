import oui.*;

public class Client {

	public static void main(String[] args) {
		// The args[0] has the address of the index file generation
		try {
			DataManager.basedir = args[0];
			// the main function of client is to make the object of the app class
		} catch (Exception e) {
			// assume this to be the main
			DataManager.basedir = "D:\\indexPrj";
			// java.lang.ArrayIndexOutOfBoundsException
			System.out.println("Exception: " + e);
		} finally {
			App app = new App();
		}

	}
}
