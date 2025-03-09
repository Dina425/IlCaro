package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        app.getHelperCar().logoSubmit();

    }

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Rehovot","3/20/2025","3/27/2025");
        app.getHelperCar().getScreen("src/test/screenshots/currentMonth.png");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }
    @Test
    public void searchCurrentYearSuccess(){
        app.getHelperCar().searchCurrentYear("Rehovot","4/10/2025","5/27/2025");
        app.getHelperCar().getScreen("src/test/screenshots/currentYear.png");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }
    @Test
    public void searchAnyPeriod(){
        app.getHelperCar().searchAnyPeriod("Rehovot","3/10/2025","1/27/2026");
        app.getHelperCar().getScreen("src/test/screenshots/currentAny.png");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());


    }
    @Test
    public void searchCarInputPeriodNegative(){
        app.getHelperCar().pause(1000);
        String period="1/27/2026-3/10/2025";
        app.getHelperCar().searchWithInputPeriod("Rehovot",period);
        app.getHelperCar().getScreen("src/test/screenshots/input.png");

        Assert.assertEquals(app.getHelperCar().getErrorText(),"Second date must be after first date\n" +
                "You can't book car for less than a day");

    }
    @Test
    public void searchCarEmptyDate(){
        app.getHelperCar().pause(1000);
        app.getHelperCar().searchWithInputPeriod("Rehovot","");
        Assert.assertEquals(app.getHelperCar().getErrorText(),"Dates are required");
    }
    @Test
    public void searchCarEmptyCity(){
        app.getHelperCar().pause(1000);
        app.getHelperCar().searchWithInputPeriodEmptyCity("","4/27/2025-1/1/2026");
        app.getHelperCar().submit();
        Assert.assertEquals(app.getHelperCar().getErrorText(),"City is required");
    }
    @Test
    public void negativeSearch(){
        app.getHelperCar().searchNotValidPeriod("Rehovot","10/10/2025","14/27/2026");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonActive());
        Assert.assertEquals(app.getHelperCar().getErrorText(),"Dates are required");

    }

}
