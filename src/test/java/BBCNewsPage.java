import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BBCNewsPage extends PageObject {
    //@FindBy( className = "h3")
//    @FindBy(xpath = "//h2[contains(text(),'Top Stories')")
    @FindBy(how= How.CLASS_NAME, using = "gs-u-vh gs-c-promo-heading__title")
    private WebElement MainNewsName;

//    @FindBy(className = "h3")
//    private WebElement labelMain;

    @FindBy(name = "Close")      // className ="tp-close tp-active")
    private WebElement popUpCloseCross;



    public BBCNewsPage(WebDriver driver) {super (driver); }

    @FindBy(id = "news-top-stories-container")
    WebElement newsTopContainer;

    public void clickTopContainer() {this.newsTopContainer.click();}
    public void clickPopUpCloseCross() {this.popUpCloseCross.click();}


    public void clickMainN() {this.MainNewsName.click();}
//    public String GetMainNewsName() {
//        String name = this.MainNewsName.getAttribute("class");
//        return name;}

   //     String newsName = driver.findElement(By.xpath("//h3")).getText();
       // + возврат имени материала
     //   <h3 class="gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text">Lavrov: Russia is not squeaky clean and not ashamed</h3>
   //     return newsName;  }

    public void closePopUp()  {
        try {
        Thread.sleep(5000); }//wait for the modal message to appear
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        String winHandleBefore = driver.getWindowHandle();
//        driver.findElement(By.xpath("xpath")).click();
        driver.findElement(By.className("tp-close tp-active")).click();
     //       Thread.sleep(2000);
        driver.switchTo().window(winHandleBefore);
    }


//    public void clickPopUp() {
////         from selenium import webdriver
////        from selenium.webdriver.common.by import By
////        from selenium.webdriver.support.ui import WebDriverWait
////        from selenium.webdriver.support import expected_conditions as EC
//
////                driver = webdriver.Firefox()
////        driver.get("http://www.example.com") #This is a dummy website URL
//        try:
//        WebElement elem = WebDriverWait(driver, 30).until(
//                expected_conditions.presence_of_element_located((By.ID, "Element_to_be_found")) #This is a dummy element
//)
//finally:
//        driver.quit()
//    }


}
