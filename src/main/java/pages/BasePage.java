package pages;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage extends Driver {

    // basePage sayfamız, diğer page sayfalarında bu metodları kullanabilmemiz için yaratıldı. Driver sınıfını extend ediyor ki, buradaki driver instance'ını aşağıdaki metodlarda kullanabilelim.

    WebDriverWait wait;
    public SoftAssert assertion;

    public BasePage() {
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // bu wait'i diğer sınıflarda belli elemenleri görmek/tıklayabilmek için bekleme olarak kullanacağız. Diğer sayfalarımız da BasePage'i extend ettiğinden wait'i görebilecekler.
        assertion = new SoftAssert(); // bu assertion, assertEquals gibi karşılaştırmalarda, beklediğimiz sonuç çıkmazsa, programı patlatma, devam et ama mesaj bas için kullanılır. normal assertEquals beklediği sonucu bulamazsa programı patlatır.
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public WebElement findElementWithText(List<WebElement> list, String elementName) {
        for (int i = 0; i <list.size(); i++) { // verilen listede dönüyoruz
            if(list.get(i).getText().equals(elementName)) // eğer listedeki i'nci elementin text'i verdiğimiz text ile aynıysa o element'i dön.
                return list.get(i);
        }
        return null;
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement)); // element görünür olana kadar bekle eğer göründüyse true dön
            return true;
        } catch (WebDriverException | NoSuchElementException error) { // görünmediyse WebDriverException | NoSuchElementException hatalarından birini verecek program, vermesin diye bunları catch bloğunda yakalayıp handle ediyoruz, bize return false dönmesini istiyoruz ki element'in olmadığını anlayalım.
            return false;
        }
    }

    public void switchTab(int windowIndex) {
        List<String> windows = driver.getWindowHandles().stream().toList(); // bütün tableri bir listede topla.
        driver.switchTo().window(windows.get(windowIndex)); // parametre olarak verilen tab'e switch et.
    }

    public void scrollDown(int howMuch) { // sayfada aşağı in.
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+howMuch+")");
    }


}
