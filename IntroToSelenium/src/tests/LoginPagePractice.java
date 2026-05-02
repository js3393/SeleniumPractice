package tests;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginPagePractice {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Task: Automate Logging in to this web page: https://rahulshettyacademy.com/loginpagePractise/
		 * as a user with consultant tag. Click I agree to terms and conditions checkbox. 
		 * (username is rahulshettyacademy and Password is Learning@830$3mK2)
		 * After logging in, select all items to cart on screen then proceed to checkout
		 */
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--incognito");

		options.setExperimentalOption("prefs", Map.of(
		    "credentials_enable_service", false,
		    "profile.password_manager_enabled", false,
		    "profile.password_manager_leak_detection", false
		));

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		runLoginTest(driver);

	}
	
	public static void runLoginTest(WebDriver d) throws InterruptedException{
		d.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		d.findElement(By.id("password")).sendKeys("Learning@830$3mK2");
		d.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		By alertWindow = By.xpath("//div[@class='modal-footer justify-content-center']/button[@id='okayBtn']");
		WaitUtils.wait(d).until(ExpectedConditions.elementToBeClickable(alertWindow)).click();
		WebElement dropdown = d.findElement(By.xpath("//select[@class='form-control']"));
		Select selectConsultant = new Select(dropdown);
		selectConsultant.selectByValue("consult");
		d.findElement(By.id("terms")).click();
		d.findElement(By.id("signInBtn")).click();
		By nextPageElement = By.className("card-body");
		WaitUtils.wait(d).until(ExpectedConditions.visibilityOfElementLocated(nextPageElement));
		
		AddAllItemsToCart(d);
		
		By viewCart = By.cssSelector("a.nav-link.btn.btn-primary");
		By checkoutBtn = By.className("btn-success");
		
		d.findElement(viewCart).click();
		
		WaitUtils.wait(d).until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn)).click();
		
		By deliveryTextBox = By.id("country");
		By conditionsCheckBox = By.xpath("//label[@for='checkbox2']");
		By purchaseBtn = By.xpath("//input[@type ='submit']");
		String deliveryLocation = "USA";
		WaitUtils.wait(d).until(ExpectedConditions.visibilityOfElementLocated(deliveryTextBox)).sendKeys(deliveryLocation);
		
		d.findElement(conditionsCheckBox).click();		
		d.findElement(purchaseBtn).click();
		
		
		
	}
	public static void AddAllItemsToCart(WebDriver d) {
		//List of all cart items on current page
		//List<WebElement> appCards = d.findElements(By.cssSelector("app-card-list[class='row'"));
		List<WebElement> addBtn = d.findElements(By.xpath("//button[text()='Add ']"));
		
		for(int i = 0; i < addBtn.size(); i++) {
			addBtn.get(i).click();
		}
	}

}
