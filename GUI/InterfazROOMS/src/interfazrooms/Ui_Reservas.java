package interfazrooms;

import APIRest.*;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Ui_Reservas implements com.trolltech.qt.QUiForm<QDialog> {
    public QGroupBox groupBox_Reservas;
    public QWidget layoutWidget_3;
    public QGridLayout gridLayout_3;
    public QLabel label_FechaInicio;
    public QLabel label_Direccion_2;
    public QCalendarWidget calendarWidget_Fin;
    public QCalendarWidget calendarWidget_Inicio;
    public QDateEdit dateEditInicio;
    public QDateEdit dateEditFin;
    public QGroupBox groupBox_habitaciones;
    public QLabel label_importeTotal;
    public QLabel label_importeTotalRes;
    public QListWidget listWidget_habitaciones;
    public QPushButton pushButton_CalcularImporte;
    public QGroupBox groupBox_reservas;
    public QListWidget listWidget_reservas;
    public QWidget layoutWidget_4;
    public QHBoxLayout horizontalLayout;
    public QSpacerItem horizontalSpacer_2;
    public QPushButton pushButton_eliminar;
    public QPushButton pushButton_modificar;
    public QPushButton pushButton_reservar;
    public QPushButton pushButton_cancelar;
    public QLabel label_Logo;
    public QLabel label_Titulo;
    public QGroupBox groupBox_cliente;
    public QComboBox comboBox;
    public QLabel label_clienteDNI;
    public boolean canOpen = true;

    public Ui_Reservas() { super(); }

    //Métodos mensajes
    public void mensajeOPCorrecta(){
        JOptionPane.showMessageDialog(null, "La acción se ha realizado correctamente.","OK", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarhabitaciones(){
        RestClientReserva restClientReserva = new RestClientReserva();
        listWidget_habitaciones.clear();
        for (Habitacion h: restClientReserva.consultarListaHab()) {
            listWidget_habitaciones.addItem(h.getNumero() + ", " + h.getTipo() + ", " + h.getCaracteristicas() + ", " + h.getImporte_noche());
        }
    }

    public void mostrarReservas(){
        RestClientReserva restClientReserva = new RestClientReserva();
        listWidget_reservas.clear();

        //try{
            String[] listaReservas = restClientReserva.consultarListaRes();
            for (String reserva: listaReservas) {
                listWidget_reservas.addItem(reserva);
            }
        //    canOpen = true;
        //}catch (Exception e){
        //    canOpen = false;
        //}



    }

    public void mostrarClientesDni(){
        RestClientCliente restClientCliente = new RestClientCliente();
        for (Cliente c: restClientCliente.consultarLista()) {
            comboBox.addItem(c.getDni());
        }

    }

    public void calcularImporte(){
        String[] getImporteNoche = listWidget_habitaciones.currentItem().text().split(", ");
        LocalDate fechaInicio = LocalDate.parse(calendarWidget_Inicio.selectedDate().toString("yyyy-MM-dd"));
        LocalDate fechaFin = LocalDate.parse(calendarWidget_Fin.selectedDate().toString("yyyy-MM-dd"));

        float importeNoche = Float.parseFloat(getImporteNoche[getImporteNoche.length-1]);
        long total_dias = DAYS.between(fechaInicio, fechaFin);

        if (total_dias <= 0){
            JOptionPane.showMessageDialog(null, "La fecha de inicio tiene que ser anterior a la fecha final", "Error en la elección de la fecha", JOptionPane.ERROR_MESSAGE);
        }else{
            float importeTotal = importeNoche * total_dias;
            label_importeTotalRes.setText(importeTotal + " €");
        }
    }

    public void insertar(){
        RestClientHabitacion restClientHabitacion = new RestClientHabitacion();
        RestClientReserva restClientReserva = new RestClientReserva();
        RestClientCliente restClientCliente = new RestClientCliente();

        String dni;
        String numero;
        LocalDate fechaInicio;
        LocalDate fechaFin;
        float importeTotal;
        Cliente cliente;
        Habitacion habitacion;

        try{
            numero = listWidget_habitaciones.currentItem().text().substring(0,listWidget_habitaciones.currentItem().text().indexOf(","));
            habitacion = restClientHabitacion.GetHabitacion(Long.parseLong(numero));
            dni = comboBox.currentText();
            cliente = restClientCliente.obtenerClienteByDni(dni);
            fechaInicio = LocalDate.parse(dateEditInicio.date().toString("yyyy-MM-dd"));
            fechaFin = LocalDate.parse(dateEditFin.date().toString("yyyy-MM-dd"));
            importeTotal = Float.parseFloat(label_importeTotalRes.text().replace(" €", ""));

            int confirmar = JOptionPane.showConfirmDialog(null,"Quieres insertar la reserva?", "Insertar reserva", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmar == 0) {
                restClientReserva.crear(fechaInicio,fechaFin,importeTotal, cliente, habitacion);
                mensajeOPCorrecta();
                mostrarReservas();
            }
        }catch (NullPointerException npe){
            npe.printStackTrace();
            System.out.println("No se ha seleccionado la habitación");
            JOptionPane.showMessageDialog(null, "No se ha seleccionado habitación", "Habitación no seleccionada", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            System.out.println("No se ha calculado el importe");
            JOptionPane.showMessageDialog(null, "No se ha calculado el importe", "Importe no calculado", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(){
        RestClientReserva restClientReserva = new RestClientReserva();

        try{
            String numero = listWidget_reservas.currentItem().text().substring(3, listWidget_reservas.currentItem().text().indexOf(" "));
            int confirmar = JOptionPane.showConfirmDialog(null,"Quieres eliminar la reserva?", "Eliminar reserva", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmar == 0) {
                restClientReserva.eliminar(Long.parseLong(numero));
                mensajeOPCorrecta();
                mostrarReservas();
            }
        }catch (NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("No se ha seleccionado la reserva");
            JOptionPane.showMessageDialog(null, "No se ha seleccionado reserva", "Reserva no seleccionada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificar(){
        RestClientCliente restClientCliente = new RestClientCliente();
        RestClientHabitacion restClientHabitacion = new RestClientHabitacion();
        RestClientReserva restClientReserva = new RestClientReserva();

        String dni;
        String numero;
        LocalDate fechaInicio;
        LocalDate fechaFin;
        float importeTotal;

        Cliente cliente;
        Habitacion habitacion;

        try{
            String idReserva = listWidget_reservas.currentItem().text().substring(3, listWidget_reservas.currentItem().text().indexOf(" "));
            try{
                numero = listWidget_habitaciones.currentItem().text().substring(0,listWidget_habitaciones.currentItem().text().indexOf(","));
                dni = comboBox.currentText();
                cliente = restClientCliente.obtenerClienteByDni(dni);
                fechaInicio = LocalDate.parse(dateEditInicio.date().toString("yyyy-MM-dd"));
                fechaFin = LocalDate.parse(dateEditFin.date().toString("yyyy-MM-dd"));
                importeTotal = Float.parseFloat(label_importeTotalRes.text().replace(" €", ""));
                habitacion = restClientHabitacion.GetHabitacion(Long.parseLong(numero));

                int confirmar = JOptionPane.showConfirmDialog(null,"Quieres modificar la reserva?", "Modificar reserva", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirmar == 0) {
                    restClientReserva.modificar(Long.parseLong(idReserva),fechaInicio,fechaFin,importeTotal, cliente, habitacion);
                    mensajeOPCorrecta();
                    mostrarReservas();
                }
            }catch (NullPointerException npe) {
                npe.printStackTrace();
                System.out.println("No se ha seleccionado la habitación");
                JOptionPane.showMessageDialog(null, "No se ha seleccionado habitación", "Habitación no seleccionada", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }catch (NullPointerException npe){
            npe.printStackTrace();
            System.out.println("No se ha seleccionado la reserva");
            JOptionPane.showMessageDialog(null, "No se ha seleccionado reserva", "Reserva no seleccionada", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            System.out.println("No se ha calculado el importe");
            JOptionPane.showMessageDialog(null, "No se ha calculado el importe", "Importe no calculado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setupUi(QDialog Reservas)
    {
        Reservas.setObjectName("Reservas");
        Reservas.resize(new QSize(607, 846).expandedTo(Reservas.minimumSizeHint()));
        Reservas.setWindowIcon(new QIcon(new QPixmap("Resources/Logos/logo_Iconsinfondo.png")));
        groupBox_Reservas = new QGroupBox(Reservas);
        groupBox_Reservas.setObjectName("groupBox_Reservas");
        groupBox_Reservas.setGeometry(new QRect(10, 130, 591, 651));
        groupBox_Reservas.setMinimumSize(new QSize(0, 50));
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
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 255, 255));
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
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 255, 255));
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
        groupBox_Reservas.setPalette(palette);
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(10);
        font.setBold(true);
        font.setWeight(75);
        groupBox_Reservas.setFont(font);
        groupBox_Reservas.setAutoFillBackground(true);
        groupBox_Reservas.setFlat(false);
        groupBox_Reservas.setCheckable(false);
        layoutWidget_3 = new QWidget(groupBox_Reservas);
        layoutWidget_3.setObjectName("layoutWidget_3");
        layoutWidget_3.setGeometry(new QRect(10, 26, 568, 205));
        gridLayout_3 = new QGridLayout(layoutWidget_3);
        gridLayout_3.setObjectName("gridLayout_3");
        label_FechaInicio = new QLabel(layoutWidget_3);
        label_FechaInicio.setObjectName("label_FechaInicio");
        QFont font1 = new QFont();
        font1.setPointSize(8);
        font1.setBold(true);
        font1.setWeight(75);
        label_FechaInicio.setFont(font1);

        gridLayout_3.addWidget(label_FechaInicio, 1, 0, 1, 1);

        label_Direccion_2 = new QLabel(layoutWidget_3);
        label_Direccion_2.setObjectName("label_Direccion_2");
        QFont font2 = new QFont();
        font2.setPointSize(8);
        font2.setBold(true);
        font2.setWeight(75);
        label_Direccion_2.setFont(font2);

        gridLayout_3.addWidget(label_Direccion_2, 1, 1, 1, 1);

        calendarWidget_Fin = new QCalendarWidget(layoutWidget_3);
        calendarWidget_Fin.setObjectName("calendarWidget_Fin");
        calendarWidget_Fin.setFirstDayOfWeek(com.trolltech.qt.core.Qt.DayOfWeek.Monday);
        calendarWidget_Fin.setGridVisible(true);
        calendarWidget_Fin.setVerticalHeaderFormat(com.trolltech.qt.gui.QCalendarWidget.VerticalHeaderFormat.NoVerticalHeader);

        gridLayout_3.addWidget(calendarWidget_Fin, 4, 1, 1, 1);

        calendarWidget_Inicio = new QCalendarWidget(layoutWidget_3);
        calendarWidget_Inicio.setObjectName("calendarWidget_Inicio");
        calendarWidget_Inicio.setFirstDayOfWeek(com.trolltech.qt.core.Qt.DayOfWeek.Monday);
        calendarWidget_Inicio.setGridVisible(true);
        calendarWidget_Inicio.setSelectionMode(com.trolltech.qt.gui.QCalendarWidget.SelectionMode.SingleSelection);
        calendarWidget_Inicio.setVerticalHeaderFormat(com.trolltech.qt.gui.QCalendarWidget.VerticalHeaderFormat.NoVerticalHeader);

        gridLayout_3.addWidget(calendarWidget_Inicio, 4, 0, 1, 1);

        dateEditInicio = new QDateEdit(layoutWidget_3);
        dateEditInicio.setObjectName("dateEditInicio");

        gridLayout_3.addWidget(dateEditInicio, 2, 0, 1, 1);

        dateEditFin = new QDateEdit(layoutWidget_3);
        dateEditFin.setObjectName("dateEditFin");

        gridLayout_3.addWidget(dateEditFin, 2, 1, 1, 1);

        groupBox_habitaciones = new QGroupBox(groupBox_Reservas);
        groupBox_habitaciones.setObjectName("groupBox_habitaciones");
        groupBox_habitaciones.setGeometry(new QRect(10, 240, 571, 251));
        QPalette palette1= new QPalette();
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_habitaciones.setPalette(palette1);
        QFont font3 = new QFont();
        font3.setFamily("Arial");
        font3.setPointSize(10);
        font3.setBold(true);
        font3.setWeight(75);
        groupBox_habitaciones.setFont(font3);
        groupBox_habitaciones.setAutoFillBackground(false);
        groupBox_habitaciones.setFlat(false);
        groupBox_habitaciones.setCheckable(false);
        label_importeTotal = new QLabel(groupBox_habitaciones);
        label_importeTotal.setObjectName("label_importeTotal");
        label_importeTotal.setGeometry(new QRect(10, 220, 111, 16));
        QFont font4 = new QFont();
        font4.setPointSize(11);
        font4.setBold(true);
        font4.setWeight(75);
        label_importeTotal.setFont(font4);
        label_importeTotalRes = new QLabel(groupBox_habitaciones);
        label_importeTotalRes.setObjectName("label_importeTotalRes");
        label_importeTotalRes.setGeometry(new QRect(110, 220, 89, 16));
        QFont font5 = new QFont();
        font5.setFamily("Arial");
        font5.setPointSize(11);
        font5.setBold(true);
        font5.setWeight(75);
        label_importeTotalRes.setFont(font5);
        listWidget_habitaciones = new QListWidget(groupBox_habitaciones);
        listWidget_habitaciones.setObjectName("listWidget_habitaciones");
        listWidget_habitaciones.setGeometry(new QRect(10, 20, 551, 192));
        pushButton_CalcularImporte = new QPushButton(groupBox_habitaciones);
        pushButton_CalcularImporte.setObjectName("pushButton_CalcularImporte");
        pushButton_CalcularImporte.setGeometry(new QRect(420, 220, 76, 24));
        pushButton_CalcularImporte.setMinimumSize(new QSize(140, 23));
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

        pushButton_CalcularImporte.setPalette(palette2);
        QFont font6 = new QFont();
        font6.setBold(true);
        font6.setWeight(75);
        pushButton_CalcularImporte.setFont(font6);
        pushButton_CalcularImporte.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_CalcularImporte.setIcon(new QIcon(new QPixmap("Resources/Iconos/Calc.png")));
        groupBox_reservas = new QGroupBox(groupBox_Reservas);
        groupBox_reservas.setObjectName("groupBox_reservas");
        groupBox_reservas.setGeometry(new QRect(10, 500, 571, 141));
        QPalette palette3= new QPalette();
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_reservas.setPalette(palette3);
        QFont font7 = new QFont();
        font7.setFamily("Arial");
        font7.setPointSize(10);
        font7.setBold(true);
        font7.setWeight(75);
        groupBox_reservas.setFont(font7);
        groupBox_reservas.setAutoFillBackground(false);
        groupBox_reservas.setFlat(false);
        groupBox_reservas.setCheckable(false);
        listWidget_reservas = new QListWidget(groupBox_reservas);
        listWidget_reservas.setObjectName("listWidget_reservas");
        listWidget_reservas.setGeometry(new QRect(10, 20, 551, 111));
        layoutWidget_4 = new QWidget(Reservas);
        layoutWidget_4.setObjectName("layoutWidget_4");
        layoutWidget_4.setGeometry(new QRect(10, 790, 591, 41));
        layoutWidget_4.setMinimumSize(new QSize(0, 23));
        horizontalLayout = new QHBoxLayout(layoutWidget_4);
        horizontalLayout.setObjectName("horizontalLayout");
        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer_2);

        pushButton_eliminar = new QPushButton(layoutWidget_4);
        pushButton_eliminar.setObjectName("pushButton_eliminar");
        pushButton_eliminar.setMinimumSize(new QSize(0, 23));
        QPalette palette4= new QPalette();
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_eliminar.setPalette(palette4);
        QFont font8 = new QFont();
        font8.setBold(true);
        font8.setWeight(75);
        pushButton_eliminar.setFont(font8);
        pushButton_eliminar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_eliminar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Eliminar.png")));

        horizontalLayout.addWidget(pushButton_eliminar);

        pushButton_modificar = new QPushButton(layoutWidget_4);
        pushButton_modificar.setObjectName("pushButton_modificar");
        pushButton_modificar.setMinimumSize(new QSize(0, 23));
        QPalette palette5= new QPalette();
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_modificar.setPalette(palette5);
        QFont font9 = new QFont();
        font9.setBold(true);
        font9.setWeight(75);
        pushButton_modificar.setFont(font9);
        pushButton_modificar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_modificar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Modificar.png")));

        horizontalLayout.addWidget(pushButton_modificar);

        pushButton_reservar = new QPushButton(layoutWidget_4);
        pushButton_reservar.setObjectName("pushButton_reservar");
        pushButton_reservar.setMinimumSize(new QSize(0, 23));
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
        pushButton_reservar.setPalette(palette6);
        QFont font10 = new QFont();
        font10.setBold(true);
        font10.setWeight(75);
        pushButton_reservar.setFont(font10);
        pushButton_reservar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_reservar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Guardar.png")));

        horizontalLayout.addWidget(pushButton_reservar);

        pushButton_cancelar = new QPushButton(layoutWidget_4);
        pushButton_cancelar.setObjectName("pushButton_cancelar");
        pushButton_cancelar.setMinimumSize(new QSize(82, 24));
        QPalette palette7= new QPalette();
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        pushButton_cancelar.setPalette(palette7);
        QFont font11 = new QFont();
        font11.setBold(true);
        font11.setWeight(75);
        pushButton_cancelar.setFont(font11);
        pushButton_cancelar.setStyleSheet("");
        pushButton_cancelar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Salir.png")));

        horizontalLayout.addWidget(pushButton_cancelar);

        label_Logo = new QLabel(Reservas);
        label_Logo.setObjectName("label_Logo");
        label_Logo.setGeometry(new QRect(480, 20, 121, 101));
        label_Logo.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_Logo.setAutoFillBackground(false);
        label_Logo.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        label_Logo.setPixmap(new QPixmap(("Resources/Logos/logo_size_invert.png")));
        label_Logo.setScaledContents(true);
        label_Logo.setWordWrap(false);
        label_Titulo = new QLabel(Reservas);
        label_Titulo.setObjectName("label_Titulo");
        label_Titulo.setGeometry(new QRect(20, 20, 181, 31));
        QFont font12 = new QFont();
        font12.setPointSize(15);
        font12.setBold(true);
        font12.setUnderline(true);
        font12.setWeight(75);
        label_Titulo.setFont(font12);
        label_Titulo.setStyleSheet("");
        groupBox_cliente = new QGroupBox(Reservas);
        groupBox_cliente.setObjectName("groupBox_cliente");
        groupBox_cliente.setEnabled(true);
        groupBox_cliente.setGeometry(new QRect(10, 60, 461, 61));
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
        groupBox_cliente.setPalette(palette8);
        QFont font13 = new QFont();
        font13.setPointSize(10);
        font13.setBold(true);
        font13.setWeight(75);
        groupBox_cliente.setFont(font13);
        groupBox_cliente.setStyleSheet("background-color:rgb(152,210,232)");
        comboBox = new QComboBox(groupBox_cliente);
        comboBox.setObjectName("comboBox");
        comboBox.setGeometry(new QRect(90, 20, 231, 22));
        QPalette palette9= new QPalette();
        palette9.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        comboBox.setPalette(palette9);
        label_clienteDNI = new QLabel(groupBox_cliente);
        label_clienteDNI.setObjectName("label_clienteDNI");
        label_clienteDNI.setGeometry(new QRect(10, 20, 77, 21));
        QFont font14 = new QFont();
        font14.setPointSize(8);
        font14.setBold(true);
        font14.setWeight(75);
        label_clienteDNI.setFont(font14);
        QWidget.setTabOrder(comboBox, dateEditInicio);
        QWidget.setTabOrder(dateEditInicio, calendarWidget_Inicio);
        QWidget.setTabOrder(calendarWidget_Inicio, dateEditFin);
        QWidget.setTabOrder(dateEditFin, calendarWidget_Fin);
        QWidget.setTabOrder(calendarWidget_Fin, pushButton_eliminar);
        QWidget.setTabOrder(pushButton_eliminar, pushButton_modificar);
        QWidget.setTabOrder(pushButton_modificar, pushButton_reservar);
        QWidget.setTabOrder(pushButton_reservar, pushButton_cancelar);
        retranslateUi(Reservas);
        pushButton_CalcularImporte.clicked.connect(this, "calcularImporte()");
        pushButton_reservar.clicked.connect(this, "insertar()");

        dateEditInicio.dateChanged.connect(calendarWidget_Inicio, "setFocus()");
        dateEditInicio.dateChanged.connect(calendarWidget_Inicio, "setSelectedDate(com.trolltech.qt.core.QDate)");
        calendarWidget_Inicio.clicked.connect(dateEditInicio, "setDate(com.trolltech.qt.core.QDate)");
        dateEditFin.dateChanged.connect(calendarWidget_Fin, "setFocus()");
        dateEditFin.dateChanged.connect(calendarWidget_Fin, "setSelectedDate(com.trolltech.qt.core.QDate)");
        calendarWidget_Fin.clicked.connect(dateEditFin, "setDate(com.trolltech.qt.core.QDate)");

        pushButton_modificar.clicked.connect(this, "modificar()");
        pushButton_eliminar.clicked.connect(this, "eliminar()");

        pushButton_cancelar.clicked.connect(Reservas, "close()");

        mostrarClientesDni();
        mostrarhabitaciones();
        mostrarReservas();
        Reservas.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Reservas)
    {
        Reservas.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Reservas", null));
        groupBox_Reservas.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Reserva", null));
        label_FechaInicio.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Fecha inicio:", null));
        label_Direccion_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Fecha fin:", null));
        groupBox_habitaciones.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Lista habitaciones", null));
        label_importeTotal.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Importe Total:", null));
        label_importeTotalRes.setText("");
        pushButton_CalcularImporte.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Eliminar reserva", null));
        pushButton_CalcularImporte.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Calcular importe", null));
        groupBox_reservas.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Lista reservas", null));
        pushButton_eliminar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Eliminar reserva", null));
        pushButton_eliminar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Elliminar", null));
        pushButton_modificar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Modificar reserva", null));
        pushButton_modificar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Modificar", null));
        pushButton_reservar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Reservar", null));
        pushButton_cancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Cancelar", null));
        label_Logo.setText("");
        label_Titulo.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Gesti\u00f3n reservas", null));
        groupBox_cliente.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Cliente", null));
        label_clienteDNI.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "DNI", null));
    } // retranslateUi

}

