package tests;

import models.Car;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {
    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged())
            app.getHelperUser().login(new User().setEmail("bazhenovadina321@gmail.com").setPassword("@12345Ab"));
    }



@Test
public void addNewCarSuccess(){
    int i = (int)((System.currentTimeMillis()/1000)%3600);
    Car car= Car.builder()
            .location("Tel Aviv, Israel")
            .manufacture("Mazda")
            .model("Cx7")
            .year("2024")
            .fuel("Diesel")
            .seats(4)
            .carClass("C")
            .carRegNumber("678-0099-"+i)
            .price(50.)
            .about("My car")
            .build();
    app.getHelperCar().openCarForm();
    app.getHelperCar().fillCarForm(car);
    app.getHelperCar().submitCarForm();

}

}
