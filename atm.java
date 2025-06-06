import java.util.Scanner;

public class atm {
    private double saldo;

    public atm(double saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    public void mostraSaldo() {
        System.out.println("Saldo attuale: " + saldo + " EUR");
    }

    public void deposita(double importo) {
        if (importo > 0) {
            saldo += importo;
            System.out.println("Hai depositato: " + importo + " EUR");
        } else {
            System.out.println("Importo non valido.");
        }
    }

    public void preleva(double importo) {
        if (importo > 0 && importo <= saldo) {
            saldo -= importo;
            System.out.println("Hai prelevato: " + importo + " EUR");
        } else {
            System.out.println("Fondi insufficienti o importo non valido.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        atm atm = new atm(1000); // Saldo iniziale

        while (true) {
            System.out.println("\n1. Mostra saldo");
            System.out.println("2. Deposita");
            System.out.println("3. Preleva");
            System.out.println("4. Esci");
            System.out.print("Scegli un'operazione: ");
            int scelta = scanner.nextInt();

            if (scelta == 4) {
                System.out.println("Grazie per aver usato l'ATM!");
                break;
            }

            switch (scelta) {
                case 1:
                    atm.mostraSaldo();
                    break;
                case 2:
                    System.out.print("Inserisci l'importo da depositare: ");
                    double deposito = scanner.nextDouble();
                    atm.deposita(deposito);
                    break;
                case 3:
                    System.out.print("Inserisci l'importo da prelevare: ");
                    double prelievo = scanner.nextDouble();
                    atm.preleva(prelievo);
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
        scanner.close();
    }
}
