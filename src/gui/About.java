package gui;

/**
 * About of editor Source
 * @author Daniel Martinez <headcruser at gmail.com>
 */
public class About
        extends javax.swing.JDialog
{
    /**
     * Creates new form About
     * @param parent
     * @param modal
     */
    public About(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo( null );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        mainPanel = new javax.swing.JPanel();
        pictureAbout = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About of Editor Source");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(290, 270));
        setResizable(false);

        mainPanel.setLayout(new java.awt.GridLayout(3, 3));

        pictureAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pictureAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/003-information.png"))); // NOI18N
        mainPanel.add(pictureAbout);

        description.setEditable(false);
        description.setColumns(20);
        description.setLineWrap(true);
        description.setRows(5);
        description.setText("Editor Source is create for Daniel Martinez Sierra. \n\nThis Proyect is protected for GNU Lincense ");
        description.setWrapStyleWord(true);
        description.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
        description.setOpaque(true);
        jScrollPane1.setViewportView(description);

        mainPanel.add(jScrollPane1);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea description;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel pictureAbout;
    // End of variables declaration//GEN-END:variables
}