package tests;

import models.User;
import org.openqa.selenium.By;
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
        User user = new User();
        user.setEmail("bazhenovadina321@gmail.com").setPassword("@12345Ab");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);

        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


        //app.getHelperUser().submitOkButton();
        //Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321gmail.com","@12345Ab");
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector(".error")));

    }
    @Test
    public void loginEmptyEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("","@12345Ab");
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector(".error")));

    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","@2345A");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector(".message")));

    }
    @Test
    public void loginEmptyPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector(".error")));

    }


    @AfterMethod
    public void postCondition(){
        app.getHelperUser().submitOkButton();
    }


}
