import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCNewsPage extends BBCPageObject {
    @FindBy(css = "div.nw-c-top-stories__primary-item h3")
    private WebElement topStoryTitle;

    public BBCNewsPage(WebDriver driver) {
        super (driver);
    }

    public String getTopStoryTitle() {
        return topStoryTitle.getText();
    }
}
