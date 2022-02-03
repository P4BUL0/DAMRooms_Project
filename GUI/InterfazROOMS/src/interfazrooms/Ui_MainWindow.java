/********************************************************************************
 ** Form generated from reading ui file 'MainWindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package interfazrooms;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QDialog>
{
    public QLabel label_logo;
    public QWidget widget;
    public QGridLayout gridLayout;
    public QPushButton pushButton_mainSalir;
    public QPushButton pushButton_mainReserva;
    public QPushButton pushButton_mainCliente;

    public Ui_MainWindow() { super(); }

    public void setupUi(QDialog MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(378, 300).expandedTo(MainWindow.minimumSizeHint()));
        label_logo = new QLabel(MainWindow);
        label_logo.setObjectName("label_logo");
        label_logo.setGeometry(new QRect(130, 10, 111, 91));
        label_logo.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_logo.setAutoFillBackground(false);
        label_logo.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        label_logo.setPixmap(new QPixmap(("Logos/logo_size_invert.png")));
        label_logo.setScaledContents(true);
        label_logo.setWordWrap(false);
        widget = new QWidget(MainWindow);
        widget.setObjectName("widget");
        widget.setGeometry(new QRect(10, 120, 351, 164));
        gridLayout = new QGridLayout(widget);
        gridLayout.setObjectName("gridLayout");
        pushButton_mainSalir = new QPushButton(widget);
        pushButton_mainSalir.setObjectName("pushButton_mainSalir");
        pushButton_mainSalir.setMinimumSize(new QSize(0, 50));
        pushButton_mainSalir.setMaximumSize(new QSize(100, 16777215));
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        pushButton_mainSalir.setFont(font);
        pushButton_mainSalir.setStyleSheet("background-color:rgb(152, 210, 236)");

        gridLayout.addWidget(pushButton_mainSalir, 2, 0, 1, 1);

        pushButton_mainReserva = new QPushButton(widget);
        pushButton_mainReserva.setObjectName("pushButton_mainReserva");
        pushButton_mainReserva.setMinimumSize(new QSize(0, 50));
        pushButton_mainReserva.setMaximumSize(new QSize(100, 16777215));
        QPalette palette= new QPalette();
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        pushButton_mainReserva.setPalette(palette);
        QFont font1 = new QFont();
        font1.setBold(true);
        font1.setWeight(75);
        pushButton_mainReserva.setFont(font1);
        pushButton_mainReserva.setStyleSheet("background-color:rgb(152, 210, 236)");

        gridLayout.addWidget(pushButton_mainReserva, 0, 0, 1, 1);

        pushButton_mainCliente = new QPushButton(widget);
        pushButton_mainCliente.setObjectName("pushButton_mainCliente");
        pushButton_mainCliente.setMinimumSize(new QSize(0, 50));
        pushButton_mainCliente.setMaximumSize(new QSize(100, 16777215));
        QFont font2 = new QFont();
        font2.setBold(true);
        font2.setWeight(75);
        pushButton_mainCliente.setFont(font2);
        pushButton_mainCliente.setStyleSheet("background-color:rgb(152, 210, 236)");

        gridLayout.addWidget(pushButton_mainCliente, 1, 0, 1, 1);

        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Men\u00fa", null));
        label_logo.setText("");
        pushButton_mainSalir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Salir", null));
        pushButton_mainReserva.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Reserva", null));
        pushButton_mainCliente.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Cliente", null));
    } // retranslateUi

}

