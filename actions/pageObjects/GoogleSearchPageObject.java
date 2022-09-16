package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commons.BasePage;
import googlePageUIs.GooglePageUIs;

public class GoogleSearchPageObject extends BasePage{
	private WebDriver driver;

	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToSearchTextbox(String searchValue) {
		waitForElementVisible(driver, GooglePageUIs.SEARCH_TEXTBOX);
		senkeyToElement(driver, GooglePageUIs.SEARCH_TEXTBOX, searchValue);
	}
	
	public void enterToSearchTextbox(Keys control) {
		waitForElementVisible(driver, GooglePageUIs.SEARCH_TEXTBOX);
		senkeyKeyToElement(driver, GooglePageUIs.SEARCH_TEXTBOX, control);
	}
	
	public void pressEnter() {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.ENTER).perform();
	}
	
	public List<String> getSearchResultTitle(){
		//isLoadPageSuccess(driver);
		ArrayList<String> listResultTitleText = new ArrayList<String>();
		List<WebElement> list = getListWebElements(driver, GooglePageUIs.SEARCH_TITLE);
		for(WebElement title : list) {
			listResultTitleText.add(title.getText());
			System.out.println("Title:" + title.getText());
		}
		return listResultTitleText;
	}
	
	public List<String> getSearchResultVideo(){
		//isLoadPageSuccess(driver);
		ArrayList<String> listResultTitleVideo = new ArrayList<String>();
		List<WebElement> list = getListWebElements(driver, GooglePageUIs.SEARCH_VIDEO);
		for(WebElement title : list) {
			listResultTitleVideo.add(title.getText());
			System.out.println("Title Video:" + title.getText());
		}
		return listResultTitleVideo;
	}
}
