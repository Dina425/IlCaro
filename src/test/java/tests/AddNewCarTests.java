package tests;

import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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
    app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
    app.getHelperCar().submit();
//    Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
//    Assert.assertTrue(app.getHelperCar().getMessage().contains(car.getModel()));
//    Assert.assertTrue(app.getHelperCar().getMessage().contains(car.getManufacture()));
    Assert.assertEquals(app.getHelperCar().getMessage(), car.getManufacture()+" "+car.getModel()+" added successful");


}
    @Test
    public void addNewCarSuccessPartly(){
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

                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
//    Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
//    Assert.assertTrue(app.getHelperCar().getMessage().contains(car.getModel()));
//    Assert.assertTrue(app.getHelperCar().getMessage().contains(car.getManufacture()));
        Assert.assertEquals(app.getHelperCar().getMessage(), car.getManufacture()+" "+car.getModel()+" added successful");


    }
@AfterMethod
public void postCondition(){
        if(app.getHelperUser().isElementPresent(By.xpath("//button[text()='Search cars']")))

    app.getHelperCar().submitSearchCars();

}

}
