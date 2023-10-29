package com.example.DAWII_CL2_NovoaLuis.repository;

import com.example.DAWII_CL2_NovoaLuis.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Rol findByNomrol(String nombrerol);
}
