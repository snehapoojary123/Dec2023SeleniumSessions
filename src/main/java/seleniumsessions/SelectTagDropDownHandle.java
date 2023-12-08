package seleniumsessions;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectTagDropDownHandle {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		String browser = "chrome";
		BrowserUtil brutil = new BrowserUtil();
		driver = brutil.initializeDriver(browser);
		driver.get("https://www.orangehrm.com/en/30-day-free-trial/");
		
		By country = By.id("Form_getForm_Country");
		
		//doSelectById(country, 4);
		
		// doSelectByValue(country, "Belgium");
		
		//doSelectByVisibleText(country, "India");
		
//		Select select = new Select(driver.findElement(country));
//		List<WebElement> optionlist = select.getOptions();
//		System.out.println("Size:" + optionlist.size());
//		
//		for(WebElement e: optionlist) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
		int size = doTotaltSelectOptionList(country);
		System.out.println(size-1);
		List<String> countrylist = getSelectOptionListText(country);
		System.out.println(countrylist);
		
		List<String> expectedCountryList = Arrays.asList("India","Belgium","Austria");
		
		if(getSelectOptionListText(country).containsAll(expectedCountryList)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		selectOptionListByVaue(country, "brazil");
		
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectById(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static  List<WebElement> getSelectOptionList(By locator){
		Select select = new Select(getElement(locator));
		List<WebElement> optionlist = select.getOptions();
		return optionlist;
		
	}
	
	public static  int doTotaltSelectOptionList(By locator){
		return getSelectOptionList(locator).size();
		
	}
	
	public static List<String> getSelectOptionListText(By locator) {
		List<String> texList = new ArrayList<String>();
		List<WebElement> optionlist = getSelectOptionList(locator);
		for(WebElement e: optionlist) {
			String text = e.getText();
			texList.add(text);
			
		}
		return texList;
		
	}
	
	public static void selectOptionListByVaue(By locator, String expValue) {
		List<WebElement> optionlist = getSelectOptionList(locator);
		for(WebElement e: optionlist) {
			String text = e.getText();
			if(text.equalsIgnoreCase(expValue)) {
				e.click();
				break;
			}
		}
	}
	

}
