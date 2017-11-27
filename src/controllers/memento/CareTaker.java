package controllers.memento;

import java.util.ArrayList;

/**
 * Tasker of Memento
 * @author Daniel Martinez <headcruser at gmail.com>
 */
public class CareTaker 
{
    ArrayList<Memento> savedCode = new ArrayList<Memento>();
    
    public void addMemento( Memento m ){ savedCode.add( m ); }
    public Memento getMemento(final int index){ return savedCode.get( index ) ; }

}
