import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
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

    ArrayList<Directory> exhaustedDirectorys = new ArrayList<>();

    for (String line : input) {
      if (line.charAt(0) == '$') {
        //We have a command
        if (line.charAt(2) == 'c') {
          if (line.substring(5).equals("..")) {
            exhaustedDirectorys.add(directories.get(0));
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

    //Unwrap
    for (Directory directory : directories) {
      exhaustedDirectorys.add(directory);
    }

    Directory mostSuitableDirectory = new Directory("tempDir");
    mostSuitableDirectory.increaseSize(100000000);

    final int outerMostSize = exhaustedDirectorys.get(exhaustedDirectorys.size() - 1).size;
    System.out.println("Total file system is: " + outerMostSize);
    final int sizeToBeRemoved = (70000000 - 30000000) - (70000000 - outerMostSize);
    System.out.println("Deleted dir must be > " + sizeToBeRemoved);
    for (Directory directory : exhaustedDirectorys) {
      if ((directory.getSize() < mostSuitableDirectory.getSize())) {
      System.out.println(directory.getName() + ": " + directory.getSize());

      if (directory.getSize() > sizeToBeRemoved) {
          System.out.println("Current best directory:");
        System.out.println(directory.getName() + ": " + directory.getSize());
        System.out.println("Free space: " + (70000000 - outerMostSize - directory.getSize()) );
          System.out.println("Over by: " + (directory.getSize() - sizeToBeRemoved));
          mostSuitableDirectory = directory;
          System.out.println("New most suitable directory is: "+ mostSuitableDirectory.getName()+"\n\n\n");
        }
      }
    }

    System.out.println(mostSuitableDirectory.getName());
  }
}
