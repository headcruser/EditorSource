package controllers.colorSyntax;

import controllers.windowEditorController;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public final class SyntaxComments extends Syntax implements CaretListener
{ 
    
    public SyntaxComments( final windowEditorController controller ) 
    {
        super(  Pattern.compile("\\/\\*.*?\\*\\/",Pattern.DOTALL ) , controller , Color.GRAY );
        
    }   

    @Override
    public void updateColorText( final String text) 
    {
        Matcher m = expresion.matcher( text );
        
        while (m.find()) 
            paintColorText( m.start(), m.end() - m.start(), sintaxColor );
    }
    
   
   
    public void clearColors() 
   {
        paintColorText( 0, wc.getView().getTextCode().length() , Color.BLACK);
    }

    @Override
    public void caretUpdate(CaretEvent e) 
    {
        clearColors();
        updateColorText( wc.getView().getTextCode() );
    }
}