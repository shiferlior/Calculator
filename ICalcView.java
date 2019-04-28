import java.awt.event.ActionListener;

public interface ICalcView {

	void addDigitListener(ActionListener multiplyListener);

	void showError(String string);

	void addOperatorListener(ActionListener listener);

	void addEqualListener(ActionListener listener);

	void setTextOnCalcScreen(String newText);

}
