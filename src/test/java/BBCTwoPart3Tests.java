import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.sql.SQLOutput;
import java.util.List;
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



    @ParameterizedTest     // BBC2 Part3 Task3 ( Verify that the score at the center improved)
    @MethodSource("dataForTestTeamScores")
    public void testCenteredScoreDisplayImproved(String nameOfChampionship, String month, String team1, String team2, int score1, int score2){
        BBCHomePage homePage = new BBCHomePage(driver);
        BBCSportPage sportPage = homePage.sportPageClick();
        // TODO not ended from this part:
        BBCSportPage scoresPageOne = sportPage.footballPageClick().scoresPageClick().makeSearchChampionship(nameOfChampionship).monthSelectorClick(month); //.clickTeam(team1);

        Score expected = new Score(score1, score2);
        // #u2672365329034485 > div > div:nth-child(3) > div > div > span > div > div:nth-child(1) > ul > li > a > article > div > span.sp-c-fixture__team.sp-c-fixture__team--home
    //    System.out.println(scoresPageOne.driver.findElement(By.xpath("//article//span[contains(text(),'Red Star Belgrade')]//span[@class ='sp-c-fixture__team']")).getText());
          WebElement matchResultsBlock = scoresPageOne.driver.findElement(By.xpath("//div[@class='qa-match-block']"));  //!!receiving full match block!!
         WebElement playResultsBlock = matchResultsBlock.findElement(By.xpath("//article//span[contains(text(),'Red Star Belgrade')]"));
        System.out.println(playResultsBlock.getText());
        System.out.println(playResultsBlock);
        System.out.println("!!!!");
// take from line the 'yellow block':
      // !!!!!! так всегда правильноЖ
        WebElement lhsRes = playResultsBlock.findElement(By.xpath("//article//span[contains(text(),'Red Star Belgrade')]//..//..//..//span[@class='sp-c-fixture__block']"));
        System.out.println(lhsRes.getText());
        System.out.println(lhsRes);
        System.out.println("&&&&&&&&");
        // !!так получается неправильно (похоже, что берет первую из всех в большом блоке:
//        WebElement lhsRes2 = playResultsBlock.findElement(By.xpath("//..//..//..//span[@class='sp-c-fixture__block']"));
//        System.out.println(lhsRes2.getText());

// уже готовый финиш:
     //   Score actual = scoresPageOne.getTeamResultByName(team1, team2);
     //   assertEquals(expected, actual);

// старый финиш:
//        matchResults awaitedMatchResults = new matchResults(team1, team2, score1, score2);
//        matchResults fromSiteResults = scoresPageOne.checkTeamsAndScore(team1, team2, score1, score2, awaitedMatchResults);
//        assertEquals(awaitedMatchResults, fromSiteResults);

    }


    static Stream<Arguments> dataForTestTeamScores() {
        // name of championship | month | team1(left) | team2(right) | score1 | score2
        return Stream.of(
//                Arguments.of("Scottish Championship", "MAY", "Airdrieonians", "Queen's Park", 1, 2),
//                Arguments.of("Scottish Championship", "MAY", "Dunfermline", "Queen's Park", 0, 1),
//                Arguments.of("Scottish Championship", "APR", "Dunfermline", "Queen of the South", 1, 2),
//                Arguments.of("Danish Superliga", "FEB", "Aalborg BK", "Silkeborg IF", 1, 4),
//                Arguments.of("Rangers", "MAR", "Dundee", "Rangers", 1, 2),
                Arguments.of("Rangers", "MAR", "St Johnstone", "Rangers", 0, 1)
        );
    }

//    @AfterAll
//    public static void cleanUp(){
//        driver.manage().deleteAllCookies();
//        driver.close();
//    }
}
