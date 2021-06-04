package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.*;

import javax.swing.*;

public class GrowPlant {

    // Values of 0 to 1 representing 0% to 100%
    private float water = 0;
    private float fertilizer = 0;

    //we won't do more than 10 levels
    private int plantLevel = 0;

    //pot content
    private boolean soil = false;
    private boolean seed = false;

    //plant status stuff
    private String[] plantStatusArray = new String[3];

    private Image leafImage;
    private ImageView leafImageView;

    private Image leaf2Image;
    private ImageView leaf2ImageView;

    private Image rodImage;
    private ImageView rodImageView;

    private Image budImage;
    private ImageView budImageView;

    private Image blossomImage;
    private ImageView blossomImageView;

    private String plantName = "";

    //getters and setters
    public void setSoil(boolean soilStatus) {
        this.soil = soilStatus;
    }

    public boolean getSoil() {
        return this.soil;
    }

    public void setSeed(boolean seedStatus) {
        this.seed = seedStatus;
    }

    public boolean getSeed() {
        return this.seed;
    }

    public float getWater() {
        return this.water;
    }

    public float getFertilizer() {
        return this.fertilizer;
    }

    public String[] getPlantStatusArray() {
        return this.plantStatusArray;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantName() {
        return this.plantName;
    }


    public Text plantManual = new Text();
    public Text plantStatusText = new Text();

    public void setup() {

        plantManual.setText("You have to setup your plant. \n" +
                "1.) Drag soil to your pot to fill in soil. \n" +
                "2.) Place in the seed. \n" +
                "3.) Add some fertilizer. \n" +
                "3.) Water the soil to 100%");
        plantManualShow();

        plantStatusCatcher();
        plantStatusShow();

        Main.root.getChildren().addAll(plantManual, plantStatusText);
    }


    public boolean watering() {
        boolean enoughtWater = false;
        if (soil && seed) {
            this.water = this.water + 0.5F;
            if (this.water >= 1) {
                enoughtWater = true;
                this.water = 1;
                plantManual.setText("This is enough water!");
                if (this.fertilizer > 0 && this.water == 1) {
                    growAction();
                }
            } else {
                plantManual.setText("You've watered your Plant.");
            }
            System.out.println(this.water);
            plantStatusCatcher();
            plantStatusShow();

            //Status Bar
        } else {
            plantManual.setText("You need to set up soil \n" +
                    "and seed first!");
        }
        //TODO AT THE MOMENT THIS RETURN STATEMANT RETURNS IN AN UNUSED VARIABLE
        return enoughtWater;
    }

    public void fertilizer() {
        if (soil && seed) {
            this.fertilizer = this.fertilizer + 1F;
            if (this.fertilizer >= 1) {
                this.fertilizer = 1;
                plantManual.setText("You've fertilized your plants.");
                if (this.water == 1 && this.fertilizer > 0) {
                    growAction();
                }
                plantStatusCatcher();
                plantStatusShow();
            } else if (this.fertilizer > 0 && this.water == 1) {
                growAction();
            }
            plantStatusCatcher();
            plantStatusShow();
        } else {
            plantManual.setText("You need to set up soil\n" +
                    "and seed first!");
        }
    }

    public void plantStatusCatcher() {

        String[] plantStatus = {Float.toString(this.water * 100), Float.toString(this.fertilizer * 100),
                Integer.toString(this.plantLevel)};
        this.plantStatusArray = plantStatus;
    }

    public void plantStatusShow() {
        Font myFontStatus = new Font("Arial", 30);
        plantStatusText.setText("Water: " + this.plantStatusArray[0] + "% \n" +
                "Fertilizer: " + this.plantStatusArray[1] + "% \n" +
                "Plant-Level: " + this.plantStatusArray[2]);
        plantStatusText.setX(450);
        plantStatusText.setY(40);
        plantStatusText.setFont(myFontStatus);
    }

    public void plantManualShow() {
        Font myFontManual = new Font("Times New Roman", 30);
        plantManual.setX(0);
        plantManual.setY(400);
        plantManual.setFont(myFontManual);
    }

    public void growAction() {

        plantManual.setText("Your Plant is growing.");
        plantManualShow();
        while (this.water > 0 && this.fertilizer > 0) {
            this.water = this.water - 0.02F;
            this.fertilizer = this.fertilizer - 0.005F;
            plantStatusCatcher();
            plantStatusShow();
        }

        this.plantLevel++;
        plantEvolver();
        if (this.water <= 0) {
            this.water = 0;
            plantManual.setText("You need to water your plant to 100%");
            plantManualShow();
        } else {
            this.fertilizer = 0;
            plantManual.setText("Your plant need fertilizer!");
            plantManualShow();
        }
    }

    public void plantEvolver() {

        switch (this.plantLevel) {
            case 1: {
                this.leafImage = new Image(getClass().getResource("images/leaf.png").toString());
                this.leafImageView = new ImageView(this.leafImage);
                this.leafImageView.setPreserveRatio(true);
                this.leafImageView.setFitWidth(60);
                this.leafImageView.setX(510);
                this.leafImageView.setY(440);
                Main.root.getChildren().add(this.leafImageView);
                break;
            }
            case 2: {
                this.leaf2Image = new Image(getClass().getResource("images/leaf2.png").toString());
                this.leaf2ImageView = new ImageView(this.leaf2Image);
                this.leaf2ImageView.setPreserveRatio(true);
                this.leaf2ImageView.setFitWidth(60);
                this.leaf2ImageView.setX(450);
                this.leaf2ImageView.setY(440);
                Main.root.getChildren().add(this.leaf2ImageView);
                break;
            }
            case 3: {
                this.rodImage = new Image(getClass().getResource("images/rod.png").toString());
                this.rodImageView = new ImageView(this.rodImage);
                this.rodImageView.setPreserveRatio(true);
                this.rodImageView.setFitHeight(100);
                this.rodImageView.setX(431);
                this.rodImageView.setY(398);
                this.rodImageView.setRotate(10);
                Main.root.getChildren().add(this.rodImageView);
                break;
            }
            case 4: {
                this.budImage = new Image(getClass().getResource("images/bud.png").toString());
                this.budImageView = new ImageView(this.budImage);
                this.budImageView.setPreserveRatio(true);
                this.budImageView.setFitHeight(50);
                this.budImageView.setX(413);
                this.budImageView.setY(365);
                Main.root.getChildren().add(this.budImageView);
                break;
            }
            default: {
                this.blossomImage = new Image(getClass().getResource("images/blossom.png").toString());
                this.blossomImageView = new ImageView(this.blossomImage);
                this.blossomImageView.setPreserveRatio(true);
                this.blossomImageView.setFitHeight(80);
                this.blossomImageView.setX(413);
                this.blossomImageView.setY(365);
                this.budImageView.setVisible(false);
                Main.root.getChildren().add(this.blossomImageView);
                this.plantLevel = 5;
                plantManualShow();
                PlantName myPlantName = new PlantName();
                myPlantName.nameYourPlant();
                myPlantName.plantNameShow();
                plantManual.setVisible(false);
                plantManualShow();
                plantStatusText.setVisible(false);
                plantStatusShow();
                break;
            }
        }
    }
}


