package com.example.gestionlogistique.repositories;

import com.example.gestionlogistique.entities.Client;
import com.example.gestionlogistique.entities.ClientPhysique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientPhysiqueRepository extends JpaRepository<ClientPhysique,Long> {
    @Query("select cp from ClientPhysique cp where cp.nom like :kw AND cp.nom is not null")
    List<ClientPhysique> SearchClient(@Param("kw") String keyword);

}
