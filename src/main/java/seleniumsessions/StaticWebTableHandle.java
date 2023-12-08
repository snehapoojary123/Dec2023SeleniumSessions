package seleniumsessions;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableHandle {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		System.out.println("Table header count: "+ getTableHeaderCount());
		
		List<String> companyNameList = getAllCompanyName();
		System.out.println(companyNameList);
		
		

	}
	
	public static int getTableHeaderCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//th")).size();
	}
	
	public static int getTableRowCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr")).size()-1;
	}
	
	public static int getTableColumnCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr/td")).size();
	}
	
	//*[@id="customers"]/tbody/tr[2]/td[1]
	
	public static List<String> getAllCompanyName() {
		
		List<String> cmpName = new ArrayList<String>();
		
		for(int i=2;i<=getTableRowCount(); i++) {
			
			String text = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td[1]")).getText();
			cmpName.add(text);
		}
		return cmpName;
		
	}
	

}
