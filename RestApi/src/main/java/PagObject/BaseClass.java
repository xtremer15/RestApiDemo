package PagObject;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


class BasePage extends Driver {


    public void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    public int getSpecificFrameFromPage(WebDriver driver, By by) {

        int i;
        int frame = driver.findElements(By.tagName("iframe")).size();
        System.out.println("avem " + frame + " frameuri in pagina");
        System.out.println(driver.findElement(By.tagName("iframe")).isDisplayed());


        for (i = 0; i < frame; i++) {
            driver.switchTo().frame(i);

            int verifyFrame = driver.findElements(by).size();

            if (verifyFrame > 0) {

                break;

            } else {
                System.out.println("continue loop");
            }
        }
        driver.switchTo().defaultContent();
        return i;
    }

    public void getLinks() {
        int links = getDriver().findElements(By.tagName("a")).size();
        System.out.println("Avem " + links + " in pagina");

    }

    public void click(By elementBy) {
        getDriver().findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        getDriver().findElement(elementBy).sendKeys(text);
    }

    public String readText(By elementBy) {
        return getDriver().findElement(elementBy).getText();
    }


    public void assertEquals(By elementBy, String expectedText) {


    }

    public void getTitle() {
        getDriver().getTitle();
    }

    public void getCurrentUrl() {
        getDriver().getCurrentUrl();
    }

}
