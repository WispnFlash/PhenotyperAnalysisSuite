import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cohort {
    public String cohortname;
    public int criterionUsed;
    private int numberofgroups;
    public ArrayList<Treatment> cohort = new ArrayList<Treatment>();
    public String graphlocation;
    private String graphdirectory = "C:/Users/DOWEN1/Desktop/";

    private String Survxlimit = "(0, 2000)";
    private String Survylimit = "(1, 100)";
    private String Survxticks = "(0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000)";
    private String Survyticks = "(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100)";
    private String SurvMargins = "(5, 5, 5, 5)";
    private String SurvWidth = "700";
    private String SurvHeight= "500";
    private String SurvLineWidth = "3";

    private String Movxlimit = "(0, 92)";
    private String Movylimit = "(0, 25000)";
    private String Movxticks = "0, 10, 20, 30, 40, 50, 60, 70, 80, 90";
    private String Movyticks = "0, 2500, 5000, 7500, 10000, 12500, 15000, 17500, 20000, 22500, 25000";
    private String MovMargins = "(5, 10, 5, 5)";
    private String MovWidth = "1200";
    private String MovHeight= "600";
    private String MovLineWidth = "3";

    private String Fedxlimit = "(0, 92)";
    private String Fedylimitv2 = "(0, 700)";
    private String Fedylimit = "(0, 50)";
    private String Fedxticks = "(0, 10, 20, 30, 40, 50, 60, 70, 80, 90)";
    private String Fedyticksv2 = "(0, 100, 200, 300, 400, 500, 600, 700)";
    private String Fedyticks = "(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50)";
    private String FedMargins = "(5, 10, 5, 5)";
    private String FedWidth = "1200";
    private String FedHeight= "600";
    private String FedLineWidth = "3";

    private String Indexxlimit = "(0, 92)";
    private String Indexylimit = "(-1, 1)";
    private String Indexxticks = "0, 10, 20, 30, 40, 50, 60, 70, 80, 90";
    private String Indexyticks = "-1, -0.75, -0.5, -0.25, 0, 0.25, 0.5, 0.75, 1";
    private String IndexMargins = "(5, 10, 5, 5)";
    private String IndexWidth = "1200";
    private String IndexHeight= "600";
    private String IndexLineWidth = "3";

    private String titlelabelsize = "20";
    private String xlabelsize = "16";
    private String ylabelsize = "16";


    public void GraphIDCohortPy(int number, String maindirectory, String Rscriptdirectory, String lastname, String color1, String color2, String color3, String color4, String color5, String color6) {
        if (this.criterionUsed == 70) {
            switch (number) {
                case 1:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 2:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 3:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Seventy\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 4:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Seventy\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Seventy\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 5:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Seventy\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Seventy\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Seventy\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 6:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + ", " + this.cohort.get(5).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(5).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(5).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Seventy\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Seventy\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Seventy\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(5).group + "[\"Entry\"][0:2000], " + this.cohort.get(5).group + "[\"Seventy\"][0:2000], \"" + color6 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\", \"" + this.cohort.get(5).group + " (n=" + this.cohort.get(5).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;

            }
        }

        if (this.criterionUsed == 80) {
            switch (number) {
                case 1:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 2:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 3:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Eighty\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 4:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Eighty\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Eighty\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 5:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Eighty\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Eighty\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Eighty\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 6:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + ", " + this.cohort.get(5).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(5).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(5).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Eighty\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Eighty\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Eighty\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(5).group + "[\"Entry\"][0:2000], " + this.cohort.get(5).group + "[\"Eighty\"][0:2000], \"" + color6 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\", \"" + this.cohort.get(5).group + " (n=" + this.cohort.get(5).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;

            }
        }

        if (this.criterionUsed == 90) {
            switch (number) {
                case 1:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "|)\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 2:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 3:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Ninety\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 4:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Ninety\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Ninety\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 5:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Ninety\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Ninety\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Ninety\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 6:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/ID90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + ", " + this.cohort.get(5).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "InitialSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(5).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(5).group + "InitialSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Ninety\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Ninety\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Ninety\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(5).group + "[\"Entry\"][0:2000], " + this.cohort.get(5).group + "[\"Ninety\"][0:2000], \"" + color6 + "\")\n");
                        writer3.write("\tplt.title(\"Initial Discrimination 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\", \"" + this.cohort.get(5).group + " (n=" + this.cohort.get(5).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;

            }
        }
    }

    public void GraphRevCohortPy(int number, String maindirectory, String Rscriptdirectory, String lastname, String color1, String color2, String color3, String color4, String color5, String color6) {
        if (this.criterionUsed == 70) {
            switch (number) {
                case 1:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 2:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 3:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Seventy\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 4:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Seventy\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Seventy\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(|" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 5:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Seventy\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Seventy\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Seventy\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 6:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev70crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + ", " + this.cohort.get(5).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(5).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(5).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Seventy\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Seventy\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Seventy\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Seventy\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Seventy\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(5).group + "[\"Entry\"][0:2000], " + this.cohort.get(5).group + "[\"Seventy\"][0:2000], \"" + color6 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 70% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\", \"" + this.cohort.get(5).group + " (n=" + this.cohort.get(5).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;

            }
        }

        if (this.criterionUsed == 80) {
            switch (number) {
                case 1:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 2:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 3:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Eighty\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 4:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Eighty\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Eighty\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 5:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Eighty\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Eighty\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Eighty\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 6:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev80crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + ", " + this.cohort.get(5).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(5).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(5).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Eighty\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Eighty\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Eighty\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Eighty\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Eighty\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(5).group + "[\"Entry\"][0:2000], " + this.cohort.get(5).group + "[\"Eighty\"][0:2000], \"" + color6 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 80% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\", \"" + this.cohort.get(5).group + " (n=" + this.cohort.get(5).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;

            }
        }

        if (this.criterionUsed == 90) {
            switch (number) {
                case 1:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 2:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 3:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Ninety\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 4:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Ninety\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Ninety\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 5:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Ninety\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Ninety\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Ninety\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();

                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;
                case 6:
                    try {

                        BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                        this.graphlocation = maindirectory + lastname + "/Graphs/Rev90crit.jpg";
                        writer3.write("\n");
                        writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + ", " + this.cohort.get(5).group + "]\n");
                        writer3.write("\n");
                        writer3.write("value = 0\n");
                        writer3.write("\n");
                        writer3.write("if __name__ == \'__main__\':\n");
                        writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                        writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                        writer3.write("\t\tpool.close()\n");
                        writer3.write("\t\tpool.join()\n");
                        writer3.write("\t\tvalue = 1\n");
                        writer3.write("\n");
                        writer3.write("if (value == 1):\n");
                        writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\t" + this.cohort.get(5).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(5).group + "ReversalSurvival.csv\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Entry\"][0:2000], " + this.cohort.get(0).group + "[\"Ninety\"][0:2000], \"" + color1 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Entry\"][0:2000], " + this.cohort.get(1).group + "[\"Ninety\"][0:2000], \"" + color2 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Entry\"][0:2000], " + this.cohort.get(2).group + "[\"Ninety\"][0:2000], \"" + color3 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Entry\"][0:2000], " + this.cohort.get(3).group + "[\"Ninety\"][0:2000], \"" + color4 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Entry\"][0:2000], " + this.cohort.get(4).group + "[\"Ninety\"][0:2000], \"" + color5 + "\")\n");
                        writer3.write("\tplt.plot(" + this.cohort.get(5).group + "[\"Entry\"][0:2000], " + this.cohort.get(5).group + "[\"Ninety\"][0:2000], \"" + color6 + "\")\n");
                        writer3.write("\tplt.title(\"Reversal 90% criterion\", fontsize=" + this.titlelabelsize + ")\n");
                        writer3.write("\tplt.xlabel(\"Entry Number\", fontsize=" + this.xlabelsize + ")\n");
                        writer3.write("\tplt.ylabel(\"% of mice that reached criterion\", fontsize=" + this.ylabelsize + ")\n");
                        writer3.write("\tplt.xticks([0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000])\n");
                        writer3.write("\tplt.yticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100])\n");
                        writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\", \"" + this.cohort.get(5).group + " (n=" + this.cohort.get(5).groupsize + ")\"])\n");
                        writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                        writer3.write("\tplt.show()\n");
                        writer3.close();


                    } catch (IOException h) {
                        System.out.println("File input/output error in IDC Part 70!");
                    }
                    break;

            }
        }
    }



    public void GraphMovCohortPy(int number, String maindirectory, String Rscriptdirectory, String lastname, String color1, String color2, String color3, String color4, String color5, String color6) {

        switch (number) {
            case 1:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/distancemoved.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "movement.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Distance moved\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.title(\"Total Distance moved by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Distance moved (cm)\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 2500, 5000, 7500, 10000, 12500, 15000, 17500, 20000, 22500, 25000])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();


                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 2:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/distancemoved.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "movement.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Distance moved\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Distance moved\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.title(\"Total Distance moved by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Distance moved (cm)\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 2500, 5000, 7500, 10000, 12500, 15000, 17500, 20000, 22500, 25000])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 3:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/distancemoved.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "movement.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Distance moved\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Distance moved\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"Distance moved\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.title(\"Total Distance moved by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Distance moved (cm)\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 2500, 5000, 7500, 10000, 12500, 15000, 17500, 20000, 22500, 25000])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 4:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/distancemoved.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "movement.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Distance moved\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Distance moved\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"Distance moved\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Hour\"], " + this.cohort.get(3).group + "[\"Distance moved\"], \"" + color4 + "\")\n");
                    writer3.write("\tplt.title(\"Total Distance moved by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Distance moved (cm)\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 2500, 5000, 7500, 10000, 12500, 15000, 17500, 20000, 22500, 25000])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 5:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/distancemoved.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "movement.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Distance moved\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Distance moved\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"Distance moved\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Hour\"], " + this.cohort.get(3).group + "[\"Distance moved\"], \"" + color4 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Hour\"], " + this.cohort.get(4).group + "[\"Distance moved\"], \"" + color5 + "\")\n");
                    writer3.write("\tplt.title(\"Total Distance moved by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Distance moved (cm)\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 2500, 5000, 7500, 10000, 12500, 15000, 17500, 20000, 22500, 25000])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 6:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/distancemoved.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + ", " + this.cohort.get(5).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "movement.csv\")\n");
                    writer3.write("\t" + this.cohort.get(5).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(5).group + "movement.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Distance moved\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Distance moved\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"Distance moved\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Hour\"], " + this.cohort.get(3).group + "[\"Distance moved\"], \"" + color4 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Hour\"], " + this.cohort.get(4).group + "[\"Distance moved\"], \"" + color5 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(5).group + "[\"Hour\"], " + this.cohort.get(5).group + "[\"Distance moved\"], \"" + color6 + "\")\n");
                    writer3.write("\tplt.title(\"Total Distance moved by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Distance moved (cm)\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 2500, 5000, 7500, 10000, 12500, 15000, 17500, 20000, 22500, 25000])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\", \"" + this.cohort.get(5).group + " (n=" + this.cohort.get(5).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;

        }
    }

    public void GraphFeedingCohortPy(int number, String maindirectory, String Rscriptdirectory, String lastname, String color1, String color2, String color3, String color4, String color5, String color6) {

        switch (number) {
            case 1:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "feeding.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Feeding\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.title(\"Total Feeding by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Pellet Drops\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();


                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 2:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "feeding.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Feeding\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Feeding\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.title(\"Total Feeding by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Pellet Drops\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 3:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "feeding.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Feeding\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Feeding\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"Feeding\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.title(\"Total Feeding by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Pellet Drops\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 4:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "feeding.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Feeding\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Feeding\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"Feeding\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Hour\"], " + this.cohort.get(3).group + "[\"Feeding\"], \"" + color4 + "\")\n");
                    writer3.write("\tplt.title(\"Total Feeding by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Pellet Drops\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 5:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "feeding.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Feeding\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Feeding\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"Feeding\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Hour\"], " + this.cohort.get(3).group + "[\"Feeding\"], \"" + color4 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Hour\"], " + this.cohort.get(4).group + "[\"Feeding\"], \"" + color5 + "\")\n");
                    writer3.write("\tplt.title(\"Total Feeding by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Pellet Drops\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 6:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + ", " + this.cohort.get(5).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "feeding.csv\")\n");
                    writer3.write("\t" + this.cohort.get(5).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(5).group + "feeding.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"Feeding\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"Feeding\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"Feeding\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Hour\"], " + this.cohort.get(3).group + "[\"Feeding\"], \"" + color4 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Hour\"], " + this.cohort.get(4).group + "[\"Feeding\"], \"" + color5 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(5).group + "[\"Hour\"], " + this.cohort.get(5).group + "[\"Feeding\"], \"" + color6 + "\")\n");
                    writer3.write("\tplt.title(\"Total Feeding by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Pellet Drops\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\", \"" + this.cohort.get(5).group + " (n=" + this.cohort.get(5).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;

        }
    }



    public void GraphFeedingCohort(int number, String maindirectory, String Rscriptdirectory, String lastname, String color1, String color2, String color3, String color4, String color5, String color6) {

        switch (number) {
            case 1:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = c" + Fedylimit + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticks + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");

                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\"), col=c(\"" + color1 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 2:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = c" + Fedylimit + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticks + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$TotFeeding, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 3:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = c" + Fedylimit + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticks + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$TotFeeding, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(2).group + "$Hour, " + this.cohort.get(2).group + "$TotFeeding, col = \"" + color3 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\", \"" + this.cohort.get(2).group + " (" + this.cohort.get(2).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\", \"" + color3 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 4:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = c" + Fedylimit + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticks + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$TotFeeding, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(2).group + "$Hour, " + this.cohort.get(2).group + "$TotFeeding, col = \"" + color3 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(3).group + "$Hour, " + this.cohort.get(3).group + "$TotFeeding, col = \"" + color4 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\", \"" + this.cohort.get(2).group + " (" + this.cohort.get(2).groupsize + ")" + "\", \"" + this.cohort.get(3).group + " (" + this.cohort.get(3).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\", \"" + color3 + "\", \"" + color4 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 5:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = c" + Fedylimit + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticks + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$TotFeeding, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(2).group + "$Hour, " + this.cohort.get(2).group + "$TotFeeding, col = \"" + color3 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(3).group + "$Hour, " + this.cohort.get(3).group + "$TotFeeding, col = \"" + color4 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(4).group + "$Hour, " + this.cohort.get(4).group + "$TotFeeding, col = \"" + color5 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\", \"" + this.cohort.get(2).group + " (" + this.cohort.get(2).groupsize + ")" + "\", \"" + this.cohort.get(3).group + " (" + this.cohort.get(3).groupsize + ")" + "\", \"" + this.cohort.get(4).group + " (" + this.cohort.get(4).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\", \"" + color3 + "\", \"" + color4 + "\", \"" + color5 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 6:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feeding.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = c" + Fedylimit + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding\", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 2, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticks + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$TotFeeding, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$TotFeeding, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(2).group + "$Hour, " + this.cohort.get(2).group + "$TotFeeding, col = \"" + color3 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(3).group + "$Hour, " + this.cohort.get(3).group + "$TotFeeding, col = \"" + color4 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(4).group + "$Hour, " + this.cohort.get(4).group + "$TotFeeding, col = \"" + color5 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(5).group + "$Hour, " + this.cohort.get(5).group + "$TotFeeding, col = \"" + color6 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\", \"" + this.cohort.get(2).group + " (" + this.cohort.get(2).groupsize + ")" + "\", \"" + this.cohort.get(3).group + " (" + this.cohort.get(3).groupsize + ")" + "\", \"" + this.cohort.get(4).group + " (" + this.cohort.get(4).groupsize + ")" + "\", \"" + this.cohort.get(5).group + " (" + this.cohort.get(5).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\", \"" + color3 + "\", \"" + color4 + "\", \"" + color5 + "\", \"" + color6 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;

        }
    }

    public void GraphFeedingCohortv2(int number, String maindirectory, String Rscriptdirectory, String lastname, String color1, String color2, String color3, String color4, String color5, String color6) {

        switch (number) {
            case 1:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feedingv2.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = " + Fedylimitv2 + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticksv2 + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");

                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\"), col=c(\"" + color1 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 2:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feedingv2.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = " + Fedylimitv2 + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticksv2 + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$Rewards, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 3:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feedingv2.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = " + Fedylimitv2 + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticksv2 + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$Rewards, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(2).group + "$Hour, " + this.cohort.get(2).group + "$Rewards, col = \"" + color3 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\", \"" + this.cohort.get(2).group + " (" + this.cohort.get(2).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\", \"" + color3 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 4:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feedingv2.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = " + Fedylimitv2 + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticksv2 + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$Rewards, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(2).group + "$Hour, " + this.cohort.get(2).group + "$Rewards, col = \"" + color3 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(3).group + "$Hour, " + this.cohort.get(3).group + "$Rewards, col = \"" + color4 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\", \"" + this.cohort.get(2).group + " (" + this.cohort.get(2).groupsize + ")" + "\", \"" + this.cohort.get(3).group + " (" + this.cohort.get(3).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\", \"" + color3 + "\", \"" + color4 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 5:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feedingv2.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = " + Fedylimitv2 + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding \", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 1.5, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticksv2 + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$Rewards, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(2).group + "$Hour, " + this.cohort.get(2).group + "$Rewards, col = \"" + color3 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(3).group + "$Hour, " + this.cohort.get(3).group + "$Rewards, col = \"" + color4 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(4).group + "$Hour, " + this.cohort.get(4).group + "$Rewards, col = \"" + color5 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\", \"" + this.cohort.get(2).group + " (" + this.cohort.get(2).groupsize + ")" + "\", \"" + this.cohort.get(3).group + " (" + this.cohort.get(3).groupsize + ")" + "\", \"" + this.cohort.get(4).group + " (" + this.cohort.get(4).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\", \"" + color3 + "\", \"" + color4 + "\", \"" + color5 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 6:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.r", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/feedingv2.jpg";
                    writer3.write("jpeg(file=\"" + this.graphlocation + "\", \n");
                    writer3.write("     width=" + FedWidth + ",\n");
                    writer3.write("     height=" + FedHeight + ",\n");
                    writer3.write("     units=\"px\")\n");
                    writer3.write(" \n");
                    writer3.write("par(mar=c" + FedMargins + ")\n");
                    writer3.write(" \n");
                    writer3.write("plot(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, \n");
                    writer3.write("     type = \"l\",\n");
                    writer3.write("     ann = FALSE,\n");
                    writer3.write("     col = \"" + color1 + "\",\n");
                    writer3.write("     xlim = c" + Fedxlimit + ",\n");
                    writer3.write("     ylim = " + Fedylimitv2 + ",\n");
                    writer3.write("     xaxt = \"n\",\n");
                    writer3.write("     yaxt = \"n\" \n");
                    writer3.write(" \n");
                    writer3.write(" \n");
                    writer3.write(")\n");
                    writer3.write("title(main = \"Feeding\", line = 1.0, cex.main = 2.0)\n");
                    writer3.write("title(ylab = \"pellet drops\", line = 6.0, cex.lab = 2.3)\n");
                    writer3.write("title(xlab = \"Hour\", line = 3.0, cex.lab = 2.3)\n");
                    writer3.write(" \n");
                    writer3.write("axis(side = 1, at = c" + Fedxticks + ", font = 2, font.lab = 2, cex.axis = 1.50)\n");
                    writer3.write("axis(side = 2, at = c" + Fedyticksv2 + ", font = 2, font.lab = 2, cex.axis = 1.50, las = 1)\n");
                    writer3.write(" \n");
                    writer3.write("lines(" + this.cohort.get(0).group + "$Hour, " + this.cohort.get(0).group + "$Rewards, col = \"" + color1 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(1).group + "$Hour, " + this.cohort.get(1).group + "$Rewards, col = \"" + color2 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(2).group + "$Hour, " + this.cohort.get(2).group + "$Rewards, col = \"" + color3 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(3).group + "$Hour, " + this.cohort.get(3).group + "$Rewards, col = \"" + color4 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(4).group + "$Hour, " + this.cohort.get(4).group + "$Rewards, col = \"" + color5 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("lines(" + this.cohort.get(5).group + "$Hour, " + this.cohort.get(5).group + "$Rewards, col = \"" + color6 + "\", lwd=" + FedLineWidth + ")\n");
                    writer3.write("legend(\"topright\", legend=c(\"" + this.cohort.get(0).group + " (" + this.cohort.get(0).groupsize + ")" + "\", \"" + this.cohort.get(1).group + " (" + this.cohort.get(1).groupsize + ")" + "\", \"" + this.cohort.get(2).group + " (" + this.cohort.get(2).groupsize + ")" + "\", \"" + this.cohort.get(3).group + " (" + this.cohort.get(3).groupsize + ")" + "\", \"" + this.cohort.get(4).group + " (" + this.cohort.get(4).groupsize + ")" + "\", \"" + this.cohort.get(5).group + " (" + this.cohort.get(5).groupsize + ")" + "\"), col=c(\"" + color1 + "\", \"" + color2 + "\", \"" + color3 + "\", \"" + color4 + "\", \"" + color5 + "\", \"" + color6 + "\"), lty=1, cex=1.5, lwd=" + FedLineWidth + ")\n");
                    writer3.write(" \n");
                    writer3.write("dev.off()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;

        }
    }



    public void GraphIndexCohortPy(int number, String maindirectory, String Rscriptdirectory, String lastname, String color1, String color2, String color3, String color4, String color5, String color6) {

        switch (number) {
            case 1:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/index.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "index.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"CumulativeIndex\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.title(\"Cumulative Learning Index by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Cumulative Index\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([-1, -0.75, -0.50, -0.25, 0, 0.25, 0.50, 0.75, 1])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();


                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 2:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/index.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "index.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"CumulativeIndex\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"CumulativeIndex\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.title(\"Cumulative Learning Index by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Cumulative Index\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([-1, -0.75, -0.50, -0.25, 0, 0.25, 0.50, 0.75, 1])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 3:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/index.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "index.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"CumulativeIndex\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"CumulativeIndex\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"CumulativeIndex\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.title(\"Cumulative Learning Index by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Cumulative Index\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([-1, -0.75, -0.50, -0.25, 0, 0.25, 0.50, 0.75, 1])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 4:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/index.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "index.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"CumulativeIndex\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"CumulativeIndex\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"CumulativeIndex\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Hour\"], " + this.cohort.get(3).group + "[\"CumulativeIndex\"], \"" + color4 + "\")\n");
                    writer3.write("\tplt.title(\"Cumulative Learning Index by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Cumulative Index\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([-1, -0.75, -0.50, -0.25, 0, 0.25, 0.50, 0.75, 1])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 5:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/index.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "index.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"CumulativeIndex\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"CumulativeIndex\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"CumulativeIndex\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Hour\"], " + this.cohort.get(3).group + "[\"CumulativeIndex\"], \"" + color4 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Hour\"], " + this.cohort.get(4).group + "[\"CumulativeIndex\"], \"" + color5 + "\")\n");
                    writer3.write("\tplt.title(\"Cumulative Learning Index by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Cumulative Index\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([-1, -0.75, -0.50, -0.25, 0, 0.25, 0.50, 0.75, 1])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;
            case 6:
                try {

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter(Rscriptdirectory + "CohortGrapher.py", true));
                    this.graphlocation = maindirectory + lastname + "/Graphs/index.jpg";
                    writer3.write("\n");
                    writer3.write("grouplist = [" + this.cohort.get(0).group + ", " + this.cohort.get(1).group + ", " + this.cohort.get(2).group + ", " + this.cohort.get(3).group + ", " + this.cohort.get(4).group + ", " + this.cohort.get(5).group + "]\n");
                    writer3.write("\n");
                    writer3.write("value = 0\n");
                    writer3.write("\n");
                    writer3.write("if __name__ == \'__main__\':\n");
                    writer3.write("\twith mp.Pool(processes=4) as pool:\n");
                    writer3.write("\t\tpool.map_async(CriterionReached, grouplist)\n");
                    writer3.write("\t\tpool.close()\n");
                    writer3.write("\t\tpool.join()\n");
                    writer3.write("\t\tvalue = 1\n");
                    writer3.write("\n");
                    writer3.write("if (value == 1):\n");
                    writer3.write("\t" + this.cohort.get(0).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(0).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(1).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(1).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(2).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(2).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(3).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(3).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(4).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(4).group + "index.csv\")\n");
                    writer3.write("\t" + this.cohort.get(5).group + " = pd.read_csv(\"" + maindirectory + "Temp/" + this.cohort.get(5).group + "index.csv\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(0).group + "[\"Hour\"], " + this.cohort.get(0).group + "[\"CumulativeIndex\"], \"" + color1 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(1).group + "[\"Hour\"], " + this.cohort.get(1).group + "[\"CumulativeIndex\"], \"" + color2 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(2).group + "[\"Hour\"], " + this.cohort.get(2).group + "[\"CumulativeIndex\"], \"" + color3 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(3).group + "[\"Hour\"], " + this.cohort.get(3).group + "[\"CumulativeIndex\"], \"" + color4 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(4).group + "[\"Hour\"], " + this.cohort.get(4).group + "[\"CumulativeIndex\"], \"" + color5 + "\")\n");
                    writer3.write("\tplt.plot(" + this.cohort.get(5).group + "[\"Hour\"], " + this.cohort.get(5).group + "[\"CumulativeIndex\"], \"" + color6 + "\")\n");
                    writer3.write("\tplt.title(\"Cumulative Learning Index by Hour\", fontsize=" + this.titlelabelsize + ")\n");
                    writer3.write("\tplt.xlabel(\"Hour\", fontsize=" + this.xlabelsize + ")\n");
                    writer3.write("\tplt.ylabel(\"Cumulative Index\", fontsize=" + this.ylabelsize + ")\n");
                    writer3.write("\tplt.xticks([0, 10, 20, 30, 40, 50, 60, 70, 80, 90])\n");
                    writer3.write("\tplt.yticks([-1, -0.75, -0.50, -0.25, 0, 0.25, 0.50, 0.75, 1])\n");
                    writer3.write("\tplt.legend([\"" + this.cohort.get(0).group + " (n=" + this.cohort.get(0).groupsize + ")\", \"" + this.cohort.get(1).group + " (n=" + this.cohort.get(1).groupsize + ")\", \"" + this.cohort.get(2).group + " (n=" + this.cohort.get(2).groupsize + ")\", \"" + this.cohort.get(3).group + " (n=" + this.cohort.get(3).groupsize + ")\", \"" + this.cohort.get(4).group + " (n=" + this.cohort.get(4).groupsize + ")\", \"" + this.cohort.get(5).group + " (n=" + this.cohort.get(5).groupsize + ")\"])\n");
                    writer3.write("\tplt.savefig(\"" + this.graphlocation + "\")\n");
                    writer3.write("\tplt.show()\n");
                    writer3.close();

                } catch (IOException h) {
                    System.out.println("File input/output error in IDC Part 70!");
                }
                break;

        }
    }









}