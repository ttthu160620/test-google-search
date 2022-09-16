package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	private By getByLocator(String xpathlocator) {
		return By.xpath(xpathlocator);
	}
	
	private WebElement getWebElement(WebDriver driver, String xpathlocator) {
		return driver.findElement(getByLocator(xpathlocator));
	}
	
	protected List<WebElement> getListWebElements(WebDriver driver, String xpathlocator) {
		return driver.findElements(getByLocator(xpathlocator));
	}
	
	protected void clickToElement(WebDriver driver, String xpathlocator) {
		getWebElement(driver, xpathlocator).click();
	}
	
	protected void senkeyToElement(WebDriver driver, String xpathlocator, String textValue) {
		WebElement element = getWebElement(driver, xpathlocator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected void senkeyKeyToElement(WebDriver driver, String xpathlocator, Keys textValue) {
		WebElement element = getWebElement(driver, xpathlocator);
		element.sendKeys(textValue);
	}
	
	protected String getElementText(WebDriver driver, String xpathlocator) {
		return getWebElement(driver, xpathlocator).getText();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String xpathlocator) {
		return getWebElement(driver, xpathlocator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	protected void waitForElementVisible(WebDriver driver, String xpathlocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathlocator)));
	}
	
	protected void waitForElementInVisible(WebDriver driver, String xpathlocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathlocator)));
	}
	
	protected void waitForClickable(WebDriver driver, String xpathlocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(xpathlocator)));
	}
	
	protected boolean isLoadPageSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active == 0)");
			}	
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return (Boolean) jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}	
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	
	private long longTimeout = 30;
	private long shortTimeout = 5;
}
