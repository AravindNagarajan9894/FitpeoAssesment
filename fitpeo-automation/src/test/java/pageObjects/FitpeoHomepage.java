package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FitpeoHomepage extends BasePage {
	WebDriver driver;
	
	public FitpeoHomepage(WebDriver driver) {
		super(driver);
	}
	//finding and storing web elements
	@FindBy(xpath="//div[text()=\"Revenue Calculator\"]") WebElement revenueCalculatorLink;
	
	//clicking the revenue calculator link
	public void clickRevenueCalculatorLink() {
		revenueCalculatorLink.click();
	}
}
