import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.interactions.Actions;

public class Shopping {

    private WebDriver driver;

   @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/joy/Desktop/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Before
    public void i_am_logged_in() {
        System.setProperty("webdriver.chrome.driver", "/Users/joy/Desktop/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement profileLink = driver.findElement(By.className("app_logo"));
        String profileLinkText = profileLink.getText();
        assertEquals(profileLinkText, "Swag Labs");

    }

    @After
    public void teardown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        WebElement profileLink = driver.findElement(By.className("app_logo"));
        String profileLinkText = profileLink.getText();
        assertEquals(profileLinkText, "Swag Labs");
    }

    @Given("the user is on the product page")
    public void userIsOnProductPage() {
        //System.setProperty("webdriver.chrome.driver", "/Users/joy/Desktop/chrome/chromedriver");
        //driver = new ChromeDriver();
        //driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("the user clicks the \"Add to Cart\" button")
    public void userClicksAddToCart() {

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        addToCartButton.click();
    }

    @Then("the product is added to the cart")
    public void productIsAddedToCart() {
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
    }

    @And("the cart contains the added product")
    public void cartContainsAddedProduct() {
        WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
        cartIcon.click();
        WebElement addedProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name' and contains(text(), 'Sauce Labs Onesie')]"));
        assert(addedProduct.isDisplayed());
        driver.quit();
    }

    @When("I click on the cart icon")
    public void i_click_on_the_cart_icon() {
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
    }

    @Then("I should be on the cart page")
    public void i_should_be_on_the_cart_page() {
        String expectedTitle = "Your Cart";
        assertEquals(expectedTitle, driver.getTitle());
    }

    @And("I should see the correct product in the cart")
    public void i_should_see_the_correct_product_in_the_cart() {
        WebElement addedProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name' and contains(text(), 'Sauce Labs Onesie')]"));
        assert(addedProduct.isDisplayed());
        driver.quit();
    }

    @When("I click on the checkout button")
    public void i_click_on_the_checkout_button() {
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();
    }

    @Then("I should be on the checkout page")
    public void i_should_be_on_the_checkout_page() {
        WebElement title = driver.findElement(By.cssSelector("span.title"));
        String expectedTitle = "Checkout: Your Information";
        assertEquals(expectedTitle, title.getText());
    }

    @When("I click on the complete purchase button")
    public void i_click_on_the_complete_purchase_button() {
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
        WebElement finishBtn = driver.findElement(By.id("finish"));
        finishBtn.click();
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        WebElement confirmationMsg = driver.findElement(By.className("checkout_complete_container"));
        assertTrue(confirmationMsg.isDisplayed());
    }

    @And("I should receive an email confirming my purchase")
    public void i_should_receive_an_email_confirming_my_purchase() {
        // code to check email
    }

    @Given("I am on the cart page")
    public void iAmOnTheCartPage() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
        WebElement title = driver.findElement(By.cssSelector("span.title"));
        String expectedTitle = "Your Cart";
        assertEquals(expectedTitle, title.getText());
    }

    @And("I have one product in my cart")
    public void iHaveOneProductInMyCart() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        addToCartButton.click();
    }

    @Given("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
       //navigate to the cart page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        WebElement title = driver.findElement(By.cssSelector("span.title"));
        String expectedTitle = "Checkout: Your Information";
        assertEquals(expectedTitle, title.getText());

    }

    @And("I fill in my shipping details")
    public void iFillInMyShippingDetails() {
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        WebElement postalcodeInput = driver.findElement(By.id("postal-code"));

        firstNameInput.sendKeys("Test");
        lastNameInput.sendKeys("Test");
        postalcodeInput.sendKeys("1234AB");
    }
}


