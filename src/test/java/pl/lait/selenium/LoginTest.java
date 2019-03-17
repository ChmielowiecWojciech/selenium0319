package pl.lait.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.ReservationPage;
import pl.lait.pageObjects.ReservationPage2;

public class LoginTest {
	
	WebDriver driver;
	
	@Before
	public void bifor() {
		driver = Init.getDriver();
	}
	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.loginAs("WC920", "Airedale2");
	}
	
	@Test
	public void reserveTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.loginAs("WC920", "Airedale2");
		ReservationPage rp = new ReservationPage();
		rp.from("Frankfurt", "3", "15");
		rp.to("London", "6", "20");
		rp.passCount("2");
		rp.firstClass();
		rp.submit();
		//2gi etap
		ReservationPage2 rp2 = new ReservationPage2();
		rp2.selectFlights(1,1);
		rp2.submit();
		//3i etap
		rp2.pass0("Wojtek", "Chmiel", "KSML");
		Init.sleep(3);
		rp2.submit2();
		rp2.logOut();
		
	}
	@After
	public void awter(){
		//tu trzeba zamknąć przeglądarkę
		Init.close();
	}
	
}
