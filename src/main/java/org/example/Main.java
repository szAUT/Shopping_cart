package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/joy/Desktop/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        //driver.quit();
        }
    }
