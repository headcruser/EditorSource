package controllers.syntaxEditor;
/**
 * Loader Reserved Words for Sintax Lenguaje
 * @author Daniel Martinez  <headcruser at gmail.com>
 */
public final class LoaderWordsReserved extends BuilderERSyntax
{ 
    public static final String NAME_RESOURCE="reserved";
    
    public LoaderWordsReserved() 
    {
        super();
        words=loaderWords();    
    }
       
    @Override
    public String[] loaderWords( ) 
    {
        return System.getProperty( NAME_RESOURCE  ).split( " " ); 
    }
}