import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BBCSportPage extends PageObject {

        @FindBy(linkText = "Football")
        private WebElement footballLink;
        @FindBy (xpath = "//*[@id='sp-nav-secondary']/li[2]/a")// (linkText = "Scores & Fixtures")   //    //data-stat-title="Scores & Fixtures"
        private WebElement scoresLink;
        @FindBy (xpath = "//input[@name='search']")//(id = "search-input")
        private WebElement scoresSearchBar;
        @FindBy (xpath = "//ul[@id ='sp-timeline-past-dates']//li[@class='sp-c-date-picker-timeline__item']//a//span[contains(text(),'MAY')]")
        private WebElement monthSelectorMay;
                          // (xpath = "//ul[@id ='sp-timeline-past-dates']//li[@class='sp-c-date-picker-timeline__item']//a//span[contains(text(),'MAY')]")
        private String monthXpathBase = "ul[@id ='sp-timeline-past-dates']//li[@class='sp-c-date-picker-timeline__item']//a//span[contains(text(),'";
 // second version for teamXpathBase: "article[@class ='sp-c-fixture']//abbr[contains(text(),'"
        private String teamXpathBase = "article[@class ='sp-c-fixture']//abbr[@title='";
        private String poolOfPlays = "//span[@role ='region']";

        public BBCSportPage(WebDriver driver) {super (driver); }

        public BBCSportPage footballPageClick(){
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            this.footballLink.click();
            //this.startSearch.click();
            BBCSportPage footballPage = new BBCSportPage(driver);
            return footballPage;
        }
    public BBCSportPage scoresPageClick(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().getImplicitWaitTimeout();
        this.scoresLink.click();
        BBCSportPage scoresPageOne = new BBCSportPage(driver); //TODO: -- try PageFactory here вместо
        return scoresPageOne;
    }
    public BBCSportPage makeSearchChampionship(String searchTerm){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.scoresSearchBar.sendKeys(searchTerm);    //(String.valueOf(searchTerm.charAt(0)));
        this.driver.findElement(By.xpath("//ul[@id ='search-results-list']//li//mark['"+searchTerm+"']")).click();
        BBCSportPage scoresPageTwo = new BBCSportPage(driver);
        return scoresPageTwo;
    }
    public BBCSportPage monthSelectorClick(String month){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // this.monthSelectorMay.click();
        this.driver.findElement(By.xpath("//"+monthXpathBase+month+"')]")).click();
        BBCSportPage scoresPageMonth = new BBCSportPage(driver);
        return scoresPageMonth;
    }
    public boolean checkTeamsAndScore(String team1, String team2, int score1, int score2){
        List<WebElement> listLeft =this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--home"));
        List<WebElement> listRight=this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--away"));
        for (WebElement l: listLeft) {
            System.out.println("listLeft   "+l.getText());
            System.out.println("!l!!!");
        }
        for (WebElement l: listRight) {
            System.out.println("listRight  " + l.getText());
            System.out.println("!r!!!");
        }



        boolean teamsAndScoreVerified = true; //!!!!!!!!!!! ---поменять!!!!!!!!!!!!!
        return teamsAndScoreVerified;
    }

//        public String firstSearchResult(String searchTerm){
//            String result = this.firstResult.getText();
//            return result;
//        }

}
