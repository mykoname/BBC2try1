import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BBCPageObject {
    protected WebDriver driver;

    public BBCPageObject(WebDriver driver, String url){
        this.driver = driver;
        if (!url.isEmpty()) {
            driver.get(url);
        }
// TODO maybe to call WaitELEment here or after Page Factory
        PageFactory.initElements(driver, this);
//        DeleteElement("fc-consent-root"); // for countries with strict GDPR
    }

    public BBCPageObject(WebDriver driver){
        this(driver, "");
    }

    public void WaitElement(){
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(getWaitSelector()))); // (ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
   }

   public String getWaitSelector(){
        return "#orb-header > div > nav.orbit-header-links.international";
   }


    public void DeleteElement(String className) {
        JavascriptExecutor js;
        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) driver;
            js.executeScript("return document.getElementsByClassName('" + className + "')[0].remove();");
        }
    }
}

