import org.junit.Test;

import static junit.framework.TestCase.*;

public class JunitTest01 {
    //bundan sonra tester olarak main method kullanacagimiz yerler cok nadir gelecek!!!!
    //bundan sonra test methodu kullanacagiz
    //test methodu Junit'in test annotation'i ile olusur.
    //run butonu asagidaki gibi test annotationi ile geldi
    //ikisinden bagimsiz ayri ayri iki test calisablir

    @Test
    public void test01(){

        assertEquals(1,1);//assertEquals() methodunda parantez icindeki parametreler birbirine esitse test gecer, degilse kalir.
        assertTrue("Merhaba".contains("a"));//assertTrue() methodunun parentez icindeki kosul true ise test gecer, degilse kalir.
        assertFalse(1==2);//negative test --> parantez içi durum false dönerse test geçer


    }


}
