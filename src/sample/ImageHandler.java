package sample;

import javafx.collections.FXCollections;
import javafx.geometry.Point2D;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.event.ActionEvent;
import java.util.Arrays;

public class ImageHandler {

    //FIELDS FOR INTERACTIVE ELEMENTS
    private Image potImage;
    private ImageView potImageView;

    private Image waterSprinklerImage;
    private ImageView waterSprinklerImageView;

    private Image waterDropsImage;
    private ImageView waterDropsImageView;

    private Image fertilizerImage;
    private ImageView fertilizerImageView;

    private Image fertilizerOpenImage;
    private ImageView fertilizerOpenImageView;

    private Image seedImage;
    private ImageView seedImageView;

    private Image soilImage;
    private ImageView soilImageView;

    private Image soilUsedImage;
    private ImageView soilUsedImageView;

    private double adjustMenuPosY = 0;

    private Rectangle waterRect;

    //program execution handler
    private boolean alreadyexecuted = false;

    public static GrowPlant myPlant = new GrowPlant();

    public ImageHandler() {
        myPlant.setup();
        //growing area
        //pot
        this.potImage = new Image(getClass().getResource("images/pot.png").toString());
        this.potImageView = new ImageView(this.potImage);
        this.potImageView.setPreserveRatio(true);
        this.potImageView.setFitWidth(100);
        this.potImageView.setX(450);
        this.potImageView.setY(500);

        //plant lvl TODO allot!!!

        //Items menu
        //water sprinkler
        this.waterSprinklerImage = new Image(getClass().getResource("images/waterSprinkler.png").toString());
        this.waterSprinklerImageView = new ImageView(this.waterSprinklerImage);
        this.waterSprinklerImageView.setPreserveRatio(true);
        this.waterSprinklerImageView.setFitHeight(100);
        this.waterSprinklerImageView.setX(0);
        this.waterSprinklerImageView.setY(0 + this.adjustMenuPosY);

        //water drops
        this.waterDropsImage = new Image(getClass().getResource("images/waterDrops.png").toString());
        this.waterDropsImageView = new ImageView(this.waterDropsImage);
        this.waterDropsImageView.setPreserveRatio(true);
        this.waterDropsImageView.setFitWidth(20);
        this.waterDropsImageView.setVisible(false);

        //fertilizer
        this.fertilizerImage = new Image(getClass().getResource("images/fertilizer.png").toString());
        this.fertilizerImageView = new ImageView(this.fertilizerImage);
        this.fertilizerImageView.setPreserveRatio(true);
        this.fertilizerImageView.setFitHeight(100);
        this.fertilizerImageView.setX(47);
        this.fertilizerImageView.setY(120 + this.adjustMenuPosY);

        //fertilizer open
        this.fertilizerOpenImage = new Image(getClass().getResource("images/fertilizerOpen.png").toString());
        this.fertilizerOpenImageView = new ImageView(this.fertilizerOpenImage);
        this.fertilizerOpenImageView.setPreserveRatio(true);
        this.fertilizerOpenImageView.setFitWidth(120);
        this.fertilizerOpenImageView.setVisible(false);


        //seed
        this.seedImage = new Image(getClass().getResource("images/seed.png").toString());
        this.seedImageView = new ImageView(this.seedImage);
        this.seedImageView.setPreserveRatio(true);
        this.seedImageView.setFitHeight(50);
        this.seedImageView.setX(65);
        this.seedImageView.setY(240 + this.adjustMenuPosY);

        //soil
        this.soilImage = new Image(getClass().getResource("images/soil.png").toString());
        this.soilImageView = new ImageView(this.soilImage);
        this.soilImageView.setPreserveRatio(true);
        this.soilImageView.setFitWidth(150);
        this.soilImageView.setX(0);
        this.soilImageView.setY(310 + this.adjustMenuPosY);


        //soil used
        this.soilUsedImage = new Image(getClass().getResource("images/soilUsed.png").toString());
        this.soilUsedImageView = new ImageView(this.soilUsedImage);
        this.soilUsedImageView.setPreserveRatio(true);
        this.soilUsedImageView.setFitWidth(70);
        this.soilUsedImageView.setX(465);
        this.soilUsedImageView.setY(480);
        this.soilUsedImageView.setVisible(false);

        //make the menu items movable
        //Interaction of water sprinkler
        this.waterSprinklerImageView.setOnMouseDragged((MouseEvent dragged) -> {
            double posX = dragged.getSceneX();
            double posY = dragged.getSceneY();
            this.waterSprinklerImageView.setX(posX);
            this.waterSprinklerImageView.setY(posY);
            if (posX > 450 && posX < 520 && posY > 300 && posY < 400) {
                this.waterSprinklerImageView.setRotate(270);
                this.waterDropsImageView.setX(posX + 0);
                this.waterDropsImageView.setY(posY + 100);
                this.waterDropsImageView.setVisible(true);
                //this section should solve problems in the future myPlant.watering is necessary but the value is
                // returned into a codeless if-statement
                if (!this.alreadyexecuted) {
                    boolean enoughtWater = myPlant.watering();
                    if (enoughtWater) {
                    }
                    this.alreadyexecuted = true;
                }

            } else {
                this.waterSprinklerImageView.setRotate(0);
                this.waterDropsImageView.setVisible(false);
                this.alreadyexecuted = false;
            }
        });
        this.waterSprinklerImageView.setOnMouseReleased((MouseEvent relesed) -> {
            this.waterSprinklerImageView.setX(0);
            this.waterSprinklerImageView.setY(0 + this.adjustMenuPosY);
            this.waterSprinklerImageView.setRotate(0);
            this.waterDropsImageView.setVisible(false);
        });

        this.fertilizerImageView.setOnMouseDragged((MouseEvent dragged) -> {
            double posX = dragged.getSceneX();
            double posY = dragged.getSceneY();
            this.fertilizerImageView.setX(posX);
            this.fertilizerImageView.setY(posY);
            if (posX > 450 && posX < 520 && posY > 300 && posY < 400) {
                this.fertilizerImageView.setVisible(false);
                this.fertilizerOpenImageView.setX(posX);
                this.fertilizerOpenImageView.setY(posY);
                this.fertilizerOpenImageView.setVisible(true);
                if (!this.alreadyexecuted) {
                    myPlant.fertilizer();
                    this.alreadyexecuted = true;
                }
            } else {
                this.fertilizerOpenImageView.setVisible(false);
                this.fertilizerImageView.setVisible(true);
                this.alreadyexecuted = false;
            }
        });
        this.fertilizerImageView.setOnMouseReleased((MouseEvent released) -> {
            this.fertilizerOpenImageView.setVisible(false);
            this.fertilizerImageView.setVisible(true);
            this.fertilizerImageView.setX(47);
            this.fertilizerImageView.setY(120 + this.adjustMenuPosY);
        });

        //Interaction of seed
        this.seedImageView.setOnMouseDragged((MouseEvent dragged) -> {
            double posX = dragged.getSceneX();
            double posY = dragged.getSceneY();
            this.seedImageView.setX(posX);
            this.seedImageView.setY(posY);
            if (posX > 400 && posX < 550 && posY > 300 && posY < 500) {
                myPlant.setSeed(true);
                this.seedImageView.setVisible(false);
            }
        });
        this.seedImageView.setOnMouseReleased((MouseEvent released) -> {
            double posX = released.getSceneX();
            double posY = released.getSceneY();
            this.seedImageView.setX(65);
            this.seedImageView.setY(240 + this.adjustMenuPosY);
        });

        //Interaction of soil
        this.soilImageView.setOnMouseDragged((MouseEvent dragged) -> {
            double posX = dragged.getSceneX();
            double posY = dragged.getSceneY();
            this.soilImageView.setX(posX);
            this.soilImageView.setY(posY);
            if (posX > 400 && posX < 550 && posY > 300 && posY < 500) {
                myPlant.setSoil(true);
                this.soilImageView.setVisible(false);
                this.soilUsedImageView.setVisible(true);
            }
        });
        this.soilImageView.setOnMouseReleased((MouseEvent released) -> {
            this.soilImageView.setX(0);
            this.soilImageView.setY(310 + this.adjustMenuPosY);
        });

        Main.root.getChildren().addAll(this.seedImageView, this.soilUsedImageView, this.potImageView,
                this.waterSprinklerImageView, this.waterDropsImageView, this.fertilizerImageView,
                this.fertilizerOpenImageView, this.soilImageView);
    }
}

        //THIS WAS ALL CODE FOR INTERACTIVE ELEMENTS

        //TODO STATUSBARS AT THE MOMENT THIS IS SOLVED BY TEXT
/*
        Rectangle frameRectWater = new Rectangle(150, 40, 200, 40);
        frameRectWater.setFill(Color.rgb(0,0,0, 0.2));

    }

    public Rectangle waterRectStats(float water) {
        Rectangle waterRect = new Rectangle(150, 40, (water * 100), 40);
        return waterRect;
    }

    public BarChart<Number, String> createChart(double water, double fertilizer) {
        final String[] resources = {"Water", "Fertilizer"};
        final CategoryAxis yAxis = new CategoryAxis();
        final NumberAxis xAxis = new NumberAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);

        bc.setTitle("Resource Statistics");
        yAxis.setLabel("Resources");
        yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(resources)));
        xAxis.setLabel("Amount / %");

        XYChart.Series<Number, String> series1 = new XYChart.Series<Number, String>();
        series1.setName("Water");
        XYChart.Series<Number, String> series2 = new XYChart.Series<Number, String>();
        series2.setName("Fertilizer");

        series1.getData().add((new XYChart.Data<Number, String>(water, resources[0])));
        series2.getData().add((new XYChart.Data<Number, String>(fertilizer, resources[1])));

        bc.getData().add(series1);
        bc.getData().add(series2);
        return bc;
    }
}
*/