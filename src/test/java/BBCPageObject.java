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

//        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fc-consent-root"))); // (ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));

        PageFactory.initElements(driver, this);
//        DeleteElement("fc-consent-root");
    }

    public BBCPageObject(WebDriver driver){
        this(driver, "");
    }

    public void DeleteElement(String className) {
        JavascriptExecutor js;
        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) driver;
            js.executeScript("return document.getElementsByClassName('" + className + "')[0].remove();");
        }
    }
}

