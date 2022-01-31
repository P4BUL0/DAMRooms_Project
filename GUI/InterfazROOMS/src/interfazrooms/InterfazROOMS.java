/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazrooms;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;

/**
 *
 * @author DAM_jabd
 */
public class InterfazROOMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QApplication.initialize(args);
            QDialog mw = new QDialog();
            Ui_Dialog dialog = new Ui_Dialog();
            dialog.setupUi(mw);
        QApplication.execStatic();
    }
    
}
