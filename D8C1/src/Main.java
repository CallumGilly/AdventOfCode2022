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


    int visibleTreeCount = 0;

    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        int currentHeight = grid[row][column];
        boolean maskingTreeFound = false;
        boolean visible = false;

        //Check to see if edge
        if (row == 0 || column == 0 || row == grid.length - 1 || column == grid[row].length - 1){
          visible = true;
        }


        //Check above:
        for (int checkerRow = row - 1; checkerRow >= 0; checkerRow--) {
          if (grid[checkerRow][column] >= currentHeight) {
            System.out.println("Tree: " + row + "," + column + "(" + currentHeight + ") is hidden by: " + checkerRow + "," + column + "(" + grid[checkerRow][column] + ")");
            maskingTreeFound = true;
          }
        }
        if (!maskingTreeFound) {
          visible = true;
        }
        maskingTreeFound = false;

        //Check below:
        for (int checkerRow = row + 1; checkerRow < grid.length; checkerRow++) {
          if (grid[checkerRow][column] >= currentHeight) {
            System.out.println("Tree: " + row + "," + column + "(" + currentHeight + ") is hidden by: " + checkerRow + "," + column + "(" + grid[checkerRow][column] + ")");
            maskingTreeFound = true;
          }
        }
        if (!maskingTreeFound) {
          visible = true;
        }
        maskingTreeFound = false;

        //Check left:
        for (int checkerColumn = column - 1; checkerColumn >= 0; checkerColumn--) {
          if (grid[row][checkerColumn] >= currentHeight) {
            System.out.println("Tree: " + row + "," + column + "(" + currentHeight + ") is hidden by: " + row + "," + checkerColumn + "(" + grid[row][checkerColumn] + ")");
            maskingTreeFound = true;
          }
        }
        if (!maskingTreeFound) {
          visible = true;
        }
        maskingTreeFound = false;

        //Check right:
        for (int checkerColumn = column + 1; checkerColumn < grid[row].length; checkerColumn++) {
          if (grid[row][checkerColumn] >= currentHeight) {
            System.out.println("Tree: " + row + "," + column + "(" + currentHeight + ") is hidden by: " + row + "," + checkerColumn + "(" + grid[row][checkerColumn] + ")");
            maskingTreeFound = true;
          }
        }
        if (!maskingTreeFound) {
          visible = true;
        }
        maskingTreeFound = false;

        if (visible) {
          System.out.println("Tree: " + row + "," + column + " is visible");
          visibleTreeCount++;
        }
      }
    }

    if (0 >= 9) {
      System.out.println("Bitch please");
    }

    System.out.println(visibleTreeCount);

  }
}
