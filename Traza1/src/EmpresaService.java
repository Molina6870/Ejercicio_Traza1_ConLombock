import lombok.Data;

import java.lang.reflect.Field;
import java.util.HashSet;

@Data
public class EmpresaService {
    private HashSet<Empresa> empresas = new HashSet<>();


    // AGREGAR EMPRESA
    public void agregarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    // a) MOSTRAR TODAS LAS EMPRESAS USANDO REFLEXIÓN
    public void mostrarEmpresas() {
        if (empresas.isEmpty()) {
            System.out.println("No hay empresas registradas.");
            return;
        }

        System.out.println("===== LISTA DE EMPRESAS =====");
        for (Empresa empresa : empresas) {
            try {
                Class<?> clazz = empresa.getClass(); // Obtener la clase en tiempo de ejecución
                Field[] campos = clazz.getDeclaredFields();

                System.out.println("Empresa:");
                for (Field campo : campos) {
                    campo.setAccessible(true); // Permitir acceso a campos privados
                    Object valor = campo.get(empresa);
                    System.out.println(" - " + campo.getName() + ": " + valor);
                }
                System.out.println("-----------------------------");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    // b) BUSCAR EMPRESA POR ID
    public Empresa buscarPorId(Long id) {
        for (Empresa empresa : empresas) {
            try {
                Field campoId = empresa.getClass().getDeclaredField("idEmpresa");
                campoId.setAccessible(true);
                Long valorId = (Long) campoId.get(empresa);

                if (valorId.equals(id)) {
                    return empresa;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // c) BUSCAR EMPRESA POR NOMBRE
    public Empresa buscarPorNombre(String nombre) {
        for (Empresa empresa : empresas) {
            try {
                Field campoNombre = empresa.getClass().getDeclaredField("nombreEmpresa");
                campoNombre.setAccessible(true);
                String valorNombre = (String) campoNombre.get(empresa);

                if (valorNombre.equalsIgnoreCase(nombre)) {
                    return empresa;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //d) ACTUALIZAR CUIT POR ID
    public boolean actualizarCuitPorId(Long id, Integer nuevoCuit) {
        Empresa empresa = buscarPorId(id);
        if (empresa != null) {
            try {
                Field campoCuit = empresa.getClass().getDeclaredField("CUIT");
                campoCuit.setAccessible(true);
                campoCuit.set(empresa, nuevoCuit); // Modificar el valor
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // e) ELIMINAR EMPRESA POR ID
    public boolean eliminarPorId(Long id) {
        Empresa empresa = buscarPorId(id);
        if (empresa != null) {
            return empresas.remove(empresa);
        }
        return false;
    }

    public HashSet<Empresa> getEmpresas() {
        return empresas;
    }
}
