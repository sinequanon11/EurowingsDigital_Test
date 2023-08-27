package Pages;

import Utilities.GenWebDrv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageBookAFlight extends Parent {

    public PageBookAFlight() {

        PageFactory.initElements( GenWebDrv.getDriver(), this );
    }

    @FindBy(xpath = "(//span[text()='Departure airport'])[1]")
    private WebElement departureAirport;

    @FindBy(xpath = "//input[@id='station-select-92-input']")
    private WebElement departureAirportInput;

    @FindBy(xpath = "//span[contains(text(),'Search for flight')]")
    private WebElement searchForFlights;

    @FindBy(xpath = "//article[@data-e2e-fare-type='EW_SMART']//header[1]")
    private WebElement selectTypeOfFlight;

    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton1;

    @FindBy(xpath = "(//span[@class='a-cta__text'])[8]")
    private WebElement continueButton2;

    @FindBy(xpath = "//span[text()='Continue to Services']")
    private WebElement continueToServices;

    @FindBy(xpath = "//span[text()='Continue without logging in']")
    private WebElement continueWithoutLogin;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "lastName")
    private WebElement surNameInput;

    @FindBy(xpath = "//h2[normalize-space()='Your billing address']")
    private WebElement billingPageMessage;



    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "departureAirport" -> myElement = departureAirport;
            case "searchForFlights" -> myElement = searchForFlights;
            case "selectTypeOfFlight" -> myElement = selectTypeOfFlight;
            case "continueButton1" -> myElement = continueButton1;
            case "continueButton2" -> myElement = continueButton2;
            case "continueToServices" -> myElement = continueToServices;
            case "continueWithoutLogin" -> myElement = continueWithoutLogin;
        }
        clickFunction( myElement );
    }


    public void findAndSend(String strElement, String value) {

        switch (strElement) {
            case "departureAirportInput" -> myElement = departureAirportInput;
            case "firstNameInput" -> myElement = firstNameInput;
            case "surNameInput" -> myElement = surNameInput;
        }
        sendKeysFunction( myElement, value );
    }


    public void findAndContainsText(String strelement, String text) {

        if ("billingPageMessage".equals( strelement )) {
            myElement = billingPageMessage;
        }
        verifyContainsTextFunction( myElement, text );
    }

}
