package controllers.colorSyntax;

import controllers.windowEditorController;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.util.regex.Pattern;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
/**
 * Abstract Class for Sintax
 * @author Daniel Martinez
 */
public abstract class Syntax extends KeyAdapter implements IUpdateColor
{
    protected final windowEditorController wc;
    protected final Color sintaxColor;
    protected Pattern expresion;
    protected boolean bold;
    
    public Syntax( Pattern p , final windowEditorController controller,  final Color color)  
    { 
        super();
        expresion=p;
        wc=controller;
        sintaxColor=color;
        bold=false;
    }  
    
     protected void paintColorText(int i, int length, Color c) 
   {
        SimpleAttributeSet aset = new SimpleAttributeSet();
        StyleConstants.setForeground( aset, c );
        StyleConstants.setBold(aset, bold );
        invokeMethod( i, length, aset, bold ); 
    }
     
    protected void assingBold( final boolean active){ bold=active; }

    private void invokeMethod( int i, int length, SimpleAttributeSet aset, boolean bold) 
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
}