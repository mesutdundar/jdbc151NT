import java.sql.*;


public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {

      Connection connection=  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Dm56485648.,,");
        Statement statement=connection.createStatement();
        System.out.println("===== 1. ORNEK =====");
        //1. Örnek:  region id'si 1 olan "country name" değerlerini çağırın.
        String sql1 ="select country_name from countries where region_id=1;\n";
        boolean r1 =statement.execute(sql1);
        System.out.println("r1 = " + r1);//true ==> DQL ie data cagirdigimiz icin true dondu

        //Datayi cagirip okumak icin executeQuery() methodunu kullanmaliyiz. execute() methodu sadece true yada false doner
        ResultSet resultSet =statement.executeQuery(sql1);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
        System.out.println("=====2. ORNEK=====");
        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.
        String sql2 = "SELECT country_id,country_name FROM countries WHERE region_id>2;";
        ResultSet resultSet1 = statement.executeQuery(sql2);
        while (resultSet1.next()){
            System.out.println(resultSet1.getString(1)+"-- "+resultSet1.getString(2));
        }
        // cagirmayla gelen kolon index numaralari bizim cagirmamiza gore gelir, tabloda kacinci sirada oldugu onemli degil!
        // uzerinde bir islem yapmayip sadece yazdiracaksak getObject() de kullanabilirdik.
        System.out.println("====3. ORNEK ====");
        //3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        String sql3="select * from companies order by number_of_employees limit 1; \n";
       ResultSet resultSet2 = statement.executeQuery(sql3);
       while (resultSet2.next()){
           System.out.println(resultSet2.getObject(1)+" "+resultSet2.getObject(2)+" "+resultSet2.getObject("number_of_employees"));
       }
        connection.close();
       statement.close();

    }
}
