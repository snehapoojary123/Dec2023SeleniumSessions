package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {
		String browserName = "chrome";
		String exPageTitle ="Amazon.com. Spend less. Smile more.";
		String exPageURL ="amazon";
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.initializeDriver(browserName);
		brUtil.launchURL("https://www.amazon.com");
		String actualPageTitle = brUtil.getPageTitle();
		if(actualPageTitle.contains(exPageTitle)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		String actPageURL= brUtil.getPageURL();
		if(actPageURL.contains(exPageURL)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		//brUtil.closeBrowser();
		brUtil.quitBrowser();

	}

}
