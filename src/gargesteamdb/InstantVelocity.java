/*
Esha Garg 3/2020
This program calculates the velocity when given an array list for coefficient and exponents as well as a value a
 */
package gargesteamdb;

import java.util.ArrayList;

public class InstantVelocity
{
    //declaring data fields
    private ArrayList<Double> coefficient = new ArrayList<>();
    private ArrayList<Double> exponent = new ArrayList<>();
    private ArrayList<Double> coefficientVelocity = new ArrayList<>();
    private ArrayList<Double> exponentVelocity = new ArrayList<>();
    private double aValue;
    private double instantVelocityValue;
    
    //constructor
    public InstantVelocity(ArrayList<Double> coefficient, ArrayList<Double> exponent, double aValue)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.aValue = aValue;
        setInstantVelocityValue();
    }
    
    //creating in case parameters are left empty
    public InstantVelocity()
    {
        this.coefficient.add(0.0);
        this.exponent.add(0.0);
        this.aValue = 0;
        setInstantVelocityValue();
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
    public double getAValue()
    {
        return aValue;
    }
    public void setAValue(double aValue)
    {
        this.aValue = aValue;
    }
    public double getInstantVelocityValue()
    {
        return instantVelocityValue;
    }
    public void setInstantVelocityValue()
    {
        instantVelocityValue = 0; //formula is s'(a) which is the first derivative of position function
        for (int i=0; i<coefficient.size(); i++)
        {
            coefficientVelocity.add(coefficient.get(i) * exponent.get(i)); //first derivative using the power rule
            exponentVelocity.add(exponent.get(i) - 1); //first derivative using the power rule
            instantVelocityValue = instantVelocityValue + (coefficientVelocity.get(i) * Math.pow(aValue, exponentVelocity.get(i))); //multiplying to get value of term and adding all terms
        }
    }
    
    //display any data field in this form
    @Override
    public String toString()
    {
        return "The value of the instantaneous velocity is " + instantVelocityValue;
    }
    
    //for testing purposes
    public static void main(String[] args)
    {
        InstantVelocity calcObj = new InstantVelocity();
        System.out.println(calcObj);
    }
}
