package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    HelperCar helperCar;

    public void init(){
        wd=new ChromeDriver();

        Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
        logger.info("All tests run in Chrome Browser");
        //wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.web.app/search");
        logger.info("The link--->"+wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        helperCar=new HelperCar(wd);

    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public void stop(){
        wd.quit();

    }
    public HelperCar getHelperCar() {
        return helperCar;
    }


}

