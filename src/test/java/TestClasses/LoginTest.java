package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Resources.Base;
import Resources.ReadFromExcel;

public class LoginTest extends Base
{
	public WebDriver wd;
	
	@Test(dataProvider = "provideData")
	public void testLogin(String username, String pwd, String status) throws IOException
	{
		
		wd=buildBase();
		
		LoginPage lp=new LoginPage(wd);
		lp.getEmailField().sendKeys(username);
		lp.getPwdField().sendKeys(pwd);
		lp.getLoginButton().click();
		
		String actual=null;
		MyAccountPage map=new MyAccountPage(wd);
		
		if(status.equals("Success"))
		{
        if(map.is_Edit_your_Account_Information_ElementDisplayed())
        {
        	actual="Success";
        }
        else {
        	actual="Fail";
        }
		}
		
        else
        {
        	if(map.is_Login_Warning_Displayed())
        	{
        	actual="Fail";
        	}
        	else
        	{
        		actual="Success";
        	}
        }
		
		Assert.assertTrue(status.equals(actual));
	}
	
	
	@DataProvider
	public Object[][] provideData() throws IOException
	{
		ReadFromExcel rfe=new ReadFromExcel();
		Object a[][]=rfe.getDataFromExcel();
		return a;
	}
	
	@AfterMethod
	public void closure()
	{
		wd.quit();
	}
}
