import lombok.Data;

import java.util.Collection;
import java.util.HashSet;
import lombok.Data;

@Data
public class Pais {
    private String nombrePais;
    private HashSet<Provincia> provincias;
    private Long idPais;

    public Pais(long idPais, String nombrePais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
        this.provincias = new HashSet<>();
    }

}

//Colocamos los getter y setter | ACLARACIÓN: Acá anteriormente lo hice colocando todo, después trate de hacerlo con Lombok

//    public Long getIdPais(){return idPais;}
//    public void setIdPais(Long idPais){this.idPais = idPais;}
//    public HashSet<Provincia> getProvincias(){return provincias;}
//    public void setProvincias(HashSet<Provincia> provincias){this.provincias = provincias;}
