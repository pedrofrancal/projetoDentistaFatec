package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

//Parte Read feita por Augusto Furtado


public class Read {

	private File chooseFile() {
        File filePath;
        
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo TXT", "txt");
        file.setFileFilter(filter);
        int returnVal = file.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            filePath = file.getSelectedFile();
            return filePath;
        }else {
            return null;
        }
        
    }
	

	public ListaLigada readFile(ListaLigada list) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader(chooseFile()));
		StringBuffer buffer = new StringBuffer();
		String vet[] = new String[4];
		Pacientes paciente = new Pacientes();
		
		String lido;
		while((lido = read.readLine())!=null) {
			buffer.append(lido);
            String teste = buffer.toString();
            vet = teste.split(";");
            //Eu guardo no vetor o que estava salvo no buffer
            
            paciente.setNomecompleto(vet[0]);
            paciente.setTelefone(vet[1]);
            paciente.setEmail(vet[2]);
            paciente.setRg(vet[3]);
            paciente.setDataAgenda(vet[4]);
            paciente.setTipoDeAgentamento(vet[5]);
            list.adicionar(paciente);
		}
		read.close();
		return list;
		// Fecho o leitor
	}
	
	
	
}
