import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCSearchPage extends PageObject {

    @FindBy (id = "search-input")
    private WebElement searchBar;
// <ul role="list" spacing="responsive"
    @FindBy(css = "ul li a") //(xpath = "//div/div/ul/li/div/div/div/a")//"//ul[@spacing='responsive']")// (css = "ul li a") //xpath = "//div[@id ='main-content']//li")
    private WebElement firstResult;

    public BBCSearchPage(WebDriver driver) {super (driver); }

    public BBCSearchPage makeSearch(String searchTerm){
        this.searchBar.sendKeys(searchTerm);
        BBCSearchPage searchPageOne = new BBCSearchPage(driver);
        return searchPageOne;
    }

    public String firstSearchResult(String searchTerm){
//        this.makeSearch(searchTerm);

        String result = this.firstResult.getText();
        return result;
    }

}
