package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {

	WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");

	}

	@Test
	public void homePageTitleTest() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expTitle = "Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(actualTitle, expTitle);
	}
	@Test
	public void searchExistsTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@Test
	public void helpExistsTest() {
		boolean flag = driver.findElement(By.xpath("//a[text()='Help']")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
