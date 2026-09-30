package lab2;

import java.util.Arrays;

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;
    private double media;

    public Disciplina (String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
    }

    public void cadastraHoras(int horasEstudo) {
        this.horasEstudo += horasEstudo;
    }

    public void cadastraNota(int nota, double valorNota) {
        notas[nota - 1] = valorNota;
    }

    public boolean aprovado() {
        double somatorio_notas = 0;

        for (double num : notas) {
            somatorio_notas += num;

        }

        media = somatorio_notas / 4;

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

