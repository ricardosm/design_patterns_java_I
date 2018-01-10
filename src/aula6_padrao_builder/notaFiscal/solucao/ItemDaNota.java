package aula6_padrao_builder.notaFiscal.solucao;

public class ItemDaNota {

	private double valor;
	private String nome;

	public ItemDaNota(String nome, double valor) {
		this.valor = valor;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public double getValor() {
		return this.valor;
	}

}
