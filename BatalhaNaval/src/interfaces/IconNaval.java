package interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class IconNaval {
    
    private ImageIcon agua;
    private ImageIcon bomba;
    private List<ImageIcon> fragata;
    private List<ImageIcon> corveta;
    private List<ImageIcon> destroier;
    private List<ImageIcon> cruzador;
    private ImageIcon[] submarino;
    private ImageIcon[] encouracado;
    private ImageIcon[] portaaviao;
    
    public IconNaval(){
        agua = new ImageIcon(getClass().getResource("imagem/agua.png"));
        bomba = new ImageIcon(getClass().getResource("imagem/bomba.png"));
        fragata = new ArrayList<>();
        fragata.add(new ImageIcon(getClass().getResource("imagem/fragatahorizontalpt1.png")));
        fragata.add(new ImageIcon(getClass().getResource("imagem/fragatahorizontalpt2.png")));
        fragata.add(new ImageIcon(getClass().getResource("imagem/fragataverticalpt1.png")));
        fragata.add(new ImageIcon(getClass().getResource("imagem/fragataverticalpt2.png")));
        corveta = new ArrayList<>();
        corveta.add(new ImageIcon(getClass().getResource("imagem/corvetahorizontalpt1.png")));
        corveta.add(new ImageIcon(getClass().getResource("imagem/corvetahorizontalpt2.png")));
        corveta.add(new ImageIcon(getClass().getResource("imagem/corvetaverticalpt1.png")));
        corveta.add(new ImageIcon(getClass().getResource("imagem/corvetaverticalpt2.png")));
        destroier = new ArrayList<>();
        destroier.add(new ImageIcon(getClass().getResource("imagem/destroierhorizontalpt1.png")));
        destroier.add(new ImageIcon(getClass().getResource("imagem/destroierhorizontalpt2.png")));
        destroier.add(new ImageIcon(getClass().getResource("imagem/destroierhorizontalpt3.png")));
        destroier.add(new ImageIcon(getClass().getResource("imagem/destroierverticalpt1.png")));
        destroier.add(new ImageIcon(getClass().getResource("imagem/destroierverticalpt2.png")));
        destroier.add(new ImageIcon(getClass().getResource("imagem/destroierverticalpt3.png")));
        cruzador = new ArrayList<>();
        cruzador.add(new ImageIcon(getClass().getResource("imagem/cruzadorhorizontalpt1.png")));
        cruzador.add(new ImageIcon(getClass().getResource("imagem/cruzadorhorizontalpt2.png")));
        cruzador.add(new ImageIcon(getClass().getResource("imagem/cruzadorhorizontalpt3.png")));
        cruzador.add(new ImageIcon(getClass().getResource("imagem/cruzadorverticalpt1.png")));
        cruzador.add(new ImageIcon(getClass().getResource("imagem/cruzadorverticalpt2.png")));
        cruzador.add(new ImageIcon(getClass().getResource("imagem/cruzadorverticalpt3.png")));
    }
   public ImageIcon getImagem(String nome){
       System.out.println(nome);
        if("agua".equals(nome) || "99".equals(nome)){
            return agua;
        }else if("bomba".equals(nome) || "77".equals(nome)){
            return bomba;
        }else if("-100".equals(nome) || "-200".equals(nome) || "-300".equals(nome) || "-400".equals(nome)){
            return fragata.get(0);
        }else if("-101".equals(nome) || "-201".equals(nome) || "-301".equals(nome) || "-401".equals(nome)){
            return fragata.get(1);
        }else if("-110".equals(nome) || "-210".equals(nome) || "-310".equals(nome) || "-410".equals(nome)){
            return fragata.get(3);
        }else if("-111".equals(nome) || "-211".equals(nome) || "-311".equals(nome) || "-411".equals(nome)){
            return fragata.get(2);
        }else if("-500".equals(nome) || "-600".equals(nome) || "-700".equals(nome) || "-800".equals(nome)){
            return corveta.get(0);
        }else if("-501".equals(nome) || "-601".equals(nome) || "-701".equals(nome) || "-801".equals(nome)){
            return corveta.get(1);
        }else if("-510".equals(nome) || "-610".equals(nome) || "-710".equals(nome) || "-810".equals(nome)){
            return corveta.get(3);
        }else if("-511".equals(nome) || "-611".equals(nome) || "-711".equals(nome) || "-811".equals(nome)){
            return corveta.get(2);
        }else if("-900".equals(nome) || "-1000".equals(nome) || "-1100".equals(nome)){
            return destroier.get(0);
        }else if("-901".equals(nome) || "-1001".equals(nome) || "-1101".equals(nome)){
            return destroier.get(1);
        }else if("-902".equals(nome) || "-1002".equals(nome) || "-1102".equals(nome)){
            return destroier.get(2);
        }else if("-910".equals(nome) || "-1010".equals(nome) || "-1110".equals(nome)){
            return destroier.get(4);
        }else if("-911".equals(nome) || "-1011".equals(nome) || "-1111".equals(nome)){
            return destroier.get(5);
        }else if("-912".equals(nome) || "-1012".equals(nome) || "-1112".equals(nome)){
            return destroier.get(3);
        }else if("-1200".equals(nome) || "-1300".equals(nome) || "-1400".equals(nome)){
            return cruzador.get(0);
        }else if("-1201".equals(nome) || "-1301".equals(nome) || "-1401".equals(nome)){
            return cruzador.get(1);
        }else if("-1202".equals(nome) || "-1302".equals(nome) || "-1402".equals(nome)){
            return cruzador.get(2);
        }else if("-1210".equals(nome) || "-1310".equals(nome) || "-1410".equals(nome)){
            return cruzador.get(4);
        }else if("-1211".equals(nome) || "-1311".equals(nome) || "-1411".equals(nome)){
            return cruzador.get(5);
        }else if("-1212".equals(nome) || "-1312".equals(nome) || "-1412".equals(nome)){
            return cruzador.get(3);
        }
        return null;
    }
}
