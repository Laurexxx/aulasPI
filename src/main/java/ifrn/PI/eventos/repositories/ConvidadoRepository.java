package ifrn.PI.eventos.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.PI.eventos.models.Convidado;
import ifrn.PI.eventos.models.Evento;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long>{
	
	List<Convidado> findByEvento(Evento evento);

}
