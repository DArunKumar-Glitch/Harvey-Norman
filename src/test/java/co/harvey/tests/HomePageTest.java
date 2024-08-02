package co.harvey.tests;

import org.testng.annotations.Test;

import co.harvey.generic.BaseTest;
import co.harvey.pages.HarveyNormanPage;

public class HomePageTest extends BaseTest
{
	@Test(priority = 1)
	public void testHomePage()
	{
		HarveyNormanPage harveyNormanPage = new HarveyNormanPage(driver);
		
		//Accept Cookies
		harveyNormanPage.acceptAllCookies();
		
		//verify Harvey Norman Page is displayed or not
		harveyNormanPage.verifyPageDisplayed("Harvey Norman");
		
		//verify search box is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.searchBox);
		
		//Verify search button is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.searchButton);
	
		//Verify browseAllCategoriesDrownDown is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.browseAllCategoriesDrownDown);

		//Verify bedroomLink is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.bedroomLink);

		//Verify MattressesLink is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.MattressesLink);

		//Verify sofa link is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.sofasLink);

		//Verify dining furniture is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.diningFurnitureLink);

		//Verify outdoors is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.OutdoorsLink);

		//Verify occasional furniture is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.occasionalFurnitureLink);

		//Verify home office link is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.homeOfficeLink);

		//Verify cabinets and storage link is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.cabinetsAndStorageLink);

		//Verify home ware is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.homewareLink);

		//Verify clearance link is present
		harveyNormanPage.verifyElementIsPresent(harveyNormanPage.clearanceLink);
		
		//Verify banner is present
		harveyNormanPage.verifyBanners();
	}
	
	@Test(priority = 2)
	public void searchProduct() throws Exception{
		HarveyNormanPage harveyNormanPage = new HarveyNormanPage(driver);
		harveyNormanPage.acceptAllCookies();
		harveyNormanPage.enterProductSearch("Sofa");
		harveyNormanPage.clickOnSearchButton();
		harveyNormanPage.acceptAllCookies();
		harveyNormanPage.verifySearchResult();
	}
}
