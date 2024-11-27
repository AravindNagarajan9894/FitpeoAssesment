package testCases;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
public class BaseTestClass {
	public WebDriver driver;
	public Logger logger;
	public Properties property;
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) throws IOException {
		FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
	    property = new Properties();
	    property.load(file);
	    switch(browser) {
	    case "chrome" : driver= new ChromeDriver(); break;
	    case "edge"   : driver= new EdgeDriver(); break;
	    case "firefox": driver = new FirefoxDriver();break;
	    default : System.out.println("Invalid browser"); return;
	    }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property.getProperty("FitpeoUrl"));
		driver.manage().window().maximize();
		logger = LogManager.getLogger(this.getClass());
	    
	}
	@AfterClass
	public void quit() {
		driver.quit();
	}
	public void captureScreenshot(String screenshotName) {
		Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String formattedDate = formatter.format(date);
        
        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        String targetFileLocation = ".\\Screenshots\\"+screenshotName+"_"+formattedDate+".png";
        File targetFile = new File(targetFileLocation);
        sourceFile.renameTo(targetFile);
	}

}
