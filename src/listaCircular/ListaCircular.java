package listaCircular;

public class ListaCircular<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanhoLista;

    public ListaCircular() {
        this.inicio = null;
        this.fim = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo) {
        No<T> novoNo =  new No<>(conteudo);

        if (this.tamanhoLista == 0) {
            this.fim = novoNo;
            this.inicio =  this.fim;
            this.fim.setProximoNo(this.inicio);
        }
        else {
            novoNo.setProximoNo(this.inicio);
            this.fim.setProximoNo(novoNo);
            this.inicio =  novoNo;
        }
        this.tamanhoLista++;
    }

    public void remove(int index) {
        if (index >= this.tamanhoLista) {
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista!");
        }
        else {
            No<T> noAux = this.inicio;
            if (index == 0) {
                this.inicio = this.inicio.getProximoNo();
                this.fim.setProximoNo(this.inicio);
            }
            else if (index == 1) {
                this.inicio.setProximoNo(this.inicio.getProximoNo().getProximoNo());
            }
            else {
                for (int i = 0; i < index-1; i++){
                    noAux = noAux.getProximoNo();
                }
                noAux.setProximoNo(noAux.getProximoNo().getProximoNo());
            }
        }
        this.tamanhoLista--;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("A lista está vazia!");
        }
        else if(index == 0) {
            return this.inicio;
        }
        else {
            No<T> noAux = this.inicio;
            for (int i = 0; (i  < index) && (noAux != null); i++) {
                noAux = noAux.getProximoNo();
            }
            return noAux;
        }
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0 ? true : false;
    }

    public int size() {
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAux = this.inicio;

        for (int i = 0; i < this.size(); i++) {
            strRetorno += "[No{conteudo=" + noAux.getConteudo() + "}]--->";
            noAux = noAux.getProximoNo();
        }

        if (this.isEmpty()){
            strRetorno += "[]";
        }
        else {
            strRetorno += "(Retorna ao início)";
        }
        //strRetorno += this.size() != 0 ?  "(Retorna ao início)" : "[]";

        return strRetorno;
    }
}
