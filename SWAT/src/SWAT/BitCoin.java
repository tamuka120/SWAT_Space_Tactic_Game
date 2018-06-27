/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * @author admin
 */
public class BitCoin implements WarChest {
    
    
    private int value = 0;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int v) {
        this.value = v;
    }

    @Override
    public void addValue(int v) {
        this.value = this.value + v;
    }

    @Override
    public void deductValue(int v) {
        this.value = this.value - v;
    }
    
}
