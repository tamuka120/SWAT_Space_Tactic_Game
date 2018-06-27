/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author admin
 */
public class DockedForce implements ListFunction {
    
   public Map<String, Force> allDockedForce = new HashMap<String,Force>();
   private Map<String, String> all= new HashMap<String,String>();
   DockedForce(){
   
   }
   
   
   public boolean checkIfExist(String ref){ // True if ref = force
   return true;
   }
    
   /* pre-condition checkIfExist 
   
   If True, return the object
   */

   public Force getObj(String ref){ 

       Force found = null;
       
       if(allDockedForce.containsKey(ref)){
           System.out.println("found");
           System.out.println(allDockedForce.get(ref));
           return allDockedForce.get(ref);}
       else
       {
       return null;
       }
   }
   
   public boolean checkBool(String ref){
   
   if(allDockedForce.containsKey(ref)){return true;}
   else{return false;}
   
   }
   
   public void addTo(String name, Force force){
   
    
    allDockedForce.put(name, force);
    
    System.out.println("Force " + name + " added to the Game.");
   }

    @Override
    public void addFight(String name, Fight fight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public String getAllItems(){
        
        
    
    StringBuilder sb = new StringBuilder();
    String line = "";
//    Iterator it = allDockedForce.entrySet().iterator();
//    while (it.hasNext()) {
//        Map.Entry pair = (Map.Entry)it.next();
//        System.out.println(pair.getKey() + " = " + pair.getValue());
////        line = pair.getValue().toString();
//        
//        //Force getC1 = (Force)allDockedForce.get("Wing");
//        //sb.append(getC1.getReference());
//        
//        it.remove(); // avoids a ConcurrentModificationException
//    }
    for(Force f:allDockedForce.values())
    {
        System.out.println(f.getReference());
       
        sb.append("Reference: " + f.getReference() + " " 
                + "Enemy Name: " + f.getEnemy() + " " 
                        + "Strength: " + f.getStrength() + " " 
                                + "Weapons " + f.getWeapon().toString() + " " + 
                                          "State:" + f.getStatus() + "\n"
                );

    }

    return sb.toString();
    
    }

    @Override
    public String searchItem(String ref) {
        
        StringBuilder sa = new StringBuilder();
        
        
        if(allDockedForce.containsKey(ref)){
        sa.append(allDockedForce.get(ref).getReference());
        sa.append(allDockedForce.get(ref).getEnemy());
        sa.append(allDockedForce.get(ref).getActivation());
        sa.append(allDockedForce.get(ref).getWeapon().toString());
        sa.append(allDockedForce.get(ref).getStrength());
        sa.append(allDockedForce.get(ref).getStatus());
        
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
    
    
    
    
    
    
}
