import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Arrays;
import java.util.List;

public class BBCNewsPage extends BBCPageObject {
    @FindBy(css = "div.nw-c-top-stories__primary-item h3")
    private WebElement topStoryTitle;

    @FindBy(id = "news-top-stories-container")
    WebElement newsTopContainer;
    @FindBy(name = "Close")
    private WebElement popUpCloseCross;

    @FindBy(css = "div.nw-c-top-stories__primary-item h3")  //(tagName = "h3")
    private WebElement labelMain;

    @FindBy(xpath = "//div[@id ='news-top-stories-container']//a[@href]//h3")
    private WebElement secondaryArticlesTitles;

    @FindBy(css = "li.nw-c-promo-meta a span") //(css = "li.nw-c-promo-meta a span")
    private WebElement categoryLink;

    @FindBy(id = "orbit-search-button")
    private WebElement searchBar;

    public BBCNewsPage(WebDriver driver) {super (driver); }

    public void openSearchPage(){this.searchBar.click();}

    public String getMainNewsCategoryName(){
        String name = this.categoryLink.getText();
        return name;
    }
    public String getTopStoryTitle() {
        return topStoryTitle.getText();
    }
    public String storedSearchTerm(){
        String term = getMainNewsCategoryName();
        return term;
    }

    public BBCSearchPage startSearchPage() {
        openSearchPage();
        BBCSearchPage searchPage = new BBCSearchPage(driver);
        return searchPage;
//        String searchTerm =  getMainNewsCategoryName();
//        openSearchPage();
//        return searchTerm;
    }


    public List<String> secondaryArticlesTitlesList(){
        List<WebElement> listOfTitles = this.driver.findElements(By.xpath("//div[@id ='news-top-stories-container']//a[@href]//h3"));
        int number = listOfTitles.size();
        String[] puredTitles = new String[number];
        int countOut = 0;
        for (int i = 2; i<number; i++) {
            if (listOfTitles.get(i).isDisplayed())  {
                puredTitles[countOut] = listOfTitles.get(i).getText();
               countOut++;
            }
        }
        List<String> puredTitlesList = Arrays.stream(puredTitles).toList().subList(0,countOut);
        return puredTitlesList;
    }

     public String nameOfHeadline() {
        String name = this.labelMain.getText();
         System.out.println(name);
        return name;
    }


    public void closePopUp()  {
        try {
        Thread.sleep(5000); }//wait for the modal message to appear
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        String winHandleBefore = driver.getWindowHandle();
//        driver.findElement(By.xpath("xpath")).click();
        driver.findElement(By.className("tp-close tp-active")).click(); //here is incorrect naming of class. Better use  css
     //       Thread.sleep(2000);
        driver.switchTo().window(winHandleBefore);
    }



}
