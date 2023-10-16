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

}
