import lombok.Data;
@Data

public class Localidad {
    private String nombreLocalidad;
    private Domicilio domicilio;
    private Long idLocalidad;

    public Localidad(Long idLocalidad, String nombreLocalidad) {
        this.idLocalidad = idLocalidad;
        this.nombreLocalidad = nombreLocalidad;
    }

}
