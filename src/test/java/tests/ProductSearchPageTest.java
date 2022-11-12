package tests;

import driver.Driver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ProductSearchPage;

public class ProductSearchPageTest extends Driver {
    BasePage basePage;
    ProductSearchPage productSearchPage;

    @BeforeTest
    public void initialize() { // testleri çalıştırmadan önce sayfaların referanslarını initiliaze et. Yoksa, basePage, productSearchPage referansı null olur ve aşağıda basePage productSearchPage vs kullanamazsın.
        basePage = new BasePage();
        productSearchPage = new ProductSearchPage();
    }

    @Test
    public void clickGivenProduct() { // verilen ürüne tıkla ve tab değiştir. (çünkü yeni tabde açıyor sayfayı)
        productSearchPage.clickProduct("iPhone 11 64 GB");
        basePage.switchTab(1);
    }
}
