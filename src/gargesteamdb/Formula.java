/*
Esha Garg 3/2020
This is the formula frame for the program, part of the help menu
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


public class Formula extends JFrame implements ActionListener
{
    //declaring variables
    private final java.net.URL FORMULA_PATH = getClass().getResource("formula.jpeg");
    private final ImageIcon FORMULA_IMAGE = new ImageIcon(new ImageIcon(FORMULA_PATH)
            .getImage().getScaledInstance(150,115,Image.SCALE_DEFAULT));
    private JLabel imageLabel;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JLabel infoLabel;
    private JButton exitButton;
    private JPanel exitPanel;
    
    //constructor
    public Formula()
    {
        //consrtuct the frame
        super("Formula Frame");
        this.setBounds(350,250,500,350);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Welcome.LIGHT_BLUE_COLOR);
        this.setLayout(new BorderLayout());
        
        //construct the labels
        this.titleLabel = new JLabel("Formulas", SwingConstants.CENTER);
        this.titleLabel.setFont(Welcome.MED_FONT);
        this.imageLabel = new JLabel(FORMULA_IMAGE);
        this.infoLabel = new JLabel("<html><center>Position: s(t) <br> Displacement: s(b)-s(a) <br> Speed: |v(t)| <br>"
                + "Instantaneous Velocity: v(t) = s'(t) <br> Average Velocity: [s(b)-s(a)]/[b-a] <br>"
                + "Instantaneous Acceleration: a(t) = v'(t) = s''(t) <br> Average Acceleration: [v(b)-v(a)]/[b-a] </center></html>");
        this.infoLabel.setHorizontalAlignment(JLabel.CENTER);
        
        //construct the buttons
        this.exitButton = new JButton("Close");
        this.exitButton.addActionListener(this);
        
        //construct the panel
        this.titlePanel = new JPanel(new BorderLayout());
        this.titlePanel.setBackground(Welcome.LIGHT_BLUE_COLOR);
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
        new Formula();
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