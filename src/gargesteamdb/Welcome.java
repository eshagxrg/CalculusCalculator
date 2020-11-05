/*
Esha Garg 2/2020
This is the welcome frame for the program
 */
package gargesteamdb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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


public class Welcome extends JFrame implements ActionListener
{
    //declaring variables
    public static final Font BIG_FONT = new Font("Time New Roman", Font.BOLD, 50);
    public static final Font MED_FONT = new Font("Time New Roman", Font.BOLD, 25);
    public static final Font SMALL_FONT = new Font("Time New Roman", Font.PLAIN, 15);
    public static final Color PINK_COLOR = new Color(247,185,209);
    public static final Color PURPLE_COLOR = new Color(192,185,221);
    public static final Color TEAL_COLOR = new Color(181,254,217);
    public static final Color RED_COLOR = new Color(221,115,115);
    public static final Color LIGHT_BLUE_COLOR = new Color(206,234,247);
    public static final Color MED_BLUE_COLOR = new Color(143,210,234);
    private final java.net.URL WELCOME_PATH = getClass().getResource("welcome.png");
    private final ImageIcon WELCOME_IMAGE = new ImageIcon(new ImageIcon(WELCOME_PATH)
            .getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT));
    private JMenuBar mainBar;
    private JMenu helpMenu;
    private JMenuItem howToUseMenu;
    private JMenuItem formulaMenu;
    private JPanel infoPanel;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JPanel centerPanel;
    private JLabel descriptionLabel;
    private JLabel imageLabel;
    private JButton startButton;
    private JPanel navigationPanel;
    private JButton displayButton;
    private JButton exitButton;
    
    //constructor
    public Welcome(String frameName)
    {
        //construct the frame
        super(frameName);
        this.setBounds(150,100,900,600);
        this.getContentPane().setBackground(PINK_COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        this.titleLabel = new JLabel("Rates of Change Calculator", SwingConstants.CENTER);
        this.titleLabel.setFont(BIG_FONT);
        this.nameLabel = new JLabel("Esha Garg", SwingConstants.CENTER);
        this.nameLabel.setFont(MED_FONT);
        this.imageLabel = new JLabel(WELCOME_IMAGE);
        this.descriptionLabel = new JLabel("This program will calculate various rates of change when given an equation and value(s).", SwingConstants.CENTER);
        this.descriptionLabel.setFont(SMALL_FONT);
        
        //construct the buttons
        this.startButton = new JButton("Start");
        this.startButton.addActionListener(this);
        this.displayButton = new JButton("Display");
        this.displayButton.addActionListener(this);
        this.exitButton = new JButton("Exit");
        this.exitButton.addActionListener(this);
        
        //construct the panels
        this.infoPanel = new JPanel(new BorderLayout());
        this.infoPanel.setBackground(PINK_COLOR);
        this.infoPanel.add(titleLabel, BorderLayout.CENTER);
        this.infoPanel.add(nameLabel, BorderLayout.SOUTH);
        this.centerPanel = new JPanel(new BorderLayout());
        this.centerPanel.setBackground(PINK_COLOR);
        this.centerPanel.add(imageLabel, BorderLayout.NORTH);
        this.centerPanel.add(descriptionLabel, BorderLayout.CENTER);
        this.navigationPanel = new JPanel(new FlowLayout());
        this.navigationPanel.setBackground(PURPLE_COLOR);
        this.navigationPanel.add(startButton);
        this.navigationPanel.add(displayButton);
        this.navigationPanel.add(exitButton);
        
        //adding to frame
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(navigationPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    //creates the original frame
    public static void main(String[] args)
    {
        Welcome welcomeObj = new Welcome("Welcome Frame");
    }
    
    //creates navigation
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
        else if (command.equals("Start"))
        {
            this.dispose();
            new Input();
        }
        else if (command.equals("Display"))
        {
            this.dispose();
            String dbName = "RatesOfChange";
            String tableName = "Solutions";
            String[] columnHeaders = {"Id", "Equation", "ValueA", "ValueB", "Position", "Displacement", "AverageVelocity", "InstantVelocity", "Speed", "AverageAccel", "InstantAccel"};
            new DisplayDb(dbName, tableName, columnHeaders);
        }
        else if (command.equals("Exit"))
        {
            System.exit(0);
        }
        
        this.validate();
        this.repaint();
    }
}