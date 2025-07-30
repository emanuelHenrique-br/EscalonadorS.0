import java.util.ArrayList;
import java.util.List;

public class FCFS {
	public static void main(String[] args) {
		List<Processo> processos = new ArrayList<>();

		// Adicionando processos (ID, Tempo de Chegada, Tempo de Execução)
		processos.add(new Processo(1, 0, 5)); // Processo 1: chega no tempo 0, executa por 5 unidades
		processos.add(new Processo(2, 1, 3)); // Processo 2: chega no tempo 1, executa por 3 unidades
		processos.add(new Processo(3, 2, 8)); // Processo 3: chega no tempo 2, executa por 8 unidades

		simularFCFS(processos);
	}

	public static void simularFCFS(List<Processo> processos) {
		int tempoAtual = 0;
		int totalProcessos = processos.size();
		int[] tempoEspera = new int[totalProcessos];
		int[] tempoTurnaround = new int[totalProcessos];

		System.out.println("=== Simulação FCFS ===");

		for (int i = 0; i < totalProcessos; i++) {
			Processo p = processos.get(i);

			// Se o processo chegou depois do tempo atual, avança o tempo
			if (tempoAtual < p.getTempoChegada()) {
				tempoAtual = p.getTempoChegada();
			}

			// Tempo de Espera = Tempo Atual - Tempo de Chegada
			tempoEspera[i] = tempoAtual - p.getTempoChegada();

			// Tempo de Turnaround = Tempo de Espera + Tempo de Execução
			tempoTurnaround[i] = tempoEspera[i] + p.getTempoExecucao();

			// Atualiza o tempo atual (processo executa até o fim)
			tempoAtual += p.getTempoExecucao();

			System.out.println("Processo " + p.getId() + " | Tempo de Espera: " + tempoEspera[i]
					+ " | Tempo de Turnaround: " + tempoTurnaround[i]);
		}

		// Cálculo das médias
		double mediaEspera = calcularMedia(tempoEspera);
		double mediaTurnaround = calcularMedia(tempoTurnaround);

		System.out.println("\n=== Métricas ===");
		System.out.println("Tempo Médio de Espera: " + mediaEspera);
		System.out.println("Tempo Médio de Turnaround: " + mediaTurnaround);
	}

	private static double calcularMedia(int[] tempos) {
		int soma = 0;
		for (int tempo : tempos) {
			soma += tempo;
		}
		return (double) soma / tempos.length;
	}
}
