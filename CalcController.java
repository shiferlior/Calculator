
import javax.swing.*;
import java.awt.event.*;

public class CalcController implements ICalcController {

    private ICalcModel _model;
    private ICalcView  _view;
    

    CalcController(ICalcModel model, ICalcView view) {
        _model = model;
        _view  = view;
    }

    public void run(){
        _view.addDigitListener(new digitListener());
        _view.addOperatorListener(new operatorListener());
        _view.addEqualListener(new equalListener());

        _view.setTextOnCalcScreen("Enter a number");
    }

    private class digitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String digit = button.getActionCommand();
            try {
                _model.addDigitToCurrentNumber(digit);
                _view.setTextOnCalcScreen(_model.getCurrentNumber());
            } catch (Exception ex) {
                _view.showError(ex.getMessage());
            }
        }
    }

    private class operatorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String operator = button.getActionCommand();

            try{
                _view.setTextOnCalcScreen("Total: " + _model.getTotalNumber());
                _model.setOperator(operator);
            } catch (Exception ex) {
                _view.showError(ex.getMessage());
            }
        }
    }

    private class equalListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                _view.setTextOnCalcScreen("Equal: " + _model.getTotalNumber());
            } catch (Exception ex) {
                _view.showError(ex.getMessage());
            }
        }
    }
    

}
