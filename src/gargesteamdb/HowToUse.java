/*
Esha Garg 3/2020
This is the how to use frame for the program, part of the help menu
 */
package gargesteamdb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class HowToUse extends JFrame implements ActionListener
{
    //declaring variables
    private final java.net.URL HOW_TO_PATH = getClass().getResource("howTo.jpg");
    private final ImageIcon HOW_TO_IMAGE = new ImageIcon(new ImageIcon(HOW_TO_PATH)
            .getImage().getScaledInstance(190,100,Image.SCALE_DEFAULT));
    private JLabel imageLabel;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JLabel infoLabel;
    private JButton exitButton;
    private JPanel exitPanel;
    
    //constructor
    public HowToUse()
    {
        //consrtuct the frame
        super("How to Use Frame");
        this.setBounds(350,200,500,450);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Welcome.MED_BLUE_COLOR);
        this.setLayout(new BorderLayout());
        
        //construct the labels
        this.titleLabel = new JLabel("How to Use", SwingConstants.CENTER);
        this.titleLabel.setFont(Welcome.MED_FONT);
        this.imageLabel = new JLabel(HOW_TO_IMAGE);
        this.infoLabel = new JLabel("<html><center> "
                + "Welcome Frame: please click Start to begin the program or click Exit to end the program. <br> <br>"
                + "Input Frame: please fill out the information from top to bottom."
                + " Start by clicking whether you have  one value or two values, and click Submit Value."
                + " To add terms to your position equation, go to New Term for Position Equation."
                + " Type in the coefficient and exponent of the term and click Add Term."
                + " You can add terms until you have completed your position equation."
                + " Next, type in the numerical value(s) for a (and b). Once done, click Enter."
                + " Finally, choose the value you would like to calculate for. An ouput frame will pop up with your answer."
                + " If you make any mistakes, just click Reset to have a fresh Input Frame. <br> <br>"
                + "Output Frame: please click Return to show the Input Frame or click Exit Program to end the program.</html></center>");
        this.infoLabel.setHorizontalAlignment(JLabel.CENTER);
        
        //construct the buttons
        this.exitButton = new JButton("Close");
        this.exitButton.addActionListener(this);
        
        //construct the panel
        this.titlePanel = new JPanel(new BorderLayout());
        this.titlePanel.setBackground(Welcome.MED_BLUE_COLOR);
        this.titlePanel.add(titleLabel, BorderLayout.CENTER);
        this.titlePanel.add(imageLabel, BorderLayout.SOUTH);
        this.exitPanel = new JPanel(new FlowLayout());
        this.exitPanel.setBackground(Welcome.PURPLE_COLOR);
        this.exitPanel.add(exitButton);
        
        //adding to frame
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(infoLabel, BorderLayout.CENTER);
        this.add(exitPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new HowToUse();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if (command.equals("Close"))
        {
            this.dispose();
        }
    }
}