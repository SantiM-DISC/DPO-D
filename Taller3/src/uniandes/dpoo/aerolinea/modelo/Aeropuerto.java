package uniandes.dpoo.aerolinea.modelo;

import java.util.HashSet;
import java.util.Set;

import uniandes.dpoo.aerolinea.exceptions.AeropuertoDuplicadoException;

public class Aeropuerto {
    private String nombre;
    private String codigo;
    private String ciudad;
    private double latitud;
    private double longitud;

    private static Set<String> codigosRegistrados = new HashSet<>();
    private static final double RADIO_TERRESTRE = 6371; 

    public Aeropuerto(String nombre, String codigo, String ciudad, double latitud, double longitud) throws AeropuertoDuplicadoException {
        if (codigosRegistrados.contains(codigo)) {
            throw new AeropuertoDuplicadoException(codigo);
        }
        this.nombre = nombre;
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.latitud = latitud;
        this.longitud = longitud;
        codigosRegistrados.add(codigo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreCiudad() {
        return ciudad;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public static int calcularDistancia(Aeropuerto aeropuerto1, Aeropuerto aeropuerto2) {
        double lat1 = Math.toRadians(aeropuerto1.getLatitud());
        double lon1 = Math.toRadians(aeropuerto1.getLongitud());
        double lat2 = Math.toRadians(aeropuerto2.getLatitud());
        double lon2 = Math.toRadians(aeropuerto2.getLongitud());
        
        double deltaX = (lon2 - lon1) * Math.cos((lat1 + lat2) / 2);
        double deltaY = lat2 - lat1;
        double distancia = Math.sqrt(deltaX * deltaX + deltaY * deltaY) * RADIO_TERRESTRE;
        return (int) Math.round(distancia);
    }
}

