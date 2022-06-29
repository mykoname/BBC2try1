import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class BBCHomePage extends BBCPageObject {
    @FindBy(linkText = "News")
    private WebElement NewsPage;
    @FindBy(linkText = "Sport")
    private WebElement sportPage;


    public BBCHomePage(WebDriver driver) {
        super(driver);
        driver.get(Utils.BASE_URL);
    }
    public BBCHomePage(WebDriver driver, String URL) {
        super(driver, URL);
    }

    public BBCNewsPage NewsPageClick(){
        this.NewsPage.click();
//        BBCNewsPage newsPage = new BBCNewsPage(driver);
    return new BBCNewsPage(driver);
    }

    public BBCSportPage sportPageClick(){
        this.sportPage.click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BBCSportPage sportPage = new BBCSportPage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    return sportPage;
    }


}