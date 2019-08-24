package cl.empresa.qa.mobile.android.pages;

import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentTest;

import cl.empresa.qa.mobile.android.helpers.Helper;
import cl.empresa.qa.mobile.android.helpers.MobilePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage extends MobilePage {
	
	private By ingresoTrello;
	private By usuario;
	private By password;
	private By loginElement;
	private By volver;

public LoginPage(AndroidDriver<AndroidElement> driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
	super(driver, test, TAKE_SS, seconds);

	// TODO completar los By
		
	this.ingresoTrello = By.id("com.trello:id/log_in_button");
	this.usuario = By.id("com.trello:id/user");
	this.password = By.id("com.trello:id/password");
	this.loginElement = By.id("com.trello:id/authenticate");
	this.volver = By.xpath("//android.widget.ImageButton[1]");
	}

	public void logearseATrello( String user, String clave, String subDir) {
		// TODO completar accion de logeo.
	
		driver.findElement(ingresoTrello).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Ingreso App", subDir, "Paso 1_AUTT-001");
		Helper.waitSeconds(5);	
		
		
		driver.findElement(usuario).sendKeys(user);
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Ingreso Usuario", subDir, "Paso 2_AUTT-002");
		Helper.waitSeconds(5);
		
		driver.findElement(password).sendKeys(clave);
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Ingreso Password", subDir, "Paso 3_AUTT-003");
		Helper.waitSeconds(5);
		
		driver.findElement(loginElement).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Ingreso Correcto", subDir, "Paso 4_AUT-004");
		Helper.waitSeconds(5);
		
		driver.findElement(volver).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Ingreso Correcto", subDir, "Paso 4_AUT-004");
		Helper.waitSeconds(5);
	}
}
