/*
Esha Garg 3/2020
This program calculates the displacement when given an array list for coefficient and exponents as well as a value a and b
 */
package gargesteamdb;

import java.util.ArrayList;

public class Displacement
{
    //declaring data fields
    private ArrayList<Double> coefficient = new ArrayList<>();
    private ArrayList<Double> exponent = new ArrayList<>();
    private double aValue;
    private double bValue;
    private double displacementValue;
    
    //constructor
    public Displacement(ArrayList<Double> coefficient, ArrayList<Double> exponent, double aValue, double bValue)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.aValue = aValue;
        this.bValue = bValue;
        setDisplacementValue();
    }
    
    //creating in case parameters are left empty
    public Displacement()
    {
        this.coefficient.add(0.0);
        this.exponent.add(0.0);
        this.aValue = 0;
        this.bValue = 0;
        setDisplacementValue();
    }
    
    //get and set methods
    public ArrayList<Double> getCoefficient()
    {
        return coefficient;
    }
    public void setCoefficient(ArrayList<Double> coefficient)
    {
        this.coefficient = coefficient;
    }
    public ArrayList<Double> getExponent()
    {
        return exponent;
    }
    public void setExponent(ArrayList<Double> exponent)
    {
        this.exponent = exponent;
    }
    public double getAValue()
    {
        return aValue;
    }
    public void setAValue(double aValue)
    {
        this.aValue = aValue;
    }
    public double getBValue()
    {
        return bValue;
    }
    public void setBValue(double bValue)
    {
        this.bValue = bValue;
    }
    public double getDisplacementValue()
    {
        return displacementValue;
    }
    public void setDisplacementValue()
    {
        displacementValue = 0;
        Position calcPositionA = new Position(coefficient, exponent, aValue); //finding s(a) using CalculatePosition class
        Position calcPositionB = new Position(coefficient, exponent, bValue); //finding s(b) using CalculatePosition class
        displacementValue = calcPositionB.getPositionValue() - calcPositionA.getPositionValue(); //formula is s(b)-s(a)
    }
    
    //display any data field in this form (create consistency)
    @Override
    public String toString()
    {
        return "The value of the displacement is " + displacementValue;
    }
    
    //for testing purposes
    public static void main(String[] args)
    {
        Displacement calcObj = new Displacement();
        System.out.println(calcObj);
    }
}
