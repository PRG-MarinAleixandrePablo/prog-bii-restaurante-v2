package es.progcipfpbatoi.view;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import es.progcipfpbatoi.model.entidades.producttypes.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuCardViewList {

    protected final List<Product> products;

    public MenuCardViewList(ArrayList<Product> menuCard) {
        this.products = menuCard;
    }

    public void show() {
        System.out.println(renderView());
    }

    private String renderView() {
        return AsciiTable.getTable(products, Arrays.asList(
                        new Column().with(Product::getCod),
                        new Column().header("Nombre").with(Product::getName),
                        new Column().header("Precio").with((Product product) ->
                                String.format("%.02f€", product.getPrizeWithoutDiscount())
                        ),
                        new Column().header("Descuento (%)").with((Product product)
                                -> String.format("%.02f", product.getPercentageDiscount())
                        ),
                        new Column().header("Extras").with(Product::getExtras)
                )
        );
    }

    @Override
    public String toString() {
        return renderView();
    }

}
