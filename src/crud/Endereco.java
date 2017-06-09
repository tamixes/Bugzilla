package crud;

public class Endereco {
	
	private String rua; 
	private String bairro; 
	private String cidade; 
	private String estado; 
	private String cep; 
	private int numero;
	
	public Endereco(){
		rua = "";
		bairro = "";
		cidade = "";
		estado = "";
		cep = "";
	}
	
	public Endereco(String rua, String bairro, String cidade, String estado,
					String cep, int numero){
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade; 
		this.estado = estado; 
		this.cep = cep; 
		this.numero = numero; 
	}

	public String getRua(){
		return rua;
	}

	public void setRua(String rua){
		this.rua = rua;
	}

	public String getBairro(){
		return bairro;
	}
	
	public void setBairro(String bairro){
		this.bairro = bairro;
	}

	public String getCidade(){
		return cidade;
	}

	public void setCidade(String cidade){
		this.cidade = cidade;
	}

	public String getEstado(){
		return estado;
	}

	public void setEstado(String estado){
		this.estado = estado;
	}

	public String getCep(){
		return cep;
	}

	public void setCep(String cep){
		this.cep = cep;
	}

	public int getNumero(){
		return numero;
	}

	public void setNumero(int numero){
		this.numero = numero;
	}
	
	public boolean equals(Endereco outroEndereco){
		boolean resultado = false; 
		
		if(this.rua.equals(outroEndereco.getRua()) &&
			this.bairro.equals(outroEndereco.getBairro()) &&
			this.cidade.equals(outroEndereco.getCidade()) &&
			this.estado.equals(outroEndereco.getEstado()) &&
			this.cep.equals(outroEndereco.getCep()) &&
			this.numero == outroEndereco.getNumero()){
			
			resultado = true;
		}
		
		return resultado;
	}

	public String toString() {
		return "Endereco [rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep="
				+ cep + ", numero=" + numero + "]";
	}
	
	
	

}
