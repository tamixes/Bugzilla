package br.ufrpe.bugzilla.negocio.beans;
import java.io.Serializable;

public class Pessoa implements Serializable{
  
	private static final long serialVersionUID = -4044140878567748490L;
	private String nome;
    private String cpf; 
    private String dataNascimento;
    private String telefone; 
    private Endereco end; 
    protected Usuario usuario;
  
  public Pessoa(String nome, String cpf, String dataNascimento, String telefone, Endereco end, Usuario usuario){
	  this.nome = nome;
	  this.cpf = cpf;
	  this.dataNascimento = dataNascimento;
	  this.telefone = telefone;
	  this.end = end;
	  this.usuario = usuario;
  }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getNome(){
		return nome;
	}
	
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	
	public String getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	
	public String getDataNascimento(){
		return dataNascimento;
	}
	
	
	public void setDataNascimento(String dataNascimento){
		this.dataNascimento = dataNascimento;
	}
	
	public String getTelefone(){
		return telefone;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public Endereco getEnd(){
		return end;
	}

	public void setEnd(Endereco end){
		this.end = end;
	}

	/*public String dataAnivo(){
		int dia = dataNascimento.getDayOfMonth();
		int mes = dataNascimento.getMonthValue();
		int ano = dataNascimento.getYear(); 
		
		String resultado = Integer.toString(dia) + '/' + mes + '/' + ano; 
		
		return resultado;
		
	}*/
	public String formataCpf(String cpf){
		
		String p1 = cpf.substring(0, 3);
		String p2 = cpf.substring(3, 6);
		String p3 = cpf.substring(6, 9);
		String p4 = cpf.substring(9, 11);

		cpf = String.format("%s.%s.%s-%s", p1, p2, p3, p4);
		return cpf;	
	}
	 
	public String toString(){
		
		String resultado = String.format("Nome: %s\nCPF: %s\nData de Nascimento: %s\nEndereco: %s", nome, this.formataCpf(this.cpf), dataNascimento, end);
		
		return resultado; 
	}

	public boolean equals(Pessoa outro){
		
		if(this.cpf.equals(outro.getCpf())){
			return true;
		}
		else{
			return false;
		}

	}

}
