package javahome.springbootstudent.hw_38.task_2.controller;

import javahome.springbootstudent.hw_38.task_1.model.Product;
import javahome.springbootstudent.hw_38.task_1.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class PrintingProductsController {
    private final ProductRepository productRepository;

    public PrintingProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/page")
    public String printProducts() {
        String header = """
                <!DOCTYPE html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Products</title>
                  </head>
                  <body>
                    <header>
                      <h1>Products</h1>
                    </header>
                """;

        String main = """
                <main>
                        <section>
                          <h2>Products list of "Lidl" shop</h2>
                          <ul>
                """;
        Collection<Product> allProducts = productRepository.getAllProducts();
        for (Product product : allProducts) {
            main = main.concat("<li>" + product + "</li>");
        }
        main = main.concat("""
                </ul>
                </section>
                </main>
                """);

        String footer = """
                    <footer>
                      <p>If you would like to become our supplier, please contact our <a href="https://www.google.com/" target="_blank" rel="noopener no-referrer">admin</a></p>
                    </footer>
                  </body>
                </html>
                """;
        return header + main + footer;
    }
}
