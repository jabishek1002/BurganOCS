package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC1_Login {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://ibswebtest.burgan.com/ib-retail-web/tenant/index");

        driver.findElement(By.id("userLogin")).sendKeys("sitocs_user04");
        driver.findElement(By.id("preloginintermediate")).click();

        //For Handling the secure question
        WebElement element = driver.findElement(By.xpath("//div[@class='form-group has-feedback']/label"));
        String text = element.getText();
        String[] split = text.split(" ");
        int length = split.length;
        String b = split[length-1].replace("?", "");
        if(b.contains("in"))
        {
            driver.findElement(By.id("userSecretAnswer")).sendKeys("in"+b);
            driver.findElement(By.id("validatesecurequestion")).click();
        }
        else
        {
            driver.findElement(By.id("userSecretAnswer")).sendKeys(b);
            driver.findElement(By.id("validatesecurequestion")).click();
        }

        //For handling secure image
        driver.findElement(By.xpath("//div[@class='form-group']/div")).click();
        driver.findElement(By.id("validatesecurequestion1")).click();
        //To enter the password
        driver.findElement(By.id("pwd")).sendKeys("Burgan@2015");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verifying whether the login is success or not
        driver.switchTo().frame("icanvas");
        WebElement element2 = driver.findElement(By.xpath("//h2[@class='module-title']"));
        String text2 = element2.getText();
        if(text2.contains("Dashboard")) {
            System.out.println("Login is successful");
        }
        else {
            System.out.println("Login is not successful");
        }

    }
}
