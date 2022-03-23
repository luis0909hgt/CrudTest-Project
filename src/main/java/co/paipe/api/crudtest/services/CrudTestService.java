package co.paipe.api.crudtest.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import co.paipe.api.crudtest.models.CrudTestModel;
import co.paipe.api.crudtest.repositories.CrudTestRepository;

@Service
public class CrudTestService {
	
	final CrudTestRepository crudTestRepository;

	public CrudTestService(CrudTestRepository crudTestRepository) {
		this.crudTestRepository = crudTestRepository;
	}

	@Transactional
	public CrudTestModel save(CrudTestModel crudTestModel) {
		return crudTestRepository.save(crudTestModel);
	}

	public boolean existsByNome(String nome) {
		return crudTestRepository.existsByNome(nome);
	}

	public boolean existsByCpf(String cpf) {
		return crudTestRepository.existsByCpf(cpf);
	}

	public boolean existsByEmail(String email) {
		return crudTestRepository.existsByEmail(email);
	}
	
	public List<CrudTestModel> findAll() {
		return crudTestRepository.findAll();
	}

	public Optional<CrudTestModel> findById(UUID id) {
		return crudTestRepository.findById(id);
	}

	@Transactional
	public void delete(CrudTestModel crudTestModel) {
		 crudTestRepository.delete(crudTestModel);
	}

}
