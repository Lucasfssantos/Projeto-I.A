import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main (String [] args){
        Boolean controle = true;
        int decisao;


        Scanner z = new Scanner(System.in);
        /**
         * Lista de doenças:
         * Dengue
         * Febre Amarela
         * Covid*/

        ArrayList<String> sintomasPaciente = new ArrayList<>();

        ArrayList<String> sintomasDengue = new ArrayList<>(Arrays.asList("dor nos músculos","dor nos olhos","dor nas costas","dor no abdômen","dor nos ossos",
                "dor nas articulação","febre","falta de apetite","mal estar","tremor","sudorese","dor de cabeça","manchas no corpo","fraqueza","cansaço"));

        ArrayList<String> sintomasCovid = new ArrayList<>(Arrays.asList("febre","calafrio","tosse","dor de garganta","congestão nasal"
                ,"perda de alfato", "perda de paladar","falta de ar","dor de cabeça","diarreia","cansaço","dor muscular","dor no peito"));

        ArrayList<String> sintomasFebreAmarela = new ArrayList<>(Arrays.asList("dor na costa ","abdômen","cabeça","febre","calafrio","fadiga"
                ,"mal estar","perda de apetite","náusea","vômito","Delírio","dor olho","pele amarelado","hemorragia" ));



        do{
            System.out.println("Bem Vindo(a) a central de atendimento");
            System.out.println("Escolha uma das  opções abaixo: \n" +
                    "1- Primeira Consulta \n" +
                    "2- Retorno ao Médico \n" +
                    "3- Resultado de exames \n" +
                    "4- SAC \n" +
                    "5- Sair");

            System.out.println("O que deseja? ");
            decisao = z.nextInt();
            z.nextLine();
            switch(decisao){
                case 1:
                    System.out.println("Bem vindo(a), Vamos fazer sua ficha médica");

                    System.out.print("Seu nome completo: ");
                    String nome = z.nextLine();

                    System.out.print("Gênero Masculino | Feminino: ");
                    String genero = z.next();
                    z.nextLine();

                    System.out.print("Tem algum sintoma?: ");
                    String sintomasDoPaciente = z.nextLine();
                    sintomasPaciente.add(sintomasDoPaciente);

                    Boolean controleSintomas = true;
                    do{
                        System.out.print("Sente mais algum sintoma?: ");
                        sintomasDoPaciente = z.nextLine();

                        if(sintomasDoPaciente.isEmpty() || sintomasDoPaciente.equalsIgnoreCase("não")|| sintomasDoPaciente.equalsIgnoreCase("nao")){
                            controleSintomas = false;
                        }else{
                            sintomasPaciente.add(sintomasDoPaciente);
                        }

                    }while (controleSintomas != false);


                    ArrayList<String> intersecaoDengue = new ArrayList<>(sintomasDengue);
                    intersecaoDengue.retainAll(sintomasPaciente);

                    ArrayList<String> intersecaoCovid = new ArrayList<>(sintomasCovid);
                    intersecaoCovid.retainAll(sintomasPaciente);

                    ArrayList<String> intersecaoFebreAmarela = new ArrayList<>(sintomasFebreAmarela);
                    intersecaoFebreAmarela.retainAll(sintomasPaciente);

                    int qntDengue = intersecaoDengue.size();
                    int qntCovid = intersecaoCovid.size();
                    int qntFebreAmarela= intersecaoFebreAmarela.size();
                    int qntPaciente = sintomasPaciente.size();


                    System.out.println("Os Sintomas do Paciente são: "+ sintomasPaciente);
                    System.out.println("Sintomas de Dengue: " + qntDengue + " "+intersecaoDengue);
                    System.out.println("Sintomas de Covid: " + qntCovid + " "+intersecaoCovid);
                    System.out.println("Sintomas de Febre amarela: " + qntFebreAmarela + " "+intersecaoFebreAmarela);

                    System.out.println("A probabilidade de ser Dengue: ");
                    CalculoDeProbabilidade.calculoProbabilidade(qntDengue,qntPaciente);
                    System.out.println("A probabilidade de ser Covid: ");
                    CalculoDeProbabilidade.calculoProbabilidade(qntCovid,qntPaciente);
                    System.out.println("A probabilidade de ser Febre Amarela: ");
                    CalculoDeProbabilidade.calculoProbabilidade(qntFebreAmarela,qntPaciente);
                    break;
                case 2:
                    System.out.print("Retorno de consulta");
                    break;
                case 3:
                    System.out.print("Exames anteriores");
                    break;
                case 4:
                    System.out.print("Bem vindo(a) ao SAC");
                    break;
                case 5:
                    System.out.print("Encerrando o atendimento, Obrigado pela prefência!");
                    controle = true;
                    break;
                default:
                    System.out.print("Encerrando o atendimento, Obrigado pela prefência!");
                    controle = true;
            }
        }while (controle != true);

    }
}
