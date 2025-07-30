public class Processo {

	// atributos da classe processo
	private int id;
	private int tempoChegada;
	private int tempoExecucao;

	// construtor da classe processo
	public Processo(int id, int tempoChegada, int tempoExecucao) {
		this.id = id;
		this.tempoChegada = tempoChegada;
		this.tempoExecucao = tempoExecucao;
	}

	// Getters
	public int getId() {
		return id;
	}

	public int getTempoChegada() {
		return tempoChegada;
	}

	public int getTempoExecucao() {
		return tempoExecucao;
	}
}
