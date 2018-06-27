/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * 
 */
public enum FightEnemy {

    BORG(" Borg"), KARDASSIANS(" Kardassians"), FERENGI("Ferengi"), EWOKS(" Ewoks"), GROANERS(" Groaners"), MOONFLIES("Moonflies");
    
    private String enemy;
    
    private FightEnemy(String e){
        this.enemy= e;
    }

    @Override
    public String toString() {
        return enemy ;
    }
    
    
    
    
    
}
