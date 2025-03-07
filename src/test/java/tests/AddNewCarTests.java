package tests;

import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {
    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged())
            app.getHelperUser().login(new User().setEmail("sonicboom@gmail.com").setPassword("Snow123456!"));
        app.getHelperCar().logoSubmit();
    }
    @BeforeMethod
    public void cleanform(){
        app.getHelperCar().logoSubmit();
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
        Assert.assertEquals(app.getHelperCar().getMessage(), car.getManufacture()+" "+car.getModel()+" added successful");


    }
    @Test
    public void addNewCarWrongCity(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car= Car.builder()
                .location("ssssssss")
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
        app.getHelperCar().fillCarFormWrong(car);
        app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
        //app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(),"Wrong address");


    }
    @Test
    public void addNewCarWrongManufacture(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car= Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("")
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
        Assert.assertEquals(app.getHelperCar().getErrorText(),"Make is required");


    }
    @Test
    public void addNewCarWrongModel(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car= Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("")
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
        Assert.assertEquals(app.getHelperCar().getErrorText(),"Model is required");


    }
    @Test
    public void addNewCarEmptyYear(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car= Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("")
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
        Assert.assertEquals(app.getHelperCar().getErrorText(),"Year required");


    }
    @Test
    public void addNewCarWrongYear(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car= Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("342234234")
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
        Assert.assertEquals(app.getHelperCar().getErrorText(),"Wrong year");


    }
    @Test
    public void addNewCarWrongFuel(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car= Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("1986")
                .fuel("")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-0099-"+i)
                .price(50.)
                .about("My car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarFormWrongFuel(car);
        app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
        app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(),"Fuel is required");


    }
    @Test
    public void addNewCarWrongSeatsMin() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("1986")
                .fuel("Diesel")
                .seats(0)
                .carClass("C")
                .carRegNumber("678-0099-" + i)
                .price(50.)
                .about("My car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
        app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(), "Car must have min 2 seat");
    }
    @Test
    public void addNewCarWrongSeatsMax() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("1986")
                .fuel("Diesel")
                .seats(300)
                .carClass("C")
                .carRegNumber("678-0099-" + i)
                .price(50.)
                .about("My car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
        app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(), "To much seats");
    }
    @Test
    public void addNewCarEmptyClass() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("1986")
                .fuel("Diesel")
                .seats(3)
                .carClass("")
                .carRegNumber("678-0099-" + i)
                .price(50.)
                .about("My car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
        app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(), "Car class is required");
    }
    @Test
    public void addNewCarEmptyCarNumber() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("1986")
                .fuel("Diesel")
                .seats(3)
                .carClass("c")
                .carRegNumber("")
                .price(50.)
                .about("My car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
        app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(), "Car registration number is required");
    }

    @Test
    public void addNewCarWrongCarNumberMax() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("1986")
                .fuel("Diesel")
                .seats(3)
                .carClass("c")
                .carRegNumber("75243597234567984259234578236")
                .price(50.)
                .about("My car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
        app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(), "To long car registration number");
    }
    @Test
    public void addNewCarWrongPrice() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("1986")
                .fuel("Diesel")
                .seats(3)
                .carClass("c")
                .carRegNumber("75243597")
                .price(5023423423.)
                .about("My car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
        app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(), "To much big price");
    }
    @Test
    public void addNewCarEmptyPrice() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("Su7")
                .year("1986")
                .fuel("Diesel")
                .seats(3)
                .carClass("c")
                .carRegNumber("45435345325")

                .about("My car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/Users/dinabazenova/Documents/GitHub/IlCaro/foto-bugatti-veyron_10-650x433.jpg");
        app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(), "Price is required");
    }



    @AfterMethod
public void postCondition(){
        if(app.getHelperUser().isElementPresent(By.xpath("//button[text()='Search cars']")))

    app.getHelperCar().submitSearchCars();

}

}
