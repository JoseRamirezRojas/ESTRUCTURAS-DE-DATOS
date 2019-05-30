package proyecto3;

import java.io.Serializable;

/**
 * Interfaz funcional para implementar funciones de dispersión con lambdas.
 */
@FunctionalInterface
public interface Dispersor<K> extends Serializable{

    int dispersa(K elemento);    
}