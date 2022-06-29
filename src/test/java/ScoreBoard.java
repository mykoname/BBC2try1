import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScoreBoard {
    WebDriver driver;

    public ScoreBoard (WebDriver _driver) {
        driver = _driver;
    }

    public Score getScore(String team1, String team2) {
        // TODO: figure out correct xpaths
// take all block:
        WebElement matchResultsBlock = driver.findElement(By.cssSelector("qa-match-block"));
//take all line with the right team
        WebElement playResultsBlock = matchResultsBlock.findElement(By.xpath("//article//span[contains(text(),'Red Star Belgrade')]"));
// take from line the 'yellow block':

// желтый блок:   article > div > span.sp-c-fixture__team.sp-c-fixture__team--home > span.sp-c-fixture__block
//        //*[@id="u020272446267453947"]/div/div[3]/div/div/span/div/div[1]/ul/li/a/article/div/span[1]/span[2]
// приям циферки:       //*[@id="u020272446267453947"]/div/div[3]/div/div/span/div/div[1]/ul/li/a/article/div/span[1]/span[2]/span
        // team name block: //article//span[contains(text(),'Red Star Belgrade')]
        // article > div > span.sp-c-fixture__team.sp-c-fixture__team--away > span.sp-c-fixture__block
        WebElement lhsRes = playResultsBlock.findElement(By.xpath("span[@class ='sp-c-fixture__block']")); // this is the yellow block after first team
       //  article > div > span.sp-c-fixture__team.sp-c-fixture__team--away > span.sp-c-fixture__block
//        //*[@id="u020272446267453947"]/div/div[3]/div/div/span/div/div[1]/ul/li/a/article/div/span[3]/span[2]

        WebElement rhsRes = playResultsBlock.findElement(By.xpath("")); // this is the yellow block after second team
        return new Score(Integer.parseInt(lhsRes.getText()), Integer.parseInt(rhsRes.getText()));
    }

}
