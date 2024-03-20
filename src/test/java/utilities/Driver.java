package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

/**
 * This class represents singleton WebDriver object, use this class's getDriver method everywhere in this
 * framework when you need a driver object
 */
public class Driver {





    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private Driver(){}

    public static synchronized WebDriver getDriver(){

        if(drivers.get() == null){

            String browserType = System.getProperty("browser"); // read the command line browser type

            if(browserType == null){ // if no browser is passed in command line
                browserType = ConfigReader.getProperty("browser").toLowerCase(); // use the one in config properties
            }




            switch (browserType){
                case "chrome" -> drivers.set(new ChromeDriver());
                case "firefox" ->drivers.set(new FirefoxDriver());
                case "edge" -> drivers.set(new EdgeDriver());
                case "safari" -> drivers.set(new SafariDriver());
                case "chrome-headless" -> drivers.set(new ChromeDriver(new ChromeOptions().addArguments("--headless").addArguments("window-size=1920x1080")));
                case "firefox-headless" -> drivers.set(new FirefoxDriver(new FirefoxOptions().addArguments("--headless").addArguments("window-size=1920x1080")));
                case "edge-headless" -> drivers.set(new EdgeDriver(new EdgeOptions().addArguments("--headless").addArguments("window-size=1920x1080")));
                default -> throw new IllegalArgumentException("Invalid driver.");
            }


        }


        return drivers.get();
    }

    public static synchronized void quitDriver(){

        if(drivers.get() != null){
            drivers.get().quit();
            drivers.remove();
        }

    }
}
