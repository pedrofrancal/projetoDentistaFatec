package model;

import javax.swing.table.AbstractTableModel;

public class verificarTableModel extends AbstractTableModel{
	
	private String [] colunas = {"Nome","Email","Data de Agendamento","Tipo de Agendamento"};
	
	@Override
	public int getColumnCount() {
		
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		//retornar o lista.length
		return 18;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
	
		return null;
	}
	
	@Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }
	
}
