/*
Esha Garg 2/10/20
This is the warning frame for the program
 */
package gargesteamdb;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class Warning extends JFrame implements ActionListener
{

    //declaring variables
    private final java.net.URL WARNING_PATH = getClass().getResource("warning.png");
    private final ImageIcon WARNING_IMAGE = new ImageIcon(new ImageIcon(WARNING_PATH)
            .getImage().getScaledInstance(250, 225, Image.SCALE_DEFAULT));
    private JLabel warningLabel;
    private JLabel imageLabel;
    private JPanel closePanel;
    private JButton closeButton;

    public Warning(String message)
    {
        //constructing frame
        super("Warning Frame");
        this.setBounds(350,250,500,350);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Welcome.RED_COLOR);
        this.setLayout(new BorderLayout());

        //constructing label
        this.warningLabel = new JLabel(message, SwingConstants.CENTER);
        this.warningLabel.setFont(Welcome.MED_FONT); //you can use public constants in other classes
        this.warningLabel.setForeground(Color.WHITE);
        this.imageLabel = new JLabel(WARNING_IMAGE);

        //constructing button
        this.closeButton = new JButton("Close");
        this.closeButton.addActionListener(this);
        
        //constructing panel
        this.closePanel = new JPanel(new FlowLayout());
        this.closePanel.setBackground(Welcome.RED_COLOR);
        this.closePanel.add(closeButton);

        this.add(warningLabel, BorderLayout.NORTH);
        this.add(imageLabel, BorderLayout.CENTER);
        this.add(closePanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Warning("Testing");
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
