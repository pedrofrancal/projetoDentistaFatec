package controller;

public class Pacientes_Node{

    private Pacientes data;
    private Pacientes_Node next;
    private Pacientes_Node before;

    public Pacientes_Node (Pacientes e){
        data = e;
        next = null;
        before = null;
    }

    public Pacientes getData() {
        return data;
    }

    public void setData(Pacientes data) {
		this.data = data;
	}

    public Pacientes_Node getNext() {
        return next;
    }

    public void setNext(Pacientes_Node next) {
        this.next = next;
    }

    public Pacientes_Node getBefore() {
        return before;
    }

    public void setBefore(Pacientes_Node before) {
        this.before = before;
    }
}