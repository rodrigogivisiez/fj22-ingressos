package ingresso;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.GerenciadorDeSessao;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {
	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario(){
		Filme filme = new Filme("Roque One" , Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		LocalTime horario = LocalTime.now();
		Sala sala = new Sala("Eldorado - IMAX",BigDecimal.ONE);
		List<Sessao> sessoes = Arrays.asList(new Sessao(horario,sala, filme));
		Sessao sessao = new Sessao(horario,sala, filme);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertFalse(gerenciador.cabe(sessao));		
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesTerminandoDentroDoHorarioDeUmaSessaoJaExistente(){
		Filme filme = new Filme("Roque One" , Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		LocalTime horario = LocalTime.now();
		Sala sala = new Sala("Eldorado - IMAX",BigDecimal.ONE);
		List<Sessao> sessoes = Arrays.asList(new Sessao(horario,sala, filme));
		Sessao sessao = new Sessao(horario,sala, filme);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertFalse(gerenciador.cabe(sessao));
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesIniciandoDentroDoHorarioDeUmaSessaoJaExistente(){
		Filme filme = new Filme("Roque One" , Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		LocalTime horario = LocalTime.now();
		Sala sala = new Sala("Eldorado - IMAX",BigDecimal.ONE);
		List<Sessao> sessoesDaSala = Arrays.asList(new Sessao(horario,sala, filme));
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoesDaSala);
		Assert.assertFalse(gerenciador.cabe(new Sessao(horario.minusHours(1),sala,filme)));
	}
	
	@Test 
	public void garanteQueDevePermitirUmaInsercaoEntreDoisFilmes(){

		
		Sala sala = new Sala("Eldorado - IMAX",BigDecimal.ONE);
		Filme filme1 = new Filme("Roque One" , Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		LocalTime dezHoras = LocalTime.parse("10:00:00");
		Sessao sessaoDasDez = new Sessao(dezHoras, sala, filme1);
		
		Filme filme2 = new Filme("Roque One" , Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		LocalTime dezoitoHoras = LocalTime.parse("18:00:00");
		Sessao sessaoDasDezoito = new Sessao(dezoitoHoras, sala, filme2);
		
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez, sessaoDasDezoito);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertTrue(gerenciador.cabe(new Sessao(LocalTime.parse("13:00:00"),sala,filme2)));
	}
		
	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme(){
		Sala sala = new Sala("Eldorado - IMAX",new BigDecimal("22.5"));
		Filme filme = new Filme("Roque One" , Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12.0"));
		BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
		Sessao sessao = new Sessao(LocalTime.now(),sala, filme);
		assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
		
	}
	
	@Test
	public void deveRetornarFalseQuandoASessaoForVazia(){
		
		LocalTime duasEMeia = LocalTime.of(14, 30);
		
		Filme f1 = new Filme("HArry porter" , Duration.ofMinutes(120), "aventura", BigDecimal.ONE);
		
		Sala sala = new Sala("3d",BigDecimal.ONE);
		
		Sessao s1 = new Sessao();
		//Sessao s1 = new Sessao(duasEMeia ,sala, f1);
		
		List<Sessao> sessoeExistentes = Arrays.asList(
				new Sessao(
						LocalTime.of(13, 00),
						sala, 
						new Filme("filme 1", Duration.ofMinutes(120), "aventura",BigDecimal.ONE)),
				new Sessao(
						LocalTime.of(20, 00),
						sala, 
						new Filme("filme 2", Duration.ofMinutes(90), "aventura",BigDecimal.ONE )),
				new Sessao(
						LocalTime.of(10, 00),
						sala, 
						new Filme("filme 3", Duration.ofMinutes(150), "aventura",BigDecimal.ONE))
						
				);
		
		GerenciadorDeSessao g = new GerenciadorDeSessao(sessoeExistentes);
		
		//Assert.assertFalse(g.cabe(s1));
		
	}
	
	@Test
	public void deveRetornarFalseQuandoNaoCabe(){
	}
}
