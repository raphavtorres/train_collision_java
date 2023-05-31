import java.util.Scanner;

public class Main {
    public static double testInput() {
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double posA, posB, speedA, speedB, resultTime, resultPos, time;

//        Extremidades da ferrovia vão do KM 0 até KM 10.000 - S = 10.000
//        Velocidade trem A +  e trem B-
        System.out.println("Position A (0 - 10.000 km): ");
        posA = scanner.nextDouble();
        System.out.println("Position B (0 - 10.000 km): ");
        posB = scanner.nextDouble();

        System.out.println("Speed A (0 - 300 km): ");
        speedA = scanner.nextDouble();
        System.out.println("Speed B (0 - 300 km): ");
        speedB = scanner.nextDouble();


        // ΔT = ΔS/Vm
        time = (posA - posB) / (speedA - speedB);
        // v = Δs/Δt
        // S = S0 + v . t
        double Sa = posA + speedA * time;

//        ENTRADA DEVE ACEITAR APENAS NÚMEROS - CRIAR FUNÇÃO PARA ISSO
//        PRINT DE RESPOSTA

//
//        Módulo da velocidade do trem será no máximo 300km/h
//        Variáveis de entrada ==> velA velB posA posB
//        posCol ? timeCol ?

//        Requisitos:
//        se posição > 10.000 ou < 0 --> mensagem de erro "Posição inválida"
//        Módulo de vel no máximo 300 km/h
//        Testar velocidades
//        Permitir executar novamente
//        Fazer partida as 17h e mostre o horário no formato == 00:00:00
//        Na situação expecifica q os trens não colidem AVISAR
        System.out.println("The trains collision will happen in the kilometer X, after TIME seconds");
        System.out.println("PROGRAM END");
    }
}