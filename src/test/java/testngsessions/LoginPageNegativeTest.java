package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest extends BaseTest {
	
	
	
	public boolean doLogin(String username, String password) {
		
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actError = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		System.out.println(actError);
		if(actError.contains("Warning")) {
			return true;
		}else {
			return false;
		}
	
		
		
	}
	
	@DataProvider
	public Object[][] loginTestData() {
		return new Object[][] {
			{"sdsd",""},
			{"","sasas"},
			{"jlksd","lihsdlh"},
			
		};
	}
	@Test(dataProvider = "loginTestData")
	public void LoginTest(String username, String password) {
		Assert.assertTrue(doLogin(username, password));
	}
	
	

}
