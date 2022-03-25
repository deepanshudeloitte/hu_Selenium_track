import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class assignment4 {
    @Test(priority = 0)
    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepanshusingh8\\Downloads\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement username=driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement password=driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement login=driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();
        String actualUrl="https://www.saucedemo.com/inventory.html";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        if( driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).isEnabled()){
            Assert.assertTrue(Integer.parseInt(driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[2]/div/text()[2]") ).getText())<=100);
            driver.findElement(By.xpath("add-to-cart-sauce-labs-fleece-jacket")).click();
        }
    }
}


