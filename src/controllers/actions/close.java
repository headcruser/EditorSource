package controllers.actions;

import java.awt.event.ActionEvent;
/**
 * 
 * Action Close System
 */
public class close  extends Action 
{
    public close() { super();}
    @Override
    public void actionPerformed(ActionEvent e) {    System.exit( 0 );   }
}