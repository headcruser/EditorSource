package gui;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingAndFX 
{
    final JFrame frame;
    static JFXPanel fxPanel;
    
    private static final int HIGH= 300;
    private static final int WIDTH= 250;
    private static final String  TITLE= "JavaFX / Swing Integrated";

    public SwingAndFX() {
        frame = new JFrame( TITLE );
        fxPanel = new JFXPanel();
        frame.add( fxPanel );
        frame.setVisible( true );
        frame.setSize( new Dimension( HIGH, WIDTH  ) );
        initAndShowGUI();
    }
    
    private static void initAndShowGUI() 
    {
        Platform.runLater(new Runnable() 
        {
          @Override
          public void run() 
          {
             final Group rootGroup = new Group();
             final Scene scene = new Scene( rootGroup, HIGH, WIDTH );
            fxPanel.setScene(scene);
            fxPanel.setOpaque(true);
          }
        });
  }


  public static void main(String[] arguments) 
  {
    SwingUtilities.invokeLater(new Runnable() 
    {
      @Override
      public void run() 
      {
        new SwingAndFX();
      }
    });
  }
  
}
