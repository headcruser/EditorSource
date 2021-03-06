package gui;

import controllers.actions.Action;
import controllers.files.IPathFiles;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyledDocument;

public final class WindowEditor extends javax.swing.JFrame implements IPathFiles
{
    private StyledDocument styleTextForDocument;
    /**
     * Creates new form WindowEditor
     */
    public WindowEditor() 
    {
           initComponents();
           assingIconApp( ICON_LOGO );
           assignSyleDocumentEditor();
           actionsSystem();
    }

    public void windowCenterPosition(){ this.setLocationRelativeTo( null ); }
    
    public void addAction( javax.swing.JButton button , Action actionButton) { button.addActionListener( actionButton ); }
    
    public void addActionItem(  javax.swing.JMenuItem item , Action actionItem){ item.addActionListener(actionItem); }

    public void addSyntaxListener(CaretListener event) { this.editor.addCaretListener( event ); }
     
    public void isEditorEditable( final boolean status) {   editor.setEditable(status ); }
    
    public String getTextCode(){ return editor.getText();}    
    
    public javax.swing.JTextPane getAreaEditor(){ return editor; }
    
    public void updateStatus( final int linea ) {   
        status.setText( new StringBuffer( "LINEA: " ).append( linea ).toString()); 
    }
    
     public  void setAttributesForStyleDoc( int i, int length, AttributeSet atribS ,  boolean bold) {
        styleTextForDocument.setCharacterAttributes( length, length, atribS, bold );   
    }
     
     public void initTextLineAspect( Component LineText ){
        scrollEditor.setRowHeaderView( LineText );
    }
    
    public void assingIconApp( final String  nameIcon ){ 
        setIconImage(new javax.swing.ImageIcon(getClass().getResource( nameIcon ) ).getImage()); 
    }
    
    public StyledDocument getStyledDocument(){ return  styleTextForDocument; }
    
    private void assignSyleDocumentEditor() { 
        styleTextForDocument = editor.getStyledDocument(); 
    }
     
