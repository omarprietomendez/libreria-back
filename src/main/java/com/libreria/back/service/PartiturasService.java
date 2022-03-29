package com.libreria.back.service;

import com.libreria.back.entity.Partitura;

import java.util.List;

public interface PartiturasService {

    public List<Partitura> findAll();
    public Partitura findById(int id);
    public Partitura save(Partitura partitura);
    public void deleteById(int id);
    public void update(Partitura partitura, int id);

}
