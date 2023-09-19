package br.gov.sp.etec.gestaofesta.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Convidado {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idConvidado;
	private String nome;
	private String rg;
	private String cpf;
	private int numero;
	
	public Long getIdConvidado() {
		return idConvidado;
	}
	public void setIdConvidado(Long idConvidado) {
		this.idConvidado = idConvidado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
