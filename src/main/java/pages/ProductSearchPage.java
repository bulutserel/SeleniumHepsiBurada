package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class ProductSearchPage extends BasePage{

    @FindBy(css = "[data-test-id='product-card-name']")
    public List<WebElement> productNames;

    @FindBy(css = "[class='information']")
    public WebElement info;


    public void clickProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(info)); // product sonuçları yüklenene kadar bekle
        scrollDown(350);
        findElementWithText(productNames,productName).click(); // verilen product'ı text ile bul ve tıkla (metod basepage'den geliyor)
    }
}
