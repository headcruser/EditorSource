package controllers.status;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.text.BadLocationException;

/**
 * Calculates the position of a character in a component JTextPane
 * @author Daniel Martinez
 */
public final class PositionComponentInJTtextPane 
{
    private int coordenateY;
    private int lineHeight; 
    
     public  int calculatePositionLine( final CaretEvent e) 
    {
        JTextPane component = (JTextPane) e.getSource();
        coordenateY = calculateCoordenateY( component, component.getCaretPosition() );
        lineHeight = calculateLineHeight(  component ) ;
        
        return ( coordenateY / lineHeight ) + 1;
    }

    private int calculateCoordenateY( final JTextPane component, final int caretPosition ) 
    {
        try 
        {
            Rectangle caretCoords = component.modelToView( caretPosition );
            return (int) caretCoords.getY();
        } catch (BadLocationException ex) {
            return 0;
        }
    }    
    private int calculateLineHeight( Component component )
    {
        return component.getFontMetrics( component.getFont() ).getHeight();
    }
}