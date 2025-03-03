package uniandes.dpoo.aerolinea.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
    protected static final double IMPUESTO = 0.28;
    
    public abstract int calcularTarifa(Vuelo vuelo, Cliente cliente);
    
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
    
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);
    
    protected int calcularDistanciaVuelo(Ruta ruta) {
        return Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
    }
    
    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }
}

class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
    private static final int COSTO_POR_KM_NATURAL = 600;
    private static final int COSTO_POR_KM_CORPORATIVO = 900;
    private static final double DESCUENTO_PEQ = 0.02;
    private static final double DESCUENTO_MEDIANAS = 0.1;
    private static final double DESCUENTO_GRANDES = 0.2;
    
    @Override
    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int costoFinal = (int) (costoBase * (1 - descuento));
        return costoFinal + calcularValorImpuestos(costoFinal);
    }
    
    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int costoPorKm = cliente.getTipoCliente().equals("Natural") ? COSTO_POR_KM_NATURAL : COSTO_POR_KM_CORPORATIVO;
        return costoPorKm * calcularDistanciaVuelo(vuelo.getRuta());
    }
    
    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        int tamanoEmpresa = cliente instanceof ClienteCorporativo ? ((ClienteCorporativo) cliente).getTamanoEmpresa() : 0;
        if (tamanoEmpresa >= 500) return DESCUENTO_GRANDES;
        if (tamanoEmpresa >= 100) return DESCUENTO_MEDIANAS;
        return DESCUENTO_PEQ;
    }
}

class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
    private static final int COSTO_POR_KM = 1000;
    
    @Override
    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        return costoBase + calcularValorImpuestos(costoBase);
    }
    
    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        return COSTO_POR_KM * calcularDistanciaVuelo(vuelo.getRuta());
    }
    
    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        return 0;
    }
}
