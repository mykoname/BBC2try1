import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCNewsPage extends PageObject {

    @FindBy( xpath = "//h3")
//#u19081705053027598 > div > div > div > div.gel-layout__item.nw-c-top-stories__primary-item.gel-2\/3\@l.gel-9\/16\@xxl.nw-o-no-keyline.nw-o-keyline\@s.nw-o-no-keyline\@m > div > div > div.gs-c-promo-body.gs-u-display-none.gs-u-display-inline-block\@m.gs-u-mt\@xs.gs-u-mt0\@m.gel-1\/3\@m > div > a > h3
//            xpath = "//class[contains(text(),'gs-c-promo-heading')]")
//  <h3 class="gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text">Captured Britons sentenced to death in Ukraine</h3>
//

    private WebElement MainNewsStuff;



    public BBCNewsPage(WebDriver driver) {super (driver); }

    public String GetMainNewsName() {this.MainNewsStuff.click();
       // + возврат имени материала
        return "";  }



}
