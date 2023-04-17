package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * Write down the following test into ‘LoginTest’ class
     * 1. userShouldNavigateToLoginPageSuccessfully
     * click on the ‘Sign In’ link
     * Verify the text ‘Welcome Back!’
     */
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        WebElement signLink = driver.findElement(By.linkText("Sign In"));
        signLink.click();

        WebElement actualText = driver.findElement(By.xpath("//h2[contains(text(), 'Welcome Back')]"));
        String actual = actualText.getText();

        String expected = "Welcome Back!";
        Assert.assertEquals("Text message doesn't match", expected, actual);
    }

    /**
     * verifyTheErrorMessage
     * click on the ‘Sign In’ link
     * Enter invalid username
     * Enter invalid password
     * Click on Login button
     * Verify the error message ‘
     * Invalid email
     * or password.’
     */
    @Test
    public void verifyTheErrorMessage() {
        WebElement signLink = driver.findElement(By.linkText("Sign In"));
        signLink.click();

        WebElement enterInvalidEmail = driver.findElement(By.id("user[email]"));
        enterInvalidEmail.sendKeys("XYZ@gmail.com");

        WebElement enterInvalidPassword = driver.findElement(By.name("user[password]"));
        enterInvalidPassword.sendKeys("12365");

        WebElement clickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        clickLogin.click();

        WebElement actualErrorMessage = driver.findElement(By.cssSelector("li.form-error__list-item"));
        String actual = actualErrorMessage.getText();

        String expected = "Invalid email or password.";
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
