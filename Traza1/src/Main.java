import lombok.Data;
import java.time.LocalTime;
@Data

//CON LOMBOCK

public class Main {
    public static void main(String[] args) {

        // ================================
        // 1) Crear un país (Argentina)
        // ================================
        Pais argentina = new Pais(1L, "Argentina");

        // ================================
        // 2) Crear una provincia y asociarla al país (Buenos Aires)
        // ================================
        Provincia bsAs = new Provincia(1L, "Buenos Aires");
        argentina.getProvincias().add(bsAs);

        // ================================
        // 3) Localidad: CABA
        // ================================
        Localidad caba = new Localidad(1L, "CABA");
        bsAs.getLocalidades().add(caba);

        // 4) Domicilio para CABA
        Domicilio domCaba = new Domicilio(1L, "Av. 9 de Julio", 123, 1000);
        caba.setDomicilio(domCaba);

        // ================================
        // 5) Localidad: La Plata
        // ================================
        Localidad laPlata = new Localidad(2L, "La Plata");
        bsAs.getLocalidades().add(laPlata);

        // 6) Domicilio para La Plata
        Domicilio domLaPlata = new Domicilio(2L, "Calle 7", 456, 1900);
        laPlata.setDomicilio(domLaPlata);

        // ================================
        // 7) Otra provincia: Córdoba
        // ================================
        Provincia cordoba = new Provincia(2L, "Córdoba");
        argentina.getProvincias().add(cordoba);

        // ================================
        // 8) Localidad: Córdoba Capital
        // ================================
        Localidad cordobaCapital = new Localidad(3L, "Córdoba Capital");
        cordoba.getLocalidades().add(cordobaCapital);

        // 9) Domicilio para Córdoba Capital
        Domicilio domCordoba = new Domicilio(3L, "Bv. San Juan", 789, 5000);
        cordobaCapital.setDomicilio(domCordoba);
        // ================================
        // 10) Localidad: Villa Carlos Paz
        // ================================
        Localidad vcp = new Localidad(4L, "Villa Carlos Paz");
        cordoba.getLocalidades().add(vcp);

        // 11) Domicilio para Villa Carlos Paz
        Domicilio domVcp = new Domicilio(4L, "Av. Libertad", 321, 5152);
        vcp.setDomicilio(domVcp);

        // ================================
        // 12) Crear sucursales
        // ================================
        Sucursal sucursal1 = new Sucursal(1L, "Sucursal CABA",
                LocalTime.of(9, 0), LocalTime.of(18, 0), true, domCaba);

        Sucursal sucursal2 = new Sucursal(2L, "Sucursal La Plata",
                LocalTime.of(9, 0), LocalTime.of(18, 0), false, domLaPlata);

        Sucursal sucursal3 = new Sucursal(3L, "Sucursal Córdoba Capital",
                LocalTime.of(9, 0), LocalTime.of(18, 0), false, domCordoba);

        Sucursal sucursal4 = new Sucursal(4L, "Sucursal Villa Carlos Paz",
                LocalTime.of(9, 0), LocalTime.of(18, 0), false, domVcp);

        // ================================
        // 13) Crear Empresa1 con sucursales 1 y 2
        // ================================
        Empresa empresa1 = new Empresa(1L, "Empresa Molina", "Razon Social Uno", 30123456, "logo1.png");
        empresa1.getSucursales().add(sucursal1);
        empresa1.getSucursales().add(sucursal2);

        // ================================
        // 14) Crear Empresa2 con sucursales 3 y 4
        // ================================
        Empresa empresa2 = new Empresa(2L, "Empresa Faé", "Razon Social Dos", 30876543, "logo2.png");
        empresa2.getSucursales().add(sucursal3);
        empresa2.getSucursales().add(sucursal4);


        // Crear empresas
        Empresa empresaA = new Empresa(1L, "Empresa Uno", "Razon Social Uno", 30123456, "logo1.png");
        Empresa empresaB = new Empresa(2L, "Empresa Dos", "Razon Social Dos", 30876543, "logo2.png");

        // Crear servicio con reflexión
        EmpresaService service = new EmpresaService();
        service.agregarEmpresa(empresaA);
        service.agregarEmpresa(empresaB);

        // a) Mostrar todas las empresas
        service.mostrarEmpresas();

        // b) Buscar empresa por ID
        System.out.println("\nBuscando empresa con ID = 1:");
        Empresa encontradaPorId = service.buscarPorId(1L);
        System.out.println(encontradaPorId != null ? encontradaPorId.getNombreEmpresa() : "No encontrada");

        // c) Buscar empresa por nombre
        System.out.println("\nBuscando empresa por nombre 'Empresa B':");
        Empresa encontradaPorNombre = service.buscarPorNombre("Empresa B");
        System.out.println(encontradaPorNombre != null ? encontradaPorNombre.getNombreEmpresa() : "No encontrada");

        // d) Actualizar CUIT
        System.out.println("\nActualizando CUIT de la empresa con ID = 1...");
        boolean actualizado = service.actualizarCuitPorId(1L, 30999999);
        System.out.println(actualizado ? "CUIT actualizado correctamente." : "Error al actualizar.");

        // e) Eliminar empresa
        System.out.println("\nEliminando empresa con ID = 2...");
        boolean eliminada = service.eliminarPorId(2L);
        System.out.println(eliminada ? "Empresa eliminada correctamente." : "No se encontró la empresa.");

        // Mostrar lista final
        System.out.println("\nLista final:");
        service.mostrarEmpresas();

        }

    private static void mostrarEmpresa(Empresa empresa) {
        System.out.println("\nEmpresa: " + empresa.getNombreEmpresa() +
                " | CUIT: " + empresa.getCUIT() +
                " | Razon Social: " + empresa.getRazonSocial());
        System.out.println("Sucursales:");
        for (Sucursal s : empresa.getSucursales()) {
            System.out.println(" - " + s.getNombreSucursal() + " | Dirección: " +
                    s.getDomicilio().getCalle() + " " + s.getDomicilio().getNumero() +
                    " (CP " + s.getDomicilio().getCp() + ")");
        }

    }

}
