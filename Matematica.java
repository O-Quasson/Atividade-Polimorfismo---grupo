public class Matematica extends Materia{

    private String questao;
    private String resp;

    public Matematica(String questao, String resp){
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
            System.out.println("\nCorreto! ");
        }else{
            System.out.println("\nErrado! ");
        };

        if(random==0){
            System.out.println("A fórmula do termo geral de uma PA é:\n\nan = a1 + (n-1)r\n\nan é o termo geral\nn é a posição ocupada pelo termo em questão\nr é a razão da PA\na1 é o primeiro termo da progressão\n\nSubstituindo os valores dados no exercício na fórmula acima, teremos:\n\n-13 = 23 + (n-1)·(-6)\n\nA partir dessa equação simples, podemos chegar a conclusão de que O número -13 ocupa a 7ª posição.\n\n");
        }else if(random==1){
            System.out.println("Como o exercício indica que não ocorrerá repetição nos algarismos que irão compor a senha, então teremos a seguinte situação:\n\n9 opções para o algarismo das unidades;\n8 opções para o algarismo das dezenas, visto que já utilizamos 1 algarismo na unidade e não pode repetir;\n7 opções para o algarismo das centenas, pois já utilizamos 1 algarismo na unidade e outro na dezena;\n6 opções para o algarismo do milhar, pois temos que tirar os que já usamos anteriormente.\n\nAssim, o número de senhas será dado por:\n\n9.8.7.6 = 3 024 senhas\n\n");
        }else if(random==2){
            System.out.println("Sabemos que o total de alunos é igual a 100, e que dos 80 que gostam de chocolate, 60 gostam também de creme, então 80 - 60 = 20 que gostam somente de chocolate. Com esse mesmo raciocínio 70 - 60 = 10, então 10 gostam somente de creme. Sendo assim, vamos somar o total de alunos que gostam somente de chocolate, somente de creme e de ambos:\n\n20 + 60 + 10 = 90\n\nComo 100 alunos foram consultados, então 100-90 = 10.\n10 não gostam de nenhum dos dois.\n\n");
        };
    };
};
