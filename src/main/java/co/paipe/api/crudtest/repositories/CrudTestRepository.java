package co.paipe.api.crudtest.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.paipe.api.crudtest.models.CrudTestModel;

@Repository
public interface CrudTestRepository extends JpaRepository<CrudTestModel, UUID>{

	boolean existsByNome(String nome);
	boolean existsByCpf(String cpf);
	boolean existsByEmail(String email);
	

}
