package co.harvey.pages;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import co.harvey.generic.BasePage;


public class HarveyNormanPage extends BasePage
{
	@FindBy(name = "q")
	public WebElement searchBox;
	
	@FindBy(xpath = "(//button[@title='Search'])[1]")
	public WebElement searchButton;
	
	@FindBy(xpath = "//span[@class='highlighted font-bold']")
	public List<WebElement> allSuggestions;
	
	@FindBy(xpath = "//div[@id='search-results-products-wrapper']//div[contains(@id,'product-card')]")
	public List<WebElement> productSearchResults; 
	
	@FindBy(xpath = "//span[text()='Browse all categories']")
	public WebElement browseAllCategoriesDrownDown;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Bedroom']")
	public WebElement bedroomLink;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Mattresses']")
	public WebElement MattressesLink;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Sofas']")
	public WebElement sofasLink;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Dining Furniture']")
	public WebElement diningFurnitureLink;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Outdoors']")
	public WebElement OutdoorsLink;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Occasional Furniture']")
	public WebElement occasionalFurnitureLink;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Home Office']")
	public WebElement homeOfficeLink;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Cabinets & Storage']")
	public WebElement cabinetsAndStorageLink;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Homeware']")
	public WebElement homewareLink;
	
	@FindBy(xpath = "//li[@class='inline hover:underline']//a[text()='Clearance']")
	public WebElement clearanceLink;
	
	@FindBy(xpath = "//div[@class='swiper banner-slider swiper-initialized swiper-horizontal swiper-backface-hidden']//a//img[@alt='web banner']")
	public List<WebElement> banners;
	
	public HarveyNormanPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductSearch(String item)
	{
		searchBox.sendKeys(item);
	}

	public void clickOnSearchButton() throws Exception
	{
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

//		searchButton.click();
		
	}
	
	public void verifySearchResult()
	{
		int count = productSearchResults.size();
		if(count>0)
		{
			Reporter.log(count +" results are displayed.",true);
		}else {
			Reporter.log("0 results displyaed.",true);
		}
	}
	
	public void verifyBanners()
	{
		int count = banners.size();
		Reporter.log("Total number of banners:"+count,true);
		for(int i=0;i<count;i++)
		{
			try {
				WebElement banner = banners.get(i);
				if(banner.isDisplayed())
				{
					Reporter.log("Banner "+(i+1)+" is present.",true);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}


