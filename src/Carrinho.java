import java.util.ArrayList;
import java.util.Scanner;

public class Carrinho {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> carrinho = new ArrayList<>();

        while (true) {
            exibirMenu();
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                inserirItem(scanner, carrinho);
            } else if (escolha == 2) {
                acrescentarItem(scanner, carrinho);
            } else if (escolha == 3) {
                aplicarDescontoItem(scanner, carrinho);
            } else if (escolha == 4) {
                aplicarAcrescimoTotal(scanner, carrinho);
            } else if (escolha == 5) {
                aplicarDescontoTotal(scanner, carrinho);
            } else if (escolha == 6) {
                finalizarVenda(carrinho);
                return;
            } else {
                System.out.println("Erro, Tente novamente");
            }
        }
    }
    private static void exibirMenu() {
        System.out.println("Escolha as opçoes de uma das opções :\n");
        System.out.println("1-Inserir item ao carrinho");
        System.out.println("2-Acréscimo de item");
        System.out.println("3-Desconto de item");
        System.out.println("4-Acréscimo total");
        System.out.println("5-Desconto total");
        System.out.println("6-Finalizar venda");
        System.out.print(": ");
    }
    private static void inserirItem(Scanner scanner, ArrayList<Item> carrinho) {
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Item novoItem = new Item(codigo, descricao);
        carrinho.add(novoItem);
        System.out.println("Item atulizado com sucesso!");
    }
    private static void acrescentarItem(Scanner scanner, ArrayList<Item> carrinho) {
        System.out.print("Código do produto: ");
        int codigoProduto = scanner.nextInt();
        System.out.print("Valor do acréscimo: ");
        double acrescimo = scanner.nextDouble();

        Item itemEncontrado = procurarItem(carrinho, codigoProduto);

        if (itemEncontrado != null) {
            itemEncontrado.aplicarAcrescimo(acrescimo);
            System.out.println("Acréscimo aplicado");
        } else {
            System.out.println("Produto não foi encotrado");
        }
    }
    private static void aplicarDescontoItem(Scanner scanner, ArrayList<Item> carrinho) {
        System.out.print("Código do produto: ");
        int codigoProduto = scanner.nextInt();
        System.out.print("Valor do desconto: ");
        double desconto = scanner.nextDouble();

        Item itemEncontrado = procurarItem(carrinho, codigoProduto);

        if (itemEncontrado != null) {
            itemEncontrado.aplicarDesconto(desconto);
            System.out.println("Desconto aplicado");
        } else {
            System.out.println("Produto não encontrado");
        }
    }
    private static void aplicarAcrescimoTotal(Scanner scanner, ArrayList<Item> carrinho) {
        System.out.print("Informe o valor do acréscimo total: ");
        double valorAcrescimo = scanner.nextDouble();

        double total = calcularTotal(carrinho);
        if (valorAcrescimo > total) {
            int numItens = carrinho.size();
            double acrescimoPorItem = valorAcrescimo / numItens;
            for (Item item : carrinho) {
                item.aplicarAcrescimo(acrescimoPorItem);
            }

            System.out.println("Acréscimo distribuído com sucesso");
        } else {
            System.out.println("O valor do acréscimo deve ser maior que o total");
        }
    }
    private static void aplicarDescontoTotal(Scanner scanner, ArrayList<Item> carrinho) {
        System.out.print("Digite o valor do desconto total: ");
        double valorDesconto = scanner.nextDouble();

        double total = calcularTotal(carrinho);
        if (valorDesconto < total) {
            int numItens = carrinho.size();
            double descontoPorItem = valorDesconto / numItens;
            for (Item item : carrinho) {
                item.aplicarDesconto(descontoPorItem);
            }

            System.out.println("Desconto distribuído com sucesso");
        } else {
            System.out.println("O valor do desconto deve ser menor que o total");
        }
    }
    private static void finalizarVenda(ArrayList<Item> carrinho) {
        System.out.println("Itens no carrinho: ");
        for (Item item : carrinho) {
            System.out.println(item);
        }

        double descontoTotal = calcularDescontoTotal(carrinho);
        System.out.println("Desconto total: " + descontoTotal);

        double acrescimoTotal = calcularAcrescimoTotal(carrinho);
        System.out.println("Acréscimo total: " + acrescimoTotal);

        double valorTotal = calcularTotal(carrinho);
        System.out.println("Valor total: " + valorTotal);
    }
    private static Item procurarItem(ArrayList<Item> carrinho, int codigo) {
        for (Item item : carrinho) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }
    private static double calcularTotal(ArrayList<Item> carrinho) {
        double total = 0;
        for (Item item : carrinho) {
            total += item.getTotal();
        }
        return total;
    }
    private static double calcularDescontoTotal(ArrayList<Item> carrinho) {
        double descontoTotal = 0;
        for (Item item : carrinho) {
            descontoTotal += item.getDesconto();
        }
        return descontoTotal;
    }
    private static double calcularAcrescimoTotal(ArrayList<Item> carrinho) {
        double acrescimoTotal = 0;
        for (Item item : carrinho) {
            acrescimoTotal += item.getAcrescimo();
        }
        return acrescimoTotal;
    }
}