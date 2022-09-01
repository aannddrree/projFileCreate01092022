import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String path = "d:\\tabuada.txt";

        try {
            leitor(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void gerarTabuada(String path){
        Scanner ler = new Scanner(System.in);
        int i, n;
        System.out.printf("Informe o número para a tabuada:\n");
        n = ler.nextInt();
        FileWriter arq = null;
        try {
            arq = new FileWriter(path);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("+--Resultado--+%n");
            for (i=1; i<=10; i++) {
                gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i*n));
            }
            gravarArq.printf("+-------------+%n");
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("\nTabuada do %d foi gravada com sucesso em \"d:\\tabuada.txt\".\n", n);
    }

    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

}
