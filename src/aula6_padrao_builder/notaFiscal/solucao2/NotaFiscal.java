package aula6_padrao_builder.notaFiscal.solucao2;

import java.util.Calendar;
import java.util.List;

public class NotaFiscal {

	private String razaoSical;
	private String cnpj;
	private Calendar dataDeEmissao;
	private double valorBruto;
	private double impostos;
	private List<ItemDaNota> itens;
	private String observacoes;

	public NotaFiscal(String razaoSocial, String cnpj, Calendar dataDeEmissao, double valorBruto, double impostos,
			List<ItemDaNota> itens, String observacoes) {
		this.razaoSical = razaoSocial;
		this.cnpj = cnpj;
		this.dataDeEmissao = dataDeEmissao;
		this.valorBruto = valorBruto;
		this.impostos = impostos;
		this.itens = itens;
		this.observacoes = observacoes;
	}

	public String getRazaoSical() {
		return razaoSical;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Calendar getDataDeEmissao() {
		return dataDeEmissao;
	}

	public double getValorBruto() {
		return valorBruto;
	}

	public double getImpostos() {
		return impostos;
	}

	public List<ItemDaNota> getItens() {
		return itens;
	}

	public String getObservacoes() {
		return observacoes;
	}

}
