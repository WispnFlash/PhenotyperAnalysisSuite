import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Mouse {
    public String status = "incomplete";
    public String AnimalID;
    private String eartag;
    public String treatment;
    private String filestring;
    private int InitialEntriestoCriterion;
    private int ReversalEntriestoCriterion;
    private double preweight;
    private double postweight;
    public String rangeStart = "1";
    public String rangeEnd ="89";
    public String rangeInterval = "1";
    public String timetype = "hours";
    public String xticks = "0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90";
    public String yticks = "0, 5000, 10000, 15000, 20000, 25000";

    public Mouse(){

    }

    public Mouse(String AnimalID){
        this.AnimalID = AnimalID;
    }

    public Mouse(String AnimalID, String treatment) {
        this.AnimalID = AnimalID;
        this.treatment = treatment;
    }

    public void setPreweight(double preweight) {
        this.preweight = preweight;
    }

    public void setPostweight(double postweight) {
        this.postweight = postweight;
    }
    public void ImportMouse(String filestring, int linenumber, String lastname, String maindirectory, String Rscriptdirectory){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Rscriptdirectory + lastname + this.AnimalID + ".r", true));

            writer.write("rm(list=ls())\n");
            writer.write("gc()\n");
            writer.write("valueframe <- read.delim(\"" + filestring + "\", header = TRUE,  row.names = NULL, encoding = \"ANSI\", sep = \";\", dec = \".\", skipNul = TRUE, comment.char= \"\",  na.strings = c(\"-\", \"cm\", \"cm/s\", \"s\"), skip=" + linenumber + ")\n");
            writer.write(this.AnimalID + " <- valueframe[-1,] \n");
            writer.write("saveRDS(" + this.AnimalID + ", file = \"" + maindirectory + lastname + "/Data/RDS files/" + this.AnimalID + ".rds\")\n");
            writer.write("rm(list = ls())\n");
            writer.write("gc()\n");
            writer.write("\n");
            writer.close();
            String newRDS = maindirectory + lastname + "/Data/RDS files/" + this.AnimalID + ".csv";
            this.MouseAddToInitial(newRDS, lastname, maindirectory, Rscriptdirectory);
            this.MouseAddtoReversal(newRDS, lastname, maindirectory, Rscriptdirectory);
            this.MousecalculateDistancemoved(newRDS, lastname, maindirectory, Rscriptdirectory);
            this.MousecalculateFeeding(newRDS, lastname, maindirectory, Rscriptdirectory);
        } catch (IOException e) {
            System.out.println("File input/output error during Import process!");
        }
    }

    public void MouseAddToInitial(String newRDS, String lastname, String maindirectory, String Rscriptdirectory){
        try {
            String group = this.treatment;
            BufferedWriter IDwriter = new BufferedWriter(new FileWriter(Rscriptdirectory + lastname +   this.AnimalID + ".r", true));
            IDwriter.write( this.AnimalID + " <- read.csv(\"" + newRDS + "\")\n");

            IDwriter.write( this.AnimalID + "entries <-data.frame(" + this.AnimalID + "$Recording.time, " + this.AnimalID + "$Include..Left.Entrance.D1, " + this.AnimalID + "$Include..Mid.Entrance.D1, " + this.AnimalID + "$Include..Right.Entrance.D1, " + this.AnimalID + "$Include..Left.Entrance.D2, " + this.AnimalID + "$Include..Mid.Entrance.D2, " + this.AnimalID + "$Include..Right.Entrance.D2, " + this.AnimalID + "$Include..Left.Entrance.Rev.D1, " + this.AnimalID + "$Include..Mid.Entrance.Rev.D1, " + this.AnimalID + "$Include..Right.Entrance.Rev.D1, " + this.AnimalID + "$Include..Left.Entrance.Rev.D2, " + this.AnimalID + "$Include..Mid.Entrance.Rev.D2, " + this.AnimalID + "$Include..Right.Entrance.Rev.D2)\n");
            IDwriter.write( this.AnimalID + "entriesedited <-" + this.AnimalID + "entries[" + this.AnimalID + "$Include..Left.Entrance.D1 == 1 | " + this.AnimalID + "$Include..Mid.Entrance.D1 == 1 | " + this.AnimalID + "$Include..Right.Entrance.D1 == 1 | " + this.AnimalID + "$Include..Left.Entrance.D2 == 1 | " + this.AnimalID + "$Include..Mid.Entrance.D2 == 1 | " + this.AnimalID + "$Include..Right.Entrance.D2 == 1 | " + this.AnimalID + "$Include..Left.Entrance.Rev.D1 == 1 | " + this.AnimalID + "$Include..Mid.Entrance.Rev.D1 == 1 | " + this.AnimalID + "$Include..Right.Entrance.Rev.D1 == 1 | " + this.AnimalID + "$Include..Left.Entrance.Rev.D2 == 1 | " + this.AnimalID + "$Include..Mid.Entrance.Rev.D2 == 1 | " + this.AnimalID + "$Include..Right.Entrance.Rev.D2, ]\n");

            IDwriter.write( this.AnimalID + "Day1entries <-data.frame(" + this.AnimalID + "entriesedited$" + this.AnimalID + ".Recording.time, " + this.AnimalID + "entriesedited$" + this.AnimalID + ".Include..Left.Entrance.D1)\n");
            IDwriter.write( "names(" + this.AnimalID + "Day1entries)[1] <- \"Time\"\n");
            IDwriter.write( "names(" + this.AnimalID + "Day1entries)[2] <- \"Correct Entries\"\n");
            IDwriter.write( this.AnimalID + "Day1entriesedited <-" + this.AnimalID + "Day1entries[" + this.AnimalID + "Day1entries$Time < 86400, ]\n");

            IDwriter.write( this.AnimalID + "Day2entries <-data.frame(" + this.AnimalID + "entriesedited$" + this.AnimalID + ".Recording.time, " + this.AnimalID + "entriesedited$" + this.AnimalID + ".Include..Left.Entrance.D2)\n");
            IDwriter.write( "names(" + this.AnimalID + "Day2entries)[1] <- \"Time\"\n");
            IDwriter.write( "names(" + this.AnimalID + "Day2entries)[2] <- \"Correct Entries\"\n");
            IDwriter.write( this.AnimalID + "Day2entriesedited <-" + this.AnimalID + "Day2entries[" + this.AnimalID + "Day2entries$Time > 86400 & " + this.AnimalID + "Day2entries$Time < 172800, ]\n");

            IDwriter.write( this.AnimalID + "InitialDiscrimination <-rbind(" + this.AnimalID + "Day1entriesedited, " + this.AnimalID + "Day2entriesedited)\n");
            IDwriter.write( "rm(" + this.AnimalID + "entries)\n");
            IDwriter.write( "rm(" + this.AnimalID + "entriesedited)\n");
            IDwriter.write( "rm(" + this.AnimalID + "Day1entries)\n");
            IDwriter.write( "rm(" + this.AnimalID + "Day2entries)\n");
            IDwriter.write( "rm(" + this.AnimalID + "Day1entriesedited)\n");
            IDwriter.write( "rm(" + this.AnimalID + "Day2entriesedited)\n");
            IDwriter.write( "x <-" + this.AnimalID + "InitialDiscrimination\n");

            IDwriter.write( "library(zoo)\n");

            IDwriter.write( "FunZoo = function(x)\n");
            IDwriter.write( "{\n");
            IDwriter.write( "Bins = list()\n");
            IDwriter.write( "Bins = zoo(x)\n");
            IDwriter.write( "Bins = rollapply(Bins, width = 30, by = 1, FUN = mean, align = \"left\")\n");
            IDwriter.write( "Bins = as.data.frame(Bins)\n");
            IDwriter.write( "}\n");

            IDwriter.write( "x$Criterion = c(rep(0, 29), FunZoo(x$`Correct Entries`)$Bins)\n");
            IDwriter.write( "n <- nrow(x)\n");
            IDwriter.write( "x$AnimalNumber <- c(rep(\"" + this.AnimalID + "\", each=n))\n");
            IDwriter.write( "x$Treatment <- c(rep(\"" + group + "\", each=n))\n");
            IDwriter.write( this.AnimalID + "InitialDiscriminationresults <- x\n");

            IDwriter.write( "rm(" + this.AnimalID + "InitialDiscrimination)\n");


            IDwriter.write( "n <- nrow(" + this.AnimalID + "InitialDiscriminationresults)\n");
            IDwriter.write( this.AnimalID + "InitialDiscriminationresults$EntryNumber <- 1:n\n");

            IDwriter.write( "IsSeventyThere <- 0.7 %in% " + this.AnimalID + "InitialDiscriminationresults$Criterion\n");
            IDwriter.write( "if (IsSeventyThere == TRUE) {\n");
            IDwriter.write( "EntriestoSeventyVector <- c(which(" + this.AnimalID + "InitialDiscriminationresults$Criterion == 0.7, arr.ind = TRUE))\n");
            IDwriter.write( "    EntriestoSeventy <- EntriestoSeventyVector[1]\n");
            IDwriter.write( "    EntriesBeforeSeventy <- EntriestoSeventy - 1\n");
            IDwriter.write( "    EntriesBeforeSeventyVector <- c(rep(0, each = EntriesBeforeSeventy))\n");
            IDwriter.write( "    EntriesfromSeventyVector <- c(rep(1, each = n - EntriestoSeventy + 1))\n");
            IDwriter.write( "    BeforeAndAfterSeventyVector <- c(EntriesBeforeSeventyVector, EntriesfromSeventyVector)\n");
            IDwriter.write( "    " + this.AnimalID + "InitialDiscriminationresults$SeventyQualifier <- BeforeAndAfterSeventyVector\n");
            IDwriter.write("HourstoSeventy <- " + this.AnimalID + "InitialDiscriminationresults$Time[EntriestoSeventy] / 3600\n");
            IDwriter.write("rm(list = 'EntriesBeforeSeventy', 'EntriesBeforeSeventyVector', 'EntriesfromSeventyVector', 'BeforeAndAfterSeventyVector')\n");
            IDwriter.write("} else {\n");
            IDwriter.write("EntriestoSeventy <- 6000\n");
            IDwriter.write("HourstoSeventy <- 48\n");
            IDwriter.write(this.AnimalID + "InitialDiscriminationresults$SeventyQualifier <- c(rep(0, each = n))\n");
            IDwriter.write("}\n");
            IDwriter.write("rm(IsSeventyThere)\n");

            IDwriter.write( "IsEightyThere <- 0.8 %in% " + this.AnimalID + "InitialDiscriminationresults$Criterion\n");
            IDwriter.write( "if (IsEightyThere == TRUE) {\n");
            IDwriter.write( "EntriestoEightyVector <- c(which(" + this.AnimalID + "InitialDiscriminationresults$Criterion == 0.8, arr.ind = TRUE))\n");
            IDwriter.write( "    EntriestoEighty <- EntriestoEightyVector[1]\n");
            IDwriter.write( "    EntriesBeforeEighty <- EntriestoEighty - 1\n");
            IDwriter.write( "    EntriesBeforeEightyVector <- c(rep(0, each = EntriesBeforeEighty))\n");
            IDwriter.write( "    EntriesfromEightyVector <- c(rep(1, each = n - EntriestoEighty + 1))\n");
            IDwriter.write( "    BeforeAndAfterEightyVector <- c(EntriesBeforeEightyVector, EntriesfromEightyVector)\n");
            IDwriter.write( "    " + this.AnimalID + "InitialDiscriminationresults$EightyQualifier <- BeforeAndAfterEightyVector\n");
            IDwriter.write("HourstoEighty <- " + this.AnimalID + "InitialDiscriminationresults$Time[EntriestoEighty] / 3600\n");
            IDwriter.write("rm(list = 'EntriesBeforeEighty', 'EntriesBeforeEightyVector', 'EntriesfromEightyVector', 'BeforeAndAfterEightyVector')\n");
            IDwriter.write("} else {\n");
            IDwriter.write("EntriestoEighty <- 6000\n");
            IDwriter.write("HourstoEighty <- 48\n");
            IDwriter.write(this.AnimalID + "InitialDiscriminationresults$EightyQualifier <- c(rep(0, each = n))\n");
            IDwriter.write("}\n");
            IDwriter.write("rm(IsEightyThere)\n");

            IDwriter.write( "IsNinetyThere <- 0.9 %in% " + this.AnimalID + "InitialDiscriminationresults$Criterion\n");
            IDwriter.write( "if (IsNinetyThere == TRUE) {\n");
            IDwriter.write( "EntriestoNinetyVector <- c(which(" + this.AnimalID + "InitialDiscriminationresults$Criterion == 0.9, arr.ind = TRUE))\n");
            IDwriter.write( "    EntriestoNinety <- EntriestoNinetyVector[1]\n");
            IDwriter.write( "    EntriesBeforeNinety <- EntriestoNinety - 1\n");
            IDwriter.write( "    EntriesBeforeNinetyVector <- c(rep(0, each = EntriesBeforeNinety))\n");
            IDwriter.write( "    EntriesfromNinetyVector <- c(rep(1, each = n - EntriestoNinety + 1))\n");
            IDwriter.write( "    BeforeAndAfterNinetyVector <- c(EntriesBeforeNinetyVector, EntriesfromNinetyVector)\n");
            IDwriter.write( "    " + this.AnimalID + "InitialDiscriminationresults$NinetyQualifier <- BeforeAndAfterNinetyVector\n");
            IDwriter.write("HourstoNinety <- " + this.AnimalID + "InitialDiscriminationresults$Time[EntriestoNinety] / 3600\n");
            IDwriter.write("rm(list = 'EntriesBeforeNinety', 'EntriesBeforeNinetyVector', 'EntriesfromNinetyVector', 'BeforeAndAfterNinetyVector')\n");
            IDwriter.write("} else {\n");
            IDwriter.write("EntriestoNinety <- 6000\n");
            IDwriter.write("HourstoNinety <- 48\n");
            IDwriter.write(this.AnimalID + "InitialDiscriminationresults$NinetyQualifier <- c(rep(0, each = n))\n");
            IDwriter.write("}\n");
            IDwriter.write("rm(IsNinetyThere)\n");

            IDwriter.write(this.AnimalID + "IDETCresults <- data.frame(\"" + this.AnimalID + "\", \"" + this.treatment + "\", EntriestoSeventy, EntriestoEighty, EntriestoNinety, HourstoSeventy, HourstoEighty, HourstoNinety)\n");
            IDwriter.write("names(" + this.AnimalID + "IDETCresults)[1] <- \"AnimalID\"\n");
            IDwriter.write("names(" + this.AnimalID + "IDETCresults)[2] <- \"Treatment\"\n");
            IDwriter.write("saveRDS(" + this.AnimalID + "IDETCresults, file=\"" + maindirectory + lastname + "/Data/Entries to Criterion/Initial Discrimination/" + this.treatment + "/" + this.AnimalID + "IDETCresults.rds\")\n");
            IDwriter.write("rm('EntriestoSeventy', 'EntriestoEighty', 'EntriestoNinety', 'HourstoSeventy', 'HourstoEighty', 'HourstoNinety')\n");

            IDwriter.write( "o <- n + 1\n");
            IDwriter.write( "p <- 6000 - n\n");

            IDwriter.write( "a <- c(rep(" + this.AnimalID + "InitialDiscriminationresults$Time[n], each = p))\n");
            IDwriter.write( "b <- c(rep(1, each = p))\n");
            IDwriter.write( "c <- c(rep(" + this.AnimalID + "InitialDiscriminationresults$Criterion[n], each = p))\n");
            IDwriter.write( "d <- c(rep(\"" + this.AnimalID + "\", each = p))\n");
            IDwriter.write( "e <- c(rep(\"" + this.treatment + "\", each = p))\n");
            IDwriter.write( "f <- c(o:6000)\n");
            IDwriter.write( "go <- c(rep(" + this.AnimalID + "InitialDiscriminationresults$SeventyQualifier[n], each = p))\n");
            IDwriter.write( "g <- c(rep(" + this.AnimalID + "InitialDiscriminationresults$EightyQualifier[n], each = p))\n");
            IDwriter.write( "h <- c(rep(" + this.AnimalID + "InitialDiscriminationresults$NinetyQualifier[n], each = p))\n");

            IDwriter.write( "remainingresults <- data.frame(a, b, c, d, e, f, go, g, h)\n");

            IDwriter.write( "names(remainingresults)[1] <- \"Time\"\n");
            IDwriter.write( "names(remainingresults)[2] <- \"Correct Entries\"\n");
            IDwriter.write( "names(remainingresults)[3] <- \"Criterion\"\n");
            IDwriter.write( "names(remainingresults)[4] <- \"AnimalNumber\"\n");
            IDwriter.write( "names(remainingresults)[5] <- \"Treatment\"\n");
            IDwriter.write( "names(remainingresults)[6] <- \"EntryNumber\"\n");
            IDwriter.write( "names(remainingresults)[7] <- \"SeventyQualifier\"\n");
            IDwriter.write( "names(remainingresults)[8] <- \"EightyQualifier\"\n");
            IDwriter.write( "names(remainingresults)[9] <- \"NinetyQualifier\"\n");
            IDwriter.write( this.AnimalID + "IDtotalresults <- rbind(" + this.AnimalID + "InitialDiscriminationresults, remainingresults)\n");
            IDwriter.write("saveRDS(" + this.AnimalID + "IDtotalresults, file=\"" + maindirectory + lastname + "/Data/Initial Discrimination/" + this.treatment + "/" + this.AnimalID + "IDtotalresults.rds\")\n");
            IDwriter.write("rm(list = ls())\n");
            IDwriter.write("gc()\n");
            IDwriter.write( " \n");
            IDwriter.close();


        } catch (IOException g) {
            System.out.println("File input/output error during Initial Discrimination process");
        }
    }

    public void MouseAddtoReversal(String newRDS, String lastname, String maindirectory, String Rscriptdirectory){
        try {
            BufferedWriter RevSurvivalwriter = new BufferedWriter(new FileWriter(Rscriptdirectory + lastname + this.AnimalID + ".r", true));
            RevSurvivalwriter.write(this.AnimalID + " <- read.csv(\"" + newRDS + "\")\n");

            RevSurvivalwriter.write( this.AnimalID + "entries <- data.frame(" + this.AnimalID + "$Recording.time, " + this.AnimalID + "$Include..Left.Entrance.D1, " + this.AnimalID + "$Include..Mid.Entrance.D1, " + this.AnimalID + "$Include..Right.Entrance.D1, " + this.AnimalID + "$Include..Left.Entrance.D2, " + this.AnimalID + "$Include..Mid.Entrance.D2, " + this.AnimalID + "$Include..Right.Entrance.D2, " + this.AnimalID + "$Include..Left.Entrance.Rev.D1, " + this.AnimalID + "$Include..Mid.Entrance.Rev.D1, " + this.AnimalID + "$Include..Right.Entrance.Rev.D1, " + this.AnimalID + "$Include..Left.Entrance.Rev.D2, " + this.AnimalID + "$Include..Mid.Entrance.Rev.D2, " + this.AnimalID + "$Include..Right.Entrance.Rev.D2)\n" );
            RevSurvivalwriter.write( this.AnimalID + "entriesedited <-" + this.AnimalID + "entries[" + this.AnimalID + "$Include..Left.Entrance.D1 == 1 | " + this.AnimalID + "$Include..Mid.Entrance.D1 == 1 | " + this.AnimalID + "$Include..Right.Entrance.D1 == 1 | " + this.AnimalID + "$Include..Left.Entrance.D2 == 1 | " + this.AnimalID + "$Include..Mid.Entrance.D2 == 1 | " + this.AnimalID + "$Include..Right.Entrance.D2 == 1 | " + this.AnimalID + "$Include..Left.Entrance.Rev.D1 == 1 | " + this.AnimalID + "$Include..Mid.Entrance.Rev.D1 == 1 | " + this.AnimalID + "$Include..Right.Entrance.Rev.D1 == 1 | " + this.AnimalID + "$Include..Left.Entrance.Rev.D2 == 1 | " + this.AnimalID + "$Include..Mid.Entrance.Rev.D2 == 1 | " + this.AnimalID + "$Include..Right.Entrance.Rev.D2, ]\n" );

            RevSurvivalwriter.write( this.AnimalID + "Day3entries <- data.frame(" + this.AnimalID + "entriesedited$" + this.AnimalID + ".Recording.time, " + this.AnimalID + "entriesedited$" + this.AnimalID + ".Include..Right.Entrance.Rev.D1)\n" );
            RevSurvivalwriter.write("names(" + this.AnimalID + "Day3entries)[1] <- \"Time\"\n" );
            RevSurvivalwriter.write("names(" + this.AnimalID + "Day3entries)[2] <- \"Correct Entries\"\n" );
            RevSurvivalwriter.write( this.AnimalID + "Day3entriesedited <- " + this.AnimalID + "Day3entries[" + this.AnimalID + "Day3entries$Time > 172800 & " + this.AnimalID + "Day3entries$Time < 259200, ]\n" );

            RevSurvivalwriter.write( this.AnimalID + "Day4entries <- data.frame(" + this.AnimalID + "entriesedited$" + this.AnimalID + ".Recording.time, " + this.AnimalID + "entriesedited$" + this.AnimalID + ".Include..Right.Entrance.Rev.D2)\n" );
            RevSurvivalwriter.write("names(" + this.AnimalID + "Day4entries)[1] <- \"Time\"\n" );
            RevSurvivalwriter.write("names(" + this.AnimalID + "Day4entries)[2] <- \"Correct Entries\"\n" );
            RevSurvivalwriter.write( this.AnimalID + "Day4entriesedited <- " + this.AnimalID + "Day4entries[" + this.AnimalID + "Day4entries$Time > 259200 & " + this.AnimalID + "Day4entries$Time < 345600, ]\n" );

            RevSurvivalwriter.write( this.AnimalID + "Reversal <-rbind(" + this.AnimalID + "Day3entriesedited, " + this.AnimalID + "Day4entriesedited)\n" );
            RevSurvivalwriter.write("rm(" + this.AnimalID + ")\n" );
            RevSurvivalwriter.write("rm(" + this.AnimalID + "entries)\n" );
            RevSurvivalwriter.write("rm(" + this.AnimalID + "entriesedited)\n" );
            RevSurvivalwriter.write("rm(" + this.AnimalID + "Day3entries)\n" );
            RevSurvivalwriter.write("rm(" + this.AnimalID + "Day4entries)\n" );
            RevSurvivalwriter.write("rm(" + this.AnimalID + "Day3entriesedited)\n" );
            RevSurvivalwriter.write("rm(" + this.AnimalID + "Day4entriesedited)\n" );
            RevSurvivalwriter.write("x <-" + this.AnimalID + "Reversal\n" );

            RevSurvivalwriter.write("library(zoo)\n" );
            RevSurvivalwriter.write("FunZoo = function(x)\n" );
            RevSurvivalwriter.write("{\n" );
            RevSurvivalwriter.write("Bins = list()\n" );
            RevSurvivalwriter.write("Bins = zoo(x)\n" );
            RevSurvivalwriter.write("Bins = rollapply(Bins, width = 30, by = 1, FUN = mean, align = \"left\")\n" );
            RevSurvivalwriter.write("Bins = as.data.frame(Bins)\n" );
            RevSurvivalwriter.write("}\n" );

            RevSurvivalwriter.write("x$Criterion = c(rep(0, 29), FunZoo(x$`Correct Entries`)$Bins)\n" );
            RevSurvivalwriter.write("n <- nrow(x)\n" );
            RevSurvivalwriter.write("x$AnimalNumber <- c(rep(\"" + this.AnimalID + "\", each=n))\n" );
            RevSurvivalwriter.write("x$Treatment <- c(rep(\"" + this.treatment +  "\", each=n))\n" );
            RevSurvivalwriter.write( this.AnimalID + "Reversalresults <- x\n" );
            RevSurvivalwriter.write("rm(x)\n" );

            RevSurvivalwriter.write("rm(FunZoo)\n" );
            RevSurvivalwriter.write("rm(" + this.AnimalID + "Reversal)\n" );


            RevSurvivalwriter.write("n <- nrow(" + this.AnimalID + "Reversalresults)\n" );
            RevSurvivalwriter.write( this.AnimalID + "Reversalresults$EntryNumber <- 1:n\n" );

            RevSurvivalwriter.write( "IsSeventyThere <- 0.7 %in% " + this.AnimalID + "Reversalresults$Criterion\n");
            RevSurvivalwriter.write( "if (IsSeventyThere == TRUE) {\n");
            RevSurvivalwriter.write( "EntriestoSeventyVector <- c(which(" + this.AnimalID + "Reversalresults$Criterion == 0.7, arr.ind = TRUE))\n");
            RevSurvivalwriter.write( "    EntriestoSeventy <- EntriestoSeventyVector[1]\n");
            RevSurvivalwriter.write( "    EntriesBeforeSeventy <- EntriestoSeventy - 1\n");
            RevSurvivalwriter.write( "    EntriesBeforeSeventyVector <- c(rep(0, each = EntriesBeforeSeventy))\n");
            RevSurvivalwriter.write( "    EntriesfromSeventyVector <- c(rep(1, each = n - EntriestoSeventy + 1))\n");
            RevSurvivalwriter.write( "    BeforeAndAfterSeventyVector <- c(EntriesBeforeSeventyVector, EntriesfromSeventyVector)\n");
            RevSurvivalwriter.write( "    " + this.AnimalID + "Reversalresults$SeventyQualifier <- BeforeAndAfterSeventyVector\n");
            RevSurvivalwriter.write("HourstoSeventy <- " + this.AnimalID + "Reversalresults$Time[EntriestoSeventy] / 3600 - 48\n");
            RevSurvivalwriter.write("rm(list = 'EntriesBeforeSeventy', 'EntriesBeforeSeventyVector', 'EntriesfromSeventyVector', 'BeforeAndAfterSeventyVector')\n");
            RevSurvivalwriter.write("} else {\n");
            RevSurvivalwriter.write("EntriestoSeventy <- 7000\n");
            RevSurvivalwriter.write("HourstoSeventy <- 48\n");
            RevSurvivalwriter.write(this.AnimalID + "Reversalresults$SeventyQualifier <- c(rep(0, each = n))\n");
            RevSurvivalwriter.write("}\n");
            RevSurvivalwriter.write("rm(IsSeventyThere)\n");

            RevSurvivalwriter.write( "IsEightyThere <- 0.8 %in% " + this.AnimalID + "Reversalresults$Criterion\n");
            RevSurvivalwriter.write( "if (IsEightyThere == TRUE) {\n");
            RevSurvivalwriter.write( "EntriestoEightyVector <- c(which(" + this.AnimalID + "Reversalresults$Criterion == 0.8, arr.ind = TRUE))\n");
            RevSurvivalwriter.write( "    EntriestoEighty <- EntriestoEightyVector[1]\n");
            RevSurvivalwriter.write( "    EntriesBeforeEighty <- EntriestoEighty - 1\n");
            RevSurvivalwriter.write( "    EntriesBeforeEightyVector <- c(rep(0, each = EntriesBeforeEighty))\n");
            RevSurvivalwriter.write( "    EntriesfromEightyVector <- c(rep(1, each = n - EntriestoEighty + 1))\n");
            RevSurvivalwriter.write( "    BeforeAndAfterEightyVector <- c(EntriesBeforeEightyVector, EntriesfromEightyVector)\n");
            RevSurvivalwriter.write( "    " + this.AnimalID + "Reversalresults$EightyQualifier <- BeforeAndAfterEightyVector\n");
            RevSurvivalwriter.write("HourstoEighty <- " + this.AnimalID + "Reversalresults$Time[EntriestoEighty] / 3600 - 48\n");
            RevSurvivalwriter.write("rm(list = 'EntriesBeforeEighty', 'EntriesBeforeEightyVector', 'EntriesfromEightyVector', 'BeforeAndAfterEightyVector')\n");
            RevSurvivalwriter.write("} else {\n");
            RevSurvivalwriter.write("EntriestoEighty <- 7000\n");
            RevSurvivalwriter.write("HourstoEighty <- 48\n");
            RevSurvivalwriter.write(this.AnimalID + "Reversalresults$EightyQualifier <- c(rep(0, each = n))\n");
            RevSurvivalwriter.write("}\n");
            RevSurvivalwriter.write("rm(IsEightyThere)\n");

            RevSurvivalwriter.write( "IsNinetyThere <- 0.9 %in% " + this.AnimalID + "Reversalresults$Criterion\n");
            RevSurvivalwriter.write( "if (IsNinetyThere == TRUE) {\n");
            RevSurvivalwriter.write( "EntriestoNinetyVector <- c(which(" + this.AnimalID + "Reversalresults$Criterion == 0.9, arr.ind = TRUE))\n");
            RevSurvivalwriter.write( "    EntriestoNinety <- EntriestoNinetyVector[1]\n");
            RevSurvivalwriter.write( "    EntriesBeforeNinety <- EntriestoNinety - 1\n");
            RevSurvivalwriter.write( "    EntriesBeforeNinetyVector <- c(rep(0, each = EntriesBeforeNinety))\n");
            RevSurvivalwriter.write( "    EntriesfromNinetyVector <- c(rep(1, each = n - EntriestoNinety + 1))\n");
            RevSurvivalwriter.write( "    BeforeAndAfterNinetyVector <- c(EntriesBeforeNinetyVector, EntriesfromNinetyVector)\n");
            RevSurvivalwriter.write( "    " + this.AnimalID + "Reversalresults$NinetyQualifier <- BeforeAndAfterNinetyVector\n");
            RevSurvivalwriter.write("HourstoNinety <- " + this.AnimalID + "Reversalresults$Time[EntriestoNinety] / 3600 - 48\n");
            RevSurvivalwriter.write("rm(list = 'EntriesBeforeNinety', 'EntriesBeforeNinetyVector', 'EntriesfromNinetyVector', 'BeforeAndAfterNinetyVector')\n");
            RevSurvivalwriter.write("} else {\n");
            RevSurvivalwriter.write("EntriestoNinety <- 7000\n");
            RevSurvivalwriter.write("HourstoNinety <- 48\n");
            RevSurvivalwriter.write(this.AnimalID + "Reversalresults$NinetyQualifier <- c(rep(0, each = n))\n");
            RevSurvivalwriter.write("}\n");
            RevSurvivalwriter.write("rm(IsNinetyThere)\n");

            RevSurvivalwriter.write(this.AnimalID + "RevETCresults <- data.frame(\"" + this.AnimalID + "\", \"" + this.treatment + "\", EntriestoSeventy, EntriestoEighty, EntriestoNinety, HourstoSeventy, HourstoEighty, HourstoNinety)\n");
            RevSurvivalwriter.write("names(" + this.AnimalID + "RevETCresults)[1] <- \"AnimalID\"\n");
            RevSurvivalwriter.write("names(" + this.AnimalID + "RevETCresults)[2] <- \"Treatment\"\n");
            RevSurvivalwriter.write("saveRDS(" + this.AnimalID + "RevETCresults, file=\"" + maindirectory + lastname + "/Data/Entries to Criterion/Reversal/" + this.treatment  + "/" + this.AnimalID + "RevETCresults.rds\")\n");
            RevSurvivalwriter.write("rm('EntriestoSeventy', 'EntriestoEighty', 'EntriestoNinety', 'HourstoSeventy', 'HourstoEighty', 'HourstoNinety')\n");

            RevSurvivalwriter.write( "o <- n + 1\n");
            RevSurvivalwriter.write( "p <- 6000 - n\n");

            RevSurvivalwriter.write( "a <- c(rep(" + this.AnimalID + "Reversalresults$Time[n], each = p))\n");
            RevSurvivalwriter.write( "b <- c(rep(1, each = p))\n");
            RevSurvivalwriter.write( "c <- c(rep(" + this.AnimalID + "Reversalresults$Criterion[n], each = p))\n");
            RevSurvivalwriter.write( "d <- c(rep(\"" + this.AnimalID + "\", each = p))\n");
            RevSurvivalwriter.write( "e <- c(rep(\"" + this.treatment + "\", each = p))\n");
            RevSurvivalwriter.write( "f <- c(o:6000)\n");
            RevSurvivalwriter.write( "go <- c(rep(" + this.AnimalID + "Reversalresults$SeventyQualifier[n], each = p))\n");
            RevSurvivalwriter.write( "g <- c(rep(" + this.AnimalID + "Reversalresults$EightyQualifier[n], each = p))\n");
            RevSurvivalwriter.write( "h <- c(rep(" + this.AnimalID + "Reversalresults$NinetyQualifier[n], each = p))\n");
            RevSurvivalwriter.write( "remainingresults <- data.frame(a, b, c, d, e, f, go, g, h)\n");

            RevSurvivalwriter.write( "names(remainingresults)[1] <- \"Time\"\n");
            RevSurvivalwriter.write( "names(remainingresults)[2] <- \"Correct Entries\"\n");
            RevSurvivalwriter.write( "names(remainingresults)[3] <- \"Criterion\"\n");
            RevSurvivalwriter.write( "names(remainingresults)[4] <- \"AnimalNumber\"\n");
            RevSurvivalwriter.write( "names(remainingresults)[5] <- \"Treatment\"\n");
            RevSurvivalwriter.write( "names(remainingresults)[6] <- \"EntryNumber\"\n");
            RevSurvivalwriter.write( "names(remainingresults)[7] <- \"SeventyQualifier\"\n");
            RevSurvivalwriter.write( "names(remainingresults)[8] <- \"EightyQualifier\"\n");
            RevSurvivalwriter.write( "names(remainingresults)[9] <- \"NinetyQualifier\"\n");

            RevSurvivalwriter.write( this.AnimalID + "Revtotalresults <- rbind(" + AnimalID + "Reversalresults, remainingresults)\n");
            RevSurvivalwriter.write("saveRDS(" + this.AnimalID + "Revtotalresults, file=\"" + maindirectory + lastname + "/Data/Reversal/" + this.treatment + "/" + this.AnimalID + "Revtotalresults.rds\")\n");
            RevSurvivalwriter.write( "rm(list = ls())\n");
            RevSurvivalwriter.write("gc()\n");
            RevSurvivalwriter.write( " \n");
            RevSurvivalwriter.close();


        } catch (IOException reversalsurvival) {
            System.out.println("File input/output error");
        }
    }

    public void MousecalculateDistancemoved(String newRDS, String lastname, String maindirectory, String Rscriptdirectory){
        try {
            BufferedWriter movementwriter = new BufferedWriter(new FileWriter(Rscriptdirectory + lastname + this.AnimalID + ".r", true));
            movementwriter.write( this.AnimalID + " <- read.csv(\"" + newRDS + "\")\n");

            movementwriter.write(this.AnimalID + "TotPathlength <- data.frame(" + this.AnimalID + "$Recording.time, " + this.AnimalID + "$Distance.moved)\n");
            movementwriter.write(this.AnimalID + "TotPathlengthedited = " + this.AnimalID + "TotPathlength[" + this.AnimalID + "TotPathlength$" + this.AnimalID + ".Distance.moved != \"NA\" & " + this.AnimalID + "TotPathlength$" + this.AnimalID + ".Distance.moved >= 0.1,]\n");
            movementwriter.write( "TotPathlength <- c(sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 3600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 3600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 7200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 7200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 10800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 10800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 14400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 14400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 18000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 18000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 21600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 21600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 25200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 25200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 28800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 28800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 32400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 32400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 36000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 36000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 39600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 39600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 43200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 43200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 46800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 46800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 50400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 50400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 54000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 54000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 57600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 57600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 61200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 61200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 64800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 64800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 68400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 68400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 72000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 72000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 75600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 75600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 79200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 79200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 82800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 82800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 86400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 86400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 90000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 90000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 93600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 93600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 97200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 97200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 100800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 100800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 104400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 104400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 108000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 108000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 111600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 111600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 115200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 115200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 118800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 118800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 122400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 122400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 126000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 126000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 129600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 129600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 133200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 133200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 136800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 136800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 140400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 140400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 144000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 144000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 147600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 147600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 151200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 151200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 154800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 154800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 158400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 158400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 162000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 162000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 165600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 165600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 169200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 169200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 172800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 172800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 176400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 176400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 180000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 180000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 183600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 183600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 187200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 187200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 190800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 190800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 194400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 194400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 198000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 198000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 201600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 201600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 205200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 205200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 208800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 208800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 212400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 212400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 216000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 216000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 219600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 219600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 223400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 223400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 226800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 226800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 230400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 230400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 234000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 234000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 237600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 237600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 241200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 241200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 244800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 244800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 248400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 248400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 252000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 252000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 255600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 255600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 259200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 259200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 262800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 262800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 266400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 266400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 270000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 270000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 273600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 273600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 277200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 277200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 280800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 280800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 284400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 284400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 288000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 288000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 291600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 291600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 295200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 295200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 298800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 298800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 302400)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 302400 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 306000)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 306000 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 309600)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 309600 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 313200)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 313200 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 316800)), sum(subset(" + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Distance.moved, " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time > 316800 & " + this.AnimalID + "TotPathlengthedited$" + this.AnimalID + ".Recording.time < 320400)))\n");
            movementwriter.write( "Hour <- c(1:89)\n");
            movementwriter.write( "AnimalNumber <- c(rep(\"" + this.AnimalID + "\", each=89))\n");
            movementwriter.write( "Treatment <- c(rep(\"" + this.treatment + "\", each=89))\n");
            movementwriter.write(this.AnimalID + "movementresults <- data.frame(AnimalNumber, Treatment, Hour, TotPathlength)\n");
            movementwriter.write("saveRDS(" + this.AnimalID + "movementresults, file=\"" + maindirectory + lastname + "/Data/Distance moved/" + this.treatment + "/" + this.AnimalID + "movementresults.rds\")\n");
            movementwriter.write( "rm(list = ls())\n");
            movementwriter.write("gc()\n");
            movementwriter.write( " \n");
            movementwriter.close();
        } catch (IOException movement){
            System.out.println("Movement IO exception");
        }
    }

    public void MousecalculateFeeding(String newRDS, String lastname, String maindirectory, String Rscriptdirectory){
        try {
            BufferedWriter feedingwriter = new BufferedWriter(new FileWriter(Rscriptdirectory + lastname + this.AnimalID + ".r", true));
            feedingwriter.write( this.AnimalID + " <- read.csv(\"" + newRDS + "\")\n");
            feedingwriter.write(this.AnimalID + "TotFeeding <- data.frame(" + this.AnimalID + "$Recording.time, " + this.AnimalID + "$Hardware.continuous)\n");
            feedingwriter.write( "TotFeeding <- c(sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 3600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 3600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 7200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 7200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 10800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 10800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 14400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 14400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 18000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 18000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 21600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 21600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 25200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 25200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 28800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 28800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 32400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 32400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 36000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 36000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 39600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 39600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 43200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 43200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 46800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 46800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 50400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 50400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 54000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 54000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 57600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 57600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 61200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 61200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 64800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 64800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 68400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 68400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 72000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 72000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 75600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 75600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 79200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 79200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 82800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 82800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 86400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 86400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 90000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 90000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 93600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 93600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 97200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 97200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 100800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 100800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 104400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 104400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 108000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 108000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 111600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 111600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 115200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 115200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 118800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 118800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 122400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 122400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 126000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 126000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 129600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 129600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 133200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 133200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 136800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 136800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 140400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 140400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 144000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 144000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 147600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 147600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 151200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 151200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 154800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 154800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 158400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 158400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 162000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 162000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 165600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 165600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 169200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 169200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 172800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 172800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 176400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 176400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 180000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 180000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 183600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 183600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 187200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 187200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 190800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 190800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 194400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 194400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 198000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 198000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 201600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 201600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 205200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 205200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 208800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 208800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 212400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 212400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 216000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 216000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 219600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 219600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 223400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 223400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 226800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 226800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 230400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 230400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 234000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 234000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 237600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 237600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 241200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 241200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 244800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 244800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 248400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 248400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 252000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 252000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 255600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 255600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 259200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 259200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 262800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 262800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 266400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 266400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 270000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 270000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 273600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 273600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 277200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 277200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 280800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 280800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 284400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 284400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 288000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 288000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 291600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 291600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 295200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 295200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 298800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 298800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 302400)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 302400 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 306000)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 306000 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 309600)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 309600 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 313200)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 313200 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 316800)), sum(subset(" + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Hardware.continuous, " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time > 316800 & " + this.AnimalID + "TotFeeding$" + this.AnimalID + ".Recording.time < 320400)))\n");
            feedingwriter.write( "Hour <- c(1:89)\n");
            feedingwriter.write( "AnimalNumber <- c(rep(\"" + this.AnimalID + "\", each=89))\n");
            feedingwriter.write( "Treatment <- c(rep(\"" + this.treatment + "\", each=89))\n");
            feedingwriter.write(this.AnimalID + "feedingresults <- data.frame(AnimalNumber, Treatment, Hour, TotFeeding)\n");
            feedingwriter.write("for (i in 1:89) {\n");
            feedingwriter.write(this.AnimalID + "feedingresults$Rewards[i] <- sum(" + this.AnimalID + "feedingresults$TotFeeding[1:i])\n");
            feedingwriter.write("}\n");
            feedingwriter.write("saveRDS(" + this.AnimalID + "feedingresults, file=\"" + maindirectory + lastname + "/Data/Feeding/" + this.treatment + "/" + this.AnimalID + "feedingresults.rds\")\n");
            feedingwriter.write( "rm(list = ls())\n");
            feedingwriter.write("gc()\n");
            feedingwriter.write( " \n");
            feedingwriter.close();
        } catch (IOException feedingexception) {
            System.out.println("Feeding IOException");
        }
    }

    public void mouseEverything(String filestring, int linenumber, String lastname, String maindirectory, String Rscriptdirectory){
        try {
            BufferedWriter pythonwriter = new BufferedWriter(new FileWriter(Rscriptdirectory + "mice/" + lastname + this.AnimalID + ".py"));
            pythonwriter.write("import numpy as np\n");
            pythonwriter.write("import pandas as pd\n");
            pythonwriter.write("import matplotlib.pyplot as plt\n");
            pythonwriter.write(" \n");

            pythonwriter.write("AnimalID = \"" + this.AnimalID + "\"\n");
            pythonwriter.write("Treatment = \"" + this.treatment + "\"\n");
            pythonwriter.write(" \n");


            pythonwriter.write("def movingwindow(ar, number, outputarray):\n");
            pythonwriter.write("    for x in range(0, number):\n");
            pythonwriter.write("        value1 = 0.0\n");
            pythonwriter.write("        value2 = 0.0\n");
            pythonwriter.write("        if (x < 29):\n");
            pythonwriter.write("            outputarray[x] = 0.0\n");
            pythonwriter.write("        if (x == 29):\n");
            pythonwriter.write("            for y in range(0, 29):\n");
            pythonwriter.write("                value1 = value1 + ar[y]\n");
            pythonwriter.write("            outputarray[x] = value1 / 30 \n");
            pythonwriter.write("        if (x > 29):\n");
            pythonwriter.write("            start = x - 29\n");
            pythonwriter.write("            end = x + 1\n");
            pythonwriter.write("            for z in range(start, end):\n");
            pythonwriter.write("                value2 = value2 + ar[z]\n");
            pythonwriter.write("            outputarray[x] = value2 / 30 \n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("def ChangedCriterion(arr, number, outputarray2):\n");
            pythonwriter.write("    value = 0\n");
            pythonwriter.write("    for element in range(0, number):\n");
            pythonwriter.write("        if ((arr[element] == 0.10) & (value <= 0.10)):\n");
            pythonwriter.write("            value = 0.10    \n");
            pythonwriter.write("        if ((arr[element] == 0.20) & (value <= 0.20)):\n");
            pythonwriter.write("            value = 0.20    \n");
            pythonwriter.write("        if ((arr[element] == 0.30) & (value <= 0.30)):\n");
            pythonwriter.write("            value = 0.30    \n");
            pythonwriter.write("        if ((arr[element] == 0.40) & (value <= 0.40)):\n");
            pythonwriter.write("            value = 0.40    \n");
            pythonwriter.write("        if ((arr[element] == 0.50) & (value <= 0.50)):\n");
            pythonwriter.write("            value = 0.50    \n");
            pythonwriter.write("        if ((arr[element] == 0.60) & (value <= 0.60)):\n");
            pythonwriter.write("            value = 0.60    \n");
            pythonwriter.write("        if ((arr[element] == 0.70) & (value <= 0.70)):\n");
            pythonwriter.write("            value = 0.70    \n");
            pythonwriter.write("        if ((arr[element] == 0.80) & (value <= 0.80)):\n");
            pythonwriter.write("            value = 0.80         \n");
            pythonwriter.write("        if ((arr[element] == 0.90) & (value <= 0.90)):\n");
            pythonwriter.write("            value = 0.90    \n")   ;
            pythonwriter.write("        if (arr[element] == 1.0):\n");
            pythonwriter.write("            value = 1.0\n");
            pythonwriter.write("        outputarray2[element] = value\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def ETCSeventyfinder(ar, ar2, number):\n");
            pythonwriter.write("    counter1 = 0\n");
            pythonwriter.write("    for member in range(0, number):\n");
            pythonwriter.write("        if ((ar[member] == 0.70) & (counter1 == 0)):\n");
            pythonwriter.write("            output1 = ar2[member]\n");
            pythonwriter.write("            counter1 = 1\n");
            pythonwriter.write("    if (counter1 == 0):\n");
            pythonwriter.write("        output1 = 6000\n");
            pythonwriter.write("    return output1\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def ETCEightyfinder(ar, ar2, number):\n");
            pythonwriter.write("    counter2 = 0\n");
            pythonwriter.write("    for member in range(0, number):\n");
            pythonwriter.write("        if ((ar[member] == 0.80) & (counter2 == 0)):\n");
            pythonwriter.write("            output2 = ar2[member]\n");
            pythonwriter.write("            counter2 = 1\n");
            pythonwriter.write("    if (counter2 == 0):\n");
            pythonwriter.write("        output2 = 6000\n");
            pythonwriter.write("    return output2\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def ETCNinetyfinder(ar, ar2, number):\n");
            pythonwriter.write("    counter3 = 0\n");
            pythonwriter.write("    for member in range(0, number):\n");
            pythonwriter.write("        if ((ar[member] == 0.90) & (counter3 == 0)):\n");
            pythonwriter.write("            output3 = ar2[member]\n");
            pythonwriter.write("            counter3 = 1\n");
            pythonwriter.write("    if (counter3 == 0):\n");
            pythonwriter.write("        output3 = 6000\n");
            pythonwriter.write("    return output3\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def HourstoCriterion(entries, array, value):\n");
            pythonwriter.write("    hours = 48\n");
            pythonwriter.write("    if (value == 1):\n");
            pythonwriter.write("        if (entries != 6000):\n");
            pythonwriter.write("            hours = array[entries-1] / 3600\n");
            pythonwriter.write("    if (value == 2):\n");
            pythonwriter.write("        if (entries != 6000):\n");
            pythonwriter.write("            hours = array[entries-1] / 3600 - 48\n");
            pythonwriter.write("    return hours\n");
            pythonwriter.write("\n");
            pythonwriter.write("def Qualifier(ar, number):\n");
            pythonwriter.write("    for u in range(0, 6000):\n");
            pythonwriter.write("        if (u < number-1):\n");
            pythonwriter.write("            ar[u] = 0\n");
            pythonwriter.write("        if (u >= number-1):\n");
            pythonwriter.write("            ar[u] = 1\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def SecondsToHours(ar, number):\n");
            pythonwriter.write("    ar2 = np.zeros(number)\n");
            pythonwriter.write("    for y in range(0, number):\n");
            pythonwriter.write("        ar2[y] = ar[y] / 3600\n");
            pythonwriter.write("    return ar2\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("def IndexFunction(ar1, ar2, ar3):\n");
            pythonwriter.write("    outputarray = np.zeros(89)\n");
            pythonwriter.write("    for v in range(0, 49):\n");
            pythonwriter.write("        left = int(ar1[v])\n");
            pythonwriter.write("        middle = int(ar2[v])\n");
            pythonwriter.write("        right = int(ar3[v])\n");
            pythonwriter.write("        difference = left - (middle + right)\n");
            pythonwriter.write("        total = left + middle + right\n");
            pythonwriter.write("        if (total == 0):\n");
            pythonwriter.write("            outputarray[v] = 0\n");
            pythonwriter.write("        if (total != 0):\n");
            pythonwriter.write("            outputarray[v] = difference / total\n");
            pythonwriter.write("    for y in range(49, 89):\n");
            pythonwriter.write("        left = int(ar1[y])\n");
            pythonwriter.write("        middle = int(ar2[y])\n");
            pythonwriter.write("        right = int(ar3[y])\n");
            pythonwriter.write("        difference = right - (left + middle)\n");
            pythonwriter.write("        total = left + middle + right\n");
            pythonwriter.write("        if (total == 0):\n");
            pythonwriter.write("            outputarray[y] = 0\n");
            pythonwriter.write("        if (total != 0):\n");
            pythonwriter.write("            outputarray[y] = difference / total\n");
            pythonwriter.write("    return outputarray\n");
            pythonwriter.write("\n");
            pythonwriter.write("Hour = np.array(range(1, 90))\n");
            pythonwriter.write("Hour = pd.DataFrame(Hour)\n");
            pythonwriter.write("" + this.AnimalID + " = pd.read_csv(\"" + filestring + "\", sep=\";\", header=" + linenumber + ", na_values=[\"-\", \"s\", \"cm\", \"cm?\", \"cm/s\"])\n");
            pythonwriter.write("" + this.AnimalID + " = " + this.AnimalID + ".drop(" + this.AnimalID + ".index[[0]])\n");
            pythonwriter.write(" \n");
            pythonwriter.write("" + this.AnimalID + "Mov = " + this.AnimalID + "[[\"Recording time\", \"Distance moved\"]]\n");
            pythonwriter.write("" + this.AnimalID + "Mov.columns = [\"Time\", \"Movement\"]\n");
            pythonwriter.write("" + this.AnimalID + "Mov = " + this.AnimalID + "Mov[" + this.AnimalID + "Mov[\"Movement\"] >= 0.1]\n");
            pythonwriter.write("" + this.AnimalID + "Mov = " + this.AnimalID + "Mov.reset_index()\n");
            pythonwriter.write("del " + this.AnimalID + "Mov[\"index\"]\n");
            pythonwriter.write("movementrownumbers = int(len(" + this.AnimalID + "Mov))\n");
            pythonwriter.write("" + this.AnimalID + "Mov[\"Time\"] = SecondsToHours(" + this.AnimalID + "Mov[\"Time\"], movementrownumbers)\n");



            // Count independent Movement per Hour
            pythonwriter.write("TotPathlength = np.array([" + this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write(this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] > " + h + ") & (" + this.AnimalID +"Mov[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write(this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] > 88) & (" + this.AnimalID + "Mov[\"Time\"] < 89)].sum()])\n");




            // Count cumulative Movement per Hour
            pythonwriter.write("CumulativeMovement = np.array([" + this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                pythonwriter.write(this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] < " + h + ")].sum(), ");
            }
            pythonwriter.write(this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] < 89)].sum()])\n");


            pythonwriter.write("TotPathlength = pd.DataFrame(TotPathlength)\n");
            pythonwriter.write("CumulativeMovement = pd.DataFrame(CumulativeMovement)\n");
            pythonwriter.write("Name = np.full((89), AnimalID)\n");
            pythonwriter.write("Name = pd.DataFrame(Name)\n");
            pythonwriter.write("Group = np.full((89), Treatment)\n");
            pythonwriter.write("Group = pd.DataFrame(Group)\n");
            pythonwriter.write("" + this.AnimalID + "Mov = pd.concat([Name, Group, Hour, TotPathlength, CumulativeMovement], axis=1)\n");
            pythonwriter.write("" + this.AnimalID + "Mov.columns = [\"AnimalNumber\", \"Treatment\", \"Hour\", \"TotPathlength\", \"CumulativeMovement\"]\n");
            pythonwriter.write("plt.figsize=(18, 6)\n");
            pythonwriter.write("plt.plot("  + this.AnimalID + "Mov[\"Hour\"], " + this.AnimalID + "Mov[\"TotPathlength\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Total Distance moved by Hour(Independent)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Distance moved\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 2500, 5000, 7500, 10000, 12500, 15000, 17500, 20000, 22500, 25000])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Movement/Independent/" + this.treatment + "/" + this.AnimalID + "IndependentMovement.jpg\", oreintation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");
            pythonwriter.write("plt.figsize=(18, 6)\n");
            pythonwriter.write("plt.plot("  + this.AnimalID + "Mov[\"Hour\"], " + this.AnimalID + "Mov[\"CumulativeMovement\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Total Distance moved by Hour(Cumulative)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Distance moved\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000, 550000, 600000, 650000])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Movement/Cumulative/" + this.treatment + "/" + this.AnimalID + "CumulativeMovement.jpg\", oreintation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");
            pythonwriter.write("" + this.AnimalID + "Mov.to_csv(\"" + maindirectory + lastname + "/Data/Distance moved/" + this.treatment +  "/" + this.AnimalID + "Movement.csv\")\n");
            pythonwriter.write("del " + this.AnimalID + "Mov\n");
            pythonwriter.write("del TotPathlength, CumulativeMovement\n");
            pythonwriter.write("del movementrownumbers\n");
            pythonwriter.write(" \n");
            pythonwriter.write("" + this.AnimalID + "Feeding = " + this.AnimalID + "[[\"Recording time\", \"Hardware continuous\"]]\n");
            pythonwriter.write("" + this.AnimalID + "Feeding.columns = [\"Time\", \"Pellet Drops\"]\n");
            pythonwriter.write("" + this.AnimalID + "Feeding = " + this.AnimalID + "Feeding[" + this.AnimalID + "Feeding[\"Pellet Drops\"] == 1]\n");
            pythonwriter.write("" + this.AnimalID + "Feeding = " + this.AnimalID + "Feeding.reset_index()\n");
            pythonwriter.write("del " + this.AnimalID + "Feeding[\"index\"]\n");
            pythonwriter.write("feedingrownumbers = int(len(" + this.AnimalID + "Feeding))\n");
            pythonwriter.write("" + this.AnimalID + "Feeding[\"Time\"] = SecondsToHours(" + this.AnimalID + "Feeding[\"Time\"], feedingrownumbers)\n");




            // Count independent Pellet Drops per hour
            pythonwriter.write("PelletDrops = np.array([" + this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write(this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] > " + h + ") & (" + this.AnimalID +"Feeding[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write(this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] > 88) & (" + this.AnimalID + "Feeding[\"Time\"] < 89)].sum()])\n");


            // Count cumulative Pellet Drops per hour
            pythonwriter.write("PelletDropsv2 = np.array([" + this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                pythonwriter.write(this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] < " + h + ")].sum(), ");
            }
            pythonwriter.write(this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] < 89)].sum()])\n");




            pythonwriter.write("PelletDrops = pd.DataFrame(PelletDrops)\n");
            pythonwriter.write("PelletDropsv2 = pd.DataFrame(PelletDropsv2)\n");
            pythonwriter.write("" + this.AnimalID + "Feeding = pd.concat([Name, Group, Hour, PelletDrops, PelletDropsv2], axis=1)\n");
            pythonwriter.write("" + this.AnimalID + "Feeding.columns = [\"AnimalNumber\", \"Treatment\", \"Hour\", \"TotFeeding\", \"Rewards\"]\n");

            pythonwriter.write("plt.figsize=(18, 6)\n");
            pythonwriter.write("plt.plot("  + this.AnimalID + "Feeding[\"Hour\"], " + this.AnimalID + "Feeding[\"TotFeeding\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Feeding by Hour(Independent)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Pellet Drops\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Feeding/Independent/" + this.treatment + "/" + this.AnimalID + "IndependentFeeding.jpg\", oreintation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");

            pythonwriter.write("plt.figsize=(18, 6)\n");
            pythonwriter.write("plt.plot("  + this.AnimalID + "Feeding[\"Hour\"], " + this.AnimalID + "Feeding[\"Rewards\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Feeding by Hour(Cumulative)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Pellet drops\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Feeding/Cumulative/" + this.treatment + "/" + this.AnimalID + "CumulativeFeeding.jpg\", oreintation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");


            pythonwriter.write("" + this.AnimalID + "Feeding.to_csv(\"" + maindirectory + lastname + "/Data/Feeding/" + this.treatment + "/" + this.AnimalID + "feedingresults.csv\")\n");
            pythonwriter.write("del " + this.AnimalID + "Feeding\n");
            pythonwriter.write("del PelletDrops, PelletDropsv2\n");
            pythonwriter.write("del Name, Group\n");
            pythonwriter.write("del feedingrownumbers\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("numberofentries = " + this.AnimalID + "[\"Include: Left Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance Rev D2\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance Rev D2\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance Rev D2\"].sum()\n");
            pythonwriter.write("numberofentries = int(numberofentries)\n");
            pythonwriter.write("" + this.AnimalID + "entries = " + this.AnimalID + "[[\"Recording time\", \"Include: Left Entrance D1\", \"Include: Mid Entrance D1\", \"Include: Right Entrance D1\", \"Include: Left Entrance D2\", \"Include: Mid Entrance D2\", \"Include: Right Entrance D2\", \"Include: Left Entrance Rev D1\", \"Include: Mid Entrance Rev D1\", \"Include: Right Entrance Rev D1\", \"Include: Left Entrance Rev D2\", \"Include: Mid Entrance Rev D2\", \"Include: Right Entrance Rev D2\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entries = " + this.AnimalID + "entries[(" + this.AnimalID + "entries[\"Include: Left Entrance D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Mid Entrance D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Right Entrance D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Left Entrance D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Mid Entrance D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Right Entrance D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Left Entrance Rev D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Mid Entrance Rev D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Right Entrance Rev D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Left Entrance Rev D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Mid Entrance Rev D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Right Entrance Rev D2\"] == 1)]\n");
            pythonwriter.write(" \n");
            pythonwriter.write("IDnumberofentries = " + this.AnimalID + "[\"Include: Left Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance D2\"].sum()\n");
            pythonwriter.write("IDnumberofentries = int(IDnumberofentries)\n");
            pythonwriter.write("Revnumberofentries = " + this.AnimalID + "[\"Include: Left Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance Rev D2\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance Rev D2\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance Rev D2\"].sum()\n");
            pythonwriter.write("Revnumberofentries = int(Revnumberofentries)\n");
            pythonwriter.write(" \n");
            pythonwriter.write("del " + this.AnimalID + "\n");
            pythonwriter.write("FullEntryNumber = np.array(range(1, 6001))\n");
            pythonwriter.write("FullEntryNumber = pd.DataFrame(FullEntryNumber)\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("" + this.AnimalID + "entriesD1 = " + this.AnimalID + "entries[[\"Recording time\", \"Include: Left Entrance D1\", \"Include: Mid Entrance D1\", \"Include: Right Entrance D1\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD1 = " + this.AnimalID + "entriesD1[(" + this.AnimalID + "entriesD1[\"Recording time\"] < 86400)]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD1.columns = [\"Time\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD2 = " + this.AnimalID + "entries[[\"Recording time\", \"Include: Left Entrance D2\", \"Include: Mid Entrance D2\", \"Include: Right Entrance D2\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD2 = " + this.AnimalID + "entriesD2[(" + this.AnimalID + "entriesD2[\"Recording time\"] > 86400) & (" + this.AnimalID + "entriesD2[\"Recording time\"] < 172800)]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD2.columns = [\"Time\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("framestomergeInitial = [" + this.AnimalID + "entriesD1, " + this.AnimalID + "entriesD2]\n");

            pythonwriter.write("" + this.AnimalID + "Initial = pd.concat(framestomergeInitial)\n");
            pythonwriter.write("" + this.AnimalID + "entriesD3 = " + this.AnimalID + "entries[[\"Recording time\", \"Include: Left Entrance Rev D1\", \"Include: Mid Entrance Rev D1\", \"Include: Right Entrance Rev D1\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD3 = " + this.AnimalID + "entriesD3[(" + this.AnimalID + "entriesD3[\"Recording time\"] > 172800) & (" + this.AnimalID + "entriesD3[\"Recording time\"] < 259200)]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD3.columns = [\"Time\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD4 = " + this.AnimalID + "entries[[\"Recording time\", \"Include: Left Entrance Rev D2\", \"Include: Mid Entrance Rev D2\", \"Include: Right Entrance Rev D2\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD4 = " + this.AnimalID + "entriesD4[(" + this.AnimalID + "entriesD4[\"Recording time\"] > 259200) & (" + this.AnimalID + "entriesD4[\"Recording time\"] < 345600)]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD4.columns = [\"Time\", \"Left\", \"Middle\", \"Right\"]\n");

            pythonwriter.write("framestomergeReversal = [" + this.AnimalID + "entriesD3, " + this.AnimalID + "entriesD4]\n");
            pythonwriter.write("" + this.AnimalID + "Reversal = pd.concat(framestomergeReversal)\n");
            pythonwriter.write("del " + this.AnimalID + "entries, " + this.AnimalID + "entriesD1, " + this.AnimalID + "entriesD2, " + this.AnimalID + "entriesD3, " + this.AnimalID + "entriesD4\n");
            pythonwriter.write("del framestomergeInitial, framestomergeReversal\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");

            pythonwriter.write("mouseIndex = pd.concat([" + this.AnimalID + "Initial, " + this.AnimalID + "Reversal])\n");
            pythonwriter.write("mouseIndex = mouseIndex.reset_index()\n");
            pythonwriter.write("del mouseIndex[\"index\"]\n");
            pythonwriter.write("mouseIndex[\"Time\"] = SecondsToHours(mouseIndex[\"Time\"], numberofentries)\n");


            // Count independent left entries
            pythonwriter.write("Left = np.array([mouseIndex[\"Left\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] > " + h + ") & (mouseIndex[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] > 88) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            // Count independent middle entries
            pythonwriter.write("Middle = np.array([mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] > " + h + ") & (mouseIndex[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] > 88) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            // Count independent right entries
            pythonwriter.write("Right = np.array([mouseIndex[\"Right\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] > " + h + ") & (mouseIndex[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] > 88) & (mouseIndex[\"Time\"] < 89)].sum()])\n");


            // Count cumulative left entries
            pythonwriter.write("CumulativeLeft = np.array([mouseIndex[\"Left\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                if (h <= 48){
                    pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
                if (h > 48){
                    pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
            }
            pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            // Count cumulative middle entries
            pythonwriter.write("CumulativeMiddle = np.array([mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                if (h <= 48){
                    pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
                if (h > 48){
                    pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
            }
            pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            // Count cumulative right entries
            pythonwriter.write("CumulativeRight = np.array([mouseIndex[\"Right\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                if (h <= 48){
                    pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
                if (h > 48){
                    pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
            }
            pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            pythonwriter.write("LearningIndex = np.zeros(89)\n");
            pythonwriter.write("LearningIndex = IndexFunction(Left, Middle, Right)\n");
            pythonwriter.write("LearningIndex = pd.DataFrame(LearningIndex)\n");

            pythonwriter.write("CumulativeIndex = np.zeros(89)\n");
            pythonwriter.write("CumulativeIndex = IndexFunction(CumulativeLeft, CumulativeMiddle, CumulativeRight)\n");
            pythonwriter.write("CumulativeIndex = pd.DataFrame(CumulativeIndex)\n");


            pythonwriter.write("Left = pd.DataFrame(Left)\n");
            pythonwriter.write("Middle = pd.DataFrame(Middle)\n");
            pythonwriter.write("Right = pd.DataFrame(Right)\n");
            pythonwriter.write("mouseIndex = pd.concat([Hour, Left, Middle, Right], axis=1)\n");
            pythonwriter.write("mouseIndex.columns = [\"Hour\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("del Left, Middle, Right\n");
            pythonwriter.write("Name = np.full((89), AnimalID)\n");
            pythonwriter.write("Name = pd.DataFrame(Name)\n");
            pythonwriter.write("Group = np.full((89), Treatment)\n");
            pythonwriter.write("Group = pd.DataFrame(Group)\n");


            pythonwriter.write("plt.figsize=(18, 6)\n");

            pythonwriter.write("plt.plot(mouseIndex[\"Hour\"], mouseIndex[\"Left\"], \"r-\")\n");
            pythonwriter.write("plt.plot(mouseIndex[\"Hour\"], mouseIndex[\"Middle\"], \"b-\")\n");
            pythonwriter.write("plt.plot(mouseIndex[\"Hour\"], mouseIndex[\"Right\"], \"g-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Entry Choice by Hour)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"# of entries\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 25, 50, 75, 100, 125, 150, 175, 200])\n");
            pythonwriter.write("plt.legend([\"Left\", \"Middle\", \"Right\"])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Entry Choice/" + this.treatment + "/" + this.AnimalID + "EntryChoice.jpg\", orientation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");

            pythonwriter.write("mouseIndex = pd.concat([Name, Group, mouseIndex, LearningIndex], axis=1)\n");
            pythonwriter.write("mouseIndex.columns = [\"Name\", \"Group\", \"Hour\", \"Left\", \"Middle\", \"Right\", \"LearningIndex\"]\n");

            pythonwriter.write("plt.figsize=(18, 6)\n");

            pythonwriter.write("plt.plot(mouseIndex[\"Hour\"], mouseIndex[\"LearningIndex\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " (Correct entries - Incorrect entries) / Total entries)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Learning Index\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([-1.0, -0.5, 0, 0.5, 1.0])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Indexes/Independent/" + this.treatment + "/" + this.AnimalID + "IndependentIndex.jpg\", orientation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");


            pythonwriter.write("CumulativeLeft = pd.DataFrame(CumulativeLeft)\n");
            pythonwriter.write("CumulativeMiddle = pd.DataFrame(CumulativeMiddle)\n");
            pythonwriter.write("CumulativeRight = pd.DataFrame(CumulativeRight)\n");
            pythonwriter.write("mouseCumulativeIndex = pd.concat([Hour, CumulativeLeft, CumulativeMiddle, CumulativeRight], axis=1)\n");
            pythonwriter.write("mouseCumulativeIndex.columns = [\"Hour\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("del CumulativeLeft, CumulativeMiddle, CumulativeRight\n");

            pythonwriter.write("mouseCumulativeIndex = pd.concat([Name, Group, mouseCumulativeIndex, CumulativeIndex], axis=1)\n");
            pythonwriter.write("mouseCumulativeIndex.columns = [\"Name\", \"Group\", \"Hour\", \"Left\", \"Middle\", \"Right\", \"CumulativeIndex\"]\n");

            pythonwriter.write("plt.figsize=(18, 6)\n");

            pythonwriter.write("plt.plot(mouseCumulativeIndex[\"Hour\"], mouseCumulativeIndex[\"CumulativeIndex\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " (Correct entries - Incorrect entries) / Total entries)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Learning Index\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([-1.0, -0.5, 0, 0.5, 1.0])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Indexes/Cumulative/" + this.treatment + "/" + this.AnimalID + "CumulativeIndex.jpg\", orientation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");

            pythonwriter.write("mouseIndex.to_csv(\"" + maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Independent/" + this.treatment + "/" + this.AnimalID + "IndependentIndex.csv\")\n");
            pythonwriter.write("mouseCumulativeIndex.to_csv(\"" + maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Cumulative/" + this.treatment + "/" + this.AnimalID + "CumulativeIndex.csv\")\n");
            pythonwriter.write("del mouseIndex, LearningIndex\n");
            pythonwriter.write("del mouseCumulativeIndex, Hour, CumulativeIndex\n");

            pythonwriter.write("\n");

            pythonwriter.write("sample = np.array(" + this.AnimalID + "Initial[\"Left\"])\n");
            pythonwriter.write("Criterions = np.zeros(IDnumberofentries)\n");
            pythonwriter.write("EditedCriterion = np.zeros(IDnumberofentries)\n");
            pythonwriter.write("movingwindow(sample, IDnumberofentries, Criterions)\n");
            pythonwriter.write("ChangedCriterion(Criterions, IDnumberofentries, EditedCriterion)\n");
            pythonwriter.write("Time = np.array(" + this.AnimalID + "Initial[\"Time\"])\n");
            pythonwriter.write("Time = pd.DataFrame(Time)\n");
            pythonwriter.write("Criterions = pd.DataFrame(Criterions)\n");
            pythonwriter.write("EditedCriterion = pd.DataFrame(EditedCriterion)\n");
            pythonwriter.write("EntryNumber = np.array(range(1, IDnumberofentries+1))\n");
            pythonwriter.write("EntryNumber = pd.DataFrame(EntryNumber)\n");
            pythonwriter.write("" + this.AnimalID + "Initial = pd.concat([Time, EntryNumber, Criterions, EditedCriterion], axis=1)\n");
            pythonwriter.write("" + this.AnimalID + "Initial.columns = [\"Time\", \"EntryNumber\", \"Criterions\", \"CriterionMet\"]\n");
            pythonwriter.write("IDETCSeventy = ETCSeventyfinder(" + this.AnimalID + "Initial[\"Criterions\"], " + this.AnimalID + "Initial[\"EntryNumber\"], IDnumberofentries)\n");
            pythonwriter.write("IDETCEighty = ETCEightyfinder(" + this.AnimalID + "Initial[\"Criterions\"], " + this.AnimalID + "Initial[\"EntryNumber\"], IDnumberofentries)\n");
            pythonwriter.write("IDETCNinety = ETCNinetyfinder(" + this.AnimalID + "Initial[\"Criterions\"],  " + this.AnimalID + "Initial[\"EntryNumber\"], IDnumberofentries)\n");
            pythonwriter.write("HourstoSeventy = HourstoCriterion(IDETCSeventy, " + this.AnimalID + "Initial[\"Time\"], 1)\n");
            pythonwriter.write("HourstoEighty = HourstoCriterion(IDETCEighty, " + this.AnimalID + "Initial[\"Time\"], 1)\n");
            pythonwriter.write("HourstoNinety = HourstoCriterion(IDETCNinety, " + this.AnimalID + "Initial[\"Time\"], 1)\n");
            pythonwriter.write("IDSeventyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(IDSeventyQualifier, IDETCSeventy)\n");
            pythonwriter.write("IDSeventyQualifier = pd.DataFrame(IDSeventyQualifier)\n");
            pythonwriter.write("IDEightyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(IDEightyQualifier, IDETCEighty)\n");
            pythonwriter.write("IDEightyQualifier = pd.DataFrame(IDEightyQualifier)\n");
            pythonwriter.write("IDNinetyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(IDNinetyQualifier, IDETCNinety)\n");
            pythonwriter.write("IDNinetyQualifier = pd.DataFrame(IDNinetyQualifier)\n");




            pythonwriter.write("Name = np.full((6000), AnimalID)\n");
            pythonwriter.write("Name = pd.DataFrame(Name)\n");
            pythonwriter.write("Group = np.full((6000), Treatment)\n");
            pythonwriter.write("Group = pd.DataFrame(Group)\n");
            pythonwriter.write(this.AnimalID + "IDETCresults = pd.DataFrame([[AnimalID, Treatment, IDETCSeventy, IDETCEighty, IDETCNinety, HourstoSeventy, HourstoEighty, HourstoNinety]], columns=np.array([\"AnimalID\", \"Treatment\", \"EntriestoSeventy\", \"EntriestoEighty\", \"EntriestoNinety\", \"HourstoSeventy\", \"HourstoEighty\", \"HourstoNinety\"]))\n");
            pythonwriter.write("del HourstoSeventy, HourstoEighty, HourstoNinety\n");
            pythonwriter.write(this.AnimalID + "IDETCresults.to_csv(\"" + maindirectory + lastname + "/Data//Entries to Criterion/Initial Discrimination/" +  this.treatment + "/" + this.AnimalID + "IDETCResults.csv\")\n");
            pythonwriter.write("del " + this.AnimalID + "IDETCresults\n");
            pythonwriter.write(this.AnimalID + "Initialv2 = pd.concat([Name, Group, FullEntryNumber, IDSeventyQualifier, IDEightyQualifier, IDNinetyQualifier], axis=1)\n");
            pythonwriter.write(this.AnimalID + "Initialv2.columns = [\"AnimalNumber\", \"Treatment\", \"EntryNumber\", \"SeventyQualifier\", \"EightyQualifier\", \"NinetyQualifier\"]  \n");
            pythonwriter.write("del IDETCSeventy, IDETCEighty, IDETCNinety\n");
            pythonwriter.write("del IDSeventyQualifier, IDEightyQualifier, IDNinetyQualifier\n");
            pythonwriter.write("" + this.AnimalID + "Initialv2.to_csv(\"" + maindirectory + lastname + "/Data/Initial Discrimination/" +  this.treatment + "/" + this.AnimalID + "totalresults.csv\")\n");
            pythonwriter.write("del sample, Criterions, EditedCriterion, Time, EntryNumber\n");
            pythonwriter.write("del " + this.AnimalID + "Initialv2\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("sample = np.array(" + this.AnimalID + "Reversal[\"Right\"])\n");
            pythonwriter.write("Criterions = np.zeros(Revnumberofentries)\n");
            pythonwriter.write("EditedCriterion = np.zeros(Revnumberofentries)\n");
            pythonwriter.write("movingwindow(sample, Revnumberofentries, Criterions)\n");
            pythonwriter.write("ChangedCriterion(Criterions, Revnumberofentries, EditedCriterion)\n");
            pythonwriter.write("Time = np.array(" + this.AnimalID + "Reversal[\"Time\"])\n");
            pythonwriter.write("Time = pd.DataFrame(Time)\n");
            pythonwriter.write("Criterions = pd.DataFrame(Criterions)\n");
            pythonwriter.write("EditedCriterion = pd.DataFrame(EditedCriterion)\n");
            pythonwriter.write("EntryNumber = np.array(range(1, Revnumberofentries+1))\n");
            pythonwriter.write("EntryNumber = pd.DataFrame(EntryNumber)\n");
            pythonwriter.write("" + this.AnimalID + "Reversal = pd.concat([Time, EntryNumber, Criterions, EditedCriterion], axis=1)\n");
            pythonwriter.write("" + this.AnimalID + "Reversal.columns = [\"Time\", \"EntryNumber\", \"Criterions\", \"CriterionMet\"]\n");
            pythonwriter.write("RevETCSeventy = ETCSeventyfinder(" + this.AnimalID + "Reversal[\"Criterions\"], " + this.AnimalID + "Reversal[\"EntryNumber\"], Revnumberofentries)\n");
            pythonwriter.write("RevETCEighty = ETCEightyfinder(" + this.AnimalID + "Reversal[\"Criterions\"], " + this.AnimalID + "Reversal[\"EntryNumber\"], Revnumberofentries)\n");
            pythonwriter.write("RevETCNinety = ETCNinetyfinder(" + this.AnimalID + "Reversal[\"Criterions\"],  " + this.AnimalID + "Reversal[\"EntryNumber\"], Revnumberofentries)  \n");
            pythonwriter.write("HourstoSeventy = HourstoCriterion(RevETCSeventy, " + this.AnimalID + "Reversal[\"Time\"], 2)\n");
            pythonwriter.write("HourstoEighty = HourstoCriterion(RevETCEighty, " + this.AnimalID + "Reversal[\"Time\"], 2)\n");
            pythonwriter.write("HourstoNinety = HourstoCriterion(RevETCNinety, " + this.AnimalID + "Reversal[\"Time\"], 2)\n");
            pythonwriter.write("RevSeventyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(RevSeventyQualifier, RevETCSeventy)\n");

            pythonwriter.write("RevSeventyQualifier = pd.DataFrame(RevSeventyQualifier)\n");
            pythonwriter.write("RevEightyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(RevEightyQualifier, RevETCEighty)\n");

            pythonwriter.write("RevEightyQualifier = pd.DataFrame(RevEightyQualifier)\n");
            pythonwriter.write("RevNinetyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(RevNinetyQualifier, RevETCNinety)\n");

            pythonwriter.write("RevNinetyQualifier = pd.DataFrame(RevNinetyQualifier)\n");

            pythonwriter.write(this.AnimalID + "RevETCresults = pd.DataFrame([[AnimalID, Treatment, RevETCSeventy, RevETCEighty, RevETCNinety, HourstoSeventy, HourstoEighty, HourstoNinety]], columns=np.array([\"AnimalID\", \"Treatment\", \"EntriestoSeventy\", \"EntriestoEighty\", \"EntriestoNinety\", \"HourstoSeventy\", \"HourstoEighty\", \"HourstoNinety\"]))\n");
            pythonwriter.write(this.AnimalID + "RevETCresults.to_csv(\"" + maindirectory + lastname + "/Data//Entries to Criterion/Reversal/" +  this.treatment + "/" + this.AnimalID + "RevETCresutls.csv\")\n");
            pythonwriter.write("del " + this.AnimalID + "RevETCresults\n");
            pythonwriter.write("" + this.AnimalID + "Reversalv2 = pd.concat([Name, Group, FullEntryNumber, RevSeventyQualifier, RevEightyQualifier, RevNinetyQualifier], axis=1) \n");
            pythonwriter.write("" + this.AnimalID + "Reversalv2.columns = [\"AnimalNumber\", \"Treatment\", \"EntryNumber\", \"SeventyQualifier\", \"EightyQualifier\", \"NinetyQualifier\"]\n");
            pythonwriter.write("del RevETCSeventy, RevETCEighty, RevETCNinety\n");
            pythonwriter.write("del RevSeventyQualifier, RevEightyQualifier, RevNinetyQualifier\n");
            pythonwriter.write("" + this.AnimalID + "Reversalv2.to_csv(\"" + maindirectory + lastname + "/Data/Reversal/" + this.treatment + "/" + this.AnimalID + "Reversal.csv\")\n");
            pythonwriter.write(" \n");
            pythonwriter.write("del sample, Criterions, EditedCriterion, Time, EntryNumber\n");
            pythonwriter.write("del " + this.AnimalID + "Reversalv2\n");

            pythonwriter.write("del numberofentries, IDnumberofentries, Revnumberofentries\n");
            pythonwriter.write("del " + this.AnimalID + "Initial, " + this.AnimalID + "Reversal\n");
            pythonwriter.write("del FullEntryNumber\n");
            pythonwriter.write(" \n");
            pythonwriter.close();
        } catch(IOException w){
            System.out.println("Failed");
        }


    }

    public void IndividualMousePlotter(String filestring, int linenumber, String lastname, String maindirectory, String Rscriptdirectory){
        try {
            BufferedWriter pythonwriter = new BufferedWriter(new FileWriter(Rscriptdirectory + lastname + this.AnimalID + ".py"));
            pythonwriter.write("import numpy as np\n");
            pythonwriter.write("import pandas as pd\n");
            pythonwriter.write("import matplotlib.pyplot as plt\n");
            pythonwriter.write(" \n");

            pythonwriter.write("AnimalID = \"" + this.AnimalID + "\"\n");
            pythonwriter.write("Treatment = \"" + this.treatment + "\"\n");
            pythonwriter.write(" \n");


            pythonwriter.write("def movingwindow(ar, number, outputarray):\n");
            pythonwriter.write("    for x in range(0, number):\n");
            pythonwriter.write("        value1 = 0.0\n");
            pythonwriter.write("        value2 = 0.0\n");
            pythonwriter.write("        if (x < 29):\n");
            pythonwriter.write("            outputarray[x] = 0.0\n");
            pythonwriter.write("        if (x == 29):\n");
            pythonwriter.write("            for y in range(0, 29):\n");
            pythonwriter.write("                value1 = value1 + ar[y]\n");
            pythonwriter.write("            outputarray[x] = value1 / 30 \n");
            pythonwriter.write("        if (x > 29):\n");
            pythonwriter.write("            start = x - 29\n");
            pythonwriter.write("            end = x + 1\n");
            pythonwriter.write("            for z in range(start, end):\n");
            pythonwriter.write("                value2 = value2 + ar[z]\n");
            pythonwriter.write("            outputarray[x] = value2 / 30 \n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("def ChangedCriterion(arr, number, outputarray2):\n");
            pythonwriter.write("    value = 0\n");
            pythonwriter.write("    for element in range(0, number):\n");
            pythonwriter.write("        if ((arr[element] == 0.10) & (value <= 0.10)):\n");
            pythonwriter.write("            value = 0.10    \n");
            pythonwriter.write("        if ((arr[element] == 0.20) & (value <= 0.20)):\n");
            pythonwriter.write("            value = 0.20    \n");
            pythonwriter.write("        if ((arr[element] == 0.30) & (value <= 0.30)):\n");
            pythonwriter.write("            value = 0.30    \n");
            pythonwriter.write("        if ((arr[element] == 0.40) & (value <= 0.40)):\n");
            pythonwriter.write("            value = 0.40    \n");
            pythonwriter.write("        if ((arr[element] == 0.50) & (value <= 0.50)):\n");
            pythonwriter.write("            value = 0.50    \n");
            pythonwriter.write("        if ((arr[element] == 0.60) & (value <= 0.60)):\n");
            pythonwriter.write("            value = 0.60    \n");
            pythonwriter.write("        if ((arr[element] == 0.70) & (value <= 0.70)):\n");
            pythonwriter.write("            value = 0.70    \n");
            pythonwriter.write("        if ((arr[element] == 0.80) & (value <= 0.80)):\n");
            pythonwriter.write("            value = 0.80         \n");
            pythonwriter.write("        if ((arr[element] == 0.90) & (value <= 0.90)):\n");
            pythonwriter.write("            value = 0.90    \n")   ;
            pythonwriter.write("        if (arr[element] == 1.0):\n");
            pythonwriter.write("            value = 1.0\n");
            pythonwriter.write("        outputarray2[element] = value\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def ETCSeventyfinder(ar, ar2, number):\n");
            pythonwriter.write("    counter1 = 0\n");
            pythonwriter.write("    for member in range(0, number):\n");
            pythonwriter.write("        if ((ar[member] == 0.70) & (counter1 == 0)):\n");
            pythonwriter.write("            output1 = ar2[member]\n");
            pythonwriter.write("            counter1 = 1\n");
            pythonwriter.write("    if (counter1 == 0):\n");
            pythonwriter.write("        output1 = 6000\n");
            pythonwriter.write("    return output1\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def ETCEightyfinder(ar, ar2, number):\n");
            pythonwriter.write("    counter2 = 0\n");
            pythonwriter.write("    for member in range(0, number):\n");
            pythonwriter.write("        if ((ar[member] == 0.80) & (counter2 == 0)):\n");
            pythonwriter.write("            output2 = ar2[member]\n");
            pythonwriter.write("            counter2 = 1\n");
            pythonwriter.write("    if (counter2 == 0):\n");
            pythonwriter.write("        output2 = 6000\n");
            pythonwriter.write("    return output2\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def ETCNinetyfinder(ar, ar2, number):\n");
            pythonwriter.write("    counter3 = 0\n");
            pythonwriter.write("    for member in range(0, number):\n");
            pythonwriter.write("        if ((ar[member] == 0.90) & (counter3 == 0)):\n");
            pythonwriter.write("            output3 = ar2[member]\n");
            pythonwriter.write("            counter3 = 1\n");
            pythonwriter.write("    if (counter3 == 0):\n");
            pythonwriter.write("        output3 = 6000\n");
            pythonwriter.write("    return output3\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def HourstoCriterion(entries, array, value):\n");
            pythonwriter.write("    hours = 48\n");
            pythonwriter.write("    if (value == 1):\n");
            pythonwriter.write("        if (entries != 6000):\n");
            pythonwriter.write("            hours = array[entries-1] / 3600\n");
            pythonwriter.write("    if (value == 2):\n");
            pythonwriter.write("        if (entries != 6000):\n");
            pythonwriter.write("            hours = array[entries-1] / 3600 - 48\n");
            pythonwriter.write("    return hours\n");
            pythonwriter.write("\n");
            pythonwriter.write("def Qualifier(ar, number):\n");
            pythonwriter.write("    for u in range(0, 6000):\n");
            pythonwriter.write("        if (u < number-1):\n");
            pythonwriter.write("            ar[u] = 0\n");
            pythonwriter.write("        if (u >= number-1):\n");
            pythonwriter.write("            ar[u] = 1\n");
            pythonwriter.write(" \n");
            pythonwriter.write("def SecondsToHours(ar, number):\n");
            pythonwriter.write("    ar2 = np.zeros(number)\n");
            pythonwriter.write("    for y in range(0, number):\n");
            pythonwriter.write("        ar2[y] = ar[y] / 3600\n");
            pythonwriter.write("    return ar2\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("def IndexFunction(ar1, ar2, ar3):\n");
            pythonwriter.write("    outputarray = np.zeros(89)\n");
            pythonwriter.write("    for v in range(0, 49):\n");
            pythonwriter.write("        left = int(ar1[v])\n");
            pythonwriter.write("        middle = int(ar2[v])\n");
            pythonwriter.write("        right = int(ar3[v])\n");
            pythonwriter.write("        difference = left - (middle + right)\n");
            pythonwriter.write("        total = left + middle + right\n");
            pythonwriter.write("        if (total == 0):\n");
            pythonwriter.write("            outputarray[v] = 0\n");
            pythonwriter.write("        if (total != 0):\n");
            pythonwriter.write("            outputarray[v] = difference / total\n");
            pythonwriter.write("    for y in range(49, 89):\n");
            pythonwriter.write("        left = int(ar1[y])\n");
            pythonwriter.write("        middle = int(ar2[y])\n");
            pythonwriter.write("        right = int(ar3[y])\n");
            pythonwriter.write("        difference = right - (left + middle)\n");
            pythonwriter.write("        total = left + middle + right\n");
            pythonwriter.write("        if (total == 0):\n");
            pythonwriter.write("            outputarray[y] = 0\n");
            pythonwriter.write("        if (total != 0):\n");
            pythonwriter.write("            outputarray[y] = difference / total\n");
            pythonwriter.write("    return outputarray\n");
            pythonwriter.write("\n");
            pythonwriter.write("Hour = np.array(range(1, 90))\n");
            pythonwriter.write("Hour = pd.DataFrame(Hour)\n");
            pythonwriter.write("" + this.AnimalID + " = pd.read_csv(\"" + filestring + "\", sep=\";\", header=" + linenumber + ", na_values=[\"-\", \"s\", \"cm\", \"cm?\", \"cm/s\"])\n");
            pythonwriter.write("" + this.AnimalID + " = " + this.AnimalID + ".drop(" + this.AnimalID + ".index[[0]])\n");
            pythonwriter.write(" \n");
            pythonwriter.write("" + this.AnimalID + "Mov = " + this.AnimalID + "[[\"Recording time\", \"Distance moved\"]]\n");
            pythonwriter.write("" + this.AnimalID + "Mov.columns = [\"Time\", \"Movement\"]\n");
            pythonwriter.write("" + this.AnimalID + "Mov = " + this.AnimalID + "Mov[" + this.AnimalID + "Mov[\"Movement\"] >= 0.1]\n");
            pythonwriter.write("" + this.AnimalID + "Mov = " + this.AnimalID + "Mov.reset_index()\n");
            pythonwriter.write("del " + this.AnimalID + "Mov[\"index\"]\n");
            pythonwriter.write("movementrownumbers = int(len(" + this.AnimalID + "Mov))\n");
            pythonwriter.write("" + this.AnimalID + "Mov[\"Time\"] = SecondsToHours(" + this.AnimalID + "Mov[\"Time\"], movementrownumbers)\n");



            // Count independent Movement per Hour
            pythonwriter.write("TotPathlength = np.array([" + this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write(this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] > " + h + ") & (" + this.AnimalID +"Mov[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write(this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] > 88) & (" + this.AnimalID + "Mov[\"Time\"] < 89)].sum()])\n");




            // Count cumulative Movement per Hour
            pythonwriter.write("CumulativeMovement = np.array([" + this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                pythonwriter.write(this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] < " + h + ")].sum(), ");
            }
            pythonwriter.write(this.AnimalID + "Mov[\"Movement\"][(" + this.AnimalID + "Mov[\"Time\"] < 89)].sum()])\n");


            pythonwriter.write("TotPathlength = pd.DataFrame(TotPathlength)\n");
            pythonwriter.write("CumulativeMovement = pd.DataFrame(CumulativeMovement)\n");
            pythonwriter.write("Name = np.full((89), AnimalID)\n");
            pythonwriter.write("Name = pd.DataFrame(Name)\n");
            pythonwriter.write("Group = np.full((89), Treatment)\n");
            pythonwriter.write("Group = pd.DataFrame(Group)\n");
            pythonwriter.write("" + this.AnimalID + "Mov = pd.concat([Name, Group, Hour, TotPathlength, CumulativeMovement], axis=1)\n");
            pythonwriter.write("" + this.AnimalID + "Mov.columns = [\"AnimalNumber\", \"Treatment\", \"Hour\", \"TotPathlength\", \"CumulativeMovement\"]\n");
            pythonwriter.write("plt.figsize=(18, 6)\n");
            pythonwriter.write("plt.plot("  + this.AnimalID + "Mov[\"Hour\"], " + this.AnimalID + "Mov[\"TotPathlength\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Total Distance moved by Hour(Independent)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Distance moved\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 2500, 5000, 7500, 10000, 12500, 15000, 17500, 20000, 22500, 25000])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Movement/Independent/" + this.treatment + "/" + this.AnimalID + "IndependentMovement.jpg\", oreintation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");
            pythonwriter.write("plt.figsize=(18, 6)\n");
            pythonwriter.write("plt.plot("  + this.AnimalID + "Mov[\"Hour\"], " + this.AnimalID + "Mov[\"CumulativeMovement\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Total Distance moved by Hour(Cumulative)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Distance moved\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000, 550000, 600000, 650000])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Movement/Cumulative/" + this.treatment + "/" + this.AnimalID + "CumulativeMovement.jpg\", oreintation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");
            pythonwriter.write("" + this.AnimalID + "Mov.to_csv(\"" + maindirectory + lastname + "/Data/Distance moved/" + this.treatment +  "/" + this.AnimalID + "Movement.csv\")\n");
            pythonwriter.write("del " + this.AnimalID + "Mov\n");
            pythonwriter.write("del TotPathlength, CumulativeMovement\n");
            pythonwriter.write("del movementrownumbers\n");
            pythonwriter.write(" \n");
            pythonwriter.write("" + this.AnimalID + "Feeding = " + this.AnimalID + "[[\"Recording time\", \"Hardware continuous\"]]\n");
            pythonwriter.write("" + this.AnimalID + "Feeding.columns = [\"Time\", \"Pellet Drops\"]\n");
            pythonwriter.write("" + this.AnimalID + "Feeding = " + this.AnimalID + "Feeding[" + this.AnimalID + "Feeding[\"Pellet Drops\"] == 1]\n");
            pythonwriter.write("" + this.AnimalID + "Feeding = " + this.AnimalID + "Feeding.reset_index()\n");
            pythonwriter.write("del " + this.AnimalID + "Feeding[\"index\"]\n");
            pythonwriter.write("feedingrownumbers = int(len(" + this.AnimalID + "Feeding))\n");
            pythonwriter.write("" + this.AnimalID + "Feeding[\"Time\"] = SecondsToHours(" + this.AnimalID + "Feeding[\"Time\"], feedingrownumbers)\n");




            // Count independent Pellet Drops per hour
            pythonwriter.write("PelletDrops = np.array([" + this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write(this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] > " + h + ") & (" + this.AnimalID +"Feeding[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write(this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] > 88) & (" + this.AnimalID + "Feeding[\"Time\"] < 89)].sum()])\n");


            // Count cumulative Pellet Drops per hour
            pythonwriter.write("PelletDropsv2 = np.array([" + this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                pythonwriter.write(this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] < " + h + ")].sum(), ");
            }
            pythonwriter.write(this.AnimalID + "Feeding[\"Pellet Drops\"][(" + this.AnimalID + "Feeding[\"Time\"] < 89)].sum()])\n");




            pythonwriter.write("PelletDrops = pd.DataFrame(PelletDrops)\n");
            pythonwriter.write("PelletDropsv2 = pd.DataFrame(PelletDropsv2)\n");
            pythonwriter.write("" + this.AnimalID + "Feeding = pd.concat([Name, Group, Hour, PelletDrops, PelletDropsv2], axis=1)\n");
            pythonwriter.write("" + this.AnimalID + "Feeding.columns = [\"AnimalNumber\", \"Treatment\", \"Hour\", \"TotFeeding\", \"Rewards\"]\n");

            pythonwriter.write("plt.figsize=(18, 6)\n");
            pythonwriter.write("plt.plot("  + this.AnimalID + "Feeding[\"Hour\"], " + this.AnimalID + "Feeding[\"TotFeeding\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Feeding by Hour(Independent)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Pellet Drops\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Feeding/Independent/" + this.treatment + "/" + this.AnimalID + "IndependentFeeding.jpg\", oreintation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");

            pythonwriter.write("plt.figsize=(18, 6)\n");
            pythonwriter.write("plt.plot("  + this.AnimalID + "Feeding[\"Hour\"], " + this.AnimalID + "Feeding[\"Rewards\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Feeding by Hour(Cumulative)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Pellet drops\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Feeding/Cumulative/" + this.treatment + "/" + this.AnimalID + "CumulativeFeeding.jpg\", oreintation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");


            pythonwriter.write("" + this.AnimalID + "Feeding.to_csv(\"" + maindirectory + lastname + "/Data/Feeding/" + this.treatment + "/" + this.AnimalID + "feedingresults.csv\")\n");
            pythonwriter.write("del " + this.AnimalID + "Feeding\n");
            pythonwriter.write("del PelletDrops, PelletDropsv2\n");
            pythonwriter.write("del Name, Group\n");
            pythonwriter.write("del feedingrownumbers\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("numberofentries = " + this.AnimalID + "[\"Include: Left Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance Rev D2\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance Rev D2\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance Rev D2\"].sum()\n");
            pythonwriter.write("numberofentries = int(numberofentries)\n");
            pythonwriter.write("" + this.AnimalID + "entries = " + this.AnimalID + "[[\"Recording time\", \"Include: Left Entrance D1\", \"Include: Mid Entrance D1\", \"Include: Right Entrance D1\", \"Include: Left Entrance D2\", \"Include: Mid Entrance D2\", \"Include: Right Entrance D2\", \"Include: Left Entrance Rev D1\", \"Include: Mid Entrance Rev D1\", \"Include: Right Entrance Rev D1\", \"Include: Left Entrance Rev D2\", \"Include: Mid Entrance Rev D2\", \"Include: Right Entrance Rev D2\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entries = " + this.AnimalID + "entries[(" + this.AnimalID + "entries[\"Include: Left Entrance D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Mid Entrance D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Right Entrance D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Left Entrance D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Mid Entrance D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Right Entrance D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Left Entrance Rev D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Mid Entrance Rev D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Right Entrance Rev D1\"] == 1) | (" + this.AnimalID + "entries[\"Include: Left Entrance Rev D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Mid Entrance Rev D2\"] == 1) | (" + this.AnimalID + "entries[\"Include: Right Entrance Rev D2\"] == 1)]\n");
            pythonwriter.write(" \n");
            pythonwriter.write("IDnumberofentries = " + this.AnimalID + "[\"Include: Left Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance D1\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance D2\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance D2\"].sum()\n");
            pythonwriter.write("IDnumberofentries = int(IDnumberofentries)\n");
            pythonwriter.write("Revnumberofentries = " + this.AnimalID + "[\"Include: Left Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance Rev D1\"].sum() + " + this.AnimalID + "[\"Include: Left Entrance Rev D2\"].sum() + " + this.AnimalID + "[\"Include: Mid Entrance Rev D2\"].sum() + " + this.AnimalID + "[\"Include: Right Entrance Rev D2\"].sum()\n");
            pythonwriter.write("Revnumberofentries = int(Revnumberofentries)\n");
            pythonwriter.write(" \n");
            pythonwriter.write("del " + this.AnimalID + "\n");
            pythonwriter.write("FullEntryNumber = np.array(range(1, 6001))\n");
            pythonwriter.write("FullEntryNumber = pd.DataFrame(FullEntryNumber)\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("" + this.AnimalID + "entriesD1 = " + this.AnimalID + "entries[[\"Recording time\", \"Include: Left Entrance D1\", \"Include: Mid Entrance D1\", \"Include: Right Entrance D1\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD1 = " + this.AnimalID + "entriesD1[(" + this.AnimalID + "entriesD1[\"Recording time\"] < 86400)]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD1.columns = [\"Time\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD2 = " + this.AnimalID + "entries[[\"Recording time\", \"Include: Left Entrance D2\", \"Include: Mid Entrance D2\", \"Include: Right Entrance D2\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD2 = " + this.AnimalID + "entriesD2[(" + this.AnimalID + "entriesD2[\"Recording time\"] > 86400) & (" + this.AnimalID + "entriesD2[\"Recording time\"] < 172800)]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD2.columns = [\"Time\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("framestomergeInitial = [" + this.AnimalID + "entriesD1, " + this.AnimalID + "entriesD2]\n");

            pythonwriter.write("" + this.AnimalID + "Initial = pd.concat(framestomergeInitial)\n");
            pythonwriter.write("" + this.AnimalID + "entriesD3 = " + this.AnimalID + "entries[[\"Recording time\", \"Include: Left Entrance Rev D1\", \"Include: Mid Entrance Rev D1\", \"Include: Right Entrance Rev D1\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD3 = " + this.AnimalID + "entriesD3[(" + this.AnimalID + "entriesD3[\"Recording time\"] > 172800) & (" + this.AnimalID + "entriesD3[\"Recording time\"] < 259200)]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD3.columns = [\"Time\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD4 = " + this.AnimalID + "entries[[\"Recording time\", \"Include: Left Entrance Rev D2\", \"Include: Mid Entrance Rev D2\", \"Include: Right Entrance Rev D2\"]]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD4 = " + this.AnimalID + "entriesD4[(" + this.AnimalID + "entriesD4[\"Recording time\"] > 259200) & (" + this.AnimalID + "entriesD4[\"Recording time\"] < 345600)]\n");
            pythonwriter.write("" + this.AnimalID + "entriesD4.columns = [\"Time\", \"Left\", \"Middle\", \"Right\"]\n");

            pythonwriter.write("framestomergeReversal = [" + this.AnimalID + "entriesD3, " + this.AnimalID + "entriesD4]\n");
            pythonwriter.write("" + this.AnimalID + "Reversal = pd.concat(framestomergeReversal)\n");
            pythonwriter.write("del " + this.AnimalID + "entries, " + this.AnimalID + "entriesD1, " + this.AnimalID + "entriesD2, " + this.AnimalID + "entriesD3, " + this.AnimalID + "entriesD4\n");
            pythonwriter.write("del framestomergeInitial, framestomergeReversal\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");

            pythonwriter.write("mouseIndex = pd.concat([" + this.AnimalID + "Initial, " + this.AnimalID + "Reversal])\n");
            pythonwriter.write("mouseIndex = mouseIndex.reset_index()\n");
            pythonwriter.write("del mouseIndex[\"index\"]\n");
            pythonwriter.write("mouseIndex[\"Time\"] = SecondsToHours(mouseIndex[\"Time\"], numberofentries)\n");


            // Count independent left entries
            pythonwriter.write("Left = np.array([mouseIndex[\"Left\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] > " + h + ") & (mouseIndex[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] > 88) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            // Count independent middle entries
            pythonwriter.write("Middle = np.array([mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] > " + h + ") & (mouseIndex[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] > 88) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            // Count independent right entries
            pythonwriter.write("Right = np.array([mouseIndex[\"Right\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 1; h < 88; h++){
                int j = h + 1;
                pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] > " + h + ") & (mouseIndex[\"Time\"] < " + j + ")].sum(), ");
            }
            pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] > 88) & (mouseIndex[\"Time\"] < 89)].sum()])\n");


            // Count cumulative left entries
            pythonwriter.write("CumulativeLeft = np.array([mouseIndex[\"Left\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                if (h <= 48){
                    pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
                if (h > 48){
                    pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
            }
            pythonwriter.write("mouseIndex[\"Left\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            // Count cumulative middle entries
            pythonwriter.write("CumulativeMiddle = np.array([mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                if (h <= 48){
                    pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
                if (h > 48){
                    pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
            }
            pythonwriter.write("mouseIndex[\"Middle\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            // Count cumulative right entries
            pythonwriter.write("CumulativeRight = np.array([mouseIndex[\"Right\"][(mouseIndex[\"Time\"] < 1)].sum(), ");
            for (int h = 2; h < 89; h++){
                if (h <= 48){
                    pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
                if (h > 48){
                    pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < " + h + ")].sum(), ");
                }
            }
            pythonwriter.write("mouseIndex[\"Right\"][(mouseIndex[\"Time\"] > 48) & (mouseIndex[\"Time\"] < 89)].sum()])\n");

            pythonwriter.write("LearningIndex = np.zeros(89)\n");
            pythonwriter.write("LearningIndex = IndexFunction(Left, Middle, Right)\n");
            pythonwriter.write("LearningIndex = pd.DataFrame(LearningIndex)\n");

            pythonwriter.write("CumulativeIndex = np.zeros(89)\n");
            pythonwriter.write("CumulativeIndex = IndexFunction(CumulativeLeft, CumulativeMiddle, CumulativeRight)\n");
            pythonwriter.write("CumulativeIndex = pd.DataFrame(CumulativeIndex)\n");


            pythonwriter.write("Left = pd.DataFrame(Left)\n");
            pythonwriter.write("Middle = pd.DataFrame(Middle)\n");
            pythonwriter.write("Right = pd.DataFrame(Right)\n");
            pythonwriter.write("mouseIndex = pd.concat([Hour, Left, Middle, Right], axis=1)\n");
            pythonwriter.write("mouseIndex.columns = [\"Hour\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("del Left, Middle, Right\n");
            pythonwriter.write("Name = np.full((89), AnimalID)\n");
            pythonwriter.write("Name = pd.DataFrame(Name)\n");
            pythonwriter.write("Group = np.full((89), Treatment)\n");
            pythonwriter.write("Group = pd.DataFrame(Group)\n");


            pythonwriter.write("plt.figsize=(18, 6)\n");

            pythonwriter.write("plt.plot(mouseIndex[\"Hour\"], mouseIndex[\"Left\"], \"r-\")\n");
            pythonwriter.write("plt.plot(mouseIndex[\"Hour\"], mouseIndex[\"Middle\"], \"b-\")\n");
            pythonwriter.write("plt.plot(mouseIndex[\"Hour\"], mouseIndex[\"Right\"], \"g-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Entry Choice by Hour)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"# of entries\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([0, 25, 50, 75, 100, 125, 150, 175, 200])\n");
            pythonwriter.write("plt.legend([\"Left\", \"Middle\", \"Right\"])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Entry Choice/" + this.treatment + "/" + this.AnimalID + "EntryChoice.jpg\", orientation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");

            pythonwriter.write("mouseIndex = pd.concat([Name, Group, mouseIndex, LearningIndex], axis=1)\n");
            pythonwriter.write("mouseIndex.columns = [\"Name\", \"Group\", \"Hour\", \"Left\", \"Middle\", \"Right\", \"LearningIndex\"]\n");

            pythonwriter.write("plt.figsize=(18, 6)\n");

            pythonwriter.write("plt.plot(mouseIndex[\"Hour\"], mouseIndex[\"LearningIndex\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " (Correct entries - Incorrect entries) / Total entries)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Learning Index\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([-1.0, -0.5, 0, 0.5, 1.0])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Indexes/Independent/" + this.treatment + "/" + this.AnimalID + "IndependentIndex.jpg\", orientation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");


            pythonwriter.write("CumulativeLeft = pd.DataFrame(CumulativeLeft)\n");
            pythonwriter.write("CumulativeMiddle = pd.DataFrame(CumulativeMiddle)\n");
            pythonwriter.write("CumulativeRight = pd.DataFrame(CumulativeRight)\n");
            pythonwriter.write("mouseCumulativeIndex = pd.concat([Hour, CumulativeLeft, CumulativeMiddle, CumulativeRight], axis=1)\n");
            pythonwriter.write("mouseCumulativeIndex.columns = [\"Hour\", \"Left\", \"Middle\", \"Right\"]\n");
            pythonwriter.write("del CumulativeLeft, CumulativeMiddle, CumulativeRight\n");

            pythonwriter.write("mouseCumulativeIndex = pd.concat([Name, Group, mouseCumulativeIndex, CumulativeIndex], axis=1)\n");
            pythonwriter.write("mouseCumulativeIndex.columns = [\"Name\", \"Group\", \"Hour\", \"Left\", \"Middle\", \"Right\", \"CumulativeIndex\"]\n");

            pythonwriter.write("plt.figsize=(18, 6)\n");

            pythonwriter.write("plt.plot(mouseCumulativeIndex[\"Hour\"], mouseCumulativeIndex[\"CumulativeIndex\"], \"r-\")\n");
            pythonwriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " (Correct entries - Incorrect entries) / Total entries)\")\n");
            pythonwriter.write("plt.xlabel(\"Hour\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Learning Index\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
            pythonwriter.write("plt.yticks([-1.0, -0.5, 0, 0.5, 1.0])\n");
            pythonwriter.write("plt.savefig(\"" + maindirectory + lastname + "/Graphs/Individual mice/Indexes/Cumulative/" + this.treatment + "/" + this.AnimalID + "CumulativeIndex.jpg\", orientation=\"landscape\")\n");
            pythonwriter.write("plt.clf()\n");

            pythonwriter.write("mouseIndex.to_csv(\"" + maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Independent/" + this.treatment + "/" + this.AnimalID + "IndependentIndex.csv\")\n");
            pythonwriter.write("mouseCumulativeIndex.to_csv(\"" + maindirectory + lastname + "/Spreadsheets/Individual mice/Indexes/Cumulative/" + this.treatment + "/" + this.AnimalID + "CumulativeIndex.csv\")\n");
            pythonwriter.write("del mouseIndex, LearningIndex\n");
            pythonwriter.write("del mouseCumulativeIndex, Hour, CumulativeIndex\n");

            pythonwriter.write("\n");

            pythonwriter.write("sample = np.array(" + this.AnimalID + "Initial[\"Left\"])\n");
            pythonwriter.write("Criterions = np.zeros(IDnumberofentries)\n");
            pythonwriter.write("EditedCriterion = np.zeros(IDnumberofentries)\n");
            pythonwriter.write("movingwindow(sample, IDnumberofentries, Criterions)\n");
            pythonwriter.write("ChangedCriterion(Criterions, IDnumberofentries, EditedCriterion)\n");
            pythonwriter.write("Time = np.array(" + this.AnimalID + "Initial[\"Time\"])\n");
            pythonwriter.write("Time = pd.DataFrame(Time)\n");
            pythonwriter.write("Criterions = pd.DataFrame(Criterions)\n");
            pythonwriter.write("EditedCriterion = pd.DataFrame(EditedCriterion)\n");
            pythonwriter.write("EntryNumber = np.array(range(1, IDnumberofentries+1))\n");
            pythonwriter.write("EntryNumber = pd.DataFrame(EntryNumber)\n");
            pythonwriter.write("" + this.AnimalID + "Initial = pd.concat([Time, EntryNumber, Criterions, EditedCriterion], axis=1)\n");
            pythonwriter.write("" + this.AnimalID + "Initial.columns = [\"Time\", \"EntryNumber\", \"Criterions\", \"CriterionMet\"]\n");
            pythonwriter.write("IDETCSeventy = ETCSeventyfinder(" + this.AnimalID + "Initial[\"Criterions\"], " + this.AnimalID + "Initial[\"EntryNumber\"], IDnumberofentries)\n");
            pythonwriter.write("IDETCEighty = ETCEightyfinder(" + this.AnimalID + "Initial[\"Criterions\"], " + this.AnimalID + "Initial[\"EntryNumber\"], IDnumberofentries)\n");
            pythonwriter.write("IDETCNinety = ETCNinetyfinder(" + this.AnimalID + "Initial[\"Criterions\"],  " + this.AnimalID + "Initial[\"EntryNumber\"], IDnumberofentries)\n");
            pythonwriter.write("HourstoSeventy = HourstoCriterion(IDETCSeventy, " + this.AnimalID + "Initial[\"Time\"], 1)\n");
            pythonwriter.write("HourstoEighty = HourstoCriterion(IDETCEighty, " + this.AnimalID + "Initial[\"Time\"], 1)\n");
            pythonwriter.write("HourstoNinety = HourstoCriterion(IDETCNinety, " + this.AnimalID + "Initial[\"Time\"], 1)\n");
            pythonwriter.write("IDSeventyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(IDSeventyQualifier, IDETCSeventy)\n");
            pythonwriter.write("IDSeventyQualifier = pd.DataFrame(IDSeventyQualifier)\n");
            pythonwriter.write("IDEightyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(IDEightyQualifier, IDETCEighty)\n");
            pythonwriter.write("IDEightyQualifier = pd.DataFrame(IDEightyQualifier)\n");
            pythonwriter.write("IDNinetyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(IDNinetyQualifier, IDETCNinety)\n");
            pythonwriter.write("IDNinetyQualifier = pd.DataFrame(IDNinetyQualifier)\n");




            pythonwriter.write("Name = np.full((6000), AnimalID)\n");
            pythonwriter.write("Name = pd.DataFrame(Name)\n");
            pythonwriter.write("Group = np.full((6000), Treatment)\n");
            pythonwriter.write("Group = pd.DataFrame(Group)\n");
            pythonwriter.write(this.AnimalID + "IDETCresults = pd.DataFrame([[AnimalID, Treatment, IDETCSeventy, IDETCEighty, IDETCNinety, HourstoSeventy, HourstoEighty, HourstoNinety]], columns=np.array([\"AnimalID\", \"Treatment\", \"EntriestoSeventy\", \"EntriestoEighty\", \"EntriestoNinety\", \"HourstoSeventy\", \"HourstoEighty\", \"HourstoNinety\"]))\n");
            pythonwriter.write("del HourstoSeventy, HourstoEighty, HourstoNinety\n");
            pythonwriter.write(this.AnimalID + "IDETCresults.to_csv(\"" + maindirectory + lastname + "/Data//Entries to Criterion/Initial Discrimination/" +  this.treatment + "/" + this.AnimalID + "IDETCResults.csv\")\n");
            pythonwriter.write("del " + this.AnimalID + "IDETCresults\n");
            pythonwriter.write(this.AnimalID + "Initialv2 = pd.concat([Name, Group, FullEntryNumber, IDSeventyQualifier, IDEightyQualifier, IDNinetyQualifier], axis=1)\n");
            pythonwriter.write(this.AnimalID + "Initialv2.columns = [\"AnimalNumber\", \"Treatment\", \"EntryNumber\", \"SeventyQualifier\", \"EightyQualifier\", \"NinetyQualifier\"]  \n");
            pythonwriter.write("del IDETCSeventy, IDETCEighty, IDETCNinety\n");
            pythonwriter.write("del IDSeventyQualifier, IDEightyQualifier, IDNinetyQualifier\n");
            pythonwriter.write("" + this.AnimalID + "Initialv2.to_csv(\"" + maindirectory + lastname + "/Data/Initial Discrimination/" +  this.treatment + "/" + this.AnimalID + "totalresults.csv\")\n");
            pythonwriter.write("del sample, Criterions, EditedCriterion, Time, EntryNumber\n");
            pythonwriter.write("del " + this.AnimalID + "Initialv2\n");
            pythonwriter.write(" \n");
            pythonwriter.write(" \n");
            pythonwriter.write("sample = np.array(" + this.AnimalID + "Reversal[\"Right\"])\n");
            pythonwriter.write("Criterions = np.zeros(Revnumberofentries)\n");
            pythonwriter.write("EditedCriterion = np.zeros(Revnumberofentries)\n");
            pythonwriter.write("movingwindow(sample, Revnumberofentries, Criterions)\n");
            pythonwriter.write("ChangedCriterion(Criterions, Revnumberofentries, EditedCriterion)\n");
            pythonwriter.write("Time = np.array(" + this.AnimalID + "Reversal[\"Time\"])\n");
            pythonwriter.write("Time = pd.DataFrame(Time)\n");
            pythonwriter.write("Criterions = pd.DataFrame(Criterions)\n");
            pythonwriter.write("EditedCriterion = pd.DataFrame(EditedCriterion)\n");
            pythonwriter.write("EntryNumber = np.array(range(1, Revnumberofentries+1))\n");
            pythonwriter.write("EntryNumber = pd.DataFrame(EntryNumber)\n");
            pythonwriter.write("" + this.AnimalID + "Reversal = pd.concat([Time, EntryNumber, Criterions, EditedCriterion], axis=1)\n");
            pythonwriter.write("" + this.AnimalID + "Reversal.columns = [\"Time\", \"EntryNumber\", \"Criterions\", \"CriterionMet\"]\n");
            pythonwriter.write("RevETCSeventy = ETCSeventyfinder(" + this.AnimalID + "Reversal[\"Criterions\"], " + this.AnimalID + "Reversal[\"EntryNumber\"], Revnumberofentries)\n");
            pythonwriter.write("RevETCEighty = ETCEightyfinder(" + this.AnimalID + "Reversal[\"Criterions\"], " + this.AnimalID + "Reversal[\"EntryNumber\"], Revnumberofentries)\n");
            pythonwriter.write("RevETCNinety = ETCNinetyfinder(" + this.AnimalID + "Reversal[\"Criterions\"],  " + this.AnimalID + "Reversal[\"EntryNumber\"], Revnumberofentries)  \n");
            pythonwriter.write("HourstoSeventy = HourstoCriterion(RevETCSeventy, " + this.AnimalID + "Reversal[\"Time\"], 2)\n");
            pythonwriter.write("HourstoEighty = HourstoCriterion(RevETCEighty, " + this.AnimalID + "Reversal[\"Time\"], 2)\n");
            pythonwriter.write("HourstoNinety = HourstoCriterion(RevETCNinety, " + this.AnimalID + "Reversal[\"Time\"], 2)\n");
            pythonwriter.write("RevSeventyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(RevSeventyQualifier, RevETCSeventy)\n");

            pythonwriter.write("RevSeventyQualifier = pd.DataFrame(RevSeventyQualifier)\n");
            pythonwriter.write("RevEightyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(RevEightyQualifier, RevETCEighty)\n");

            pythonwriter.write("RevEightyQualifier = pd.DataFrame(RevEightyQualifier)\n");
            pythonwriter.write("RevNinetyQualifier = np.zeros(6000)\n");
            pythonwriter.write("Qualifier(RevNinetyQualifier, RevETCNinety)\n");

            pythonwriter.write("RevNinetyQualifier = pd.DataFrame(RevNinetyQualifier)\n");

            pythonwriter.write(this.AnimalID + "RevETCresults = pd.DataFrame([[AnimalID, Treatment, RevETCSeventy, RevETCEighty, RevETCNinety, HourstoSeventy, HourstoEighty, HourstoNinety]], columns=np.array([\"AnimalID\", \"Treatment\", \"EntriestoSeventy\", \"EntriestoEighty\", \"EntriestoNinety\", \"HourstoSeventy\", \"HourstoEighty\", \"HourstoNinety\"]))\n");
            pythonwriter.write(this.AnimalID + "RevETCresults.to_csv(\"" + maindirectory + lastname + "/Data//Entries to Criterion/Reversal/" +  this.treatment + "/" + this.AnimalID + "RevETCresutls.csv\")\n");
            pythonwriter.write("del " + this.AnimalID + "RevETCresults\n");
            pythonwriter.write("" + this.AnimalID + "Reversalv2 = pd.concat([Name, Group, FullEntryNumber, RevSeventyQualifier, RevEightyQualifier, RevNinetyQualifier], axis=1) \n");
            pythonwriter.write("" + this.AnimalID + "Reversalv2.columns = [\"AnimalNumber\", \"Treatment\", \"EntryNumber\", \"SeventyQualifier\", \"EightyQualifier\", \"NinetyQualifier\"]\n");
            pythonwriter.write("del RevETCSeventy, RevETCEighty, RevETCNinety\n");
            pythonwriter.write("del RevSeventyQualifier, RevEightyQualifier, RevNinetyQualifier\n");
            pythonwriter.write("" + this.AnimalID + "Reversalv2.to_csv(\"" + maindirectory + lastname + "/Data/Reversal/" + this.treatment + "/" + this.AnimalID + "Reversal.csv\")\n");
            pythonwriter.write(" \n");
            pythonwriter.write("del sample, Criterions, EditedCriterion, Time, EntryNumber\n");
            pythonwriter.write("del " + this.AnimalID + "Reversalv2\n");

            pythonwriter.write("del numberofentries, IDnumberofentries, Revnumberofentries\n");
            pythonwriter.write("del " + this.AnimalID + "Initial, " + this.AnimalID + "Reversal\n");
            pythonwriter.write("del FullEntryNumber\n");
            pythonwriter.write(" \n");
            pythonwriter.close();
        } catch(IOException w){
            System.out.println("Failed");
        }


    }

    public void mousePostInjection(String filestring, int linenumber, String lastname, String maindirectory, String Rscriptdirectory){
        try {
            BufferedWriter pythonwriter = new BufferedWriter(new FileWriter(Rscriptdirectory + lastname + this.AnimalID + ".py"));
            pythonwriter.write("import pandas as pd\n");
            pythonwriter.write("import numpy as np\n");
            pythonwriter.write("import matplotlib.pyplot as plt\n");
            pythonwriter.write("\n");
            pythonwriter.write("AnimalID = " + "\"" + this.AnimalID + "\"\n");
            pythonwriter.write("Treatment = " + "\"" + this.treatment + "\"\n");
            pythonwriter.write("\n");
            pythonwriter.write("mouse = pd.read_csv(\"" + filestring + "\", sep=\";\", header=" + linenumber + ", na_values=[\"-\", \"s\", \"cm\", \"cm?\", \"cm/s\"])\n");
            pythonwriter.write("mouseMov = mouse[[\"Recording time\", \"Distance moved\"]]\n");
            pythonwriter.write("mouseMov.columns = [\"Time\", \"Movement\"]\n");
            pythonwriter.write("mouseMov = mouseMov[mouseMov[\"Movement\"] >= 0.1]\n");
            pythonwriter.write("mouseMov = mouseMov[mouseMov[\"Time\"] < 6400]\n");
            pythonwriter.write("mouseMov[\"Time\"] = mouseMov[\"Time\"] / 60\n");
            pythonwriter.write("mouseShelter = mouse[[\"Recording time\", \"Shelter\"]]\n");
            pythonwriter.write("mouseShelter.columns = [\"Time\", \"Shelter\"]\n");
            pythonwriter.write("mouseShelter = mouseShelter[mouseShelter[\"Time\"] < 6400]\n");
            pythonwriter.write("mouseShelter[\"Time\"] = mouseShelter[\"Time\"] / 60\n");
            pythonwriter.write("plt.plot(mouseMov[\"Time\"], mouseMov[\"Movement\"], \"r-\")\n");
            pythonwriter.write("plt.plot(mouseShelter[\"Time\"], mouseShelter[\"Shelter\"]+3, \"r-\")\n");
            pythonwriter.write("plt.title(AnimalID + \" - \" + Treatment + \" - First Two Hours Movement and Shelter\")\n");
            pythonwriter.write("plt.xlabel(\"Minutes\", fontsize=18)\n");
            pythonwriter.write("plt.ylabel(\"Movement (cm) and Shelter time (s)\", fontsize=18)\n");
            pythonwriter.write("plt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120])\n");
            pythonwriter.write("plt.yticks([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10])\n");
            pythonwriter.write("plt.savefig(\"C:/Users/DOWEN1/Desktop/Resilience/\" + AnimalID + \"FirstTwoHoursMovementShelter.jpg\")\n");
            pythonwriter.write("plt.clf()\n");

            pythonwriter.write("del mouse, mouseMov, mouseShelter\n");
            pythonwriter.close();
        } catch(IOException w){
            System.out.println("Failed");
        }


    }

    public void IndMouseGrapher(String filestring, int linenumber, String lastname, String maindirectory, String Rscriptdirectory) {
        try {
            BufferedWriter mousewriter = new BufferedWriter(new FileWriter(Rscriptdirectory + lastname + this.AnimalID + "Grapher.py"));
            mousewriter.write("import pandas as pd\n");
            mousewriter.write("import numpy as np\n");
            mousewriter.write("import matplotlib.pyplot as plt\n");
            mousewriter.write("\n");
            mousewriter.write("def TimeArr(start, end, interval):\n");
            mousewriter.write("\ttotalelements = int((end-start+1)/interval)\n");
            mousewriter.write("\ttimearray = np.zeros(totalelements)\n");
            mousewriter.write("\tvalue = start\n");
            mousewriter.write("\tfor element in range(0, totalelements):\n");
            mousewriter.write("\t\ttimearray[element] = value\n");
            mousewriter.write("\t\tvalue = value + interval\n");
            mousewriter.write("\treturn timearray\n");
            mousewriter.write("def Movement(inputframe, outputsize, start, end, interval):\n");
            mousewriter.write("\toutputarray = np.zeros(outputsize)\n");
            mousewriter.write("\ttempmin = start-interval\n");
            mousewriter.write("\tfor x in range(0, outputsize):\n");
            mousewriter.write("\t\ttempmax = tempmin + interval\n");
            mousewriter.write("\t\toutputarray[x] = inputframe[\"Movement\"][(inputframe[\"Time\"] > tempmin) & (inputframe[\"Time\"] < tempmax)].sum()\n");
            mousewriter.write("\t\ttempmin = tempmin + interval\n");
            mousewriter.write("\treturn outputarray\n");
            mousewriter.write("\n");
            mousewriter.write("AnimalID = " + "\"" + this.AnimalID + "\"\n");
            mousewriter.write("Treatment = " + "\"" + this.treatment + "\"\n");
            mousewriter.write("\n");
            mousewriter.write("mouse = pd.read_csv(\"" + filestring + "\", sep=\";\", header=" + linenumber + ", na_values=[\"-\", \"s\", \"cm\", \"cm?\", \"cm/s\"])\n");
            mousewriter.write("mouseMov = mouse[[\"Recording time\", \"Distance moved\"]]\n");

            if (this.timetype.equalsIgnoreCase("seconds")){
                mousewriter.write("mouseMov.columns = [\"Time\", \"Movement\"]\n");
                mousewriter.write("mouseMov = mouseMov[mouseMov[\"Movement\"] >= 0.1]\n");
                mousewriter.write("MovementArray = Movement(mouseMov, int(("  + this.rangeEnd + "-" + this.rangeStart + "+1)/" + this.rangeInterval + "), " + this.rangeStart + ", " + this.rangeEnd + ", " + this.rangeInterval + ")\n");
                mousewriter.write("Time = TimeArr(" + this.rangeStart + ", " + this.rangeEnd + ", " + this.rangeInterval + ")");
                mousewriter.write("\n");
                mousewriter.write("plt.figure(figsize=(12, 6))\n");
                mousewriter.write("plt.plot(Time, MovementArray, \"r-\")\n");
                mousewriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Custom Movement\")\n");
                mousewriter.write("plt.xlabel(\"Seconds\", fontsize=18)\n");
                mousewriter.write("plt.ylabel(\"Movement (cm)\", fontsize=18)\n");
                mousewriter.write("plt.xticks([" + xticks + "])\n");
                mousewriter.write("plt.yticks([" + yticks + "])\n");
            }
            if (this.timetype.equalsIgnoreCase("minutes")){
                mousewriter.write("mouseMov.columns = [\"Time\", \"Movement\"]\n");
                mousewriter.write("mouseMov = mouseMov[mouseMov[\"Movement\"] >= 0.1]\n");
                mousewriter.write("mouseMov[\"Time\"] = mouseMov[\"Time\"] / 60\n");
                mousewriter.write("MovementArray = Movement(mouseMov, int(("  + this.rangeEnd + "-" + this.rangeStart + "+1)/" + this.rangeInterval + "), " + this.rangeStart + ", " + this.rangeEnd + ", " + this.rangeInterval + ")\n");
                mousewriter.write("Time = TimeArr(" + this.rangeStart + ", " + this.rangeEnd + ", " + this.rangeInterval + ")");
                mousewriter.write("\n");
                mousewriter.write("plt.figure(figsize=(12, 6))\n");
                mousewriter.write("plt.plot(Time, MovementArray, \"r-\")\n");
                mousewriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Custom Movement\")\n");
                mousewriter.write("plt.xlabel(\"Minutes\", fontsize=18)\n");
                mousewriter.write("plt.ylabel(\"Movement (cm)\", fontsize=18)\n");
                mousewriter.write("plt.xticks([" + xticks + "])\n");
                mousewriter.write("plt.yticks([" + yticks + "])\n");
            }
            if (this.timetype.equalsIgnoreCase("hours")){
                mousewriter.write("mouseMov.columns = [\"Time\", \"Movement\"]\n");
                mousewriter.write("mouseMov = mouseMov[mouseMov[\"Movement\"] >= 0.1]\n");
                mousewriter.write("mouseMov[\"Time\"] = mouseMov[\"Time\"] / 3600\n");
                mousewriter.write("MovementArray = Movement(mouseMov, int(("  + this.rangeEnd + "-" + this.rangeStart + "+1)/" + this.rangeInterval + "), " + this.rangeStart + ", " + this.rangeEnd + ", " + this.rangeInterval + ")\n");
                mousewriter.write("Time = TimeArr(" + this.rangeStart + ", " + this.rangeEnd + ", " + this.rangeInterval + ")");
                mousewriter.write("\n");
                mousewriter.write("plt.figure(figsize=(12, 6))\n");
                mousewriter.write("plt.plot(Time, MovementArray, \"r-\")\n");
                mousewriter.write("plt.title(\"" + this.AnimalID + " " + this.treatment + " Custom Movement\")\n");
                mousewriter.write("plt.xlabel(\"Hours\", fontsize=18)\n");
                mousewriter.write("plt.ylabel(\"Movement (cm)\", fontsize=18)\n");
                mousewriter.write("plt.xticks([" + xticks + "])\n");
                mousewriter.write("plt.yticks([" + yticks + "])\n");
            }
            mousewriter.write("plt.savefig(\""  + maindirectory + lastname + "/Graphs/" + this.AnimalID +"customMove.jpg\")\n");
            mousewriter.write("plt.clf()\n");
            mousewriter.write("");
            mousewriter.close();
        } catch (IOException t) {
            System.out.println("Could not complete");
        }

    }

    public double CalculatePercentWeightLost(){
        return (this.postweight - this.preweight) / this.preweight * 100;
    }
}



