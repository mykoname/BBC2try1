import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BBCSportPage extends PageObject {

        @FindBy(linkText = "Football")
        private WebElement footballLink;
        @FindBy (linkText = "Scores & Fixtures")   //    //data-stat-title="Scores & Fixtures"
        private WebElement scoresLink;
        @FindBy (xpath = "//input[@name='search']")//(id = "search-input")
        private WebElement scoresSearchBar;
             // (xpath = "//ul[@id ='sp-timeline-past-dates']//li[@class='sp-c-date-picker-timeline__item']//a//span[contains(text(),'MAY')]")
        @FindBy (xpath = "//ul[@id ='sp-timeline-past-dates']//li[@class='sp-c-date-picker-timeline__item']//a//span[contains(text(),'MAY')]")
        private WebElement monthSelectorMay;


        public BBCSportPage(WebDriver driver) {super (driver); }

        public BBCSportPage footballPageClick(){
            this.footballLink.click();
            //this.startSearch.click();
            BBCSportPage footballPage = new BBCSportPage(driver);
            return footballPage;
        }
    public BBCSportPage scoresPageClick(){
        this.scoresLink.click();
        //this.startSearch.click();
        BBCSportPage scoresPageOne = new BBCSportPage(driver); //TODO: -- try PageFactory here вместо
        return scoresPageOne;
    }
    public BBCSportPage makeSearchChampionship(String searchTerm){
        this.scoresSearchBar.sendKeys(searchTerm);    //(String.valueOf(searchTerm.charAt(0)));
        this.driver.findElement(By.xpath("//ul[@id ='search-results-list']//li//mark['"+searchTerm+"']")).click();
        BBCSportPage scoresPageTwo = new BBCSportPage(driver);
        return scoresPageTwo;
    }
    public BBCSportPage monthSelectorClick(){
        this.monthSelectorMay.click();
        BBCSportPage scoresPageMonth = new BBCSportPage(driver);
        return scoresPageMonth;
    }


//        public String firstSearchResult(String searchTerm){
//            String result = this.firstResult.getText();
//            return result;
//        }

}
