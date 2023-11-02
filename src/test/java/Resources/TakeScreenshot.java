package Resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public void getScreenshot(WebDriver wd,String testName) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) wd;
		File f=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File("Screenshots/"+testName+".png"));
		
	}
	
	
}
