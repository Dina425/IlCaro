package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm(){

        click(By.xpath("/*[@class='navigation-link' and contains(@href,'/login')]"));
    }
    public void fillLoginRegistrationform(String email, String password) {

        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);

    }

    public void submitLogin(){
        click(By.xpath("//button[contains(text(),'Y’alla!')]"));
    }
    public void submitOkButton(){
        click(By.xpath("//button[normalize-space()='Ok']"));
    }
    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
    }
    public void logout() {
        click(By.xpath("//a[normalize-space()='Logout']"));
    }


}
