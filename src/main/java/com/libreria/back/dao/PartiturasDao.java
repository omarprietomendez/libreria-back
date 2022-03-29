package com.libreria.back.dao;

import com.libreria.back.entity.Partitura;
import org.springframework.data.repository.CrudRepository;

public interface PartiturasDao extends CrudRepository<Partitura, Integer> {
}
