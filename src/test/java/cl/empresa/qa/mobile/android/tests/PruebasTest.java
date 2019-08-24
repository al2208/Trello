package cl.empresa.qa.mobile.android.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cl.empresa.qa.mobile.android.pages.CrearTablero;
import cl.empresa.qa.mobile.android.pages.CrearTarjeta;
import cl.empresa.qa.mobile.android.pages.EditarTarjeta;
import cl.empresa.qa.mobile.android.pages.LoginPage;
import cl.empresa.qa.mobile.android.vo.PruebaVO;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;



public class PruebasTest {
	private AndroidDriver<AndroidElement> driver;
	private ExtentReports extent;
	private ExtentTest test;
	private String SUBDIR;
	private static Boolean TAKE_SS = true;
	private static int WAIT = 5;

@Parameters({ "suite" })
@BeforeSuite
public void configExtentReports(String suite) {
		// ExtentReports config
	this.SUBDIR = suite + "\\";
	this.extent = new ExtentReports("ExtentReports/" + suite + ".html", true);
	this.extent.addSystemInfo("Host Name", "Tecnova Soluciones Informaticas SA");
	this.extent.addSystemInfo("Enviroment", "Automation Testing");
	this.extent.addSystemInfo("User Name", "Alejandro Ascencio");

	File conf = new File("src/test/resources/extentReports/extent-config.xml");
	this.extent.loadConfig(conf);

	}

@Parameters({ "device", "application", "app_package", "app_activity", "url_server" })
@BeforeMethod
public void configSelenium(String device, String application, String app_package, String app_activity,
	String url_server) throws MalformedURLException {

		// Configuracion del dispositivo.
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);

		// Configuracion de la app.
		// para una apk o una app ya instalada.
	if (!application.equals("none")) {
		File app = new File("src/test/resources/apks/" + application);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	} else {
		cap.setCapability("appPackage", app_package);
		cap.setCapability("appActivity", app_activity);
			// Esta capability permite no resetear la configuracion que ya tengamos de la
			// app.
		cap.setCapability("noReset", "true");
	}

		// Creamos el driver del servidor appium.
	driver = new AndroidDriver<>(new URL(url_server), cap);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	 
@Test
@Parameters ({"ruta_excel", "hoja"})
public void pruebaLogin(String ruta_excel, String hoja) {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();

		// Configuracion de reporte.
	test = extent.startTest("Reporte Ingreso Trello", "Prueba 01");
	test.log(LogStatus.INFO, "Inicio Login en Trello.-");

	System.out.println("Prueba de Ingreso Correcto a Trello");
	PruebaVO param = new PruebaVO (ruta_excel, hoja);
	LoginPage login = new LoginPage (driver, test, TAKE_SS, WAIT);
	login.logearseATrello(param.getUser(), param.getPass(),  subDir);
		
	}
@Test
@Parameters ({"ruta_excel", "hoja"})
public void pruebaTablero(String ruta_excel, String hoja) {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
	
	// Configuracion de reporte.
	test = extent.startTest("Reporte Creacion de Tablero en Trello", "Prueba 02");
	test.log(LogStatus.INFO, "Prueba Crear Tablero en Trello.-");

	System.out.println("Prueba de Creacion de Tablero");
	PruebaVO param = new PruebaVO (ruta_excel, hoja);
	CrearTablero tabl = new CrearTablero (driver, test, TAKE_SS, WAIT);
	tabl.tablero(param.getTablero(), param.getLista(), subDir);
	
	}
	
@Test
@Parameters ({"ruta_excel", "hoja"})
public void pruebaTarjeta(String ruta_excel, String hoja) {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
	
	// Configuracion de reporte.
	test = extent.startTest("Reporte Creacion de Tarjeta y Edicion en Trello", "Prueba 03");
	test.log(LogStatus.INFO, "Prueba de Crear y Editar en Trello.-");

	System.out.println("Prueba de Creacion de Tarjeta y editar");
	PruebaVO param = new PruebaVO (ruta_excel, hoja);
	
	CrearTarjeta tarjeta = new CrearTarjeta (driver, test, TAKE_SS, WAIT);
	tarjeta.tarjeta(subDir, param.getTarjeta());
	
	EditarTarjeta edit = new EditarTarjeta (driver, test, TAKE_SS, WAIT);
	edit.editar(subDir, param.getDescripcion(), param.getTextoCheckList());

	}

@AfterMethod
public void afterMethod(ITestResult result) {
	if (result.getStatus() == ITestResult.FAILURE) {
		test.log(LogStatus.FAIL, "Test failed.- <br>" + result.getThrowable());
	} else if (result.getStatus() == ITestResult.SKIP) {
		test.log(LogStatus.SKIP, "Test skipped.- <br>" + result.getThrowable());
	} else {
		test.log(LogStatus.PASS, "Test passed.-");
	}
	//driver.closeApp();
	extent.endTest(test);
	}

@AfterSuite
public void closeExtentReports() {
	extent.flush();
	}
}
