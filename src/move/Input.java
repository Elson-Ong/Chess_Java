package src.move;

import src.board.Board;
import src.piece.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Input extends MouseAdapter {

    private Board board;

    public Input(Board board){
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        Piece pieceXY = board.getPiece(col, row);

        if(pieceXY != null)
            board.setSelectedPiece(pieceXY);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(board.getSelectedPiece() != null) {
            board.getSelectedPiece().setxPos(e.getX() - board.tileSize / 2);
            board.getSelectedPiece().setyPos(e.getY() - board.tileSize / 2);

            board.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        if(board.getSelectedPiece() != null){
            Move move = new Move(board, board.getSelectedPiece(), col, row);

            if(board.isValidMove(move)) {
                board.makeMove(move);
            }
            else {
                board.getSelectedPiece().setxPos(board.getSelectedPiece().getCol() * board.tileSize);
                board.getSelectedPiece().setyPos(board.getSelectedPiece().getRow() * board.tileSize);
            }

            board.setSelectedPiece(null);
            board.repaint();
        }
    }


}
