package fasttrackit.lottogame;


import java.io.File;
import java.io.IOException;

/**
 * Created by condor on 21/11/15.
 */
public class Demo {

    public static void main(String[] argv) {

//        try {
//            createMyFile("/bubu.txt");
//        } catch (Exception e) {
//            e.printStackTrace();
//            try {
//                createMyFile("bubu.txt");
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//        }
//

        //int[] a = {4,5};
       // int value =a[7];

        calculate();
        System.out.println("si acum continuam");
        calculate();
        System.out.println("salut");

    }

    static int a =0;
    private static void calculate() {
        try {
            a++;
            System.out.print(a);
            if(a<8000)
            calculate();
        } catch (Throwable e) {
            System.out.println("ha ha ha ");
        }
    }


    private static void createMyFile(String param) throws Exception{
        File f = new File(param);
        boolean exista = f.exists();
        System.out.println(exista);
        if(!exista)

            try {
                f.createNewFile();
            } catch (IOException e) {
             //  throw new Exception("ba, asta e natang");
            }

        else
            System.out.println("deja exista");
    }
}
