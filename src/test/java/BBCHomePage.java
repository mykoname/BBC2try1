import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

public class BBCHomePage extends PageObject {
    @FindBy(linkText = "News")
    private WebElement NewsPage;
    @FindBy(linkText = "Sport")
    private WebElement sportPage;


    public BBCHomePage(WebDriver driver) {
        super(driver);
        driver.get(Utils.BASE_URL);
    }

    public BBCNewsPage NewsPageClick(){
        this.NewsPage.click();
        BBCNewsPage newsPage = new BBCNewsPage(driver);
    return newsPage;
    }

    public BBCSportPage sportPageClick(){
        this.sportPage.click();
        BBCSportPage sportPage = new BBCSportPage(driver);
    return sportPage;
    }


}