public class Artes extends Materia {

    private String questao;
    private String resp;

    public Artes(String questao, String resp){
        this.questao=questao;
        this.resp=resp;
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
    public void setquestao(String questao){
        this.questao = questao;
    };

    @Override
    public void setrep(String resp){
        this.resp = resp;
    };
    
    @Override
    public void exibirExplicacao(Materia materias, String resposta, int random){
        if(resposta.equals(materias.getresp())){
            System.out.println("Correto! ");
        }else{
            System.out.println("Errado! ");
        };

        if(random==3){
            System.out.println("Ritmo é um elemento mais associado às artes temporais, como a música, a dança e até mesmo a literatura, mas não é um elemento básico das artes visuais.\n\n");
        }else if(random==4){
            System.out.println("As artes, em suas diversas linguagens, são meios de expressão que vão além das palavras. Por meio de sons, imagens, movimentos ou encenações, os artistas comunicam emoções, reflexões, críticas sociais, experiências pessoais ou coletivas. Essa característica é essencial em todas as linguagens artísticas.encial em todas as linguagens artísticas.\n\n");
        }else if(random==5){
            System.out.println("A apreciação artística é subjetiva e influenciada por fatores como cultura, experiências de vida, conhecimentos prévios e até o momento emocional do observador. Por isso, diferentes pessoas podem interpretar uma mesma obra de maneiras distintas, e todas essas leituras são válidas.\n\n");
        };
    };

};
