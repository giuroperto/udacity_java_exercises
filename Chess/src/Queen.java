public class Queen extends Piece{
    @Override
    boolean isValidMove(Position newPosition) {
        if (canMoveDiagonally(newPosition) || canMoveStraight(newPosition)) {
            return true;
        } else {
            return false;
        }
    }

    boolean canMoveDiagonally(Position newPosition) {
        if (Math.abs(newPosition.row - position.row) == Math.abs(newPosition.column - position.column)) {
            return true;
        } else {
            return false;
        }
    }

    boolean canMoveStraight(Position newPosition) {
        if (position.row == newPosition.row || position.column == newPosition.column) {
            return true;
        } else {
            return false;
        }
    }
}
