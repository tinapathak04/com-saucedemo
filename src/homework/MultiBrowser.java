package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // 1.Setup Multi browser

        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else {
            System.out.println("Invalid input");
        }


        //2. Open Url
        driver.get(baseUrl);

        //Maximize Screen
        driver.manage().window().maximize();

        // Implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3.Print title of the page
        System.out.println("Page title is : " + driver.getTitle());

        //4.Print the cuurent Url
        System.out.println("Current Url is : " + driver.getCurrentUrl());

        //5.Print the page source
        System.out.println("Page source is :"  + driver.getPageSource());

        //6. Enter the Email to Email field
        //find the email element
        WebElement usernameField = driver.findElement(By.name("user-name"));

        //Action is to type username
        usernameField.sendKeys("tv@gmail.com");

        //7. Enter the password to password field
        WebElement passwordField = driver.findElement(By.id("password"));

        //Action is to type password
        passwordField.sendKeys("tv123");

        //hold Screen
        Thread.sleep(2000);

        //8. Close the Browser
        driver.close();
    }
}
