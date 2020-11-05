/*
Esha Garg 5/2020
This class displays the database in a table format
 */
package gargesteamdb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;


public class DisplayDb extends JFrame implements ActionListener
{
    //declaring variables
    private JMenuBar mainBar;
    private JMenu helpMenu;
    private JMenuItem howToUseMenu;
    private JMenuItem formulaMenu;
    private JPanel infoPanel;
    private JLabel titleLabel;
    private JPanel navigationPanel;
    private JButton returnButton;
    private JButton exitButton;
    
    private ArrayList<ArrayList<String>> dataList;
    private Object [][] data;
    private JTable dbTable;
    private JScrollPane scrollTable;
    private JTableHeader header;
    private TableColumn column;
    
    //constructor
    public DisplayDb(String dbName, String tableName, String[] tableHeaders)
    {
        //construct the frame
        super("Display");
        this.setBounds(50,100,1350,600);
        this.getContentPane().setBackground(Welcome.LIGHT_BLUE_COLOR);
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
        
        //construct the data
        JavaDatabase dbObj = new JavaDatabase(dbName);
        dataList = dbObj.getData(tableName, tableHeaders);
        if (dataList.size() == 0)
        {
            data = new Object[0][0];
        }
        else
        {
            data = dbObj.to2dArray(dataList);
        }
        dbObj.closeDbConn();
        
        //construct the table
        dbTable = new JTable(data, tableHeaders);
        //format table
        dbTable.setGridColor(Color.BLACK);
        dbTable.setBackground(Welcome.LIGHT_BLUE_COLOR);
        dbTable.setFont(Welcome.SMALL_FONT);
        //format header
        header = dbTable.getTableHeader();
        header.setBackground(Welcome.MED_BLUE_COLOR);
        header.setForeground(Color.WHITE);
        header.setFont(Welcome.SMALL_FONT);
        //format rows
        dbTable.setRowHeight(25);
        //format columns
        column = dbTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(5);
        column = dbTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(70);
        column = dbTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(10);
        column = dbTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(10);
        column = dbTable.getColumnModel().getColumn(4);
        column.setPreferredWidth(50);
        column = dbTable.getColumnModel().getColumn(5);
        column.setPreferredWidth(50);
        column = dbTable.getColumnModel().getColumn(6);
        column.setPreferredWidth(50);
        column = dbTable.getColumnModel().getColumn(7);
        column.setPreferredWidth(50);
        column = dbTable.getColumnModel().getColumn(8);
        column.setPreferredWidth(50);
        column = dbTable.getColumnModel().getColumn(9);
        column.setPreferredWidth(50);
        column = dbTable.getColumnModel().getColumn(10);
        column.setPreferredWidth(50);
        //scroll table
        scrollTable = new JScrollPane();
        scrollTable.getViewport().add(dbTable);
        dbTable.setFillsViewportHeight(true);
        
        //construct the labels
        this.titleLabel = new JLabel("Display Database", SwingConstants.CENTER);
        this.titleLabel.setFont(Welcome.MED_FONT);
        
        //construct the buttons
        this.returnButton = new JButton("Return");
        this.returnButton.addActionListener(this);
        this.exitButton = new JButton("Exit");
        this.exitButton.addActionListener(this);
        
        //construct the panels
        this.infoPanel = new JPanel(new BorderLayout());
        this.infoPanel.setBackground(Welcome.LIGHT_BLUE_COLOR);
        this.infoPanel.add(titleLabel, BorderLayout.CENTER);
        this.navigationPanel = new JPanel(new FlowLayout());
        this.navigationPanel.setBackground(Welcome.LIGHT_BLUE_COLOR);
        this.navigationPanel.add(returnButton);
        this.navigationPanel.add(exitButton);
        
        //adding to frame
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(scrollTable, BorderLayout.CENTER);
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
            new Welcome("Welcome Frame");
        }
        else if (command.equals("Exit"))
        {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
    
    public static void main(String[] args)
    {
        String dbName = "RatesOfChange";
        String tableName = "Solutions";
        String[] columnHeaders = {"Id", "Equation", "ValueA", "ValueB", "Position", "Displacement", "AverageVelocity", "InstantVelocity", "Speed", "AverageAccel", "InstantAccel"};
        new DisplayDb(dbName, tableName, columnHeaders);
    }
}
