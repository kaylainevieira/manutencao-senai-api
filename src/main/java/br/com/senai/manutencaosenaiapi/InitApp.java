package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Cliente;
import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.enums.Sexo;
import br.com.senai.manutencaosenaiapi.service.ClienteService;
import br.com.senai.manutencaosenaiapi.service.OrdemDeServicoService;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}

	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PecaService pecaService;
	
	
	@Autowired
	private OrdemDeServicoService ordemService;
	
	@Transactional
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				Cliente novoCliente = new Cliente();
				novoCliente.setNome("Monteiro");
				novoCliente.setSobrenome("Lobato");
				novoCliente.setDataDeNascimento(LocalDate.of(2000, 10, 10));
				novoCliente.setEndereco("João adolfo corrêa");
				novoCliente.setCpf("123.123.123-12");
				novoCliente.setSexo(Sexo.M);
				this.clienteService.inserir(novoCliente);
				Tecnico tecnicoSalvo = this.tecnicoService.buscarPor(7);
				this.tecnicoService.alterar(tecnicoSalvo);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
}
