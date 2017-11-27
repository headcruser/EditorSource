package controllers;
import gui.WindowEditor;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.text.BadLocationException;

/**
 * Controlador de la ventana Window Editor
 *
 * @author Daniel Martinez <headcruser at gmail.com>
 */
public class windowEditorController implements IUpdateStatusConsole 
{

    final private WindowEditor editorView;

    public windowEditorController(WindowEditor view) throws Exception
    {
        editorView = view;
        addCarentEventListener();
        editorView.windowCenterPosition();
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        editorView.updateStatus( calculatePositionLine(e) );
    }

    private int calculatePositionLine( final CaretEvent e) {
        JTextPane component = (JTextPane) e.getSource();
        int coordenateY = calculateCoordenateInComponentY(component, component.getCaretPosition());
        int lineHeight = component.getFontMetrics(component.getFont()).getHeight();
        return ( coordenateY / lineHeight ) + 1;
    }

    private int calculateCoordenateInComponentY(final JTextPane component, final int caretPosition) 
    {
        int y = 0;
        try {
            Rectangle caretCoords = component.modelToView( caretPosition );
            y = (int) caretCoords.getY();
        } catch (BadLocationException ex) {
        }
        return y;
    }

    private void addCarentEventListener() { editorView.addCarentEventListener(this);    }
    
    public void showWindowEditor(final boolean isVisible) { editorView.setVisible(isVisible); }

}
