package lab2;

import java.util.Arrays;

/**
 * A Classe Disciplina representa uma disciplina cursada por um aluno, permite o cadastro de horas de estudo, de notas (e seus pesos, caso existam) e o cálculo da média final alcançada pelo aluno.
 * @author brunarochaa
 */

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;
    private double media;
    private int numeroNotas;
    private int[] pesos;

    /**
     * Inicializa uma nova disciplina, com um array para armazenar 4 notas.
     * @param nomeDisciplina Nome da discplina.
     */
    public Disciplina (String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.numeroNotas = 4;
        this.notas = new double[4];
    }

    /**
     * Inicializa uma nova disciplina, com um array de tamanho específico para armazenar notas.
     * @param nomeDisciplina Nome da disciplina.
     * @param numeroNotas Número de notas que o array poderá armazenar.
     */

    public Disciplina (String nomeDisciplina, int numeroNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.numeroNotas = numeroNotas;
        this.notas = new double[numeroNotas];
    }

    /**
     * Inicializa uma nova disciplina com um array de tamanho específico para armazenar notas e um array de pesos para calcular a média ponderada das notas da disciplina.
     * @param nomeDisciplina Nome da disciplina.
     * @param numeroNotas Npumero de notas que o array poderá armazenar.
     * @param pesos Array com pesos para cálculo da média.
     */
    public Disciplina (String nomeDisciplina, int numeroNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.numeroNotas = numeroNotas;
        this.pesos = pesos;
        this.notas = new double[numeroNotas];
    }

    /**
     * Cadastra o número de horas de estudo destinadas à disciplina.
     * @param horasEstudo Quantidade de horas a serem somadas.
     */
    public void cadastraHoras(int horasEstudo) {
        this.horasEstudo += horasEstudo;
    }

    /**
     * Cadastra ou altera uma nota (específica) da disciplina.
     * @param nota Número da nota a ser alterada (iniciada em 1).
     * @param valorNota Valor da nota.
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Calcula e retorna o valor da média obtida pelo aluno, ponderada ou não.
     * @return Média calculada.
     */
    public double calculaMedia() {
        // verifica se o array existe na memória, se existe, verifica se o tamanho é maior do que 0
        if (notas == null || notas.length == 0) {
            return 0.0;
        }

        if (pesos != null && pesos.length == numeroNotas) {
            double somatorioPonderado = 0;
            int somatorioPesos = 0;

            for (int i = 0; i < numeroNotas; i++) {
                somatorioPonderado += notas[i] * pesos[i];
                somatorioPesos += pesos[i];
            }

            if (somatorioPesos > 0) {
                media = somatorioPonderado / somatorioPesos;
            } else {
                media = 0.0;
            }

        } else {
            double somatorioNotas = 0;

            for (double num : notas) {
                somatorioNotas += num;
            }

            media = somatorioNotas / notas.length;
        }

        return media;
    }

    /**
     * Verifica se o aluno foi aprovado ou não na disciplina com base na sua média.
     * @return true se a média for maior ou igual a 7.0; false se for menor que 7.0.
     */
    public boolean aprovado() {
        if (calculaMedia() >= 7.0) {
            return true;
        }
        return false;
    }

    /**
     * Retorna um resumo geral da disciplina, com o nome, a média e as notas cadastradas.
     * @return String de dados da disciplina.
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + media + " " + Arrays.toString(this.notas);
    }

}