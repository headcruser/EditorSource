package controllers.buttons;

import gui.WindowEditor;
import java.awt.event.ActionEvent;

/**
 * Listener for Button Undo
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class UndoButtonListener extends ButtonListener
{
     private final WindowEditor viewEditor;
     private static final int MINIMAL_ARTICLE = 1;

    public UndoButtonListener(WindowEditor viewEdirtor) {
        this.viewEditor = viewEdirtor;
        viewEditor.enableUndoButton( false );
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (!  articleNumberValid() )
        {
            viewEditor.enableUndoButton( false );
            return;
        }
        
        viewEditor.decreaseArticle();
            String codeBoxString= viewEditor.getOriginator().
                    RestoreFromMemento( viewEditor.getCareTaker().
                            getMemento( viewEditor.getCurrentArticle() ) );
            
            viewEditor.getAreaEditor().setText(codeBoxString);
            viewEditor.enableRedoButton( true );
            
        
    }
    
    private boolean articleNumberValid(){
        return viewEditor.getCurrentArticle() >=MINIMAL_ARTICLE;
    }

}
