import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class BBCNewsPage extends PageObject {

    @FindBy(id = "news-top-stories-container")
    WebElement newsTopContainer;
    @FindBy(name = "Close")
    private WebElement popUpCloseCross;

    @FindBy(css = "div.nw-c-top-stories__primary-item h3")  //css = "div.nw-c-top-stories__primary-item h3"
    private WebElement labelMain;

    @FindBy(tagName = "h3")  //(css = "div.gs-c-promo-heading__title h3")
    private WebElement secondaryArticlesTitles;


    public BBCNewsPage(WebDriver driver) {super (driver); }

    public void secondaryArticlesTitlesList(){
        System.out.println(driver.findElement(By.tagName("h3")));
        System.out.println(this.secondaryArticlesTitles.findElement(By.tagName("h3")));
//        return list;
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
