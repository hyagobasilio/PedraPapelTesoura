import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class PedraPapelTesouraJogo {
	
	private Scanner scanner = new Scanner(System.in);
	private Jogador jogador;
	private String 	jogadaUsuario;
	private String 	jogadaPC;
	
	public void iniciarNovoJogo() {
		pedirNomeJogador();
		jogar();
	}

	private void jogar() {
		pedirOpcaoJogador();
		validaOpcaoJogador();
		gerarJogadaDoPC();
		verificaSeJogadorGanhou();
		lancaAsEscolhasDosJogadores();
		verificaContinuarJogo();
	}

	private void lancaAsEscolhasDosJogadores() {
		System.out.println("Você jogou: " + jogadaUsuario + ", PC jogou: " + jogadaPC);
	}

	private void verificaContinuarJogo() {
		System.err.println("Deseja jogar novamente? S/N");
		String escolha = scanner.nextLine();
		if(escolha.equalsIgnoreCase("S")) {
			jogar();
		}
		
	}

	private void validaOpcaoJogador() {
		if(!listaOpcoes().contains(jogadaUsuario)) {
			System.err.println("Escolha uma opção válida!");
			jogar();
		}
	}
	
	private List<String> listaOpcoes() {
		List<String> lista = new ArrayList<String>();
		lista.add("PEDRA");
		lista.add("PAPEL");
		lista.add("TESOURA");
		return lista;
	}

	private void gerarJogadaDoPC() {
		
		int numeroGerado = new Random().nextInt(3);
		jogadaPC = listaOpcoes().get(numeroGerado);
	}


	private void pedirOpcaoJogador() {
		System.out.println("Digite pedra, papel ou tesoura para jogar!");
		jogadaUsuario = scanner.nextLine().toUpperCase();
		
	}

	private void pedirNomeJogador() {
		System.out.println("Insira seu nome:");
		jogador = new Jogador();
		String nome = scanner.nextLine();
		jogador.setNome(nome);
		lancaMensagemBoasVindas();
	}
	
	private void lancaMensagemBoasVindas() {
		System.out.println("Bem vindo ao jogo " + this.jogador.getNome());
	}


	private void verificaSeJogadorGanhou() {
		if("PEDRA".equals(jogadaUsuario)) {
			if("PAPEL".equals(jogadaPC)) {
				lancaMensagemPerdeu();
			}else if("TESOURA".equals(jogadaPC)) {
				lancaMensagemGanhou();
			}else  {
				lancaMensagemEmpate();
			}
		}else if("PAPEL".equals(jogadaUsuario)) {
			if("TESOURA".equals(jogadaPC)) {
				lancaMensagemPerdeu();
			}else if("PEDRA".equals(jogadaPC)) {
				lancaMensagemGanhou();
			}else  {
				lancaMensagemEmpate();
			}
		}else if("TESOURA".equals(jogadaUsuario)) {
			if("PEDRA".equals(jogadaPC)) {
				lancaMensagemPerdeu();
			}else if("PAPEL".equals(jogadaPC)) {
				lancaMensagemGanhou();
			}else  {
				lancaMensagemEmpate();
			}
		}
	}
	
	private void lancaMensagemEmpate() {
		System.err.println("Você empatou");
	}

	private void lancaMensagemGanhou() {
		System.err.println("Parabéns você ganhou!");
	}
	
	private void lancaMensagemPerdeu() {
		System.err.println("Que pena você perdeu :/");
	}
	
}
