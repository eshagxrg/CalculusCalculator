/*
Esha Garg 2/2020
This is the input frame for the program
 */
package gargesteamdb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Input extends JFrame implements ActionListener
{

    //declaring variables
    private final java.net.URL RATE_CHANGE_PATH = getClass().getResource("ratechange.png");
    private final ImageIcon RATE_CHANGE_IMAGE = new ImageIcon(new ImageIcon(RATE_CHANGE_PATH)
            .getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT));
    private JMenuBar mainBar;
    private JMenu helpMenu;
    private JMenuItem howToUseMenu;
    private JMenuItem formulaMenu;
    private JPanel submitPanel;
    private JPanel centerPanel;
    private JPanel chooseValuePanel;
    private JLabel valueLabel;
    private JRadioButton oneValueButton;
    private JRadioButton twoValueButton;
    private ButtonGroup valueGroup;
    private JButton submitValueButton;
    private JPanel valuePanel;
    private JLabel valueALabel;
    private JTextField valueAField;
    private JLabel valueBLabel;
    private JTextField valueBField;
    private JPanel termPanel;
    private JLabel termLabel;
    private JTextField coefficientField;
    private JLabel xLabel;
    private JTextField exponentField;
    private JButton submitTermButton;
    private JPanel positionPanel;
    private JLabel positionLabel;
    private JLabel positionEquationLabel;
    private JLabel imageLabel;
    private JButton enterButton;
    private JPanel calculatePanel;
    private JButton calculatePositionButton;
    private JButton calculateDisplacementButton;
    private JButton calculateAverageVelocityButton;
    private JButton calculateInstantaneousVelocityButton;
    private JButton calculateSpeedButton;
    private JButton calculateAverageAccelerationButton;
    private JButton calculateInstantaneousAccelerationButton;
    private JPanel navigationPanel;
    private JButton resetButton;
    private JButton returnButton;
    private JButton exitButton;
    private String equation = "p(x) = ";
    private int counter = 0;
    double aValue = 0;
    double bValue = 0;
    private double outputValue;
    private ArrayList<String> equationOriginal = new ArrayList<>();
    private ArrayList<Double> coefficient = new ArrayList<>();
    private ArrayList<Double> exponent = new ArrayList<>();

    double positionValue;
    double instantVelocityValue;
    double speedValue;
    double instantAccelerationValue;
    double displacementValue;
    double averageVelocityValue;
    double averageAccelerationValue;

    //constructor
    public Input()
    {
        //construct the frame
        super("Input Frame");
        this.setBounds(175, 200, 850, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Welcome.TEAL_COLOR);
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
        this.valueLabel = new JLabel("Number of Values:");
        this.valueLabel.setFont(Welcome.MED_FONT);
        this.valueALabel = new JLabel("   a =");
        this.valueALabel.setFont(Welcome.SMALL_FONT);
        this.valueBLabel = new JLabel("   b =");
        this.valueBLabel.setFont(Welcome.SMALL_FONT);
        this.termLabel = new JLabel("New Term for Position Equation:");
        this.termLabel.setFont(Welcome.MED_FONT);
        this.xLabel = new JLabel("x^");
        this.xLabel.setFont(Welcome.SMALL_FONT);
        this.positionLabel = new JLabel("Position Equation:");
        this.positionLabel.setFont(Welcome.MED_FONT);
        this.positionEquationLabel = new JLabel("");
        this.positionEquationLabel.setFont(Welcome.SMALL_FONT);
        this.imageLabel = new JLabel(RATE_CHANGE_IMAGE);

        //construct the textfields
        this.valueAField = new JTextField(3);
        this.valueBField = new JTextField(3);
        this.coefficientField = new JTextField(3);
        this.exponentField = new JTextField(3);

        //construct the radio buttons
        this.oneValueButton = new JRadioButton("one value (a)");
        this.oneValueButton.setFont(Welcome.SMALL_FONT);
        this.twoValueButton = new JRadioButton("two values [a,b]");
        this.twoValueButton.setFont(Welcome.SMALL_FONT);
        this.valueGroup = new ButtonGroup();
        this.valueGroup.add(oneValueButton);
        this.valueGroup.add(twoValueButton);

        //construct the buttons
        this.submitValueButton = new JButton("Submit Value");
        this.submitValueButton.addActionListener(this);
        this.submitTermButton = new JButton("Add Term");
        this.submitTermButton.addActionListener(this);
        this.submitTermButton.setEnabled(false);
        this.enterButton = new JButton("Enter");
        this.enterButton.addActionListener(this);
        this.enterButton.setEnabled(false);
        this.calculatePositionButton = new JButton("Calculate Position");
        this.calculatePositionButton.addActionListener(this);
        this.calculateDisplacementButton = new JButton("Calculate Displacement");
        this.calculateDisplacementButton.addActionListener(this);
        this.calculateAverageVelocityButton = new JButton("Calculate Average Velocity");
        this.calculateAverageVelocityButton.addActionListener(this);
        this.calculateInstantaneousVelocityButton = new JButton("Calculate Instantaneous Velocity");
        this.calculateInstantaneousVelocityButton.addActionListener(this);
        this.calculateSpeedButton = new JButton("Calculate Speed");
        this.calculateSpeedButton.addActionListener(this);
        this.calculateAverageAccelerationButton = new JButton("Calculate Average Acceleration");
        this.calculateAverageAccelerationButton.addActionListener(this);
        this.calculateInstantaneousAccelerationButton = new JButton("Calculate Instantaneous Acceleration");
        this.calculateInstantaneousAccelerationButton.addActionListener(this);
        this.resetButton = new JButton("Reset");
        this.resetButton.addActionListener(this);
        this.returnButton = new JButton("Return");
        this.returnButton.addActionListener(this);
        this.exitButton = new JButton("Exit");
        this.exitButton.addActionListener(this);

        //construct the panels
        this.chooseValuePanel = new JPanel(new FlowLayout());
        this.chooseValuePanel.setBackground(Welcome.TEAL_COLOR);
        this.chooseValuePanel.add(valueLabel);
        this.chooseValuePanel.add(oneValueButton);
        this.chooseValuePanel.add(twoValueButton);
        this.chooseValuePanel.add(submitValueButton);
        this.termPanel = new JPanel(new FlowLayout());
        this.termPanel.setBackground(Welcome.TEAL_COLOR);
        this.termPanel.add(termLabel);
        this.termPanel.add(coefficientField);
        this.termPanel.add(xLabel);
        this.termPanel.add(exponentField);
        this.termPanel.add(submitTermButton);
        this.valuePanel = new JPanel(new FlowLayout());
        this.valuePanel.setBackground(Welcome.TEAL_COLOR);
        this.positionPanel = new JPanel(new FlowLayout());
        this.positionPanel.setBackground(Welcome.TEAL_COLOR);
        this.submitPanel = new JPanel(new BorderLayout());
        this.submitPanel.setBackground(Welcome.TEAL_COLOR);
        this.submitPanel.add(chooseValuePanel, BorderLayout.NORTH);
        this.submitPanel.add(termPanel, BorderLayout.CENTER);
        this.submitPanel.add(imageLabel, BorderLayout.SOUTH);
        this.calculatePanel = new JPanel(new FlowLayout());
        this.calculatePanel.setBackground(Welcome.TEAL_COLOR);
        this.calculatePanel.add(enterButton);
        this.centerPanel = new JPanel(new BorderLayout());
        this.centerPanel.setBackground(Welcome.TEAL_COLOR);
        this.centerPanel.add(valuePanel, BorderLayout.NORTH);
        this.centerPanel.add(positionPanel, BorderLayout.CENTER);
        this.centerPanel.add(calculatePanel, BorderLayout.SOUTH);
        this.navigationPanel = new JPanel(new FlowLayout());
        this.navigationPanel.setBackground(Welcome.PURPLE_COLOR);
        this.navigationPanel.add(resetButton);
        this.navigationPanel.add(returnButton);
        this.navigationPanel.add(exitButton);

        //adding to frame
        this.add(submitPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    //creates navigation and purpose to buttons
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        Object component = e.getSource();
        double coefficientValue;
        double exponentValue;

        String dbName = "RatesOfChange";
        String tableName = "Solutions";
        String[] tableHeaders =
        {
            "Id", "Equation", "ValueA", "ValueB", "Position", "Displacement", "AverageVelocity", "InstantVelocity", "Speed", "AverageAccel", "InstantAccel"
        };
        //Id, Equation, ValueA, ValueB, Position, Displacement, AverageVelocity, InstantVelocity, Speed, AverageAccel, InstantAccel
        String dbQuery;

        if (component == howToUseMenu)
        {
            new HowToUse();
        }
        else if (component == formulaMenu)
        {
            new Formula();
        }
        else if (command.equals("Submit Value"))
        {
            if (oneValueButton.isSelected())
            {
                this.valuePanel.add(valueALabel);
                this.valuePanel.add(valueAField);
                this.submitValueButton.setEnabled(false);
                this.submitTermButton.setEnabled(true);
            }
            else if (twoValueButton.isSelected())
            {
                this.valuePanel.add(valueALabel);
                this.valuePanel.add(valueAField);
                this.valuePanel.add(valueBLabel);
                this.valuePanel.add(valueBField);
                this.submitValueButton.setEnabled(false);
                this.submitTermButton.setEnabled(true);
            }
            else
            {
                new Warning("Select a button!");
            }
        }
        else if (command.equals("Add Term"))
        {
            try
            {
                coefficientValue = Double.parseDouble(coefficientField.getText());
                exponentValue = Double.parseDouble(exponentField.getText());
                coefficientField.setText("");
                exponentField.setText("");
                coefficient.add(coefficientValue);
                exponent.add(exponentValue);
                if (counter == 0)
                {
                    equation = equation + coefficientValue + "x^" + exponentValue;
                    this.positionPanel.add(positionLabel);
                    this.positionPanel.add(positionEquationLabel);
                    this.enterButton.setEnabled(true);
                }
                else if (counter > 0)
                {
                    equation = equation + " + " + coefficientValue + "x^" + exponentValue;
                }
                this.positionEquationLabel.setText(equation);
                counter++;
            }
            catch (NumberFormatException nfe)
            {
                new Warning("Enter a number!");
            }
        }
        else if (command.equals("Enter"))
        {
            try
            {
                if (oneValueButton.isSelected())
                {
                    aValue = Double.parseDouble(valueAField.getText());
                    this.valueAField.setEnabled(false);
                    this.calculatePanel.remove(enterButton);
                    this.calculatePanel.add(calculatePositionButton);
                    this.calculatePanel.add(calculateSpeedButton);
                    this.calculatePanel.add(calculateInstantaneousVelocityButton);
                    this.calculatePanel.add(calculateInstantaneousAccelerationButton);

                    //adding to db
                    dbQuery = "INSERT INTO Solutions (Equation, ValueA, Position, InstantVelocity, Speed, InstantAccel) VALUES (?,?,?,?,?,?)";
                    //connect to db
                    JavaDatabase objDb = new JavaDatabase(dbName);
                    Connection myDbConn = objDb.getDbConn();

                    //calculating each value
                    Position calcPositionObj = new Position(coefficient, exponent, aValue);
                    positionValue = calcPositionObj.getPositionValue();
                    InstantVelocity calcInstantVelocityObj = new InstantVelocity(coefficient, exponent, aValue);
                    instantVelocityValue = calcInstantVelocityObj.getInstantVelocityValue();
                    Speed calcSpeedObj = new Speed(instantVelocityValue);
                    speedValue = calcSpeedObj.getSpeedValue();
                    InstantAcceleration calcInstantAccelerationObj = new InstantAcceleration(coefficient, exponent, aValue);
                    instantAccelerationValue = calcInstantAccelerationObj.getInstantAccelerationValue();

                    //trying to add to database
                    try
                    {
                        //prepare statement
                        PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
                        //enter data into query
                        ps.setString(1, equation);
                        ps.setDouble(2, aValue);
                        ps.setDouble(3, positionValue);
                        ps.setDouble(4, instantVelocityValue);
                        ps.setDouble(5, speedValue);
                        ps.setDouble(6, instantAccelerationValue);
                        //execute the query
                        ps.executeUpdate();
                    }
                    catch (SQLException se)
                    {
                        System.out.println("Error inserting data " + se.getMessage());
                        se.printStackTrace();
                    } finally
                    {
                        //end of adding to db
                        objDb.closeDbConn();
                    }
                }
                else if (twoValueButton.isSelected())
                {
                    aValue = Double.parseDouble(valueAField.getText());
                    bValue = Double.parseDouble(valueBField.getText());
                    this.valueAField.setEnabled(false);
                    this.valueBField.setEnabled(false);
                    this.calculatePanel.remove(enterButton);
                    this.calculatePanel.add(calculateDisplacementButton);
                    this.calculatePanel.add(calculateSpeedButton);
                    this.calculatePanel.add(calculateAverageVelocityButton);
                    this.calculatePanel.add(calculateAverageAccelerationButton);

                    //adding to db
                    dbQuery = "INSERT INTO Solutions (Equation, ValueA, ValueB, Displacement, AverageVelocity, Speed, AverageAccel) VALUES (?,?,?,?,?,?,?)";
                    //connect to db
                    JavaDatabase objDb = new JavaDatabase(dbName);
                    Connection myDbConn = objDb.getDbConn();

                    //calculating each value
                    Displacement calcDisplacementObj = new Displacement(coefficient, exponent, aValue, bValue);
                    displacementValue = calcDisplacementObj.getDisplacementValue();
                    AverageVelocity calcAverageVelocityObj = new AverageVelocity(coefficient, exponent, aValue, bValue);
                    averageVelocityValue = calcAverageVelocityObj.getAverageVelocityValue();
                    Speed calcSpeedObj = new Speed(averageVelocityValue);
                    speedValue = calcSpeedObj.getSpeedValue();
                    AverageAcceleration calcAverageAccelerationObj = new AverageAcceleration(coefficient, exponent, aValue, bValue);
                    averageAccelerationValue = calcAverageAccelerationObj.getAverageAccelerationValue();

                    //trying to add to database
                    try
                    {
                        //prepare statement
                        PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
                        //enter data into query
                        ps.setString(1, equation);
                        ps.setDouble(2, aValue);
                        ps.setDouble(3, bValue);
                        ps.setDouble(4, displacementValue);
                        ps.setDouble(5, averageVelocityValue);
                        ps.setDouble(6, speedValue);
                        ps.setDouble(7, averageAccelerationValue);
                        //execute the query
                        ps.executeUpdate();
                    }
                    catch (SQLException se)
                    {
                        System.out.println("Error inserting data " + se.getMessage());
                        se.printStackTrace();
                    } finally
                    {
                        //end of adding to db
                        objDb.closeDbConn();
                    }
                }
                else
                {
                    new Warning("Select a button!");
                }
            }
            catch (Exception ge)
            {
                new Warning("Enter a number!");
            }
            this.coefficientField.setEnabled(false);
            this.exponentField.setEnabled(false);
            this.submitTermButton.setEnabled(false);
            equationOriginal.add(equation);
        }

        else if (command.equals("Calculate Position"))
        {
            Position calcPositionObj = new Position(coefficient, exponent, aValue);
            outputValue = calcPositionObj.getPositionValue();
            new Output("Position", outputValue);
        }

        else if (command.equals("Calculate Displacement"))
        {
            Displacement calcDisplacementObj = new Displacement(coefficient, exponent, aValue, bValue);
            outputValue = calcDisplacementObj.getDisplacementValue();
            new Output("Displacement", outputValue);
        }

        else if (command.equals("Calculate Speed"))
        {
            if (oneValueButton.isSelected())
            {
                InstantVelocity calcInstantVelocityObj = new InstantVelocity(coefficient, exponent, aValue);
                outputValue = calcInstantVelocityObj.getInstantVelocityValue();
                Speed calcSpeedObj = new Speed(outputValue);
                outputValue = calcSpeedObj.getSpeedValue();
                new Output("Speed", outputValue);
            }
            else if (twoValueButton.isSelected())
            {
                AverageVelocity calcAverageVelocityObj = new AverageVelocity(coefficient, exponent, aValue, bValue);
                outputValue = calcAverageVelocityObj.getAverageVelocityValue();
                Speed calcSpeedObj = new Speed(outputValue);
                outputValue = calcSpeedObj.getSpeedValue();
                new Output("Speed", outputValue);
            }
        }

        else if (command.equals("Calculate Average Velocity"))
        {
            AverageVelocity calcAverageVelocityObj = new AverageVelocity(coefficient, exponent, aValue, bValue);
            outputValue = calcAverageVelocityObj.getAverageVelocityValue();
            new Output("Average Velocity", outputValue);
        }

        else if (command.equals("Calculate Instantaneous Velocity"))
        {
            InstantVelocity calcInstantVelocityObj = new InstantVelocity(coefficient, exponent, aValue);
            outputValue = calcInstantVelocityObj.getInstantVelocityValue();
            new Output("Instantaneous Velocity", outputValue);
        }

        else if (command.equals("Calculate Average Acceleration"))
        {
            AverageAcceleration calcAverageAccelerationObj = new AverageAcceleration(coefficient, exponent, aValue, bValue);
            outputValue = calcAverageAccelerationObj.getAverageAccelerationValue();
            new Output("Average Acceleration", outputValue);
        }

        else if (command.equals("Calculate Instantaneous Acceleration"))
        {
            InstantAcceleration calcInstantAccelerationObj = new InstantAcceleration(coefficient, exponent, aValue);
            outputValue = calcInstantAccelerationObj.getInstantAccelerationValue();
            new Output("Instantaneous Acceleration", outputValue);
        }

        else if (command.equals("Reset"))
        {
            this.dispose();
            new Input();
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

//created for testing purposes
    public static void main(String[] args)
    {
        new Input();
    }
}
