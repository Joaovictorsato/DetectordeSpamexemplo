package Programa;

public class SpamDetector {
    // Matriz de termos suspeitos com seus respectivos pesos
    private static final String[][] SPAM_TERMS = {
        {"oferta", "5"},
        {"grátis", "10"},
        {"dinheiro", "7"},
        {"clique aqui", "8"},
        {"promoção", "6"},
        {"ganhe", "9"},
        {"urgente", "7"},
        {"desconto", "4"},
        {"transação", "6"},
        {"cartão de crédito", "10"}
    };

    public static void main(String[] args) {
        LeitorArquivo leitor = new LeitorArquivo();
        String caminhoArquivo = "C:\\Users\\Japsps\\Desktop\\Spam\\ArquivoSpam.txt"; // Especifique o caminho do arquivo aqui
        String texto = leitor.lerArquivo(caminhoArquivo);
        
        int spamScore = calculateSpamScore(texto);
        String classification = classifyText(spamScore); 
        System.out.println("Pontuação de Spam: " + spamScore);
        System.out.println("Classificação: " + classification);
    }

    public static int calculateSpamScore(String text) {
        int score = 0;
        for (String[] term : SPAM_TERMS) {
            String word = term[0];
            int weight = Integer.parseInt(term[1]);
            if (text.contains(word)) {
                score += weight;
            }
        }
        return score;
    }

    public static String classifyText(int score) {
        if (score >= 5 && score <= 30) {
            return "Francamente Suspeito";
        } else if (score >= 31 && score <= 70) {
            return "Potencialmente Suspeito";
        } else if (score > 70) {
            return "Spam";
        } else {
            return "Não Suspeito";
    }
 }
}
