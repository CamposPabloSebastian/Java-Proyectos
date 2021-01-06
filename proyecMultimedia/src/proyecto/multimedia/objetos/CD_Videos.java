package proyecto.multimedia.objetos;

/**
 *
 * @author pscam
 */
public class CD_Videos extends Multimedia{
    
    private int numVideos;

    public CD_Videos(String titulo, String autor, double duracion, int numVideos) {
        super(titulo, autor, duracion);
        this.numVideos = numVideos;
    }

    @Override
    public String toString() {
        return "CD VIDEOS:\nnumVideos=" + numVideos + "\n" + super.toString();
    }

    public int getNumVideos() {
        return numVideos;
    }

    public void setNumVideos(int numVideos) {
        this.numVideos = numVideos;
    }
}
