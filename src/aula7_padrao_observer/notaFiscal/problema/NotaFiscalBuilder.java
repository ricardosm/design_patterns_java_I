package aula7_padrao_observer.notaFiscal.problema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
 * Imagine que, ap�s o processo de gera��o de notas fiscais de um sistema,
 *  ainda � necess�rio enviar a nota fiscal por e-mail para o cliente,
 *  salvar no banco de dados, enviar por SMS e ainda imprimi-la.
 *  
 *  Em uma implementa��o mais tradicional ter�amos, logo ap�s o processo
 *  de gera��o da nota fiscal, uma sequ�ncia de m�todos que fariam cada 
 *  uma das atividades. 
 *  
 *  Podemos implementar cada uma dessas atividades em m�todos privados,
 *  dentro da classe NotaFiscalBuilder, que � a respons�vel por gerar
 *  a NotaFiscal.
 *  
 *  Problema: Esse c�digo apresenta muitos problemas. O primeiro deles 
 *  � que essa classe j� � complexa, e sua complexidade s� tende a piorar. 
 *  Ela faz muitas coisas diferentes: manda e-mail, persiste no banco de dados, 
 *  e assim por diante.
 *  
 *  Solu��o 1: Uma primeira melhoria nele seria extrair as responsabilidades 
 *  para diferentes classes. Ou seja, uma classe respons�vel somente por 
 *  persistir no banco de dados, uma somente respons�vel por enviar e-mails
 *  e assim por diante. E, por fim, o NotaFiscalBuilder, ao inv�s de conter 
 *  todo o c�digo, reutilizar o c�digo escrito nessas classes especialistas.
 */

public class NotaFiscalBuilder {
	private String razaoSocial;
	private String cnpj;
	private double valorBruto;
	private double impostos;
	private Calendar data;
	private String observacoes;
	
	private List<ItemDaNota> itens;
	
	public NotaFiscalBuilder() {
		this.itens = new ArrayList<>();
	}
	
	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}
	
	public NotaFiscalBuilder comCNPJ(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	
	public NotaFiscalBuilder comItem(ItemDaNota item) {
		itens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}
	
	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}
	
	public NotaFiscalBuilder naDataAtual() {
		this.data = Calendar.getInstance();
		return this;
	}
	
	public NotaFiscal constroi() {
		NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, cnpj, data, valorBruto, impostos, itens, observacoes);
		
		enviaPorEmail(notaFiscal);
		salvaNoBanco(notaFiscal);
		enviaPorSMS(notaFiscal);
		imprime(notaFiscal);
		
		return notaFiscal;
	}
	
	private void enviaPorEmail(NotaFiscal notaFiscal) {
		System.out.println("Enviando por e-mail...");
	}
	
	private void salvaNoBanco(NotaFiscal notaFiscal) {
		System.out.println("Salvando no banco de dados...");
	}
	
	private void enviaPorSMS(NotaFiscal notaFiscal) {
		System.out.println("Enviando por SMS...");
	}
	
	private void imprime(NotaFiscal notaFiscal) {
		System.out.println("Imprimindo NotaFiscal...");
	}
	
	
	
	
	
	
	
	
	
	
		
}
