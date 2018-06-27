package OODCwk;

/**
 * This class implements the behaviour expected from a SWAT
 * system as required for 6COM1037 - Nov 2017
 * 
 * @author 
 * @version 
 */

public class SpaceWars  implements SWAT 
{
    // fields
    WarChest bitcoin = new BitCoin();
    FightingFleet fightFleet = new FightingFleet();
    DockedForce dockedForce = new DockedForce();
    FightContainer allFights = new FightContainer();
    ForceSubName fn;
    ForceReference fr;
    FightEnemy fe;
    FightType ft;
    String admiral;
    
//**************** SWAT **************************  
    /** Constructor requires the name of the admiral
     * @param admiral the name of the admiral
     */  
    public SpaceWars(String admiral)
    {
    setupForces();
    setupFights();
    setupWarChest();
        this.admiral = admiral;
    }
    
        
    /**Returns a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     **/
    public String toString()
    {
        String resources = String.valueOf(bitcoin.getValue());
        
        
        return admiral + resources;
    }
    
    
    /** returns true if war chest <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     * @returns true if resources <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     */
    public boolean isDefeated()
    {
        
        if (bitcoin.getValue() <= 0 && fightFleet.isEmpty() ){return true;}
        else{return false;}
    }
    
    
    /** returns the number of talents in the resources
     * @returns the number of talents in the resources
     */
    public int getWarchest()
    {

        return bitcoin.getValue();
    }
    
    public void setupWarChest(){
        
    
        bitcoin.setValue(1000); // Loaded with 1000 coins
        System.out.println("Loading warchest with " + 1000 + " bitcoins...");
    
    }
    
    /**Returns a String representation of all forces in the Allied Space Fleet(ASF)
     * @return a String representation of all forces in the Allied Space Fleet(ASF)
     **/
    public String getASFleet()
    {   
        
        
        
        return dockedForce.getAllItems();
    }
    
    /** Returns details of an ASF force with the given reference code
     * @return details of an ASF force with the given reference code
     **/
    public String findForceInASF(String ref)
    {
        return dockedForce.searchItem(ref);
    }
    
    /** Returns details of any force with the given reference code
     * @return details of any force with the given reference code
     **/
    public String getForce(String ref)
    {     
        if (dockedForce.checkBool(ref)){return dockedForce.searchItem(ref);}
        else{
        return fightFleet.searchItem(ref);
        }
    }     
 
    // ***************** Fighting Fleet Forces ************************   
    /** Allows a force to be activated into the admiral's FightingFleet,  
     * if there are enough resources for the activation fee.The force's 
     * state is set to "active"
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the ASF
      * 2 if not enough money, 3 if no such force
     **/        
    public int activateForce(String ref)
    {
        if (!dockedForce.checkBool(ref) && isInFightingFleet(ref)){return 1;} // not in ASF but in Fighting Fleet
       
        if ( dockedForce.checkBool(ref)){// IF found in ASF 
            int toDeduct = dockedForce.allDockedForce.get(ref).getActivation();
            if (toDeduct <= bitcoin.getValue()){
            
            bitcoin.deductValue(toDeduct);
            dockedForce.allDockedForce.get(ref).setActive(); // ACTIVATE force
            fightFleet.addTo(ref, dockedForce.getObj(ref)); // add to Fighting Fleet
            dockedForce.allDockedForce.remove(ref); // remove force
            return 0;}
            else{
                return 2;
            }}
        else{return 3;}

    }
    
    /** Returns true if the force with the reference code is in 
     * the admiral's FightingFleet, false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the admiral's FightingFleet, false otherwise.
     **/
    public boolean isInFightingFleet(String ref)
    {
        return fightFleet.checkBool(ref);
    }
    
    
    /** Removes a force from the FightingFleet back to the ASF dock, if they 
     * are in the FightingFleet
     * pre-condition: isInAdmiralsForce(ref)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref)
    {
        
        if ( isInFightingFleet(ref)){
            if (fightFleet.getObj(ref).getStatus().equals(ForceState.ACTIVE.toString())){
            int toAdd = fightFleet.getObj(ref).getActivation();
            bitcoin.addValue(toAdd/2);
            dockedForce.addTo(ref,fightFleet.getObj(ref));
            }
        }
            else{
                    System.out.println("No such force");
                    
                    }
        }
        
      
    
        
    /**Returns a String representation of the forces in the admiral's Fighting Fleet
     * or the message "No forces activated"
     * @return a String representation of the forces in the admiral's FightingFleet
     **/
    public String getFightingFleet()
    {
        
        return fightFleet.getAllItems();
    }
    
    
//**********************Fights************************* 
    /** returns true if the number represents a fight
     * @param num is the number of the fight
     * @returns true if the number represents a fight
     **/
     public boolean isFight(int num)
     {
         String toString = String.valueOf(num);
         return allFights.checkIfExist(toString);
     }
     
