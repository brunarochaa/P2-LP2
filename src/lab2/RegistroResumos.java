package lab2;

import java.util.ArrayList;
import java.util.List;
/*
TENTAR TORNA ESSA CLASSE MAIS CONCISA
 */

public class RegistroResumos {

    private Resumo[] resumos;
    private int limite;
    private int ponteiro;
    private int quantidade;
    private String chaveDeBusca;

    public RegistroResumos(int numeroDeResumos) {
        this.limite = numeroDeResumos;
        this.resumos = new Resumo[numeroDeResumos];
        this.ponteiro = 0;
        this.quantidade = 0;
    }

    public void adiciona(String tema, String conteudo) {
        for (int i = 0; i < this.quantidade; i++) {
            if (this.resumos[i].getTema().equals(tema)) {
                this.resumos[i].setConteudo(conteudo);
            }
        }

        this.resumos[this.ponteiro] = new Resumo(tema, conteudo);

        if (this.quantidade < this.limite) {
            this.quantidade ++;
        }

        this.ponteiro = (this.ponteiro + 1) % this.limite;
    }

    public String[] pegaResumos() {
        String[] lista = new String[this.quantidade];
        for (int i = 0; i < this.quantidade; i++) {
            lista[i] = this.resumos[i].toString();
        }
        return lista;
    }

    public String imprimeResumos() {
        String[] listaResumos = new String[this.quantidade];

        for (int i = 0; i < this.quantidade; i++) {
            listaResumos[i] = this.resumos[i].getTema();
        }

        String resumosFormatados = String.join(" | ", listaResumos);

        return "- " + this.quantidade + " resumo(s) cadastrado(s)\n- " + resumosFormatados;
    }

    public int conta() {
        return this.quantidade;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidade; i++) {
            if (this.resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    public String[] busca(String chaveDeBusca) {
        List<String> saida = new ArrayList<>()
        for (int i = 0; i < quantidade; i++){
            String conteudo = resumos[i].getConteudo();
            if (conteudo.contains(chaveDeBusca.toLowerCase())) {
            saida.add(resumos[i].getTema());
            }
        }
        java.util.Collections.sort(saida);
        return saida.toArray(new String[0]);
    }
}
