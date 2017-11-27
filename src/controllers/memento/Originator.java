package controllers.memento;

/**
 * 
 * @author Daniel Martinez <headcruser at gmail.com>
 */
public class Originator 
{
    private String sourceCode;
    
    public void set( String newSourceCode )
    {
        System.out.println
            ( new StringBuilder(  "From Originator : Current Version of Article:  " )
                .append( newSourceCode ) );
        
        sourceCode=newSourceCode;
    }
    
    public Memento storeInMomento()
    {
        return new Memento(sourceCode);
    }
    
    public String  RestoreFromMemento( Memento memento)
    {
        sourceCode=memento.getSaveSourceCode();
        
        System.out.println
            ( new StringBuilder(  "From Originator : Previus Article saved In memento:  " )
                .append( sourceCode ) );
        
        return sourceCode;
    }

}
