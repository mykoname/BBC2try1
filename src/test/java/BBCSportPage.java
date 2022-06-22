import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BBCSportPage extends PageObject {

        @FindBy(linkText = "Football")
        private WebElement footballLink;
                                                        //data-stat-title="Scores & Fixtures"
        @FindBy (linkText = "Scores & Fixtures")   //    xpath = "//button[@type='submit']")
        private WebElement scoresLink;
//
        @FindBy (xpath = "//input[@name='search']")//(id = "search-input")
        private WebElement scoresSearchBar;
//        @FindBy (xpath = "//input//button[@type='submit']")
//        private WebElement scoresSearchGlass;
        @FindBy (xpath = "//li//a//span['MAY']")
        private WebElement monthSelector;


//        // <ul role="list" spacing="responsive"
//        @FindBy(xpath = "//ul[@spacing='responsive']//li[1]//a[@href]") //(xpath = "//div/div/ul/li/div/div/div/a")//"//ul[@spacing='responsive']")// (css = "ul li a") //xpath = "//div[@id ='main-content']//li")
//        private WebElement firstResult;

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
        BBCSportPage scoresPageOne = new BBCSportPage(driver);
        return scoresPageOne;
    }
    public BBCSportPage makeSearchChampionship(String searchTerm){
        this.scoresSearchBar.sendKeys(searchTerm);
        //!!!!!!:
       // this.driver.findElement(By.xpath("//div[@id ='sp-c-search']//mark["+searchTerm+"]")).click(); // By.xpath("//mark['Scottish Championship']")
       Select dropList = new Select(driver.findElement(By.xpath("//*[@id='downshift-0-item-0']")));   //(By.xpath("//a[@class='sp-c-search__result-item']")));   //(By.xpath("//input[@name='search']")));
       dropList.selectByValue(searchTerm);
//    //    this.scoresSearchGlass.click();
        BBCSportPage scoresPageTwo = new BBCSportPage(driver);
        return scoresPageTwo;
    }
    public BBCSportPage monthSelectorClick(){
        this.monthSelector.click();
        //this.startSearch.click();
        BBCSportPage scoresPageMonth = new BBCSportPage(driver);
        return scoresPageMonth;
    }


//        public String firstSearchResult(String searchTerm){
//            String result = this.firstResult.getText();
//            return result;
//        }

}
