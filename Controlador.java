import java.time.LocalDateTime;
import java.util.ArrayList;
/*
Programa: Laboratorio 3
Programador: Ricardo Méndez - 21289
*/
public class Controlador {
    static public void main(String args[]){
        Vista v = new Vista();
        QOM qom = new QOM();
        int opcion = 0;
        while(opcion != 4){

            opcion = v.Menu();
            if(opcion == 1){
                int op = v.askInts("¿Qué tipo de post desea hacer? \n 1. Texto. \n 2. Emoticon \n 3. Video. \n 4. Audio. \n 5. Imagen.");
                if(op == 1){
                    String a = v.askStrings("Ingrese el autor del post.");
                    int n = v.askInts("¿Cuántos hashtags tendrá el post?");
                    ArrayList<String>hash = new ArrayList<String>();
                    for(int i = 0; i < n; i++){
                        hash.add(v.askStrings("Ingrese el hashtag deseado con su respectivo símbolo (#)\n Ejemplo: #UVG"));
                    }
                    String texto = v.askStrings("Ingrese el texto que tendrá el post.");
                    qom.PublicarTexto(a, hash, texto);
                }

                if(op == 2){
                    String a = v.askStrings("Ingrese el autor del post.");
                    int n = v.askInts("¿Cuántos hashtags tendrá el post?");
                    ArrayList<String>hash = new ArrayList<String>();
                    for(int i = 0; i < n; i++){
                        hash.add(v.askStrings("Ingrese el hashtag deseado con su respectivo símbolo (#)\n Ejemplo: #UVG"));
                    }
                    String texto = v.askStrings("Ingrese el emoticon que tendrá el post.");
                    qom.PublicarEmoticon(a, hash, texto);
                }

                if(op == 3){
                    String a = v.askStrings("Ingrese el autor del post.");
                    int n = v.askInts("¿Cuántos hashtags tendrá el post?");
                    ArrayList<String>hash = new ArrayList<String>();
                    for(int i = 0; i < n; i++){
                        hash.add(v.askStrings("Ingrese el hashtag deseado con su respectivo símbolo (#)\n Ejemplo: #UVG"));
                    }
                    qom.PublicarVideo(a, hash, v.askInts("Ingrese el tamaño del video en kilobytes."), v.askStrings("Ingrese el URL del video."), v.askInts("Ingrese el frame rate del video."));
                }

                if(op == 4){
                    String a = v.askStrings("Ingrese el autor del post.");
                    int n = v.askInts("¿Cuántos hashtags tendrá el post?");
                    ArrayList<String>hash = new ArrayList<String>();
                    for(int i = 0; i < n; i++){
                        hash.add(v.askStrings("Ingrese el hashtag deseado con su respectivo símbolo (#)\n Ejemplo: #UVG"));
                    }
                    qom.PublicarAudio(a, hash, v.askInts("Ingrese el tamaño del audio de kilobytes"), v.askStrings("Ingrese el URL del audio."),
                     v.askInts("Ingrese el sample rate del audio."), v.askInts("Ingrese el bit depth del audio."));
                }

                if(op == 5){
                    String a = v.askStrings("Ingrese el autor del post.");
                    int n = v.askInts("¿Cuántos hashtags tendrá el post?");
                    ArrayList<String>hash = new ArrayList<String>();
                    for(int i = 0; i < n; i++){
                        hash.add(v.askStrings("Ingrese el hashtag deseado con su respectivo símbolo (#)\n Ejemplo: #UVG"));
                    }
                    qom.PublicarImagen(a, hash, v.askInts("Ingrese el tamaño de la imagen en kilobytes."), v.askStrings("Ingrese el URL de la imagen."),
                     v.askStrings("Ingrese el formato de la imagen."), v.askInts("Ingrese la resolución de la imagen en megapixeles."));
                }
            }

            if(opcion == 2){
               try{
                String fecha = v.askStrings("Ingrese de qué fecha desea ver los posts en formato aa-mm-dd. \n Por ejemplo: 2021-05-07 (Mayo 7 de 2021).");
                ArrayList<Integer> posts = new ArrayList<Integer>();
                posts = qom.BuscarF(fecha);
                if(posts.get(0) != -1){
                    if(posts.size() != 0){
                        v.Mensaje("Los posts con la fecha ingresada son:\n");
                        for(int i = 0; i < posts.size(); i++){
                            Post p = qom.getPost(posts.get(i));
                            String a = p.getAutor();
                            String tipo = p.getTipo();
                            LocalDateTime f = p.getFecha();
                            int likes = p.getLikes();
                            ArrayList<String> hashtags = new ArrayList<String>();
                            hashtags = p.getHash();
                            ArrayList<String> comment = new ArrayList<String>();
                            comment = p.getComentarios();
                            if(tipo.equals("Texto") || tipo.equals("Emoticon")){
                                String texto = p.getTexto();
                                String s = "(" + posts.get(i)+")"+a + ". " + f +" likes: "+likes + "\n";
                                for(int j = 0; j<hashtags.size(); j++){
                                    s+= hashtags.get(j) + " ";
                                }
                                s += "\n" +"(" + tipo + ")" + " " + texto+"\n →Comentarios:\n";
                                for(int j = 0; j<comment.size(); j++){
                                    s+= "   - " +comment.get(j) + ".\n";
                                }
                                v.Mensaje(s);
                            }
                            else if(tipo.equals("Imagen")){
                                String[] det = p.getDetalles(1);
                                String s = "(" + posts.get(i)+")"+a + ". " + f +" likes: "+likes + "\n";
                                for(int j = 0; j<hashtags.size(); j++){
                                    s+= hashtags.get(j) + " ";
                                }
                                s+= "\n" +"(" + tipo + ")" + det[1] +"\n" + det[0]+"KB, " + det[3]+", "+det[2]+" Megapixeles.\n";
                                for(int j = 0; j<comment.size(); j++){
                                    s+= "   - " +comment.get(j) + ".\n";
                                }
                                v.Mensaje(s);
                            }
                            else if(tipo.equals("Audio")){
                                String[] det = p.getDetalles(2);
                                String s = "(" + posts.get(i)+")"+a + ". " + f +" likes: "+likes + "\n";
                                for(int j = 0; j<hashtags.size(); j++){
                                    s+= hashtags.get(j) + " ";
                                }
                                s+= "\n" +"(" + tipo + ")" + det[1] +"\n" + det[0]+"KB, " + det[2]+" sample rate, "+det[3]+" bit depth\n";
                                for(int j = 0; j<comment.size(); j++){
                                    s+= "   - " +comment.get(j) + ".\n";
                                }
                                v.Mensaje(s);
                            }
                            else if(tipo.equals("Video")){
                                String[] det = p.getDetalles(3);
                                String s = "(" + posts.get(i)+")"+a + ". " + f +" likes: "+likes + "\n";
                                for(int j = 0; j<hashtags.size(); j++){
                                    s+= hashtags.get(j) + " ";
                                }
                                s+= "\n" +"(" + tipo + ")" + det[1] +"\n" + det[0]+"KB, " + det[2]+" frame rate \n";
                                for(int j = 0; j<comment.size(); j++){
                                    s+= "   - " +comment.get(j) + ".\n";
                                }
                                v.Mensaje(s);
                            }
                        }
                        String yn = v.askStrings("¿Desea dejar un comentario en alguna publicación? Por favor ingrese Y para 'Si' o N para 'No'.").toUpperCase();
                        while(yn.equals("Y")){
                            if(yn.equals("Y")){
                                int n = v.askInts("Ingrese el número de la publicación en la que desea comentar. (Aparece entre corchetes.)\n");
                                String comentario = v.askStrings("Ingrese el comentario que desea realizar\n");
                                qom.getPost(n).comentarios(comentario);
                            }
                            yn = v.askStrings("¿Desea comentar otra publicación? (Y/N)").toUpperCase();
                        }
                        yn = v.askStrings("¿Desea dejar un like en alguna publicación? Por favor responda igual que en la pregunta anterior (Y/N).").toUpperCase();
                        while(yn.equals("Y")){
                            int n = v.askInts("Ingrese el número de la publicación a la que desea dejar un like.(Aparece entre corchetes)\n");
                            qom.getPost(n).Like();
                            yn = v.askStrings("¿Desea dejar un like en otra publicación? (Y/N)");
                        }
                    }
                    else v.Mensaje("No hay ninguna publicación realizada en la fecha ingresada.");
                }else v.Mensaje("Error en el ingreso de la fecha.");
                
               }catch(Exception e){
                   v.Mensaje("La fecha está próxima a suceder o no existe.");
               }
            }

            if(opcion == 3){
                String hashtag = v.askStrings("Ingrese el hashtag que desea buscar en las publicaciones.");
                ArrayList<Integer> posts = qom.BuscarH(hashtag);
                if(posts.size() != 0){
                    v.Mensaje("Los posts con el hashtag ingresado son: \n");
                    for(int i = 0; i < posts.size(); i++){
                        Post p = qom.getPost(posts.get(i));
                        String a = p.getAutor();
                        String tipo = p.getTipo();
                        LocalDateTime f = p.getFecha();
                        int likes = p.getLikes();
                        ArrayList<String> hashtags = new ArrayList<String>();
                        hashtags = p.getHash();
                        ArrayList<String> comment = new ArrayList<String>();
                        comment = p.getComentarios();
                        if(tipo.equals("Texto") || tipo.equals("Emoticon")){
                            String texto = p.getTexto();
                            String s = "(" + posts.get(i)+")"+a + ". " + f +" likes: "+likes + "\n";
                            for(int j = 0; j<hashtags.size(); j++){
                                s+= hashtags.get(j) + " ";
                            }
                            s += "\n" +"(" + tipo + ")" + " " + texto+"\n →Comentarios:\n";
                            for(int j = 0; j<comment.size(); j++){
                                s+= "   - " +comment.get(j) + ".\n";
                            }
                            v.Mensaje(s);
                        }
                        else if(tipo.equals("Imagen")){
                            String[] det = p.getDetalles(1);
                            String s = "(" + posts.get(i)+")"+a + ". " + f +" likes: "+likes + "\n";
                            for(int j = 0; j<hashtags.size(); j++){
                                s+= hashtags.get(j) + " ";
                            }
                            s+= "\n" +"(" + tipo + ")" + det[1] +"\n" + det[0]+"KB, " + det[3]+", "+det[2]+" Megapixeles.\n";
                            for(int j = 0; j<comment.size(); j++){
                                s+= "   - " +comment.get(j) + ".\n";
                            }
                            v.Mensaje(s);
                        }
                        else if(tipo.equals("Audio")){
                            String[] det = p.getDetalles(2);
                            String s = "(" + posts.get(i)+")"+a + ". " + f +" likes: "+likes + "\n";
                            for(int j = 0; j<hashtags.size(); j++){
                                s+= hashtags.get(j) + " ";
                            }
                            s+= "\n" +"(" + tipo + ")" + det[1] +"\n" + det[0]+"KB, " + det[2]+" sample rate, "+det[3]+" bit depth\n";
                            for(int j = 0; j<comment.size(); j++){
                                s+= "   - " +comment.get(j) + ".\n";
                            }
                            v.Mensaje(s);
                        }
                        else if(tipo.equals("Video")){
                            String[] det = p.getDetalles(3);
                            String s = "(" + posts.get(i)+")"+a + ". " + f +" likes: "+likes + "\n";
                            for(int j = 0; j<hashtags.size(); j++){
                                s+= hashtags.get(j) + " ";
                            }
                            s+= "\n" +"(" + tipo + ")" + det[1] +"\n" + det[0]+"KB, " + det[2]+" frame rate \n";
                            for(int j = 0; j<comment.size(); j++){
                                s+= "   - " +comment.get(j) + ".\n";
                            }
                            v.Mensaje(s);
                        }
                    }
                    String yn = v.askStrings("¿Desea dejar un comentario en alguna publicación? Por favor ingrese Y para 'Si' o N para 'No'.").toUpperCase();
                    while(yn.equals("Y")){
                        if(yn.equals("Y")){
                            int n = v.askInts("Ingrese el número de la publicación en la que desea comentar. (Aparece entre corchetes.)\n");
                            String comentario = v.askStrings("Ingrese el comentario que desea realizar\n");
                            qom.getPost(n).comentarios(comentario);
                        }
                        yn = v.askStrings("¿Desea comentar otra publicación? (Y/N)").toUpperCase();
                    }
                    yn = v.askStrings("¿Desea dejar un like en alguna publicación? Por favor responda igual que en la pregunta anterior (Y/N).").toUpperCase();
                    while(yn.equals("Y")){
                        int n = v.askInts("Ingrese el número de la publicación a la que desea dejar un like.(Aparece entre corchetes)\n");
                        qom.getPost(n).Like();
                        yn = v.askStrings("¿Desea dejar un like en otra publicación? (Y/N)");
                    }
                }
            }
        }
    }
}
