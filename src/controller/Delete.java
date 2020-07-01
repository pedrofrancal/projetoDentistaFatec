package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Delete {
	private String preparePaciente(ListaLigada controller) {
        StringBuffer buffer = new StringBuffer();
        String preparo;
        int pos = 0;
        Pacientes data = controller.get(pos);
        do {
        	buffer.append(data.getNomecompleto() + ";");
			buffer.append(data.getTelefone()+";");
			buffer.append(data.getEmail() + ";");
			buffer.append(data.getRg()+";");
			buffer.append(data.getDataAgenda()+";");
			buffer.append(data.getTipoDeAgendamento());
			buffer.append("\n");
            pos++;
            data = controller.get(pos);
        }while(data!=null);
        preparo = buffer.toString();
        return preparo;
    }

    public void removePaciente(ListaLigada controller, String nome, String path) throws IOException {
    	if(nome != "") {
    		File arq = new File(path);
    		if(controller.tamanho()==1) {
                arq.delete();
            }else {
                String save = "";
                controller.remover(nome);
                save += preparePaciente(controller);
                FileWriter writer = new FileWriter(arq);
                PrintWriter printer = new PrintWriter(writer);
                printer.write(save);
                printer.flush();
                printer.close();
                writer.close();
            }
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Paciente não encontrado");
        }
    }
}
