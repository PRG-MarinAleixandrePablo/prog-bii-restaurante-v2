package es.progcipfpbatoi.view;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import es.progcipfpbatoi.utils.AnsiColor;
import es.progcipfpbatoi.model.dto.Order;

import java.util.ArrayList;

public class OrderViewList {

    private final ArrayList<Order> orderList;

    public OrderViewList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public void show(){
        if (orderList.size() > 0) {
            System.out.println(renderView());
        } else {
            System.out.println(AnsiColor.colorize(AnsiColor.RED, "No existen pedidos pendientes de servir"));
        }
    }

    private String renderView() {

        AsciiTable at = new AsciiTable();
        at.addRule();
        AT_Row row = at.addRow( null, null, null, " === Restaurante 20 Montaditos === ");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        row = at.addRow("Código", "Cliente", "Fecha", "Servido");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        for (Order order: orderList) {
            AT_Row row2 = at.addRow(order.getCode(), order.getClientName(), order.getCreatedOn(),
                    (order.isServed() ? "Si" : "No"));
            row2.setTextAlignment(TextAlignment.CENTER);
            at.addRule();
        }
        row = at.addRow("*", "*", "*", "*");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        at.getContext().setGridTheme(TA_GridThemes.FULL);
        return at.render();

    }

    @Override
    public String toString() {
        return renderView();
    }

}
