package app.repository;

public class Caixa<T> {

    private T item;

    public void guardar(T item) {
        this.item = item;
    }

    public T abrir() {
        return item;
    }
}
