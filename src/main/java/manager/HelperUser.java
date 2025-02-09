package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Base64;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm(){
       // WebElement element= wd.findElement(By.xpath("/*[@class='navigation-link' and contains(@href,'/login')]"));

        click(By.xpath("//*[@href='/login?url=%2Fsearch']"));
        //click(By.xpath("//*[@href='/search']"));
    }
    public void fillLoginRegistrationform(String email, String password) {

        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);

    }

    public void submitLogin(){
        // click(By.xpath("//button[contains(text(),'Y’alla!')]"));
        click(By.xpath("//button[contains(text(),'alla!')]"));
    }
    public void submitOkButton(){
        click(By.xpath("//button[text()='Ok']"));
    }
    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
    }
    public void logout() {
        click(By.xpath("//a[normalize-space()='Logout']"));
    }


    public String getMessage() {
        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();

    }
}
