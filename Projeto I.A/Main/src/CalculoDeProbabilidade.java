
public class CalculoDeProbabilidade {


    public static float calculoProbabilidade(int qntSintomas, int qntPaciente){
        float probabilidade = ((float) qntSintomas / qntPaciente) * 100;

        probabilidade = Math.round(probabilidade * 100) / 100.0f;

        return probabilidade;
    }


}
