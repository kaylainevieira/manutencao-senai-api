package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;
import br.com.senai.manutencaosenaiapi.repository.TiposDePecaRepository;

@Service
@Validated
public class TipoDePecaService {
	
	@Autowired
	private TiposDePecaRepository repository;
	
	private TipoDePeca inserir(
			@Valid
			@NotNull(message = "O tipo de peça não pode ser nulo.")
			TipoDePeca novoTipoDePeca) {
		TipoDePeca tipoDePecaSalvo = repository.save(novoTipoDePeca);
		return tipoDePecaSalvo;
	}
	
	private TipoDePeca alterar (
			@Valid
			@NotNull(message = "O tipo de peça não pode ser nulo.")
			TipoDePeca tipoDePecaSalvo) {
		TipoDePeca tipoDePecaAtualizado = repository.save(tipoDePecaSalvo);
		return tipoDePecaAtualizado;
	}
	
	public void removerPor(
			@NotNull(message = "O id do tipo de peça para remoção não pode ser nulo.")
	        @Min(value = 1, message = "O id do tipo de peça deve ser maior que 1.")
            Integer id) {
    this.repository.deleteById(id);
    }
	
	public List<TipoDePeca> listarPor(
			@NotEmpty(message = "A descrição de busca é obrigatória.")
			@NotBlank(message = "A descrição de busca não pode ser vazia.")
			String descricao) {
		return repository.listarPor("%" + descricao + "%");
	}
	
}
