/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import java.util.Random;

/**
 * Classe VariableUniforme que genera valors aleatoris seguint una distribució uniforme.
 *
 * @author Daniel Ortiz
 */
public class VariableUniforme implements Serializable {
    private Random random;

    /**
     * Constructor de la classe VariableUniforme.
     * Inicialitza l'objecte Random amb una llavor per garantir la generació consistent de valors aleatoris.
     *
     * @param seed Llavor per inicialitzar el generador aleatori.
     */
    public VariableUniforme(long seed) {
        this.random = new Random(seed);
    }

    /**
     * Retorna un nou valor aleatori entre 0 i 99 seguint una distribució uniforme.
     *
     * @return Valor aleatori generat.
     */
    public int seguentValor() {
        return random.nextInt(100);
    }
}
