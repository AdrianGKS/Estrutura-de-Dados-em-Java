package filas;

public class Fila<T> {

    private No<T> referenciaNoEntrada;

    public Fila() {
        this.referenciaNoEntrada = null;
    }

    public void enqueue(T obj) {
        No novoNo = new No(obj);
        novoNo.setRefNo(referenciaNoEntrada);
        referenciaNoEntrada = novoNo;
    }

    public T first() {
        if (!this.isEmpty()) {
            No primeiroNo = referenciaNoEntrada;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                }
                else {
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public T dequeue() {
        if (!this.isEmpty()) {
            No primeiroNo = referenciaNoEntrada;
            No noAux = referenciaNoEntrada;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    noAux = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }
                else {
                    noAux.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
       if (referenciaNoEntrada == null) {
           return true;
       }
       return false;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No noAux = referenciaNoEntrada;

        if (referenciaNoEntrada != null) {
            while (true) {
                strRetorno += "[No{objeto=" + noAux.getObject() + "}]--->";
                if (noAux.getRefNo() != null) {
                    noAux = noAux.getRefNo();
                }
                else {
                    strRetorno += "null";
                    break;
                }
            }
        }
        else {
            strRetorno = "null";
        }
        return strRetorno;
    }
}
