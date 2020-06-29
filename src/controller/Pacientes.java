package controller;

public class Pacientes {

    private String nomecompleto;
    private String rg;
    private String email;
    private String telefone;
	private String dataAgenda;
	private String TipoDeAgendamento;
    
    public String getTipoDeAgendamento() {
		return TipoDeAgendamento;
	}


	public void setTipoDeAgendamento(String tipoDeAgendamento) {
		TipoDeAgendamento = tipoDeAgendamento;
	}


	// construtor	 
    public Pacientes() {
        super();
    }

    
	public String getNomecompleto() {
		return nomecompleto;
	}


	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public void setTelefone(String telefone) {
		 this.telefone = telefone;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
    public String getDataAgenda() {
		return dataAgenda;
	}


	public void setDataAgenda(String dataAgenda) {
		this.dataAgenda = dataAgenda;
	}
	
    
}
