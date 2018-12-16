package armas;

public class Arma {
    
    protected String descricao;
    protected int nível;
    protected int pontoParcial;
    protected int pontoTotal;
    
    protected int quantidadeOK;
    protected int id;
    
    protected char posicao;
    protected int x;
    protected int y;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNível() {
        return nível;
    }

    public void setNível(int nível) {
        this.nível = nível;
    }

    public int getPontoParcial() {
        return pontoParcial;
    }

    public void setPontoParcial(int pontoParcial) {
        this.pontoParcial = pontoParcial;
    }

    public int getPontoTotal() {
        return pontoTotal;
    }

    public void setPontoTotal(int pontoTotal) {
        this.pontoTotal = pontoTotal;
    }

    public int getQuantidadeOK() {
        return quantidadeOK;
    }

    public void setQuantidadeOK(int quantidadeOK) {
        this.quantidadeOK = quantidadeOK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getPosicao() {
        return posicao;
    }

    public void setPosicao(char posicao) {
        this.posicao = posicao;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
