import oui.*;

public class Client {

	public static void main(String[] args) throws Exception {
		// The args[0] has the address of the index file generation
		DataManager.basedir = args[0];
		// the main function of client is to make the object of the app class
		App app = new App();
	}
}
