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
public enum ForceReference {
    
    IW1("IW1"), IW4("IW4"), IW10("IW10"), WB5("WB5"), SS6("SS6"), SS7("SS7"), WB9("WB9"), SS2("SS2"), WB3("WB3")
    , WB26("WB26"), SF34("SF34");
 
    private String reference;

    private ForceReference (String r){
            this.reference = r;
    }

    @Override
    public String toString() {
        return reference;
    }
    
    
    
    
    
    
    
    
    
    
}
