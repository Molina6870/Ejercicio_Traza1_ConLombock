import lombok.Data;
@Data

public class Domicilio {
    private String calle;
    private int numero;
    private Integer cp;
    private Long idDomicilio;

    public Domicilio (Long idDomicilio, String calle, int numero, Integer cp){
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
    }
}

