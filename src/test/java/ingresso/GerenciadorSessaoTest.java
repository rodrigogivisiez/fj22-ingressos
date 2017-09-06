package ingresso;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;




import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.GerenciadorSessao;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;


public class GerenciadorSessaoTest {
	
	
	
	@Test
	public void deveRetornarFalseQuandoNaoCabe(){
		
		LocalTime duasEMeia = LocalTime.of(14, 30);
		Filme f1 = new Filme("HArry porter" , Duration.ofMinutes(120), "aventura");
		Sala sala = new Sala("3d");
		Sessao s1 = new Sessao(duasEMeia ,sala, f1);
		
		List<Sessao> sessoeExistentes = Arrays.asList(
				new Sessao(
						LocalTime.of(13, 00),
						sala, 
						new Filme("filme 1", Duration.ofMinutes(120), "aventura")),
				new Sessao(
						LocalTime.of(20, 00),
						sala, 
						new Filme("filme 2", Duration.ofMinutes(90), "aventura" )),
				new Sessao(
						LocalTime.of(10, 00),
						sala, 
						new Filme("filme 3", Duration.ofMinutes(150), "aventura" ))
						
				);
		
		GerenciadorSessao g = new GerenciadorSessao(sessoeExistentes);
		
		Assert.assertFalse(g.cabe(s1));
		
	}

	@Test
	public void deveRetornarFalseQuandoASessaoForVazia(){
		
		LocalTime duasEMeia = LocalTime.of(14, 30);
		
		Filme f1 = new Filme("HArry porter" , Duration.ofMinutes(120), "aventura");
		
		Sala sala = new Sala("3d");
		
		Sessao s1 = new Sessao();
		//Sessao s1 = new Sessao(duasEMeia ,sala, f1);
		
		List<Sessao> sessoeExistentes = Arrays.asList(
				new Sessao(
						LocalTime.of(13, 00),
						sala, 
						new Filme("filme 1", Duration.ofMinutes(120), "aventura")),
				new Sessao(
						LocalTime.of(20, 00),
						sala, 
						new Filme("filme 2", Duration.ofMinutes(90), "aventura" )),
				new Sessao(
						LocalTime.of(10, 00),
						sala, 
						new Filme("filme 3", Duration.ofMinutes(150), "aventura" ))
						
				);
		
		GerenciadorSessao g = new GerenciadorSessao(sessoeExistentes);
		
		Assert.assertFalse(g.cabe(s1));
		
	}

}
