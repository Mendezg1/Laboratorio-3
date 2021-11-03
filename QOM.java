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
    public void PublicarTexto(String autor, ArrayList<String>hashtags, String texto){
        posts.add(new Texto(autor, hashtags, texto));
    }

    public void PublicarEmoticon(String autor, ArrayList<String>hashtags, String texto){
        posts.add(new Emoticon(autor, hashtags, texto));
    }

    public void PublicarImagen(String autor, ArrayList<String>hashtags, int kb, String url, String tipoimg, int mp){
        posts.add(new Imagen(autor, hashtags, kb, url,  tipoimg, mp));
    }

    public void PublicarAudio(String autor, ArrayList<String>hashtags, int kb, String url, int sr, int bd){
        posts.add(new Audio(autor, hashtags, kb, url, sr, bd));
    }

    public void PublicarVideo(String autor, ArrayList<String>hashtags, int kb, String url, int fr){
        posts.add(new Video(autor, hashtags, kb, url, fr));
    }

    //Esta función fue mal implementada en el diseño pues Post no tendría el array de los posts, sino QOM.
    public Post getPost(int a){
        return posts.get(a);
    }

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
