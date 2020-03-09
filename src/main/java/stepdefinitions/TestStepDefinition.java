package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import steps.TestPage;

/**
 * Step Definition for Automation Practice feature
 */
public class TestStepDefinition extends BaseSteps {
    WebDriver driver;

    TestPage worklistPage = new TestPage(driver);

    public TestStepDefinition() throws Exception {
    }

    /**
     * Open the Browser and launch the website automationpractice.com
     */
    @Given("^I am on test page$")
    public void i_am_on_test_page() throws Exception {
        worklistPage.testHomePage();
    }

    /**
     * Pass the item Number and item Name for adding items to cart through feature file
     * @param itemNumber
     * @param itemName
     */
    @And("^I search the ([^\"]*) \"([^\"]*)\" and Add to cart$")
    public void i_search_product_and_Add_to_cart(String itemNumber, String itemName) throws Throwable {
        worklistPage.enterSearchItem(itemName);
        if(itemNumber.contains("first")){
            worklistPage.selectFirstProduct();
        }else if(itemNumber.contains("second")){
            worklistPage.selectSecondProduct();
        }else{
            System.out.println("For this test we only adding two items");
        }
        worklistPage.clickAddToCart();
    }

    /**
     * Checkout the items which already added to cart
     */
    @When("^I checkout the items$")
    public void i_checkout_the_items() {
        worklistPage.clickCheckout();
        worklistPage.mainCheckOut();
    }

    /**
     * Assert if checkout done correctly and user is on Authentication Page.
     */
    @Then ("^I should see the Authentication page$")
    public void i_should_see_the_authentication_page(){
        Assert.assertEquals("authentication",worklistPage.getPageHeading().toLowerCase());
        worklistPage.driver.quit();
    }
}