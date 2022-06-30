import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.print.DocFlavor;

public class ScoreBoard {
    WebDriver driver;

    public ScoreBoard (WebDriver _driver) {
        driver = _driver;
    }

    public Score getScore(String team1, String team2) {
// take all block: (done)
        WebElement matchResultsBlock = driver.findElement(By.xpath("//div[@class='qa-match-block']"));
//take all lines with the right pair of teams: (done)
        WebElement playResultsBlock = matchResultsBlock.findElement(By.xpath("//*[self::article//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--home']//span[contains(text(),'"+team1+"')] and self::article//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--away']//span[contains(text(),'"+team2+"')]]"));
// take from line the 'yellow block' (realised without color): (done)
        WebElement lhsRes = playResultsBlock.findElement(By.xpath(".//..//..//..//span[@class='sp-c-fixture__number sp-c-fixture__number--home sp-c-fixture__number--ft']"));
        WebElement rhsRes = playResultsBlock.findElement(By.xpath(".//..//..//..//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft']"));
    return new Score(Integer.parseInt(lhsRes.getText()), Integer.parseInt(rhsRes.getText()));
    }

    public Score getScoreFromLine(String team1, String team2) {
//take all lines with the right pair of teams: (done)
        WebElement playResultsBlock = driver.findElement(By.xpath("//*[self::article//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--home']//span[contains(text(),'"+team1+"')] and self::article//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--away']//span[contains(text(),'"+team2+"')]]"));
// take from line the 'yellow block' (realised without color): (done)
        WebElement lhsRes = playResultsBlock.findElement(By.xpath(".//..//..//..//span[@class='sp-c-fixture__number sp-c-fixture__number--home sp-c-fixture__number--ft']"));
        WebElement rhsRes = playResultsBlock.findElement(By.xpath(".//..//..//..//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft']"));
        return new Score(Integer.parseInt(lhsRes.getText()), Integer.parseInt(rhsRes.getText()));
    }
}
