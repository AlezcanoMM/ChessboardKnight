package p3trabajo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.Info;

public class ReadFile {
    private static Info[] infos;
    
    public static Info[] Read(String dir){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(dir));
            int counter = -1;
            while (reader.ready()) {
                String line = reader.readLine();
                String[] nums = line.split(" ");
                if(counter == -1){
                    infos = new Info[Integer.parseInt(nums[0])];
                    counter++;
                    continue;
                }
                if(nums.length != 2){
                    infos[counter] = new Info(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]), Integer.parseInt(nums[3]));
                } else{
                    infos[counter] = new Info(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
                }
                counter++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Fallo al leer fichero " + dir);
        }
        return infos;
    }
    
    public static Info[][] ReadDirectory(String dir){
        final File folder = new File(dir);
        Info[][] allInfos = new Info[folder.listFiles().length][];
        int index = 0;
        for (final File file : folder.listFiles()) {
            allInfos[index] = Read(file.getAbsolutePath());
            index++;
        }
        return allInfos;
    }
}
