package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver wd = null;
	public Properties p;
	
	public WebDriver buildBase() throws IOException
	{
	
	String browser=null;
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/Resources/data.properties");
	 p=new Properties();
	p.load(fis);
	browser=p.getProperty("browser");
	
	
	if(browser.equals("Chrome"))
	{
		 wd= new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wd.get(p.getProperty("url"));
	}
	if(browser.equals("Edge"))
	{
		wd=new EdgeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wd.get(p.getProperty("url"));
	}
	if(browser.equals("FireFox"))
	{
		wd=new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wd.get(p.getProperty("url"));
	}
	
	return wd;
	}
}
