package sample;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestProgram {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://login.salesforce.com/?locale=in");
    }
}
