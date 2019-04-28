
public class Main {
   
    public static void main(String[] args) {
        ICalcModel      model      = new CalcModel();
        ICalcView       view       = new CalcView();
        ICalcController controller = new CalcController(model, view);

        controller.run();
    }
}
