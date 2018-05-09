package com.minghua.springboot.jpa.dao;

import com.minghua.springboot.jpa.model.Departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptRepository extends CrudRepository<Departement, Integer> {
    @Override
    List<Departement> findAll();
    Departement findOne(int id);
    @Override
    Departement save(Departement departement);
    void delete(int id);
}
