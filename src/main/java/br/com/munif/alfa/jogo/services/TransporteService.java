package br.com.munif.alfa.jogo.services;

import br.com.munif.alfa.jogo.entidades.Lugar;

public class TransporteService {

    private static TransporteService instancia=new TransporteService();

    public static TransporteService getInstancia() {
        return instancia;
    }
    

//    public synchronized static TransporteService getInstancia() {
////        if (instancia==null){
////            instancia=new TransporteService();
////        }
//        return instancia;
//    }

    private TransporteService() {
        instancia = this;
    }

    public void transporta(Transportavel alguem, Lugar algumLugar) {
        alguem.setLugar(algumLugar);
    }

}
