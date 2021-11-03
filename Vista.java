import java.util.Scanner;
public class Vista {
    Scanner scan;
    public Vista(){
        scan = new Scanner(System.in);
    }

    //@returns la opción elegida por el usuario.
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

    //@params el mensaje a transmitir al usuario.
    public void Mensaje(String s){
        System.out.println(s+"\n");
    }

    //@params el mensaje pidiendo el valor del tipo string al usuario
    //@returns el valor ingresado por el usuario.
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

    //@params el mensaje pidiendo el valor de tipo int al usuario
    //@returns el valor ingresado por el usuario
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
