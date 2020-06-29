package model;

import javax.swing.table.AbstractTableModel;

import controller.ListaLigada;



public class verificarTableModel extends AbstractTableModel{
	
	private ListaLigada lista;
	
	public verificarTableModel(ListaLigada lista) {
		this.lista = lista;
	}
	
	
	private String [] colunas = {"Nome","Rg", "Email","telefone","Data de Agendamento","Tipo de Agendamento", "Opções"};
	
	@Override
	public int getColumnCount() {
		
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return lista.tamanho();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch(arg1) {
		case 0:return lista.get(arg0).getNomecompleto();
		case 1:return lista.get(arg0).getRg();
		case 2:return lista.get(arg0).getEmail();
		case 3:return lista.get(arg0).getTelefone();
		case 4:return lista.get(arg0).getDataAgenda();
		case 5:return lista.get(arg0).getTipoDeAgendamento();
		}
		return null;
	}
	
	@Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }
	
	public void refresh () {
		fireTableDataChanged();
	}
}
