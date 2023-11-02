package StepDefinitionFiles;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Resources.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppLogin extends Base {
	WebDriver wd;
	LoginPage lp;
	@Given("I Open any browser")
	public void i_open_any_browser() throws IOException {
	 wd=buildBase();

	}

	@And("I Navigate to login page")
	public void i_navigate_to_login_page() {
	    
	}

	@When("I enter user name as {string} and password as {string} in to the fields")
	public void i_enter_user_name_as_and_password_as_in_to_the_fields(String string, String string2) {
		 lp=new LoginPage(wd);
		lp.getEmailField().sendKeys(string);
		lp.getPwdField().sendKeys(string2);
	    
	}

	@And("I click on login button")
	public void i_click_on_login_button() {
	    lp.getLoginButton().click();
	}

	@Then("Verify user is able to successfully login")
	public void verify_user_is_able_to_successfully_login() {
	 MyAccountPage map=new MyAccountPage(wd);
		 Assert.assertTrue(map.is_Edit_your_Account_Information_ElementDisplayed());
		 
	  
		
	}
	
	@After
	public void closure()
	{
		wd.quit();
	}

}
