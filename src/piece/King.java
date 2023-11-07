package src.piece;

import src.board.Board;

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
        return Math.abs((col - this.getCol()) * (row - this.getRow()))  == 1 || Math.abs(col - this.getCol()) + Math.abs(row - this.getRow()) == 1 ;
    }

}
