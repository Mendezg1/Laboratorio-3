import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
public class QOM {
    ArrayList<Post>posts = new ArrayList<Post>();
    public QOM(){
        String autor = "Admin";
        ArrayList<String>hashtags = new ArrayList<String>();
        hashtags.add("#QOM");
        hashtags.add("#Bienvenidos");
        hashtags.add("#PrimerDia");
        String texto = "¡Bienvenidos a QueOndaMano!\n Esperamos que la plataforma sea de su agrado. \n ¡Disfruten!";
        posts.add(new Texto(autor,  hashtags, texto));
        posts.get(0).comentarios(":DDDDDDD");
    }

    //La función "Publicar" fue pensada para usarse en todos los casos, pero por los datos fue imposible ya que se deberían solicitar
    //todas las propiedades en cada caso, por lo que se dividió la función en los 5 casos específicos.

    //@params string autor, arraylist de hashtags, string del texto
    public void PublicarTexto(String autor, ArrayList<String>hashtags, String texto){
        posts.add(new Texto(autor, hashtags, texto));
    }

    //@params string del autor, arraylist de hashtags, string del emoticon
    public void PublicarEmoticon(String autor, ArrayList<String>hashtags, String texto){
        posts.add(new Emoticon(autor, hashtags, texto));
    }

    //@params string del autor, arraylist de hashtags, string del url, int del tamaño
    //string del formato de imagen, int de los megapixeles
    public void PublicarImagen(String autor, ArrayList<String>hashtags, int kb, String url, String tipoimg, int mp){
        posts.add(new Imagen(autor, hashtags, kb, url,  tipoimg, mp));
    }

    //@params string del autor, arraylist de hashtags, string del url, int del tamaño
    //int del sample rate, int del bit depth
    public void PublicarAudio(String autor, ArrayList<String>hashtags, int kb, String url, int sr, int bd){
        posts.add(new Audio(autor, hashtags, kb, url, sr, bd));
    }

    //@params string del autor, arraylist de hashtags, int del tamaño, string del url, int del frame rate
    public void PublicarVideo(String autor, ArrayList<String>hashtags, int kb, String url, int fr){
        posts.add(new Video(autor, hashtags, kb, url, fr));
    }

    //Esta función fue mal implementada en el diseño pues Post no tendría el array de los posts, sino QOM.
    //@params la posición del post a devolver
    //@returns el post en la posición indicada.
    public Post getPost(int a){
        return posts.get(a);
    }

    //@params la fecha en formato aa-mm-dd
    //@returns arraylist de las posiciones de los post con la fecha ingresada
    public ArrayList<Integer> BuscarF(String s){
        try{
            LocalDate f = LocalDate.parse(s);
            int año = f.getYear();
            Month mes = f.getMonth();
            int dia = f.getDayOfMonth();
            ArrayList<Integer>resultados = new ArrayList<Integer>();
            for(int i = 0; i < posts.size(); i++){
                if(año == posts.get(i).getFecha().getYear()){
                    if(mes == posts.get(i).getFecha().getMonth()){
                        if(dia == posts.get(i).getFecha().getDayOfMonth()){
                            resultados.add(i);
                        }
                    }
                }
            }
            return resultados;
        }catch(Exception e){
            ArrayList<Integer>resultados = new ArrayList<Integer>();
            resultados.add(-1);
            return resultados;
        }
    }

    //@params el hashtag a buscar en los posts
    //@returns posts con el hashtag ingresado
    public ArrayList<Integer> BuscarH(String s){
        ArrayList<Integer> resultados = new ArrayList<Integer>();
        for(int i = 0; i < posts.size(); i++){
            ArrayList<String>hash = posts.get(i).getHash();
            for(int j = 0; j < hash.size(); j++){
                if(hash.get(j).equals(s)){
                    resultados.add(i);
                }
            }
        }
        return resultados;
    }
}
