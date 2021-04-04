package com.wsystec.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsystec.cursomc.domain.Pedido;

@Repository
public interface pedidoRepository extends JpaRepository<Pedido, Integer> {

}
