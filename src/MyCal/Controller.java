// This is the main controller for the calculator .......

// Main package for Cal.....
package MyCal;


// Importing JavaFX packages ..........
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// Importing Maths package for cal .........
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

// Importing other important libraries......
import java.net.URL;
import java.util.ResourceBundle;



// Main class for calculations  ............
public final class Controller implements Initializable {


    public void insertAnswer(String answer ){
        CAL.setText(CAL.getText()+answer);
    }

//initializing.....
    private BigDecimal left;
    private String selectOperator;
    private boolean numberInputting;

// initialize two text fields.......
    @FXML
    private TextField CAL;
    @FXML
    private TextField ANS;


    /** calling hooke's law scene*/
    public void HookesLawController(){
        try{                             // Use try to load UI ........
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MyCal/HookesLaw/HookesLaw.fxml"));
            Parent root = loader.load();
            Main.getHookesLaw().setScene(new Scene(root));
            Main.getHookesLaw().show();



        }catch (Exception ex){         // Catching Exceptions ......
            System.out.println(ex);    // printing exception out .....
        }

    }
    /** calling Stress Calculations scene*/
    public void StressController() {
        try {                                    // Use try to load UI ........
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MyCal/StressCal/StressCal.fxml"));
            Parent root = loader.load();
            Main.getStressCal().setScene(new Scene(root));
            Main.getStressCal().show();


        } catch (Exception ex) {         // Catching Exceptions ......
            System.out.println(ex);      // printing exception out .....
        }
    }

    /** calling help scene*/
        public void HelpController(){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/MyCal/Help/Help.fxml"));
                Parent root = loader.load();
                Main.getHelp().setScene(new Scene(root));
                Main.getHelp().show();



            }catch (Exception ex){           // Catching Exceptions ......
                System.out.println(ex);      // printing exception out .....
            }
    }

//constructor method...

    public Controller() {
        this.left = BigDecimal.ZERO ;
        this.selectOperator = "";
        this.numberInputting = false;
    }

    //giving actions to buttons..
    @FXML
    public void operateButton(ActionEvent evt){
        Button button = (Button)evt.getSource();
        String buttonText = button.getText();

        //clear button
        if(buttonText.equals("CLEAR")){
            if (buttonText.equals("CLEAR")){
                left = BigDecimal.ZERO;
            }
            selectOperator = "";
            numberInputting = true;
            CAL.setText("");  // Clear input text .....
            ANS.setText("");  // Clear answer text .....
            return;
        }


        //numerical buttons and point...
        if (buttonText.matches("[0-9\\.]")){
            if (!numberInputting){
                numberInputting =true;
                CAL.clear();

            }
              CAL.appendText(buttonText);
              ANS.appendText(buttonText);    // Set text to display .......
            return;
        }

        //Maths basic operations buttons..
        if (buttonText.matches("[/x+-]")){
            left=new BigDecimal(CAL.getText());
            selectOperator = buttonText;
            numberInputting =false;
            CAL.appendText(buttonText);
            ANS.appendText(buttonText);    // Set text to display .......
            return;

        }
        //Square root button..
        if (buttonText.equals("Sqr")){
            left=new BigDecimal(CAL.getText());
            MathContext mc = new MathContext(6);
            BigDecimal squareRoot= left.sqrt(mc);
            ANS.appendText(buttonText);
            CAL.setText(squareRoot.toString());    // Set text to display .......


        }
        //2nd power button..
        if (buttonText.equals("^2")){
            String a=CAL.getText();
            double square =Math.pow(Double.parseDouble(a),2);
            CAL.setText(String.valueOf(square));
            ANS.appendText(buttonText);
        }

        //3rd power button..
        if (buttonText.equals("^3")){
            String a=CAL.getText();
            double cubic =Math.pow(Double.parseDouble(a),3);
            CAL.setText(String.valueOf(cubic));    // Set text to display .......
            ANS.appendText(buttonText);
        }

        //ANS button....
        if (buttonText.equals("ANS")) {
            String a=CAL.getText();
            insertAnswer(a.substring(1));
            ANS.appendText(buttonText);
            CAL.clear();
         return;
        }
        // 1/x button..
            if (buttonText.equals("1/x")){
            left=new BigDecimal(CAL.getText());
            BigDecimal byx= BigDecimal.valueOf(1).divide(left,5,RoundingMode.HALF_UP);

            CAL.setText(byx.toString());    // Set text to display .......
        }

        //equal button...
        if (buttonText.equals("=")){
            final BigDecimal right = numberInputting ? new BigDecimal(CAL.getText()):left;

            left = calculate(selectOperator,left,right);
            CAL.setText(left.toString());    // Set text to display .......
            ANS.appendText(buttonText);

            numberInputting =false;
            return;
        }
        //hooke's law button..
        if(buttonText.equals("Hooke's Law")){
            HookesLawController();
        }
        //stress calculation button..
        if (buttonText.equals("Stress Cal")){
            StressController();
        }
        //help button..
        if (buttonText.equals("Help")){
            HelpController();}
    }
    // Main calculations.....
    public static BigDecimal calculate(String operator,BigDecimal left,BigDecimal right){
        switch (operator) {
            case "+" :

                return left.add(right);
            case "-" :
                return left.subtract(right);
            case "x" :
                return left.multiply(right);
            case "/" :
                try {
                    return left.divide(right,4,RoundingMode.HALF_UP);   //rounding up for 4 decimals..
                }
                catch (ArithmeticException ex){
                    throw new ArithmeticException("Non-terminating decimal expansion; " + "no exact representable decimal result.");
                }
        }
        return right;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
