package googleSearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.GoogleSearchPageObject;
import pageObjects.PageGeneratorManager;

public class GoogleSearch extends BaseTest{
	
	WebDriver driver;
	GoogleSearchPageObject googlePage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		googlePage = PageGeneratorManager.getGooglePage(driver);
	}
	
	@Test
	public void Google_Search() {
		googlePage.inputToSearchTextbox("Demo with selenium");
		googlePage.enterToSearchTextbox(Keys.ENTER);
		
		List<String> listTitle = googlePage.getSearchResultTitle();
		for(String title : listTitle) {
			Assert.assertTrue(title.contains("Selenium"));
		}
		
		List<String> listVideo = googlePage.getSearchResultVideo();
		for(String title : listVideo) {
			Assert.assertTrue(title.contains("Selenium"));
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
