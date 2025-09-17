import java.util.HashSet;
import lombok.Data;
@Data

public class Provincia {
    private String nombreProvincia;
    private HashSet<Localidad> localidades;
    private Long idProvincia;

    public Provincia(long idProvincia, String nombreProvincia) {
    this.idProvincia = idProvincia;
    this.nombreProvincia = nombreProvincia;
    this.localidades = new HashSet<>();
    }

}


//Colocamos los getter y setter | ACLARACIÓN: Acá anteriormente lo hice colocando todo, después trate de hacerlo con Lombok

//    public Long getIdProvincia(){return idProvincia;}
//    public void setIdProvincia(Long idProvincia){this.idProvincia = idProvincia;}

//    public void setNombreProvincia(String nombreProvincia){this.nombreProvincia = nombreProvincia;}

//    public String getNombreProvincia(){return nombreProvincia;}

//    public HashSet<Localidad> getLocalidades(){return localidades;}

//    public void setLocalidades (HashSet<Localidad> localidades){this.localidades = localidades;}

