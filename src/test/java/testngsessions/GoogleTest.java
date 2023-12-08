package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class GoogleTest extends BaseTest{
	

	@Test(priority=1)
	public void homePageTitleTest() {
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expTitle = "Google";
		Assert.assertEquals(actualTitle, expTitle);
	}
	@Test(priority = 2)
	public void searchExistsTest() {
		boolean flag = driver.findElement(By.id("APjFqb")).isDisplayed();
		Assert.assertTrue(flag);
	}
	

	
}
