package proyecto.multimedia.objetos;

/**
 *
 * @author pscam
 */
public class CD_Fotos extends Multimedia{
    
    private int numFotos;

    public CD_Fotos(String titulo, String autor, double duracion, int numFotos) {
        super(titulo, autor, duracion);
        this.numFotos = numFotos;
    }

    @Override
    public String toString() {
        return "CD FOTOS:\nnumFotos=" + numFotos + "\n" + super.toString();
    }
    
    public int getNumFotos() {
        return numFotos;
    }

    public void setNumFotos(int numFotos) {
        this.numFotos = numFotos;
    }
}
