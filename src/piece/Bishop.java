package src.piece;

import src.board.Board;

import java.awt.image.BufferedImage;

public class Bishop extends Piece{

    public Bishop(Board board, int col, int row, boolean isWhite) {
        super(board);

        this.setCol(col);
        this.setxPos(col * board.tileSize);

        this.setRow(row);
        this.setyPos(row * board.tileSize);

        this.setIsWhite(isWhite);
        this.setName("Bishop");

        this.setSprite(sheet.getSubimage(2 * sheetScale, isWhite ? 0 : sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH));
    }

    @Override
    public boolean isValidMovement(int col, int row) {
        return Math.abs(this.getCol() - col) == Math.abs(this.getRow() - row);
    }

    @Override
    public boolean isMoveCollideWithPiece(int col, int row) {

        // up left
        if(this.getCol() > col && this.getRow() > row){
            for(int i = 1; i < Math.abs(this.getCol() - col); i++){
                if(getBoard().getPieceByPos(this.getCol() - i, this.getRow() - i) != null){
                    return true;
                }
            }
        }

        // up right
        if(this.getCol() < col && this.getRow() > row){
            for(int i = 1; i < Math.abs(this.getCol() - col); i++){
                if(getBoard().getPieceByPos(this.getCol() + i, this.getRow() - i) != null){
                    return true;
                }
            }
        }

        // down left
        if(this.getCol() > col && this.getRow() < row){
            for(int i = 1; i < Math.abs(this.getCol() - col); i++){
                if(getBoard().getPieceByPos(this.getCol() - i, this.getRow() + i) != null){
                    return true;
                }
            }
        }

        // down right
        if(this.getCol() < col && this.getRow() < row){
            for(int i = 1; i < Math.abs(this.getCol() - col); i++){
                if(getBoard().getPieceByPos(this.getCol() + i, this.getRow() + i) != null){
                    return true;
                }
            }
        }

        return false;
    }

}
