package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FitpeoRevenueCalculatorPage extends BasePage {
	WebDriver driver;
	JavascriptExecutor js;
	public FitpeoRevenueCalculatorPage(WebDriver driver) {
		super(driver);
	    js = (JavascriptExecutor) driver;
	}
	
	//finding and storing web elements
	@FindBy(xpath="//span[@class=\"MuiSlider-rail css-3ndvyc\"]") WebElement calculatorSlider;
	@FindBy(xpath="//span[contains(@class,\"MuiSlider-thumb\")]/input") WebElement calculatorSliderPointer;
	@FindBy(xpath="(//div[contains(@class,\"MuiGrid-root MuiGrid-item\")])[2]") WebElement sliderWithTextFieldArea;
	@FindBy(xpath="//input[contains(@class,\"MuiInputBase-input\")]") WebElement patientsTextfield;
	@FindBy(xpath="(//input[contains(@class,\"PrivateSwitchBase-input\")])[1]") WebElement CPT_99091CheckBox;
	@FindBy(xpath="(//input[contains(@class,\"PrivateSwitchBase-input\")])[2]") WebElement CPT_99453CheckBox;
	@FindBy(xpath="(//input[contains(@class,\"PrivateSwitchBase-input\")])[3]") WebElement CPT_99454CheckBox;
	@FindBy(xpath="(//input[contains(@class,\"PrivateSwitchBase-input\")])[8]") WebElement CPT_99474CheckBox;
	@FindBy(xpath="//p[contains(text(),\"Total Recurring \")]/p") WebElement totalRecurringReimbursementValue;
	
	// Scroll to the slider
	public void slideDownToSlider(WebDriver driver) {
        //js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'});", sliderWithTextFieldArea);
		js.executeScript("arguments[0].scrollIntoView();",sliderWithTextFieldArea );
	}
	 // Move slider to a specific value
	public void MoveSlider(WebDriver driver, String target) {
	    try {
			Actions sliderAction = new Actions(driver);
			int sliderWidth = calculatorSlider.getSize().getWidth();
	
			// Calculate the offset for the desired value
			int targetValue = Integer.parseInt(target);
			int minValue = 0; // Minimum value of the slider
			int maxValue = 2000; // Maximum value of the slider
			int currentValue = Integer.parseInt(calculatorSliderPointer.getAttribute("aria-valuenow"));
			int offset = (int) ((double) (targetValue - currentValue) / (maxValue - minValue) * sliderWidth);
	
			// Perform the drag-and-drop action
			sliderAction.clickAndHold(calculatorSliderPointer).moveByOffset(offset, 0).release().perform();
			sliderAction.keyDown(Keys.ARROW_RIGHT).keyUp(Keys.ARROW_RIGHT).
			keyDown(Keys.ARROW_RIGHT).keyUp(Keys.ARROW_RIGHT).
			keyDown(Keys.ARROW_RIGHT).keyUp(Keys.ARROW_RIGHT).perform();
	    }
	    catch(Exception e){
	    	 System.out.println("Error while moving the slider: " + e.getMessage());
	    }
	}
	// Clear text field
	public void clearPatientsTextfield() {
		 try {
			 patientsTextfield.clear();
	        } catch (Exception e) {
	            System.out.println("Error while clearing the text field: " + e.getMessage());
	        }
	}
	 // Set value in the text field using JavaScriptExecutor
	public void setValueInPatientsTextfield(WebDriver driver, String  value) {
		try {
		 js.executeScript("arguments[0].value=arguments[1];", patientsTextfield, value);
		}
		catch (Exception e) {
            System.out.println("Error while setting value in text field: " + e.getMessage());
        }
	}
    // Validate slider value matches text field value
	public boolean validateValuesOfSliderAndTextField() {
		 try {
	            String sliderValue = calculatorSliderPointer.getAttribute("value");
	            String textFieldValue = patientsTextfield.getAttribute("value");
	            return sliderValue.equals(textFieldValue);
	        } catch (Exception e) {
	            System.out.println("Error while validating slider and text field values: " + e.getMessage());
	            return false;
	        }
	}
	//select checkboxes
	public void selectCPT_99091CheckBox() {
		CPT_99091CheckBox.click();
	}
	public void selectCPT_99453CheckBox() {
		CPT_99453CheckBox.click();
	}
	public void selectCPT_99454CheckBox() {
		CPT_99454CheckBox.click();
	}
	public void selectCPT_99474CheckBox() {
		CPT_99474CheckBox.click();
	}	
	 // Validate total recurring reimbursement
	public boolean validateTotalRecurringReimbursement(String expectedResult) {
		try {
			String actualResult = totalRecurringReimbursementValue.getText();
			return actualResult.equals(expectedResult);
		}
		catch (Exception e) {
            System.out.println("Error while validating total reimbursement: " + e.getMessage());
            return false;
        }
	}
}
