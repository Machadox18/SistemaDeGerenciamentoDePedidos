package app.model;

import java.util.List;

public record Pedido(int id, List<Produto> produtos) {

    public double total() {
        return produtos.stream()
                .mapToDouble(Produto::preco)
                .sum();
    }
}
