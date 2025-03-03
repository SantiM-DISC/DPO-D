package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {
    public static final String NATURAL = "Natural";

    public ClienteNatural(String identificador) {
        super(identificador);
    }

    @Override
    public String getTipoCliente() {
        return NATURAL;
    }

    @Override
    public int calcularValorTotalTiquetes() {
        return 0; // Implementar lógica real cuando se conecte con los tiquetes
    }
}

