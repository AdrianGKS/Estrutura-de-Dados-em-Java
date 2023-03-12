package listaEncadeada;

public class ListaEncadeada<T> {

    private No<T> refEntrada;

    public ListaEncadeada() {
        this.refEntrada = null;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);

        if (this.isEmpty()) {
            refEntrada = novoNo;
            return;
        }

        No<T> noAux = refEntrada;

        for (int i = 0; i< this.size()-1; i++) {
            noAux = noAux.getProximoNo();
        }

        noAux.setProximoNo(novoNo);
    }

    public T get(int index) {
        return getNo(index).getConteudo();
    }

    public T remove(int index) {
        No<T> noAlvo = this.getNo(index); //seleciona o No que vai ser removido

        if (index == 0) { // se o indice do No = 0,
            refEntrada =  noAlvo.getProximoNo(); // a referencia vai apontar pro No indice 1
            return noAlvo.getConteudo(); // e o conteudo do No removido vai ser retornado
        }

        No<T> noAnterior = getNo(index - 1); // se o indice do No != 0, o indice anterior do No Removido vai ser pego pela variável
        noAnterior.setProximoNo(noAlvo.getProximoNo()); //e vai ser setado o próximo No com base no No Removido

        return noAlvo.getConteudo(); // por fim o conteúdo do No Removido sendo retornado
    }

    public int size() {
        int tamanhoLista = 0;
        No<T> refAux = refEntrada;

        while (true) {
            if (refAux != null) {
                tamanhoLista++;
                if (refAux.getProximoNo() != null) {
                    refAux = refAux.getProximoNo();
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }
        return tamanhoLista;
    }

    private No<T> getNo(int index) {
        validaIndice(index);

        No<T> noAux = refEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <= index; i++) {
            noRetorno = noAux;
            noAux = noAux.getProximoNo();
        }
        return noRetorno;
    }

    private void validaIndice(int index) {
        if (index >= size()) {
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " desta lista." +
                    "\nEsta listas só vai até o índice " + ultimoIndice + ".");
        }
    }

    public boolean isEmpty() {
        return refEntrada == null ? true : false;
    }

    public String toString() {
        String strRetorno =  "";
        No<T> noAux = refEntrada;

        for (int i = 0; i< this.size(); i++) {
            strRetorno += "[No{conteudo=" + noAux.getConteudo() + "}]--->";
            noAux = noAux.getProximoNo();
        }

        strRetorno += "null";
        return strRetorno;
    }
}
