import javax.swing.*;
import java.util.ArrayList;

public class GerenciadorDeTarefas {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        boolean executando = true;

        while (executando) {
            String opcao = JOptionPane.showInputDialog(
                    "Selecione uma opção:\n" +
                            "1. Adicionar tarefa\n" +
                            "2. Marcar tarefa como concluída\n" +
                            "3. Remover tarefa\n" +
                            "4. Exibir todas as tarefas\n" +
                            "5. Sair"
            );

            switch (opcao) {
                case "1":
                    String novaTarefa = JOptionPane.showInputDialog("Digite a nova tarefa:");
                    if (novaTarefa != null && !novaTarefa.isEmpty()) {
                        tarefas.add(novaTarefa);
                        JOptionPane.showMessageDialog(null, "Tarefa adicionada!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Tarefa inválida.");
                    }
                    break;

                case "2":
                    if (tarefas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma tarefa disponível.");
                    } else {
                        String lista = listarTarefas(tarefas);
                        String indice = JOptionPane.showInputDialog("Tarefas:\n" + lista + "\nDigite o número da tarefa a marcar como concluída:");
                        try {
                            int pos = Integer.parseInt(indice) - 1;
                            String tarefa = tarefas.get(pos);
                            tarefas.set(pos, tarefa + " (Concluída)");
                            JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída!");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Opção inválida.");
                        }
                    }
                    break;

                case "3":
                    if (tarefas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma tarefa disponível.");
                    } else {
                        String lista = listarTarefas(tarefas);
                        String indice = JOptionPane.showInputDialog("Tarefas:\n" + lista + "\nDigite o número da tarefa a remover:");
                        try {
                            int pos = Integer.parseInt(indice) - 1;
                            tarefas.remove(pos);
                            JOptionPane.showMessageDialog(null, "Tarefa removida!");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Opção inválida.");
                        }
                    }
                    break;

                case "4":
                    if (tarefas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma tarefa cadastrada.");
                    } else {
                        String lista = listarTarefas(tarefas);
                        JOptionPane.showMessageDialog(null, "Tarefas:\n" + lista);
                    }
                    break;

                case "5":
                    executando = false;
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    private static String listarTarefas(ArrayList<String> tarefas) {
        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < tarefas.size(); i++) {
            lista.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
        }
        return lista.toString();
    }
}
