package interfazrooms;

import APIRest.Habitacion;
import APIRest.RestClientHabitacion;
import com.google.gson.Gson;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import javax.swing.*;

public class Ui_Habitaciones implements com.trolltech.qt.QUiForm<QDialog> {
    public QLabel label_Titulo;
    public QWidget layoutWidget_4;
    public QHBoxLayout horizontalLayout;
    public QSpacerItem horizontalSpacer_2;
    public QLabel label_confirmacion;
    public QPushButton pushButton_informe;
    public QPushButton pushButton_cancelar;
    public QWidget layoutWidget;
    public QGridLayout gridLayout;
    public QPushButton pushButton_consultar;
    public QPushButton pushButton_modificar;
    public QGroupBox groupBox_2;
    public QWidget layoutWidget1;
    public QGridLayout gridLayout_4;
    public QLabel label_Tipo;
    public QRadioButton radioButton_Individual;
    public QRadioButton radioButton_Doble;
    public QRadioButton radioButton_Familiar;
    public QRadioButton radioButton_Suite;
    public QRadioButton radioButton_GranSuite;
    public QGroupBox groupBox_3;
    public QWidget layoutWidget_2;
    public QGridLayout gridLayout_5;
    public QCheckBox checkBox_Jacuzzi;
    public QCheckBox checkBox_WiFi;
    public QCheckBox checkBox_Bar;
    public QCheckBox checkBox_Aire;
    public QLabel label_Cama;
    public QRadioButton radioButton_CamaIndividual;
    public QCheckBox checkBox_Luminosa;
    public QCheckBox checkBox_Banera;
    public QCheckBox checkBox_Tele;
    public QCheckBox checkBox_Terraza;
    public QCheckBox checkBox_Cafe;
    public QRadioButton radioButton_CamaMatrimonio;
    public QRadioButton radioButton_CamaKing;
    public QLabel label_ImporteNoche;
    public QLineEdit lineEdit_ImporteNoche;
    public QPushButton pushButton_eliminar;
    public QPushButton pushButton_ingresar;
    public QLabel label_Logo;
    public QGroupBox groupBox_cliente_2;
    public QWidget layoutWidget2;
    public QGridLayout gridLayout_2;
    public QLabel label_Numero;
    public QSpinBox spinBox_NumeroHabitacion;

    public Ui_Habitaciones() { super(); }

    //Métodos API
    public void insertarHab(){
        String tipo = "", caracteristica = "";
        float importeNoche = 0f;
        RestClientHabitacion restClientHabitacion = new RestClientHabitacion();
        importeNoche = Float.parseFloat(lineEdit_ImporteNoche.text());
        if (radioButton_Individual.isChecked()){
            tipo = "Individual";
        }else if (radioButton_Doble.isChecked()){
            tipo = "Doble";
        }else if (radioButton_Familiar.isChecked()){
            tipo = "Familiar";
        }else if (radioButton_Suite.isChecked()){
            tipo = "Suite";
        }else if (radioButton_GranSuite.isChecked()){
            tipo = "Gran Suite";
        }
        if (radioButton_CamaIndividual.isChecked()){
            caracteristica = "Cama individual";
        }else if (radioButton_CamaMatrimonio.isChecked()){
            caracteristica = "Cama de matrimonio";
        }else if (radioButton_CamaKing.isChecked()){
            caracteristica = "Cama KingSize";
        }
        if (checkBox_Luminosa.isChecked()){
            caracteristica += ", Luminosa";
        }if (checkBox_WiFi.isChecked()){
            caracteristica += ", Wi-Fi";
        }if (checkBox_Terraza.isChecked()){
            caracteristica += ", Terraza";
        }if (checkBox_Cafe.isChecked()){
            caracteristica += ", Cafetera";
        }if (checkBox_Bar.isChecked()){
            caracteristica += ", Mini Bar";
        }if (checkBox_Banera.isChecked()){
            caracteristica += ", Bañera";
        }if (checkBox_Jacuzzi.isChecked()){
            caracteristica += ", Jacuzzi";
        }if (checkBox_Tele.isChecked()){
            caracteristica += ", TV";
        }if (checkBox_Aire.isChecked()){
            caracteristica += ", AC";
        }

        restClientHabitacion.crear(0, tipo, caracteristica, importeNoche);
        lineEdit_ImporteNoche.clear();
        radioButton_Individual.setChecked(false);
        radioButton_Doble.setChecked(false);
        radioButton_Familiar.setChecked(false);
        radioButton_Suite.setChecked(false);
        radioButton_GranSuite.setChecked(false);


        radioButton_CamaIndividual.setEnabled(false);
        radioButton_CamaMatrimonio.setChecked(false);
        radioButton_CamaKing.setChecked(false);

        checkBox_Luminosa.setChecked(false);
        checkBox_WiFi.setChecked(false);
        checkBox_Terraza.setChecked(false);
        checkBox_Cafe.setChecked(false);
        checkBox_Bar.setChecked(false);
        checkBox_Banera.setChecked(false);
        checkBox_Jacuzzi.setChecked(false);
        checkBox_Tele.setChecked(false);
        checkBox_Aire.setChecked(false);
    }

