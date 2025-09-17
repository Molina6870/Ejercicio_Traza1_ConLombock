import java.time.LocalTime;
import java.util.HashSet;
import lombok.Data;
@Data

public class Sucursal {
    private String nombreSucursal;
    private LocalTime HorarioApertura;
    private LocalTime HorarioCierre;
    private boolean es_Casa_Matriz;
    private Domicilio domicilio;

    private Long idSucursal;

    public  Sucursal(Long idSucursal, String nombreSucursal, LocalTime HorarioApertura, LocalTime HorarioCierre, boolean es_Casa_Matriz ,Domicilio domicilio){
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.HorarioApertura = HorarioApertura;
        this.HorarioCierre = HorarioCierre;
        this.es_Casa_Matriz = es_Casa_Matriz;
        this.domicilio = domicilio;
    }
}
