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
        
        //Use various methods from the Action class to move the mouse over
        actionTest(driver);
    }
    public static void actionTest(WebDriver d){
        Actions a = new Actions(d);

        By searchBox = By.id("twotabsearchtextbox");
        By hoverSignIn =
                By.id("nav-link-accountList");
        By signInBtn = By.cssSelector("div[id='nav-flyout-ya-signin'] span[class='nav-action-inner']");

        WebElement search = WaitUtils.waitForVisible(d, searchBox);
        
        
        //Moves the mouse to textbox element, click on it, type in text box, double click to highlight text
        a.moveToElement(search)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .doubleClick()
                .keyUp(Keys.SHIFT)
                .perform();
        
        //move mouse to element that automatically drops down a list, click on an element from the list.
        //context click will right click an element
        a.moveToElement(d.findElement(hoverSignIn))
        		.contextClick()
                .build()
                .perform();
        WaitUtils.waitForVisible(d, signInBtn); 
        d.findElement(signInBtn).click();
        
        //Drag and drop
        a.moveToElement(d.findElement(hoverSignIn))
        		.dragAndDrop(search, search);
    }
    
}
