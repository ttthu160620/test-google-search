package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static GoogleSearchPageObject getGooglePage(WebDriver driver) {
		return new GoogleSearchPageObject(driver);
	}
}
