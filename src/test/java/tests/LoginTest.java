package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        //if SignOut present---logout
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","@12345Ab");
        app.getHelperUser().submitLogin();

      Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

        //app.getHelperUser().submitOkButton();
        //Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginSuccessMon(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","@12345Ab");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

        //app.getHelperUser().submitOkButton();
        //Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().submitOkButton();
    }


}
