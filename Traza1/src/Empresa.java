import java.util.HashSet;
import java.util.IdentityHashMap;
import lombok.Data;
@Data

public class Empresa {
    private String nombreEmpresa;
    private String RazonSocial;
    private Integer CUIT;
    private String logo;
    private HashSet<Sucursal> sucursales;

    private Long idEmpresa;


    public Empresa (Long idEmpresa, String nombreEmpresa, String RazonSocial, Integer CUIT, String logo){
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.RazonSocial = RazonSocial;
        this.CUIT = CUIT;
        this.sucursales = new HashSet<>();
    }
}
