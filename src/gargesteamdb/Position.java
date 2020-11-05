/*
Esha Garg 3/2020
This program calculates the position when given an array list for coefficient and exponents as well as a value a
 */
package gargesteamdb;

import java.util.ArrayList;

public class Position
{
    //declaring data fields
    private ArrayList<Double> coefficient = new ArrayList<>();
    private ArrayList<Double> exponent = new ArrayList<>();
    private double aValue;
    private double positionValue;
    
    //constructor
    public Position(ArrayList<Double> coefficient, ArrayList<Double> exponent, double aValue)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.aValue = aValue;
        setPositionValue();
    }
    
    //creating in case parameters are left empty
    public Position()
    {
        this.coefficient.add(0.0);
        this.exponent.add(0.0);
        this.aValue = 0;
        setPositionValue();
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
    public double getPositionValue()
    {
        return positionValue;
    }
    public void setPositionValue()
    {
        positionValue = 0; //formula is s(a)
        for (int i=0; i<coefficient.size(); i++)
        {
            positionValue = positionValue + (coefficient.get(i) * Math.pow(aValue, exponent.get(i))); //multiplying to get value of term and adding all terms
        }
    }
    
    //display any data field in this form (create consistency)
    @Override
    public String toString()
    {
        return "The value of the position is " + positionValue;
    }
    
    //for testing purposes
    public static void main(String[] args)
    {
        Position calcObj = new Position();
        System.out.println(calcObj);
    }
}
