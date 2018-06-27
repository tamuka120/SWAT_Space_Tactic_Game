/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 
 * 
 * @author admin
 */
public class StarShip extends Force {
    
    private boolean isAmbush, isBattle, isSkirmish;
    private int strength, activation,laser,photon; // has laser and photon
    private String reference, enemy, status;
    private Map<String,String> weapon = new HashMap<String, String>();
    
    // Contructor for the Force Super class
    public StarShip(String ref,String ene, int str, int fee, boolean isA, boolean isB, boolean isS, int l, int p){
    super(ref,ene,str,fee,isA,isB,isS);
        this.reference = ref;
        this.enemy = ene;
        this.activation = fee;
        this.isAmbush = isA;
        this.isBattle = isB;
        this.isSkirmish = isS;
        this.laser = l;
        this.photon = p;
        this.strength = str;
        
        this.status = ForceState.DOCKED.toString();
    }

    public boolean isIsAmbush() {
        return isAmbush;
    }

    public void setIsAmbush(boolean isAmbush) {
        this.isAmbush = isAmbush;
    }

    public boolean isIsBattle() {
        return isBattle;
    }

    public void setIsBattle(boolean isBattle) {
        this.isBattle = isBattle;
    }

    public boolean isIsSkirmish() {
        return isSkirmish;
    }

    public void setIsSkirmish(boolean isSkirmish) {
        this.isSkirmish = isSkirmish;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public int getLaser() {
        return laser;
    }

    public void setLaser(int laser) {
        this.laser = laser;
    }

    public int getPhoton() {
        return photon;
    }

    public void setPhoton(int photon) {
        this.photon = photon;
    }

   
    
    
    @Override
    public void setActive(){
    
    this.status = ForceState.ACTIVE.toString();
    
    };
    public void setDestroyed(){this.status = ForceState.DESTROYED.toString();};
    public void setDocked(){this.status = ForceState.DOCKED.toString();};
    public String getStatus(){return this.status;};

    @Override
    Map<String, String> getWeapon() {

        
        String toHash = String.valueOf(photon);
        String toHash1 = String.valueOf(laser);
        weapon.put("Photon ", toHash);
        weapon.put("Laser ", toHash1);
       
        return weapon; 
        
        
    }

    @Override
    boolean hasSpecial() {
return false;    }
   
}
