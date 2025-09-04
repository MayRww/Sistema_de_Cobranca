import factory.*;
import pagamento.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PagamentoService service = new PagamentoService();

        System.out.println("Escolha o método de pagamento: ");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - PayPal");
        System.out.println("3 - Criptomoeda");
        System.out.println("4 - ApplePay");
        int escolha = scanner.nextInt();
        scanner.nextLine(); 

        PagamentoFactory factory = null;
        double valor;
        String input;

        switch (escolha) {
            case 1:
                System.out.print("Digite o número do cartão (16 dígitos): ");
                input = scanner.nextLine();
                factory = new FactoryCartaoCredito(input);
                break;

            case 2:
                System.out.print("Digite seu email PayPal (ex: user@paypal.com): ");
                input = scanner.nextLine();
                factory = new FactoryPayPal(input);
                break;

            case 3:
                System.out.println("Escolha a criptomoeda: BTC, ETH, USDT, DOGE, SHIBA");
                String moedaStr = scanner.nextLine().toUpperCase();

                System.out.print("Digite seu saldo na carteira: ");
                double saldo = scanner.nextDouble();

                PagamentoCriptomoeda.Moeda moeda;
                try {
                    moeda = PagamentoCriptomoeda.Moeda.valueOf(moedaStr);
                } catch (IllegalArgumentException e) {
                    System.out.println("Moeda inválida.");
                    scanner.close();
                    return;
                }
                factory = new FactoryCriptomoeda(moeda, saldo);
                break;

            case 4:
                
               System.out.println("Dispositivo Apple Pay autorizado? (true/false)");
                boolean autenticado = scanner.nextBoolean();
                 factory = new FactoryApplePay(autenticado);
                break;


            default:
                System.out.println("Opção inválida.");
                scanner.close();
                return;
        }

        System.out.print("Digite o valor da transação: ");
        valor = scanner.nextDouble();

        String resultado = service.processarPagamento(factory, valor);
        System.out.println(resultado);

        scanner.close();
    }
}
