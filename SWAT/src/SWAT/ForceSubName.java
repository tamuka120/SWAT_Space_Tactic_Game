/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * @author 
 */
public enum ForceSubName {
    
    
    DRAGONS("Dragons"), ENTERPRISE("Enterprise"), DROOP("Droop"), WINGERS("Wingers"), HANG("Hang"), VOYAGER("Voyager"), EXPLORER("Explorer"), HOVER("Hover"), FLYERS("Flyers"), LINGER("Linger"), SPEAR("Spear"); 

    private String forceName;

    private ForceSubName (String fn){
            this.forceName = fn;
    }

    
    public String toString() {
        return this.forceName;
    
    }
}
