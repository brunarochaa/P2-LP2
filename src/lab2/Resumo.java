package lab2;

/**
 * A Classe Resumo representa um resumo, contendo tema e seu respctivo conteúdo.
 * @author brunarochaa
 */

public class Resumo {

    private String tema;
    private String conteudo;

    /**
     * Constrói um novo resumo.
     * @param tema Tema do resumo.
     * @param conteudo Conteúdo do resumo.
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo.
     * @return Uma String do tema do resumo.
     */
    public String getTema() {
        return this.tema;
    }

    /**
     * Retorna o conteúdo do resumo.
     * @return Uma String do conteúdo do resumo.
     */
    public String getConteudo() {
        return this.conteudo;
    }

    /**
     * Altera, ou mais especificamente, substitui o conteúdo do resumo.
     * @param conteudo O novo conteúdo que será atribuído no lugar do antigo.
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Retorna a representação textual do resumo, com seu tema e seu conteúdo.
     * @return String no formato "tema:conteudo".
     */
    @Override
    public String toString() {
        return this.tema + ":" + this.conteudo;
    }
}