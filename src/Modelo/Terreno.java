/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Felix Diaz ®
 */
public class Terreno {

    private Nodos inicio;
    private Nodos fin;
    private Nodos[][] grafo;
    private int ancho;
    private int alto;

    public Terreno(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.grafo = new Nodos[ancho][alto];
    }

    public Nodos get(int fila, int columna) {
        if (fila < alto && fila >= 0 && columna < ancho && columna >= 0) {
            return grafo[fila][columna];
        } else {
            return null;
        }
    }

    public Nodos getInicio() {
        return inicio;
    }

    public void setInicio(Nodos inicio) {
        this.inicio = inicio;
    }

    public Nodos getFin() {
        return fin;
    }

    public void setFin(Nodos fin) {
        this.fin = fin;
    }

    public Nodos[][] getGrafo() {
        return grafo;
    }

    public void setGrafo(Nodos[][] grafo) {
        this.grafo = grafo;
    }

    public void estableceInicio(int fila, int columna) {
        this.inicio = get(fila, columna);
    }

    public void estableceFin(int fila, int columna) {
        this.fin = get(fila, columna);
    }

    public void establecerVecinos4Direcciones(Nodos node) {
        Cola aux = new Cola();
        int fila = node.getFila();
        int columna = node.getColumna();
        Nodos vecino;

        vecino = get(fila + 1, columna);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila, columna + 1);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila - 1, columna);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila, columna - 1);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }

        node.setVecinos(aux);
    }

    private boolean vecinoAceptable(Nodos vecino) {
        return ((vecino != null) && !(vecino.isRecorrido()) && !(vecino.isObstaculo()));
    }

    public void establecerVecinos8Direcciones(Nodos node) {
        Cola aux = new Cola();
        int fila = node.getFila();
        int columna = node.getColumna();
        Nodos vecino;

        vecino = get(fila + 1, columna - 1);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila + 1, columna);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila + 1, columna + 1);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila, columna + 1);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila - 1, columna + 1);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila - 1, columna);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila - 1, columna - 1);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        vecino = get(fila, columna - 1);
        if (vecinoAceptable(vecino)) {
            aux.enqueue(vecino);
            vecino.setAnterior(node);
        }
        
         node.setVecinos(aux);
    }
}
