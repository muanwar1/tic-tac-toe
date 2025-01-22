import java.util.Scanner;

public class Game {
    private Player player1, player2;
    private Board gameboard;
    private char currentPlayerSymbol;
    private Scanner scanner;

    public Game() {
        this.currentPlayerSymbol = 'X';
        this.player1 = new Player("", 'X');
        this.player2 = new Player("", 'O');
        this.gameboard = new Board();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        // طلب أسماء اللاعبين
        System.out.println("Enter name for Player 1 (X): ");
        String player1Name = scanner.nextLine();
        player1.setName(player1Name);

        System.out.println("Enter name for Player 2 (O): ");
        String player2Name = scanner.nextLine();
        player2.setName(player2Name);
    }

    public void switchPlayer() {
        if (currentPlayerSymbol == 'X') {
            currentPlayerSymbol = 'O';
        } else {
            currentPlayerSymbol = 'X';
        }
    }

    public boolean checkWinner() {
        // تحقق من الفائز (أفقياً وعمودياً وقطرياً)
        for (int i = 0; i < 3; i++) {
            if (gameboard.getGrid()[i][0] == currentPlayerSymbol && gameboard.getGrid()[i][1] == currentPlayerSymbol && gameboard.getGrid()[i][2] == currentPlayerSymbol) {
                return true;
            }
            if (gameboard.getGrid()[0][i] == currentPlayerSymbol && gameboard.getGrid()[1][i] == currentPlayerSymbol && gameboard.getGrid()[2][i] == currentPlayerSymbol) {
                return true;
            }
        }

        // تحقق من القطريين
        if (gameboard.getGrid()[0][0] == currentPlayerSymbol && gameboard.getGrid()[1][1] == currentPlayerSymbol && gameboard.getGrid()[2][2] == currentPlayerSymbol) {
            return true;
        }
        if (gameboard.getGrid()[0][2] == currentPlayerSymbol && gameboard.getGrid()[1][1] == currentPlayerSymbol && gameboard.getGrid()[2][0] == currentPlayerSymbol) {
            return true;
        }

        return false;
    }

    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameboard.getGrid()[i][j] == ' ') {
                    return false; // There is still an empty cell
                }
            }
        }
        return true; // All cells are filled, and no one has won
    }

    public void playGame() {
        startGame(); // Start game and take names

        while (true) {
            gameboard.displayBoard();

            int row = -1, col = -1;
            boolean validMove = false;
            while (!validMove) {
                System.out.println("Player " + currentPlayerSymbol + ", enter your move (row and column): ");
                row = scanner.nextInt();
                col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && gameboard.isCellEmpty(row, col)) {
                    validMove = true;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            gameboard.updateBoard(row, col, currentPlayerSymbol);

            if (checkWinner()) {
                gameboard.displayBoard();
                System.out.println("Player " + currentPlayerSymbol + " wins!");
                break;
            }

            if (checkDraw()) {
                gameboard.displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }
}
