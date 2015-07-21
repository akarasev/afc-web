package afc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://xn--f1aijeow.xn--p1ai/office/auth");
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        WebElement userName = driver.findElement(By.id("userName"));
        WebElement userPass= driver.findElement(By.id("userPass"));
        userName.sendKeys("demo");
        userPass.sendKeys("demo");
        
        WebElement logInButton = driver.findElement(By.id("submitButton"));
        logInButton.submit();
        
        driver.switchTo().defaultContent();
        
        WebElement accountButton = driver.findElement(By.cssSelector("div.office-menu > a.fancybox"));
        accountButton.click();

        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        WebElement countersTab = driver.findElement(By.cssSelector("div.main-nav > a[href='/room/lk/counters.action']"));
        countersTab.click();
        
        WebElement counterFieldCold = driver.findElement(By.cssSelector("input[name='counterValue[0]']"));
        counterFieldCold.sendKeys("150");
        WebElement counterFieldHot = driver.findElement(By.cssSelector("input[name='counterValue[1]']"));
        counterFieldHot.sendKeys("202");

        WebElement saveButton = driver.findElement(By.cssSelector("a.save"));
        saveButton.click();

        WebElement approveButton = driver.findElement(By.cssSelector("td[align='left'] > a.btn-rc"));
        approveButton.click();

        WebElement discardButton = driver.findElement(By.cssSelector("td.left > a.btn-rc"));
        discardButton.click();
        
        driver.quit();
        
        SpringApplication.run(Application.class, args);
    }
}
