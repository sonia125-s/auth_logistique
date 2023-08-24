package com.example.gestionlogistique.repositories;

import com.example.gestionlogistique.entities.Client;
import com.example.gestionlogistique.entities.ClientMorale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientMoraleRepository extends JpaRepository<ClientMorale,Long> {

     @Query("select cm from ClientMorale cm where cm.statut like :kw and cm.statut is not null")
    List<ClientMorale> SearchClient(@Param("kw") String keyword);
}
