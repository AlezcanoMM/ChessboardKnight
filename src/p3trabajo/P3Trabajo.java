package p3trabajo;

import methods.Memoization;
import methods.Tabulation;
import model.Info;

public class P3Trabajo {

    public static void main(String[] args) {
        String file = null;
        String directory = null;
        boolean time = false;
        boolean mem = false;
        boolean tab = false;
        boolean check = false;
        double pT = 0.0;
        double pM = 0.0;
        for (int i = 0; i < args.length; i++) {
            switch(args[i]){
                case "-h":
                    ShowHelp();
                case "-check":
                    check = true;
                case "-d":
                    i++;
                    directory = args[i];
                case "-f":
                    i++;
                    file = args[i];
                case "-t":
                    time = true;
                case "-sm":
                    mem = true;
                case "-st":
                    tab = true;
                default:
                    System.out.println("Unknow switch: " + args[i]);
            }
        }
        if(file != null){
            Info[] info = ReadFile.Read(file);
            System.out.println("File: " + file + "\n");
            for (Info inf : info) {
                if(tab){
                    Tabulation tabu = new Tabulation(inf, time);
                    tabu.Start();
                    pT = tabu.GetProb();
                }
                if(mem){
                    Memoization me = new Memoization(inf, time);
                    me.Start();
                    pM = me.GetProb();
                }
                if(check){
                    Check(pT, pM);
                }
            }
        }
        if(directory != null){
            Info[][] infos = ReadFile.ReadDirectory(directory);
            System.out.println("Directory: " + directory + "\n");
            for (Info[] info : infos) {
                for (Info inf : info) {
                    if(tab){
                        Tabulation tabu = new Tabulation(inf, time);
                        tabu.Start();
                        pT = tabu.GetProb();
                    }
                    if(mem){
                        Memoization me = new Memoization(inf, time);
                        me.Start();
                        pM = me.GetProb();
                    }
                    if(check){
                        Check(pT, pM);
                    }
                }
            }
        }
    }
    
    static void ShowHelp(){
        System.out.println("usage: P3Trabajo.java [-h] [-d [DIRECTORY]] [-f [FILE]] [-t] [-sm] [-st]\n"
                         + "optional arguments:\n"
                         + "-h\t\tshow this help message and exit\n"
                         + "-d [DIRECTORY]\tdirectory (process many files)\n"
                         + "-f [FILE]\tfile (process a single file)\n"
                         + "-t\t\tDisplay time\n"
                         + "-sm\t\tSolve it with Memoization\n"
                         + "-st\t\tSolve it with Tabulation\n"
                         + "-check\t\tChecks if Tab and Mem have the same answer\n");
    }
    
    static void Check(double t, double m){
        if(t == m){
            System.out.println("The results are equal (" + t + ", " + m + ")");
        } else{
            System.out.println("WARNING The results are different (" + t + ", " + m + ")");
        }
        System.out.println("");
    }
}
