/*
Esha Garg 2/2020
This is the output frame for the program
 */
package gargesteamdb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Output extends JFrame implements ActionListener
{
    //declaring variables
    private final java.net.URL OUTPUT_PATH = getClass().getResource("output.png");
    private final ImageIcon OUTPUT_IMAGE = new ImageIcon(new ImageIcon(OUTPUT_PATH)
            .getImage().getScaledInstance(500, 180, Image.SCALE_DEFAULT));
    private JMenuBar mainBar;
    private JMenu helpMenu;
    private JMenuItem howToUseMenu;
    private JMenuItem formulaMenu;
    private JLabel infoLabel;
    private JLabel imageLabel;
    private JPanel navigationPanel;
    private JButton returnButton;
    private JButton exitButton;
    
    //constructor
    public Output(String calculating, double outputValue)
    {
        //construct the frame
        super("Output Frame");
        this.setBounds(300,250,600,350);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Welcome.PURPLE_COLOR);
        this.setLayout(new BorderLayout());
        
        //construct the menu
        this.mainBar = new JMenuBar();
        this.helpMenu = new JMenu("HELP");
        this.howToUseMenu = new JMenuItem("How to Use");
        this.howToUseMenu.addActionListener(this);
        this.formulaMenu = new JMenuItem("Formulas");
        this.formulaMenu.addActionListener(this);
        this.helpMenu.add(howToUseMenu);
        this.helpMenu.add(formulaMenu);
        this.mainBar.add(helpMenu);
        this.setJMenuBar(mainBar);
        
        //construct the labels
        this.infoLabel = new JLabel(calculating + ": " + outputValue, SwingConstants.CENTER);
        this.infoLabel.setFont(Welcome.MED_FONT);
        this.infoLabel.setForeground(Color.WHITE);
        this.imageLabel = new JLabel(OUTPUT_IMAGE);

        
        //construct the buttons
        this.returnButton = new JButton("Return");
        this.returnButton.addActionListener(this);
        this.exitButton = new JButton("Exit Program");
        this.exitButton.addActionListener(this);
        
        //construct the panels
        this.navigationPanel = new JPanel(new FlowLayout());
        this.navigationPanel.setBackground(Welcome.PURPLE_COLOR);
        this.navigationPanel.add(returnButton);
        this.navigationPanel.add(exitButton);
        
        //adding to frame
        this.add(imageLabel, BorderLayout.NORTH);
        this.add(infoLabel, BorderLayout.CENTER);
        this.add(navigationPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        Object component = e.getSource();
        if (component == howToUseMenu)
        {
            new HowToUse();
        }
        else if (component == formulaMenu)
        {
            new Formula();
        }
        else if (command.equals("Return"))
        {
            this.dispose();
        }
        else if (command.equals("Exit Program"))
        {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
    
    public static void main(String[] args)
    {
        new Output("testing", 0);
    }
}
