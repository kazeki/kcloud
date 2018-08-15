package com.kzk.kcloud.repository;

import com.kzk.kcloud.model.Module;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ModuleRepository extends Repository<Module,Long> {
    List<Module> findAllBy();
    Module findByName(String name);
}
