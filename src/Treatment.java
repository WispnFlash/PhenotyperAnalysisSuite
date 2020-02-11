import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Treatment {
    public ArrayList<Mouse> treatmentgroup = new ArrayList<Mouse>();
    public String group;
    public String status;
    public int groupsize;
    public String treatmentlocation;




    public Treatment(String group, int groupsize, String maindirectory, String lastname, String Rscriptdirectory) {
        this.group = group;
        this.groupsize = groupsize;
    }

    public void createTreatmentforInitial(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Data/Initial Discrimination/" + group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");

            cohortcreator.write( "cvb <- dataset\n");
            cohortcreator.write("\n");
            cohortcreator.write("rm(dataset)\n");
            cohortcreator.write( "SeventyPercentCriterionreached <- c(");
            int a;
            int x = 1;
            for (a = 1; a < 6000; a++)
            {
                cohortcreator.write( "(sum(subset(cvb$SeventyQualifier, cvb$EntryNumber == " + x + ")))/" + this.groupsize + "*100, ");
                x = x + 1;
            }
            cohortcreator.write( "(sum(subset(cvb$SeventyQualifier, cvb$EntryNumber == 6000)))/" + this.groupsize + "*100)\n");
            cohortcreator.write("\n");

            cohortcreator.write( "EightyPercentCriterionreached <- c(");
            int b;
            int y = 1;
            for (b = 1; b < 6000; b++)
            {
                cohortcreator.write( "(sum(subset(cvb$EightyQualifier, cvb$EntryNumber == " + y + ")))/" + this.groupsize + "*100, ");
                y = y + 1;
            }
            cohortcreator.write( "(sum(subset(cvb$EightyQualifier, cvb$EntryNumber == 6000)))/" + this.groupsize + "*100)\n");
            cohortcreator.write("\n");

            cohortcreator.write( "NinetyPercentCriterionreached <- c(");
            int d;
            int z = 1;
            for (d = 1; d < 6000; d++)
            {
                cohortcreator.write( "(sum(subset(cvb$NinetyQualifier, cvb$EntryNumber == " + z + ")))/" + this.groupsize + "*100, ");
                z = z + 1;
            }
            cohortcreator.write( "(sum(subset(cvb$NinetyQualifier, cvb$EntryNumber == 6000)))/" + this.groupsize + "*100)\n");
            cohortcreator.write("\n");

            cohortcreator.write( "Entry <- c(1:6000)\n");
            cohortcreator.write( this.group + " <- data.frame(\"" + this.group + "\", Entry, SeventyPercentCriterionreached, EightyPercentCriterionreached, NinetyPercentCriterionreached)\n");
            cohortcreator.write("rm(list= 'Entry', 'SeventyPercentCriterionreached', 'EightyPercentCriterionreached', 'NinetyPercentCriterionreached')\n");
            cohortcreator.write( "rm(cvb)\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }

    public void createTreatmentforInitialPlotPyversion(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
            cohortcreator.write(this.group + " = CreateCohort(\"" + maindirectory + lastname + "/Data/Initial Discrimination/" + this.group + "/\")\n");
            cohortcreator.close();
        } catch (IOException py) {
            System.out.println("Could not complete");
        }
    }

    public void createTreatmentforReversalPlotPyversion(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
            cohortcreator.write(this.group + " = CreateCohort(\"" + maindirectory + lastname + "/Data/Reversal/" + this.group + "/\")\n");
            cohortcreator.close();
        } catch (IOException py) {
            System.out.println("Could not complete");
        }
    }

    public void createTreatmentforReversal(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Data/Reversal/" + group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");

            cohortcreator.write( "cvb <- dataset\n");
            cohortcreator.write("\n");
            cohortcreator.write("rm(dataset)\n");
            cohortcreator.write( "SeventyPercentCriterionreached <- c(");
            int a;
            int x = 1;
            for (a = 1; a < 6000; a++)
            {
                cohortcreator.write( "(sum(subset(cvb$SeventyQualifier, cvb$EntryNumber == " + x + ")))/" + this.groupsize + "*100, ");
                x = x + 1;
            }
            cohortcreator.write( "(sum(subset(cvb$SeventyQualifier, cvb$EntryNumber == 6000)))/" + this.groupsize + "*100)\n");
            cohortcreator.write("\n");

            cohortcreator.write( "EightyPercentCriterionreached <- c(");
            int b;
            int y = 1;
            for (b = 1; b < 6000; b++)
            {
                cohortcreator.write( "(sum(subset(cvb$EightyQualifier, cvb$EntryNumber == " + y + ")))/" + this.groupsize + "*100, ");
                y = y + 1;
            }
            cohortcreator.write( "(sum(subset(cvb$EightyQualifier, cvb$EntryNumber == 6000)))/" + this.groupsize + "*100)\n");
            cohortcreator.write("\n");

            cohortcreator.write( "NinetyPercentCriterionreached <- c(");
            int d;
            int z = 1;
            for (d = 1; d < 6000; d++)
            {
                cohortcreator.write( "(sum(subset(cvb$NinetyQualifier, cvb$EntryNumber == " + z + ")))/" + this.groupsize + "*100, ");
                z = z + 1;
            }
            cohortcreator.write( "(sum(subset(cvb$NinetyQualifier, cvb$EntryNumber == 6000)))/" + this.groupsize + "*100)\n");
            cohortcreator.write("\n");

            cohortcreator.write( "Entry <- c(1:6000)\n");
            cohortcreator.write( this.group + " <- data.frame(\"" + this.group + "\", Entry, SeventyPercentCriterionreached, EightyPercentCriterionreached, NinetyPercentCriterionreached)\n");
            cohortcreator.write("rm(list= 'Entry', 'SeventyPercentCriterionreached', 'EightyPercentCriterionreached', 'NinetyPercentCriterionreached')\n");
            cohortcreator.write( "rm(cvb)\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }

    public void createTreatmentforMovementPlotPyversion(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
            cohortcreator.write(this.group + " = CreateCohort(\"" + maindirectory + lastname + "/Data/Distance moved/" + this.group + "/\")\n");
            cohortcreator.close();
        } catch (IOException py) {
            System.out.println("Could not complete");
        }
    }


    public void createTreatmentforMovement(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Data/Distance moved/" + group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");
            cohortcreator.write("Hour <- c(1:89)\n");

            cohortcreator.write("TotPathlength <- c(mean(subset(dataset$TotPathlength, dataset$Hour == 1)), ");
            for (int z = 2; z < 89; z++){
                cohortcreator.write("mean(subset(dataset$TotPathlength, dataset$Hour == " + z + ")), ");
            }
            cohortcreator.write("mean(subset(dataset$TotPathlength, dataset$Hour == 89)))\n");

            cohortcreator.write("dataset2 <- data.frame(\"" + this.group + "\", Hour, TotPathlength)\n");
            cohortcreator.write(this.group + " <- dataset2\n");
            cohortcreator.write("rm(dataset)\n");
            cohortcreator.write("rm(dataset2)\n");
            cohortcreator.write("rm(Distancemoved)\n");
            cohortcreator.write("rm(Hour)\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }

    public void createTreatmentforMovementSpreadsheet(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Data/Distance moved/" + this.group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");
            cohortcreator.write(this.group + " <- dataset\n");
            cohortcreator.write("write.csv(" + this.group + ", file=\"" + maindirectory + lastname + "/Spreadsheets/" + this.group + "DistanceMovedresults.csv\")\n");
            cohortcreator.write("rm(list = ls())\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }

    public void createTreatmentforFeedingPlotPyversion(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
            cohortcreator.write(this.group + " = CreateCohort(\"" + maindirectory + lastname + "/Data/Feeding/" + this.group + "/\")\n");
            cohortcreator.close();
        } catch (IOException py) {
            System.out.println("Could not complete");
        }
    }

    public void createTreatmentforFeeding(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Data/Feeding/" + group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("Hour <- c(1:89)\n");

            cohortcreator.write("TotFeeding <- c(mean(subset(dataset$TotFeeding, dataset$Hour == 1)), ");
            for (int y = 2; y < 89; y++){
                cohortcreator.write("mean(subset(dataset$TotFeeding, dataset$Hour == " + y + ")), ");
            }
            cohortcreator.write("mean(subset(dataset$TotFeeding, dataset$Hour == 89)))\n");

            cohortcreator.write("Rewards <- c(mean(subset(dataset$Rewards, dataset$Hour == 1)), ");
            for (int zz = 2; zz < 89; zz++){
                cohortcreator.write("mean(subset(dataset$Rewards, dataset$Hour == " + zz + ")), ");
            }
            cohortcreator.write("mean(subset(dataset$Rewards, dataset$Hour == 89)))\n");

            cohortcreator.write("dataset2 <- data.frame(\"" + this.group + "\", Hour, TotFeeding, Rewards)\n");

            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");
            cohortcreator.write(this.group + " <- dataset2\n");
            cohortcreator.write("rm(dataset)\n");
            cohortcreator.write("rm(dataset2)\n");
            cohortcreator.write("rm(Hour)\n");
            cohortcreator.write("rm(TotFeeding)\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }

    public void createTreatmentforFeedingSpreadsheet(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Data/Feeding/" + this.group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");
            cohortcreator.write(this.group + " <- dataset\n");
            cohortcreator.write("write.csv(" + this.group + ", file=\"" + maindirectory + lastname + "/Spreadsheets/" + this.group + "Feedingresults.csv\")\n");
            cohortcreator.write("rm(list = ls())\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }

    public void createTreatmentforIDETC(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Data/Entries to Criterion/Initial Discrimination/" + group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");
            cohortcreator.write(this.group + " <- dataset\n");
            cohortcreator.write("write.csv(" + this.group + ", file=\"" + maindirectory + lastname + "/Spreadsheets/" + this.group + "IDETCresults.csv\")\n");
            cohortcreator.write("rm(list = ls())\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }
    public void createTreatmentforRevETC(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Data/Entries to Criterion/Reversal/" + group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");
            cohortcreator.write(this.group + " <- dataset\n");
            cohortcreator.write("write.csv(" + this.group + ", file=\"" + maindirectory + lastname + "/Spreadsheets/" + this.group + "RevETCresults.csv\")\n");
            cohortcreator.write("rm(list = ls())\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }

    public void createTreatmentforIndexPlotPyversion(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
            cohortcreator.write(this.group + " = CreateCohort(\"" + maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Cumulative/" + this.group + "/\")\n");
            cohortcreator.close();
        } catch (IOException py) {
            System.out.println("Could not complete");
        }
    }

    public void createTreatmentforIndexGraph(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Cumulative/" + group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("Hour <- c(1:89)\n");

            cohortcreator.write("CumulativeIndex <- c(mean(subset(dataset$CumulativeIndex, dataset$Hour == 1)), ");
            for (int y = 2; y < 89; y++){
                cohortcreator.write("mean(subset(dataset$CumulativeIndex, dataset$Hour == " + y + ")), ");
            }
            cohortcreator.write("mean(subset(dataset$CumulativeIndex, dataset$Hour == 89)))\n");

            cohortcreator.write("IndependentIndex <- c(mean(subset(dataset$IndependentIndex, dataset$Hour == 1)), ");
            for (int zz = 2; zz < 89; zz++){
                cohortcreator.write("mean(subset(dataset$IndependentIndex, dataset$Hour == " + zz + ")), ");
            }
            cohortcreator.write("mean(subset(dataset$IndependentIndex, dataset$Hour == 89)))\n");

            cohortcreator.write("dataset2 <- data.frame(\"" + this.group + "\", Hour, CumulativeIndex, IndependentIndex)\n");

            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");
            cohortcreator.write(this.group + " <- dataset2\n");
            cohortcreator.write("rm(dataset)\n");
            cohortcreator.write("rm(dataset2)\n");
            cohortcreator.write("rm(Hour)\n");
            cohortcreator.write("rm(CumulativeIndex)\n");
            cohortcreator.write("rm(IndependentIndex)\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }


    public void createTreatmentforCumulativeIndex(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "TreatmentIndexer.py", true));
            cohortcreator.write("import pandas as pd\n");
            cohortcreator.write("import numpy as np\n");
            cohortcreator.write("import os\n");
            cohortcreator.write("\n");
            cohortcreator.write("def CohortIndex(location):\n");
            cohortcreator.write("\tos.chdir(location)\n");
            cohortcreator.write("\tanimals = os.listdir()\n");
            cohortcreator.write("\tdataset = None\n");
            cohortcreator.write("\tfor i in animals:\n");
            cohortcreator.write("\t\tif dataset is not None:\n");
            cohortcreator.write("\t\t\ttemp = pd.read_csv(i)\n");
            cohortcreator.write("\t\t\tdataset = pd.concat([dataset, temp], axis=0)\n");
            cohortcreator.write("\t\tif dataset is None:\n");
            cohortcreator.write("\t\t\tdataset = pd.read_csv(i)\n");
            cohortcreator.write("\treturn dataset\n");
            cohortcreator.write("\n");
            cohortcreator.write("data = CohortIndex(\"" + maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Cumulative/" + this.group + "/\")\n");
            cohortcreator.write("data.to_csv(\"" + maindirectory + lastname + "/Spreadsheets/" + this.group + "cumulativeIndexResults.csv\")\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }

    public void createTreatmentforIndependentIndex(String maindirectory, String lastname, String Rscriptdirectory){
        try {
            BufferedWriter cohortcreator = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
            cohortcreator.write("setwd(\"" + maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Independent/" + this.group + "/\")\n");

            cohortcreator.write("file_list <- list.files()\n");

            cohortcreator.write("for (i in file_list){\n");
            cohortcreator.write("  # if the merged dataset does exist, append to it\n");
            cohortcreator.write("  if (exists(\"dataset\")){\n");
            cohortcreator.write("    temp_dataset1 <- read.csv(i)\n");
            cohortcreator.write("    dataset <- rbind(dataset, temp_dataset1)\n");
            cohortcreator.write("    rm(temp_dataset1)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("  # if the merged dataset doesn't exist, create it\n");
            cohortcreator.write("  if (!exists(\"dataset\")){\n");
            cohortcreator.write("    dataset <- read.csv(i)\n");
            cohortcreator.write("  }\n");

            cohortcreator.write("}\n");
            cohortcreator.write("rm(i)\n");
            cohortcreator.write("rm(file_list)\n");
            cohortcreator.write(this.group + " <- dataset\n");
            cohortcreator.write("write.csv(" + this.group + ", file=\"" + maindirectory + lastname + "/Spreadsheets/" + this.group + "CumulativeIndexresults.csv\")\n");
            cohortcreator.write("rm(list = ls())\n");
            cohortcreator.write("\n");
            cohortcreator.close();

        } catch (IOException cohortgrapher) {
            System.out.println("Error");
        }
    }


}
