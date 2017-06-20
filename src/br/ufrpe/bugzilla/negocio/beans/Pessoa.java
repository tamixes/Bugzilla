package br.ufrpe.bugzilla.negocio.beans;
import java.time.LocalDate;

public class Pessoa {
  
  private String nome;
  private String cpf; 
  private LocalDate dataNascimento;
  private String telefone; 
  private Endereco end; 
  
 
  
  
  public Pessoa(String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco end){
	  this.nome = nome;
	  this.cpf = cpf;
	  this.dataNascimento = dataNascimento;
	  this.telefone = telefone;
	  this.end = end;
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
	
	
	public LocalDate getDataNascimento(){
		return dataNascimento;
	}
	
	
	public void setDataNascimento(LocalDate dataNascimento){
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

	public String dataAnivo(){
		int dia = dataNascimento.getDayOfMonth();
		int mes = dataNascimento.getMonthValue();
		int ano = dataNascimento.getYear(); 
		
		String resultado = Integer.toString(dia) + '/' + mes + '/' + ano; 
		
		return resultado;
		
	}
	
	public String toString(){
		
		String resultado = String.format("Nome: %s\nCPF: %s\nData de Nascimento: %s\nEndereco: %s", nome, cpf, this.dataAnivo(), end);
		
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
