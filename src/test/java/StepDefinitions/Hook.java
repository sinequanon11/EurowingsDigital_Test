package StepDefinitions;

import Utilities.GenWebDrv;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hook {

    @Before
    public void before() {
        System.out.println( "Scenario Started" );
    }

    @After
    public void after(Scenario scenario) {
        System.out.println( "Scenario Ended" );

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter tf = DateTimeFormatter.ofPattern( "dd_MM_YYHHmmss" );


        if (scenario.isFailed()) {
            final byte[] byteState = ((TakesScreenshot) GenWebDrv.getDriver()).getScreenshotAs( OutputType.BYTES );
            scenario.attach( byteState, "image/png", "screenshot name" );
        }
        GenWebDrv.quitDriver();
    }
}
