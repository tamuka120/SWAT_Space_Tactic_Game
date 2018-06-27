package OODCwk;
import java.io.*;
/**
 * Enumeration class ForceState 
 * 
 * @author A.Marczyk
 * @version 20/10/2017
 */
public enum ForceState implements Serializable
{
    DOCKED(" In dock"), ACTIVE(" Active"), DESTROYED (" Destroyed");
    private String state;
    
    private ForceState(String st)
    {
        state = st;
    }
    
    public String toString()
    {
        return state;
    }
}
