import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class withHead {
    public static void main(String[] args)throws InterruptedException  {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\deepanshusingh8\\Downloads\\chromedriver.exe"); //chromeDriver setup
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
        Thread.sleep(3000);
        String parentWindow= driver.getWindowHandle();
        String pageTitle= driver.getTitle();
        check(pageTitle);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/header/div/nav/a[4]")).click();
        String secondTitle= driver.getTitle();
        Check_2(pageTitle,secondTitle);


        Thread.sleep(3000);
        driver.switchTo().window(parentWindow);
        System.out.println("printing the current url "+driver.getCurrentUrl());
        driver.findElement(By.xpath("//nav[@class='clearfix']/child::a[2]")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();
    }


    public static void check(String pageTitle)
    {
        if(pageTitle.contains("PHPTRAVELS"))
        {
            System.out.println("PASS");
        }else
        {
            System.out.println("FAIL");
        }
    }
    public static void Check_2(String title1,String title2)
    {
        if(title1.equals(title2))
        {
            System.out.println("Test Pass");
        }else{
            System.out.println("Test Fail");
        }

    }
}
