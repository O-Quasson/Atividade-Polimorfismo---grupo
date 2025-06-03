public class Fisica extends Materia {

    private String questao;
    private String resp;

    public Fisica(String questao, String resp){
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
        
        if(random==6){
            System.out.println("Considerando que a formula do sorvetao seja S = S0 + v0.t + a.t^2/2 entao:\n S = 10 + 20.20 + 5.20.20/2\n S = 10 + 400 + 2000/2\n S = 10 + 400 + 1000\n S = 1410m\n\n");
        }else if(random==7){
            System.out.println("A crianca respondeu que ela estava maior pois devido a sua localizacao (entre vertice e foco) a reflexao projetada é direita, maior e virtual.\n\n");
        }else if(random==8){
            System.out.println("As polias moveis dividem o peso em dois, o calculo então se resume a (20/2)/2\nR = 10/2\nR = 5kg\n\n");
        };
    };
};