    public void consultarHab(){
        long numero;
        String resultado = "";
        Gson gson = new Gson();

        RestClientHabitacion restClientHabitacion = new RestClientHabitacion();
        numero = Long.parseLong(String.valueOf(spinBox_NumeroHabitacion.value()));
        resultado = restClientHabitacion.consultar(numero);
        Habitacion h = gson.fromJson(resultado, Habitacion.class);

        lineEdit_ImporteNoche.setText(String.valueOf(h.getImporte_noche()));

        //Tipo de habitación
        if (h.getTipo().equalsIgnoreCase("Individual")){
            System.out.println(h.getTipo());
            radioButton_Individual.setChecked(true);
        }
        if (h.getTipo().equalsIgnoreCase("Doble")){
            radioButton_Doble.setChecked(true);
        }
        if (h.getTipo().equalsIgnoreCase("Familiar")){
            radioButton_Familiar.setChecked(true);
        }
        if (h.getTipo().equalsIgnoreCase("Suite")){
            radioButton_Suite.setChecked(true);
        }
        if (h.getTipo().equalsIgnoreCase("Gran Suite")){

            radioButton_GranSuite.setChecked(true);
        }


        //Cama de la habitación
        if (h.getCaracteristicas().contains("Cama individual")){
            radioButton_CamaIndividual.setChecked(true);
        }
        if (h.getCaracteristicas().contains("Cama de matrimonio")){
            radioButton_CamaMatrimonio.setChecked(true);
        }
        if (h.getCaracteristicas().contains("Cama KingSize")){
            radioButton_CamaKing.setChecked(true);
        }

        //Características de la habitación
        if (h.getCaracteristicas().contains("Luminosa")){
            checkBox_Luminosa.setChecked(true);
        }
        if (h.getCaracteristicas().contains("Wi-Fi")){
            checkBox_WiFi.setChecked(true);
        }
        if (h.getCaracteristicas().contains("Terraza")){
            checkBox_Terraza.setChecked(true);
        }
        if (h.getCaracteristicas().contains("Cafetera")){
            checkBox_Cafe.setChecked(true);
        }
        if (h.getCaracteristicas().contains("Mini Bar")){
            checkBox_Bar.setChecked(true);
        }
        if (h.getCaracteristicas().contains("Bañera")){
            checkBox_Banera.setChecked(true);
        }
        if (h.getCaracteristicas().contains("Jacuzzi")){
            checkBox_Jacuzzi.setChecked(true);
        }
        if (h.getCaracteristicas().contains("TV")){
            checkBox_Tele.setChecked(true);
        }
        if (h.getCaracteristicas().contains("Aire acondicionado")){
            checkBox_Aire.setChecked(true);
        }
    }

    public void eliminarHab(){
        long numero;
        RestClientHabitacion restClientHabitacion = new RestClientHabitacion();
        numero = Long.parseLong(String.valueOf(spinBox_NumeroHabitacion.value()));

        int confirmar = JOptionPane.showConfirmDialog(null,"Quieres eliminar la habitación?", "Eliminar habitación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmar == 0) {
            restClientHabitacion.eliminar(numero);
        }
    }

