package seleniumsessions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomXpathConcept {

	public static void main(String[] args) {
		// xpath is address of element in dom
		//absolute xpath: starting from top of DOM to the element
		//absolute is risky because if the UI changes then the code will break
		//relative xpath: custom xpath bases on properties
		
		//tag[@attribute='value']
		//tag[@attribute='value' and @attrubute2 ='value']
		//tag[@attribute='value' or @attrubute2 ='value']
		
		//tag[text()='value']
		
		//text with attribute
		
		//a[text()='value' and @id='value']
		
		//contains ---//tag[contains(@attr,'value')],  //tag[contains(text(),'value')]
		
		//containwith att and other without attr
		
		//tag[contains(@attr,'value') and @attr2='value']
		
		//dynamic attribute = value keeps changing e.g id - abc_1, abc_2,abc_3
		//use cusom xpath and custom waits e.guse contains //tag[contains(@attr,'abc_')]
		
		//starts-with
		//tag[starts-with(@attr,'value')]   , tag[starts-with(text(),'value')]
		
		//indexing - capture group = e.g to pick second value (//input[@class='form-control'])[2] or (//input[@class='form-control'])[position()=1]
		
		//to go to last element
		//(//input[@class='form-control'])[last()]
		
		//to go to second last element
				//(//input[@class='form-control'])[last()-1]
		
		//last link of last footer section in amazon =  //div[@class='navFooterLinkCol navAccessibility'][last()]//a[text()='Help']
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		By lasthelplink = By.xpath("((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]");
		WebElement help =driver.findElement(lasthelplink);
		if(help.getText().equalsIgnoreCase("help")) {
			System.out.println("Pass");
		}
	//	System.out.println(driver.getTitle());
		
		//child to parent traversing
		//e.g //label[@for='input-email']/..//..
		
		//sibling
		//preceding-sibling::tag and following-sibling::tag
		//e.g //label[@for='input-email']/following-sibling::input e.g //input[@type='text']/preceding-sibling::label
		
		// //label[@for='input-email']/following-sibling::input[@type='text']
		
		
		// //a[text()='shweeta poojary']/parent::td/preceding-sibling::td/input[@type='checkbox']
		
		// //a[text()='shweeta poojary']/parent::td/following-sibling::td/a[@_name='here']
		
		// parent, ancestor 
	}

}
