package com.wsystec.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsystec.cursomc.domain.Pagamento;

@Repository
public interface pagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
