package Scenarios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Scenario1 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\deepanshusingh8\\Downloads\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[22]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a")).click();
        Thread.sleep(1000);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String title=driver.findElement(By.xpath("/html/body")).getText();
        System.out.println(title);


        driver.quit();
    }
}