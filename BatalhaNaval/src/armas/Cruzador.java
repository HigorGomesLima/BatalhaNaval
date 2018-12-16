package armas;

public class Cruzador extends Arma {

    public Cruzador(int id) {
        this.id = id;
        this.nível = 3;
        this.descricao = "cruzador";
        this.pontoParcial = 10;
        this.pontoTotal = 30;
        this.quantidadeOK = 3;
    }
}
