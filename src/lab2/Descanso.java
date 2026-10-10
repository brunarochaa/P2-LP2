package lab2;

/**
 * A Classe Descanso possibilita o controle das horas de descanso de um estudante, a partir do registro das horas descansadas por ele ao longo de um número de semanas.
 * @author brunarochaa
 */

public class Descanso {

        private int horasDescanso;
        private int numeroDeSemanas;

        /**
         * Define quantas horas foram destinadas ao descanso.
         * @param horasDescanso Quantidade de horas de descanso.
         */
        public void defineHorasDescanso(int horasDescanso) {
                this.horasDescanso = horasDescanso;
        }

        /**
         * Define o intervalo de tempo considerado para a avaliação do descanso do aluno.
         * @param numeroDeSemanas Número de semanas.
         */
        public void defineNumeroSemanas(int numeroDeSemanas) {
                this.numeroDeSemanas = numeroDeSemanas;
        }

        /**
         * Retorna o status geral do aluno baseado na média de descanso por semana.
         * Se a média for maior ou igual a 26 horas/semana, considera-se que o aluno está descansado; caso contrário, o aluno é considerado cansado.
         * @return Uma String ("descansado" ou "cansado") que aponta o status atual do aluno.
         */
        public String getStatusGeral() {
                if (this.numeroDeSemanas > 0 && this.horasDescanso/this.numeroDeSemanas >= 26) {
                        return "descansado";
                }
                return "cansado";
        }
}