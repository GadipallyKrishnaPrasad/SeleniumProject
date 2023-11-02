package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;

public class SecondTest extends Base {
	
	public WebDriver wd=null;
	
	@Test
	public void testNumberTwo() throws IOException
	{
		wd=buildBase();
		wd.get("https://www.google.com/");
		System.out.println(wd.getTitle());
		System.out.println("new line of code");
	}

	@AfterMethod
	public void closure()
	{
		wd.quit();
	}
}
