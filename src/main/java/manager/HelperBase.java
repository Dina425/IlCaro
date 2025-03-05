package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HelperBase {
    WebDriver wd;
    Logger logger= LoggerFactory.getLogger(HelperBase.class);

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void type(By locator, String text){
        WebElement element= wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if(text!=null) {
            element.sendKeys(text);
        }
    }
    public void clearNew(WebElement element){
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }
    public void click(By locator){
        WebElement element= wd.findElement(locator);
        element.click();
    }
    public boolean isElementPresent(By locator){
        List<WebElement> list=wd.findElements(locator);
        return list.size()>0;
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public boolean isYallaButtonActive() {
       boolean res=isElementPresent(By.cssSelector("button[disabled]"));//1 var
        WebElement element=wd.findElement(By.cssSelector("button[type='submit']"));//2 var
        boolean result = element.isEnabled();
        return res;//return result
    }
    public void submit() {
        click(By.cssSelector("button[type='submit']"));
    }
    public String getMessage() {
        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();


    }
    public void getScreen(String link) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void clearTextBox(By locator){
        WebElement element= wd.findElement(locator);
        String os=System.getProperty("os.name");
        System.out.println(os);
        if(os.startsWith("Win")){
            element.sendKeys(Keys.CONTROL,"a");
        }else
            element.sendKeys(Keys.COMMAND,"a");


        element.sendKeys(Keys.DELETE);

    }


}


