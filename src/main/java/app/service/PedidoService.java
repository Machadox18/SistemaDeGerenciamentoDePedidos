package app.service;

import app.model.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoService {

    private List<Pedido> pedidos = new ArrayList<>();
    private Map<Integer, Pedido> pedidosPorId = new HashMap<>();

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedidosPorId.put(pedido.id(), pedido);
    }
}
