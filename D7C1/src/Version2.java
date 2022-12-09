import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Version2 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
    ArrayList<String> input = new ArrayList<>();
    while (reader.ready()) {
      input.add(reader.readLine());
    }
    reader.close();

    ArrayList<Directory> directories = new ArrayList<>();
    directories.add(new Directory("/"));

    int sum = 0;

    for (String line : input) {
      if (line.charAt(0) == '$') {
        //We have a command
        if (line.charAt(2) == 'c') {
          if (line.substring(5).equals("..")) {
            sum += directories.remove(0).getSize(100000);
          } else {
            directories.add(0, new Directory(line.substring(5)));
          }
        } else if (line.charAt(2) == 'l') {
          //next lines are ls outputs
        } else {
          throw new Error("Command found but not known");
        }
      } else {
        //We have output
        if (line.substring(0, 3).equals("dir")) {
          for (Directory directory : directories) {
            if (directory.getName().equals(line.substring(5))) {
              System.out.println("FUCK");
            }
          }
          //Dir of name: line.substring(5); found, can ignore tho
        } else {
          for (Directory directory : directories) {
            directory.increaseSize(Integer.parseInt(line.split(" ")[0]));
          }
          //File of size: System.out.println(line.split(" ")[0]); found
        }
      }
    }
    System.out.println(sum);
  }
}
