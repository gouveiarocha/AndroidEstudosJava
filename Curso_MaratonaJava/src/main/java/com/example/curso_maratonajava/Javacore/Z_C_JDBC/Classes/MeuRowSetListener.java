package com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes;

import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MeuRowSetListener implements RowSetListener{

    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("Comando execute executado...");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Quando a linha for inserida, atualizada ou deletada...");
        if (event.getSource() instanceof RowSet) {
            try {
                ((RowSet) event.getSource()).execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor moveu...");
    }

}
