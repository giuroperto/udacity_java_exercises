public class Game {
    Piece [][] board;
//    constructor creates an empty board
    Game() {
        board = new Piece[8][8];
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.position = new Position(3, 0);
        Position testPosition = new Position(5,4);
        if (queen.isValidMove(testPosition)) {
            System.out.println("Yes, I can move there.");
        } else {
            System.out.println("Nope, can't do!");
        }
    }
}
