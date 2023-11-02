package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;

public class ThirdTest extends Base{
	
	public WebDriver wd=null;
	
	@Test
	public void testNumberThree() throws IOException
	{
		wd=buildBase();
		wd.get("https://www.youtube.com/");
		System.out.println(wd.getTitle());
		System.out.println("new line of code");
		System.out.println("Another new line of code");
		System.out.println("Third line of new code");
		Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void closure()
	{
		wd.quit();
	}

}
