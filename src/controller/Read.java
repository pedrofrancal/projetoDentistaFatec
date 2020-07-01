package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.verificarConsultas;

//Parte Read feita por Augusto Furtado


public class Read {

	private File chooseFile() {
        File filePath;
        
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("SELECIONE O ARQUIVO PARA SER VERIFICADO", "txt");
        file.setFileFilter(filter);
        int returnVal = file.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            filePath = file.getSelectedFile();
            return filePath;
        }else {
            return null;
        }
        
    }
	
	public void pesquisa(String nome) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(chooseFile().getPath()));
		String lido;
		while(!((lido = reader.readLine()).contains(nome))||!(lido==null)) {
			if(lido.contains(nome)) {
				lido = lido.replaceAll(";", " | ");
				JOptionPane.showMessageDialog(null, lido);
				break;
			}
		}
			
	}
	

	public ListaLigada readFile(ListaLigada list) throws IOException {
		
		list = new ListaLigada();
		
		String path = chooseFile().getPath();
		
		BufferedReader read = new BufferedReader(new FileReader(path));
		verificarConsultas.path10 = path;
		
		String vet[];
		
		Pacientes paciente;
		String lido;
		
		//duas vezes, por algum motivo ele ta lendo duplicado sem isso
		lido = read.readLine();
		while(lido !=null ) {
			vet = lido.split(";");
            //Eu guardo no vetor o que estava salvo no buffer
            paciente = new Pacientes();
            paciente.setNomecompleto(vet[0]);
            paciente.setTelefone(vet[1]);
            paciente.setEmail(vet[2]);
            paciente.setRg(vet[3]);
            paciente.setDataAgenda(vet[4]);
            paciente.setTipoDeAgendamento(vet[5]);
            list.adicionar(paciente);
            
            lido = read.readLine();
		}
		read.close();
		return list;
		// Fecho o leitor
	}
	
	
	
}
