package utilityMethods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshot {

	public static void captureScreenshot(WebDriver driver,String SCname) {

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String SCpath = System.getProperty("user.dir")+File.separator+"myScreenshots"+File.separator+SCname+".png";

		File destLocation = new File(SCpath);

		try {
			FileHandler.copy(sourceFile, destLocation);
		    } 
		catch (IOException e) 
		{
			System.out.println("failed to copy screenshot from source to destination...captureScreenshot method");
			e.printStackTrace();
		}

	}
	
	
	
}
