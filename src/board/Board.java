package src.board;

import src.piece.*;
import  src.move.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    public int tileSize = 85;
    private int cols = 8;
    private int rows = 8;

    ArrayList<Piece> pieceArrayList  = new ArrayList<>();

    private Piece selectedPiece;

    Input input = new Input(this);

    public Board() {
        this.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));

        this.addMouseListener(input);
        this.addMouseMotionListener(input);

        addPieces();
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public Piece getPiece(int col, int row){

        for (Piece p: pieceArrayList){
            if(p.getRow() == row && p.getCol() == col)
                return p;
        }
        return null;
    }

    public boolean isValidMove(Move move){

        if (sameTeam(move.getPiece(), move.getCapturePiece()))
            return false;

        if(!move.getPiece().isValidMovement(move.getNewCol(), move.getNewRow()))
            return false;

        if(move.getPiece().isMoveCollideWithPiece(move.getNewCol(), move.getNewRow()))
            return false;

        return true;
    }

    public boolean sameTeam(Piece p1, Piece p2){
        if(p1 == null || p2 == null)
            return false;

        return p1.isWhite()==p2.isWhite();
    }

    public void makeMove(Move move){
        move.getPiece().setCol(move.getNewCol());
        move.getPiece().setRow(move.getNewRow());
        move.getPiece().setxPos(move.getNewCol() * tileSize);
        move.getPiece().setyPos(move.getNewRow() * tileSize);

        capture(move);
    }

    public void capture(Move move){
        pieceArrayList.remove(move.getCapturePiece());
    }

    public void addPieces() {
        // add black pieces
        pieceArrayList.add(new Rook(this,0,0,false));
        pieceArrayList.add(new Knight(this,1,0,false));
        pieceArrayList.add(new Bishop(this,2,0,false));
        pieceArrayList.add(new Queen(this,3,0,false));
        pieceArrayList.add(new King(this,4,0,false));
        pieceArrayList.add(new Bishop(this,5,0,false));
        pieceArrayList.add(new Knight(this,6,0,false));
        pieceArrayList.add(new Rook(this,7,0,false));

        pieceArrayList.add(new Pawn(this,0,1,false));
        pieceArrayList.add(new Pawn(this,1,1,false));
        pieceArrayList.add(new Pawn(this,2,1,false));
        pieceArrayList.add(new Pawn(this,3,1,false));
        pieceArrayList.add(new Pawn(this,4,1,false));
        pieceArrayList.add(new Pawn(this,5,1,false));
        pieceArrayList.add(new Pawn(this,6,1,false));
        pieceArrayList.add(new Pawn(this,7,1,false));

        // add white pieces
        pieceArrayList.add(new Rook(this,0,7,true));
        pieceArrayList.add(new Knight(this,1,7,true));
        pieceArrayList.add(new Bishop(this,2,7,true));
        pieceArrayList.add(new Queen(this,3,7,true));
        pieceArrayList.add(new King(this,4,7,true));
        pieceArrayList.add(new Bishop(this,5,7,true));
        pieceArrayList.add(new Knight(this,6,7,true));
        pieceArrayList.add(new Rook(this,7,7,true));

        pieceArrayList.add(new Pawn(this,0,6,true));
        pieceArrayList.add(new Pawn(this,1,6,true));
        pieceArrayList.add(new Pawn(this,2,6,true));
        pieceArrayList.add(new Pawn(this,3,6,true));
        pieceArrayList.add(new Pawn(this,4,6,true));
        pieceArrayList.add(new Pawn(this,5,6,true));
        pieceArrayList.add(new Pawn(this,6,6,true));
        pieceArrayList.add(new Pawn(this,7,6,true));

    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        //paint board
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                g2d.setColor((c+r)% 2 == 0 ? new Color(246, 223, 181) : new Color(107, 79, 37));
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            }
        }

        // paint possible move location green
        if(selectedPiece != null) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {

                    if (isValidMove(new Move(this, selectedPiece, c, r))) {

                        g2d.setColor(new Color(0, 255, 0, 150));
                        g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);

                    }
                }
            }
        }

        // paint pieces
        for(Piece piece: pieceArrayList) {
            piece.paint(g2d);
        }
    }

}
