public class ArattaiGrowthTracker {
    public static void main(String[] args) {
        int[] downloadsDiarios = {850000, 1050000, 1100000, 950000, 1200000, 1000000, 850000};
        String[] diasDaSemana = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"};

        System.out.println("=== Análise de Crescimento do Arattai (7 dias) ===\n");

        int totalDownloads = 0;
        for (int downloads : downloadsDiarios) {
            totalDownloads += downloads;
        }
        System.out.println("[R2] Total de Downloads na Semana: " + String.format("%,d", totalDownloads));

        int pico = downloadsDiarios[0];
        int minimo = downloadsDiarios[0];
        String diaPico = diasDaSemana[0];
        String diaMinimo = diasDaSemana[0];

        for (int i = 1; i < downloadsDiarios.length; i++) {
            if (downloadsDiarios[i] > pico) {
                pico = downloadsDiarios[i];
                diaPico = diasDaSemana[i];
            }
            if (downloadsDiarios[i] < minimo) {
                minimo = downloadsDiarios[i];
                diaMinimo = diasDaSemana[i];
            }
        }

        System.out.println("\n[R3] Análise de Extremos:");
        System.out.println("Dia de Pico de Downloads: " + diaPico + " com " + String.format("%,d", pico) + " downloads.");
        System.out.println("Dia de Mínimo de Downloads: " + diaMinimo + " com " + String.format("%,d", minimo) + " downloads.");

        int metaDiaria = 1000000;
        int diasAcimaDaMeta = 0;

        System.out.println("\n[R4] Análise de Metas (Meta Diária: " + metaDiaria + "):");

        for (int i = 0; i < downloadsDiarios.length; i++) {
            if (downloadsDiarios[i] > metaDiaria) {
                System.out.println("  > " + diasDaSemana[i] + ": SUCESSO! (" + String.format("%,d", downloadsDiarios[i]) + " downloads)");
                diasAcimaDaMeta++;
            } else if (downloadsDiarios[i] == metaDiaria) {
                System.out.println("  > " + diasDaSemana[i] + ": Não atingiu. (" + String.format("%,d", downloadsDiarios[i]) + " downloads)");
            } else {
                System.out.println("  > " + diasDaSemana[i] + ": Não atingiu. (" + String.format("%,d", downloadsDiarios[i]) + " downloads)");
            }
        }

        System.out.println("\n[Relatório Final] O Arattai superou a meta diária em " + diasAcimaDaMeta + " dias esta semana.");
    }
}
