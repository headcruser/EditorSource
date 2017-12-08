package controllers.status;

import gui.WindowEditor;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

/**
 * This class review State Console
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class StatusConsole implements CaretListener
{
    private final WindowEditor editorView;
    
    public StatusConsole(WindowEditor view)
    {
        this.editorView=view;
        addCarentEventListener();
    }

     @Override
    public void caretUpdate(CaretEvent e) 
    {
        editorView.updateStatus( calculatePositionLine(e) );
    }

    private int calculatePositionLine( final CaretEvent e) 
    {
        JTextPane component = (JTextPane) e.getSource();
        int coordenateY = calculateCoordenateInComponentY(component, component.getCaretPosition());
        int lineHeight = component.getFontMetrics(component.getFont()).getHeight();
        return ( coordenateY / lineHeight ) + 1;
    }

    private int calculateCoordenateInComponentY(final JTextPane component, final int caretPosition) 
    {
        int coordenateY = 0;
        try {
            Rectangle caretCoords = component.modelToView( caretPosition );
            coordenateY = (int) caretCoords.getY();
        } catch (BadLocationException ex) {
        }
        return coordenateY;
    }

    private void addCarentEventListener() { editorView.addCarentEventListener(this);    }

}