    public void modificarHab(){
        long numero;
        String tipo = "", caracteristica = "";
        float importe_noche;
        consultarHab();
        RestClientHabitacion restClientHabitacion = new RestClientHabitacion();
        numero = spinBox_NumeroHabitacion.value();
        importe_noche = Float.parseFloat(lineEdit_ImporteNoche.text());
        if (radioButton_Individual.isChecked()){
            tipo = "Individual";
        }else if (radioButton_Doble.isChecked()){
            tipo = "Doble";
        }else if (radioButton_Familiar.isChecked()){
            tipo = "Familiar";
        }else if (radioButton_Suite.isChecked()){
            tipo = "Suite";
        }else if (radioButton_GranSuite.isChecked()){
            tipo = "Gran Suite";
        }
        if (radioButton_CamaIndividual.isChecked()){
            caracteristica = "Cama individual";
        }else if (radioButton_CamaMatrimonio.isChecked()){
            caracteristica = "Cama de matrimonio";
        }else if (radioButton_CamaKing.isChecked()){
            caracteristica = "Cama KingSize";
        }
        if (checkBox_Luminosa.isChecked()){
            caracteristica += ", Luminosa";
        }if (checkBox_WiFi.isChecked()){
            caracteristica += ", Wi-Fi";
        }if (checkBox_Terraza.isChecked()){
            caracteristica += ", Terraza";
        }if (checkBox_Cafe.isChecked()){
            caracteristica += ", Cafetera";
        }if (checkBox_Bar.isChecked()){
            caracteristica += ", Mini Bar";
        }if (checkBox_Banera.isChecked()){
            caracteristica += ", Bañera";
        }if (checkBox_Jacuzzi.isChecked()){
            caracteristica += ", Jacuzzi";
        }if (checkBox_Tele.isChecked()){
            caracteristica += ", TV";
        }if (checkBox_Aire.isChecked()){
            caracteristica += ", AC";
        }

        restClientHabitacion.modificar(numero, tipo, caracteristica, importe_noche);
    }

