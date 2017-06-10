package crud;
import java.time.LocalDateTime;

public class Rastreio {

	private Produto produto; 
	private LocalDateTime dateTime;
	private String operacao;
	private String local; 
	
	public Rastreio(Produto produto, LocalDateTime dateTime, String operacao, String local){
		this.produto = produto;
		this.dateTime = dateTime;
		this.operacao = operacao; 
		this.local = local;
	}
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String toString() {
		return "Rastreio [produto=" + produto + ", dateTime=" + dateTime + ", operacao=" +
				operacao + ", local=" + local + "]";
	}
	
	
	
	
}
