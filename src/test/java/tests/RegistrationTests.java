package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }
    @Test
    public void registrationSuccess(){
        Random randome=new Random();
        int i=randome.nextInt(1000);
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z=(int) ((System.currentTimeMillis()/1000)%3600);
        System.out.println(z);
        User user=new User()
                .setFirstName("Liza")
                .setLastName("Snow")
                .setEmail("snow"+i+"@gmail.com")
                .setPassword("Snow123456@");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");

    }
    @Test
    public void registrationWrongEmail(){
        Random randome=new Random();
        int i=randome.nextInt(1000);

        User user=new User()
                .setFirstName("Liza")
                .setLastName("Snow")
                .setEmail("snow"+i+"gmail.com")
                .setPassword("Snow123456@");
        app.getHelperUser().pause(1000);
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format\n" +
                "Wrong email format");
        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void registrationWrongPassword(){
        Random randome=new Random();
        int i=randome.nextInt(1000);

        User user=new User()
                .setFirstName("Liza")
                .setLastName("Snow")
                .setEmail("snow"+i+"@gmail.com")
                .setPassword("S");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();

        app.getHelperUser().submit();


        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");

        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void registrationEmptyEmail(){
        Random randome=new Random();
        int i=randome.nextInt(1000);

        User user=new User()
                .setFirstName("Liza")
                .setLastName("Snow")
                .setEmail("")
                .setPassword("Snow123456@");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();

        app.getHelperUser().submit();


        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");

        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void registrationEmptyPassword(){
        Random randome=new Random();
        int i=randome.nextInt(1000);

        User user=new User()
                .setFirstName("Liza")
                .setLastName("Snow")
                .setEmail("snow"+i+"@gmail.com")
                .setPassword("");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();

        app.getHelperUser().submit();


        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");

        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void registrationEmptyFName(){
        Random randome=new Random();
        int i=randome.nextInt(1000);

        User user=new User()
                .setFirstName("")
                .setLastName("Snow")
                .setEmail("snow"+i+"@gmail.com")
                .setPassword("Snow123456@");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();

        app.getHelperUser().submit();


        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");

        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void registrationEmptyLName(){
        Random randome=new Random();
        int i=randome.nextInt(1000);

        User user=new User()
                .setFirstName("Sara")
                .setLastName("")
                .setEmail("snow"+i+"@gmail.com")
                .setPassword("Snow123456@");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();

        app.getHelperUser().submit();


        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");

        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }
    @Test
    public void registrationEmptyCheckBox(){
        Random randome=new Random();
        int i=randome.nextInt(1000);

        User user=new User()
                .setFirstName("Sara")
                .setLastName("Snow")
                .setEmail("snow"+i+"@gmail.com")
                .setPassword("Snow123456@");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);


        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());

    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().submitOkButton();
    }
}
