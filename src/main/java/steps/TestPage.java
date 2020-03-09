package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class TestPage extends BasePage {

    public TestPage(WebDriver driver) throws Exception {
        super(driver);
      }

    public WebElement getSearch()  {
        By Search = By.cssSelector("input[id='search_query_top']");
        waitForElement(Search, 10);
        return getElement(Search);
    }

    public WebElement getAddToCart()  {
        By AddToCart = By.cssSelector("p[id='add_to_cart']");
        waitForElement(AddToCart, 20);
        return getElement(AddToCart);
    }

    public List<WebElement> getCheckout()  {
        By Checkout = By.cssSelector("a[title='Proceed to checkout']");
        waitForElement(Checkout, 10);
        return getElements(Checkout);
    }

    public void testHomePage() throws Exception {
        driver.get("http://automationpractice.com/index.php");
    }

    public void selectFirstProduct(){
        if (getProduct() != null)
            getProduct().get(0).click();
        else
            Assert.fail("Product element is not available on Page");
    }

    public void clickAddToCart(){
        if (getAddToCart() != null)
            getAddToCart().click();
        else
            Assert.fail("AddToCard element is not available on Page");
    }

    public void selectSecondProduct(){
        if (getProduct() != null)
            getProduct().get(0).click();
        else
            Assert.fail("Product element is not available on Page");
    }

    public List<WebElement> getProduct()  {
        By Product = By.cssSelector("div[class='product-container']");
        waitForElement(Product, 10);
        return getElements(Product);
    }

    public void clickCheckout(){
        if (getCheckout() != null)
            getCheckout().get(0).click();
        else
            Assert.fail("Checkout element is not available on Page");
    }

    public void enterSearchItem(String Product) {
        if (getSearch() != null) {
            getSearch().clear();
            getSearch().sendKeys(Product);
            getSearch().submit();
        }
        else
            Assert.fail("Search element is not available on Page");
    }

    public String getPageHeading(){
        WebElement pageHeading = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        waitForElement(pageHeading, 10);
        return pageHeading.getText();
    }

    public void mainCheckOut(){
        WebElement checkOut = driver.findElement(By.xpath("//div[@id='center_column']//a[@title='Proceed to checkout']"));
        waitForElement(checkOut, 10);
        try {
            checkOut.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}