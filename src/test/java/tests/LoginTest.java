package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        // if SignOut present---logout
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        //app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","@12345Ab");
        //app.getHelperUser().submitLogin();
       // app.getHelperUser().submitOkButton();


    }
}