    private void actionsSystem()
    {
        itemSaveAs.setEnabled( false );
        itemSave.setEnabled( false );
        buttonSave.setEnabled( false );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        Menu = new javax.swing.JMenu();
        ContenedorPrincipal = new javax.swing.JPanel();
        panelStatus = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        menuToolbar = new javax.swing.JToolBar();
        buttonSave = new javax.swing.JButton();
        buttonUndo = new javax.swing.JButton();
        buttonRedo = new javax.swing.JButton();
        scrollEditor = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextPane();
        menuPrincipal = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itemNew = new javax.swing.JMenuItem();
        itemOpen = new javax.swing.JMenuItem();
        itemSave = new javax.swing.JMenuItem();
        itemSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemClose = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        optionMenu = new javax.swing.JMenu();
        checkTool = new javax.swing.JCheckBoxMenuItem();
        checkConsole = new javax.swing.JCheckBoxMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemFonts = new javax.swing.JMenuItem();
        menuThemes = new javax.swing.JMenu();
        chItemDark = new javax.swing.JCheckBoxMenuItem();
        chItemClassic = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        itemAbout = new javax.swing.JMenuItem();

        Menu.setBackground(new java.awt.Color(0, 0, 0));
        Menu.setText("jMenu1");
        Menu.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EditorSource");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(400, 200));
        setName("windowApp"); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 500));
        setSize(new java.awt.Dimension(700, 500));

        ContenedorPrincipal.setLayout(new java.awt.BorderLayout());

        panelStatus.setBackground(new java.awt.Color(52, 152, 219));
        panelStatus.setBorder(null);
        panelStatus.setLayout(new java.awt.BorderLayout());

        status.setBackground(new java.awt.Color(52, 152, 219));
        status.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText(" ");
        status.setOpaque(true);
        panelStatus.add(status, java.awt.BorderLayout.LINE_END);

        ContenedorPrincipal.add(panelStatus, java.awt.BorderLayout.PAGE_END);

        menuToolbar.setRollover(true);

        buttonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/011-save.png"))); // NOI18N
        buttonSave.setToolTipText("Save File");
        buttonSave.setBorder(null);
        buttonSave.setBorderPainted(false);
        buttonSave.setContentAreaFilled(false);
        buttonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSave.setFocusable(false);
        buttonSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menuToolbar.add(buttonSave);

        buttonUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/undo.png"))); // NOI18N
        buttonUndo.setToolTipText("undo");
        buttonUndo.setBorder(null);
        buttonUndo.setBorderPainted(false);
        buttonUndo.setContentAreaFilled(false);
        buttonUndo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonUndo.setFocusable(false);
        buttonUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menuToolbar.add(buttonUndo);

        buttonRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redo.png"))); // NOI18N
        buttonRedo.setToolTipText("redo");
        buttonRedo.setBorder(null);
        buttonRedo.setBorderPainted(false);
        buttonRedo.setContentAreaFilled(false);
        buttonRedo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonRedo.setFocusable(false);
        buttonRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menuToolbar.add(buttonRedo);

        ContenedorPrincipal.add(menuToolbar, java.awt.BorderLayout.PAGE_START);

        scrollEditor.setBackground(new java.awt.Color(44, 62, 80));
        scrollEditor.setOpaque(true);

        editor.setBackground(new java.awt.Color(44, 62, 80));
        editor.setOpaque(false);
        scrollEditor.setViewportView(editor);

        ContenedorPrincipal.add(scrollEditor, java.awt.BorderLayout.CENTER);

        getContentPane().add(ContenedorPrincipal, java.awt.BorderLayout.CENTER);

        menuPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        menuPrincipal.setForeground(new java.awt.Color(51, 51, 51));
        menuPrincipal.setOpaque(true);

        fileMenu.setForeground(new java.awt.Color(0, 51, 51));
        fileMenu.setText("File");
        fileMenu.setOpaque(true);

        itemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/008-new-file.png"))); // NOI18N
        itemNew.setText("new");
        itemNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileMenu.add(itemNew);

        itemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        itemOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/009-open-folder-with-document.png"))); // NOI18N
        itemOpen.setText("open");
        itemOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileMenu.add(itemOpen);

        itemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/011-save.png"))); // NOI18N
        itemSave.setText("save");
        itemSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileMenu.add(itemSave);

        itemSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itemSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/010-save-file-option.png"))); // NOI18N
        itemSaveAs.setText("Save as");
        fileMenu.add(itemSaveAs);
        fileMenu.add(jSeparator1);

        itemClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        itemClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/007-close.png"))); // NOI18N
        itemClose.setText("Close");
        fileMenu.add(itemClose);

        menuPrincipal.add(fileMenu);

        menuEdit.setText("edit");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/006-magnifying-glass.png"))); // NOI18N
        jMenuItem1.setText("find");
        menuEdit.add(jMenuItem1);

        menuPrincipal.add(menuEdit);

        optionMenu.setText("options");

        checkTool.setSelected(true);
        checkTool.setText("showTools");
        checkTool.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/005-repair-tools.png"))); // NOI18N
        checkTool.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkTool(evt);
            }
        });
        optionMenu.add(checkTool);

        checkConsole.setSelected(true);
        checkConsole.setText("state console");
        checkConsole.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkConsole(evt);
            }
        });
        optionMenu.add(checkConsole);
        optionMenu.add(jSeparator2);

        itemFonts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/004-text-editor.png"))); // NOI18N
        itemFonts.setText("Fonts");
        optionMenu.add(itemFonts);

        menuThemes.setText("themes");

        chItemDark.setSelected(true);
        chItemDark.setText("Dark");
        menuThemes.add(chItemDark);

        chItemClassic.setSelected(true);
        chItemClassic.setText("Clasic");
        menuThemes.add(chItemClassic);

        optionMenu.add(menuThemes);

        menuPrincipal.add(optionMenu);

        helpMenu.setText("help");

        itemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/003-information.png"))); // NOI18N
        itemAbout.setText("about editor");
        helpMenu.add(itemAbout);

        menuPrincipal.add(helpMenu);

        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkTool(java.awt.event.ActionEvent evt)//GEN-FIRST:event_checkTool
    {//GEN-HEADEREND:event_checkTool
        showComponent( checkTool, menuToolbar  );
    }//GEN-LAST:event_checkTool

    private void checkConsole(java.awt.event.ActionEvent evt)//GEN-FIRST:event_checkConsole
    {//GEN-HEADEREND:event_checkConsole
        showComponent( checkConsole, panelStatus );
    }//GEN-LAST:event_checkConsole

    private void showComponent(javax.swing.JCheckBoxMenuItem check  , JComponent component)
    {
        if ( check.isSelected() == true )
            component.setVisible( true );        
        else 
            component.setVisible( false );
        
        this.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContenedorPrincipal;
    private javax.swing.JMenu Menu;
    public javax.swing.JButton buttonRedo;
    public javax.swing.JButton buttonSave;
    public javax.swing.JButton buttonUndo;
    private javax.swing.JCheckBoxMenuItem chItemClassic;
    private javax.swing.JCheckBoxMenuItem chItemDark;
    private javax.swing.JCheckBoxMenuItem checkConsole;
    private javax.swing.JCheckBoxMenuItem checkTool;
    private javax.swing.JTextPane editor;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    public javax.swing.JMenuItem itemAbout;
    public javax.swing.JMenuItem itemClose;
    private javax.swing.JMenuItem itemFonts;
    public javax.swing.JMenuItem itemNew;
    public javax.swing.JMenuItem itemOpen;
    public javax.swing.JMenuItem itemSave;
    public javax.swing.JMenuItem itemSaveAs;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenu menuThemes;
    private javax.swing.JToolBar menuToolbar;
    private javax.swing.JMenu optionMenu;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JScrollPane scrollEditor;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}