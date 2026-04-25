package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class DropDownPractice {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		runDropDownTest(driver);
		
	}
	public static void runDropDownTest(WebDriver driver) throws InterruptedException {
		//Uncomment below if you want to run this class by itself
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		//clicking the radio button for round trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		
		//Select by the option text in the from column 
		//dropdown.selectByVisibleText("AED");
		//System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//select by value. To know value see what the attribute equals from the to column
		//dropdown.selectByValue("INR");
		//System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		
		//
		driver.findElement(By.id("divpaxinfo")).click();
		WaitUtils.wait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt")));
		
		int repeatClick = 3;
		for(int i = 0; i < repeatClick; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Use assert to make sure we get correct adults. Purposely failed here to see error message
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//Dynamic dropdown with indexes
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value= 'BKK']")).click();
		//Needs a second to load the to dynamic dropdown
		WaitUtils.wait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DXB']")));
		//Using xpath index to get to the second window (from window to to window)
			//driver.findElement(By.xpath("(//a[@value='DXB'])[2]")).click();
		
		//Using parent of second window (to) and child to select value in second window 
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DXB']")).click();
		
		//dropdown with select tagname - static 
				WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				Select dropdown = new Select(staticDropDown);
				
				dropdown.selectByIndex(3);
				System.out.println(dropdown.getFirstSelectedOption().getText());
		
	}

}
