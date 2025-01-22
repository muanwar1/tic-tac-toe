public class Board {
    private char[][] grid;

    public Board() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("  ___________");
        for (int i = 0; i < 3; i++) {
            System.out.print(" | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("  ___________");
    }

    public void updateBoard(int i, int j, char c) {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2)) {
            System.out.println("This cell is out of range...");
        } else if (c != 'X' && c != 'O') {
            System.out.println("Invalid symbol...");
        } else if (!isCellEmpty(i, j)) {
            System.out.println("This cell is already occupied.");
        } else {
            grid[i][j] = c;
        }
    }

    public boolean isCellEmpty(int i, int j) {
        return grid[i][j] == ' ';
    }
    public char[][] getGrid() {
        return grid;
    }
}
