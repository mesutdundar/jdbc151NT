import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class CountryTest {

     /*
 Given
   User connects to the database
   (Kullanıcı veritabanına bağlanır)

 When
   User sends the query to get the region ids from "countries" table
   (Kullanıcı, 'countries' table'dan 'region id' almak üzere query gönderir )

 Then
   Assert that the number of region ids greater than 1 is 17.
   (1'den büyük region id'lerin sayısının 17 olduğunu doğrula )

 And
   User closes the connection
*/
    @Test
    public void countryTest () throws SQLException {
       // User connects to the database
        JdbcUtils.connectToDataBase();
        JdbcUtils.createStatement();
        //   User sends the query to get the region ids from "countries" table
        String sql = " SELECT count(region_id) from countries where region_id>1";
       ResultSet resultSet = JdbcUtils.executeQuery(sql);
       //   Assert that the number of region ids greater than 1 is 17.
        resultSet.next();
        int result = resultSet.getInt(1);
        assertEquals(17,result);
       // User closes the connection
        JdbcUtils.closeConnection();


    }
    //alttaki test usttekini list ile ve looopla cozumu
    @Test
    public void countryTest2() throws SQLException {
        // User connects to the database
        JdbcUtils.connectToDataBase();
        JdbcUtils.createStatement();
        //   User sends the query to get the region ids from "countries" table

        String sql = " SELECT region_id from countries where region_id>1";
        ResultSet resultSet = JdbcUtils.executeQuery(sql);
       // System.out.println(resultSet.getMetaData().getColumnName(1));//columnun ismini almak istersek bu getmetadata methodunu kullanabiliriz
        List<Integer> region_idList =new ArrayList<>();
        while (resultSet.next()){
            region_idList.add(resultSet.getInt("region_id"));
        }
        System.out.println("region_idList = " + region_idList);

        //   Assert that the number of region ids greater than 1 is 17.
        assertEquals(17,region_idList.size());

        // User closes the connection
        JdbcUtils.closeConnection();
    }







     }
