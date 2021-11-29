public class Rock extends Piece {

    @Override
    boolean isValidMove(Position newPosition) {
        if (newPosition.column == position.column || newPosition.row == position.row) {
            return true;
        } else {
            return false;
        }
    }
}


//class Rock extends Piece{
//    boolean isValidMove(Position newPosition){
//        // First call the parent's method to check for the board bounds
//        if(!super.isValidMove(position)){
//            return false;
//        }
//        // If we passed the first test then check for the specific rock movement
//        if(newPosition.column == this.column && newPosition.row == this.row){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//}