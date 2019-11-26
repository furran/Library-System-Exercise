package biblioteca.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DataFormato {
	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String formatar(Date data) {
		return dateFormat.format(data);
	}
	
}
