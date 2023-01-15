package stepDefinitions;

import config.env;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

// extends -> inheritance
public class Hooks extends env {

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(true);
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + scenario.getName() + ".png"));
        }
        driver.quit();
    }


}
