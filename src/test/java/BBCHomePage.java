import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCHomePage extends BBCPageObject {
    @FindBy(linkText = "News")
    private WebElement NewsPage;

    public BBCHomePage(WebDriver driver, String URL) {
        super(driver, URL);
    }

    public BBCNewsPage NewsPageClick() {
        this.NewsPage.click();
        return new BBCNewsPage(driver);
    }
}