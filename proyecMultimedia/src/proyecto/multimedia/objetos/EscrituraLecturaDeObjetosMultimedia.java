package proyecto.multimedia.objetos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author pscam
 */
public class EscrituraLecturaDeObjetosMultimedia {

    //private FileOutputStream fileOutPutStream; //no lo utilizo porque instancion en el flujo de objetos
    //private FileInputStream fileInPutStream; //no lo utilizo porque instancion en el flujo de objetos
    private ObjectOutputStream escritura;
    private ObjectInputStream lectura;
    private String archivo;

    /**
     * Constructor que inicializa archivo
     *
     * @param archivo nombre o ruta del archivo
     */
    public EscrituraLecturaDeObjetosMultimedia(String archivo) {
        this.archivo = archivo;
    }

    /**
     * metodo que guarda los objetos en un fichero.dat
     *
     * @param estanteriaMultimedia objeto a guardar
     * @throws java.io.EOFException
     * @throws IOException excepcion lanzada por metodo en caso de no encontrar
     * fichero
     */
    public void escrituraObjetos(EstanteriaMultimedia estanteriaMultimedia) throws EOFException, IOException {
        escritura = new ObjectOutputStream(new FileOutputStream(archivo));
        for (int i = 0; i < estanteriaMultimedia.size(); i++) {
            escritura.writeObject(estanteriaMultimedia.get(i));
        }
        escritura.close();
    }

    /**
     * metodo que lee la cantidad de objetos que le indicamos guardados en un fichero
     *
     * @param numObjetos cantidad de objetos que quiero leer
     * @return arrayList con los objetos leidos
     * @throws Exception excepcion lanzada si hay algun error en tiempo de
     * ejecucion
     * @throws FileNotFoundException excepcion lanzada si numObjetos esta fuera
     * de rango
     * @throws IOException excepcion lanzada por metodo en caso de no encontrar
     * fichero
     */
    public ArrayList lecturaObjetos(int numObjetos) throws Exception, FileNotFoundException, IOException {
        lectura = new ObjectInputStream(new FileInputStream(archivo));
        ArrayList<Multimedia> listaLeida = new ArrayList<>();
        for (int i = 0; i < numObjetos; i++) {
            System.out.println("leyendo " + i + " de " + numObjetos + " obj");
            Object aux = lectura.readObject();
            if (aux != null) {
                listaLeida.add((Multimedia) aux);
            }
        }
        lectura.close();
        return listaLeida;
    }

    /**
     * metodo que lee todos los objetos guardados en un fichero
     *
     * @return arrayList con los objetos leidos
     * @throws Exception excepcion lanzada si hay algun error en tiempo de
     * ejecucion
     * @throws FileNotFoundException excepcion lanzada si numObjetos esta fuera
     * de rango
     * @throws IOException excepcion lanzada por metodo en caso de no encontrar
     * fichero
     */
    public ArrayList lecturaObjetos() throws Exception, FileNotFoundException, IOException {
        lectura = new ObjectInputStream(new FileInputStream(archivo));
        ArrayList<Multimedia> listaLeida = new ArrayList();
        try {
            while (true) {
                Object aux = lectura.readObject();
                listaLeida.add((Multimedia) aux);
            }
        } catch (EOFException e) {
            //con EOFException capturo el final del fichero y evito que
            //rompa la ejecucion. readObject no retorna NULL
        }
        lectura.close();
        return listaLeida;
    }
}
