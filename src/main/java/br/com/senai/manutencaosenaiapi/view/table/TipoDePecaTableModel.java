package br.com.senai.manutencaosenaiapi.view.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;

public class TipoDePecaTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 2;
	
	private List<TipoDePeca> tiposDePecas;
	
	public TipoDePecaTableModel(List<TipoDePeca> tiposDePecas) {
		this.tiposDePecas = tiposDePecas;
	}

	@Override
	public int getRowCount() {
		return tiposDePecas.size();
	}

	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	@Override
	public String getColumnName(int column) {
		
		if (column == 0) {
			return "ID";
		}else if (column == 1) {
			return "Descrição";
		}
		throw new IllegalArgumentException("Indice inválido.");
	}

	public TipoDePeca getPor(int rowIndex) {
		return tiposDePecas.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		tiposDePecas.remove(rowIndex);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(columnIndex == 0) {
			return tiposDePecas.get(rowIndex).getId();
		}else if (columnIndex == 1) {
			return tiposDePecas.get(rowIndex).getDescricao();
		}
	    throw new IllegalArgumentException("Indice inválido.");
	}

}
