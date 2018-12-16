package batalhanaval;

import armas.Arma;
import armas.FabricaArmas;
import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private int id;
    private String nome;
    private int ponto;
    private List<Arma> listaDeArma;
    private int[][] oceano;
    private int linha;
    private int coluna;
    private int qFragata;
    private int qDestroier;
    private int qCorveta;
    private int qCruzador;
    private int qSubmarino;
    private int qEncouracado;
    private int qPortaAvioes;

    public Jogador(int linha, int coluna, int id, String nome) {
        this.nome = nome;
        this.id = id;
        this.ponto = 0;
        oceano = new int[linha][coluna];
        this.linha = linha;
        this.coluna = coluna;
        listaDeArma = new ArrayList<>();
        qFragata = 0;
        qDestroier = 0;
        qCorveta = 0;
        qCruzador = 0;
        qSubmarino = 0;
        qEncouracado = 0;
        qPortaAvioes = 0;
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                oceano[i][j] = 99;
            }
        }
    }

    public boolean inserirArma(int linha, int coluna, char posicao, String tipo) {
        boolean r = false;
        Arma novo = FabricaArmas.getArma(tipo, listaDeArma.size());
        if (posicao == 'h') {
            if (linha < this.linha && (coluna + novo.getNível() - 1) < this.coluna) {
                boolean controle = true;
                for (int j = coluna; j < novo.getNível() + coluna; j++) {
                    if (oceano[linha][j] != 99) {
                        controle = false;
                    }
                }
                if (controle) {
                    for (int j = coluna; j < novo.getNível() + coluna; j++) {
                        oceano[linha][j] = novo.getId();
                    }
                    novo.setPosicao(posicao);
                    novo.setX(linha);
                    novo.setY(coluna);
                    listaDeArma.add(novo);
                    r = true;
                }
            }
        } else if (posicao == 'v') {
            if (coluna < this.coluna && (linha + novo.getNível() - 1) < this.linha) {
                boolean controle = true;
                for (int j = linha; j < novo.getNível() + linha; j++) {
                    if (oceano[j][coluna] != 99) {
                        controle = false;
                    }
                }
                if (controle) {
                    for (int j = linha; j < novo.getNível() + linha; j++) {
                        oceano[j][coluna] = novo.getId();
                    }
                    novo.setPosicao(posicao);
                    novo.setX(linha);
                    novo.setY(coluna);
                    listaDeArma.add(novo);
                    r = true;
                }
            }
        }
        return r;
    }

    public String ataque(int linha, int coluna) {
        String r = null;
        int p = oceano[linha][coluna];
        if (p < 20) {
            this.listaDeArma.get(p).setQuantidadeOK(listaDeArma.get(p).getQuantidadeOK() - 1);
            if (this.listaDeArma.get(p).getQuantidadeOK() > 0) {
                r = "1;" + this.listaDeArma.get(p).getPontoParcial();
                oceano[linha][coluna] = 100 + listaDeArma.get(p).getId();
            } else {
                r = "2;" + this.listaDeArma.get(p).getPontoTotal() + ";" + this.listaDeArma.get(p).getDescricao();
                if(listaDeArma.get(p).getPosicao() == 'h'){
                    int cont = 0;
                    for(int n = listaDeArma.get(p).getY(); n < listaDeArma.get(p).getNível() + linha ; n++){
                        oceano[listaDeArma.get(p).getX()][n] = 200 + listaDeArma.get(p).getId() + cont;
                        cont++;
                    }
                }else{
                    int cont = 0;
                    for(int n = listaDeArma.get(p).getX(); n < listaDeArma.get(p).getNível() + coluna ; n++){
                        oceano[n][listaDeArma.get(p).getY()] = 200 + listaDeArma.get(p).getId() + cont;
                        cont++;
                    }
                }
            }
        } else if (p == 99) {
            oceano[linha][coluna] = 77;
            r = "0";
        }
        return r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPonto() {
        return ponto;
    }

    public void setPonto(int ponto) {
        this.ponto = ponto;
    }

    public List<Arma> getListaDeArma() {
        return listaDeArma;
    }

    public void setListaDeArma(List<Arma> listaDeArma) {
        this.listaDeArma = listaDeArma;
    }

    public int[][] getOceano() {
        return oceano;
    }

    public void setOceano(int[][] oceano) {
        this.oceano = oceano;
    }

    public int getqFragata() {
        return qFragata;
    }

    public void setqFragata(int qFragata) {
        this.qFragata = qFragata;
    }

    public int getqDestroier() {
        return qDestroier;
    }

    public void setqDestroier(int qDestroier) {
        this.qDestroier = qDestroier;
    }

    public int getqCorveta() {
        return qCorveta;
    }

    public void setqCorveta(int qCorveta) {
        this.qCorveta = qCorveta;
    }

    public int getqCruzador() {
        return qCruzador;
    }

    public void setqCruzador(int qCruzador) {
        this.qCruzador = qCruzador;
    }

    public int getqSubmarino() {
        return qSubmarino;
    }

    public void setqSubmarino(int qSubmarino) {
        this.qSubmarino = qSubmarino;
    }

    public int getqEncouracado() {
        return qEncouracado;
    }

    public void setqEncouracado(int qEncouracado) {
        this.qEncouracado = qEncouracado;
    }

    public int getqPortaAvioes() {
        return qPortaAvioes;
    }

    public void setqPortaAvioes(int qPortaAvioes) {
        this.qPortaAvioes = qPortaAvioes;
    }
}
