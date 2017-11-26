package controllers;
import gui.WindowEditor;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;

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
        editorView.addCarentEventListener(this);
        editorView.windowCenterPosition();
    }
    
    public void showWindowEditor( final boolean isVisible )
    {
        editorView.setVisible( isVisible );
    }
    
    @Override
    public void caretUpdate(CaretEvent e) 
    {
        JTextArea editArea = (JTextArea) e.getSource();
        int linea = 1;
        int columna = 1;

        try 
        {
            int caretpos = editArea.getCaretPosition();
            linea = editArea.getLineOfOffset(caretpos);
            columna = caretpos - editArea.getLineStartOffset(linea);
            linea += 1;
        } catch (Exception ex) {}

        editorView.updateStatus( linea, columna );
    }
}
