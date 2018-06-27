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
public enum ForceName {
    
    WING("Wing"),STARSHIP("Starship"),WARBIRD("Warbird");
    
    private String name;
    
    ForceName(String n){
    this.name = n;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    
    
}
