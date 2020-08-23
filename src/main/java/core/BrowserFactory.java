package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static String browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
    private static WebDriver instance;

    public static WebDriver getDriver(){
        if(instance == null){
            instance = startBrowser();
        }
        return instance;
    }

    private BrowserFactory(){}

    private static WebDriver startBrowser(){
       if(browser.equals("chrome")){
           WebDriverManager.chromedriver().setup();
           instance = new ChromeDriver();
       }
       else if(browser.equals("firefox")){
           WebDriverManager.firefoxdriver().setup();
           instance = new FirefoxDriver();
       }
       else if(browser.equals("edge")){
           WebDriverManager.edgedriver().setup();
           instance = new EdgeDriver();
       }

       instance.manage().window().maximize();
       instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       return instance;
    }

    public static void closeBrowser(){
        instance.close();
        instance.quit();
        instance = null;
    }

}
