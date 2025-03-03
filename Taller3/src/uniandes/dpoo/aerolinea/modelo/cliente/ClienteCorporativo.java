package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

public class ClienteCorporativo extends Cliente {
    private String nombreEmpresa;
    private int tamanoEmpresa;
    
    public static final String CORPORATIVO = "Corporativo";

    public ClienteCorporativo(String nombreEmpresa, int tamanoEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamanoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int getTamanoEmpresa() {
        return tamanoEmpresa;
    }

    @Override
    public String getIdentificador() {
        return nombreEmpresa;
    }

    @Override
    public String getTipoCliente() {
        return CORPORATIVO;
    }

    public static ClienteCorporativo cargarDesdeJSON(JSONObject cliente) {
        String nombreEmpresa = cliente.getString("nombreEmpresa");
        int tamano = cliente.getInt("tamanoEmpresa");
        return new ClienteCorporativo(nombreEmpresa, tamano);
    }

    public JSONObject salvarEnJSON() {
        JSONObject jobject = new JSONObject();
        jobject.put("nombreEmpresa", this.nombreEmpresa);
        jobject.put("tamanoEmpresa", this.tamanoEmpresa);
        jobject.put("tipo", CORPORATIVO);
        return jobject;
    }
}

