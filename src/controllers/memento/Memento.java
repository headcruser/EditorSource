package controllers.memento;

/**
 *  Disign Pattern Memento for Editor Source
 * @author Daniel Martinez  <headcruser at gmail.com>
 */
public class Memento 
{
    private final String sourceCode;
    public Memento( String CodeSave ){ sourceCode=CodeSave; }
    public String getSaveSourceCode(){ return sourceCode; }

}
