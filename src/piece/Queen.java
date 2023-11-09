package src.piece;

import src.board.Board;

import java.awt.image.BufferedImage;

public class Queen extends Piece{

    public Queen(Board board, int col, int row, boolean isWhite) {
        super(board);

        this.setCol(col);
        this.setxPos(col * board.tileSize);

        this.setRow(row);
        this.setyPos(row * board.tileSize);

        this.setIsWhite(isWhite);
        this.setName("Queen");

        this.setSprite(sheet.getSubimage(sheetScale, isWhite ? 0 : sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH));
    }

    @Override
    public boolean isValidMovement(int col, int row) {
        return this.getCol() == col || this.getRow() == row || Math.abs(this.getCol() - col) == Math.abs(this.getRow() - row);
    }

    @Override
    public boolean isMoveCollideWithPiece(int col, int row) {
        if(this.getCol()==col || this.getRow() == row) {
            // left
            if (this.getCol() > col) {
                for (int c = this.getCol() - 1; c > col; c--) {
                    if (getBoard().getPieceByPos(c, this.getRow()) != null)
                        return true;
                }
            }

            // right
            if (this.getCol() < col) {
                for (int c = this.getCol() + 1; c < col; c++) {
                    if (getBoard().getPieceByPos(c, this.getRow()) != null)
                        return true;
                }
            }

            // up
            if (this.getRow() > row) {
                for (int r = this.getRow() - 1; r > row; r--) {
                    if (getBoard().getPieceByPos(this.getCol(), r) != null)
                        return true;
                }
            }

            // down
            if (this.getRow() < row) {
                for (int r = this.getRow() + 1; r < row; r++) {
                    if (getBoard().getPieceByPos(this.getCol(), r) != null)
                        return true;
                }
            }
        }
        else{
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
        }
        return false;
    }
}
