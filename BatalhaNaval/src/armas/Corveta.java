package armas;

public class Corveta extends Arma {

    public Corveta(int id) {
        this.id = id;
        this.nível = 2;
        this.descricao = "corveta";
        this.pontoParcial = 5;
        this.pontoTotal = 20;
        this.quantidadeOK = 2;
    }
}
