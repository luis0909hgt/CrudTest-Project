package co.paipe.api.crudtest.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.paipe.api.crudtest.dtos.CrudTestDto;
import co.paipe.api.crudtest.models.CrudTestModel;
import co.paipe.api.crudtest.services.CrudTestService;

@RestController
@RequestMapping("/crud-test")
public class CrudTestController {
	
	
	final CrudTestService crudTestService;

	public CrudTestController(CrudTestService crudTestService) {
		this.crudTestService = crudTestService;
	}
	
	
	@PostMapping
	public ResponseEntity<Object> saveFuncioanrios(@RequestBody @Valid CrudTestDto crudTestDto) {
		if(crudTestService.existsByNome(crudTestDto.getNome())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse nome de funcionário já existe!");
		}
		if(crudTestService.existsByCpf(crudTestDto.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse CPF de funcionário já existe!");
		}
		if(crudTestService.existsByEmail(crudTestDto.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse e-mail de funcionário já existe!");
		}
		var crudTestModel = new CrudTestModel();
		BeanUtils.copyProperties(crudTestDto, crudTestModel);
		crudTestModel.setDataAdmissao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(crudTestService.save(crudTestModel));
	}
	
	@GetMapping("/allFuncs")
	public ResponseEntity<List<CrudTestModel>> getAllFuncionarios() {
		return ResponseEntity.status(HttpStatus.OK).body(crudTestService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneFuncionario(@PathVariable (value = "id") UUID id){
		Optional<CrudTestModel> crudTestModelOptional = crudTestService.findById(id);
		if(!crudTestModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(crudTestModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFuncionario(@PathVariable (value = "id") UUID id){
		Optional<CrudTestModel> crudTestModelOptional = crudTestService.findById(id);
		if(!crudTestModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado!");
		}
		crudTestService.delete(crudTestModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("A exclusão foi feita com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateFuncionario(@PathVariable (value = "id") UUID id,
													@RequestBody @Valid CrudTestDto crudTestDto) {
		Optional<CrudTestModel> crudTestModelOptional = crudTestService.findById(id);
		if(!crudTestModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado!");
		}
		
		var crudTestModel = new CrudTestModel();
		BeanUtils.copyProperties(crudTestDto, crudTestModel);
		crudTestModel.setId(crudTestModelOptional.get().getId());
		crudTestModel.setDataAdmissao(crudTestModelOptional.get().getDataAdmissao());
		return ResponseEntity.status(HttpStatus.OK).body(crudTestService.save(crudTestModel));
	}
}
