public class Artes extends Materia {

    public Artes(String questao, String resp, String explicacao){
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

    // @Override
    // public void exibirExplicacao(int random) {
    //     if (random == 0) {
    //         System.out.println("A unidade de medida da força no Sistema Internacional é o Newton (N).");
    //     } else if (random == 1) {
    //         System.out.println("Isaac Newton foi o responsável por formular a Lei da Gravitação Universal.");
    //     } else if (random == 2) {
    //         System.out.println("A velocidade da luz no vácuo é aproximadamente 299.792.458 m/s.");
    //     }
    // }
}
