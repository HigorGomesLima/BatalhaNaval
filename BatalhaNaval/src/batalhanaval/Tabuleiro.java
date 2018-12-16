package batalhanaval;

public class Tabuleiro {

    private static Tabuleiro mesa;
    private static int altura;
    private static int largura;

    private static Jogador p1;
    private static Jogador p2;

    private static boolean jogar;

    private Tabuleiro(int h, int l, String nome) {
        jogar = false;
        altura = h;
        largura = l;
        p1 = new Jogador(h, l, 1, nome);
    }

    public static void newGame(int h, int l, String nome) {
        if (h > 9 && l > 9) {
            if (mesa == null) {
                mesa = new Tabuleiro(h, l, nome);
            }
        }
    }

    public static Tabuleiro getGame() {
        if (mesa != null) {
            return mesa;
        } else {
            return null;
        }
    }

    public static boolean inserirArma(String nome, int i, int j, String peca, char posicao) {
        boolean r = false;
        if (nome.equals(p1.getNome())) {
            r = p1.inserirArma(i, j, posicao, peca);
        }
        return r;
    }

    public static String atacar(String nome, int i, int j) {
        String r = null;
        if (nome.equals(p1.getNome())) {
            r = p2.ataque(i, j);
            String[] aux = r.split(";");
            if ("1".equals(aux[0]) || "2".equals(aux[0])) {
                p1.setPonto(p1.getPonto() + (Integer.parseInt(aux[1])));
            }
        } else {
            r = p1.ataque(i, j);
            String[] aux = r.split(";");
            if ("1".equals(aux[0]) || "2".equals(aux[0])) {
                p2.setPonto(p2.getPonto() + (Integer.parseInt(aux[1])));
            }
        }
        return r;
    }

    public static int getAltura() {
        return altura;
    }

    public static void setAltura(int aAltura) {
        altura = aAltura;
    }

    public static int getLargura() {
        return largura;
    }

    public static void setLargura(int aLargura) {
        largura = aLargura;
    }

    private static Jogador getJogador(String nome) {
        Jogador r = null;
        if(nome.equals(p1.getNome()))
            r = p1;
        else if(nome.equals(p2.getNome()))
            r = p2;
        return r;
    }

    public static boolean isJogar() {
        return jogar;
    }

    public static void setJogar(boolean aJogar) {
        jogar = aJogar;
    }

}
