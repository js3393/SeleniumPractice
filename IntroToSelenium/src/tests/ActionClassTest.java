package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

public class ActionClassTest {
    public static void main(String[] args){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.com");

        actionTest(driver);
    }
    public static void actionTest(WebDriver d){
        Actions a = new Actions(d);

        By searchBox = By.id("twotabsearchtextbox");
        By hoverSignIn =
                By.id("nav-link-accountList");
        By signInBtn = By.cssSelector("div[id='nav-flyout-ya-signin'] span[class='nav-action-inner']");

        WebElement search = WaitUtils.waitForVisible(d, searchBox);

        a.moveToElement(search)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .keyUp(Keys.SHIFT)
                .perform();

        a.moveToElement(d.findElement(hoverSignIn))
                .build()
                .perform();
        WaitUtils.waitForVisible(d, signInBtn);
        d.findElement(signInBtn).click();

    }
}
