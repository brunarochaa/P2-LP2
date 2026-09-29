// As importações (imports) trazem ferramentas prontas do Java para o nosso projeto.
import java.util.ArrayList;   // Permite criar uma lista que pode mudar de tamanho e ser ordenada.
import java.util.Collections; // Contém ferramentas matemáticas e de organização, como a ordenação (sort).
import java.util.HashSet;     // Cria um conjunto de dados que PROÍBE itens repetidos automaticamente.
import java.util.List;        // É a "interface" (molde) para usar o ArrayList.
import java.util.Random;      // Ferramenta para gerar números aleatórios.
import java.util.Set;         // É a "interface" (molde) para usar o HashSet.

public class JogoDoBicho {

    // -------------------------------------------------------------------------
    // REQUISITO 1: Animais de 01 a 25
    // -------------------------------------------------------------------------
    // Criamos um vetor (array) de Strings.
    // Importante: No Java, a primeira posição é o índice zero (0).
    // Então, "Avestruz" está na posição 0, "Águia" na 1, e "Vaca" na 24.
    private final String[] animais = {
            "Avestruz", "Águia", "Burro", "Borboleta", "Cachorro", // 0 a 4
            "Cabra", "Carneiro", "Camelo", "Cobra", "Coelho",      // 5 a 9
            "Cavalo", "Elefante", "Galo", "Gato", "Jacaré",        // 10 a 14
            "Leão", "Macaco", "Porco", "Pavão", "Peru",            // 15 a 19
            "Touro", "Tigre", "Urso", "Veado", "Vaca"              // 20 a 24
    };

    // -------------------------------------------------------------------------
    // REQUISITO 2: Pega o Bicho (Recuperar o bicho correspondente a um número)
    // -------------------------------------------------------------------------
    public String pegaOBicho(int numero) {
        // CUIDADO COM NÚMEROS INVÁLIDOS:
        // Se o número for menor que 1 ou maior que 25, barramos a execução.
        // Isso evita que o programa dê erro tentando buscar uma posição que não existe.
        if (numero < 1 || numero > 25) {
            return "Número Inválido! O bicho deve ser de 1 a 25.";
        }

        // Como o grupo 1 (Avestruz) está na posição 0 do nosso array,
        // nós pegamos o número que o usuário digitou e subtraímos 1.
        // Exemplo: Se pediu o bicho 25 (Vaca), o código busca animais[24].
        return animais[numero - 1];
    }

    // -------------------------------------------------------------------------
    // REQUISITO 3: Faz Aposta (Escolher 5 números aleatórios sem repetir)
    // -------------------------------------------------------------------------
    public List<Integer> fazAposta() {
        // Por que usar Set/HashSet?
        // A professora pediu para NÃO repetir os animais. O HashSet é uma coleção
        // inteligente no Java que simplesmente ignora números duplicados.
        Set<Integer> numerosSorteados = new HashSet<>();

        // Criamos o nosso gerador de números aleatórios
        Random random = new Random();

        // O laço (while) vai rodar até que o nosso conjunto tenha EXATAMENTE 5 números.
        while (numerosSorteados.size() < 5) {
            // nextInt(25) gera números de 0 a 24.
            // Somamos + 1 para que o sorteio fique entre 1 e 25.
            int numeroSorteado = random.nextInt(25) + 1;

            // Tentamos adicionar. Se o número já estiver lá dentro,
            // o HashSet recusa silenciosamente e o laço roda de novo.
            numerosSorteados.add(numeroSorteado);
        }

        // A professora pediu ORDEM CRESCENTE (Requisito 4).
        // Porém, o HashSet não permite ordenação. Então, nós transferimos
        // os nossos 5 números sorteados para um ArrayList (que permite ordenar).
        List<Integer> bilhete = new ArrayList<>(numerosSorteados);

        // O comando Collections.sort pega o bilhete e organiza do menor pro maior.
        Collections.sort(bilhete);

        // Retornamos a lista final pronta
        return bilhete;
    }

    // -------------------------------------------------------------------------
    // REQUISITO 4: Imprime Aposta (Mostrar os 5 animais em ordem crescente)
    // -------------------------------------------------------------------------
    public void imprimeAposta(List<Integer> bilhete) {
        System.out.println("===================================");
        System.out.println("         BILHETE DE APOSTA         ");
        System.out.println("===================================");

        // Este é um laço "for-each". Ele lê-se assim:
        // "Para cada 'numero' dentro da lista 'bilhete', faça o seguinte:"
        for (int numero : bilhete) {
            // Chamamos a função do Requisito 2 para descobrir o nome do animal
            String nomeDoBicho = pegaOBicho(numero);

            // O printf formata o texto.
            // O %02d força o número a ter duas casas (ex: 3 vira 03).
            // O %s é onde o nome do bicho vai aparecer.
            System.out.printf("Grupo %02d -> %s\n", numero, nomeDoBicho);
        }

        System.out.println("===================================");
    }
}