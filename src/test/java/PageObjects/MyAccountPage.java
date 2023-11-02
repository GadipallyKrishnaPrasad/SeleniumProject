package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    
	WebDriver wd;
	
	public MyAccountPage(WebDriver wd)
	{
		this.wd=wd;
	}
	
	public Boolean is_Edit_your_Account_Information_ElementDisplayed()
	{
		if(wd.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).isDisplayed())
		{
		return true ;
	}
		else
		{
			return false;
		}
	}
	
	public boolean is_Login_Warning_Displayed()
	{
		if(wd.findElement(By.xpath("//body/div[@id='account-login']/div[1]/i[1]")).isDisplayed())
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
		

}
