import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BBCTwoPart2Tests {

        private static final WebDriver driver;
        static {
            System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setJavascriptEnabled(false);
            ChromeOptions javaCap = new ChromeOptions();
            javaCap.merge(dc);
            driver = new ChromeDriver(javaCap);
        }

        @ParameterizedTest     // BBC2 Part2 Test1
        @MethodSource("dataForTestTeamScores")
    public void testTeamScoresDisplay(String nameOfChampionship, String month){
            BBCHomePage homePage = new BBCHomePage(driver);
            BBCSportPage sportPage = homePage.sportPageClick();
            sportPage.footballPageClick().scoresPageClick().makeSearchChampionship(nameOfChampionship).monthSelectorClick(month);

        }
    static Stream<Arguments> dataForTestTeamScores() {
        return Stream.of(
                Arguments.of("Scottish Championship", "MAY")
                );
    }



//    @AfterAll
//    public static void cleanUp(){
//        driver.manage().deleteAllCookies();
//        driver.close();
//    }
}
