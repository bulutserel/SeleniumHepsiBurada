package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{

    @FindBy(css = "input[class*='desktopOldAutosuggestTheme']")
    public WebElement inputSearch;

    public void searchGivenProduct(String product) { // input alanı tıklanılabilir olana kadar
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch));
        inputSearch.click();
        inputSearch.sendKeys(product);
        inputSearch.sendKeys(Keys.ENTER);
    }
}
