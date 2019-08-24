package cl.empresa.qa.mobile.android.pages;

import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentTest;
import cl.empresa.qa.mobile.android.helpers.Helper;
import cl.empresa.qa.mobile.android.helpers.MobilePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EditarTarjeta extends MobilePage {
	
	private By etiqueta;
	private By colorEtiqueta;
	private By confirmarColor;
	private By miembro;
	private By selMiembro;
	private By miembroConfirma;
	private By ingresarFecha;
	private By selFecha;
	private By selDia;
	private By guardarFecha;
	private By checkBoxFecha;
	private By checkList;
	private By ingresoTextoChk;
	private By confirmarTextoChk;
	private By marcarBoxChkList;
	private By ingresarDescripcion;
	private By confirmarDescripcion;
	
public EditarTarjeta (AndroidDriver<AndroidElement> driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
	super(driver, test, TAKE_SS, seconds);
	
	this.etiqueta = By.id("com.trello:id/icon");
	this.colorEtiqueta = By.id("com.trello:id/label_container");
	this.confirmarColor = By.id("com.trello:id/confirm");
	this.miembro = By.xpath("(//android.widget.LinearLayout)[3]");
	this.selMiembro = By.id("com.trello:id/initials_text_view");
	this.miembroConfirma = By.id("android:id/button1");
	this.ingresarFecha = By.id("com.trello:id/date");
	this.selFecha = By.id("com.trello:id/date_button");
	this.selDia = By.xpath("(//android.widget.CheckedTextView)[3]");
	this.guardarFecha = By.xpath("//android.widget.Button[@text='HECHO']"); 
	this.checkBoxFecha = By.id("com.trello:id/checkbox");
	this.checkList = By.xpath("//android.widget.LinearLayout[4]");
	this.ingresoTextoChk = By.id("com.trello:id/add_checkitem_edit_text");
	this.confirmarTextoChk = By.id("com.trello:id/confirm");
	this.marcarBoxChkList = By.xpath("(//android.widget.CheckBox)[2]");
	this.ingresarDescripcion = By.id("com.trello:id/card_description");
	this.confirmarDescripcion = By.id("com.trello:id/confirm");
}

public void editar (String subDir, String descrip, String textchk) {
		
	driver.findElement(ingresarDescripcion).sendKeys(descrip);
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Ingresar Descripcion", subDir, "Paso 31_AUTT-031");
	Helper.waitSeconds(5);
	
	driver.findElement(confirmarDescripcion).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Confirmar Descripcion", subDir, "Paso 32_AUTT-032");
	Helper.waitSeconds(5);
	
	driver.findElement(etiqueta).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Editar Tarjeta", subDir, "Paso 15_AUTT-015");
	Helper.waitSeconds(5);
	
	driver.findElement(colorEtiqueta).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Color Etiqueta", subDir, "Paso 16_AUTT-016");
	Helper.waitSeconds(5);
	
	driver.findElement(confirmarColor).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Confirmar Color Etiqueta", subDir, "Paso 17_AUTT-017");
	Helper.waitSeconds(5);
	
	driver.findElement(miembro).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Miembro", subDir, "Paso 18_AUTT-018");
	Helper.waitSeconds(5);
	
	driver.findElement(selMiembro).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Seleccionar Miembro", subDir, "Paso 19_AUTT-019");
	Helper.waitSeconds(5);
	
	driver.findElement(miembroConfirma).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Confirmar Miembro", subDir, "Paso 20_AUTT-020");
	Helper.waitSeconds(5);
	
	driver.findElement(ingresarFecha).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Ingresar Fecha", subDir, "Paso 21_AUTT-021");
	Helper.waitSeconds(5);
	
	driver.findElement(selFecha).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Seleccionar Fecha", subDir, "Paso 22_AUTT-022");
	Helper.waitSeconds(5);
	
	driver.findElement(selDia).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Seleccionar Dia", subDir, "Paso 23_AUTT-023");
	Helper.waitSeconds(5);
	
	driver.findElement(guardarFecha).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Guardar Dia", subDir, "Paso 24_AUTT-024");
	Helper.waitSeconds(5);
	
	driver.findElement(checkBoxFecha).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Check Box Fecha", subDir, "Paso 25_AUTT-025");
	Helper.waitSeconds(5);
	
	driver.findElement(checkList).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Check List", subDir, "Paso 26_AUTT-026");
	Helper.waitSeconds(5);
	
	driver.findElement(ingresoTextoChk).sendKeys(textchk);
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Ingresar Texto Check List", subDir, "Paso 28_AUTT-028");
	Helper.waitSeconds(5);
	
	driver.findElement(confirmarTextoChk).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Confirmar Texto Check List", subDir, "Paso 29_AUTT-029");
	Helper.waitSeconds(5);
	
	driver.findElement(marcarBoxChkList).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOTRELLO: Marcar ChekBox Texto Check List", subDir, "Paso 30_AUTT-030");
	Helper.waitSeconds(5);
	

	
}

}
