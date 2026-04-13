package app.service;

import app.model.Pedido;
import app.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PedidoService {

    private List<Pedido> pedidos = new ArrayList<>();
    private Map<Integer, Pedido> pedidosPorId = new HashMap<>();

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedidosPorId.put(pedido.id(), pedido);
    }

    public void listarPedidos() {
        pedidos.forEach(System.out::println);
    }

    public void buscarPorId(int id) {
        Pedido pedido = pedidosPorId.get(id);
        System.out.println(pedido);
    }

    public void listarPedidosCaros(double valor) {
        pedidos.stream()
                .filter(p -> p.total() > valor)
                .forEach(System.out::println);
    }

    public void listarProdutosVendidos() {
        List<Produto> produtos = pedidos.stream()
                .flatMap(p -> p.produtos().stream())
                .collect(Collectors.toList());

        produtos.forEach(System.out::println);
    }

    public void totalGeral() {
        double total = pedidos.stream()
                .mapToDouble(Pedido::total)
                .sum();

        System.out.println("Total geral: " + total);
    }
}
