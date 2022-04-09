package br.com.senai.manutencaosenaiapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.service.PecaService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}

//	@Autowired
//	private TecnicoService service;
//	
//	@Autowired
//	private ClienteService clienteService;
	
	@Autowired
	private PecaService pecaService;
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
//				Tecnico novoTecnico = new Tecnico();
//				novoTecnico.setNomeCompleto("José Soares.");
//
//				this.service.inserir(novoTecnico);	
				
//	      		Tecnico tecnicoSalvo = new Tecnico();
//				
//				tecnicoSalvo.setId(1);
//				tecnicoSalvo.setNomeCompleto("Joana Silva.");
//				tecnicoSalvo.setDataDeAdmissao(LocalDate.now());
//				
//				this.service.alterar(tecnicoSalvo);
				
//				System.out.println("Técnico salvo com sucesso.");
//				this.service.listarPor(" ");
//				this.service.removerPor(1);
				
//				Cliente novoCliente = new Cliente();
//				novoCliente.setNome("João");
//				novoCliente.setSobrenome("Da Silva");
//				novoCliente.setCpf("000.000.000-00");
//				novoCliente.setSexo(Sexo.MASCULINO);
//				novoCliente.setEndereco("Rua das Couves");
//				novoCliente.setDataDeNascimento(LocalDate.of(2018, 9, 14));
//				this.clienteService.inserir(novoCliente);
//                System.out.println("Cliente salvo com sucesso");
				
				Peca novaPeca = new Peca();
				novaPeca.setDescricao("Teclado");
				novaPeca.setQtdEmEstoque(10);
				System.out.println(novaPeca);
				this.pecaService.inserir(null);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
}
