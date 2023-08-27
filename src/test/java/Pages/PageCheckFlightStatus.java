package Pages;

import Utilities.GenWebDrv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCheckFlightStatus extends Parent {

    public PageCheckFlightStatus() {

        PageFactory.initElements( GenWebDrv.getDriver(), this );
    }

    @FindBy(xpath = "//span[normalize-space()='My trip']")
    private WebElement myTrip;

    @FindBy(xpath = "//span[contains(text(),'Check flight status')]")
    private WebElement checkFlightStatus;

    @FindBy(xpath = "//span[@class='a-cta__text']")
    private WebElement iUnderstand;

    @FindBy(xpath = "//span[normalize-space()='Departure airport']")
    private WebElement depAirport;

    @FindBy(xpath = "//input[@id='station-select-200-input']")
    private WebElement depAirportInput;

    // @FindBy(xpath = "//span[@class='o-compact-search__cta-button-floating-label']")
    @FindBy(xpath = "//span[text()='Destination airport']")
    private WebElement desAirport;

    @FindBy(xpath = "//input[@id='station-select-201-input']")
    private WebElement desAirportInput;

    @FindBy(xpath = "//div[@name='departureDate']")
    private WebElement depDate;

    @FindBy(xpath = "(//div[@class='calendar-date'])[4]")
    private WebElement chooseDate1;

    @FindBy(xpath = "(//div[@class='calendar-date'])[5]")
    private WebElement chooseDate2;

    @FindBy(xpath = "//span[contains(text(),'Show flight status')]")
    private WebElement showFlightStatus;

    @FindBy(xpath = "//h5[normalize-space()='Status of your searched flight']")
    private WebElement flightStatusResults;

    @FindBy(xpath = "//h2[@class='a-headline a-headline--h4']")
    private WebElement noResult;


    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "myTrip" -> myElement = myTrip;
            case "checkFlightStatus" -> myElement = checkFlightStatus;
            case "iUnderstand" -> myElement = iUnderstand;
            case "depAirport" -> myElement = depAirport;
            case "desAirport" -> myElement = desAirport;
            case "depDate" -> myElement = depDate;
            case "chooseDate1" -> myElement = chooseDate1;
            case "chooseDate2" -> myElement = chooseDate2;
            case "showFlightStatus" -> myElement = showFlightStatus;
        }
        clickFunction( myElement );
    }


    public void findAndSend(String strElement, String value) {

        switch (strElement) {
            case "depAirportInput" -> myElement = depAirportInput;
            case "desAirportInput" -> myElement = desAirportInput;
        }
        sendKeysFunction( myElement, value );
    }

    public void findAndContainsText(String strelement, String text) {

        switch (strelement) {
            case "flightStatusResults" -> myElement = flightStatusResults;
            case "noResult" -> myElement = noResult;
        }
        verifyContainsTextFunction( myElement, text );
    }

}
