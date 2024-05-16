package StepDefinitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.base;
import Utils.GenericUtilities;

 
public class hooks{
	public static WebDriver driver;
	public GenericUtilities genUtil;
    
    @Before
    public void setUp() throws IOException {
    	
    	driver=base.initializeDriver();
    	genUtil = new GenericUtilities(driver);
		
       }
                                                                            
   @After
    public static void tearDown() {
 
    	driver.close();
    }
}