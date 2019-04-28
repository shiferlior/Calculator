
public interface ICalcModel {

	void addDigitToCurrentNumber(String digit) throws Exception;

	String getCurrentNumber();

	void setOperator(String operator);

	String getTotalNumber();
}
