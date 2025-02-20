package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

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

    public void submitYalla() {
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
        if(!wd.findElement(By.id("terms-of-use")).isSelected()) {

            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.\n" +
                    "    querySelector('#terms-of-use').click();");
        }

    }
    public void checkPolicyXY(){
        WebElement label=wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rectangle= label.getRect();
        int w=rectangle.getWidth();
        int xOffset=-w/2;

        Dimension size=wd.manage().window().getSize();// size of screen
        Actions actions = new Actions(wd);
        actions.moveToElement(label,xOffset, 0).click().release().perform();



    }


    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationform(user);
        submitYalla();
        submitOkButton();

    }
}

