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
 * @author admin
 */
public class FightContainer implements ListFunction{
    
    
    Map<String,Fight> allFights = new HashMap();

    @Override
    public boolean checkIfExist(String ref) {
       if(allFights.containsKey(ref)){return true;}
       else{return false;}

    }

    public Fight getFightObj(String ref) {
        
    
    Fight found = null;
       
    try{
       if(allFights.containsKey(ref)){
           System.out.println("found");
           System.out.println(allFights.get(ref));
           return allFights.get(ref);
           
       }
     
        }
    catch(NullPointerException e){
        System.out.println("A Fight NullPointer");
        
    }
    return null;
    }


    

    @Override
    public void addTo(String name, Force force) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addFight(String name, Fight fight) {
        allFights.put(name, fight);
    }

    @Override
    public String getAllItems() {
        
        StringBuilder sq = new StringBuilder();
    for(Fight fi:allFights.values())
    {
        System.out.println(fi.getFightNo());
       
        sq.append("FightNo: " + fi.getFightNo() + " " 
                + "Enemy Name: " + fi.getFightname() + " " 
                        + "Fight Type: " + fi.getType() + " "
                        + "Gains: " + fi.getGains() + " " 
                                + "Loses " + fi.getLoses() + " " + 
                                          "Enemy Str:" + fi.getStrength() + "\n"
                );

    }

    return sq.toString();    }

    @Override
    public String searchItem(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getType(int fightNo){
    
        String fightToString = String.valueOf(fightNo);
        
        String fightType = getFightObj(fightToString).getType(); // Type of Fight found

        return fightType;
    }

    @Override
    public Force getObj(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
       
}
