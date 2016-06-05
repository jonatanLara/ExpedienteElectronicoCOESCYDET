/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Jonatan Lara
 */
public class Gestion {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    public Gestion(){
    }
    public String AbrirArchivo(File archivo){
        String contenido="";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!= -1){
                char caracter = (char) ascci;
                contenido += caracter;
            }
        } catch (Exception e) {
        }   
        return contenido;
    }
    /*metodo para guardar*/
    public String GuardarATexto(File archivo,String contenido){
        String respuesta="";
        try {
            salida = new FileOutputStream(archivo);
            byte[] byteText = contenido.getBytes();
            salida.write(byteText);
            respuesta="Se guardo con exito";
        } catch (Exception e) {
        }
        return respuesta;
    }
    /*Abir imagen*/
    public byte[] AbrirAImagen(File archivo){
        byte[] byteImg = new byte[1024*100];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(byteImg);
        } catch (Exception e) {
        }
        return byteImg;
    }
    /*gardar imagen*/
    public String GuardarAImagen(File archivo,byte[] bytesImg){
        String respuesta="";
        try {
            salida = new FileOutputStream(archivo);
            salida.write(bytesImg);
            respuesta="Se guardo con exito la Imagen";
        } catch (Exception e) {
        }
        return respuesta;
    }
}
