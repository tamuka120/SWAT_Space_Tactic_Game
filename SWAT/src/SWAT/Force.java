/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

import java.util.Map;

/**
 *
 * 
 * 
 * @author admin
 */
abstract class Force {
    
    private boolean isAmbush, isBattle, isSkirmish;
    private int strength, activation;
    private String reference, enemy,status;

    
    // Contructor for the Force Super class
    Force(String ref, String ene, int str, int fee, boolean isA, boolean isB, boolean isS){
    
        this.reference = ref;
        this.enemy = ene;
        this.strength = str;
        this.activation = fee;
        this.isAmbush = isA;
        this.isBattle = isB;
        this.isSkirmish = isS;
        
     
        
        
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
    
    abstract void setActive();
    abstract void setDestroyed();
    abstract void setDocked();
    abstract boolean hasSpecial();
    abstract String getStatus();
    abstract Map<String,String> getWeapon();
    
   
}
