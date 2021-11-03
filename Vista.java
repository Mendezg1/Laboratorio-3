import java.util.Scanner;
public class Vista {
    Scanner scan;
    public Vista(){
        scan = new Scanner(System.in);
    }

    public int Menu(){
        try{
            System.out.println("\n¡Bienvenido a QueOndaMano! \n ¿Qué Desea Hacer? (Ingrese el número de la opción deseada)");
            System.out.println("1. Publicar un post.");
            System.out.println("2. Buscar posts por fecha.");
            System.out.println("3. Buscar post por hashtag.");
            System.out.println("4. Salir.\n");
            return Integer.parseInt(scan.nextLine());
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    public void Mensaje(String s){
        System.out.println(s+"\n");
    }

    public String askStrings(String s){
        try{
            System.out.println("\n"+s);
            return scan.nextLine();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return "";
        }
    }

    public int askInts(String s){
        try{
            System.out.println("\n"+s);
            return Integer.parseInt(scan.nextLine());
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }
}
