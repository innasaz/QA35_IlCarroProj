package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class HelperBase {
    Logger logger= LoggerFactory.getLogger(HelperBase.class);
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }


    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void type(By locator, String text){
        if(text!=null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }

    public void submit() {
        new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector("button[type='submit']"))));
        wd.findElement(By.cssSelector("button[type='submit']")).click();
        //button[text()='YЭalla!']
    }

    public boolean isElementPresent(By locator){

        return wd.findElements(locator).size()>0;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void searchNextMonth(String tel_aviv, String s, String s1) {
    }

    public boolean isListOfCarsAppeared(){
        new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".cars-container"), 1));
        WebElement carsContainer = wd.findElement(By.cssSelector(".cars-container"));
        List<WebElement> carsChildElements = carsContainer.findElements(By.cssSelector("*"));
        return carsChildElements.size() > 0;
    }
}
