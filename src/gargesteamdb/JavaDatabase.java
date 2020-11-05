/*
Esha Garg 5/22/20
This program connects java and the database
 */
package gargesteamdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JavaDatabase
{

    private String dbName;
    private Connection dbConn;
    private ArrayList<ArrayList<String>> data;
    
    public JavaDatabase() //when you do not have a database yet
    {
        dbName = "";
        dbConn = null;
        data = null;
    }
    
    public JavaDatabase(String dbName) //asumes existing database
    {
        setDbName(dbName);
        setDbConn();
        data = null;
    }

    //get and set methods
    public String getDbName()
    {
        return dbName;
    }

    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    public Connection getDbConn()
    {
        return dbConn;
    }

    public void setDbConn()
    {
        String connectionURL = "jdbc:derby:" + this.dbName;
        this.dbConn = null;
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConn = DriverManager.getConnection(connectionURL);
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Driver not found, check Library");
        }
        catch (SQLException se)
        {
            System.out.println("SQL Connection error!");
        }
    }

    public void closeDbConn()
    {
        try
        {
            this.dbConn.close();
        }
        catch (Exception err)
        {
            System.out.println("DB closing error.");
        }
    }
    
    public ArrayList<ArrayList<String>> getData(String tableName, String[] tableHeaders) //receive data from the database and return it
    {
        int columnCount = tableHeaders.length;
        Statement s = null;
        ResultSet rs = null;
        String dbQuery = "SELECT * FROM " + tableName;
        this.data = new ArrayList<>();
        
        //read the data
        try
        {
            //send the query and recieve data
            s = this.dbConn.createStatement();
            rs = s.executeQuery(dbQuery); //reads query and assigns to object of ResultSet
            
            //read the data using rs and store in ArrayList data
            while (rs.next())
            {
                //row object to hold one row data
                ArrayList<String> row = new ArrayList<>();
                //go through the row and read each cell
                for (int i=0; i<columnCount; i++)
                {
                    //read cell i and add the cell to the row
                    String cell = rs.getString(tableHeaders[i]);
                    row.add(cell);      
                }
                //add the row to the data
                this.data.add(row);
            }
        }
        catch (SQLException se)
        {
            System.out.println("SQL Error: Not able to get data");
        }
        return data;
    }

    public void setData(ArrayList<ArrayList<String>> data)
    {
        this.data = data;
    }
    
    public void createDb(String newDbName)
    {
        setDbName(newDbName);
        String connectionURL = "jdbc:derby:" + this.dbName + ";create=true";
        this.dbConn = null;
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConn = DriverManager.getConnection(connectionURL);
            System.out.println("New Database " + this.dbName + " created!");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Driver not found, check Library");
        }
        catch (SQLException se)
        {
            System.out.println("SQL Connection error, Db was not created!");
        }
    }
    
    public void createTable(String newTable, String dbName)
    {
        System.out.println(newTable);
        setDbName(dbName);
        setDbConn();
        Statement s;
        try
        {
            s = this.dbConn.createStatement();
            s.execute(newTable);
            System.out.println("New table created!");
        }
        catch (SQLException se)
        {
            System.out.println("SQL connection error or syntax error!");
        }
    }
    
    public Object[][] to2dArray(ArrayList<ArrayList<String>> data)
    {
        if (data.size() == 0)
        {
            Object[][] dataList = new Object[0][0];
            return dataList;
        }
        else
        {
            int columnCount = data.get(0).size(); //number of members of the row
            Object[][] dataList = new Object[data.size()][columnCount];
            for (int i = 0; i < data.size(); i++)
            {
                ArrayList<String> row = data.get(i);
                for (int j = 0; j < columnCount; j++)
                {
                    dataList[i][j] = row.get(j);
                }
            }
            return dataList;
        }
    }
    
    //for testing purposes
    public static void main(String[] args)
    {
        // db info
        String dbName = "RatesOfChange";
        String tableName = "Solutions";
        String[] columnName = {"Id", "Equation", "ValueA", "ValueB", "Position", "Displacement", "AverageVelocity", "InstantVelocity", "Speed", "AverageAccel", "InstantAccel"};
        String dbQuery = "INSERT INTO Solutions VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        // connect to db
        JavaDatabase objDb = new JavaDatabase(dbName);
        Connection myDbConn = objDb.getDbConn();
        
        // data to be entered
        String equation = "hehehehe";
        double valueA = 3;
        double valueB = 9;
        double displacement = 2;
        double avVelocity = 4;
        double speed = 8;
        double avAcceleration = 5;
        
        try
        {
            // prepare statement
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
            // enter data into query
            ps.setString(1, equation);
            ps.setDouble(2, valueA);
            ps.setDouble(3, valueB);
            ps.setDouble(5, displacement);
            ps.setDouble(6, avVelocity);
            ps.setDouble(8, speed);
            ps.setDouble(9, avAcceleration);
            // execute the query
            ps.executeUpdate();
            System.out.println("Data inserted successfully");
        }
        catch (SQLException se)
        {
            System.out.println("Error inserting data");
        }
        
        ArrayList<ArrayList<String>> myData = objDb.getData(tableName, columnName);
        System.out.println(myData);
    }
}