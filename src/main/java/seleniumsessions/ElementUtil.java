package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	// In Utils WebDriver should be private to avoid null
	// Class variable String default value in null
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		// local to class
	}

	public WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public WebElement getElement(By locator, int timeout) {

		return waitForElementVisibility(locator, timeout);

	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);

	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String getElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsEmenlenyDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public String getElementAttribute(By locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}

	public void getOfElementAttributeList(By locator, String attribute) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String attrvalue = e.getAttribute(attribute);
			System.out.println(attrvalue);

		}

	}

	public int getTotalElementCount(By locator) {

		int elecount = getElements(locator).size();
		System.out.println("Total elements for locator- " + locator + " is- " + elecount);
		return elecount;
	}

	public List<String> getElementsTextList(By locator) {
		List<String> elementText = new ArrayList<String>();
		List<WebElement> textlist = getElements(locator);
		for (WebElement e : textlist) {
			elementText.add(e.getText());
		}
		return elementText;
	}

	public void doSelectById(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public List<WebElement> getSelectOptionList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionlist = select.getOptions();
		return optionlist;

	}

	public int doTotaltSelectOptionList(By locator) {
		return getSelectOptionList(locator).size();

	}

	public List<String> getSelectOptionListText(By locator) {
		List<String> texList = new ArrayList<String>();
		List<WebElement> optionlist = getSelectOptionList(locator);
		for (WebElement e : optionlist) {
			String text = e.getText();
			texList.add(text);

		}
		return texList;

	}

	public void selectOptionListByVaue(By locator, String expValue) {
		List<WebElement> optionlist = getSelectOptionList(locator);
		for (WebElement e : optionlist) {
			String text = e.getText();
			if (text.equalsIgnoreCase(expValue)) {
				e.click();
				break;
			}
		}
	}

	public void selectDropdownByValue(By locator, String expValue) {
		List<WebElement> dropdownlist = getElements(locator);
		for (WebElement e : dropdownlist) {
			String text = e.getText();
			// System.out.println(text);
			if (text.equalsIgnoreCase(expValue)) {
				e.click();
				break;
			}
		}

	}

	public void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).build().perform();
	}

	public void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).build().perform();

	}

	// wait util section
	public WebElement waitForElementPresence(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public List<WebElement> waitForElementsPresence(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param seconds
	 * @return
	 */
	public WebElement waitForElementVisibility(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public List<WebElement> waitForElementsVisibility(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public String waitForTitleContainsAndFetch(int timeout, String titleFractionValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleContains(titleFractionValue));
		return driver.getTitle();
	}

	public String waitForTitleISAndFetch(int timeout, String titleValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}

	public String waitForURLContainsAndFetch(int timeout, String urlFractionValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlContains(urlFractionValue));
		return driver.getCurrentUrl();
	}

	public String waitForURLMatchesAndFetch(int timeout, String urlValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlMatches(urlValue));
		return driver.getCurrentUrl();
	}

	public String waitForURLToBeAndFetch(int timeout, String urlValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlToBe(urlValue));
		return driver.getCurrentUrl();
	}

	// Alert Utilities
	public Alert waitForAlertPresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public String getAlertText(int timeout) {
		return waitForAlertPresent(timeout).getText();

	}

	public void acceptAlert(int timeout) {
		waitForAlertPresent(timeout).accept();
		;

	}

	public void dismissAlert(int timeout) {
		waitForAlertPresent(timeout).dismiss();
		;

	}

	public void enterPromptText(int timeout, String value) {
		waitForAlertPresent(timeout).sendKeys(value);

	}

	// frame utils
	public void waitForFrameAndSwitchByIdOrName(int timeout, String IdOrName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdOrName));

	}

	public void waitForFrameAndSwitchByIndex(int timeout, int farmeIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(farmeIndex));

	}

	public void waitForFrameAndSwitchByFrameElement(int timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

	}

	public void waitForFrameAndSwitchByLocatort(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));

	}

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param timeout
	 * @param locator
	 */
	public void clickWhenReady(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement waitForElementToBeClickable(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void doClickWIthActionsAndWait(int timeout, By locator) {
		waitForElementToBeClickable(timeout, locator);
		Actions act = new Actions(driver);
		act.click().build().perform();

	}
	
	public WebElement waitForElementPresentWithFluentWait(int timeOut, int pollingInterval, By locator) {
		
		 Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(timeOut))
				 .ignoring(NoSuchElementException.class)
				 .ignoring(StaleElementReferenceException.class)
				 .pollingEvery(Duration.ofSeconds(pollingInterval))
				 .withMessage("Element not found..");
		 
		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public void waitForAlertPresentWithFluentWait(int timeOut, int pollingInterval) {
		
		 Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(timeOut))
				 .ignoring(NoAlertPresentException.class)
				 .pollingEvery(Duration.ofSeconds(pollingInterval))
				 .withMessage("Element not found..");
		 
		 wait.until(ExpectedConditions.alertIsPresent());
		
	}

}
