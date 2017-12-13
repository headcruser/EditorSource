package controllers.colorSyntax;

/**
 * Actions for Loader Words for system
 * @author Daniel Martinez  <headcruser at gmail.com>
 */
public abstract class BuilderERSyntax
{
    protected String words [];

    public BuilderERSyntax() {}
    
    abstract String[] loaderWords();
    
    protected final StringBuilder buildExpresion(  ) 
    {
        StringBuilder buff = new StringBuilder( "" );
        buff.append( "(" );

        for ( String keyword : words ) 
            buff.append( "\\b").append( keyword ).append( "\\b" ).append( "|" );

        buff.deleteCharAt( buff.length() - 1 );
        buff.append( ")" );

        return buff;
    }
    
    public String getRegularExpresion() {   return buildExpresion().toString(); }
}
