import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(args[0]));
    ArrayList<String> input = new ArrayList<>();
    while (reader.ready()) {
      input.add(reader.readLine());
    }
    reader.close();

    //Define an x,y grid and populate it
    int[][] grid = new int[input.get(0).length()][input.size()];

    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        grid[row][column] =  input.get(row).charAt(column) - 48;
      }
    }

    String gridRef = "d";
    int bestScenicScore = 0;

    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {

        System.out.println(row + "," + column + ":");

        int currentHeight = grid[row][column];
        int scenicScore = 1;

        if (row == 0 || column == 0 || row == grid.length - 1 || column == grid[row].length - 1){
          scenicScore = 0;
          System.out.println("Edge");
        } else {

          int scenicMultiplier = 1;

          //Check above:
          for (int checkerRow = row - 1; checkerRow >= 1; checkerRow--) {
            if (grid[checkerRow][column] >= currentHeight) {
              break;
            } else {
              scenicMultiplier++;
            }
          }
          scenicScore *= scenicMultiplier;
          System.out.println("Can see " + scenicMultiplier + " trees above");
          scenicMultiplier = 1;

          //Check below:
          for (int checkerRow = row + 1; checkerRow < grid.length - 1; checkerRow++) {
            if (grid[checkerRow][column] >= currentHeight) {
              break;
            } else {
              scenicMultiplier++;
            }
          }
          scenicScore *= scenicMultiplier;
          System.out.println("Can see " + scenicMultiplier + " trees below");
          scenicMultiplier = 1;


          //Check left:
          for (int checkerColumn = column - 1; checkerColumn >= 1; checkerColumn--) {
            if (grid[row][checkerColumn] >= currentHeight) {
              break;
            } else {
              scenicMultiplier++;
            }
          }
          scenicScore *= scenicMultiplier;
          System.out.println("Can see " + scenicMultiplier + " trees left");
          scenicMultiplier = 1;

          //Check right:
          for (int checkerColumn = column + 1; checkerColumn < grid[row].length - 1; checkerColumn++) {
            if (grid[row][checkerColumn] >= currentHeight) {
              break;
            } else {
              scenicMultiplier++;
            }
          }
          scenicScore *= scenicMultiplier;
          System.out.println("Can see " + scenicMultiplier + " trees right");
          scenicMultiplier = 1;
          System.out.println(scenicScore);
        }
        if (bestScenicScore < scenicScore) {
          gridRef = row + "," + column;
          bestScenicScore = scenicScore;
        }
      }
    }

    if (0 >= 9) {
      System.out.println("Bitch please");
    }

    System.out.println(gridRef);
    System.out.println(bestScenicScore);

  }
}
