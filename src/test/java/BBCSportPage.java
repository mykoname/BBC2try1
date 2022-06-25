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
        this.scoresLink.click();
        BBCSportPage scoresPageOne = new BBCSportPage(driver); //TODO: -- try PageFactory here вместо
        return scoresPageOne;
    }
    public BBCSportPage makeSearchChampionship(String searchTerm){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.scoresSearchBar.sendKeys(searchTerm);    //(String.valueOf(searchTerm.charAt(0)));
        this.driver.findElement(By.xpath("//ul[@id ='search-results-list']//li//mark['"+searchTerm+"']")).click();
        BBCSportPage scoresPageTwo = new BBCSportPage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return scoresPageTwo;
    }
    public BBCSportPage monthSelectorClick(String month){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver.findElement(By.xpath("//"+monthXpathBase+month+"')]")).click();
        BBCSportPage scoresPageMonth = new BBCSportPage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return scoresPageMonth;
    }

    public matchResults checkTeamsAndScore(String team1, String team2, int score1, int score2, matchResults assessedResult){
        List<WebElement> listLeft =this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--home > span > span > span"));
        List<WebElement> scopeLeft =this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--home > span.sp-c-fixture__block > span"));
        List<WebElement> listRight=this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--away > span > span > span"));
        List<WebElement> scopeRight=this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--away > span.sp-c-fixture__block > span"));
        int numberOfLines = listLeft.size();
        matchResults[] allResults = new matchResults[numberOfLines];
        for (int i = 0; i < numberOfLines; i++){
            allResults[i] = new matchResults(listLeft.get(i).getText(),listRight.get(i).getText(), Integer.valueOf(scopeLeft.get(i).getText()), Integer.valueOf(scopeRight.get(i).getText()));
//           System.out.println("teamLeft "+i+":   "+allResults[i].teamLeft);
//            System.out.println("scoreLeft "+i+":  "+ allResults[i].scoreLeft);
//            System.out.println("teamRight "+i+":   "+allResults[i].teamRight);
//            System.out.println("scoreRight "+i+":  "+allResults[i].scoreRight);
        }
        int rightLineNumber = 0;
        while (!allResults[rightLineNumber].equals(assessedResult) & rightLineNumber<numberOfLines){
            rightLineNumber++;
        }
        matchResults fromSiteAppropriateResult = allResults[rightLineNumber];
        return fromSiteAppropriateResult;
    }

    public BBCSportPage clickTeam(String team1){
        List<WebElement> listLeft =this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--home > span > span > span"));
//        List<WebElement> scopeLeft =this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--home > span.sp-c-fixture__block > span"));
        List<WebElement> listRight=this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--away > span > span > span"));
//        List<WebElement> scopeRight=this.driver.findElements(By.cssSelector("article span.sp-c-fixture__team.sp-c-fixture__team--away > span.sp-c-fixture__block > span"));
        int numberOfLines = listLeft.size();
        int i = 0;
        while (!listLeft.get(i).getText().equals(team1) & i<numberOfLines){
            i++;
        }
        listLeft.get(i).click();
        BBCSportPage scoresPageTwoTeams = new BBCSportPage(driver);
        return scoresPageTwoTeams;
    }
}
