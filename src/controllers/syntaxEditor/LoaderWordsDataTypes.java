package controllers.syntaxEditor;
/**
 * Loader Data Types Words for Sintax Lenguaje
 * @author Daniel Martinez  <headcruser at gmail.com>
 */
public final class LoaderWordsDataTypes extends BuilderERSyntax
{
    public static final String NAME_RESOURCE="types";

    public LoaderWordsDataTypes() 
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