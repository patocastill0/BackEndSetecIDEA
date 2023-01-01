package com.setec.mvc.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.setec.mvc.entidades.Cargo} entity
 */
public class CargoDto implements Serializable {
    private final Integer id;
    private final String nombreCargo;

    public CargoDto(Integer id, String nombreCargo) {
        this.id = id;
        this.nombreCargo = nombreCargo;
    }

    public Integer getId() {
        return id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoDto entity = (CargoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombreCargo, entity.nombreCargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreCargo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombreCargo = " + nombreCargo + ")";
    }
}