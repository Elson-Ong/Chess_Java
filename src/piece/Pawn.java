package src.piece;

import src.board.Board;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{

    public Pawn(Board board, int col, int row, boolean isWhite) {
        super(board);

        this.setCol(col);
        this.setxPos(col * board.tileSize);

        this.setRow(row);
        this.setyPos(row * board.tileSize);

        this.setIsWhite(isWhite);
        this.setName("Pawn");

        this.setSprite(sheet.getSubimage(5 * sheetScale, isWhite ? 0 : sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH));
    }

    @Override
    public boolean isValidMovement(int col, int row) {
        int colorIndex = isWhite() ? 1 : -1;

        //normal pawn move of 1 step
        if(this.getCol() == col && row == this.getRow() - colorIndex && getBoard().getPiece(col,row) == null)
            return true;

        //first pawn move might be 2 steps
        if(isFirstMove() && this.getCol() == col && row == this.getRow() - colorIndex * 2 && getBoard().getPiece(col,row + colorIndex) == null)
            return true;

        //pawn capture to left
        if(col == this.getCol() - 1 && row == this.getRow() - colorIndex && getBoard().getPiece(col,row) != null)
            return true;

        //pawn capture to right
        if(col == this.getCol() + 1 && row == this.getRow() - colorIndex && getBoard().getPiece(col,row) != null)
            return true;

        return false;
    }

}
