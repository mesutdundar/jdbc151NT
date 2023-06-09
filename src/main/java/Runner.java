public class Runner {
    public static void main(String[] args) {
        //Database'e baglan
        JdbcUtils.connectToDataBase();

        //Statement olustur.
        JdbcUtils.createStatement();

        //Query'u calistir
        String sql1= "CREATE TABLE workers (worker_id varchar(20),worker_name varchar(20),worker_salary int );\n";

        JdbcUtils.execute(sql1);

        JdbcUtils.closeConnection();
    }
}
