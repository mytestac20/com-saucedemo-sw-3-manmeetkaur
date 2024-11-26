package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LogInTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    //Set the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //Verify user should log in successfully.
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter username and password into email and password field.
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");

        //click on the login button
        clickOnElement(By.id("login-button"));


        //Verify the text “Products”
        String expectedResult = "Products";
        // String actualResult = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        String actualResult = getTextFromElement(By.xpath("//span[text()='Products']"));
        Assert.assertEquals("User is not log in successfully", expectedResult, actualResult);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username and password into email and password field.

        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");

        //click on the login button
        clickOnElement(By.id("login-button"));

        //Verify that six products are displayed on page
        List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        int expectedNoOfProduct = 6;

        Assert.assertEquals("six products are not displayed on the page", expectedNoOfProduct, productsList.size());

    }

    //close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }






}

