package Scenarios;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class scenario3 {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","C:\\Users\\deepanshusingh8\\Downloads\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[29]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        Thread.sleep(500);
        String input="Ex-Test";
        driver.switchTo().alert().sendKeys(input);
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(500);
        String text=driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();

        System.out.println(text);
        if(text.contains(input))
        {
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        JavascriptExecutor javascriptExecutor= (JavascriptExecutor)driver;
        WebElement source=driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement dest= driver.findElement(By.xpath("//div[@id='column-b']"));

        Thread.sleep(1000);
        Actions builder=new Actions(driver);
        builder.dragAndDrop(source,dest).build().perform();
        driver.switchTo().defaultContent();

        driver.quit();
}
    }
