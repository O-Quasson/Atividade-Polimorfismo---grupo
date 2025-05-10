public class Matematica extends Materia{

    public Matematica(String questao, String resp, String explicacao){
        super(questao, resp, explicacao);
    };

    @Override
    public void exibirExplicacao(Materia materias, String resposta){
        if(resposta.equals(materias.getresp())){
            System.out.println("Correto! ");
        }else{
            System.out.println("Errado! ");
        };
        System.out.println(materias.getexplicacao());
        // if(random==0){
        //     System.out.println("Explicacao");
        // }else if(random==1){
        //     System.out.println("Explicacao 2");
        // }else if(random==2){
        //     System.out.println("Explicacao 3");
        // }
    };
}
