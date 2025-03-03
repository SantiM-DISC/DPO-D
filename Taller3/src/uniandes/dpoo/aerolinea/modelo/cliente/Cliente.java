package uniandes.dpoo.aerolinea.modelo.cliente;

public abstract class Cliente {
    private String identificador;

    public Cliente(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public abstract String getTipoCliente();
    
    public abstract int calcularValorTotalTiquetes();
}

