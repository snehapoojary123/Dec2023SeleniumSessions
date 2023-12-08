package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.id("datepicker")).click();
		
		
		//System.out.println(monthyr);
		
		
		//selectDay("21");
		//selectCalendarDay("30");
		
		selectCalendarDate("April 2024", "20");
		
		

	}
	
	public static void selectDay(String day) {
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
		
	}
	
	public static void selectCalendarDay(String day) {
		List<WebElement> daysList = driver.findElements(By.cssSelector("table.ui-datepicker-calendar a"));
		for(WebElement e: daysList) {
			String text = e.getText();
			if(text.equalsIgnoreCase(day)) {
				e.click();
				break;
			}
		}
	}
	
	public static void selectCalendarDate(String mmyy, String day) {
		if(mmyy.contains("February") && Integer.parseInt(day) >29) {
			System.out.println("Please pass the right day for february");
		}
		if(Integer.parseInt(day) >31) {
			System.out.println("Please pass the right day for the month");
		}
		
		
		String monthyr = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		while(!monthyr.equalsIgnoreCase(mmyy)) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			monthyr = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
			
		}
		selectDay(day);
		
	}
	//div.DayPicker-Month div.DayPicker-Day--disabled:not(.DayPicker-Day--outside) -- disabled
	//div.DayPicker-Day:not(.DayPicker-Day--disabled):not(.DayPicker-Day--outside) -- enabled
	
	//div.DayPicker-Day--selected:not(.DayPicker-Day--outside) -- current date

}
