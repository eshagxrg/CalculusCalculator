/*
Esha Garg 3/2020
This program calculates the speed when given a value for velocity
 */
package gargesteamdb;


public class Speed
{
    //declaring data fields
    private double velocityValue;
    private double speedValue;
    
    //constructor
    public Speed(double velocityValue)
    {
        this.velocityValue = velocityValue;
        setSpeedValue();
    }
    
    //creating in case parameters are left empty
    public Speed()
    {
        this.velocityValue = 0;
        this.speedValue = 0;
    }
    
    //get and set methods
    public double getVelocityValue()
    {
        return velocityValue;
    }
    public void setVelocityValue(double velocityValue)
    {
        this.velocityValue = velocityValue;
    }
    public double getSpeedValue()
    {
        return speedValue;
    }
    public void setSpeedValue()
    {
        speedValue = Math.abs(velocityValue); //formula is |v(a)|, simply finding the absolute value when the velocity has been given
    }
    
    //display any data field in this form (create consistency)
    @Override
    public String toString()
    {
        return "The value of the speed is " + speedValue;
    }
    
    //for testing purposes
    public static void main(String[] args)
    {
        Speed calcObj = new Speed(4.5);
        System.out.println(calcObj);
    }
}
