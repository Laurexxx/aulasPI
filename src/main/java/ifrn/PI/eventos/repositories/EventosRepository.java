package ifrn.PI.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.PI.eventos.models.Evento;

public interface EventosRepository extends JpaRepository<Evento, Long> {

}
