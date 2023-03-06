package es.progcipfpbatoi.views;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import es.progcipfpbatoi.model.entidades.producttypes.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuCardViewList {

    private List<Product> products;

    public MenuCardViewList(ArrayList<Product> menuCard) {
        this.products = menuCard;
    }

    public void show() {
        System.out.println(renderView());
    }

    private String renderView() {
        return AsciiTable.getTable(products, Arrays.asList(
                new Column().with(
                        (Product product) -> product.getCod()),
                new Column().header("Nombre").with(
                        (Product product) -> product.getName()),
                new Column().header("Precio").with((
                        Product product) -> String.format("%.02f€", product.getPrizeWithoutDiscount())),
                new Column().header("Descuento (%)").with((
                        Product product) -> String.format("%.02f", product.getPercentageDisccount()))
        ));
    }

    @Override
    public String toString() {
        return renderView();
    }

}
