import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BBCTwoPart3Tests {  // BBC2 Task3  Part3
    private static final WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setJavascriptEnabled(false);
        ChromeOptions javaCap = new ChromeOptions();
        javaCap.merge(dc);
          ChromeOptions chromePath = new ChromeOptions();
          chromePath.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
          chromePath.merge(javaCap);
//        driver = new ChromeDriver(javaCap);
          driver = new ChromeDriver(chromePath);
    }

    @ParameterizedTest     // BBC2 Part3 Task3 (improved BBC2 Part2 Test1 (Verify that 2 specific teams ))
    @MethodSource("dataForTestTeamScores")
    public void testTeamScoresDisplayImproved(String nameOfChampionship, String month, String team1, String team2, int score1, int score2){
        BBCHomePage homePage = new BBCHomePage(driver);
        BBCSportPage sportPage = homePage.sportPageClick();
        BBCSportPage scoresPageMonth = sportPage.footballPageClick().scoresPageClick().makeSearchChampionship(nameOfChampionship).monthSelectorClick(month);
        Score expected = new Score(score1, score2);
        Score actual = scoresPageMonth.getTeamResultByName(team1, team2);
        assertEquals(expected, actual);
    }



    @ParameterizedTest  // BBC2 Part3 Task3 ( Verify scores on single page and verify that the score at the center. Improved)
    @MethodSource("dataForTestTeamScores")
    public void testCenteredScoreDisplayImproved(String nameOfChampionship, String month, String team1, String team2, int score1, int score2){
        BBCHomePage homePage = new BBCHomePage(driver);
        BBCSportPage sportPage = homePage.sportPageClick();
        BBCSportPage scoresPageOne = sportPage.footballPageClick().scoresPageClick().makeSearchChampionship(nameOfChampionship).monthSelectorClick(month).clickTeamImproved(team1, team2);
        Score expected = new Score(score1, score2);
        Score actual = scoresPageOne.getTeamResultFromSingleLine(team1, team2);
        assertEquals(expected, actual);
        // TODO: it would be good also to check exactly centered

    }


    static Stream<Arguments> dataForTestTeamScores() {
        // name of championship | month | team1(left) | team2(right) | score1 | score2
        return Stream.of(
                Arguments.of("Scottish Championship", "MAY", "Airdrieonians", "Queen's Park", 1, 2),
                Arguments.of("Scottish Championship", "MAY", "Dunfermline", "Queen's Park", 0, 1),
                Arguments.of("Scottish Championship", "APR", "Dunfermline", "Queen of the South", 1, 2),
                Arguments.of("Danish Superliga", "FEB", "Aalborg BK", "Silkeborg IF", 1, 4),
                Arguments.of("Rangers", "MAR", "Dundee", "Rangers", 1, 2),
                Arguments.of("Rangers", "MAR", "St Johnstone", "Rangers", 0, 1)
        );
    }

    @AfterAll
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
