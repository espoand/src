package utility;

public class DateConverter {
public java.sql.Date DateToSQLDate(java.util.Date data){
	java.sql.Date sqlDate = new java.sql.Date(data.getTime());
	return sqlDate;
	
}
}
