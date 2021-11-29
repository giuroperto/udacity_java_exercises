public class Bishop extends Piece {
    @Override
    boolean isValidMove(Position newPosition) {
        if (Math.abs(position.column - newPosition.column) == Math.abs(position.row - newPosition.row)) {
            return true;
        } else {
            return false;
        }
    }
}
