package armas;

public class Destroier extends Arma {

    public Destroier(int id) {
        this.id = id;
        this.nível = 3;
        this.descricao = "destroier";
        this.pontoParcial = 10;
        this.pontoTotal = 30;
        this.quantidadeOK = 3;
    }
}
