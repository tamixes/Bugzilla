package old;

// ESSA CLASSE REPRESENTA A ENCOMENDA

public class Produto {

	private int pedido; 
	private String tipo; 
	private double peso; 
	private boolean entregue = false; 
	// esse entregue muda para true quando o produto for entregue, ele é alterado junto com o rastreio
	private int codigo;
	//esse codigo é usado para rastrear a encomenda cadastrada
	
	public Produto(int pedido, String tipo, double peso, int codigo){
		this.pedido = pedido; 
		this.tipo = tipo;
		this.peso = peso;
		this.codigo = codigo; 
	}

	public int getPedido(){
		return pedido;
	}

	public void setPedido(int pedido){
		this.pedido = pedido;
	}

	public String getTipo(){
		return tipo;
	}

	public void setTipo(String tipo){
		this.tipo = tipo;
	}

	public double getPeso(){
		return peso;
	}

	public void setPeso(double peso){
		this.peso = peso;
	}

	public int getCodigo(){
		return codigo;
	}

	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	
	public boolean IsEntregue(){
		return entregue;
	}
	
	public boolean equals(Produto outro){
		boolean resultado = false;
		
		if(outro != null){
				resultado = (this.pedido == outro.pedido) && (this.codigo == outro.codigo);
			}
		return resultado; 
	}

	public String toString(){
		return "Produto [pedido=" + pedido + ", tipo=" + tipo + ", peso=" + peso + ", codigo=" + codigo + "]";
	}
		
}
