package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	

	public void readFile() throws IOException {
		BufferedReader read = new BufferedReader(new FileReader(chooseFile()));
		StringBuffer buffer = new StringBuffer();
		String vet[] = new String[4];
		
		
		String lido;
		while((lido = read.readLine())!=null) {
			buffer.append(lido);
            String teste = buffer.toString();
            vet = teste.split(";");
           

			/*Pacientes. = lido;
            read.readLine();
            Pacientes.setEmail = lido;
            read.readLine();
            Pacientes.setTelefone = Integer.parseInt(read.readLine());*/	
		}
		read.close();
		
	}
	
	
	
}
