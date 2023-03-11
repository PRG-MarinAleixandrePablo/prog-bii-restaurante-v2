package es.progcipfpbatoi.view;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import es.progcipfpbatoi.model.dto.Order;
import es.progcipfpbatoi.model.dto.producttypes.Product;

public class OrderView {

    private final Order order;

    public OrderView(Order order) {
        this.order = order;
    }

    public void show() {
        System.out.println(renderView());
    }

    private String renderView() {

        AsciiTable at = new AsciiTable();
        at.addRule();
        AT_Row row = at.addRow(null, null, null, null, null, null, null, null, " === Restaurante 20 Montaditos === ");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        row = at.addRow(null, null, "Pedido: " + order.getCode(), null, null, "Cliente: " + order.getClientName(), null, null,  "Fecha: " + order.getCreatedOn());
        row.setPadding(1);
        at.addRule();
        row = at.addRow(null, null , null, null, null, null, null, null, "Listado productos solicitados");
        row.setTextAlignment(TextAlignment.LEFT);
        at.addRule();
        row = at.addRow("", null, null, null,  "Nombre", "Precio", null, "Descuento(%)", "PVP");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        for (Product product: order.getProducts()) {
            AT_Row row2 = at.addRow(product.getCod(), null, null, null, product.getName(), prizeToCurrencyFormat(product.getPrizeWithoutDiscount()), null, prizeToCurrencyFormat(product.getPercentageDiscount()), prizeToCurrencyFormat(product.getPrize()));
            row2.setTextAlignment(TextAlignment.CENTER);
            at.addRule();
        }
        row = at.addRow(null, null, null, null, null, "", null, "Total", prizeToCurrencyFormat(order.getOrderPrize()));
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        row = at.addRow("*", "*", "*", "*", "*", "*", "*", "*", "*");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        at.getContext().setGridTheme(TA_GridThemes.FULL);
        return at.render();

    }

    private String prizeToCurrencyFormat(double prize) {
        return String.format("%.2f€", order.getOrderPrize());
    }

    @Override
    public String toString() {
        return renderView();
    }

}
