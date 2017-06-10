package crud;
import java.time.LocalDate;

public class Pessoa {
  
  private String nome;
  private String cpf; 
  private LocalDate dataNascimento;
  private String telefone; 
  private Endereco end; 
  
  
  public Pessoa(){
	  nome ="";
	  cpf ="";
	  telefone = "";
  }
  
  
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

	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + 
				", telefone=" + telefone + ", end=" + end + "]";
	}


	public boolean equals(Pessoa outro){
		boolean resultado = false; 
		
		if(outro != null && this.cpf != null){
			resultado = this.cpf.equals(outro.cpf);
		}
		
		return resultado; 
	}
	  
  
}
