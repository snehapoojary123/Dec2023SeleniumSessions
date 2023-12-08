package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTestBM extends BaseTest{


	@Test(priority=1)
	public void homePageTitleTest() {
	
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expTitle = "Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(actualTitle, expTitle);
	}

	@Test(dependsOnMethods = "homePageTitleTest",priority=2)
	public void searchExistsTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(dependsOnMethods = "searchExistsTest",priority=2)
	public void helpExistsTest() {
		boolean flag = driver.findElement(By.xpath("//a[text()='Help']")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(expectedExceptions = Exception.class)
	public void exceptionTest() {
		int i = 9 / 0;
	}

	
}
