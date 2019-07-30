package qa.object.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Page Variables
    String baseURL = "https://bank.paysera.com/en/login";

    //Web Elements
    By usernameBy = By.name("userIdentifier");
    By passwordBy = By.name("password");
    By loginButtonBy = By.cssSelector("button[type='submit']");
    By errorMessageUsernameBy = By.xpath("//*[@id=\"react-app\"]/div[1]/div/div/div/div/div[2]/div/div");
    By errorMessagePasswordBy = By.xpath("//*[@id=\"login-methods-body-user_credentials\"]/div/form/div[1]");
    By passwordDropDown = By.xpath("//*[@id=\"login-methods-heading-user_credentials\"]/strong");

    //Open Login Page
    public LoginPage goToLoginPage() {
        driver.get(baseURL);
        return this;
    }

        //Check Login of Email address or Phone number
    public LoginPage loginUsername (String username) throws Exception{

        //Enter Email Address/Phone Number
        writeText(usernameBy, username);

        //Click Login Button
        click(loginButtonBy);

        Thread.sleep(4000);
        return this;
    }

    //Check Login Page
    public LoginPage loginPassword (String password) throws Exception{

        //Click Password Drop Down
        click(passwordDropDown);

        //Enter Password
        writeText(passwordBy, password);

        //Click Login Button
        click(loginButtonBy);

        Thread.sleep(4000);
        return this;
    }

    //Verify Username Condition
    public LoginPage verifyLoginUserName (String expectedText) throws Exception{
        //Enter wrong Email Address/Phone Number
        writeText(usernameBy, expectedText);

        //Click login button
        click(loginButtonBy);

        //Assert the error message
        waitVisibility(errorMessageUsernameBy);

        Thread.sleep(4000);
        return this;
    }

    //Verify Password Condition
    public LoginPage verifyLoginPassword (String expectedText) throws Exception {

        //Click Password Drop Down
        click(passwordDropDown);

        //Enter Password
        writeText(passwordBy, expectedText);

        //Click Login Button
        click(loginButtonBy);

        waitVisibility(errorMessagePasswordBy);

        Thread.sleep(4000);
        return this;
    }
}
