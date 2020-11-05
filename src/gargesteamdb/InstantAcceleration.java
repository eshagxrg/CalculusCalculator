/*
Esha Garg 3/2020
This program calculates the acceleration when given an array list for coefficient and exponents as well as a value a
 */
package gargesteamdb;

import java.util.ArrayList;

public class InstantAcceleration
{
    //declaring data fields
    private ArrayList<Double> coefficient = new ArrayList<>();
    private ArrayList<Double> exponent = new ArrayList<>();
    private ArrayList<Double> coefficientVelocity = new ArrayList<>();
    private ArrayList<Double> exponentVelocity = new ArrayList<>();
    private ArrayList<Double> coefficientAcceleration = new ArrayList<>();
    private ArrayList<Double> exponentAcceleration = new ArrayList<>();
    private double aValue;
    private double instantAccelerationValue;
    
    //constructor
    public InstantAcceleration(ArrayList<Double> coefficient, ArrayList<Double> exponent, double aValue)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.aValue = aValue;
        setInstantAccelerationValue();
    }
    
    //creating in case parameters are left empty
    public InstantAcceleration()
    {
        this.coefficient.add(0.0);
        this.exponent.add(0.0);
        this.aValue = 0;
        setInstantAccelerationValue();
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
    public ArrayList<Double> getCoefficientVelocity()
    {
        return coefficientVelocity;
    }
    public void setCoefficientVelocity(ArrayList<Double> coefficientVelocity)
    {
        this.coefficientVelocity = coefficientVelocity;
    }
    public ArrayList<Double> getExponentVelocity()
    {
        return exponentVelocity;
    }
    public void setExponentVelocity(ArrayList<Double> exponentVelocity)
    {
        this.exponentVelocity = exponentVelocity;
    }
    public ArrayList<Double> getCoefficientAcceleration()
    {
        return coefficientAcceleration;
    }
    public void setCoefficientAcceleration(ArrayList<Double> coefficientAcceleration)
    {
        this.coefficientAcceleration = coefficientAcceleration;
    }
    public ArrayList<Double> getExponentAcceleration()
    {
        return exponentAcceleration;
    }
    public void setExponentAcceleration(ArrayList<Double> exponentAcceleration)
    {
        this.exponentAcceleration = exponentAcceleration;
    }
    public double getAValue()
    {
        return aValue;
    }
    public void setAValue(double aValue)
    {
        this.aValue = aValue;
    }
    public double getInstantAccelerationValue()
    {
        return instantAccelerationValue;
    }
    public void setInstantAccelerationValue()
    {
        instantAccelerationValue = 0; //formula is s''(a) which is the second derivative of the position function
        for (int i=0; i<coefficient.size(); i++)
        {
            coefficientVelocity.add(coefficient.get(i) * exponent.get(i)); //first derivative using the power rule
            exponentVelocity.add(exponent.get(i) - 1); //first derivative using the power rule
            coefficientAcceleration.add(coefficientVelocity.get(i) * exponentVelocity.get(i)); //second derivative
            exponentAcceleration.add(exponentVelocity.get(i) - 1); //second derivative
            instantAccelerationValue = instantAccelerationValue + (coefficientAcceleration.get(i) * Math.pow(aValue, exponentAcceleration.get(i))); //multiplying to get value of term and adding all terms
        }
    }
    
    //display any data field in this form
    @Override
    public String toString()
    {
        return "The value of the instantaneous acceleration is " + instantAccelerationValue;
    }
    
    //for testing purposes
    public static void main(String[] args)
    {
        InstantAcceleration calcObj = new InstantAcceleration();
        System.out.println(calcObj);
    }
}
