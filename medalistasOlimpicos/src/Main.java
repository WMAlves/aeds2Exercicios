import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList <String> listaMedatlista = new ArrayList<>();

       File file = new File("C:\\Users\\998780\\Downloads\\medallists.csv");
       Scanner sc = null;

       try {
           sc = new Scanner(file);

           while (sc.hasNextLine()) {
                listaMedatlista.add(sc.nextLine());


           }
       }catch (IOException e){
               System.out.println("Erro" +e.getMessage());
           } finally {
           if (sc!=null){
               sc.close();
           }
        for (int i=0; i < listaMedatlista.size();i++){
            System.out.println(listaMedatlista.get(i));
        }


       }
    }

}