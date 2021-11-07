 // @author Ivan Prusac

package AlgoProject;

public class firstNameException extends Exception {

	public firstNameException (String message) {
		super ("Invalid first name input!" + message);
	}

}