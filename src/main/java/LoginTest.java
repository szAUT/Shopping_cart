import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/joy/Desktop/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("https://www.saucedemo.com");

            // Find the username and password input fields and enter valid credentials
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");

            // Find the login button and click it
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Verify that the user is logged in by checking for a welcome message
            WebElement welcomeMessage = driver.findElement(By.cssSelector(".title"));
            String welcomeText = welcomeMessage.getText();
            if (welcomeText.contains("Products")) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found on page: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

