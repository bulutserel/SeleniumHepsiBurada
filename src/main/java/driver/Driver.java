package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Driver {

    public static WebDriver driver;


    @BeforeSuite // xml yapısında suite->test->class-> methods hiyerarşisi olduğundan, before suite ile ilk önce driver'I başlatıyoruz.
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite // suite sonunda da driver'ı bitiriyoruz.
    public void endDriver() {
        driver.quit();
    }

}
