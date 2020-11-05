/*
Esha Garg 5/22/20
This program connects java and the database
 */
package gargesteamdb;

public class InstallDb
{
    public static void main(String[] args)
    {
        String dbName = "RatesOfChange";
        //creating an object of db class
        JavaDatabase objDb = new JavaDatabase();
        //creating a new database
        objDb.createDb(dbName);
        
        //creating a new table
        String newTable = "CREATE TABLE Solutions (Id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), Equation varchar(255), ValueA double, ValueB double, Position double, "
                + "Displacement double, AverageVelocity double, InstantVelocity double, Speed double, AverageAccel double, "
                + "InstantAccel double)";
        objDb.createTable(newTable, dbName);
    }
}