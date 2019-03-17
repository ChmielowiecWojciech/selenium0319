package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pl.lait.selenium.Init;

public class ReservationPage2 {
	
	WebDriver driver;
	
	@FindBy (xpath = "/html/body/div/table/tbody/"
			+ "tr/td[2]/table/tbody/tr[4]/td/table/"
			+ "tbody/tr/td[2]/table/tbody/tr[5]/td/"
			+ "form/table[1]/tbody/tr[5]/td[1]/input")
	WebElement radio_d_1;
	
	
	@FindBy (xpath = "/html/body/div/table/tbody/tr/td"
			+ "[2]/table/tbody/tr[4]/td/table/tbody/tr/"
			+ "td[2]/table/tbody/tr[5]/td/form/table[2]/"
			+ "tbody/tr[5]/td[1]/input")
	WebElement radio_r_1;
	
	
	@FindBy (name = "reserveFlights")
	WebElement reserveFlightsBtn;
	
	//reservation 3 level start
	
	@FindBy (name = "passFirst0")
	WebElement passFirst0Input;
	
	@FindBy (name = "passLast0")
	WebElement passLast0Input;
	
	@FindBy(name = "pass.0.meal")
	WebElement meal0Select;
	
	@FindBy(name = "buyFlights")
	WebElement buyFlights;
	
	@FindBy (xpath = "/html/body/div/table/"
			+ "tbody/tr/td[2]/table/tbody/tr"
			+ "[4]/td/table/tbody/tr[1]/td[2"
			+ "]/table/tbody/tr[7]/td/table/tbody/tr/td[3]/a/img")
	WebElement logOut;
	
	//reservation 3 level end
	
	public ReservationPage2() {
		driver = Init.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void selectFlights(int departing, int returning) {
		switch (departing) {
		case 1:
			radio_d_1.click();
			break;
		default:
			break;
		}
		
		switch (returning) {
		case 1:
			radio_r_1.click();
			break;
		default:
			break;
		}				
	}
	public void submit() {
		reserveFlightsBtn.click();
	}
	
	public void pass0(String firstName, String lastName, String mealCode) {
		passFirst0Input.sendKeys(firstName);
		passLast0Input.sendKeys(lastName);
		Select m = new Select (meal0Select);
		m.selectByValue(mealCode);
		}
	public void submit2() {
		buyFlights.click();
		
	}
	public void logOut() {
		logOut.click();
	}
}
