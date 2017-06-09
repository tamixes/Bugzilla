package crud;
import java.time.LocalDate;

public class Pessoa {
  
  private String nome;
  private String cpf; 
  private LocalDate dataNascimento;
  private String telefone; 
  
  
  public Pessoa(){
	  nome ="";
	  cpf ="";
	  telefone = "";
  }
  
  
  public Pessoa(String nome, String cpf, LocalDate dataNascimento, String telefone){
	  this.nome = nome;
	  this.cpf = cpf;
	  this.dataNascimento = dataNascimento;
	  this.telefone = telefone;
  }


	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getTelefone(){
		return telefone;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}


	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone
				+ "]";
	}
	
	public boolean equals(Pessoa outro){
		boolean resultado = false; 
		
		if(this.cpf.equals(outro.cpf)){
			resultado = true;
		}
		
		return resultado; 
	}
	  
  
}
