package lab2;

/**
 * A Classe RegistroTempoOnline permitie registrar o tempo online e visualizar o progresso em relação a uma meta de tempo a ser alcançada.
 * @author brunarochaa
 */
public class RegistroTempoOnline {

    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoEsperado;

    /**
     * Constrói um registro de tempo online e define que o tempo online esperado para a disciplina será 120 horas por padrão.
     * @param nomeDisciplina Nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = 120;
        this.tempoOnline = 0;
    }

    /**
     * Constrói um registro de tempo online especificando não apenas o nome da disciplina, mas também o tempo esperado para a disciplina.
     * @param nomeDisciplina Nome da disciplina.
     * @param tempoEsperado Tempo esperado para a disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoEsperado;
        this.tempoOnline = 0;
    }

    /**
     * Adiciona minutos ao tempo online da disciplina.
     * @param tempoOnline Tempo a ser adicionado.
     */
    public void adicionaTempoOnline(int tempoOnline) {
        this.tempoOnline += tempoOnline;
    }

    /**
     * Verifica se o tempo online acumulado já atingiu ou ultrapassou o tempo esperado.
     * @return true se o tempo online já atingiu ou ultrapassou; false se ainda não atingiu.
     */
    public boolean atingiuMetaTempoOnline() {
        if (this.tempoOnline >= this.tempoEsperado) {
            return true;
        }
        return false;
    }

    /**
     * Retorna um relatório textual da situação do aluno em relação as horas onine. contendo o nome da disciplina, o tempo online e o tempo esperado.
     * @return Uma String com o relatório.
     */
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.tempoOnline + "/" + this.tempoEsperado;
    }
}