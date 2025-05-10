public abstract class Materia {
    private String questao;
    private String resp;
    private String explicacao;

    public Materia(String questao, String resp, String explicacao){
        this.questao=questao;
        this.resp=resp;
        this.explicacao=explicacao;
    };

    public String getquestao(){
        return questao;
    };

    public String getresp(){
        return resp;
    };

    public String getexplicacao(){
        return explicacao;
    };

    public void setexplicacao(String explicacao){
        this.explicacao=explicacao;
    };

    public void setquestao(String questao){
        this.questao = questao;
    };

    public void setrep(String resp){
        this.resp = resp;
    };

    abstract void exibirExplicacao(Materia materias, String resposta);
}
