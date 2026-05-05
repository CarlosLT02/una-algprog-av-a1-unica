import java.util.Scanner;

public class prova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do profissional: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Digite o cargo ocupado (Cientista, Engenheiro, Zelador, Administrativo): ");
        String cargo = scanner.nextLine().trim();

        System.out.print("Digite o nível de acesso (1 a 10): ");
        int nivelAcesso = readIntInRange(scanner, 1, 10);

        System.out.print("Digite o nível de sigilo da área (1 a 10): ");
        int nivelSigilo = readIntInRange(scanner, 1, 10);

        boolean acessoPermitido = nivelAcesso >= nivelSigilo;
        boolean alertaSeguranca = nivelAcesso < 3 && nivelSigilo > 7;

        System.out.println();
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Resultado do acesso: " + (acessoPermitido ? "ACESSO PERMITIDO" : "ACESSO NEGADO"));

        if (alertaSeguranca) {
            System.out.println("ALERTA DE SEGURANÇA: profissional de nível baixo tentando acessar área de sigilo alto.");
        }

        scanner.close();
    }

    private static int readIntInRange(Scanner scanner, int min, int max) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.print("Valor inválido. Digite um número entre " + min + " e " + max + ": ");
                scanner.nextLine();
                continue;
            }

            int value = scanner.nextInt();
            scanner.nextLine();

            if (value < min || value > max) {
                System.out.print("Valor fora do intervalo. Digite um número entre " + min + " e " + max + ": ");
                continue;
            }

            return value;
        }
    }
}

