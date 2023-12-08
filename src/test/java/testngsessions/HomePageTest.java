package testngsessions;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

	// global pre conditions
	// pre conditions
	// test cases -- steps-- act vs expected -- assertions
	// post condition
	// global post condition

	
	/*
	 * BS -startDBConnection
BT -createUser
BC -launchBrowser
BM -login
homePageSearchTest
AM -logout
BM -login
homePageTitleTest
AM -logout
BM -login
homePageURLTest
AM -logout
AC -closeBrowser
AT -deleteUser
AS- closeDBConnection
	 */
	@BeforeSuite
	public void startDBConnection() {
		System.out.println("BS -startDBConnection");
	}

	@BeforeTest
	public void createUser() {
		System.out.println("BT -createUser");

	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC -launchBrowser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM -login");

	}
	
	@Test
	public void homePageTitleTest() {
		System.out.println("homePageTitleTest");
		
	}
	@Test
	public void homePageURLTest() {
		System.out.println("homePageURLTest");
		
	}
	@Test
	public void homePageSearchTest() {
		System.out.println("homePageSearchTest");
		
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM -logout");

	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -closeBrowser");
	}

	@AfterTest
	public void deleteUser() {
		System.out.println("AT -deleteUser");

	}
	
	@AfterSuite
	public void closeDBConnection() {
		System.out.println("AS- closeDBConnection");
	}

}
