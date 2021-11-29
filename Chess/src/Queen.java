public class Queen extends Piece{
    @Override
    boolean isValidMove(Position newPosition) {
        return super.isValidMove(newPosition) ?
                (canMoveDiagonally(newPosition) || canMoveStraight(newPosition)) :
                super.isValidMove(newPosition);
    }

    boolean canMoveDiagonally(Position newPosition) {
        return (Math.abs(newPosition.row - position.row)
                == Math.abs(newPosition.column - position.column));
    }

    boolean canMoveStraight(Position newPosition) {
        return (position.row == newPosition.row || position.column == newPosition.column);
    }
}
