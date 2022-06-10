import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCHomePage extends PageObject {
    @FindBy(linkText = "News")
    private WebElement NewsPage;


    public BBCHomePage(WebDriver driver) {
        super(driver);
    }

    public BBCNewsPage NewsPageClick() {
        this.NewsPage.click();
        BBCNewsPage newsPage = new BBCNewsPage(driver);
        return newsPage;
    }
}
