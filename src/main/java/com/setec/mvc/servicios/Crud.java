package com.setec.mvc.servicios;

import com.setec.mvc.general.EntidadRespuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Crud<T>{
    public T findById(String id);

    public T save(T entity);

    public List<T> findAll();

    public EntidadRespuesta<T> findAll(int numeroDePagina, int MedidaDePagina);

    public Page<T> findAll(Pageable pageable);

    public void delete(String id);

    public T update(T tipo , String id);

    public Object mapearEntity(T entidadDto);

}
