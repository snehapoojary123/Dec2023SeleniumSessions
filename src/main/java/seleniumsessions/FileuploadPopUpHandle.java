package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileuploadPopUpHandle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//tag type='file' should be present
		//AutoIT - for windows machine or Sikuli or Robot- not a stable a solution
		//can ask the developer to add a type='file'
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\sneha\\Downloads\\pom.xml");
		
		driver.findElement(By.xpath("//input[@value='Press']")).click();

	}

}
