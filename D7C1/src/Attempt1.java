import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Attempt1 {
  //THIS CODE DOES NOT WORK, USE VERSION 2
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("smallInput.txt"));
    ArrayList<String> input = new ArrayList<>();
    while (reader.ready()) {
      input.add(reader.readLine());
    }
    reader.close();
    int sum = 0;
    HashMap<String, Integer> directorySizes = new HashMap<>();
    ArrayList<String> currentDirectorys = new ArrayList<>();
    ArrayList<String> expectedDirectorys = new ArrayList<>();
    for (String line : input) {
      if (line.charAt(0) == '$') {
        //We have a command
        if (line.charAt(2) == 'c') {
          if (line.substring(5).equals("..")) {
            try {
              if (directorySizes.get(currentDirectorys.get(0)) <= 100000) {
                sum += directorySizes.get(currentDirectorys.get(0));
              }
              directorySizes.remove(currentDirectorys.get(0));
              currentDirectorys.remove(0);
            } catch (Exception ex) {
              System.out.println("Some error on dir:" +currentDirectorys.get(0));
            }
          } else {
            currentDirectorys.add(0,line.substring(5));
          }
        } else if (line.charAt(2) == 'l') {
          //Don't need to care
        } else {
          throw new Error("Command found but not known");
        }
      } else {
        //We have output
        if (line.substring(0,3).equals("dir")) {
          expectedDirectorys.add(line.substring(5));

          //We don't need to care
        } else {
          System.out.println(line.split(" ")[0]);

          for (String dir : currentDirectorys) {
            directorySizes.put(dir, directorySizes.getOrDefault(dir,0) + Integer.parseInt(line.split(" ")[0]));
          }
        }
      }
    }

//    directorySizes.remove("/");

    System.out.println(sum);

  }
}
