package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver wd=null;
	
	public LoginPage(WebDriver wd)
	{
		this.wd=wd;
	}
	
	public WebElement getEmailField()
	{
		return wd.findElement(By.xpath("//input[@id='input-email']"));
	}
	
	public WebElement getPwdField()
	{
		return wd.findElement(By.xpath("//input[@id='input-password']"));
	}
	
	public WebElement getLoginButton()
	{
		return wd.findElement(By.xpath("//input[@class='btn btn-primary']"));
	}
}
