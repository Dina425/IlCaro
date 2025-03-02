package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Rehovot","3/10/2025","3/27/2025");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }
    @Test
    public void searchCurrentYearSuccess(){
        app.getHelperCar().searchCurrentYear("Rehovot","4/10/2025","5/27/2025");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }
    @Test
    public void searchAnyperiod(){
        app.getHelperCar().searchAnyPeriod("Rehovot","3/10/2025","1/27/2026");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }
}
