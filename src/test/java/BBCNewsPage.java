import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCNewsPage extends PageObject {

    @FindBy(id = "news-top-stories-container")
    WebElement newsTopContainer;
    @FindBy(name = "Close")
    private WebElement popUpCloseCross;

    @FindBy(tagName = "h3")
    private WebElement labelMain;


    public BBCNewsPage(WebDriver driver) {super (driver); }



     public String nameOfHeadline() {
        String name = this.labelMain.getText();
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
