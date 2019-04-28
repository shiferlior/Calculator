
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class CalcView extends JFrame implements ICalcView {

    private JPanel _digitPanel;
    private JPanel _operatorsPanel;

    private JTextField _calcScreenTf = new JTextField(20);
    private JButton[] _numbersBtn = new JButton[10];
    private JButton _multiplyBtn = new JButton("*");
    private JButton _divideBtn = new JButton("/");
    private JButton _plusBtn = new JButton("+");
    private JButton _minusBtn = new JButton("-");
    private JButton _signBtn = new JButton("+/-");
    private JButton _dotBtn = new JButton(".");
    private JButton _equalBtn = new JButton("=");

    CalcView() {
        super("Calculator");
        setVisible(true);

        _calcScreenTf.setEditable(false);
        _digitPanel = buildDigitsButtons();
        _operatorsPanel = buildOperatorsPanel();

        this.add(_calcScreenTf, BorderLayout.NORTH);
        this.add(_digitPanel, BorderLayout.CENTER);
        this.add(_operatorsPanel, BorderLayout.EAST);
        this.add(_equalBtn, BorderLayout.SOUTH);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel buildDigitsButtons() {
        JPanel digit = new JPanel(new GridLayout(4, 3));
        for (int i = 9; i >= 0; i--) {
            _numbersBtn[i] = new JButton();
            _numbersBtn[i].setText(String.valueOf(i));
            digit.add(_numbersBtn[i]);
        }
        digit.add(_dotBtn);
        digit.add(_signBtn);
        return digit;
    }

    private JPanel buildOperatorsPanel() {
        JPanel operatorsPanel = new JPanel(new GridLayout(4, 1));
        operatorsPanel.add(_plusBtn);
        operatorsPanel.add(_minusBtn);
        operatorsPanel.add(_multiplyBtn);
        operatorsPanel.add(_divideBtn);
        return operatorsPanel;
    }

    public void setTextOnCalcScreen(String newText) {
        _calcScreenTf.setText(newText);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public void addDigitListener(ActionListener listener) {
        for (JButton digitBtn : _numbersBtn) {
            digitBtn.addActionListener(listener);
        }
        _dotBtn.addActionListener(listener);
        _signBtn.addActionListener(listener);
    }

    public void addOperatorListener(ActionListener listener) {
        _multiplyBtn.addActionListener(listener);
        _divideBtn.addActionListener(listener);
        _plusBtn.addActionListener(listener);
        _minusBtn.addActionListener(listener);
    }

    public void addEqualListener(ActionListener listener) {
        _equalBtn.addActionListener(listener);
    }

}
