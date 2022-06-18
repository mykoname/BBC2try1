import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

public class BBCHomePage extends PageObject {
    @FindBy(linkText = "News")
    private WebElement NewsPage;


    public BBCHomePage(WebDriver driver) {
        super(driver);
        driver.get(Utils.BASE_URL);
    }

    public BBCNewsPage NewsPageClick(){

        this.NewsPage.click();
        BBCNewsPage newsPage = new BBCNewsPage(driver);
//        Thread.sleep(5000);
//        Alert alert = driver.switchTo().alert(); // switch to alert
//        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
//        System.out.println(alertMessage); // Print Alert Message
//        Thread.sleep(5000);
//        alert.accept();

        return newsPage;
    }
}