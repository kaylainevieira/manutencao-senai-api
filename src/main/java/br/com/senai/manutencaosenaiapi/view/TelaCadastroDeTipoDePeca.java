package br.com.senai.manutencaosenaiapi.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;
import br.com.senai.manutencaosenaiapi.service.TipoDePecaService;

@Component
public class TelaCadastroDeTipoDePeca extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtId;
	private JTextField edtDescricao;
	
	@Autowired
	private TipoDePecaService service;
	
	@Autowired
	@Lazy
	private TelaConsultaDeTipoDePeca telaDeConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroDeTipoDePeca frame = new TelaCadastroDeTipoDePeca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroDeTipoDePeca() {
		setTitle("Cadastro de Tipo de Peça");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 121);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("ID");
		
		edtId = new JTextField();
		edtId.setEnabled(false);
		edtId.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição");
		
		edtDescricao = new JTextField();
		edtDescricao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (edtId.getText() != null && edtId.getText().length() > 0) {
						TipoDePeca tipoDePecaSalvo = new TipoDePeca();
						tipoDePecaSalvo.setDescricao(edtDescricao.getText());
						tipoDePecaSalvo.setId(Integer.parseInt(edtId.getText()));
						service.alterar(tipoDePecaSalvo);
						JOptionPane.showMessageDialog(
								contentPane, "Tipo de peça alterado com sucesso.");
					}else {
						TipoDePeca novoTipoDePeca = new TipoDePeca();
						novoTipoDePeca.setDescricao(edtDescricao.getText());
						TipoDePeca tipoDePecaSalvo = service.inserir(novoTipoDePeca);
						edtId.setText(tipoDePecaSalvo.getId().toString());
						JOptionPane.showMessageDialog(contentPane,
								"Tipo de peça inserido com sucesso.");
					}
					telaDeConsulta.setVisible(true);
					setVisible(false);
					telaDeConsulta.pesquisar();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblId)
						.addComponent(edtId, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescricao)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnSalvar)
							.addComponent(edtDescricao, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)))
					.addGap(68))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblDescricao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(edtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalvar)
					.addContainerGap(177, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void colocarEmEdicao(TipoDePeca tipoDePecaSalvo) {
		edtId.setText(tipoDePecaSalvo.getId().toString());
		edtDescricao.setText(tipoDePecaSalvo.getDescricao());
	}

	public void limparCampos() {
		edtId.setText("");
		edtDescricao.setText("");
	}
}
