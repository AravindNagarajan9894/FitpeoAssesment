package testCases;

import java.time.Duration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.FitpeoHomepage;
import pageObjects.FitpeoRevenueCalculatorPage;

public class TC001_Fitpeo_ValidateTotalRecurringReimbursementValue extends BaseTestClass {
	String ExpectedResult="$110700";
	SoftAssert softAssert;
	@Test
	public void ValidateTotalRecurringReimbursementValue() throws InterruptedException {
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//creating object for home page and revenue calculator page
		FitpeoHomepage homepage = new FitpeoHomepage(driver);
		FitpeoRevenueCalculatorPage revenueCalcPage = new FitpeoRevenueCalculatorPage(driver);
		// Initialize SoftAssert 
		softAssert = new SoftAssert();
		try {	
			logger.info("Navigate to Revenue Calculator Page");
			homepage.clickRevenueCalculatorLink();
			logger.info("Slide down to Slider and Interact");
			revenueCalcPage.slideDownToSlider(driver);	
			logger.info("Moving slider to the specified value...");
			revenueCalcPage.MoveSlider(driver,property.getProperty("sliderValue"));
			logger.info("Validating slider and text field values...");
			//storing validation of slider and text field values
			boolean ValidationOne = revenueCalcPage.validateValuesOfSliderAndTextField();
			if(!ValidationOne)
				captureScreenshot("ValidationOne"); //Capturing screenshots if the validation didn't match requirement
			softAssert.assertTrue(ValidationOne); //Validation one - validation of slider and text field values
			logger.info("Clearing and setting patient text field...");
			revenueCalcPage.clearPatientsTextfield();
			revenueCalcPage.setValueInPatientsTextfield(driver,property.getProperty("textFieldValue"));
			logger.info("Validating slider and text field values...");
			//storing validation of slider and text field values
			boolean ValidationTwo = revenueCalcPage.validateValuesOfSliderAndTextField();
			if(!ValidationTwo)
				captureScreenshot("ValidationTwo"); //Capturing screenshots if the validation didn't match requirement
			softAssert.assertTrue(ValidationTwo); //Validation two - validation of slider and text field values
			logger.info("Selecting CPT checkboxes..");
			revenueCalcPage.selectCPT_99091CheckBox();
			revenueCalcPage.selectCPT_99453CheckBox();
			revenueCalcPage.selectCPT_99454CheckBox();
			revenueCalcPage.selectCPT_99474CheckBox();
			logger.info("Validating total recurring reimbursement value...");
			if(revenueCalcPage.validateTotalRecurringReimbursement(ExpectedResult)) { //Validation three - Validating TotalRecurringReimbursement
				logger.info("Test case passed sucessfully...");
				 softAssert.assertTrue(true); 
			}
			else
			{
				captureScreenshot("ValidationThree");//Capturing screenshots if the validation didn't match requirement
				logger.error("error message");
				logger.debug("Debug logs");
				softAssert.assertTrue(false); 
			}
		}
		catch(Exception exp) {
			logger.info("Test case didnot executed...");
			logger.info("Test case failed...");
			System.out.println(exp.getMessage());
			softAssert.assertTrue(false); 
		}
		finally {
			softAssert.assertAll();
		}
	}
}
