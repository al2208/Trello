package cl.empresa.qa.mobile.android.pages;

import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentTest;
import cl.empresa.qa.mobile.android.helpers.Helper;
import cl.empresa.qa.mobile.android.helpers.MobilePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class CrearTablero extends MobilePage {
	
	private By ingresoTablero;
	private By nombreTablero;
	private By crearTablero;
	private By nuevaLista;
	private By nombreLista;
	private By crearLista;
		
public CrearTablero (AndroidDriver<AndroidElement> driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
	super(driver, test, TAKE_SS, seconds);
	
	this.ingresoTablero = By.id("com.trello:id/add_fab");
	this.nombreTablero = By.id("com.trello:id/board_name");
	this.crearTablero = By.id("android:id/button1");
	this.nuevaLista = By.id("com.trello:id/add_list_button");
	this.nombreLista = By.id("com.trello:id/list_name_edit_text");
	this.crearLista = By.id("com.trello:id/confirm");
	//
}

public void tablero ( String nomb, String lista, String subDir) {
	
	driver.findElement(ingresoTablero).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Ingreso Tablero", subDir, "Paso 5_AUTT-005");
	Helper.waitSeconds(5);
	
	driver.findElement(nombreTablero).sendKeys(nomb);
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Nombre Tablero", subDir, "Paso 6_AUTT-006");
	Helper.waitSeconds(5);
	
	driver.findElement(crearTablero).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Crear Tablero", subDir, "Paso 7_AUTT-007");
	Helper.waitSeconds(5);
	
	driver.findElement(nuevaLista).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Nueva Lista", subDir, "Paso 8_AUTT-008");
	Helper.waitSeconds(5);
	
	driver.findElement(nombreLista).sendKeys(lista);
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Nombre Lista", subDir, "Paso 9_AUTT-009");
	Helper.waitSeconds(5);
	
	driver.findElement(crearLista).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Crear Lista", subDir, "Paso 10_AUTT-010");
	Helper.waitSeconds(5);
}

}
