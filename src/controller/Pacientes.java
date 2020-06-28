package controller;

public class Pacientes {

    private String nomecompleto;
    private String rg;
    private String email;
    private String telefone;

    // construtor	 
    Pacientes() {
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
	
    
}
