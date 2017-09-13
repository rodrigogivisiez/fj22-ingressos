package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue
	private Integer id;
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;
	
	@OneToMany
	private List<Ingresso> ingressos;
	
	private BigDecimal preco;
	


	public Sessao(LocalTime horario, Sala sala, Filme filme) {
		super();
		this.filme = filme;
		this.horario = horario;
		this.sala = sala;
		this.preco = sala.getPreco().add(filme.getPreco());
	}

	public Sessao(){
		
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public LocalTime getHorarioTermino() {
		// TODO Auto-generated method stub
		return this.horario.plus( filme.getDuracao().toMinutes(), ChronoUnit.MINUTES);
	}
	public BigDecimal getPreco() {
		// TODO Auto-generated method stub
		return filme.getPreco().add(sala.getPreco());
	}
	public Map<String, List<Lugar>> getMapaDeLugares() {
		// TODO Auto-generated method stub
		return sala.getMapaDeLugares();
	}
	public boolean isDisponivel(Lugar lugar){
		return ingressos.stream().map(Ingresso::getLugar).noneMatch(l-> l.equals(lugar));
	}
	
	
}
