package com.setec.mvc.general;

import java.util.List;

public class EntidadRespuesta<T> {
    private List<T> contenido;
    private int numeroPagina;
    private int medidaPagina;
    private long totalElementos;
    private int totalPaginas;
    private boolean ultima;
    private boolean primera;

    public EntidadRespuesta() {
    }

    public List<T> getContenido() {
        return contenido;
    }

    public void setContenido(List<T> contenido) {
        this.contenido = contenido;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getMedidaPagina() {
        return medidaPagina;
    }

    public void setMedidaPagina(int medidaPagina) {
        this.medidaPagina = medidaPagina;
    }

    public long getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public boolean isUltima() {
        return ultima;
    }

    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }

    public boolean isPrimera() {
        return primera;
    }

    public void setPrimera(boolean primera) {
        this.primera = primera;
    }
}
