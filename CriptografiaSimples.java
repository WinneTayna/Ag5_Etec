import javax.swing.JOptionPane;

public class CriptografiaSimples {
    public static void main(String[] args) {
        // Entrada de dados: solicita ao usuário uma mensagem para criptografar
        String mensagem = JOptionPane.showInputDialog("Digite a mensagem para criptografar:");
        // Processa a mensagem fornecida
        processarMensagem(mensagem);
    }

    public static void processarMensagem(String mensagem) {
        // Verificação de mensagem nula ou vazia
        if (mensagem == null || mensagem.isEmpty()) {
            exibirMensagem("Erro", "Mensagem vazia ou nula!");
            return;
        }

        // Saída de dados: Exibe a mensagem original
        exibirMensagem("Mensagem do tipo String fornecida", mensagem);

        // Saída de dados: Exibe o tamanho da mensagem (quantidade de caracteres)
        int tamanhoMensagem = mensagem.length();
        exibirMensagem("Tamanho da mensagem (número de caracteres)", String.valueOf(tamanhoMensagem));

        // Converte a string para um vetor de caracteres
        char[] caracteres = mensagem.toCharArray();

        // Saída de dados: Exibe a separação de caracteres
        StringBuilder caracteresSeparados = new StringBuilder();
        for (char c : caracteres) {
            caracteresSeparados.append(c).append(" ");
        }
        exibirMensagem("Conversão da String de entrada em um vetor de caracteres", caracteresSeparados.toString().trim());

        // Inicializa os StringBuilders para armazenar resultados
        StringBuilder valoresASCII = new StringBuilder();
        StringBuilder valoresCriptografados = new StringBuilder();
        StringBuilder mensagemCriptografada = new StringBuilder();

        // Processa cada caractere
        for (char caractere : caracteres) {
            int codigoASCII = caractere;
            int codigoCriptografado = (caractere + 10) % 256; // Garante que não estoure o limite ASCII

            // Armazena os valores em seus respectivos StringBuilders
            valoresASCII.append(String.format("%d ", codigoASCII));
            valoresCriptografados.append(String.format("%d ", codigoCriptografado));
            mensagemCriptografada.append((char) codigoCriptografado);
        }

        // Saída de dados: Exibe os resultados da conversão
        exibirMensagem("Conversão dos caracteres para decimal (ASCII)", valoresASCII.toString().trim());
        exibirMensagem("Valores criptografados (soma 10 unidades)", valoresCriptografados.toString().trim());
        exibirMensagem("Mensagem/String criptografada", mensagemCriptografada.toString());
    }

    private static void exibirMensagem(String titulo, String mensagem) {
        // Exibe a mensagem final em uma janela de diálogo
        JOptionPane.showMessageDialog(null, titulo + ":\n" + mensagem);
    }
}