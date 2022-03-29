package com.libreria.back.service;

import com.libreria.back.dao.PartiturasDao;
import com.libreria.back.entity.Partitura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartiturasServiceImpl implements PartiturasService{

    @Autowired
    private PartiturasDao partiturasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Partitura> findAll(){
        return (List<Partitura>) partiturasDao.findAll();
    }

    @Override
    public Partitura findById(int id) {
        return partiturasDao.findById(id).orElse(null);
    }

    @Override
    public Partitura save(Partitura partitura) {
        return partiturasDao.save(partitura);
    }

    @Override
    public void deleteById(int id) {
        partiturasDao.deleteById(id);
    }

    @Override
    public void update(Partitura partitura, int id) {
        partiturasDao.save(partitura);
    }

}
