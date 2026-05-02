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
import org.testng.Assert;

public class AddItemsToCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

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
		//Test data where rahulshettyacademy will pass anything else should be invalid
	    String promoString = "rahulshettyacademy";

	    By cartIcon = By.xpath("//img[@alt='Cart']");
	    By checkoutBtn = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
	    By selectPromoTextbox = By.cssSelector("input.promoCode");
	    By applyBtn = By.cssSelector("button.promoBtn");
	    By promoInfo = By.cssSelector("span.promoInfo");
	    By placeOrder = By.xpath("//div[contains(@style, 'text')]/button[contains(text(), 'Place')]");

	    WaitUtils.wait(driver)
	        .until(ExpectedConditions.elementToBeClickable(cartIcon))
	        .click();

	    WaitUtils.wait(driver)
	        .until(ExpectedConditions.elementToBeClickable(checkoutBtn))
	        .click();

	    WaitUtils.wait(driver)
	        .until(ExpectedConditions.visibilityOfElementLocated(selectPromoTextbox))
	        .sendKeys(promoString);

	    driver.findElement(applyBtn).click();

	    WebElement promoMessage = WaitUtils.wait(driver)
	        .until(ExpectedConditions.visibilityOfElementLocated(promoInfo));

	    String promoText = promoMessage.getText();
	    String promoStyle = promoMessage.getAttribute("style");

	    System.out.println(promoText);
	    
	    //green = success, red = failure
	    if (promoStyle.contains("green")) {
	        Assert.assertEquals(promoText, "Code applied ..!");
	    } else if (promoStyle.contains("red")) {
	        Assert.assertEquals(promoText, "Invalid code ..!");
	    } else {
	        Assert.fail("Unexpected promo style: " + promoStyle + " with text: " + promoText);
	    }

	    WaitUtils.wait(driver)
	        .until(ExpectedConditions.elementToBeClickable(placeOrder))
	        .click();
		
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
