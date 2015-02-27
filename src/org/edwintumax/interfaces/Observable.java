package org.edwintumax.interfaces;
public interface Observable {
    public void agregar(Observer observador);
    public void eliminar(Observer observador);
    public void notificar();
}
