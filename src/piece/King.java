package src.piece;

import src.board.Board;
import src.move.Move;

import java.awt.image.BufferedImage;

public class King extends Piece{

    public King(Board board, int col, int row, boolean isWhite) {
        super(board);

        this.setCol(col);
        this.setxPos(col * board.tileSize);

        this.setRow(row);
        this.setyPos(row * board.tileSize);

        this.setIsWhite(isWhite);
        this.setName("King");

        this.setSprite(sheet.getSubimage(0, isWhite ? 0 : sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH));
    }

    @Override
    public boolean isValidMovement(int col, int row) {
        return Math.abs((col - this.getCol()) * (row - this.getRow()))  == 1 || Math.abs(col - this.getCol()) + Math.abs(row - this.getRow()) == 1 || canCastle(col, row);
    }

    private boolean canCastle(int col, int row){

        if(this.getRow() == row){
            if(col == 6){
                Piece rook = getBoard().getPieceByPos(7, row);
                if(rook != null && rook.isFirstMove() && isFirstMove()) {
                    return  getBoard().getPieceByPos(5,row) == null &&
                            getBoard().getPieceByPos(6,row) == null &&
                            !getBoard().checkScanner.isKingChecked(new Move(getBoard(), this, 5, row));

                }
            }
            else if(col == 2){
                Piece rook = getBoard().getPieceByPos(0, row);
                if(rook != null && rook.isFirstMove() && isFirstMove()) {
                    return  getBoard().getPieceByPos(3,row) == null &&
                            getBoard().getPieceByPos(2,row) == null &&
                            getBoard().getPieceByPos(1,row) == null &&
                            !getBoard().checkScanner.isKingChecked(new Move(getBoard(), this, 3, row));

                }
            }
        }

        return false;
    }

}
