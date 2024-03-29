package presentacion.gui;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MantenedorCodigos extends javax.swing.JInternalFrame {
    
    public MantenedorCodigos() {
        initComponents();
        
       //JLabel etiqueta1 = new JLabel( "panel uno", SwingConstants.CENTER );
       PanelCliente panel1 = new PanelCliente();
       //PanelMarcaVehiculo panel2 = new PanelMarcaVehiculo();
       PanelMarcaVehiculo panel2 = new PanelMarcaVehiculo();
       PanelModeloMarca panel3 = new PanelModeloMarca();
       
       
       //panel1.add( etiqueta1 ); 
       jTabbedPane1.addTab( "Clientes", null, panel1, "Primer panel" );         
       jTabbedPane1.addTab( "Marca Vehiculos", null, panel2, "Segundo panel" );         
       jTabbedPane1.addTab( "Modelo Marca", null, panel3, "Tercer panel" );         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenedor de codigos");
        setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
