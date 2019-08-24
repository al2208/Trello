package cl.empresa.qa.mobile.android.pages;

import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentTest;
import cl.empresa.qa.mobile.android.helpers.Helper;
import cl.empresa.qa.mobile.android.helpers.MobilePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class CrearTarjeta extends MobilePage {
	
	private By ingresarTablero;
	private By tarjeta;
	private By nombreTarjeta;
	private By crearTarjeta;
	private By tarjetaCreada;
	
public CrearTarjeta (AndroidDriver<AndroidElement> driver, ExtentTest test, Boolean TAKE_SS, int seconds)	{
	super(driver, test, TAKE_SS, seconds);
	
	this.ingresarTablero = By.xpath("(//android.widget.LinearLayout)[4]");
	this.tarjeta = By.id("com.trello:id/add_button");
	this.nombreTarjeta = By.id("com.trello:id/card_name_edit_text");
	this.crearTarjeta = By.id("com.trello:id/confirm");
	this.tarjetaCreada = By.id("com.trello:id/cardText");
	
}

public void tarjeta (String subDir, String tarjet) {
	
	driver.findElement(ingresarTablero).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Crear tarjeta", subDir, "Paso 28_AUTT-028");
	Helper.waitSeconds(5);
	
	driver.findElement(tarjeta).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Crear tarjeta", subDir, "Paso 11_AUTT-011");
	Helper.waitSeconds(5);
	
	driver.findElement(nombreTarjeta).sendKeys(tarjet);
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Nombre Tarjeta", subDir, "Paso 12_AUTT-012");
	Helper.waitSeconds(5);
	
	driver.findElement(crearTarjeta).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Crear Tarjeta", subDir, "Paso 13_AUTT-013");
	Helper.waitSeconds(5);
	
	driver.findElement(tarjetaCreada).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Tarjeta Creada", subDir, "Paso 14_AUTT-014");
	Helper.waitSeconds(5);
}

}
