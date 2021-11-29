public class Piece {
    Position position;

    boolean isValidMove(Position newPosition) {
        return (newPosition.row > 0 && newPosition.column > 0
                && newPosition.row < 8 && newPosition.column < 8);
    }
}
