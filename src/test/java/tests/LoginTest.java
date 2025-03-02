package tests;


import models.User;

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
        logger.info("Before method finished logout");
    }

    @Test
    public void loginSuccess(){
        logger.info("Start test with name loginSuccess");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("sonicboom@gmail.com","Snow123456!");
        app.getHelperUser().submit();
        logger.info("Test data--> email:sonicboom@gmail.com & password:Snow123456!");

      Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


    }
    @Test
    public void loginSuccessMon(){
        User user = new User();
        user.setEmail("sonicboom@gmail.com").setPassword("Snow123456!");
        app.getHelperUser().pause(1000);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);

        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("sonicboomgmail.com","Snow123456!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void loginEmptyEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("","Snow123456!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());


    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("sonicboom@gmail.com","Snow123456");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

    }
    @Test
    public void loginEmptyPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("sonicboom@gmail.com","");
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().pause(3000);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().pause(3000);
        app.getHelperUser().fillLoginRegistrationform("sonicboom1234@gmail.com","Snow123456");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

    }


    @AfterMethod
    public void postCondition(){
        app.getHelperUser().submitOkButton();
    }


}
