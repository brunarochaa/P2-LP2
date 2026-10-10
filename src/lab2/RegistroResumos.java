package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Classe RegistroResumos permite adicionar uma quantidade fixa de resumos com tema e conteúdo próprios, listá-los e imprimir uma lista dos seus temas, contar quantos resumos já foram adcionados e verificar a existência de um resumo a partir do seu tema ou de uma palavra-chave específica em seu conteúdo.
 * @author brunarochaa
 */

public class RegistroResumos {

    private Resumo[] resumos;
    private int limite;
    private int ponteiro;
    private int quantidade;

    /**
     * Inicializa um novo registro de resumos com capacidade máxima definida, criando um array interno.
     * @param numeroDeResumos Número máximo de resumos a serem registrados.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.limite = numeroDeResumos;
        this.resumos = new Resumo[numeroDeResumos];
        this.ponteiro = 0;
        this.quantidade = 0;
    }

    /**
     * Adiciona um resumo no array pré-definido de resumos, ou atualiza seu conteúdo caso o tema já exista. Quando o limite de resumos é excedido, os resumos das posições mais antigas são substituídos, a partir da lógica do buffer circular.
     * @param tema Tema do resumo.
     * @param conteudo Conteúdo do resumo.
     */
    public void adiciona(String tema, String conteudo) {
        for (int i = 0; i < this.quantidade; i++) {
            if (this.resumos[i].getTema().equals(tema)) {
                this.resumos[i].setConteudo(conteudo);
                return;
            }
        }

        this.resumos[this.ponteiro] = new Resumo(tema, conteudo);

        if (this.quantidade < this.limite) {
            this.quantidade ++;
        }

        this.ponteiro = (this.ponteiro + 1) % this.limite;
    }

    /**
     * Retorna um array contendo a representação textual de todos os resumos já registrados, com tema e conteúdo.
     * @return Um array de Strings com os resumos.
     */
    public String[] pegaResumos() {
        String[] listaResumos = new String[this.quantidade];
        for (int i = 0; i < this.quantidade; i++) {
            listaResumos[i] = this.resumos[i].toString();
        }
        return listaResumos;
    }

    /**
     * Retorna um relatório textual contendo a quantidade de resumos cadastrados e uma lista de seus temas separados por uma barra "|".
     * @return Uma String formatada do relatório dos resumos.
     */
    public String imprimeResumos() {
        String[] listaResumos = new String[this.quantidade];

        for (int i = 0; i < this.quantidade; i++) {
            listaResumos[i] = this.resumos[i].getTema();
        }

        String resumosFormatados = String.join(" | ", listaResumos);

        return "- " + this.quantidade + " resumo(s) cadastrado(s)\n- " + resumosFormatados;
    }

    /**
     * Retorna o número de resumos cadastrados.
     * @return Quantidade de resumos.
     */
    public int conta() {
        return this.quantidade;
    }

    /**
     * Verifica se o resumo já foi cadastro, realizando a busca pelo seu tema.
     * @param tema Tema a ser buscado.
     * @return true se o resumo já estiver cadastrado; false se não estiver.
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidade; i++) {
            if (this.resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se existem resumos que contém uma palavra-chave em seu conteúdo e retorna um array com os temas dos resumos encontrados.
     * @param chaveDeBusca Palavra-chave a ser buscada.
     * @return Um array de Strings com os temas encontrados.
     */
    public String[] busca(String chaveDeBusca) {
        List<String> arrayTemas = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            String texto = resumos[i].getConteudo();
            if (texto.contains(chaveDeBusca) == true) {
                arrayTemas.add(resumos[i].getTema());
            }
        }

        Collections.sort(arrayTemas);
        return arrayTemas.toArray(new String[0]);
    }
}