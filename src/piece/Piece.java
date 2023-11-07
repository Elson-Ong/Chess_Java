package src.piece;

import src.board.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Piece {

    private int col, row;
    private int xPos, yPos;
    private boolean isWhite;
    private String name;
    private int value;
    private boolean isFirstMove = true;
    private Board board;

    BufferedImage sheet;
    {
        try{
            sheet = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("pieces.png")));
        }catch (IOException ex){
            System.out.println("Problem trying to load pieces image from resource");
        }
    }

    protected int sheetScale = sheet.getTileWidth() / 6;
    private Image sprite;


    public Piece(Board board) {
        this.board = board;
    }

    public boolean isValidMovement(int col, int row){
        return true;
    }

    public boolean isMoveCollideWithPiece(int col, int row){
        return false;
    }

    public void paint(Graphics2D g2d){

        g2d.drawImage(sprite, xPos, yPos, null);

    }

    // Getters and Setters
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setIsFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }
}
