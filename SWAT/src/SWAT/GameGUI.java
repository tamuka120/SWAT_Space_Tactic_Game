package OODCwk;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/10/2017
 */
public class GameGUI 
{
    private SWAT gp = new SpaceWars("Horatio");
    private JFrame myFrame = new JFrame("Game GUI");
    private Container contentPane = myFrame.getContentPane();
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton fightBtn = new JButton("Fight");
    private JButton viewBtn = new JButton("View State");
    private JButton clearBtn = new JButton("Clear");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();
    
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
    }
    

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        contentPane.setLayout(new BorderLayout());
        contentPane.add(listing,BorderLayout.CENTER);
        listing.setVisible(false);
        contentPane.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(fightBtn);
        eastPanel.add(viewBtn);
        eastPanel.add(clearBtn);
        
        clearBtn.addActionListener(new ClearHandler());
        fightBtn.addActionListener(new FightHandler());
        eastPanel.add(quitBtn);
        fightBtn.setVisible(true);
        viewBtn.setVisible(true);
        clearBtn.setVisible(true);
        quitBtn.setVisible(true);
        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File menu
        JMenu fileMenu = new JMenu("Forces");
        menubar.add(fileMenu);
        
        JMenuItem listForceItem = new JMenuItem("List ASFleet ");
        listForceItem.addActionListener(new ListForceHandler());
        fileMenu.add(listForceItem);

        JMenuItem listFleetItem = new JMenuItem("List admiral's fleet");
        listFleetItem.addActionListener(new ListFleetHandler());
        fileMenu.add(listFleetItem);
        
        JMenuItem activation = new JMenuItem("Activate Force");
        activation.addActionListener(new ActivateHandler());
        fileMenu.add(activation);
       
        JMenuItem recall = new JMenuItem("Recall Force");
        recall.addActionListener(new RecallHandler());
        fileMenu.add(recall);
        
        

    }
    
    private String activation(int code)
    {
        switch (code)
        {
            case 0:return "force is activated"; 
            case 1:return "force is not in the ASF"; 
            case 2:return "not enough money";
            case 3:return "no such force";
            default: return "Error";
        }
    }
    
    private String fighting(int code)
    {
        switch (code)
        {
            case 0:return "Fight won"; 
            case 1:return "Fight lost as no suitable force available"; 
            case 2:return "Fight lost on battle strength, force destroyed";
            case 3:return "fight is lost and admiral completely defeated ";
        }
        return " no such fight ";
    }
    
    private class ListForceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getASFleet();
            listing.setText(xx);
            
        }
    }
    
    private class ListFleetHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getFightingFleet();
            listing.setText(xx);
        }
    }
    
    private class ClearHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setText("");
            listing.setVisible(false);            
        }
    }

    private class ActivateHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String inputValue = JOptionPane.showInputDialog("Force reference ?: ");
            result = gp.activateForce(inputValue);
            JOptionPane.showMessageDialog(myFrame,activation(result));    
        }
    }
    
    private class RecallHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String result = "";
            String inputValue = JOptionPane.showInputDialog("Force code ?: ");
            
            if(gp.isInFightingFleet(inputValue)) 
            {
                gp.recallForce(inputValue);
                result = inputValue + " is recalled";
            }
            else
            {
                result = inputValue + " not in fighting fleet";
            }
            JOptionPane.showMessageDialog(myFrame,result);    
        }
    }
    
    private class ViewForceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String result = "";
            String inputValue = JOptionPane.showInputDialog("Force code ?: ");
            result = gp.getForce(inputValue);
            JOptionPane.showMessageDialog(myFrame,result);    
        }
    }
    
    private class FightHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String inputValue = JOptionPane.showInputDialog("Fight number ?: ");
            int num = Integer.parseInt(inputValue);
            result = gp.fight(num);
            JOptionPane.showMessageDialog(myFrame,fighting(result));    
        }
    }
    
   
    private class ClearButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {            
            listing.setVisible(false);
            clearBtn.setVisible(false);
        }
    }   
}
   
