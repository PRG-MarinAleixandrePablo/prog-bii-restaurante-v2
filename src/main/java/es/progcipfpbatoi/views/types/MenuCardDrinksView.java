package es.progcipfpbatoi.views.types;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import es.progcipfpbatoi.model.entidades.Order;
import es.progcipfpbatoi.model.entidades.producttypes.Product;
import es.progcipfpbatoi.model.entidades.producttypes.types.Drink;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuCardDrinksView extends MenuCardViewList {

    public MenuCardDrinksView(ArrayList<Drink> menuCard) {
        super(new ArrayList<>(menuCard));
    }

    @Override
    protected String renderView() {

        AsciiTable at = new AsciiTable();
        at.addRule();
        AT_Row row = at.addRow( null, null, null, null, null, "Bebidas");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        row = at.addRow(" ", "Nombre", "Tamaño", "Rellenable", "Precio Base", "Descuento");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        for (Product product: products) {
            Drink drink = (Drink) product;
            AT_Row row2 = at.addRow(product.getCod(), product.getName(), drink.getSize(),
                    (drink.isRefillable() ? "Si" : "No"), product.getPrize(), product.getPercentageDisccount());
            row2.setTextAlignment(TextAlignment.CENTER);
            at.addRule();
        }

        at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        at.getContext().setGridTheme(TA_GridThemes.FULL);
        return at.render();
    }
}
