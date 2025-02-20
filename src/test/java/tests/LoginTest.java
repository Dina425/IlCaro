package tests;

import models.Car;
import models.User;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
        app.getHelperUser().submitYalla();

      Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


        //app.getHelperUser().submitOkButton();
        //Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginSuccessMon(){
        User user = new User();
        user.setEmail("bazhenovadina321@gmail.com").setPassword("@12345Ab");
        app.getHelperUser().pause(1000);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);

        app.getHelperUser().submitYalla();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


        //app.getHelperUser().submitOkButton();
        //Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321gmail.com","@12345Ab");
        app.getHelperUser().submitYalla();
        //Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector(".error")));
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void loginEmptyEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("","@12345Ab");
        app.getHelperUser().submitYalla();
        //Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector(".error")));
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());


    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","@2345A");
        app.getHelperUser().submitYalla();
        //Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector(".message")));
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

    }
    @Test
    public void loginEmptyPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","");
        app.getHelperUser().submitYalla();
        //Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector(".error")));
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().pause(3000);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().pause(3000);
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina31@gmail.com","@12345Ab");
        app.getHelperUser().submitYalla();
        //Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector(".error")));
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

    }


    @AfterMethod
    public void postCondition(){
        app.getHelperUser().submitOkButton();
    }


}
