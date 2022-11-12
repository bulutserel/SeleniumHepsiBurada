package tests;

import driver.Driver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MainPage;

public class MainPageTest extends Driver {

    BasePage basePage;
    MainPage mainPage;

    @BeforeTest
    public void initialize() { // testleri çalıştırmadan önce sayfaların referanslarını initiliaze et. Yoksa, basePage referansı null olur ve aşağıda basePage mainPage vs kullanamazsın.
        basePage = new BasePage();
        mainPage = new MainPage();
    }

    @Test
    public void navigateToHomePage() {
        basePage.navigateTo("https://hepsiburada.com");
    }
    @Test
    public void searchProduct() throws InterruptedException {
        mainPage.searchGivenProduct("iphone 11"); // iphone 11 yaz ve tıkla.
    }
}
