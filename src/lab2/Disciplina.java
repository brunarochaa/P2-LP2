package lab2;

import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;
    private double media;
    private int numeroNotas;
    private int[] pesosNotas;

    public Disciplina (String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
    }

    public Disciplina(int numeroNotas) {
        this.numeroNotas = numeroNotas;
    }

    public Disciplina(String nomeDisciplina, int numeroNotas, int[] pesosNotas) {
        this.pesosNotas = new int[pesosNotas];
    }

    public void cadastraHoras(int horasEstudo) {
        this.horasEstudo += horasEstudo;
    }

    public void cadastraNota(int nota, double valorNota) {
        notas[nota - 1] = valorNota;
    }

    public boolean aprovado() {
        double somatorioNotas = 0;

        for (int i = 0; i < quantidade; i++;) {
            somatorioNotas += notas[i] * pesoNotas[i];

        }

        media = somatorioNotas / 4;

        if (media >= 7.0) {
            return true;
        }
        return false;
    }



    @Override
    public String toString() {

        return nomeDisciplina + " " + media + " " + Arrays.toString(this.notas);
    }

}

