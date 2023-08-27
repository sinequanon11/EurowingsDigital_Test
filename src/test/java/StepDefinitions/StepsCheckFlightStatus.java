package StepDefinitions;

import Pages.PageCheckFlightStatus;
import Utilities.GenWebDrv;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class StepsCheckFlightStatus {

    PageCheckFlightStatus cfs = new PageCheckFlightStatus();

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        GenWebDrv.getDriver().get( "https://www.eurowings.com/en.html" );
        GenWebDrv.getDriver().manage().window().maximize();
    }

    @And("Navigate to Check Flight Status Page")
    public void navigateToCheckFlightStatusPage(DataTable elements) {

        List<String> listElements = elements.asList( String.class );
        for (String strButtonName : listElements) {
            cfs.findAndClick( strButtonName );
        }
    }

    @And("Click Departure airport and Enter Airport")
    public void clickDepartureAirportAndEnterAirport()  {

        cfs.findAndClick( "depAirport" );
        cfs.findAndSend( "depAirportInput", "CGN" );
        new Actions( GenWebDrv.getDriver() )
                .sendKeys( Keys.ENTER ).sendKeys( Keys.TAB ).sendKeys( Keys.TAB ).sendKeys( Keys.ENTER ).perform();
    }

    @And("Click Departure airport and Enter Other Airport")
    public void clickDepartureAirportAndEnterOtherAirport()  {

        cfs.findAndClick( "depAirport" );
        cfs.findAndSend( "depAirportInput", "EDI" );
        new Actions( GenWebDrv.getDriver() )
                .sendKeys( Keys.ENTER ).sendKeys( Keys.TAB ).sendKeys( Keys.TAB ).sendKeys( Keys.ENTER ).perform();
    }

    @And("Click Destination airport and Enter Airport")
    public void clickDestinationAirportAndEnterAirport() {

        try {
            cfs.findAndClick( "desAirport" );
        } catch (StaleElementReferenceException st){

            cfs.findAndClick( "desAirport" );
        }

        cfs.findAndSend( "desAirportInput", "BER" );
        new Actions( GenWebDrv.getDriver() ).sendKeys( Keys.ENTER ).perform();
    }

    @And("Click Destination airport and Enter Other Airport")
    public void clickDestinationAirportAndEnterOtherAirport() {

        try {
            cfs.findAndClick( "desAirport" );
        } catch (StaleElementReferenceException ste){
            cfs.findAndClick( "desAirport" );
        }

        cfs.findAndSend( "desAirportInput", "HAM" );
        new Actions( GenWebDrv.getDriver() ).sendKeys( Keys.ENTER ).perform();
    }

    @And("Click Departure date and choose date 1")
    public void clickDepartureDateAndChooseDate1() {

        cfs.findAndClick( "depDate" );
        cfs.findAndClick( "chooseDate1" );
        new Actions( GenWebDrv.getDriver() ).sendKeys( Keys.ENTER ).perform();
    }

    @And("Click Departure date and choose date 2")
    public void clickDepartureDateAndChooseDate2() {

        cfs.findAndClick( "depDate" );
        cfs.findAndClick( "chooseDate2" );
        new Actions( GenWebDrv.getDriver() ).sendKeys( Keys.ENTER ).perform();
    }

    @And("Click Show flight status")
    public void clickShowFlightStatus() {

        cfs.findAndClick( "showFlightStatus" );
    }

    @Then("Results of the Flight Status Should be Displayed")
    public void resultsOfTheFlightStatusShouldBeDisplayed() {

        cfs.findAndContainsText( "flightStatusResults", "Status of your searched flight" );
    }

    @Then("No Result for This Flight Message Should be Displayed")
    public void noResultForThisFlightMessageShouldBeDisplayed() {

        cfs.findAndContainsText( "noResult", "Unfortunately, we could not find any results for your search." );
    }

}