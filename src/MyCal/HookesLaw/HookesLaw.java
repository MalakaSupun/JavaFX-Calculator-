package MyCal.HookesLaw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HookesLaw {

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

        //Getting force....
        if (buttonText.equals("Force =")){

        double num1= Double.parseDouble(TextA1.getText());
        double num2= Double.parseDouble(TextA2.getText());

        double ans1= num1*num2;
        AnsA.setText(String.valueOf(ans1));
    }

        //Getting Constant....
        else if (buttonText.equals("Constant =")){

            num1= BigDecimal.valueOf(Double.parseDouble(TextB1.getText()));
            num2= BigDecimal.valueOf(Double.parseDouble(TextB2.getText()));

            BigDecimal ans1= num1.divide(num2,4, RoundingMode.HALF_UP);
            AnsB.setText(String.valueOf(ans1));
        }

        //Getting Displacement....
        else if (buttonText.equals("Displacement =")){

            num1= BigDecimal.valueOf(Double.parseDouble(TextC1.getText()));
            num2= BigDecimal.valueOf(Double.parseDouble(TextC2.getText()));

            BigDecimal ans1= num1.divide(num2,4, RoundingMode.HALF_UP);
            AnsC.setText(String.valueOf(ans1));
        }


    }



    }







