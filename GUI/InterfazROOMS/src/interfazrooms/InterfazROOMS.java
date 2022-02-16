package interfazrooms;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;

public class InterfazROOMS {
    
    public static void main(String[] args) {
        QApplication.initialize(args);
            QDialog mw = new QDialog();
            Ui_MainWindow mainWindow = new Ui_MainWindow();
            mainWindow.setupUi(mw);
            mw.setModal(true);
            mw.show();
        QApplication.execStatic();
    }
    
}
