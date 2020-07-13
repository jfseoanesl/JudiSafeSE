
package gov.deajcesar.judisafese.logic;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import gov.deajcesar.judisafese.dao.PersonDAO;
import gov.deajcesar.judisafese.presentation.JFPrincipal;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author jairo
 */
public class JudiSafeSE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //PersonDAO p = new PersonDAO();
       // p.migrarEntity();
        try{
            
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            //UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            JFPrincipal ppal = new JFPrincipal();
            ppal.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ppal.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
