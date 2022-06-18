import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BBCPageObject {
    protected WebDriver driver;

    public BBCPageObject(WebDriver driver, String url){
        this.driver = driver;
        if (!url.isEmpty()) {
            driver.get(url);
        }
        // TODO: replace with wait for element delay (use the overlay thing)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // NOP
        }
        PageFactory.initElements(driver, this);
        DeleteElement("fc-consent-root");
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