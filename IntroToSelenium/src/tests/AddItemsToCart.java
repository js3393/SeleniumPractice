package tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class AddItemsToCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		runGreenKartTest(driver);

	}

	public static void runGreenKartTest(WebDriver driver) throws InterruptedException {

		// Array of required items to add to cart
		String[] cartItemReq = { "Cucumber", "Brocolli", "Cauliflower" };
		// list of all product names as web element
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// List every button associated with each product name
		List<WebElement> addButton = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

		searchForItems(cartItemReq, products, addButton);
		checkout(driver);

	}
	
	public static void checkout(WebDriver driver) throws InterruptedException {
		//click cart image. Might need to add a wait time

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		//click proceed to checkout

		WaitUtils.wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']"))).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		
		//Type in the promo code

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rashulshettyacademy");
		//click apply button
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Grab the text that appears after apply button clicked
		WaitUtils.wait(driver).until(ExpectedConditions.textMatches(By.cssSelector(".promoInfo")), "Code applied ..!");

		//click place order
		driver.findElement(By.xpath("//div[contains(@style, 'text')]/button[contains(text(), 'Place')]")).click();
		
		
	}

	public static void searchForItems(String[] items, List<WebElement> prod, List<WebElement> button) {
		int itemsAdded = 0;
		// convert items to a list for easy traversal.
		List<String> cartItems = Arrays.asList(items);

		// check whether name you extracted is present in arrayList
		for (int i = 0; i < prod.size(); i++) {

			// Get each product name at specific index, there should be 2 indexes
			// per split. Ex. "Broccoli " at product[0] and product[1] = " 1 kg"
			String[] productName = prod.get(i).getText().split("-");
			// take first index and trim the white space
			String formattedName = productName[0].trim();
			// convert cartItemReq to an array list for easy search

			if (cartItems.contains(formattedName)) {
				System.out.println(formattedName + " added to cart");
				// gets the "Add to cart" button at specific index and click
				button.get(i).click();
				// Increment each time we enter loop up to cart size
				itemsAdded++;

				// Once all items in cart is found, exit loop to prevent out of bounds index
				if (itemsAdded == cartItems.size()) {
					break;
				}
			}
		}
	}

}
