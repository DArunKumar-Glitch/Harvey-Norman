package co.harvey.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest 
{
	public WebDriver driver;
	
	@BeforeMethod
	public void preCondition()
	{
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.harvey-norman.co.uk/");
		driver.manage().deleteAllCookies();
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
}
