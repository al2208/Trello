package cl.empresa.qa.mobile.android.vo;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import cl.empresa.qa.mobile.android.helpers.Helper;

public class PruebaVO {
	private String user;
	private String pass;
	private String nombreTablero;
	private String nombreLista;
	private String nombreTarjeta;
	private String textoCheckList;
	private String descripcion;

	public PruebaVO(String rutaExcel, String hoja) {

		XSSFSheet sheet = Helper.obtenerPaginaExcel(rutaExcel, hoja);

		this.user = Helper.obtenerCelda(sheet, 1, "B").getStringCellValue();
		this.pass = Helper.obtenerCelda(sheet, 2, "B").getStringCellValue();
		this.nombreTablero = Helper.obtenerCelda(sheet, 3, "B").getStringCellValue();
		this.nombreLista = Helper.obtenerCelda(sheet, 4, "B").getStringCellValue();
		this.nombreTarjeta = Helper.obtenerCelda(sheet, 5, "B").getStringCellValue();
		this.textoCheckList = Helper.obtenerCelda(sheet, 6, "B").getStringCellValue();
		this.descripcion = Helper.obtenerCelda(sheet, 7, "B").getStringCellValue();
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getTablero() {
		return nombreTablero;
	}
	
	public String getLista() {
		return nombreLista;
	}
	
	public String getTarjeta() {
		return nombreTarjeta;
	}
	
	public String getTextoCheckList() {
		return textoCheckList;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "pruebaVO [user=" + user + ", pass=" + pass + ", nombreTablero=" + nombreTablero + ", nombreLista=" + nombreLista + ", nombreTarjeta=" + nombreTarjeta + ", textoCheckList=" + textoCheckList + ", descripcion=" + descripcion + "]";
	}

}
