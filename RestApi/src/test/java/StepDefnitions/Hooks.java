package StepDefnitions;

import Driver.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hooks extends Driver {


    @Before
    public void initializeTest() {
        if (getDriver() == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mihai.constantin\\Project\\driver\\chromedriver.exe");
            addDriver(new ChromeDriver());


        }
    }


    @After
    public void tearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File screenShoot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                String timeStamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
                String testName = scenario.getName();
                Files.copy(screenShoot.toPath(),
                        new File("C:\\Users\\mihai.constantin\\Learning\\target\\generated-sources " + testName + " " + timeStamp + " screenshot.png").toPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        getDriver().close();

    }
}
