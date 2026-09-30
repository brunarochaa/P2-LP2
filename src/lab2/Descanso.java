package lab2;

public class Descanso {

        private int horasDescanso;
        private int numeroDeSemanas;

        public void defineHorasDescanso(int horasDescanso) {
                this.horasDescanso = horasDescanso;
        }

        public void defineNumeroSemanas(int numeroDeSemanas) {
                this.numeroDeSemanas = numeroDeSemanas;
        }

        public String getStatusGeral() {

                if (this.numeroDeSemanas > 0 && this.horasDescanso/this.numeroDeSemanas >= 26) {
                        return "descansado";
                }

                return "cansado";

                }
}
