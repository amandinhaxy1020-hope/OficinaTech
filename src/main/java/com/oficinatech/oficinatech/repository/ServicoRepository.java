package com.oficinatech.oficinatech.repository;

import com.oficinatech.oficinatech.model.Servico;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    Optional<Servico> findByCodigoAcompanhamento(String codigo);
    List<Servico> findByClienteId(Long clienteId);
}