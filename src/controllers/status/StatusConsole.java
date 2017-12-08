package controllers.status;

import gui.WindowEditor;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * This class review State Console
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class StatusConsole implements CaretListener
{
    private final WindowEditor editorView;
    private final PositionComponentInJTtextPane position;
    
    public StatusConsole(WindowEditor view)
    {
        this.editorView=view;
        position= new PositionComponentInJTtextPane();
        addCarentEventListener();
    }

     @Override
    public void caretUpdate(CaretEvent e) 
    {
        editorView.updateStatus( position.calculatePositionLine(e) );
    }

    private void addCarentEventListener() { editorView.addCarentEventListener(this);    }
}