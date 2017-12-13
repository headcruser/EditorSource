package controllers.colorSyntax;

import controllers.windowEditorController;
import java.util.regex.Pattern;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretListener;
import javax.swing.text.SimpleAttributeSet;
/**
 * Define Abstract Model for Sintax
 * @author Daniel Martinez  <headcruser at gmail.com>
 */
public abstract class Syntax implements IUpdateColor, CaretListener
{
    protected final windowEditorController wc;
    protected Pattern reserved= Pattern.compile(  new LoaderWordsReserved().getRegularExpresion() );
    protected Pattern comments= Pattern.compile("\\/\\*.*?\\*\\/",Pattern.DOTALL);
    
    public Syntax( final windowEditorController controller)  
    { 
        super();
        wc=controller;
    }  
  
    protected final void updateComponent( int i, int length, SimpleAttributeSet aset, boolean bold) 
    {
        Runnable doHighlight = new Runnable()
        {
            @Override
            public void run() {
                wc.getView().getStyledDocument().setCharacterAttributes( i, length, aset , bold );
            }
        };
        SwingUtilities.invokeLater(doHighlight);
    }
    
    public abstract void clearColors();
}