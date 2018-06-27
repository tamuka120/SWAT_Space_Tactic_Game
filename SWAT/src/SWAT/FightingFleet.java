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
public class FightingFleet implements ListFunction{
    
       public Map<String, Force> allActiveForce = new HashMap();
   
   public boolean checkIfExist(String ref){ // True if ref = force
   return true;
   }
    
   /* pre-condition checkIfExist 
   
   If True, return the object
   */

   public Force getObj(String ref){ 

          Force found = null;
       
       if(allActiveForce.containsKey(ref)){
           System.out.println("found");
           System.out.println(allActiveForce.get(ref));
           return allActiveForce.get(ref);}
       else
       {
       return null;
       }
   }
   
   public boolean checkBool(String ref){
   
   if(allActiveForce.containsKey(ref)){return true;}
   else{return false;}
   
   }
    
   
  public void addTo(String name, Force force){
   
    allActiveForce.put(name, force);
    System.out.println("Force " + name + " added to the Game.");
   }

    @Override
    public void addFight(String name, Fight fight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAllItems() {
        StringBuilder sa = new StringBuilder();
        
            for(Force f:allActiveForce.values())
    {
        System.out.println(f.getReference());
       
        sa.append("Reference: " + f.getReference() + " " 
                + "Enemy Name: " + f.getEnemy() + " " 
                        + "Strength: " + f.getStrength() + " " 
                                + "Weapons " + f.getWeapon().toString() + " " + 
                                          "State:" + f.getStatus() + "\n"
                );

    }
        
        
        return sa.toString();
        
    }

    @Override
    public String searchItem(String ref) {
        StringBuilder sa = new StringBuilder();
        
        
        if(allActiveForce.containsKey(ref)){
        sa.append(allActiveForce.get(ref).getReference());
        sa.append(allActiveForce.get(ref).getEnemy());
        sa.append(allActiveForce.get(ref).getActivation());
        sa.append(allActiveForce.get(ref).getWeapon().toString());
        sa.append(allActiveForce.get(ref).getStrength());
        sa.append(allActiveForce.get(ref).getStatus());
        
        }else{sa.append("No such force");}
        
        
     return sa.toString();


    }

    @Override
    public Fight getFightObj(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean validateType(String type){
    boolean forceFound = false;
        
        for(Force force : allActiveForce.values()){
        if(force.isIsAmbush() && type.equals(FightType.AMBUSH.toString())){
        forceFound = true;
        }else if(force.isIsBattle()&& type.equals(FightType.BATTLE.toString())){
        forceFound = true;
        }else if(force.isIsSkirmish() && type.equals(FightType.SKIRMISH.toString()) && force.getStatus().equals(ForceState.ACTIVE.toString())){
        forceFound = true;
        }
    }
        return forceFound;
        
    }
    
    
    
    public Force validatedType(String type){
    
        
    try{
    if(validateType(type)){
        
    for(Force force : allActiveForce.values()){
        if((force.isIsAmbush() || force.hasSpecial()) && (type.equals(FightType.AMBUSH.toString()))){
        return force;
        }else if(force.isIsBattle()&& type.equals(FightType.BATTLE.toString())){
        return force;
        }else if(force.isIsSkirmish() && type.equals(FightType.SKIRMISH.toString()) && force.getStatus().equals(ForceState.ACTIVE.toString())){
        return force;
        }
    }
    }}
    catch (NullPointerException e){
        System.out.print("You have a null pointer");
        
    }
        
    return null;
    }
    
    
    
    public boolean isEmpty(){
        return allActiveForce.isEmpty();
    }
    
    public void deleteForce(Force obj){
    allActiveForce.remove(obj);
    
    }
}
