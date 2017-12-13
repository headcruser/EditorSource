package controllers.colorSyntax;

import controllers.windowEditorController;
import java.awt.Color;
import java.util.regex.Matcher;
import javax.swing.event.CaretEvent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 * Paint Syntax for Reserved Words 
 * @author Daniel Martinez  <headcruser at gmail.com>
 */
public final class PaintColorSyntax extends Syntax
{  
    public PaintColorSyntax( windowEditorController controller ) 
    {
        super (  controller );        
    }

    @Override
    public void updateColorText( final String text) 
    {
        Matcher findR = reserved.matcher( text );
        Matcher  findC= comments.matcher( text );
        
        while ( findR.find() ) 
            paintColorText( findR.start(), findR.end() - findR.start(), Color.BLUE, true );
        
        while ( findC.find() ) 
            paintColorText( findC.start(), findC.end() - findC.start(), Color.GRAY, true );
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        clearColors();
        updateColorText( wc.getView().getTextCode() );
    }
    
    @Override
    public void clearColors() {
        paintColorText( 0, wc.getView().getTextCode().length() , Color.BLACK, false);
    }
    
    private void  paintColorText(int i, int length, Color c, boolean bold) 
   {
       StyleContext sc = StyleContext.getDefaultStyleContext();
        SimpleAttributeSet aset = new SimpleAttributeSet();
        StyleConstants.setForeground( aset, c ); 
        StyleConstants.setBold( aset, bold );
        updateComponent( i, length, aset, bold ); 
    }
}
