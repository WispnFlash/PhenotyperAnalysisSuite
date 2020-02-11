import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Driver extends Application {
    private int threadcount = 0;
    private int numberofgroups = 0;
    private int counter = 0;
    private int criterion;
    private String lastname;
    private String inputdirectory = "C:/Inputs/";
    private String maindirectorychoice = "G:/Behavioral Data/";
    private String maindirectory = maindirectorychoice + "Sonntag Lab Dropbox/Phenotyper/Investigators/";
    private String Rscriptdirectory = "C:/Users/Public/Documents/Rscripts/";
    private String mouseimagelocation = "C:/Users/DOWEN1/Pictures/mouse.jpg";
    private String directorychooser = maindirectory;
    private File file1 = new File(Rscriptdirectory + "TextToRDAfileconverter.r");
    private File file2 = new File(Rscriptdirectory + "InitialDiscriminationSurvival.r");
    private File file3 = new File(Rscriptdirectory + "RevSurvival.r");
    private File file4 = new File(Rscriptdirectory + "movementevaluator.r");
    private File file5 = new File(Rscriptdirectory + "feedingevaluator.r");
    private File file6 = new File(Rscriptdirectory + "TreatmentIndexer.py");
    private File file7 = new File(Rscriptdirectory + "CohortGrapher.py");
    private File file8 = new File(Rscriptdirectory + "import.py");
    private File file9 = new File(Rscriptdirectory + "index.py");
    private int placement = 14;
    private ColorPicker color1 = new ColorPicker();
    private ColorPicker color2 = new ColorPicker();
    private ColorPicker color3 = new ColorPicker();
    private ColorPicker color4 = new ColorPicker();
    private ColorPicker color5 = new ColorPicker();
    private ColorPicker color6 = new ColorPicker();
    private ColorPicker color7 = new ColorPicker();
    private ColorPicker color8 = new ColorPicker();
    private ColorPicker color9 = new ColorPicker();
    private ColorPicker color10 = new ColorPicker();
    private ColorPicker color11 = new ColorPicker();
    private ColorPicker color12 = new ColorPicker();
    private String lcolor1 = "green";
    private String lcolor2 = "blue";
    private String lcolor3 = "orange";
    private String lcolor4 = "yellow";
    private String lcolor5 = "red";
    private String lcolor6 = "brown";
    private String lcolor7 = "black";
    private String lcolor8 = "purple";
    private String lcolor9 = "darkgreen";
    private String lcolor10 = "darkred";
    private String lcolor11 = "pink";
    private String lcolor12 = "darkblue";
    private String statuss = "done";
    private File mousescriptlist = new File(Rscriptdirectory + "pythonscriptlist.txt");
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.getIcons().add(new Image("mouse.jpg"));
        int i = 0;
        file1.deleteOnExit();
        file2.deleteOnExit();
        file3.deleteOnExit();
        file4.deleteOnExit();
        file5.deleteOnExit();
        file6.deleteOnExit();
        file7.deleteOnExit();
        file8.deleteOnExit();
        mousescriptlist.deleteOnExit();

        primaryStage.setTitle("Welcome to the Phenotyper mouse analysis program!");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        Text title = new Text("The Amazing Phenotyper Analysis Program");
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        grid.add(title, 0, 0, 10, 1);

        try {
            Image mouseimage = new Image(new FileInputStream(mouseimagelocation));
            ImageView mouseviewer = new ImageView(mouseimage);
            mouseviewer.setFitWidth(350);
            mouseviewer.setFitHeight(250);
            grid.add(mouseviewer, 0, 1, 10, 1);
        } catch (FileNotFoundException t) {
            System.out.println("Image not found.");
        }
        Text question1 = new Text("What would you like to do?");
        Button mouseRDA = new Button("Import mice into Dropbox");
        Text Survival = new Text("Survival Plots:");
        Survival.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Text ETC = new Text("Entries to Criterion:");
        ETC.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Text Feeding = new Text("Feeding:");
        Feeding.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Text movement = new Text("Movement");
        movement.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Text Index = new Text("Cumulative Index");
        Index.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Text IndepIndex = new Text("Independent Index");
        IndepIndex.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Text Segment = new Text("Segment Distribution");
        Segment.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Button InitialDiscrininationSurvival = new Button("Initial");
        Button ReversalSurvival = new Button("Reversal");
        Button CalculateETCID = new Button("Initial");
        Button CalculateETCR = new Button("Reversal");
        Text ScatterPlots = new Text("ETC Scatterplots:");
        ScatterPlots.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Button GraphInitialETCScatter = new Button("Initial");
        Button GraphRevETCScatter = new Button("Reversal");
        Button CalculateFeeding = new Button("Graph");
        Button FeedingSpreadsheets = new Button("Spreadsheet");
        Button FeedingPrism = new Button("Prism");
        Button CalculateDistanceMoved = new Button("Graph");
        Button CalculateMovement = new Button("Spreadsheet");
        Button MovPrism = new Button("Prism");
        Button CalculateCumulativeIndex = new Button("Spreadsheet");
        Button GraphCumulativeIndex = new Button("Graph");
        Button CumulativePrism = new Button("Prism");
        Button PostInjection = new Button("Post Injection");
        Button IndMouse = new Button("Individual mouse");
        Button GraphSegmentDistribution = new Button("Graph");
        Button GraphIndepIndex = new Button("Graph");
        Button CalculateIndepIndex = new Button("Spreadsheet");
        Button IndIndexPrism = new Button("Prism");
        Button Custom = new Button("Exclude mice");
        Button IMDONE = new Button("Done");
        Button MainMenu = new Button("Main");
        MainMenu.setStyle("-fx-base:orange");
        IMDONE.setStyle("-fx-base:blue");

        grid.add(question1, 1, 2, 10, 1);
        grid.add(mouseRDA, 1, 3, 1, 1);
        grid.add(PostInjection, 2, 3, 1, 1);
        grid.add(IndMouse, 3, 3, 1, 1);
        grid.add(Survival, 1, 4, 1, 1);
        grid.add(InitialDiscrininationSurvival, 2, 4, 1, 1);
        grid.add(ReversalSurvival, 3, 4, 1, 1);

        grid.add(ETC, 1, 6, 1, 1);
        grid.add(CalculateETCID, 2, 6, 1, 1);
        grid.add(CalculateETCR, 3, 6, 1, 1);
        grid.add(ScatterPlots, 1, 7, 1, 1);
        grid.add(GraphInitialETCScatter, 2, 7, 1, 1);
        grid.add(GraphRevETCScatter, 3, 7, 1, 1);
        grid.add(movement, 1, 8, 1, 1);
        grid.add(CalculateDistanceMoved, 2, 8, 1, 1);
        grid.add(CalculateMovement, 3, 8, 1, 1);
        grid.add(MovPrism, 4, 8, 1, 1);

        grid.add(Feeding, 1, 9, 1, 1);
        grid.add(CalculateFeeding, 2, 9, 10, 1);
        grid.add(FeedingSpreadsheets, 3, 9, 1, 1);
        grid.add(FeedingPrism, 4, 9, 1, 1);

        grid.add(Index, 1, 10, 1, 1);
        grid.add(GraphCumulativeIndex, 2, 10, 1, 1);
        grid.add(CalculateCumulativeIndex, 3, 10, 1, 1);
        grid.add(CumulativePrism, 4, 10, 1, 1);
        grid.add(IndepIndex, 1, 11, 1, 1);
        grid.add(GraphIndepIndex, 2, 11, 1, 1);
        grid.add(CalculateIndepIndex, 3, 11, 1, 1);
        grid.add(IndIndexPrism, 4, 11, 1, 1);
        grid.add(Segment, 1, 12, 1, 1);
        grid.add(GraphSegmentDistribution, 2, 12, 1, 1);


        grid.add(IMDONE, 1, 13, 1, 1);

        primaryStage.setScene(new Scene(grid, 600, 1000));
        File directory20 = new File("C:/Users/Public/Documents/Rscripts/mice");
        if (!directory20.exists()){
            directory20.mkdirs();
        }
        primaryStage.show();
        IMDONE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                file1.delete();
                file2.delete();
                file3.delete();
                file4.delete();
                file5.delete();
                file6.delete();
                file7.delete();
                file8.delete();
                mousescriptlist.delete();
                System.exit(0);
            }
        });

        MainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                file1.delete();
                file2.delete();
                file3.delete();
                file4.delete();
                file5.delete();
                file6.delete();
                file7.delete();
                file8.delete();
                mousescriptlist.delete();
                grid.getChildren().clear();
                placement = 14;
                counter = 0;
                numberofgroups = 0;
                grid.add(title, 0, 0, 10, 1);
                try {
                    Image mouseimage = new Image(new FileInputStream(mouseimagelocation));
                    ImageView mouseviewer = new ImageView(mouseimage);
                    mouseviewer.setFitWidth(350);
                    mouseviewer.setFitHeight(250);
                    grid.add(mouseviewer, 0, 1, 10, 1);
                } catch (FileNotFoundException t) {
                    System.out.println("Image not found.");
                }
                grid.add(question1, 1, 2, 10, 1);
                grid.add(mouseRDA, 1, 3, 1, 1);
                grid.add(PostInjection, 2, 3, 1, 1);
                grid.add(IndMouse, 3, 3, 1, 1);
                grid.add(Survival, 1, 4, 1, 1);
                grid.add(InitialDiscrininationSurvival, 2, 4, 1, 1);
                grid.add(ReversalSurvival, 3, 4, 1, 1);

                grid.add(ETC, 1, 6, 1, 1);
                grid.add(CalculateETCID, 2, 6, 1, 1);
                grid.add(CalculateETCR, 3, 6, 1, 1);

                grid.add(ScatterPlots, 1, 7, 1, 1);
                grid.add(GraphInitialETCScatter, 2, 7, 1, 1);
                grid.add(GraphRevETCScatter, 3, 7, 1, 1);

                grid.add(movement, 1, 8, 1, 1);
                grid.add(CalculateDistanceMoved, 2, 8, 1, 1);
                grid.add(CalculateMovement, 3, 8, 1, 1);
                grid.add(MovPrism, 4, 8, 1, 1);

                grid.add(Feeding, 1, 9, 1, 1);
                grid.add(CalculateFeeding, 2, 9, 10, 1);
                grid.add(FeedingSpreadsheets, 3, 9, 1, 1);
                grid.add(FeedingPrism, 4, 9, 1, 1);

                grid.add(Index, 1, 10, 1, 1);
                grid.add(GraphCumulativeIndex, 2, 10, 1, 1);
                grid.add(CalculateCumulativeIndex, 3, 10, 1, 1);
                grid.add(CumulativePrism, 4, 10, 1, 1);
                grid.add(IndepIndex, 1, 11, 1, 1);
                grid.add(GraphIndepIndex, 2, 11, 1, 1);
                grid.add(CalculateIndepIndex, 3, 11, 1, 1);
                grid.add(IndIndexPrism, 4, 11, 1, 1);
                grid.add(Segment, 1, 12, 1, 1);
                grid.add(GraphSegmentDistribution, 2, 12, 1, 1);

                grid.add(IMDONE, 1, 13, 1, 1);
            }
        });

        mouseRDA.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button addmouse = new Button("Add a mouse");
                Button doneSelecting = new Button("I'm done selecting mice, I am ready to import them into R.");
                doneSelecting.setStyle("-fx-base: green");
                grid.getChildren().remove(mouseRDA);
                grid.add(addmouse, 1, 3, 10, 1);
                grid.add(doneSelecting, 1, 4, 10, 1);
                Text miceselected = new Text("Mice selected: ");
                miceselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(miceselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                try {
                    BufferedWriter mouseimporter = new BufferedWriter(new FileWriter(Rscriptdirectory + "import.py"));
                    mouseimporter.write("import multiprocessing as mp\n");
                    mouseimporter.write("import os\n");
                    mouseimporter.write("import runpy as rp\n");
                    mouseimporter.write("\n");
                    mouseimporter.write("location = \"" + Rscriptdirectory + "mice/\"\n");
                    mouseimporter.write("os.chdir(location)\n");
                    mouseimporter.write("files = os.listdir(location)\n");
                    mouseimporter.write("\n");
                    mouseimporter.write("value = 0\n");
                    mouseimporter.write("\n");
                    mouseimporter.write("if __name__ == \'__main__\':\n");
                    mouseimporter.write("\tpool = mp.Pool(processes=4)\n");
                    mouseimporter.write("\tpool.map_async(rp.run_path, files)\n");
                    mouseimporter.write("\tpool.close()\n");
                    mouseimporter.write("\tpool.join()\n");
                    mouseimporter.write("\tvalue = 1\n");
                    mouseimporter.write("\n");
                    mouseimporter.write("if (value == 1):\n");
                    mouseimporter.write("\tfor g in files:\n");
                    mouseimporter.write("\t\tos.remove(g)\n");
                    mouseimporter.close();

                } catch(IOException imp) {
                    System.out.println("Could not complete");
                }

                addmouse.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {

                            String AnimalID = " ";
                            String treatment = " ";
                            String line;
                            FileChooser browser = new FileChooser();
                            browser.setTitle("Choose the mouse you would like to import into R:");
                            browser.setInitialDirectory(new File(inputdirectory));
                            File file = browser.showOpenDialog(primaryStage);
                            String source = file.getAbsolutePath();
                            String source2 = source.replace('\\','/');
                            BufferedReader reader = new BufferedReader(new FileReader(source2));
                            int linenumber = 0;
                            for (int i = 0; i < 100; i++){
                                line = reader.readLine();
                                if (line.contains("Investigator")){
                                    lastname = line.substring(16, line.length() - 2);
                                }
                                if (line.contains("Treatment")){
                                    treatment = line.substring(13, line.length() - 2);
                                }
                                if (line.contains("AnimalID")){
                                    AnimalID = "mouse" + line.substring(12, line.length() - 2);
                                }
                                if (line.contains("Trial time")){
                                    linenumber = i;
                                }
                            }
                            reader.close();
                            System.out.println(AnimalID + " " + treatment + " " + lastname);
                            Text groupchoice = new Text(treatment + " " + lastname + " ");
                            grid.add(groupchoice, 1, placement, 10, 1);
                            placement = placement + 1;
                            Mouse mouse = new Mouse(AnimalID, treatment);
                            File directory1 = new File(maindirectory + lastname + "/Data/Initial Discrimination/" + treatment);
                            File directory2 = new File(maindirectory + lastname + "/Data/Reversal/" + treatment);
                            File directory3 = new File(maindirectory + lastname + "/Data/Entries to Criterion/Initial Discrimination/" + treatment);
                            File directory4 = new File(maindirectory + lastname + "/Data/Entries to Criterion/Reversal/" + treatment);
                            File directory5 = new File(maindirectory + lastname + "/Data/RDS files");
                            File directory6 = new File(maindirectory + lastname + "/Data/Distance moved/" + treatment);
                            File directory7 = new File(maindirectory + lastname + "/Data/Feeding/" + treatment);
                            File directory8 = new File(maindirectory + lastname + "/Treatments");
                            File directory9 = new File(maindirectory + lastname + "/Graphs");
                            File directory10 = new File(maindirectory + lastname + "/Spreadsheets/");
                            File directory11 = new File(maindirectory + lastname + "/Data/Indexes/Cumulative/" + treatment);
                            File directory12 = new File(maindirectory + lastname + "/Data/Indexes/Independent/" + treatment);
                            File directory13 = new File(maindirectory + lastname + "/Graphs/Individual mice/Indexes/Cumulative/" + treatment);
                            File directory14 = new File(maindirectory + lastname + "/Graphs/Individual mice/Indexes/Independent/" + treatment);
                            File directory15 = new File(maindirectory + lastname + "/Graphs/Individual mice/Entry Choice/" + treatment);
                            File directory16 = new File(maindirectory + lastname + "/Graphs/Individual mice/Movement/Independent/" + treatment);
                            File directory17 = new File(maindirectory + lastname + "/Graphs/Individual mice/Movement/Cumulative/" + treatment);
                            File directory18 = new File(maindirectory + lastname + "/Graphs/Individual mice/Feeding/Independent/" + treatment);
                            File directory19 = new File(maindirectory + lastname + "/Graphs/Individual mice/Feeding/Cumulative/" + treatment);
                            File directory20 = new File(maindirectory + lastname + "/Data/Segmentation/raw/" + treatment);
                            File directory21 = new File(maindirectory + lastname + "/Data/Segmentation/PreSegmentation/" + treatment);
                            File directory22 = new File(maindirectory + lastname + "/Data/Segmentation/Moving Segments/" + treatment);
                            File directory23 = new File(maindirectory + lastname + "/Data/Segmentation/Frequency/" + treatment);
                            File directory24 = new File(maindirectory + lastname + "/Data/Segmentation/Acceleration/" + treatment);
                            File directory25 = new File(maindirectory + lastname + "/Data/Segmentation/Graphs/Distribution/" + treatment);
                            File directory26 = new File(maindirectory + lastname + "/Data/Segmentation/Graphs/Acceleration/" + treatment);
                            File directory27 = new File(maindirectory + lastname + "/Data/Segmentation/fromR/" + treatment);
                            File directory28 = new File(maindirectory + lastname + "/Graphs/Individual mice/Acceleration/" + treatment);
                            File directory29 = new File(maindirectory + lastname + "/Graphs/Individual mice/Segmentation/" + treatment);
                            File directory30 = new File(maindirectory + lastname + "/Graphs/Individual mice/Figures/" + treatment);

                            if (!directory1.exists()){
                                directory1.mkdirs();
                            }
                            if (!directory2.exists()){
                                directory2.mkdirs();
                            }
                            if (!directory3.exists()){
                                directory3.mkdirs();
                            }
                            if (!directory4.exists()){
                                directory4.mkdirs();
                            }
                            if (!directory5.exists()){
                                directory5.mkdirs();
                            }
                            if (!directory6.exists()){
                                directory6.mkdirs();
                            }
                            if (!directory7.exists()){
                                directory7.mkdirs();
                            }
                            if (!directory8.exists()){
                                directory8.mkdirs();
                            }
                            if (!directory9.exists()){
                                directory9.mkdirs();
                            }
                            if (!directory10.exists()){
                                directory10.mkdirs();
                            }
                            if (!directory11.exists()){
                                directory11.mkdirs();
                            }
                            if (!directory12.exists()){
                                directory12.mkdirs();
                            }
                            if (!directory13.exists()){
                                directory13.mkdirs();
                            }
                            if (!directory14.exists()){
                                directory14.mkdirs();
                            }
                            if (!directory15.exists()){
                                directory15.mkdirs();
                            }
                            if (!directory16.exists()){
                                directory16.mkdirs();
                            }
                            if (!directory17.exists()){
                                directory17.mkdirs();
                            }
                            if (!directory18.exists()){
                                directory18.mkdirs();
                            }
                            if (!directory19.exists()){
                                directory19.mkdirs();
                            }
                            if (!directory20.exists()){
                                directory20.mkdirs();
                            }
                            if (!directory21.exists()){
                                directory21.mkdirs();
                            }
                            if (!directory22.exists()){
                                directory22.mkdirs();
                            }
                            if (!directory23.exists()){
                                directory23.mkdirs();
                            }
                            if (!directory24.exists()){
                                directory24.mkdirs();
                            }
                            if (!directory25.exists()){
                                directory25.mkdirs();
                            }
                            if (!directory26.exists()){
                                directory26.mkdirs();
                            }
                            if (!directory27.exists()){
                                directory27.mkdirs();
                            }
                            if (!directory28.exists()){
                                directory28.mkdirs();
                            }
                            if (!directory29.exists()){
                                directory29.mkdirs();
                            }
                            if (!directory30.exists()){
                                directory30.mkdirs();
                            }
                            File file11 = new File(maindirectory + lastname + "/Treatments/" + treatment + ".txt");
                            if (!file11.exists()){
                                try {
                                    BufferedWriter TextTreatment = new BufferedWriter(new FileWriter(maindirectory + lastname + "/Treatments/" + treatment + ".txt", true));
                                    TextTreatment.write("Treatment: " + treatment + "\n");
                                    TextTreatment.write("Investigator: " + lastname + "\n");
                                    TextTreatment.close();
                                } catch (IOException IDtextexception) {
                                    System.out.println("Could not create treatment text file.");
                                }
                            }
                            //mouse.mouseEverything(source2, linenumber, lastname, maindirectory, Rscriptdirectory);

                            //BufferedWriter mousescripts = new BufferedWriter(new FileWriter(Rscriptdirectory + "pythonscriptlist.txt", true));
                            //mousescripts.write(Rscriptdirectory + lastname + mouse.AnimalID + ".py\n");
                            //mousescripts.close();
                        } catch(FileNotFoundException art) {
                            System.out.println("File not found");
                        } catch (IOException cantdoit){
                            System.out.println("Can't read/write");
                        }
                    }
                });
                doneSelecting.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        grid.getChildren().remove(addmouse);
                        grid.getChildren().remove(doneSelecting);
                        try {
                            String command = "python " + Rscriptdirectory + "ImportMouse.py " + inputdirectory;
                            System.out.println(command);
                            Process importgroup = Runtime.getRuntime().exec(command);
                            importgroup.waitFor();
                        } catch (IOException iop) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException jkl) {
                            System.out.println("Process interrupted");
                        }

                    }
                });
            }
        });
        InitialDiscrininationSurvival.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Button readyToGraph = new Button("I am ready to graph!");
                readyToGraph.setStyle("-fx-base: green");
                grid.add(readyToGraph, 1, 6, 10, 1);
                Cohort cohort = new Cohort();
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberofgroups = numberofgroups + 1;

                        FileChooser IDTreatmentbrowser = new FileChooser();
                        IDTreatmentbrowser.setTitle("Choose the group that you would like to graph:");
                        IDTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = IDTreatmentbrowser.showOpenDialog(primaryStage);
                        String IDTreatmentsource = file2.getAbsolutePath();
                        String IDTreatmentsource2 = IDTreatmentsource.replace('\\','/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader IDtreatmentreader = new BufferedReader(new FileReader(IDTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++){
                                linefromtext = IDtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")){
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")){
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            IDtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Initial Discrimination/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Button groupchoice = new Button(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 1, 1);
                        placement = placement + 1;
                        cohort.cohort.add(new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory));
                        counter = counter + 1;

                        readyToGraph.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                grid.getChildren().remove(readyToGraph);
                                grid.getChildren().remove(choosegroupstograph);

                                System.out.println("Ready to graph!");
                                Button seventy = new Button("70% criterion");
                                Button eighty = new Button("80% criterion");
                                Button ninety = new Button("90% criterion");
                                grid.add(seventy, 1, 4, 10, 1);
                                grid.add(eighty, 1, 5,10, 1);
                                grid.add(ninety, 1, 6, 10, 1);
                                if (numberofgroups == 1){
                                    grid.add(color1, 2, 15, 1, 1);
                                }
                                if (numberofgroups == 2){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                }
                                if (numberofgroups == 3){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                }
                                if (numberofgroups == 4){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                }
                                if (numberofgroups == 5){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                }
                                if (numberofgroups == 6){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                }

                                if (numberofgroups == 7){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                }
                                if (numberofgroups == 8){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                }

                                if (numberofgroups == 9){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                }

                                if (numberofgroups == 10){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                }

                                if (numberofgroups == 11){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                }


                                if (numberofgroups == 12){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                    grid.add(color12, 2, 26, 1, 1);
                                }
                                color1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color1.getValue().toString();
                                        lcolor1 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color2.getValue().toString();
                                        lcolor2 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color3.getValue().toString();
                                        lcolor3 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color4.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color4.getValue().toString();
                                        lcolor4 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color5.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color5.getValue().toString();
                                        lcolor5 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color6.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color6.getValue().toString();
                                        lcolor6 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color7.getValue().toString();
                                        lcolor7 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color8.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color8.getValue().toString();
                                        lcolor8 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color9.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color9.getValue().toString();
                                        lcolor9 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color10.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color10.getValue().toString();
                                        lcolor10 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color11.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color11.getValue().toString();
                                        lcolor11 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color12.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color12.getValue().toString();
                                        lcolor12 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                seventy.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        cohort.criterionUsed = 70;
                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                        } catch (IOException iop) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jkl) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });
                                eighty.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        cohort.criterionUsed = 80;
                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                        } catch (IOException ipo) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jlk) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });
                                ninety.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        cohort.criterionUsed = 90;
                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                        } catch (IOException ito) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jlo) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });
                            }

                        });
                    }
                });
            }
        });
        ReversalSurvival.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Button readyToGraph = new Button("I am ready to graph!");
                readyToGraph.setStyle("-fx-base: green");
                grid.add(readyToGraph, 1, 6, 10, 1);
                Cohort cohort = new Cohort();
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;


                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberofgroups = numberofgroups + 1;

                        FileChooser RevTreatmentbrowser = new FileChooser();
                        RevTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        RevTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = RevTreatmentbrowser.showOpenDialog(primaryStage);
                        String RevTreatmentsource = file2.getAbsolutePath();
                        String RevTreatmentsource2 = RevTreatmentsource.replace('\\','/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader Revtreatmentreader = new BufferedReader(new FileReader(RevTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++){
                                linefromtext = Revtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")){
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")){
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            Revtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Reversal/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Button groupchoice = new Button(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 1, 1);
                        placement = placement + 1;
                        cohort.cohort.add(new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory));
                        counter = counter + 1;

                        readyToGraph.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                grid.getChildren().remove(readyToGraph);
                                grid.getChildren().remove(choosegroupstograph);

                                System.out.println("Ready to graph!");
                                Button seventy = new Button("70% criterion");
                                Button eighty = new Button("80% criterion");
                                Button ninety = new Button("90% criterion");
                                grid.add(seventy, 1, 4, 10, 1);
                                grid.add(eighty, 1, 5,10, 1);
                                grid.add(ninety, 1, 6, 10, 1);
                                if (numberofgroups == 1){
                                    grid.add(color1, 2, 15, 1, 1);
                                }
                                if (numberofgroups == 2){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                }
                                if (numberofgroups == 3){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                }
                                if (numberofgroups == 4){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                }
                                if (numberofgroups == 5){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                }
                                if (numberofgroups == 6){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                }

                                if (numberofgroups == 7){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                }
                                if (numberofgroups == 8){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                }

                                if (numberofgroups == 9){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                }

                                if (numberofgroups == 10){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                }

                                if (numberofgroups == 11){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                }


                                if (numberofgroups == 12){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                    grid.add(color12, 2, 26, 1, 1);
                                }
                                color1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color1.getValue().toString();
                                        lcolor1 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color2.getValue().toString();
                                        lcolor2 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color3.getValue().toString();
                                        lcolor3 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color4.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color4.getValue().toString();
                                        lcolor4 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color5.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color5.getValue().toString();
                                        lcolor5 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color6.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color6.getValue().toString();
                                        lcolor6 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color7.getValue().toString();
                                        lcolor7 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color8.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color8.getValue().toString();
                                        lcolor8 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color9.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color9.getValue().toString();
                                        lcolor9 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color10.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color10.getValue().toString();
                                        lcolor10 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color11.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color11.getValue().toString();
                                        lcolor11 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color12.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color12.getValue().toString();
                                        lcolor12 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                seventy.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        cohort.criterionUsed = 70;
                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                        } catch (IOException iop) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jkl) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });
                                eighty.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        cohort.criterionUsed = 80;
                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                        } catch (IOException ipo) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jlk) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });
                                ninety.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        cohort.criterionUsed = 90;
                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "reversalsurvival.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12 + " " + cohort.criterionUsed;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                        } catch (IOException ito) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jlo) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });
                            }

                        });
                    }
                });
            }
        });
        CalculateDistanceMoved.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Cohort cohort = new Cohort();
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                placement = placement + 1;
                Button readyToGraph = new Button("I am ready to graph!");
                readyToGraph.setStyle("-fx-base: green");
                grid.add(readyToGraph, 1, 6, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);


                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberofgroups = numberofgroups + 1;
                        FileChooser MovTreatmentbrowser = new FileChooser();
                        MovTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        MovTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = MovTreatmentbrowser.showOpenDialog(primaryStage);
                        String MovTreatmentsource = file2.getAbsolutePath();
                        String MovTreatmentsource2 = MovTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader Movtreatmentreader = new BufferedReader(new FileReader(MovTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = Movtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            Movtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Distance moved/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Button groupchoice = new Button(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 1, 1);
                        placement = placement + 1;
                        cohort.cohort.add(new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory));

                        counter = counter + 1;
                        readyToGraph.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                grid.getChildren().remove(choosegroupstograph);
                                grid.getChildren().remove(readyToGraph);
                                Button graph = new Button("Graph");
                                grid.add(graph, 0, 6, 10, 1);
                                if (numberofgroups == 1){
                                    grid.add(color1, 2, 15, 1, 1);
                                }
                                if (numberofgroups == 2){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                }
                                if (numberofgroups == 3){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                }
                                if (numberofgroups == 4){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                }
                                if (numberofgroups == 5){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                }
                                if (numberofgroups == 6){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                }

                                if (numberofgroups == 7){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                }
                                if (numberofgroups == 8){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                }

                                if (numberofgroups == 9){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                }

                                if (numberofgroups == 10){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                }

                                if (numberofgroups == 11){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                }


                                if (numberofgroups == 12){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                    grid.add(color12, 2, 26, 1, 1);
                                }
                                color1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color1.getValue().toString();
                                        lcolor1 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color2.getValue().toString();
                                        lcolor2 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color3.getValue().toString();
                                        lcolor3 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color4.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color4.getValue().toString();
                                        lcolor4 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color5.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color5.getValue().toString();
                                        lcolor5 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color6.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color6.getValue().toString();
                                        lcolor6 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color7.getValue().toString();
                                        lcolor7 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color8.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color8.getValue().toString();
                                        lcolor8 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color9.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color9.getValue().toString();
                                        lcolor9 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color10.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color10.getValue().toString();
                                        lcolor10 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color11.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color11.getValue().toString();
                                        lcolor11 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color12.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color12.getValue().toString();
                                        lcolor12 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                graph.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "movement.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                        } catch (IOException iop) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jkl) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });


                            }
                        });

                    }

                });
            }
        });
        CalculateMovement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser MovTreatmentbrowser = new FileChooser();
                        MovTreatmentbrowser.setTitle("Choose the group you would like to get Movements for:");
                        MovTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = MovTreatmentbrowser.showOpenDialog(primaryStage);
                        String MovTreatmentsource = file2.getAbsolutePath();
                        String MovTreatmentsource2 = MovTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader Movtreatmentreader = new BufferedReader(new FileReader(MovTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = Movtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            Movtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Distance moved/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforMovementSpreadsheet(maindirectory, lastname, Rscriptdirectory);
                        try {
                            Process compileMoveTreatment = Runtime.getRuntime().exec("python " + Rscriptdirectory + "createtreatment.py " + lastname + " " + treatment + " 1");
                            compileMoveTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        MovPrism.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser ETCIDTreatmentbrowser = new FileChooser();
                        ETCIDTreatmentbrowser.setTitle("Choose the group you would like to get indexes for:");
                        ETCIDTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = ETCIDTreatmentbrowser.showOpenDialog(primaryStage);
                        String ETCIDTreatmentsource = file2.getAbsolutePath();
                        String ETCIDTreatmentsource2 = ETCIDTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader ETCIDtreatmentreader = new BufferedReader(new FileReader(ETCIDTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = ETCIDtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            ETCIDtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Distance moved/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforCumulativeIndex(maindirectory, lastname, Rscriptdirectory);
                        try {
                            String command = "python " + Rscriptdirectory + "prism.py " + lastname + " " + treatment + " 3";
                            System.out.println(command);
                            Process compileIndexTreatment = Runtime.getRuntime().exec(command);
                            compileIndexTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        CalculateFeeding.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Cohort cohort = new Cohort();
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                placement = placement + 1;
                Button readyToGraph = new Button("I am ready to graph!");
                readyToGraph.setStyle("-fx-base: green");
                grid.add(readyToGraph, 1, 6, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);




                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberofgroups = numberofgroups + 1;

                        FileChooser FeedingTreatmentbrowser = new FileChooser();
                        FeedingTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        FeedingTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = FeedingTreatmentbrowser.showOpenDialog(primaryStage);
                        String FeedingTreatmentsource = file2.getAbsolutePath();
                        String FeedingTreatmentsource2 = FeedingTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader Feedingtreatmentreader = new BufferedReader(new FileReader(FeedingTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = Feedingtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            Feedingtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Feeding/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Button groupchoice = new Button(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 1, 1);
                        placement = placement + 1;
                        cohort.cohort.add(new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory));

                        counter = counter + 1;
                        readyToGraph.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                grid.getChildren().remove(choosegroupstograph);
                                grid.getChildren().remove(readyToGraph);
                                Button graph = new Button("Graph");
                                grid.add(graph, 0, 6, 10, 1);
                                if (numberofgroups == 1){
                                    grid.add(color1, 2, 15, 1, 1);
                                }
                                if (numberofgroups == 2){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                }
                                if (numberofgroups == 3){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                }
                                if (numberofgroups == 4){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                }
                                if (numberofgroups == 5){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                }
                                if (numberofgroups == 6){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                }

                                if (numberofgroups == 7){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                }
                                if (numberofgroups == 8){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                }

                                if (numberofgroups == 9){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                }

                                if (numberofgroups == 10){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                }

                                if (numberofgroups == 11){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                }


                                if (numberofgroups == 12){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                    grid.add(color12, 2, 26, 1, 1);
                                }
                                color1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color1.getValue().toString();
                                        lcolor1 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color2.getValue().toString();
                                        lcolor2 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color3.getValue().toString();
                                        lcolor3 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color4.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color4.getValue().toString();
                                        lcolor4 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color5.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color5.getValue().toString();
                                        lcolor5 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color6.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color6.getValue().toString();
                                        lcolor6 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color7.getValue().toString();
                                        lcolor7 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color8.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color8.getValue().toString();
                                        lcolor8 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color9.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color9.getValue().toString();
                                        lcolor9 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color10.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color10.getValue().toString();
                                        lcolor10 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color11.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color11.getValue().toString();
                                        lcolor11 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color12.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color12.getValue().toString();
                                        lcolor12 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                graph.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "feeding.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                        } catch (IOException iop) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jkl) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });
                            }
                        });

                    }

                });
            }
        });
        FeedingSpreadsheets.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser FedTreatmentbrowser = new FileChooser();
                        FedTreatmentbrowser.setTitle("Choose the group you would like to get indexes for:");
                        FedTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = FedTreatmentbrowser.showOpenDialog(primaryStage);
                        String FedTreatmentsource = file2.getAbsolutePath();
                        String FedTreatmentsource2 = FedTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader Fedtreatmentreader = new BufferedReader(new FileReader(FedTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = Fedtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            Fedtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Feeding/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforFeedingSpreadsheet(maindirectory, lastname, Rscriptdirectory);
                        try {
                            Process compileFedTreatment = Runtime.getRuntime().exec("python " + Rscriptdirectory + "createtreatment.py " + lastname + " " + treatment + " 2");
                            compileFedTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        FeedingPrism.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser ETCIDTreatmentbrowser = new FileChooser();
                        ETCIDTreatmentbrowser.setTitle("Choose the group you would like to get indexes for:");
                        ETCIDTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = ETCIDTreatmentbrowser.showOpenDialog(primaryStage);
                        String ETCIDTreatmentsource = file2.getAbsolutePath();
                        String ETCIDTreatmentsource2 = ETCIDTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader ETCIDtreatmentreader = new BufferedReader(new FileReader(ETCIDTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = ETCIDtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            ETCIDtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Feeding/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforCumulativeIndex(maindirectory, lastname, Rscriptdirectory);
                        try {
                            String command = "python " + Rscriptdirectory + "prism.py " + lastname + " " + treatment + " 4";
                            System.out.println(command);
                            Process compileIndexTreatment = Runtime.getRuntime().exec(command);
                            compileIndexTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        CalculateETCID.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser ETCIDTreatmentbrowser = new FileChooser();
                        ETCIDTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        ETCIDTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = ETCIDTreatmentbrowser.showOpenDialog(primaryStage);
                        String ETCIDTreatmentsource = file2.getAbsolutePath();
                        String ETCIDTreatmentsource2 = ETCIDTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader ETCIDtreatmentreader = new BufferedReader(new FileReader(ETCIDTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = ETCIDtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            ETCIDtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Entries to Criterion/Initial Discrimination/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforIDETC(maindirectory, lastname, Rscriptdirectory);
                        try {
                            Process compileIDETCTreatment = Runtime.getRuntime().exec("Rscript " + Rscriptdirectory + "CohortGrapher.r");
                            compileIDETCTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        CalculateETCR.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser ETCRevTreatmentbrowser = new FileChooser();
                        ETCRevTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        ETCRevTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = ETCRevTreatmentbrowser.showOpenDialog(primaryStage);
                        String ETCRevTreatmentsource = file2.getAbsolutePath();
                        String ETCRevTreatmentsource2 = ETCRevTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader ETCRevtreatmentreader = new BufferedReader(new FileReader(ETCRevTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = ETCRevtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            ETCRevtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Entries to Criterion/Reversal/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforRevETC(maindirectory, lastname, Rscriptdirectory);
                        try {
                            Process compileRevETCTreatment = Runtime.getRuntime().exec("Rscript " + Rscriptdirectory + "CohortGrapher.r");
                            compileRevETCTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        CalculateCumulativeIndex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser ETCIDTreatmentbrowser = new FileChooser();
                        ETCIDTreatmentbrowser.setTitle("Choose the group you would like to get indexes for:");
                        ETCIDTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = ETCIDTreatmentbrowser.showOpenDialog(primaryStage);
                        String ETCIDTreatmentsource = file2.getAbsolutePath();
                        String ETCIDTreatmentsource2 = ETCIDTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader ETCIDtreatmentreader = new BufferedReader(new FileReader(ETCIDTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = ETCIDtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            ETCIDtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Cumulative/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforCumulativeIndex(maindirectory, lastname, Rscriptdirectory);
                        try {
                            String command = "python " + Rscriptdirectory + "createtreatment.py " + lastname + " " + treatment + " 8";
                            System.out.println(command);
                            Process compileIndexTreatment = Runtime.getRuntime().exec(command);
                            compileIndexTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        CumulativePrism.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser ETCIDTreatmentbrowser = new FileChooser();
                        ETCIDTreatmentbrowser.setTitle("Choose the group you would like to get indexes for:");
                        ETCIDTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = ETCIDTreatmentbrowser.showOpenDialog(primaryStage);
                        String ETCIDTreatmentsource = file2.getAbsolutePath();
                        String ETCIDTreatmentsource2 = ETCIDTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader ETCIDtreatmentreader = new BufferedReader(new FileReader(ETCIDTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = ETCIDtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            ETCIDtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Cumulative/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforCumulativeIndex(maindirectory, lastname, Rscriptdirectory);
                        try {
                            String command = "python " + Rscriptdirectory + "prism.py " + lastname + " " + treatment + " 2";
                            System.out.println(command);
                            Process compileIndexTreatment = Runtime.getRuntime().exec(command);
                            compileIndexTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        GraphCumulativeIndex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Cohort cohort = new Cohort();
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                placement = placement + 1;
                Button readyToGraph = new Button("I am ready to graph!");
                readyToGraph.setStyle("-fx-base: green");
                grid.add(readyToGraph, 1, 6, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                int pyvalue = 1;


                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberofgroups = numberofgroups + 1;
                        FileChooser GraphIndexTreatmentbrowser = new FileChooser();
                        GraphIndexTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        GraphIndexTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = GraphIndexTreatmentbrowser.showOpenDialog(primaryStage);
                        String GraphIndexTreatmentsource = file2.getAbsolutePath();
                        String GraphIndexTreatmentsource2 = GraphIndexTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader GraphIndextreatmentreader = new BufferedReader(new FileReader(GraphIndexTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = GraphIndextreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            GraphIndextreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Distance moved/" + treatment);
                        int size = 0;
                        size = directory1.list().length;

                        System.out.println(treatment + " " + lastname + " " + size);
                        Button groupchoice = new Button(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 1, 1);

                        placement = placement + 1;
                        cohort.cohort.add(new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory));

                        counter = counter + 1;
                        readyToGraph.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                grid.getChildren().remove(choosegroupstograph);
                                grid.getChildren().remove(readyToGraph);
                                Button graph = new Button("Graph");
                                grid.add(graph, 0, 6, 10, 1);
                                if (numberofgroups == 1){
                                    grid.add(color1, 2, 15, 1, 1);
                                }
                                if (numberofgroups == 2){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                }
                                if (numberofgroups == 3){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                }
                                if (numberofgroups == 4){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                }
                                if (numberofgroups == 5){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                }
                                if (numberofgroups == 6){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                }

                                if (numberofgroups == 7){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                }
                                if (numberofgroups == 8){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                }

                                if (numberofgroups == 9){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                }

                                if (numberofgroups == 10){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                }

                                if (numberofgroups == 11){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                }


                                if (numberofgroups == 12){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                    grid.add(color12, 2, 26, 1, 1);
                                }
                                color1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color1.getValue().toString();
                                        lcolor1 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color2.getValue().toString();
                                        lcolor2 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color3.getValue().toString();
                                        lcolor3 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color4.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color4.getValue().toString();
                                        lcolor4 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color5.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color5.getValue().toString();
                                        lcolor5 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color6.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color6.getValue().toString();
                                        lcolor6 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color7.getValue().toString();
                                        lcolor7 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color8.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color8.getValue().toString();
                                        lcolor8 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color9.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color9.getValue().toString();
                                        lcolor9 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color10.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color10.getValue().toString();
                                        lcolor10 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color11.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color11.getValue().toString();
                                        lcolor11 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color12.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color12.getValue().toString();
                                        lcolor12 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                graph.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "index.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }


                                        } catch (IOException iop) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jkl) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });


                            }
                        });

                    }

                });
            }
        });
        GraphIndepIndex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Cohort cohort = new Cohort();
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                placement = placement + 1;
                Button readyToGraph = new Button("I am ready to graph!");
                readyToGraph.setStyle("-fx-base: green");
                grid.add(readyToGraph, 1, 6, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                int pyvalue = 1;


                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberofgroups = numberofgroups + 1;
                        FileChooser GraphIndexTreatmentbrowser = new FileChooser();
                        GraphIndexTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        GraphIndexTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = GraphIndexTreatmentbrowser.showOpenDialog(primaryStage);
                        String GraphIndexTreatmentsource = file2.getAbsolutePath();
                        String GraphIndexTreatmentsource2 = GraphIndexTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader GraphIndextreatmentreader = new BufferedReader(new FileReader(GraphIndexTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = GraphIndextreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            GraphIndextreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Distance moved/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Button groupchoice = new Button(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 1, 1);
                        placement = placement + 1;
                        cohort.cohort.add(new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory));

                        counter = counter + 1;
                        readyToGraph.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                grid.getChildren().remove(choosegroupstograph);
                                grid.getChildren().remove(readyToGraph);
                                Button graph = new Button("Graph");
                                grid.add(graph, 0, 6, 10, 1);
                                if (numberofgroups == 1){
                                    grid.add(color1, 2, 15, 1, 1);
                                }
                                if (numberofgroups == 2){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                }
                                if (numberofgroups == 3){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                }
                                if (numberofgroups == 4){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                }
                                if (numberofgroups == 5){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                }
                                if (numberofgroups == 6){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                }

                                if (numberofgroups == 7){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                }
                                if (numberofgroups == 8){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                }

                                if (numberofgroups == 9){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                }

                                if (numberofgroups == 10){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                }

                                if (numberofgroups == 11){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                }


                                if (numberofgroups == 12){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                    grid.add(color12, 2, 26, 1, 1);
                                }
                                color1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color1.getValue().toString();
                                        lcolor1 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color2.getValue().toString();
                                        lcolor2 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color3.getValue().toString();
                                        lcolor3 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color4.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color4.getValue().toString();
                                        lcolor4 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color5.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color5.getValue().toString();
                                        lcolor5 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color6.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color6.getValue().toString();
                                        lcolor6 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color7.getValue().toString();
                                        lcolor7 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color8.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color8.getValue().toString();
                                        lcolor8 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color9.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color9.getValue().toString();
                                        lcolor9 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color10.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color10.getValue().toString();
                                        lcolor10 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color11.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color11.getValue().toString();
                                        lcolor11 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color12.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color12.getValue().toString();
                                        lcolor12 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                graph.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "independentindex.py " + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }



                                        } catch (IOException iop) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jkl) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });


                            }
                        });

                    }

                });
            }
        });
        CalculateIndepIndex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser ETCIDTreatmentbrowser = new FileChooser();
                        ETCIDTreatmentbrowser.setTitle("Choose the group you would like to get indexes for:");
                        ETCIDTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = ETCIDTreatmentbrowser.showOpenDialog(primaryStage);
                        String ETCIDTreatmentsource = file2.getAbsolutePath();
                        String ETCIDTreatmentsource2 = ETCIDTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader ETCIDtreatmentreader = new BufferedReader(new FileReader(ETCIDTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = ETCIDtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            ETCIDtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Independent/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforCumulativeIndex(maindirectory, lastname, Rscriptdirectory);
                        try {
                            String command = "python " + Rscriptdirectory + "createtreatment.py " + lastname + " " + treatment + " 7";
                            System.out.println(command);
                            Process compileIndexTreatment = Runtime.getRuntime().exec(command);
                            compileIndexTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        IndIndexPrism.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser ETCIDTreatmentbrowser = new FileChooser();
                        ETCIDTreatmentbrowser.setTitle("Choose the group you would like to get indexes for:");
                        ETCIDTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = ETCIDTreatmentbrowser.showOpenDialog(primaryStage);
                        String ETCIDTreatmentsource = file2.getAbsolutePath();
                        String ETCIDTreatmentsource2 = ETCIDTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader ETCIDtreatmentreader = new BufferedReader(new FileReader(ETCIDTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = ETCIDtreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            ETCIDtreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Independent/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Text groupchoice = new Text(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 10, 1);
                        placement = placement + 1;
                        Treatment newtreatment = new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory);
                        newtreatment.createTreatmentforCumulativeIndex(maindirectory, lastname, Rscriptdirectory);
                        try {
                            String command = "python " + Rscriptdirectory + "prism.py " + lastname + " " + treatment + " 1";
                            System.out.println(command);
                            Process compileIndexTreatment = Runtime.getRuntime().exec(command);
                            compileIndexTreatment.waitFor();
                            file6.delete();
                        } catch(IOException zxc) {
                            System.out.println("I/O Error");
                        } catch (InterruptedException cxz) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });
        PostInjection.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button addmouse = new Button("Select a mouse");
                Button doneSelecting = new Button("Graph");
                doneSelecting.setStyle("-fx-base: green");
                grid.getChildren().remove(mouseRDA);
                grid.add(addmouse, 1, 3, 1, 1);
                grid.add(doneSelecting, 2, 3, 1, 1);
                Text miceselected = new Text("Mice selected: ");
                miceselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(miceselected, 1, placement, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                placement = placement + 1;
                addmouse.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {

                            String AnimalID = " ";
                            String treatment = " ";
                            String line;
                            FileChooser browser = new FileChooser();
                            browser.setTitle("Select a mouse to examine");
                            browser.setInitialDirectory(new File("D:/Inputs/"));
                            File file = browser.showOpenDialog(primaryStage);
                            String source = file.getAbsolutePath();
                            String source2 = source.replace('\\','/');
                            BufferedReader reader = new BufferedReader(new FileReader(source2));
                            int linenumber = 0;
                            for (int i = 0; i < 100; i++){
                                line = reader.readLine();
                                if (line.contains("Investigator")){
                                    lastname = line.substring(16, line.length() - 2);
                                }
                                if (line.contains("Treatment")){
                                    treatment = line.substring(13, line.length() - 2);
                                }
                                if (line.contains("AnimalID")){
                                    AnimalID = "mouse" + line.substring(12, line.length() - 2);
                                }
                                if (line.contains("Trial time")){
                                    linenumber = i;
                                }
                            }
                            reader.close();
                            System.out.println(AnimalID + " " + treatment + " " + lastname);
                            Text groupchoice = new Text(treatment + " " + lastname + " ");
                            grid.add(groupchoice, 1, placement, 10, 1);
                            placement = placement + 1;
                            Mouse mouse = new Mouse(AnimalID, treatment);

                            File file11 = new File(maindirectory + lastname + "/Treatments/" + treatment + ".txt");
                            if (!file11.exists()){
                                try {
                                    BufferedWriter TextTreatment = new BufferedWriter(new FileWriter(maindirectory + lastname + "/Treatments/" + treatment + ".txt", true));
                                    TextTreatment.write("Treatment: " + treatment + "\n");
                                    TextTreatment.write("Investigator: " + lastname + "\n");
                                    TextTreatment.close();
                                } catch (IOException IDtextexception) {
                                    System.out.println("Could not create treatment text file.");
                                }
                            }
                            mouse.mousePostInjection(source2, linenumber, lastname, maindirectory, Rscriptdirectory);

                            BufferedWriter mousescripts = new BufferedWriter(new FileWriter(Rscriptdirectory + "pythonscriptlist.txt", true));
                            mousescripts.write(Rscriptdirectory + lastname + mouse.AnimalID + ".py\n");
                            mousescripts.close();
                        } catch(FileNotFoundException art) {
                            System.out.println("File not found");
                        } catch (IOException cantdoit){
                            System.out.println("Can't read/write");
                        }
                    }
                });
                doneSelecting.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        grid.getChildren().remove(doneSelecting);
                        Button startit = new Button("Start the multicorescriptrunner program");
                        grid.add(startit, 1, 3, 10, 1);
                    }
                });
            }
        });
        GraphSegmentDistribution.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Cohort cohort = new Cohort();
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                placement = placement + 1;
                Button readyToGraph = new Button("I am ready to graph!");
                readyToGraph.setStyle("-fx-base: green");
                grid.add(readyToGraph, 1, 6, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                int pyvalue = 1;


                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberofgroups = numberofgroups + 1;
                        FileChooser GraphIndexTreatmentbrowser = new FileChooser();
                        GraphIndexTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        GraphIndexTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = GraphIndexTreatmentbrowser.showOpenDialog(primaryStage);
                        String GraphIndexTreatmentsource = file2.getAbsolutePath();
                        String GraphIndexTreatmentsource2 = GraphIndexTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader GraphIndextreatmentreader = new BufferedReader(new FileReader(GraphIndexTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = GraphIndextreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            GraphIndextreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Distance moved/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Button groupchoice = new Button(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 1, 1);
                        placement = placement + 1;
                        cohort.cohort.add(new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory));

                        counter = counter + 1;
                        readyToGraph.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                grid.getChildren().remove(choosegroupstograph);
                                grid.getChildren().remove(readyToGraph);
                                Button graph = new Button("Graph");
                                grid.add(graph, 0, 6, 10, 1);
                                if (numberofgroups == 1){
                                    grid.add(color1, 2, 15, 1, 1);
                                }
                                if (numberofgroups == 2){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                }
                                if (numberofgroups == 3){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                }
                                if (numberofgroups == 4){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                }
                                if (numberofgroups == 5){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                }
                                if (numberofgroups == 6){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                }

                                if (numberofgroups == 7){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                }
                                if (numberofgroups == 8){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                }

                                if (numberofgroups == 9){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                }

                                if (numberofgroups == 10){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                }

                                if (numberofgroups == 11){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                }


                                if (numberofgroups == 12){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                    grid.add(color12, 2, 26, 1, 1);
                                }
                                color1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color1.getValue().toString();
                                        lcolor1 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color2.getValue().toString();
                                        lcolor2 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color3.getValue().toString();
                                        lcolor3 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color4.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color4.getValue().toString();
                                        lcolor4 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color5.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color5.getValue().toString();
                                        lcolor5 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color6.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color6.getValue().toString();
                                        lcolor6 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color7.getValue().toString();
                                        lcolor7 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color8.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color8.getValue().toString();
                                        lcolor8 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color9.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color9.getValue().toString();
                                        lcolor9 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color10.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color10.getValue().toString();
                                        lcolor10 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color11.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color11.getValue().toString();
                                        lcolor11 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color12.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color12.getValue().toString();
                                        lcolor12 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                graph.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "groupsegmentation.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }



                                        } catch (IOException iop) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jkl) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });


                            }
                        });

                    }

                });
            }
        });
        GraphInitialETCScatter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Cohort cohort = new Cohort();
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                placement = placement + 1;
                Button readyToGraph = new Button("I am ready to graph!");
                readyToGraph.setStyle("-fx-base: green");
                grid.add(readyToGraph, 1, 6, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                int pyvalue = 1;


                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberofgroups = numberofgroups + 1;
                        FileChooser GraphIndexTreatmentbrowser = new FileChooser();
                        GraphIndexTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        GraphIndexTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = GraphIndexTreatmentbrowser.showOpenDialog(primaryStage);
                        String GraphIndexTreatmentsource = file2.getAbsolutePath();
                        String GraphIndexTreatmentsource2 = GraphIndexTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader GraphIndextreatmentreader = new BufferedReader(new FileReader(GraphIndexTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = GraphIndextreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            GraphIndextreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Distance moved/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Button groupchoice = new Button(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 1, 1);
                        placement = placement + 1;
                        cohort.cohort.add(new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory));

                        counter = counter + 1;
                        readyToGraph.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                grid.getChildren().remove(choosegroupstograph);
                                grid.getChildren().remove(readyToGraph);
                                Button graph = new Button("Graph");
                                grid.add(graph, 0, 6, 10, 1);
                                if (numberofgroups == 1){
                                    grid.add(color1, 2, 15, 1, 1);
                                }
                                if (numberofgroups == 2){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                }
                                if (numberofgroups == 3){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                }
                                if (numberofgroups == 4){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                }
                                if (numberofgroups == 5){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                }
                                if (numberofgroups == 6){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                }

                                if (numberofgroups == 7){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                }
                                if (numberofgroups == 8){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                }

                                if (numberofgroups == 9){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                }

                                if (numberofgroups == 10){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                }

                                if (numberofgroups == 11){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                }


                                if (numberofgroups == 12){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                    grid.add(color12, 2, 26, 1, 1);
                                }
                                color1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color1.getValue().toString();
                                        lcolor1 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color2.getValue().toString();
                                        lcolor2 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color3.getValue().toString();
                                        lcolor3 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color4.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color4.getValue().toString();
                                        lcolor4 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color5.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color5.getValue().toString();
                                        lcolor5 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color6.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color6.getValue().toString();
                                        lcolor6 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color7.getValue().toString();
                                        lcolor7 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color8.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color8.getValue().toString();
                                        lcolor8 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color9.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color9.getValue().toString();
                                        lcolor9 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color10.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color10.getValue().toString();
                                        lcolor10 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color11.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color11.getValue().toString();
                                        lcolor11 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color12.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color12.getValue().toString();
                                        lcolor12 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                graph.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "initialetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }



                                        } catch (IOException iop) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jkl) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });


                            }
                        });

                    }

                });
            }
        });
        GraphRevETCScatter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Button choosegroupstograph = new Button("Choose groups to graph.");
                grid.add(choosegroupstograph, 1, 4, 10, 1);
                Cohort cohort = new Cohort();
                Text treatmentsselected = new Text("Treatments selected: ");
                treatmentsselected.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                grid.add(treatmentsselected, 1, placement, 10, 1);
                placement = placement + 1;
                Button readyToGraph = new Button("I am ready to graph!");
                readyToGraph.setStyle("-fx-base: green");
                grid.add(readyToGraph, 1, 6, 10, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                int pyvalue = 1;


                choosegroupstograph.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberofgroups = numberofgroups + 1;
                        FileChooser GraphIndexTreatmentbrowser = new FileChooser();
                        GraphIndexTreatmentbrowser.setTitle("Choose the mouse you would like to import into R:");
                        GraphIndexTreatmentbrowser.setInitialDirectory(new File(directorychooser));
                        File file2 = GraphIndexTreatmentbrowser.showOpenDialog(primaryStage);
                        String GraphIndexTreatmentsource = file2.getAbsolutePath();
                        String GraphIndexTreatmentsource2 = GraphIndexTreatmentsource.replace('\\', '/');
                        String group = "";
                        String treatment = " ";
                        try {
                            BufferedReader GraphIndextreatmentreader = new BufferedReader(new FileReader(GraphIndexTreatmentsource2));
                            String linefromtext;
                            for (int f = 0; f < 2; f++) {
                                linefromtext = GraphIndextreatmentreader.readLine();
                                if (linefromtext.contains("Treatment")) {
                                    treatment = linefromtext.substring(11, linefromtext.length());
                                }
                                if (linefromtext.contains("Investigator")) {
                                    lastname = linefromtext.substring(14, linefromtext.length());
                                }
                            }
                            GraphIndextreatmentreader.close();
                        } catch (IOException creatingtreatmentgrouperror) {
                            System.out.println("Error");
                        }
                        directorychooser = maindirectory + lastname + "/Treatments";
                        File directory1 = new File(maindirectory + lastname + "/Data/Distance moved/" + treatment);
                        int size = 0;
                        size = directory1.list().length;
                        System.out.println(treatment + " " + lastname + " " + size);
                        Button groupchoice = new Button(treatment + " " + lastname + " " + size);
                        grid.add(groupchoice, 1, placement, 1, 1);
                        placement = placement + 1;
                        cohort.cohort.add(new Treatment(treatment, size, maindirectory, lastname, Rscriptdirectory));

                        counter = counter + 1;
                        readyToGraph.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                grid.getChildren().remove(choosegroupstograph);
                                grid.getChildren().remove(readyToGraph);
                                Button graph = new Button("Graph");
                                grid.add(graph, 0, 6, 10, 1);
                                if (numberofgroups == 1){
                                    grid.add(color1, 2, 15, 1, 1);
                                }
                                if (numberofgroups == 2){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                }
                                if (numberofgroups == 3){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                }
                                if (numberofgroups == 4){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                }
                                if (numberofgroups == 5){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                }
                                if (numberofgroups == 6){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                }

                                if (numberofgroups == 7){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                }
                                if (numberofgroups == 8){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                }

                                if (numberofgroups == 9){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                }

                                if (numberofgroups == 10){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                }

                                if (numberofgroups == 11){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                }


                                if (numberofgroups == 12){
                                    grid.add(color1, 2, 15, 1, 1);
                                    grid.add(color2, 2, 16, 1, 1);
                                    grid.add(color3, 2, 17, 1, 1);
                                    grid.add(color4, 2, 18, 1, 1);
                                    grid.add(color5, 2, 19, 1, 1);
                                    grid.add(color6, 2, 20, 1, 1);
                                    grid.add(color7, 2, 21, 1, 1);
                                    grid.add(color8, 2, 22, 1, 1);
                                    grid.add(color9, 2, 23, 1, 1);
                                    grid.add(color10, 2, 24, 1, 1);
                                    grid.add(color11, 2, 25, 1, 1);
                                    grid.add(color12, 2, 26, 1, 1);
                                }
                                color1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color1.getValue().toString();
                                        lcolor1 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color2.getValue().toString();
                                        lcolor2 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color3.getValue().toString();
                                        lcolor3 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color4.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color4.getValue().toString();
                                        lcolor4 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color5.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color5.getValue().toString();
                                        lcolor5 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color6.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color6.getValue().toString();
                                        lcolor6 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color7.getValue().toString();
                                        lcolor7 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color8.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color8.getValue().toString();
                                        lcolor8 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color9.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color9.getValue().toString();
                                        lcolor9 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color10.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color10.getValue().toString();
                                        lcolor10 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color11.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color11.getValue().toString();
                                        lcolor11 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                color12.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        String colorvalue = color12.getValue().toString();
                                        lcolor12 = "#" + colorvalue.substring(2, colorvalue.length()-2);
                                    }
                                });
                                graph.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        try {
                                            if (numberofgroups == 1)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + lcolor1;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 2)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + lcolor1 + " " + lcolor2;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 3)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 4)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 5)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 6)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }

                                            if (numberofgroups == 7)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 8)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 9)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 10)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 11)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }
                                            if (numberofgroups == 12)
                                            {
                                                String command = "python " + Rscriptdirectory + "revetcscatter.py" + " " + lastname + " " + numberofgroups + " " + cohort.cohort.get(0).group + " " + cohort.cohort.get(1).group + " " + cohort.cohort.get(2).group + " " + cohort.cohort.get(3).group + " " + cohort.cohort.get(4).group + " " + cohort.cohort.get(5).group + " " + cohort.cohort.get(6).group + " " + cohort.cohort.get(7).group + " " + cohort.cohort.get(8).group + " " + cohort.cohort.get(9).group + " " + cohort.cohort.get(10).group + " "  + cohort.cohort.get(11).group + " " + lcolor1 + " " + lcolor2 + " " + lcolor3 + " " + lcolor4 + " " + lcolor5 + " " + lcolor6 + " " + lcolor7 + " " + lcolor8 + " " + lcolor9 + " " + lcolor10 + " " + lcolor11 + " " + lcolor12;
                                                System.out.println(command);
                                                Process graphindexcohort = Runtime.getRuntime().exec(command);
                                                graphindexcohort.waitFor();
                                            }



                                        } catch (IOException iop) {
                                            System.out.println("I/O Error");
                                        } catch (InterruptedException jkl) {
                                            System.out.println("Process interrupted");
                                        }
                                    }
                                });


                            }
                        });

                    }

                });
            }
        });
        IndMouse.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().remove(mouseRDA);
                grid.getChildren().remove(question1);
                grid.getChildren().remove(InitialDiscrininationSurvival);
                grid.getChildren().remove(ReversalSurvival);
                grid.getChildren().remove(CalculateETCID);
                grid.getChildren().remove(CalculateETCR);
                grid.getChildren().remove(CalculateDistanceMoved);
                grid.getChildren().remove(CalculateFeeding);
                grid.getChildren().remove(CalculateCumulativeIndex);
                grid.getChildren().remove(GraphCumulativeIndex);
                grid.getChildren().remove(CumulativePrism);
                grid.getChildren().remove(Survival);
                grid.getChildren().remove(Index);
                grid.getChildren().remove(movement);
                grid.getChildren().remove(Feeding);
                grid.getChildren().remove(ETC);
                grid.getChildren().remove(CalculateMovement);
                grid.getChildren().remove(MovPrism);
                grid.getChildren().remove(FeedingSpreadsheets);
                grid.getChildren().remove(FeedingPrism);
                grid.getChildren().remove(PostInjection);
                grid.getChildren().remove(IndMouse);
                grid.getChildren().remove(Segment);
                grid.getChildren().remove(GraphSegmentDistribution);
                grid.getChildren().remove(IndepIndex);
                grid.getChildren().remove(GraphIndepIndex);
                grid.getChildren().remove(CalculateIndepIndex);
                grid.getChildren().remove(IndIndexPrism);
                grid.getChildren().remove(ScatterPlots);
                grid.getChildren().remove(GraphInitialETCScatter);
                grid.getChildren().remove(GraphRevETCScatter);
                Mouse mouse = new Mouse();
                Button addmouse = new Button("Select a mouse");
                Button doneSelecting = new Button("Create graph");
                doneSelecting.setStyle("-fx-base: green");
                Scanner scanner = new Scanner(System.in);
                Text startlabel = new Text("Start");
                startlabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
                TextField start = new TextField();
                start.setMaxWidth(60.0);
                Text endlabel = new Text("End");
                endlabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
                TextField end = new TextField();
                end.setMaxWidth(60.0);
                Text intervallabel = new Text("Interval");
                intervallabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
                TextField interval = new TextField();
                interval.setMaxWidth(60.0);
                Button seconds = new Button("Seconds");
                Button minutes = new Button("Minutes");
                Button hours = new Button("Hours");
                Text xticklabel = new Text("xticks:");
                xticklabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
                TextField xticks = new TextField();
                xticks.setMaxWidth(335.0);
                Text yticklabel = new Text("yticks:");
                yticklabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
                TextField yticks = new TextField();
                yticks.setMaxWidth(335.0);

                start.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mouse.rangeStart = start.getCharacters().toString();
                    }
                });
                end.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mouse.rangeEnd = end.getCharacters().toString();
                    }
                });
                interval.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mouse.rangeInterval = interval.getCharacters().toString();
                    }
                });
                seconds.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mouse.timetype = "seconds";
                    }
                });
                minutes.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mouse.timetype = "minutes";
                    }
                });
                hours.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mouse.timetype = "hours";
                    }
                });
                xticks.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mouse.xticks = xticks.getCharacters().toString();
                    }
                });
                yticks.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mouse.yticks = yticks.getCharacters().toString();
                    }
                });
                grid.getChildren().remove(mouseRDA);
                grid.add(addmouse, 1, 3, 3, 1);
                grid.add(doneSelecting, 4, 3, 3, 1);
                grid.add(MainMenu, 2, 13, 1, 1);
                grid.add(startlabel, 1, 5, 1, 1);
                grid.add(endlabel, 2, 5, 1, 1);
                grid.add(intervallabel, 3, 5, 1, 1);
                grid.add(start, 1, 6, 1, 1);
                grid.add(end, 2, 6, 1, 1);
                grid.add(interval, 3, 6, 1, 1);
                grid.add(seconds, 4, 6, 1, 1);
                grid.add(minutes, 5, 6, 1, 1);
                grid.add(hours, 6, 6, 1, 1);
                grid.add(xticklabel, 1, 7, 1, 1);
                grid.add(xticks, 2, 7, 10, 1);
                grid.add(yticklabel, 1, 8, 1, 1);
                grid.add(yticks, 2, 8, 10, 1);


                addmouse.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {

                            String AnimalID = " ";
                            String treatment = " ";
                            String line;
                            FileChooser browser = new FileChooser();
                            browser.setTitle("Select a mouse to examine");
                            browser.setInitialDirectory(new File("D:/Inputs/"));
                            File file = browser.showOpenDialog(primaryStage);
                            String source = file.getAbsolutePath();
                            String source2 = source.replace('\\','/');
                            BufferedReader reader = new BufferedReader(new FileReader(source2));
                            int linenumber = 0;
                            for (int i = 0; i < 100; i++){
                                line = reader.readLine();
                                if (line.contains("Investigator")){
                                    lastname = line.substring(16, line.length() - 2);
                                }
                                if (line.contains("Treatment")){
                                    treatment = line.substring(13, line.length() - 2);
                                }
                                if (line.contains("AnimalID")){
                                    AnimalID = "mouse" + line.substring(12, line.length() - 2);
                                }
                                if (line.contains("Trial time")){
                                    linenumber = i;
                                }
                            }
                            reader.close();
                            mouse.AnimalID = AnimalID;
                            mouse.treatment = treatment;
                            mouse.IndMouseGrapher(source2, linenumber, lastname, maindirectory, Rscriptdirectory);

                            BufferedWriter mousescripts = new BufferedWriter(new FileWriter(Rscriptdirectory + "pythonscriptlist.txt", true));
                            mousescripts.write(Rscriptdirectory + lastname + mouse.AnimalID + ".py\n");
                            mousescripts.close();
                        } catch(FileNotFoundException art) {
                            System.out.println("File not found");
                        } catch (IOException cantdoit){
                            System.out.println("Can't read/write");
                        }
                    }
                });
                doneSelecting.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            Process graphmouse = Runtime.getRuntime().exec("python " + Rscriptdirectory + lastname + mouse.AnimalID + "Grapher.py");
                            graphmouse.waitFor();
                        } catch (IOException g) {
                            System.out.println("Script not found");
                        } catch (InterruptedException h) {
                            System.out.println("Process interrupted");
                        }
                    }
                });
            }
        });

    }

}


