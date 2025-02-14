package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Base64;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        // WebElement element= wd.findElement(By.xpath("/*[@class='navigation-link' and contains(@href,'/login')]"));

        click(By.xpath("//*[@href='/login?url=%2Fsearch']"));
        //click(By.xpath("//*[@href='/search']"));
    }

    public void fillLoginRegistrationform(String email, String password) {

        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);

    }

    public void fillLoginRegistrationform(User user) {

        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());

    }

    public void submit() {
        // click(By.xpath("//button[contains(text(),'Y’alla!')]"));
        click(By.xpath("//button[contains(text(),'alla!')]"));
    }

    public void submitOkButton() {

        if (isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));


    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }


    public String getMessage() {
        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();


    }
//Registration****************

    public void openRegistrationForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));
       //click(By.cssSelector("label[for='terms-of-use']"));

        JavascriptExecutor js=(JavascriptExecutor) wd;
        js.executeScript("document.\n" +
                "    querySelector('#terms-of-use').click();");

    }



}

