package co.harvey.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

abstract public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyPageDisplayed(String eTitle)
	{
		wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log(eTitle+" page is displayed.",true);
		}
		catch (Exception e) 
		{
			Assert.fail(eTitle+" is not displyaed.");
		}
	}
	public void verifyElementIsPresent(WebElement element)
	{
		wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log(element.getText()+" element is displayed.",true);
		}
		catch (Exception e) 
		{
			Assert.fail("Element is not displyaed.");
		}
	}
	
	public void acceptAllCookies()
	{
		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
