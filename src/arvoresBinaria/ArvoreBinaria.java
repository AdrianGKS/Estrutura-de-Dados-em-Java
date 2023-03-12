package arvoresBinaria;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo) {
        BinNo<T> novoNo =  new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir (BinNo<T> atual, BinNo<T> novoNo) {
        if (atual == null) {
            return novoNo;
        }
        else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        }
        else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }

    public void inOrdem() {
        System.out.println("\nExibindo In-Ordem");
        inOrdem(this.raiz);
    }

    private void inOrdem(BinNo<T> atual) {
        if (atual != null) {
            inOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + " ");
            inOrdem(atual.getNoDir());
        }
    }

    public void posOrdem() {
        System.out.println("\nExibindo Pós-Ordem");
        posOrdem(this.raiz);
    }

    private void posOrdem(BinNo<T> atual) {
        if (atual != null) {
            posOrdem(atual.getNoEsq());
            posOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + " ");
        }
    }

    public void preOrdem() {
        System.out.println("\nExibindo Pré-Ordem");
        preOrdem(this.raiz);
    }

    private void preOrdem(BinNo<T> atual) {
        if (atual != null) {
            System.out.print(atual.getConteudo() + " ");
            preOrdem(atual.getNoEsq());
            preOrdem(atual.getNoDir());
        }
    }

    public void remove(T conteudo) {
        try {
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temporario = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)) {
                pai = atual;
                if (conteudo.compareTo(atual.getConteudo()) < 0) {
                    atual = atual.getNoEsq();
                }
                else {
                    atual =  atual.getNoDir();
                }
            }

            if (atual == null) {
                System.out.println("Conteúdo não encontrado. Bloco try.");
            }

            if (pai == null) {
                if (atual.getNoDir() == null) {
                    this.raiz = atual.getNoEsq();
                }
                else if (atual.getNoEsq() == null) {
                    this.raiz = atual.getNoDir();
                }
                else {
                    for (temporario = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temporario = filho, filho = filho.getNoEsq()
                    ) {
                            if (filho != atual.getNoEsq()) {
                                temporario.setNoDir(filho.getNoEsq());
                                filho.setNoEsq(raiz.getNoEsq());
                            }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;
                }
            }
            else if (atual.getNoDir() == null) {
                if (pai.getNoEsq() == atual) {
                    pai.setNoEsq(atual.getNoEsq());
                }
                else {
                    pai.setNoDir(atual.getNoEsq());
                }
            }
            else if (atual.getNoEsq() == null) {
                if (pai.getNoEsq() == atual) {
                    pai.setNoEsq(atual.getNoDir());
                }
                else {
                    pai.setNoDir(atual.getNoDir());
                }
            }
            else {
                for ( temporario = atual, filho = atual.getNoEsq();
                      filho.getNoDir() != null;
                      temporario = filho, filho = filho.getNoDir()
                ) {
                    if (filho != atual.getNoEsq()) {
                        temporario.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }

                    filho.setNoDir(atual.getNoDir());

                    if (pai.getNoEsq() == atual) {
                        pai.setNoEsq(filho);
                    }
                    else {
                        pai.setNoDir(filho);
                    }
                }
            }

        } catch (NullPointerException erro) {
            System.out.println("Conteúdo não encontrado. Bloco catch.");
        }

    }
}
