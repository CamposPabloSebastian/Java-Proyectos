package proyecto.multimedia.objetos;


import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pscam
 */
public class EstanteriaMultimedia implements Iterable<Multimedia> {

    private Multimedia[] listaMultimedia;
    private int contador;
    private EscrituraLecturaDeObjetosMultimedia escrituraLectura;

    /**
     * constructor que inicializa un array de Multimedia
     *
     * @param tamañoMaximo tamaño del array
     */
    public EstanteriaMultimedia(int tamañoMaximo) {
        this.listaMultimedia = new Multimedia[tamañoMaximo];
        this.contador = 0;
        escrituraLectura = new EscrituraLecturaDeObjetosMultimedia("estanteria.txt");
    }

    /**
     * metodo que devuelve la cantidad de objetos contenidos en el array
     *
     * @return cantidad de objetos
     */
    public int size() {
        return contador;
    }

    /**
     * metodo que añade un objeto a listaMultimedia
     *
     * @param obj elemento que pasamos para añadir
     * @return true si se añade correctamente, de lo contrario false.
     */
    public boolean add(Multimedia obj) {
        if (size() == listaMultimedia.length) {
            return false;
        }
        listaMultimedia[contador++] = obj;
        return true;
    }

    /**
     * metodo que devuelve un objeto especificado por indice
     *
     * @param posicion del objeto que queremos obtener
     * @return objeto contenido en la posicion indicada
     */
    public Multimedia get(int posicion) {
        if (posicion < listaMultimedia.length && posicion >= 0) {
            return listaMultimedia[posicion];
        }
        return null;
    }

    /**
     * metodo que busca un objeto undicado y retorna la posicion el el array
     *
     * @param obj elemento buscado
     * @return posicion en el array si se encuentra, de lo contrario -1
     */
    public int indexOf(Multimedia obj) {
        int indice = -1;
        if (size() > 0) {
            for (int i = 0; i < size(); i++) {
                if (listaMultimedia[i].equals(obj)) {
                    indice = i;
                }
            }
        }
        return indice;
    }

    /**
     * Metodo sobreescrito de la clase Obkect que devuelve la informacion de los
     * objetos en la lista
     *
     * @return cadena de texto con los valores de cada objeto contenido en la
     * lista
     */
    @Override
    public String toString() {
        String listado = "";
        for (int i = 0; i < size(); i++) {
            listado += listaMultimedia[i].toString() + "\n\n";
        }
        return listado;
    }

    /**
     * metodo que guarda los objetos en el fichero
     */
    public void guardarObjetos() {
        try {
            System.out.println("Guardando...");
            escrituraLectura.escrituraObjetos(this);
            System.out.println("Guardado completado!!");
        } catch (EOFException ex) {
            System.out.println("Error al escribir en fichero EOFE" + ex.getMessage());
            Logger.getLogger(EstanteriaMultimedia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al escribir en fichero IO" + ex.getMessage());
            Logger.getLogger(EstanteriaMultimedia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metedo que lee los objetos del fichero y los carga en el listaMultimedia
     */
    public void leerObjetos() {
        contador = 0;
        try {
            ArrayList<Multimedia> listaRecuperada = escrituraLectura.lecturaObjetos();
            Iterator<Multimedia> it = listaRecuperada.iterator();
            
            while(it.hasNext()){
                listaMultimedia[contador] = it.next();
                contador++;
            }
        } catch (EOFException ex) {
            System.out.println("EOFE " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(EstanteriaMultimedia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
            //Logger.getLogger(EstanteriaMultimedia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println("EXCEPTION " + ex.getMessage());
            //Logger.getLogger(EstanteriaMultimedia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * metodo sobreescrito de la Interface Iterable
     *
     * @return un iterador de la clase interna
     */
    @Override
    public Iterator<Multimedia> iterator() {
        return new EstanteriaMultimediaIterator();
    }

    /**
     * Clase interna que implementa Interface ITERATOR y sobrescribe sus metodos
     */
    class EstanteriaMultimediaIterator implements Iterator<Multimedia> {

        int indice = 0;

        @Override
        public boolean hasNext() {
            return indice < contador;
        }

        @Override
        public Multimedia next() {
            Multimedia multimedia = listaMultimedia[indice];
            indice++;
            return multimedia;
        }
    }
    
    /**
     * metodo que comprueba si un elemento existe en la lista
     * @param obj elemtno que queremos verificar
     * @return true si existe, de lo contrario false
     */
    public boolean comprobarExistencia(Multimedia obj){
        for (Multimedia e : this) {
            if(e.equals(obj)){
                return true;
            }
        }
        return false;
    }
}
