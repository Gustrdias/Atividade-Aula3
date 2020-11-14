package br.com.atividade3.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.atividade3.model.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}