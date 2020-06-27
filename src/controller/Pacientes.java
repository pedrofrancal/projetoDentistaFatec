package controller;

public class Pacientes {

    private String nomecompleto;
    private int rg;
    private String email;


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


	public int getRg() {
		return rg;
	}


	public void setRg(int rg) {
		this.rg = rg;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

    
}
