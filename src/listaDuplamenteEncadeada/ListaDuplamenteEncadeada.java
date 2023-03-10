package listaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public void remove(int index) {
        if (index == 0) {
            primeiroNo = primeiroNo.getNoProximo();
            if (primeiroNo != null) {
                primeiroNo.setNoAnterior(null);
            }
        }
        else {
            NoDuplo<T> noAux =  getNo(index);
            noAux.getNoAnterior().setNoProximo(noAux.getNoProximo());
            if (noAux != ultimoNo) {
                noAux.getNoProximo().setNoAnterior(noAux.getNoAnterior());
            }
            else {
                ultimoNo = noAux;
            }
        }

        this.tamanhoLista--;
    }

    public void add(int index, T elemento) {
        NoDuplo<T> noAux = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAux);

        if (novoNo.getNoProximo() != null) {
            novoNo.setNoAnterior(noAux.getNoAnterior());
            novoNo.getNoProximo().setNoAnterior(novoNo);
        }
        else {
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo =  novoNo;
        }

        if (index == 0) {
            primeiroNo =  novoNo;
        }
        else {
            novoNo.getNoAnterior().setNoProximo(novoNo);
        }

        tamanhoLista++;
    }

    public void add(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoAnterior(ultimoNo);

        if (primeiroNo == null) {
            primeiroNo = novoNo;
        }
        if (ultimoNo != null) {
            ultimoNo.setNoProximo(novoNo);
        }

        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAux = primeiroNo;

        for (int i = 0; (i < index) && (noAux != null); i++){
            noAux = noAux.getNoProximo();
        }

        return noAux;
    }

    public int size() {
        return tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        NoDuplo<T> noAux = primeiroNo;

        for (int i = 0; i < size(); i++) {
            strRetorno += "[No{conteudo=" + noAux.getConteudo() + "}]--->";
            noAux =  noAux.getNoProximo();
        }

        strRetorno += "null";

        return strRetorno;
    }
}
