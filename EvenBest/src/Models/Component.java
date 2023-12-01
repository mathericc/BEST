/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author mathericc
 */
public class Component {
    String name;
    float quantity;

    public Component(String name, float quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    
    @Override public String toString() {
        return "" + this.name + " - " + this.quantity + "milemoles";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
    
    
    
    
}
