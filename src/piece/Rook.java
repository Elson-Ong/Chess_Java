package src.piece;

import src.board.Board;

import java.awt.image.BufferedImage;

public class Rook extends Piece{

    public Rook(Board board, int col, int row, boolean isWhite) {
        super(board);

        this.setCol(col);
        this.setxPos(col * board.tileSize);

        this.setRow(row);
        this.setyPos(row * board.tileSize);

        this.setIsWhite(isWhite);
        this.setName("Rook");

        this.setSprite(sheet.getSubimage(4 * sheetScale, isWhite ? 0 : sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH));
    }

    @Override
    public boolean isValidMovement(int col, int row) {
        return this.getCol() == col || this.getRow() == row;
    }

    @Override
    public boolean isMoveCollideWithPiece(int col, int row) {

        // left
        if(this.getCol() > col){
            for(int c = this.getCol() - 1; c > col; c--){
                if(getBoard().getPiece(c, this.getRow()) != null)
                    return true;
            }
        }

        // right
        if(this.getCol() < col){
            for(int c = this.getCol() + 1; c < col; c++){
                if(getBoard().getPiece(c, this.getRow()) != null)
                    return true;
            }
        }

        // up
        if(this.getRow() > row){
            for(int r = this.getRow() - 1; r > row; r--){
                if(getBoard().getPiece(this.getCol(), r) != null)
                    return true;
            }
        }

        // down
        if(this.getRow() < row){
            for(int r = this.getRow() + 1; r < row; r++){
                if(getBoard().getPiece(this.getCol(), r) != null)
                    return true;
            }
        }

        return false;
    }

}
