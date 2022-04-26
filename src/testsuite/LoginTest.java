package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith");
        sendTextToElement(By.xpath("//input[@id='password']"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = getTextFromElement(By.xpath("//h4[@class='subheader']"));
        Assert.assertEquals("securearea text is not displayed", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        sendTextToElement(By.id("username"),"tomsmith1");
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        String expected = "Your username is invalid!" +
                "×";
        String actualResult = getTextFromElement(By.linkText("flash"));
        Assert.assertEquals("varify username", expected, actualResult);
    }

@Test
public void verifyThePasswordErrorMessage() {
    sendTextToElement(By.id("username"),"tomsmith");
    sendTextToElement(By.id("password"),"SuperSecretPassword");
    clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
    String expected = "Your password is invalid!" +
            "×";
    String actualResult = getTextFromElement(By.xpath("//div[@id='flash']"));
    Assert.assertEquals("varify password", expected, actualResult);
}
    @After
    public void closeBrowser(){
    }
}

