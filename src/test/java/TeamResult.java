import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TeamResult {
        WebElement Score;

        public TeamResult(String teamName, WebDriver driver) {
            driver.findElement(By.className("sp-c-fixture__team-name.sp-c-fixture__team-name--home"));
        }

        public TeamResult(WebElement _teamBlock) {
            Score = _teamBlock.findElement(By.cssSelector("span.sp-c-fixture__block > span"));
        }

        public int getScore() {
            return Integer.parseInt(Score.getText());
        }
}

