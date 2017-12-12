package controllers.colorSyntax;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Abstract Class for Sintax
 * @author Daniel Martinez
 */
public abstract class Syntax 
{
    protected String  regex;
    protected Pattern pattern;
    
     public Syntax( String regexExp) 
    {
        regex= regexExp;
        pattern = Pattern.compile( regex , Pattern.DOTALL);
    }
     
    public Matcher analizeSentence( final String match )
    {
            return pattern.matcher( match );
    }   
}