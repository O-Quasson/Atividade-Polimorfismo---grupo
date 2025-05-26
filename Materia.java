public abstract class Materia {
    private String questao;
    private String resp;
    private String explicacao;

    abstract String getquestao();

    abstract String getresp();

    abstract String getexplicacao();

    abstract void setexplicacao(String explicacao);

    abstract void setquestao(String questao);

    abstract void setrep(String resp);

    abstract void exibirExplicacao(Materia materias, String resposta);
};
