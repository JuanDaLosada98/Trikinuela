package com.example.estudiante.triki;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

public class Servidor  extends Thread{
    private DatagramSocket ds;
    private MainActivity mainActivity;
    private int jugador;
    public Servidor(MainActivity mainActivity, int jugador) {
        this.mainActivity = mainActivity;
        this.jugador = jugador;
        try {
            ds = new DatagramSocket(5000);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                recibir();
                sleep(8);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void recibir() throws IOException {

        byte[] buf = new byte[64]; // 47k
        DatagramPacket p = new DatagramPacket(buf, buf.length);
        ds.receive(p);

        String mensajes =  new String(p.getData(),0,p.getLength()).trim();
        String[] partes = mensajes.split(",");

        int vx = Integer.parseInt(partes[0]);
        int vy = Integer.parseInt(partes[1]);
        int vj = Integer.parseInt(partes[2]);
    }


    public void enviar(String mensaje){

        try {
            InetAddress ip = InetAddress.getByName("192.168.1.68");
            int puerto = 5000;
            byte[] buf = mensaje.getBytes();
            DatagramPacket p = new DatagramPacket(buf,buf.length, ip, puerto);
            ds.send(p);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
