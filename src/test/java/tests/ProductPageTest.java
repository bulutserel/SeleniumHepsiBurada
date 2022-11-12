package tests;

import driver.Driver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ProductPage;
import pages.ProductSearchPage;

import static org.testng.Assert.assertEquals;

public class ProductPageTest extends Driver {
    BasePage basePage;
    ProductPage productPage;

    @BeforeTest
    public void initialize() { // testleri çalıştırmadan önce sayfaların referanslarını initiliaze et. Yoksa, basePage ve productPage referansı null olur ve aşağıda basePage productPage vs kullanamazsın.
        basePage = new BasePage();
        productPage = new ProductPage();
    }

    @Test
    public void clickThumbsUpInFirstReview() throws InterruptedException {
       productPage.clickThumbsUpInReview(); // üründeki ilk like butonuna tıkla
    }
}
