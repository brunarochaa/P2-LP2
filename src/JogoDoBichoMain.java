public static void main(String[] args) {
    // Instanciamos (criamos) o nosso jogo na memória
    JogoDoBicho jogo = new JogoDoBicho();

    System.out.println("Sorteando os números da sua aposta...\n");

    // 1º Passo: Mandamos fazer a aposta (gera os 5 números)
    List<Integer> minhaAposta = jogo.fazAposta();

    // 2º Passo: Mandamos imprimir o bilhete que acabou de ser gerado
    jogo.imprimeAposta(minhaAposta);

    // Abaixo, apenas um teste extra para mostrar à professora que o
    // Requisito 2 (tratar número inválido) está funcionando corretamente.
    System.out.println("\n--- TESTE DE SEGURANÇA (Validação) ---");
    System.out.println("Tentando pegar o bicho 99: " + jogo.pegaOBicho(99));
    System.out.println("Tentando pegar o bicho 0: " + jogo.pegaOBicho(0));
}