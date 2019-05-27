package proyecto3;
/**
 * Interfaz funcional para implementar funciones de dispersión con lambdas.
 */
@FunctionalInterface
public interface Dispersor<K>{

    int dispersa(K elemento);    
}