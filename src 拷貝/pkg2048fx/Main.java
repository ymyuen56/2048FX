/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048fx;



import java.util.Arrays;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author ymyue
 */
public class Main extends Application {
    
    
    Button btn,btn2;
    static StackPane root;
    int positionY[] ={-145,-35,75,185,295};
    int positionX[]={-165,-55,55,165};
    int indexY=0;
    int indexX=0;
    Scene scene;
    Box box;
    int limitY[]={5,5,5,5};
    //static ImageView temimge;
    
    
    public void start(Stage primaryStage) {
        
        
        Text score=new Text();
        score.setText("0000");
        score.setFont(Font.font("Serif", FontWeight.NORMAL, 30));
        score.setFill(Color.WHITE);
        score.setTranslateY(-290);
        score.setTranslateX(-35);
        
        Text Bestcore =new Text();
        Bestcore.setText("0000");
        Bestcore.setFont(Font.font("Serif",FontWeight.NORMAL,30));
        Bestcore.setFill(Color.WHITE);
        Bestcore.setTranslateX(140);
        Bestcore.setTranslateY(-290);
        
        
        
       // Image image1=new Image(Main.class.getResourceAsStream("/assets/tiles/2.png"));
        root = new StackPane();
        //root.getChildren().add(btn);
        //root.getChildren().add(btn2);
        //root.setStyle("-fx-background-image: url('board.png')"); 
        root.getChildren().add(score);
        root.getChildren().add(Bestcore);
       
        
        
        Timeline fiveSecondsWonder=new Timeline(new KeyFrame(Duration.seconds(6),gernBox));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        
        
        scene = new Scene(root, 450, 700);
        scene.getStylesheets().add(Main.class.getResource("systle.css").toExternalForm());
        primaryStage.setTitle("Tetris2048");
        
        primaryStage.setResizable(false);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
        fiveSecondsWonder.play();
        
        
    }
     EventHandler <ActionEvent> gernBox = new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
         
         box=new Box(root,scene,limitY);
         limitY=box.getlimitY();
            
                  
        }
    }; 
    /**
     * @param args the command line arguments
     */
   
   
   
  
   
      
       
        
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
