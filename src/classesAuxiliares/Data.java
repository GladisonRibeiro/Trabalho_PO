/*
 * Codigo da web:
 * Calendar c = Calendar.getInstance();
		Date data = c.getTime();//pega data atual
		DateFormat f = DateFormat.getDateInstance();
		Date data2;
		try {
			data2 = f.parse("12/01/1995");
			System.out.println(data2);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data formatada: " + sdf.format(data));
 */
package classesAuxiliares;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Data {

	private Date data;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setData(String data) {
		// tentar transformar String em data
		DateFormat f = DateFormat.getDateInstance();
		try {
			this.data = f.parse(data);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public Data(){
		super();
	}

	public Data(String data) {
		super();
		this.setData(data);
	}
	
	public boolean éIgual(Data data){
		if (this.data.equals(data.getData()) && !(this.data.compareTo(data.getData()) > 0 || this.data.compareTo(data.getData()) < 0))
			return true;
		else
			return false;
	}

}
