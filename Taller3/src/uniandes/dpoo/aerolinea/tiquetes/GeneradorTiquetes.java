package uniandes.dpoo.aerolinea.tiquetes;

import java.util.HashSet;
import java.util.Set;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class GeneradorTiquetes {
    private static Set<String> codigos = new HashSet<>();

    public static Tiquete generarTiquete(Vuelo vuelo, Cliente cliente, int tarifa) {
        int numero = (int) (Math.random() * 10e7);
        String codigo = String.valueOf(numero);
        while (codigos.contains(codigo)) {
            numero = (int) (Math.random() * 10e7);
            codigo = String.valueOf(numero);
        }
        while (codigo.length() < 7) {
            codigo = "0" + codigo;
        }
        Tiquete nuevoTiquete = new Tiquete(codigo, vuelo, cliente, tarifa);
        registrarTiquete(nuevoTiquete);
        return nuevoTiquete;
    }

    public static void registrarTiquete(Tiquete unTiquete) {
        codigos.add(unTiquete.getCodigo());
    }

    public static boolean validarTiquete(String codigoTiquete) {
        return codigos.contains(codigoTiquete);
    }
}

