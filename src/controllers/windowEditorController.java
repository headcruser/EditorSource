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
    
    public windowEditorController(WindowEditor view ) throws Exception
    {
        editorView=view; 
        addCarentEventListener();
        editorView.windowCenterPosition();
    }
    
    public void showWindowEditor( final boolean isVisible )
    {
        editorView.setVisible( isVisible );
    }
    
    @Override
    public void caretUpdate(CaretEvent e) 
    {
        JTextPane component = (JTextPane) e.getSource();

        int coordenateY = calculateCoordenateInComponentY( component, component.getCaretPosition() );
        int lineHeight = component.getFontMetrics( component.getFont() ).getHeight();
        int posLine= (coordenateY / lineHeight) + 1;      

        editorView.updateStatus( posLine );
    }
    
    private void addCarentEventListener()
    {
        editorView.addCarentEventListener(this);
    }
    
    private int calculateCoordenateInComponentY(JTextPane component, int caretPosition )
    {
        int y=0;
         try {
            Rectangle caretCoords = component.modelToView(caretPosition);
            y = (int) caretCoords.getY();
        } catch (BadLocationException ex) {
        }
         return y;
    }
}
