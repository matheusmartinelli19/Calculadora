import javax.swing.*;

public class Calculadora {
    public static void main(String[] args) {
        double numero1, numero2;
        int opcao;
        boolean condicao = true;

        while (condicao) {
            try {
                // Menu principal da calculadora
                opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                        CALCULADORA - ESCOLHA UMA OPÇÃO:
                        1- SOMAR
                        2- SUBTRAIR
                        3- MULTIPLICAR
                        4- DIVIDIR
                        5- RESTO DA DIVISÃO
                        6- POTÊNCIA
                        7- RAIZ QUADRADA
                        8- SAIR"""));

                switch (opcao) {
                    case 1: // Soma
                        numero1 = getNumero("Digite o primeiro número:");
                        numero2 = getNumero("Digite o segundo número:");
                        JOptionPane.showMessageDialog(null, "Resultado: " +
                                formatarResultado(numero1 + numero2));
                        break;

                    case 2: // Subtração
                        numero1 = getNumero("Digite o primeiro número:");
                        numero2 = getNumero("Digite o segundo número:");
                        JOptionPane.showMessageDialog(null, "Resultado: " +
                                formatarResultado(numero1 - numero2));
                        break;

                    case 3: // Multiplicação
                        numero1 = getNumero("Digite o primeiro número:");
                        numero2 = getNumero("Digite o segundo número:");
                        JOptionPane.showMessageDialog(null, "Resultado: " +
                                formatarResultado(numero1 * numero2));
                        break;

                    case 4: // Divisão
                        numero1 = getNumero("Digite o primeiro número:");
                        numero2 = getNumero("Digite o segundo número:");
                        if (numero2 == 0) {
                            JOptionPane.showMessageDialog(null, "Erro: Divisão por zero!");
                            continue;
                        }
                        JOptionPane.showMessageDialog(null, "Resultado: " +
                                formatarResultado(numero1 / numero2));
                        break;

                    case 5: // Resto da divisão
                        numero1 = getNumero("Digite o primeiro número:");
                        numero2 = getNumero("Digite o segundo número:");
                        if (numero2 == 0) {
                            JOptionPane.showMessageDialog(null, "Erro: Divisão por zero!");
                            continue;
                        }
                        JOptionPane.showMessageDialog(null, "Resultado: " +
                                formatarResultado(numero1 % numero2));
                        break;

                    case 6: // Potência
                        numero1 = getNumero("Digite a base:");
                        numero2 = getNumero("Digite o expoente:");
                        JOptionPane.showMessageDialog(null, "Resultado: " +
                                formatarResultado(Math.pow(numero1, numero2)));
                        break;

                    case 7: // Raiz quadrada
                        numero1 = getNumero("Digite o número:");
                        if (numero1 < 0) {
                            JOptionPane.showMessageDialog(null, "Erro: Número negativo!");
                            continue;
                        }
                        JOptionPane.showMessageDialog(null, "Resultado: " +
                                formatarResultado(Math.sqrt(numero1)));
                        break;

                    case 8: // Sair
                        condicao = false;
                        JOptionPane.showMessageDialog(null, "Calculadora encerrada. Até logo!");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Escolha de 1 a 8.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite apenas números.");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Operação cancelada. Voltando ao menu...");
            }
        }
    }

    // Metodo para obter números com tratamento de erros
    private static double getNumero(String mensagem) throws NullPointerException {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensagem);
                if (input == null) {
                    throw new NullPointerException();
                }
                input = input.replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número válido.");
            }
        }
    }

    // Metodo para formatar o resultado (remove .0 quando é inteiro)
    private static String formatarResultado(double valor) {
        if (valor == (long) valor) {
            return String.format("%d", (long) valor);
        }
        return String.format("%.4f", valor).replaceAll("0*$", "").replaceAll("\\.$", "");
    }
}