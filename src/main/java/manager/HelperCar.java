package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperCar extends HelperBase {
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        pause(500);
        click(By.xpath("//a[text()=' Let the car work ']"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
        type(By.id("make"),car.getManufacture());
        type(By.id("model"),car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"),car.getFuel());
        type(By.id("seats"),String.valueOf(car.getSeats()));
        type(By.id("class"),car.getCarClass());
        type(By.id("serialNumber"),car.getCarRegNumber());
        type(By.id("price"),car.getPrice()+"");//konkotination
        type(By.id("about"), car.getAbout());

    }

    private void select(By locator, String option) {
        Select select=new Select(wd.findElement(locator));
        select.selectByValue(option);
    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"),location);
        click(By.cssSelector("div.pac-item"));
    }



    public void submitSearchCars() {
        click(By.xpath("//button[text()='Search cars']"));
    }

    public void attachPhoto(String link) {
        wd.findElement(By.id("photos")).sendKeys(link);

    }


    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        clearTextBox(By.id("dates"));
        click(By.id("dates"));

        String[] from=dataFrom.split("/");
        String[] to=dataTo.split("/");

        String locatorFrom="//div[text()=' "+from[1]+" ']";
        String locatorTo="//div[text()=' "+to[1]+" ']";


        click(By.xpath(locatorFrom));
        click(By.xpath(locatorTo));

    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
    }

    public boolean isListOfCarAppeared() {
        return isElementPresent(By.cssSelector("a.car-container"));
    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        clearTextBox(By.id("dates"));
        click(By.id("dates"));

        LocalDate now=LocalDate.now();

//        int month=now.getMonthValue();
//        int year= now.getYear();
//        int day=now.getDayOfMonth();

        LocalDate from=LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to=LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
        int diffMonthNowFrom=from.getMonthValue()-now.getMonthValue();
        if (diffMonthNowFrom>0)
            clickNextMonthButton(diffMonthNowFrom);
//        String locator= String.format("//div[text()= ' $s ']",to.getDayOfMonth());
//        click(By.xpath(locator));
        click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));

        int diffMonthFromTo=to.getMonthValue()-from.getMonthValue();
        if(diffMonthFromTo>0)
            clickNextMonthButton(diffMonthFromTo);
        click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));

    }

    private void clickNextMonthButton(int diffMonth) {
        for (int i = 0; i < diffMonth; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }

    public void searchAnyPeriod(String city, String dataFrom, String dataTo) {
        clearTextBox(By.id("dates"));
        LocalDate now=LocalDate.now();
        LocalDate from=LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to=LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/d/yyyy"));

        int diffYear=to.getYear()- from.getYear();
        if (diffYear==0 && to.getYear()== now.getYear()) {
            searchCurrentYear(city, dataFrom, dataTo);
        }
        if(diffYear==0 && to.getYear()!= now.getYear()){
            typeCity(city);
            click(By.id("dates"));

            int diffMonthNowFrom=from.getMonthValue()+(12-now.getMonthValue());
            if (diffMonthNowFrom>0)
                clickNextMonthButton(diffMonthNowFrom);
            click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));
            int diffMonthFromTo=to.getMonthValue()-from.getMonthValue();
            if(diffMonthFromTo>0)
                clickNextMonthButton(diffMonthFromTo);
            click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));

        }
        if(diffYear!=0){
            typeCity(city);
            click(By.id("dates"));

            int diffMonthNowFrom=from.getMonthValue()-now.getMonthValue();
            if (diffMonthNowFrom>0)
                clickNextMonthButton(diffMonthNowFrom);
            click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));

            int diffMonthFromTo=to.getMonthValue()+(12-from.getMonthValue());
            if(diffMonthFromTo>0)
                clickNextMonthButton(diffMonthFromTo);
            click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));


        }


    }

    public void logoSubmit() {
        click(By.xpath("(//a[@class='logo'])"));
    }


}
