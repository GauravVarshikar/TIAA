
import org.junit.Test;

public class TestMainClass {

	@Test
	public void testValidInputs() {
		System.out.println("main");
	    String[] args = new String[3];
	    //pass # of bolts
	    args[0] = "20";
	    //pass # of machines
	    args[1] = "10";
	    //pass time taken to make a product (in seconds)
	    args[2] = "2";
	    TIAA_Main.main(args);
	}
	
	@Test
	public void testInvalidTextInputs() {
		System.out.println("main");
	    String[] args = new String[3];
	    //pass # of bolts
	    args[0] = "20e";
	    //pass # of machines
	    args[1] = "10";
	    //pass time taken to make a product (in seconds)
	    args[2] = "2";
	    TIAA_Main.main(args);
	}
	
	@Test
	public void testInvalidZeroInputs() {
		System.out.println("main");
	    String[] args = new String[3];
	    //pass # of bolts
	    args[0] = "0";
	    //pass # of machines
	    args[1] = "10";
	    //pass time taken to make a product (in seconds)
	    args[2] = "2";
	    TIAA_Main.main(args);
	}

}
