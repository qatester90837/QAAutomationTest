
import org.testng.annotations.Test;
import qa.object.BaseTest;
import qa.object.Page.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void when_OpeningTheWebsite_Expect_LoginPageShouldAppear () {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
    }

    @Test
            (dependsOnMethods = "when_OpeningTheWebsite_Expect_LoginPageShouldAppear")
    public void when_LoginCorrectUsername_Expect_SuccessLogin () throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage()
                .loginUsername("eduardvizcarra006@gmail.com");
    }

    @Test
            (dependsOnMethods = "when_LoginCorrectUsername_Expect_SuccessLogin")
    public void when_LoginCorrectPassword_Expect_SuccessLogin () throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage()
                .loginUsername("eduardvizcarra006@gmail.com")
                .loginPassword("Asdf1234**");
    }

    @Test
            (dependsOnMethods = "when_OpeningTheWebsite_Expect_LoginPageShouldAppear")
    public void when_LoggingIncorrectUsername_Expect_Error () throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage()
                .verifyLoginUserName("test");
    }

    @Test
            (dependsOnMethods = "when_LoggingIncorrectUsername_Expect_Error")
    public void when_LoggingIncorrectPassword_Expect_Error () throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage()
                .loginUsername("eduardvizcarra006@gmail.com")
                .verifyLoginPassword("test");
    }
}
