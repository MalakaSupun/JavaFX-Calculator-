// This is the main code .......
package MyCal;
// JavaFX packages .......
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    //Creating stages for GUIs...
    private static Stage EngStage = null;

    private static Stage AboutStage = null;

    private static Stage HelpStage = null;

    //Main GUI.......
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Use try to load UI ........
       try {
           // Loading main GUI ........
           Parent root = FXMLLoader.load(getClass().getResource("MainCal.fxml"));
           primaryStage.setTitle("The..M..CALCULATOR");         // Name of the cal ....
           primaryStage.setScene(new Scene(root, 333, 559));    // Staring position for cal .....
           primaryStage.setResizable(false);                    // Setting window to un-resizable..... 
           Image icon = new Image(getClass().getResourceAsStream("icon/Calculator.png"));
           primaryStage.getIcons().add(icon);
           
          
           primaryStage.setOpacity(0.9);   // Setting window Transparent.......
           primaryStage.show();            // Show the application........
           
       }catch (Exception e){      // Catching Exceptions ......
           e.printStackTrace();
       }
        CreateHookesLaw();
        CreateStressCal();
        CreateHelp();

    }

    //GUI for hooke's law...
    public void CreateHookesLaw(){
        EngStage = new Stage ();
        EngStage.setTitle("Hooke's Law Calculations");
        EngStage.setAlwaysOnTop(true);
        EngStage.setResizable(false);
        EngStage.initModality(Modality.APPLICATION_MODAL);

        EngStage.setOpacity(0.8);
        Image icon = new Image(getClass().getResourceAsStream("icon/Calculator.png"));
        EngStage.getIcons().add(icon);

    }

    //GUI for Stress Calculations....
    public void CreateStressCal(){
        AboutStage = new Stage ();
        AboutStage.setTitle("Stress Calculator");
        AboutStage.setAlwaysOnTop(true);
        AboutStage.setResizable(false);
        AboutStage.initModality(Modality.APPLICATION_MODAL);

        AboutStage.setOpacity(0.8);
        Image icon = new Image(getClass().getResourceAsStream("icon/Calculator.png"));
        AboutStage.getIcons().add(icon);
        
    }
    //GUI for helps.....
    public void CreateHelp(){
        HelpStage = new Stage ();
        HelpStage.setTitle("....Helps....");
        HelpStage.setAlwaysOnTop(true);
        HelpStage.setResizable(false);
        HelpStage.initModality(Modality.APPLICATION_MODAL);

        HelpStage.setOpacity(0.8);
        Image icon = new Image(getClass().getResourceAsStream("icon/Malwarebytes.png"));
        HelpStage.getIcons().add(icon);

    }

    // Stages are private because of that creating some getters....

    public static Stage getHookesLaw(){
        return EngStage;
    }

    public static Stage getStressCal(){
        return AboutStage;
    }

    public static Stage getHelp(){
        return HelpStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
