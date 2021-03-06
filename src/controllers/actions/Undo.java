package controllers.actions;

import controllers.windowEditorController;
import java.awt.event.ActionEvent;

/**
 * Listener for Button Undo
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class Undo extends Action
{
     private final windowEditorController wController;

    public Undo( windowEditorController viewEdirtor ) 
    {
        this.wController = viewEdirtor;
        wController.getView().buttonUndo.setEnabled( false );
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        if (!  articleNumberValid() )
        {
            wController.getView().buttonUndo.setEnabled( false );
            return;
        }
        
        wController.decreaseArticle();            
        wController.getView().getAreaEditor().setText( getBoxString() );
        wController.getView().buttonUndo.setEnabled( true );
    }

    private String getBoxString() 
    {
        String codeBoxString= wController.getOriginator().
                RestoreFromMemento( wController.getCareTaker().
                        getMemento( wController.getCurrentArticle() ) );
        return codeBoxString;
    }
    
    private boolean articleNumberValid(){
        return wController.getCurrentArticle() >=MINIMAL_ARTICLE;
    }
}