
public class CalcModel implements ICalcModel {

    private String _number;
    private String _operator;
    private double _totalNumber;
    private boolean _isNotUseDotInNumber;
    private boolean _isFirstTimeHere;
    private boolean _isStartTypeNewNum;

    CalcModel() {
        _totalNumber = 0;
        _isFirstTimeHere = true;
        _operator = "";
        init();
    }

    @Override
    public void addDigitToCurrentNumber(String digit) throws ArithmeticException {
        if (_isStartTypeNewNum && digit.equals("+/-")) {
            makeNegative();
        } else if (_isStartTypeNewNum && digit.equals(".")) {
            dotDigit();
        } else if ('0' <= digit.charAt(0) && digit.charAt(0) <= '9') {
            _isStartTypeNewNum = true;
            addDigit(digit);
        } else
            throw new ArithmeticException("First write a Number!");

    }

    private void dotDigit() throws ArithmeticException {
        if (_isNotUseDotInNumber) {
            _number += ".";
            _isNotUseDotInNumber = false;
        } else
            throw new ArithmeticException("You can't use 2 dots in number!");
    }

    private void makeNegative() {
        if (_number.charAt(0) == '-')
            _number = _number.substring(1);
        else
            _number = "-" + _number;
    }

    private void addDigit(String digit) {
        if (_number.equals("0"))
            _number = digit;
        else
            _number += digit;
    }

    @Override
    public String getCurrentNumber() {
        return _number;
    }

    @Override
    public void setOperator(String operator) {
        _operator = operator;
    }

    private void calculateNumbers(String operator) throws ArithmeticException {
        double number = Double.parseDouble(_number);
        if (_isStartTypeNewNum) {
            if (operator.equals("-")) {
                _totalNumber -= number;
            } else if (operator.equals("*")) {
                _totalNumber *= number;
            } else if (operator.equals("/")) {
                if (number == 0)
                    throw new ArithmeticException("You try divide by zero!");
                _totalNumber /= number;
            } else
                _totalNumber += number;
        }
    }

    @Override
    public String getTotalNumber() {
        if (_isFirstTimeHere) {
            _totalNumber = Double.parseDouble(_number);
            _isFirstTimeHere = false;
        } else
            calculateNumbers(_operator);
        init();
        return totalNumberToString();
    }

    private String totalNumberToString() {
        if (_totalNumber % 1 == 0) {
            return Integer.toString((int) _totalNumber);
        } else {
            return Double.toString(_totalNumber);
        }
    }

    private void init() {
        _isNotUseDotInNumber = true;
        _isStartTypeNewNum = false;
        _number = "0";
    }
}
