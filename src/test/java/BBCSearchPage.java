import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCSearchPage extends PageObject {

    @FindBy (id = "search-input")
    private WebElement searchBar;

    @FindBy (css = "ul li a p") //xpath = "//div[@id ='main-content']//li")
    private WebElement firstResult;

    public BBCSearchPage(WebDriver driver) {super (driver); }

    public void makeSearch(String searchTerm){
        this.searchBar.sendKeys(searchTerm);
    }

    public String firstSearchResult(String searchTerm){
        this.makeSearch(searchTerm);
        String result = this.firstResult.getText();
        return result;
    }

}
