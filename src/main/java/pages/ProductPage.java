package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class ProductPage extends BasePage {

    @FindBy(id = "productReviews")
    public WebElement productReviewTab;

    @FindBy(css = "div[class*='thumbsUp']")
    public List<WebElement> thumbsUps;

    @FindBy(xpath = "//*[@itemprop=\"reviewRating\"]/following-sibling::div[1]")
    public List<WebElement> reviewTexts;

    @FindBy(css = "[itemprop=\"review\"]")
    public WebElement reviewContainer;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookiesAcceptButton;


    public void clickLikeButtonInReview(int reviewIndex) {
        wait.until(ExpectedConditions.visibilityOf(thumbsUps.get(reviewIndex))).click();
    }

    public void clickThumbsUpInReview() throws InterruptedException {
        productReviewTab.click(); // yıldızlara tıkla review tab'ine inmek için
        if (isElementPresent(reviewContainer)) { // eğer review alanı açılırsa, yani bu ürün için değerlendirme varsa
            cookiesAcceptButton.click(); // cookie'leri kabul et
            scrollDown(750); // biraz aşağı in
            clickLikeButtonInReview(0); // ilk yorumun like butonuna tıkla
            assertTrue(reviewTexts.get(0).getText().contains( "Teşekkür Ederiz")); // çıkan yazı teşekkür ederiz içeriyor mu kontrol et
        } else
            assertion.fail("Değerlendirme bulunamadı!"); // içermiyorsa, değerlendirme bulunamadı dön. buradaki assertion referansı, BasePage'deki SoftAssert'den geliyor, değerlendirme bulunamadı basacak ama programı patlatmayacak.
    }
}
