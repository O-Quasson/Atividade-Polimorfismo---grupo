public class Matematica extends Materia{

    private String questao;
    private String resp;
    private String explicacao;

    public Matematica(String questao, String resp, String explicacao){
        this.questao=questao;
        this.resp=resp;
        this.explicacao=explicacao;
    };

    @Override
    public String getquestao(){
        return questao;
    };

    @Override
    public String getresp(){
        return resp;
    };

    @Override
    public String getexplicacao(){
        return explicacao;
    };

    @Override
    public void setexplicacao(String explicacao){
        this.explicacao=explicacao;
    };

    @Override
    public void setquestao(String questao){
        this.questao = questao;
    };

    @Override
    public void setrep(String resp){
        this.resp = resp;
    };

    @Override
    public void exibirExplicacao(Materia materias, String resposta){
        if(resposta.equals(materias.getresp())){
            System.out.println("\nCorreto! ");
        }else{
            System.out.println("\nErrado! ");
        };
        System.out.println(materias.getexplicacao());
    };
};
