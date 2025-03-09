public class ResultadoDiagnostico {

    public static void exibirResultado(int qntDengue, int qntCovid, int qntFebreAmarela, int qntPaciente) {
        System.out.println("\nRESULTADO DO DIAGNÓSTICO");

        float probDengue = CalculoDeProbabilidade.calculoProbabilidade(qntDengue, qntPaciente);
        float probCovid = CalculoDeProbabilidade.calculoProbabilidade(qntCovid, qntPaciente);
        float probFebreAmarela = CalculoDeProbabilidade.calculoProbabilidade(qntFebreAmarela, qntPaciente);

        System.out.println("Probabilidade de Dengue: " + probDengue + "%");
        System.out.println("Probabilidade de Covid: " + probCovid + "%");
        System.out.println("Probabilidade de Febre Amarela: " + probFebreAmarela + "%");

        if (probDengue > probCovid && probDengue > probFebreAmarela) {
            System.out.println("O diagnóstico mais provável é: Dengue");
        } else if (probCovid > probDengue && probCovid > probFebreAmarela) {
            System.out.println("O diagnóstico mais provável é: Covid");
        } else if (probFebreAmarela > probDengue && probFebreAmarela > probCovid) {
            System.out.println("O diagnóstico mais provável é: Febre Amarela");
        } else {
            System.out.println("Os sintomas são muito variados, a melhor coisa a ser feita é consultar um médico.");
        }
    }
}