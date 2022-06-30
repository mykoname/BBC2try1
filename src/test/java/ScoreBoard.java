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
// take all block: (done)
        WebElement matchResultsBlock = driver.findElement(By.xpath("//div[@class='qa-match-block']"));
//take all line with the right team  (done)
        // WebElement playResultsBlock = matchResultsBlock.findElement(By.xpath("//article//span[contains(text(),'Red Star Belgrade')]"));
//take all lines with the right pair of teams: (done)
        //  "//*[self::article//span[contains(text(),'Rangers')] and self::article//span[contains(text(),'Aberdeen')]]"
         WebElement playResultsBlock = matchResultsBlock.findElement(By.xpath("//*[self::article//span[contains(text(),'"+team1+"')] and self::article//span[contains(text(),'"+team2+"')]]"));
// take from line the 'yellow block' (realised without color): (done)
        WebElement lhsRes = playResultsBlock.findElement(By.xpath("//article//span[contains(text(),'"+team1+"')]//..//..//..//span[@class='sp-c-fixture__number sp-c-fixture__number--home sp-c-fixture__number--ft']"));
        WebElement rhsRes = playResultsBlock.findElement(By.xpath("//article//span[contains(text(),'"+team2+"')]//..//..//..//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft']"));

        System.out.println(Integer.parseInt(lhsRes.getText())+"   "+Integer.parseInt(rhsRes.getText()));
        System.out.println("!!!!");
    return new Score(Integer.parseInt(lhsRes.getText()), Integer.parseInt(rhsRes.getText()));
    }
}
