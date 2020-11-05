/*
Esha Garg 3/2020
This program calculates the average velocity when given an array list for coefficient and exponents as well as a value a and b
 */
package gargesteamdb;

import java.util.ArrayList;

public class AverageVelocity
{
    //declaring data fields
    private ArrayList<Double> coefficient = new ArrayList<>();
    private ArrayList<Double> exponent = new ArrayList<>();
    private double aValue;
    private double bValue;
    private double numeratorValue;
    private double averageVelocityValue;
    
    //constructor
    public AverageVelocity(ArrayList<Double> coefficient, ArrayList<Double> exponent, double aValue, double bValue)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.aValue = aValue;
        this.bValue = bValue;
        setAverageVelocityValue();
    }
    
    //creating in case parameters are left empty
    public AverageVelocity()
    {
        this.coefficient.add(0.0);
        this.exponent.add(0.0);
        this.aValue = 0;
        this.bValue = 0;
        setAverageVelocityValue();
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
    public double getNumeratorValue()
    {
        return numeratorValue;
    }
    public void setNumeratorValue(double numeratorValue)
    {
        this.numeratorValue = numeratorValue;
    }
    public double getAverageVelocityValue()
    {
        return averageVelocityValue;
    }
    public void setAverageVelocityValue()
    {
        averageVelocityValue = 0; //formula is (s(b)-s(a))/(b-a) where s is position
        Position calcPositionA = new Position(coefficient, exponent, aValue); //finding s(a) using CalculatePosition class
        Position calcPositionB = new Position(coefficient, exponent, bValue); //finding s(b) using CalculatePosition class
        numeratorValue = calcPositionB.getPositionValue() - calcPositionA.getPositionValue(); //finding s(b)-s(a)
        averageVelocityValue = numeratorValue/(bValue - aValue); //dividing numerator by (b-a)
    }
    
    //display any data field in this form (create consistency)
    @Override
    public String toString()
    {
        return "The value of the average velocity is " + averageVelocityValue;
    }
    
    //for testing purposes
    public static void main(String[] args)
    {
        AverageVelocity calcObj = new AverageVelocity();
        System.out.println(calcObj);
    }
}
