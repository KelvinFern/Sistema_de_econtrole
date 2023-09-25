public class Item {
    private int codigo;
    private String descricao;
    private double acrescimo;
    private double desconto;
    private double total;

    public int getCodigo() {
        return this.codigo;
    }

    public Item(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.acrescimo = 0;
        this.desconto = 0;
        calcularTotal();
    }

    public void aplicarAcrescimo(double valor) {
        this.acrescimo += valor;
        calcularTotal();
    }

    public void aplicarDesconto(double valor) {
        this.desconto += valor;
        calcularTotal();
    }

    private void calcularTotal() {
        this.total = this.codigo + this.acrescimo - this.desconto;
    }

    public double getAcrescimo() {
        return this.acrescimo;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public double getTotal() {
        return this.total;
    }

    public String toString() {
        return "Código: " + codigo + ", Descrição: " + descricao +
                ", Acréscimo: " + acrescimo + ", Desconto: " + desconto + ", Total: " + total;
    }
}