    //Métodos GUI
    public void setupUi(QDialog Habitaciones) {
        Habitaciones.setObjectName("Habitaciones");
        Habitaciones.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.WindowModal);
        Habitaciones.setEnabled(true);
        Habitaciones.resize(new QSize(571, 498).expandedTo(Habitaciones.minimumSizeHint()));
        Habitaciones.setWindowIcon(new QIcon(new QPixmap("Resources/Logos/logo_Icon.png")));
        Habitaciones.setModal(true);
        label_Titulo = new QLabel(Habitaciones);
        label_Titulo.setObjectName("label_Titulo");
        label_Titulo.setGeometry(new QRect(20, 10, 211, 31));
        QFont font = new QFont();
        font.setPointSize(15);
        font.setBold(true);
        font.setUnderline(true);
        font.setWeight(75);
        label_Titulo.setFont(font);
        label_Titulo.setStyleSheet("");
        layoutWidget_4 = new QWidget(Habitaciones);
        layoutWidget_4.setObjectName("layoutWidget_4");
        layoutWidget_4.setGeometry(new QRect(10, 450, 551, 42));
        horizontalLayout = new QHBoxLayout(layoutWidget_4);
        horizontalLayout.setObjectName("horizontalLayout");
        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer_2);

        label_confirmacion = new QLabel(layoutWidget_4);
        label_confirmacion.setObjectName("label_confirmacion");

        horizontalLayout.addWidget(label_confirmacion);

        pushButton_informe = new QPushButton(layoutWidget_4);
        pushButton_informe.setObjectName("pushButton_informe");
        pushButton_informe.setMinimumSize(new QSize(0, 25));
        QPalette palette= new QPalette();
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_informe.setPalette(palette);
        QFont font1 = new QFont();
        font1.setBold(true);
        font1.setWeight(75);
        pushButton_informe.setFont(font1);
        pushButton_informe.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_informe.setIcon(new QIcon(new QPixmap("Resources/Iconos/Informe.png")));

        horizontalLayout.addWidget(pushButton_informe);

        pushButton_cancelar = new QPushButton(layoutWidget_4);
        pushButton_cancelar.setObjectName("pushButton_cancelar");
        pushButton_cancelar.setMinimumSize(new QSize(0, 25));
        QPalette palette1= new QPalette();
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        pushButton_cancelar.setPalette(palette1);
        QFont font2 = new QFont();
        font2.setBold(true);
        font2.setWeight(75);
        pushButton_cancelar.setFont(font2);
        pushButton_cancelar.setStyleSheet("");
        pushButton_cancelar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Salir.png")));

        horizontalLayout.addWidget(pushButton_cancelar);

        layoutWidget = new QWidget(Habitaciones);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(10, 120, 551, 321));
        gridLayout = new QGridLayout(layoutWidget);
        gridLayout.setObjectName("gridLayout");
        pushButton_consultar = new QPushButton(layoutWidget);
        pushButton_consultar.setObjectName("pushButton_consultar");
        QPalette palette2= new QPalette();
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_consultar.setPalette(palette2);
        QFont font3 = new QFont();
        font3.setBold(true);
        font3.setWeight(75);
        pushButton_consultar.setFont(font3);
        pushButton_consultar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_consultar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Buscar.png")));

        gridLayout.addWidget(pushButton_consultar, 0, 1, 1, 1);

        pushButton_modificar = new QPushButton(layoutWidget);
        pushButton_modificar.setObjectName("pushButton_modificar");
        QPalette palette3= new QPalette();
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_modificar.setPalette(palette3);
        QFont font4 = new QFont();
        font4.setBold(true);
        font4.setWeight(75);
        pushButton_modificar.setFont(font4);
        pushButton_modificar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_modificar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Modificar.png")));

        gridLayout.addWidget(pushButton_modificar, 1, 1, 1, 1);

        groupBox_2 = new QGroupBox(layoutWidget);
        groupBox_2.setObjectName("groupBox_2");
        QPalette palette4= new QPalette();
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_2.setPalette(palette4);
        QFont font5 = new QFont();
        font5.setFamily("Arial");
        font5.setPointSize(10);
        font5.setBold(true);
        font5.setWeight(75);
        groupBox_2.setFont(font5);
        groupBox_2.setAutoFillBackground(true);
        groupBox_2.setFlat(false);
        groupBox_2.setCheckable(false);
        layoutWidget1 = new QWidget(groupBox_2);
        layoutWidget1.setObjectName("layoutWidget1");
        layoutWidget1.setGeometry(new QRect(10, 26, 511, 221));
        gridLayout_4 = new QGridLayout(layoutWidget1);
        gridLayout_4.setObjectName("gridLayout_4");
        label_Tipo = new QLabel(layoutWidget1);
        label_Tipo.setObjectName("label_Tipo");
        QFont font6 = new QFont();
        font6.setPointSize(8);
        font6.setBold(true);
        font6.setWeight(75);
        label_Tipo.setFont(font6);

        gridLayout_4.addWidget(label_Tipo, 2, 0, 1, 1);

        radioButton_Individual = new QRadioButton(layoutWidget1);
        QButtonGroup buttonGroup_Tipo = new QButtonGroup(Habitaciones);
        buttonGroup_Tipo.addButton(radioButton_Individual);
        radioButton_Individual.setObjectName("radioButton_Individual");

        gridLayout_4.addWidget(radioButton_Individual, 2, 1, 1, 1);

        radioButton_Doble = new QRadioButton(layoutWidget1);
        buttonGroup_Tipo.addButton(radioButton_Doble);
        radioButton_Doble.setObjectName("radioButton_Doble");

        gridLayout_4.addWidget(radioButton_Doble, 2, 2, 1, 1);

        radioButton_Familiar = new QRadioButton(layoutWidget1);
        buttonGroup_Tipo.addButton(radioButton_Familiar);
        radioButton_Familiar.setObjectName("radioButton_Familiar");

        gridLayout_4.addWidget(radioButton_Familiar, 2, 3, 1, 1);

        radioButton_Suite = new QRadioButton(layoutWidget1);
        buttonGroup_Tipo.addButton(radioButton_Suite);
        radioButton_Suite.setObjectName("radioButton_Suite");

        gridLayout_4.addWidget(radioButton_Suite, 2, 4, 1, 1);

        radioButton_GranSuite = new QRadioButton(layoutWidget1);
        buttonGroup_Tipo.addButton(radioButton_GranSuite);
        radioButton_GranSuite.setObjectName("radioButton_GranSuite");

        gridLayout_4.addWidget(radioButton_GranSuite, 2, 5, 1, 1);

        groupBox_3 = new QGroupBox(layoutWidget1);
        groupBox_3.setObjectName("groupBox_3");
        groupBox_3.setMaximumSize(new QSize(500, 140));
        QPalette palette5= new QPalette();
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_3.setPalette(palette5);
        QFont font7 = new QFont();
        font7.setFamily("Arial");
        font7.setPointSize(10);
        font7.setBold(true);
        font7.setWeight(75);
        groupBox_3.setFont(font7);
        groupBox_3.setAutoFillBackground(true);
        groupBox_3.setFlat(false);
        groupBox_3.setCheckable(false);
        layoutWidget_2 = new QWidget(groupBox_3);
        layoutWidget_2.setObjectName("layoutWidget_2");
        layoutWidget_2.setGeometry(new QRect(40, 20, 451, 113));
        gridLayout_5 = new QGridLayout(layoutWidget_2);
        gridLayout_5.setObjectName("gridLayout_5");
        checkBox_Jacuzzi = new QCheckBox(layoutWidget_2);
        checkBox_Jacuzzi.setObjectName("checkBox_Jacuzzi");
        checkBox_Jacuzzi.setMaximumSize(new QSize(100, 16777215));
        QFont font8 = new QFont();
        font8.setPointSize(8);
        checkBox_Jacuzzi.setFont(font8);

        gridLayout_5.addWidget(checkBox_Jacuzzi, 0, 2, 1, 1);

        checkBox_WiFi = new QCheckBox(layoutWidget_2);
        checkBox_WiFi.setObjectName("checkBox_WiFi");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(checkBox_WiFi.sizePolicy().hasHeightForWidth());
        checkBox_WiFi.setSizePolicy(sizePolicy);
        checkBox_WiFi.setMaximumSize(new QSize(100, 16777215));
        QFont font9 = new QFont();
        font9.setPointSize(8);
        checkBox_WiFi.setFont(font9);

        gridLayout_5.addWidget(checkBox_WiFi, 1, 0, 1, 1);

        checkBox_Bar = new QCheckBox(layoutWidget_2);
        checkBox_Bar.setObjectName("checkBox_Bar");
        checkBox_Bar.setMaximumSize(new QSize(100, 16777215));
        QFont font10 = new QFont();
        font10.setPointSize(8);
        checkBox_Bar.setFont(font10);

        gridLayout_5.addWidget(checkBox_Bar, 1, 1, 1, 1);

        checkBox_Aire = new QCheckBox(layoutWidget_2);
        checkBox_Aire.setObjectName("checkBox_Aire");
        checkBox_Aire.setMaximumSize(new QSize(100, 16777215));
        QFont font11 = new QFont();
        font11.setPointSize(8);
        checkBox_Aire.setFont(font11);

        gridLayout_5.addWidget(checkBox_Aire, 2, 2, 1, 1);

        label_Cama = new QLabel(layoutWidget_2);
        label_Cama.setObjectName("label_Cama");
        QFont font12 = new QFont();
        font12.setPointSize(9);
        label_Cama.setFont(font12);

        gridLayout_5.addWidget(label_Cama, 3, 0, 1, 1);

        radioButton_CamaIndividual = new QRadioButton(layoutWidget_2);
        radioButton_CamaIndividual.setObjectName("radioButton_CamaIndividual");
        QFont font13 = new QFont();
        font13.setPointSize(8);
        radioButton_CamaIndividual.setFont(font13);

        gridLayout_5.addWidget(radioButton_CamaIndividual, 4, 0, 1, 1);

        checkBox_Luminosa = new QCheckBox(layoutWidget_2);
        checkBox_Luminosa.setObjectName("checkBox_Luminosa");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(checkBox_Luminosa.sizePolicy().hasHeightForWidth());
        checkBox_Luminosa.setSizePolicy(sizePolicy1);
        checkBox_Luminosa.setMaximumSize(new QSize(100, 16777215));
        QFont font14 = new QFont();
        font14.setPointSize(8);
        checkBox_Luminosa.setFont(font14);

        gridLayout_5.addWidget(checkBox_Luminosa, 0, 0, 1, 1);

        checkBox_Banera = new QCheckBox(layoutWidget_2);
        checkBox_Banera.setObjectName("checkBox_Banera");
        checkBox_Banera.setMaximumSize(new QSize(100, 16777215));
        QFont font15 = new QFont();
        font15.setPointSize(8);
        checkBox_Banera.setFont(font15);

        gridLayout_5.addWidget(checkBox_Banera, 2, 1, 1, 1);

        checkBox_Tele = new QCheckBox(layoutWidget_2);
        checkBox_Tele.setObjectName("checkBox_Tele");
        checkBox_Tele.setMaximumSize(new QSize(100, 16777215));
        QFont font16 = new QFont();
        font16.setPointSize(8);
        checkBox_Tele.setFont(font16);

        gridLayout_5.addWidget(checkBox_Tele, 1, 2, 1, 1);

        checkBox_Terraza = new QCheckBox(layoutWidget_2);
        checkBox_Terraza.setObjectName("checkBox_Terraza");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(checkBox_Terraza.sizePolicy().hasHeightForWidth());
        checkBox_Terraza.setSizePolicy(sizePolicy2);
        checkBox_Terraza.setMaximumSize(new QSize(100, 16777215));
        QFont font17 = new QFont();
        font17.setPointSize(8);
        checkBox_Terraza.setFont(font17);

        gridLayout_5.addWidget(checkBox_Terraza, 2, 0, 1, 1);

        checkBox_Cafe = new QCheckBox(layoutWidget_2);
        checkBox_Cafe.setObjectName("checkBox_Cafe");
        checkBox_Cafe.setMaximumSize(new QSize(100, 16777215));
        QFont font18 = new QFont();
        font18.setPointSize(8);
        checkBox_Cafe.setFont(font18);

        gridLayout_5.addWidget(checkBox_Cafe, 0, 1, 1, 1);

        radioButton_CamaMatrimonio = new QRadioButton(layoutWidget_2);
        radioButton_CamaMatrimonio.setObjectName("radioButton_CamaMatrimonio");
        QFont font19 = new QFont();
        font19.setPointSize(8);
        radioButton_CamaMatrimonio.setFont(font19);

        gridLayout_5.addWidget(radioButton_CamaMatrimonio, 4, 1, 1, 1);

        radioButton_CamaKing = new QRadioButton(layoutWidget_2);
        radioButton_CamaKing.setObjectName("radioButton_CamaKing");
        QFont font20 = new QFont();
        font20.setPointSize(8);
        radioButton_CamaKing.setFont(font20);

        gridLayout_5.addWidget(radioButton_CamaKing, 4, 2, 1, 1);


        gridLayout_4.addWidget(groupBox_3, 3, 0, 1, 6);

        label_ImporteNoche = new QLabel(layoutWidget1);
        label_ImporteNoche.setObjectName("label_ImporteNoche");
        QFont font21 = new QFont();
        font21.setPointSize(8);
        font21.setBold(true);
        font21.setWeight(75);
        label_ImporteNoche.setFont(font21);

        gridLayout_4.addWidget(label_ImporteNoche, 0, 0, 1, 1);

        lineEdit_ImporteNoche = new QLineEdit(layoutWidget1);
        lineEdit_ImporteNoche.setObjectName("lineEdit_ImporteNoche");
        lineEdit_ImporteNoche.setMaximumSize(new QSize(1000, 16777215));
        QFont font22 = new QFont();
        font22.setPointSize(8);
        lineEdit_ImporteNoche.setFont(font22);

        gridLayout_4.addWidget(lineEdit_ImporteNoche, 0, 1, 1, 1);


        gridLayout.addWidget(groupBox_2, 2, 0, 1, 2);

        pushButton_eliminar = new QPushButton(layoutWidget);
        pushButton_eliminar.setObjectName("pushButton_eliminar");
        QPalette palette6= new QPalette();
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_eliminar.setPalette(palette6);
        QFont font23 = new QFont();
        font23.setBold(true);
        font23.setWeight(75);
        pushButton_eliminar.setFont(font23);
        pushButton_eliminar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_eliminar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Eliminar.png")));

        gridLayout.addWidget(pushButton_eliminar, 1, 0, 1, 1);

        pushButton_ingresar = new QPushButton(layoutWidget);
        pushButton_ingresar.setObjectName("pushButton_ingresar");
        QPalette palette7= new QPalette();
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_ingresar.setPalette(palette7);
        QFont font24 = new QFont();
        font24.setBold(true);
        font24.setWeight(75);
        pushButton_ingresar.setFont(font24);
        pushButton_ingresar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_ingresar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Guardar.png")));

        gridLayout.addWidget(pushButton_ingresar, 0, 0, 1, 1);

        label_Logo = new QLabel(Habitaciones);
        label_Logo.setObjectName("label_Logo");
        label_Logo.setGeometry(new QRect(440, 10, 121, 101));
        label_Logo.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_Logo.setAutoFillBackground(false);
        label_Logo.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        label_Logo.setPixmap(new QPixmap(("Resources/Logos/logo_size_invert.png")));
        label_Logo.setScaledContents(true);
        label_Logo.setWordWrap(false);
        groupBox_cliente_2 = new QGroupBox(Habitaciones);
        groupBox_cliente_2.setObjectName("groupBox_cliente_2");
        groupBox_cliente_2.setGeometry(new QRect(10, 50, 421, 61));
        QPalette palette8= new QPalette();
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_cliente_2.setPalette(palette8);
        QFont font25 = new QFont();
        font25.setPointSize(10);
        font25.setBold(true);
        font25.setWeight(75);
        groupBox_cliente_2.setFont(font25);
        groupBox_cliente_2.setStyleSheet("background-color:rgb(152,210,232)");
        layoutWidget2 = new QWidget(groupBox_cliente_2);
        layoutWidget2.setObjectName("layoutWidget2");
        layoutWidget2.setGeometry(new QRect(20, 20, 250, 42));
        gridLayout_2 = new QGridLayout(layoutWidget2);
        gridLayout_2.setObjectName("gridLayout_2");
        label_Numero = new QLabel(layoutWidget2);
        label_Numero.setObjectName("label_Numero");
        label_Numero.setMinimumSize(new QSize(120, 25));
        QFont font26 = new QFont();
        font26.setPointSize(14);
        font26.setBold(true);
        font26.setWeight(75);
        label_Numero.setFont(font26);

        gridLayout_2.addWidget(label_Numero, 0, 0, 1, 1);

        spinBox_NumeroHabitacion = new QSpinBox(layoutWidget2);
        spinBox_NumeroHabitacion.setObjectName("spinBox_NumeroHabitacion");
        spinBox_NumeroHabitacion.setMinimumSize(new QSize(100, 25));

        gridLayout_2.addWidget(spinBox_NumeroHabitacion, 0, 1, 1, 1);

        label_Tipo.setBuddy(radioButton_Individual);
        label_ImporteNoche.setBuddy(lineEdit_ImporteNoche);
        label_Numero.setBuddy(spinBox_NumeroHabitacion);
        QWidget.setTabOrder(spinBox_NumeroHabitacion, pushButton_ingresar);
        QWidget.setTabOrder(pushButton_ingresar, pushButton_consultar);
        QWidget.setTabOrder(pushButton_consultar, pushButton_eliminar);
        QWidget.setTabOrder(pushButton_eliminar, pushButton_modificar);
        QWidget.setTabOrder(pushButton_modificar, lineEdit_ImporteNoche);
        QWidget.setTabOrder(lineEdit_ImporteNoche, radioButton_Individual);
        QWidget.setTabOrder(radioButton_Individual, radioButton_Doble);
        QWidget.setTabOrder(radioButton_Doble, radioButton_Familiar);
        QWidget.setTabOrder(radioButton_Familiar, radioButton_Suite);
        QWidget.setTabOrder(radioButton_Suite, radioButton_GranSuite);
        QWidget.setTabOrder(radioButton_GranSuite, checkBox_Luminosa);
        QWidget.setTabOrder(checkBox_Luminosa, checkBox_Cafe);
        QWidget.setTabOrder(checkBox_Cafe, checkBox_Jacuzzi);
        QWidget.setTabOrder(checkBox_Jacuzzi, checkBox_WiFi);
        QWidget.setTabOrder(checkBox_WiFi, checkBox_Bar);
        QWidget.setTabOrder(checkBox_Bar, checkBox_Tele);
        QWidget.setTabOrder(checkBox_Tele, checkBox_Terraza);
        QWidget.setTabOrder(checkBox_Terraza, checkBox_Banera);
        QWidget.setTabOrder(checkBox_Banera, checkBox_Aire);
        QWidget.setTabOrder(checkBox_Aire, radioButton_CamaIndividual);
        QWidget.setTabOrder(radioButton_CamaIndividual, radioButton_CamaMatrimonio);
        QWidget.setTabOrder(radioButton_CamaMatrimonio, radioButton_CamaKing);
        QWidget.setTabOrder(radioButton_CamaKing, pushButton_informe);
        QWidget.setTabOrder(pushButton_informe, pushButton_cancelar);
        retranslateUi(Habitaciones);

        pushButton_ingresar.clicked.connect(this, "insertarHab()");
        pushButton_consultar.clicked.connect(this, "consultarHab()");
        pushButton_eliminar.clicked.connect(this, "eliminarHab()");
        pushButton_modificar.clicked.connect(this, "modificarHab()");

        pushButton_cancelar.clicked.connect(Habitaciones, "close()");

        Habitaciones.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Habitaciones){
        Habitaciones.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Habitaciones", null));
        label_Titulo.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Gesti\u00f3n habitaciones", null));
        label_confirmacion.setText("");
        pushButton_informe.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Informe", null));
        pushButton_cancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Cancelar", null));
        pushButton_consultar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Buscar habitaci\u00f3n", null));
        pushButton_consultar.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Consultar", null));
        pushButton_modificar.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Modificar", null));
        groupBox_2.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Habitaci\u00f3n", null));
        label_Tipo.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Tipo:", null));
        radioButton_Individual.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Individual", null));
        radioButton_Doble.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Doble", null));
        radioButton_Familiar.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Familiar", null));
        radioButton_Suite.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Suite", null));
        radioButton_GranSuite.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Gran Suite", null));
        groupBox_3.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Caracter\u00edsticas", null));
        checkBox_Jacuzzi.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Jacuzzi", null));
        checkBox_WiFi.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Wi-Fi", null));
        checkBox_Bar.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Mini bar", null));
        checkBox_Aire.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Aire acond", null));
        label_Cama.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Cama:", null));
        radioButton_CamaIndividual.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Individual", null));
        checkBox_Luminosa.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Luminosa", null));
        checkBox_Banera.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Ba\u00f1era", null));
        checkBox_Tele.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Televisi\u00f3n", null));
        checkBox_Terraza.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Terraza", null));
        checkBox_Cafe.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Cafetera", null));
        radioButton_CamaMatrimonio.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Matrimonio", null));
        radioButton_CamaKing.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "KingSize", null));
        label_ImporteNoche.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Importe noche:", null));
        lineEdit_ImporteNoche.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Introduzca su tel\u00e9fono", null));
        lineEdit_ImporteNoche.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "\u20ac", null));
        pushButton_eliminar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Eliminar habitaci\u00f3n", null));
        pushButton_eliminar.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Eliminar", null));
        pushButton_ingresar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Ingresar habitaci\u00f3n", null));
        pushButton_ingresar.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Ingresar", null));
        label_Logo.setText("");
        groupBox_cliente_2.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "Habitaci\u00f3n", null));
        label_Numero.setText(com.trolltech.qt.core.QCoreApplication.translate("Habitaciones", "N\u00famero:", null));
    } // retranslateUi

}

