public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;

    public Descanso() {
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    public void definirHoras(int horas) {
        this.horasDescanso = horas;
    }

    public void definirSemanas(int semanas) {
        this.numeroSemanas = semanas;
    }

    public String getStatus() {
        if (this.numeroSemanas > 0 && (this.horasDescanso / this.numeroSemanas) >= 26) {
            return "descansado";
        }
        return "cansado";
    }

    public static void main(String[] args) {
        Descanso d1 = new Descanso();
        d1.definirHoras(30);
        d1.definirSemanas(1);
        System.out.println("Status 1: " + d1.getStatus());
        d1.definirHoras(26);
        d1.definirSemanas(2);

        System.out.println("Status 2: " + d1.getStatus());
    }
}

