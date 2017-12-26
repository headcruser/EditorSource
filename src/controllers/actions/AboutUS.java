package controllers.actions;

import controllers.windowEditorController;
import gui.About;
import java.awt.event.ActionEvent;

/**
 * Action information about of Editor Source
 * @author Daniel Martinez <headcruser at gmail.com>
 */
public final class AboutUS extends Action
{
    private final About __windowAbout;

    public AboutUS( final windowEditorController viewEditor )
    {
        __windowAbout=new About( viewEditor.getView() , true );    
    }
       
    @Override
    public void actionPerformed(ActionEvent e)
    {
        __windowAbout.setVisible( true );
    }
}