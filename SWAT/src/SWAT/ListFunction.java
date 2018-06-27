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
public interface ListFunction {
    
    
    public boolean checkIfExist(String ref); // True if ref = force

   
    
   /* pre-condition checkIfExist 
   
   If True, return the object
   */

   public Force getObj(String ref);

   public Fight getFightObj(String ref);

   public String getType(int value);
   public void addTo(String name, Force force);
   
   public void addFight(String name, Fight fight);

   public String getAllItems();
   
   public String searchItem(String ref);
  
}
