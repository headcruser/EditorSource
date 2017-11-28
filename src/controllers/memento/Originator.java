package controllers.memento;

/**
 * Origin Memento Backup Temporaly
 * @author Daniel Martinez <headcruser at gmail.com>
 */
public class Originator 
{
    private String sourceCode;
    
    public void set( String newSourceCode ) { sourceCode=newSourceCode; }
    
    public Memento storeInMomento() { return new Memento(sourceCode); }
    
    public String  RestoreFromMemento( Memento memento)
    {
        sourceCode=memento.getSaveSourceCode();        
        return sourceCode;
    }

}
