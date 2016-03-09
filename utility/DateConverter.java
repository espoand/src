package utility;

import java.sql.Date;
import java.time.LocalDate;

public class DateConverter {
/** public java.sql.Date DateToSQLDate(java.util.Date data){
	java.sql.Date sqlDate = new java.sql.Date(data.getTime());
	return sqlDate;
	
}*/
	
public java.sql.Date  LocalDateToSQLDate(LocalDate data){
	return Date.valueOf(data);
}
}
