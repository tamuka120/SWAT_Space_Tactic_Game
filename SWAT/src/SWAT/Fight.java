/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * @author admin
 */
public class Fight {
    
    private String fightname, type;
    private int gains,loses,fightNo, strength;
    boolean special;
    
    Fight(int fn,String ty, String name, int str,int l, int g){
        
        this.fightNo = fn;
        this.fightname = name;
        this.strength = str;
        this.gains = g;
        this.loses = l;
        this.type = ty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

    public int getFightNo() {
        return fightNo;
    }

    public void setFightNo(int fightNo) {
        this.fightNo = fightNo;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getFightname() {
        return fightname;
    }

    public void setFightname(String Fightname) {
        this.fightname = Fightname;
    }

    public int getGains() {
        return gains;
    }

    public void setGains(int gains) {
        this.gains = gains;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }
    
    
    
    
    
    
    
    
}
