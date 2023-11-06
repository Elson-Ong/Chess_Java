package src.piece;

import src.board.Board;

import java.awt.image.BufferedImage;

public class Knight extends Piece{

    public Knight(Board board, int col, int row, boolean isWhite) {
        super(board);

        this.setCol(col);
        this.setxPos(col * board.tileSize);

        this.setRow(row);
        this.setyPos(row * board.tileSize);

        this.setIsWhite(isWhite);
        this.setName("Knight");

        this.setSprite(sheet.getSubimage(3 * sheetScale, isWhite ? 0 : sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH));
    }

    @Override
    public boolean isValidMovement(int col, int row) {
        return Math.abs(col - this.getCol()) * Math.abs(row - this.getRow()) == 2;
    }

    @Override
    public boolean isMoveCollideWithPiece(int col, int row) {
        return super.isMoveCollideWithPiece(col, row);
    }
}
