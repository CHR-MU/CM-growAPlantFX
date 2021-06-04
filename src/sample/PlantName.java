package sample;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;

public class PlantName {

    public GrowPlant myPlant = new GrowPlant();
    public void nameYourPlant(){

        boolean correctLength = false;
        String message = ("You successfully grow a plant. \n" +
                "Now you can name it.");
        String name = "";
        while(!correctLength){
            JOptionPane.showMessageDialog(null, message);
            name = JOptionPane.showInputDialog("Your Plant Name (max 5 Chars.): ");
            if(name.length() > 5){
                JOptionPane.showMessageDialog(null, "Your chosen name is to long!");
            }
            else if(name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Your chosen name must at least have one Char.");
            }
            else {
                myPlant.setPlantName(name);
                plantNameShow();
                correctLength = true;
            }
        }
    }

    public void plantNameShow(){
        Text myPlantName = new Text();
        myPlantName.setText(myPlant.getPlantName());
        Font myPlantNameFont = new Font("Arial", 20);
        myPlantName.setX(470);
        myPlantName.setY(550);
        myPlantName.setFont(myPlantNameFont);
        Main.root.getChildren().add(myPlantName);
    }
}

