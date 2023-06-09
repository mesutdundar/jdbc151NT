import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    // pom = page object model
    // dependency nereden = mvnrepository den alınır(normalde şirketten alınır çünkü
    // site public tir virüs falan bulaştırabilir.)
    // Çalıştığınız şirket size verir.
    // mavenrepository sitesinden her türlü dependency bulunabilir
    // database çok sıkıntılı tehlikeli bir yer oldugu için şifresi verilir ama çok kısıtlı
    // bir yetki ile verilir şirket tarafından

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. ADIM: Driver'a kaydol
    //    Class.forName("org.postgresql.Driver");//JDBC 4 sonrası yapmaya gerek yok

        //2. ADIM: Database'e bağlan
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Dm56485648.,,");

        //postgresql de filin üzerine sağ tıkladık, en altta properties dedik ve
        // connectiona gelip bilgilere baktık ve bilgileri oradan aldık
        // hostname/adress + port + maintenance database ==> adresim  ==> localhost:5432/postgres
        // ilk parametrenin başı standarttır. (jdbc:postgresql://...adresim...)
                /*
                 DRY= Don't Repeat Yourself
                 WET= Write Everything Twice
                */

        //3.ADIM :statement olustur.
        Statement statement = connection.createStatement();

        /*
execute() methodu DDL(create, drop, alter table) ve DQL(select) ile kullanılır
1) Eğer execute() methodu DDL ile kullanılırsa hep "false" döner. Çünkü DDL ile data çağrılmaz
2) Eğer execute() methodu DQL ile kullanılırsa data döndüğünde "true" data dönmediğinde "false" verir.
 */

        //4.ADIM : Query calistir (execute : ifa etmek)

        // 1.Örnek: "workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.
        String sql1= "CREATE TABLE workers (worker_id varchar(20),worker_name varchar(20),worker_salary int );\n";
       boolean r1 = statement.execute(sql1);
        System.out.println("r1 = " + r1);//false

        //2.Örnek: Table'a worker_address sütunu ekleyin.
        String sql2 ="ALTER TABLE workers ADD COLUMN worker_adress varchar(100)";
        boolean r2 =statement.execute(sql2);
        System.out.println("r2 = " + r2);//false
        
        //3.Ornek workers tablosnu silin
        String sql3 ="DROP TABLE workers;";
        boolean r3 =statement.execute(sql3);
        System.out.println("r3 = " + r3);

        //5.ADIM: Baglantiyi kapat
        connection.close();
        statement.close();
    }
}
