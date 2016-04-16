/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048fx;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author yeungmingyuen
 */
public class Box {
    ImageView imgView;
    Image img;
    String img_url;
    StackPane root;
    Scene scene;
    int positionY[] ={-145,-35,75,185,295};
    int positionX[]={-165,-55,55,165};
    int indexX=0;
    int indexY=0;
    int limitY[]=new int[4];
   
    
    Box(StackPane root,Scene scene,int [] limitY){
        
      this.root=root;
      this.scene=scene;
      System.arraycopy(limitY, 0,this.limitY,0,limitY.length);
      String img_url="/assets/tiles/2.png";
      img=new Image(Main.class.getResourceAsStream(img_url));
      imgView=new ImageView();
      imgView.setImage(img);
      imgView.setTranslateY(positionY[0]);
      Random r=new Random();
      indexX=(int)r.nextInt(3+1);
      imgView.setTranslateX(positionX[indexX]);
     
            
      root.getChildren().add(imgView);
      this.scene.setOnKeyPressed(keyListiner);
      new Timer().schedule(timer, 0,1000);
      
      
      
      
    }
    
    public int[] getlimitY(){
     return limitY;
    }
    
    
    TimerTask timer=new TimerTask(){

        @Override
        public void run() {
            if(indexY<limitY[indexX]){
              
              imgView.setTranslateY(positionY[indexY]); 
              indexY++;   
            }else{
            limitY[indexX]=indexY-1;}
        
        
        }
     };
    

    
    
    
    
     EventHandler <KeyEvent> keyListiner=new EventHandler<KeyEvent>(){

        @Override
        public void handle(KeyEvent event) {
            if(event.getCode()== KeyCode.RIGHT){
                if(indexX<positionX.length-1){
                  indexX++;  
                 imgView.setTranslateX(positionX[indexX]);
               
                }
            
            }else if(event.getCode()==KeyCode.LEFT){
               if(indexX>0){
                  indexX--;  
                  imgView.setTranslateX(positionX[indexX]);
                
                }
            
            }else if(event.getCode()== KeyCode.DOWN){
               if(indexY<limitY[indexX]){
                  indexY++;
                  imgView.setTranslateY(positionY[indexY]);
               
               }
            
            }
            
        }};
   
    
}
