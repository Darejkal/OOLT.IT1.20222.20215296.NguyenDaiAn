package hust.soict.ictglobal.gui.javafx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class JavafxCounter extends Application {
    int count=0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");
        Text t= new Text(Integer.toString(count));
        t.setTextAlignment(TextAlignment.CENTER);
        VBox v= new VBox(t);
        v.setFillWidth(true);
        v.setAlignment(Pos.CENTER);
        Scene s= new Scene(v,500,500);
        primaryStage.setScene(s);
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED,(event)->{
            t.setText(Integer.toString(++count));
        });
        primaryStage.show();

    }
}
