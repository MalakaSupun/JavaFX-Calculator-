// This is for calculations of stress equation..........
package MyCal.StressCal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
// Main class .....
public class StressCal {

    //initialize all the text fields and buttons....
    @FXML
    private TextField TextA1;
    @FXML
    private TextField TextA2;
    @FXML
    private TextField AnsA;
    @FXML
    private TextField TextB1;
    @FXML
    private TextField TextB2;
    @FXML
    private TextField AnsB;
    @FXML
    private TextField TextC1;
    @FXML
    private TextField TextC2;
    @FXML
    private TextField AnsC;


    // creating big decimal for division..and rounding.....
    BigDecimal num1;
    BigDecimal num2;



    //giving actions to buttons..
    public void operateButton(ActionEvent evt){
        Button button = (Button)evt.getSource();
        String buttonText = button.getText();

       //Getting stress...
        if (buttonText.equals("Stress =")){

             num1= BigDecimal.valueOf(Double.parseDouble(TextA1.getText())); // first number ....
             num2= BigDecimal.valueOf(Double.parseDouble(TextA2.getText())); // second number ....

           BigDecimal ans1= num1.divide(num2,4, RoundingMode.HALF_UP);
            AnsA.setText(String.valueOf(ans1));
        }

        //Getting force....
        else if (buttonText.equals("Force =")){

            num1= BigDecimal.valueOf(Double.parseDouble(TextB1.getText()));  // first number ....
            num2= BigDecimal.valueOf(Double.parseDouble(TextB2.getText()));  // second number ....

            BigDecimal ans1= num1.multiply(num2);
            AnsB.setText(String.valueOf(ans1));
        }

        //Getting area.....
        else if (buttonText.equals("Area =")){

            num1= BigDecimal.valueOf(Double.parseDouble(TextC1.getText()));  // first number ....
            num2= BigDecimal.valueOf(Double.parseDouble(TextC2.getText()));  // second number ....

            BigDecimal ans1= num1.divide(num2,4, RoundingMode.HALF_UP);
            AnsC.setText(String.valueOf(ans1));
        }

    }



}















