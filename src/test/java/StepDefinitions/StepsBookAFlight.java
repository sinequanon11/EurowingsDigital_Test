package StepDefinitions;

import Pages.PageBookAFlight;
import Pages.PageCheckFlightStatus;
import Utilities.GenWebDrv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StepsBookAFlight {

    PageBookAFlight book = new PageBookAFlight();
    PageCheckFlightStatus cfs = new PageCheckFlightStatus();

    @And("Click I understand")
    public void clickIUnderstand() {

        cfs.findAndClick( "iUnderstand" );
    }

    @And("Select Departure airport Destination airport and Date")
    public void selectDepartureAirportDestinationAirportAndDate() throws InterruptedException {

        book.findAndClick( "departureAirport" );
        book.findAndSend( "departureAirportInput", "AMST" );
        Thread.sleep( 3000 );
        new Actions( GenWebDrv.getDriver() ).sendKeys( Keys.ENTER ).perform();
        Thread.sleep( 3000 );
        new Actions( GenWebDrv.getDriver() ).sendKeys( "BUDA" ).sendKeys( Keys.ENTER ).perform();
        Thread.sleep( 3000 );
        new Actions( GenWebDrv.getDriver() ).sendKeys( Keys.ENTER ).sendKeys( "220923" ).perform();
        new Actions( GenWebDrv.getDriver() ).sendKeys( Keys.ENTER ).perform();
        Thread.sleep( 3000 );
    }

    @And("Click Search for flights")
    public void clickSearchForFlights() throws InterruptedException {

        book.findAndClick( "searchForFlights" );
        Thread.sleep( 5000 );
    }

    @And("Select Type of Flight")
    public void selectTypeOfFlight() throws InterruptedException {

        book.findAndClick( "selectTypeOfFlight" );
        Thread.sleep( 5000 );
    }

    @And("Click Continue button")
    public void clickContinueButton() throws InterruptedException {

        book.findAndClick( "continueButton1" );
        Thread.sleep( 5000 );
    }

    @And("Click Continue button 2")
    public void clickContinueButton2() throws InterruptedException {

        book.findAndClick( "continueButton2" );
        Thread.sleep( 5000 );
    }

    @And("Click Continue to Services button")
    public void clickContinueToServicesButton() throws InterruptedException {

        book.findAndClick( "continueToServices" );
        Thread.sleep( 5000 );
    }

    @And("Select Gender and Enter Name and Surname")
    public void selectGenderAndEnterNameAndSurname() {

        book.findAndClick( "continueWithoutLogin" );

        Select dropdownmenu = new Select(GenWebDrv.getDriver().findElement( By.name("title") ) );
        dropdownmenu.selectByValue("MR");

        book.findAndSend( "firstNameInput", "Michael" );
        book.findAndSend( "surNameInput", "Woodland" );
    }

    @Then("Payment Page Should be Displayed")
    public void PaymentPageShouldBeDisplayed() {

        book.findAndContainsText( "billingPageMessage", "Your billing address" );
    }

}
