public class Pilha<T> {
    T[] mem;
    int len = 0;
    final int defcap = 8; // capacidade inicial

    @SuppressWarnings("unchecked")
    public Pilha() {
        mem = (T[]) new Object[defcap];
    }

    public int comprimento() {
        return len;
    }

    public int capacidade() {
        return mem.length;
    }

    public void empilha(T algo) {
        if (len == mem.length) {
            int novaCap = mem.length * 2;
            @SuppressWarnings("unchecked")
            T[] novoMem = (T[]) new Object[novaCap];
            System.arraycopy(mem, 0, novoMem, 0, mem.length);
            mem = novoMem;
        }
        mem[len++] = algo;
        System.out.println(algo + " Foi adicionado com sucesso");
    }

    public T desempilha() {
        if (estaVazia()) {
            System.out.println("Pilha vazia, nada a desempilhar");
            return null;
        }
        T topo = mem[--len];
        mem[len] = null;
        return topo;
    }

    public T topo() {
        if (estaVazia()) {
            System.out.println("Pilha vazia, sem topo");
            return null;
        }
        return mem[len - 1];

    }

    public boolean estaVazia() {
        return len == 0;
    }

    public void limpa() {
        for (int i = 0; i < len; i++) {
            mem[i] = null;
        }
        len = 0;
    }

}
