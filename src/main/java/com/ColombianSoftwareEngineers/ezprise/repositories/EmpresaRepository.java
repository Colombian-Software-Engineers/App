package com.ColombianSoftwareEngineers.ezprise.repositories;

import com.ColombianSoftwareEngineers.ezprise.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}