package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author Daniel Martinez
 */
public class WindowEditorFX extends Application
{

    public WindowEditorFX() {
        super();
        
    }
    
    public static void main(String[] args) 
    {
            launch(args);
    }
    
    @Override
    public void start(Stage winStage ) throws Exception 
    {
        winStage.setTitle( "  Source Editor" );
        StackPane root = new StackPane();
        Text text = new Text(" My Editor Source");
        root.getChildren().add( text );
        
        Scene scene = new Scene( root, 400, 400 );
        winStage.setScene( scene );
        winStage.setResizable( false );
        //winStage.setFullScreen(true);
        winStage.setOpacity( 0.5 );
        winStage.initStyle(StageStyle.UTILITY );
        winStage.show();
    }
}
