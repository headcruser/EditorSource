package controllers.colorSyntax;

import gui.WindowEditor;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 * Controller Syntax for Editor Source
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ColorSyntax extends KeyAdapter
{
    private final WindowEditor editorView;

    public ColorSyntax(WindowEditor view) 
    {
        editorView = view;
        editorView.getAreaEditor().addKeyListener(this);
    }

    private void updateColorText( int i,  int length,  Color c,  boolean bold )
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        SimpleAttributeSet aset = new SimpleAttributeSet();
        StyleConstants.setForeground(aset, c);
        
        if (bold) 
            StyleConstants.setBold(aset, true);
         else 
            StyleConstants.setBold(aset, false);
        
        editorView.setAttributesForStyleDoc( i, length, aset, bold );
    }
    
     public void compilaComentarioVariasLineas(Color color) 
     {
        Pattern p = Pattern.compile("\\/\\*.*?\\*\\/",
                Pattern.DOTALL);
        Matcher m = p.matcher( editorView.getTextCode() );
        while ( m.find()  ) 
            updateColorText( m.start(), m.end() - m.start(), color, false );
        
    }
     
  private  void paintColorSyntaxis() throws BadLocationException 
  {
        limpiarColores();
        compilaComentarioVariasLineas(Color.gray);//Comentarios de varias lineas
   
  }
  
   public void limpiarColores() 
   {
        updateColorText( 0, editorView.getTextCode().length() , Color.BLACK, false );
    }
   
   @Override
    public void keyPressed(java.awt.event.KeyEvent evt) 
    {
        try 
        {
            paintColorSyntaxis();
        } catch (BadLocationException ex) {
            System.out.println(ex.getMessage() );
        }
    }
}
