package com.example.jaimo.expresionexpressmobileapp;

import android.content.Context;
import android.content.Intent;

/**
 * Created by jaimo on 17/11/2017.
 */





public class Controlador {
    private static Controlador ctrl;

    public Controlador(){
    }

    public static Controlador getInstance(){
        if(ctrl == null)
            ctrl = new Controlador();
        return ctrl;
    }

    public Intent dameVista(EVENTOS evento, Context contexto) {
        Intent intent = null;
        switch (evento){
            case INICIO_A_NUMPAREJAS: intent = new Intent(contexto, NumParejas.class);
        }
        return intent;
    }

}
