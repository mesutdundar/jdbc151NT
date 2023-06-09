public class Test01 {
    public static void main(String[] args) {
//asagidaki gibi otomasyon testi olmaz
        String str ="Merhaba";
        if (str.contains("er")){
            System.out.println("PASS");
        }else System.out.println("FAIL");
    }

    //Otomasyon testi yapabilmemiz için bir test framework'üne ihtiyacımız vardır(jUnit,Cucumber,testNG gibi )


}