    /** Retrieves the fight represented by the fight number.Finds 
      * a force from the Fighting Fleet which can engage in the fight.The  
      * results of fighting an fight will be one of the following: 
      * 0 - Fight won, add fight gains to the warchest, 
      * 1 - Fight lost as no suitable force available, deduct the fight losses 
      * from resources 
      * 2 - Fight lost on battle strength  - deduct fight losses warchest, 
      *   and destroy the force
      * 3 - If a fight is lost and admiral completely defeated (no resources and 
      * no forces to recall) 
      * -1 - no such fight
      * @param fightNo is the number of the fight
      * @return a int showing the result of the fight
      */ 
    public int fight(int fightNo)
    {
        
        String fightToString = String.valueOf(fightNo);
        String fightType = allFights.getType(fightNo); // get the type of the fight

        int result = -1;
        if(isFight(fightNo) && fightFleet.validateType(fightType)){
  
            Force forceToUse = fightFleet.validatedType(fightType); // get the force for the fight
            Force toRemove = fightFleet.validatedType(fightType);
            if(allFights.getFightObj(fightToString).getStrength() < forceToUse.getStrength()){ // you win
                bitcoin.addValue(allFights.getFightObj(fightToString).getGains());
                result = 0;}
            else if(forceToUse.getStrength() < allFights.getFightObj(fightToString).getStrength() && isDefeated()){ // you loose
                result = 3;
            }else if(forceToUse.getStrength() < allFights.getFightObj(fightToString).getStrength() && !isDefeated()){ // you loose
                System.out.println(fightFleet.isEmpty());
                bitcoin.deductValue(allFights.getFightObj(fightToString).getLoses());
                forceToUse.setDestroyed();// force Destroyed + remove from fightFleet
                fightFleet.allActiveForce.remove(toRemove.getReference());                   //method 2
                result = 2;
    }
    }else if (isFight(fightNo)){bitcoin.deductValue(allFights.getFightObj(fightToString).getLoses());result = 1;}

        else{result = -1;}
        return result;
        
    }

    /** Provides a String representation of a fight given by 
     * the fight number
     * @param num the number of the fight
     * @return returns a String representation of a fight given by 
     * the fight number
     **/
    public String getFight(int num)
    {
        return "";
    }
    
    /** Provides a String representation of all fights 
     * @return returns a String representation of all fights
     **/
    public String getAllFights()
            
            
    {
        return allFights.getAllItems();
    }
    

    //****************** private methods for Task 4 functionality*******************
    //*******************************************************************************
    private void setupForces()
    {
      
        dockedForce = new DockedForce();
      
     
           
      dockedForce.addTo( fr.IW1.toString(),new Wing("IW1","Dragons",200,200,true,false,true,10));
      dockedForce.addTo( fr.IW4.toString(),new Wing(fr.IW4.toString(),fn.WINGERS.toString(),400,200,true,false,true,20));
      dockedForce.addTo( fr.IW10.toString(),new Wing(fr.IW10.toString(),fn.FLYERS.toString(),100,200,true,false,true,5));
     
      dockedForce.addTo( fr.SS2.toString(),new StarShip(fr.SS2.toString(),fn.ENTERPRISE.toString(),200,300,false,true,true,10,20));
      dockedForce.addTo( fr.SS6.toString(),new StarShip(fr.SS6.toString(),fn.VOYAGER.toString(),250,450,false,true,true,15,10));
      dockedForce.addTo( fr.SS7.toString(),new StarShip(fr.SS7.toString(),fn.EXPLORER.toString(),65,120,false,true,true,4,5));
     
      dockedForce.addTo( fr.WB3.toString(),new WarBird(fr.WB3.toString(),fn.DROOP.toString(),100,300,false,true,false,false));
      dockedForce.addTo( fr.WB5.toString(),new WarBird(fr.WB5.toString(),fn.HANG.toString(),300,400,true,true,false,true));
      dockedForce.addTo( fr.WB9.toString(),new WarBird(fr.WB9.toString(),fn.HOVER.toString(),400,300,false,true,false,false));
        
        
        
        
    }
    
    private void setupFights()
    {
        allFights = new FightContainer();
        

      allFights.addFight("1",new Fight(1,ft.BATTLE.toString(),fe.BORG.toString(),200,300,100));
      allFights.addFight( "2",new Fight(2, ft.SKIRMISH.toString(), fe.KARDASSIANS.toString(), 700, 200, 120));
      allFights.addFight( "3",new Fight(3,ft.AMBUSH.toString() ,fe.FERENGI.toString(), 100, 400, 150));
    
      allFights.addFight( "4",new Fight(4,ft.BATTLE.toString(), fe.EWOKS.toString(), 600, 600, 200));
      allFights.addFight( "5",new Fight(5,ft.AMBUSH.toString() ,fe.BORG.toString(), 500, 400, 90));
      allFights.addFight( "6",new Fight(6,ft.SKIRMISH.toString() ,fe.GROANERS.toString(), 150, 100, 100));
        
        
        
        
    }
    
    

    //*******************************************************************************
    //*******************************************************************************
  

    // These methods are not needed until Task 7.3
    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    public void saveGame(String fname)
    {    
    }
    
    /** reads all information about the game from the specified file 
     * and returns 
     * @param fname name of file storing the game
     * @return the game (as a Admiral object)
     */
    public SpaceWars restoreGame(String fname)
    {   
        return null;
    } 
    
}



