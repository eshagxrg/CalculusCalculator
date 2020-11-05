/*
Esha Garg 3/2020
This program calculates the average acceleration when given an array list for coefficient and exponents as well as a value a and b
 */
package gargesteamdb;

import java.util.ArrayList;

public class AverageAcceleration
{
    //declaring data fields
    private ArrayList<Double> coefficient = new ArrayList<>();
    private ArrayList<Double> exponent = new ArrayList<>();
    private double aValue;
    private double bValue;
    private double numeratorValue;
    private double averageAccelerationValue;
    
    //constructor
    public AverageAcceleration(ArrayList<Double> coefficient, ArrayList<Double> exponent, double aValue, double bValue)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.aValue = aValue;
        this.bValue = bValue;
        setAverageAccelerationValue();
    }
    
    //creating in case parameters are left empty
    public AverageAcceleration()
    {
        this.coefficient.add(0.0);
        this.exponent.add(0.0);
        this.aValue = 0;
        this.bValue = 0;
        setAverageAccelerationValue();
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
    public double getAverageAccelerationValue()
    {
        return averageAccelerationValue;
    }
    public void setAverageAccelerationValue()
    {
        averageAccelerationValue = 0; //formula is (v(b)-v(a))/(b-a) where v is velocity
        InstantVelocity calcVelocityA = new InstantVelocity(coefficient, exponent, aValue); //finding v(a) using CalculateInstantVelocity class
        InstantVelocity calcVelocityB = new InstantVelocity(coefficient, exponent, bValue); //finding v(b) using CalculateInstantVelocity class
        numeratorValue = calcVelocityB.getInstantVelocityValue() - calcVelocityA.getInstantVelocityValue(); //(v(b)-v(a))
        averageAccelerationValue = numeratorValue/(bValue - aValue); //dividing numerator by (b-a)
    }
    
    //display any data field in this form (create consistency)
    @Override
    public String toString()
    {
        return "The value of the average acceleration is " + averageAccelerationValue;
    }
    
    //for testing purposes
    public static void main(String[] args)
    {
        AverageAcceleration calcObj = new AverageAcceleration();
        System.out.println(calcObj);
    }
}
