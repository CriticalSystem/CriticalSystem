/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author s20163051
 */
public class Cash_Register {

    private String denom;       //  金種
    private int piece;          //  本数
    private int sheet;          //  枚数
    private int moneys;         //  金額

    //  コンストラクタ
    public Cash_Register() {
    }
    
    public Cash_Register(String denom, int piece, int sheet, int moneys) {
        this.denom = denom;
        this.piece = piece;
        this.sheet = sheet;
        this.moneys = moneys * ((piece * 50) + sheet);
    }

    //  セッター、ゲッター
    public String getDenom() {
        return denom;
    }

    public void setDenom(String denom) {
        this.denom = denom;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public int getSheet() {
        return sheet;
    }

    public void setSheet(int sheet) {
        this.sheet = sheet;
    }

    public int getMoneys() {
        return moneys;
    }

    public void setMoneys(int moneys) {
        this.moneys = moneys;
    }
    
}
