package lab2;

public class RegistroTempoOnline {

    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoEsperado;

    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, 120);
    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoEsperado;
        this.tempoOnline = 0;
    }

    public void adicionaTempoOnline(int tempoOnline) {
        this.tempoOnline += tempoOnline;
    }

    public boolean atingiuMetaTempoOnline() {
        if (this.tempoOnline >= this.tempoEsperado) {
            return true;
        }
        return false;
    }

    @Override

    public String toString() {
        return this.nomeDisciplina + this.tempoOnline + "/" + this.tempoEsperado;
    }
}
