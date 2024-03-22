import java.util.Scanner;

public class TicTacToe {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public TicTacToe() {
        System.out.println("Let's play some Tic Tac Toe!!");
        gameBoard = new GameBoard();
        // TODO: read player names
        // player1 starts the game
        scanner = new Scanner(System.in);

        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();

        player1 = new Player(player1Name, "X");
        player2 = new Player(player2Name, "O");
        currentPlayer = player1; // Player 1 starts the game
    }

    // NO NEED TO TOUCH startGame()
    public void startGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            gameBoard.printBoard();
            placeMove();
            if (gameBoard.checkWin()) {
                gameBoard.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                gameEnded = true;
            } else if (gameBoard.isFull()) {
                gameBoard.printBoard();
                System.out.println("The game ended in a tie!");
                gameEnded = true;
            } else {
                switchPlayers();
            }
        }
        scanner.close();
    }
    // Asks the player to place a move and checks for its validity
    private void placeMove() {
        boolean validMove = false;
        // TODO: ask the player to place a move
        // Make the move on the gameBoard
        // Check whether the move is valid, if not, ask the player to place a move again
    
        System.out.println(currentPlayer.getName() + ", please enter your move (row then column). The Rows and Columns start at zero,");
        System.out.println("(Ex. 0 0 is the top left and 2 2 is the bottom right), make sure to put a space in between each number: ");
    
        while (!validMove) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
    
            validMove = gameBoard.makeMove(row, col, currentPlayer.getSymbol());
    
            if (!validMove) {
                System.out.println("Invalid move, please try again.");
            }
        }
    }

    

    // Switch players
    // Sets the player that is not the currentPlayer as the currentPlayer
    private void switchPlayers() {
        // TODO implement
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
