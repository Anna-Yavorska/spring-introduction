package javahome.springbootstudent.hw_38.task_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/printing")
public class PrintingProductsController {
    @GetMapping("/products")
    public String printProducts() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Заголовок страницы</title>
                    <link rel="stylesheet" href="./styles/style.css">
                                
                    <meta property="og:title" content="Заголовок страницы в OG">
                    <meta property="og:description" content="Описание страницы в OG">
                    <meta property="og:image" content="https://example.com/image.jpg">
                    <meta property="og:url" content="https://example.com/">
                  </head>
                  <body>
                    <header>
                      <h1>Products</h1>
                    </header>
                    <main>
                        <section>
                          <h2>Products list of "Lidl" shop</h2>
                          <ul>
                          <li>"id":1,"name":"Potato","description":"3kg in pack","price":3.50</li>
                          <li>"id":2,"name":"Orange","description":"From Turkey","price":6.9</li>
                          <li>"id":3,"name":"Water","description":"Highly carbonated","price":2.0</li>
                          <li>"id":4,"name":"Corn","description":"Canned corn 2 in pack","price":7.15</li>
                          <li>"id":5,"name":"Cherry","description":"1kg in pack","price":20.0</li>
                          <li>"id":6,"name":"Bread","description":"Toast bread","price":1.9</li>
                          <li>"id":7,"name":"Chocolate","description":"Dark chocolate 100g","price":7.45</li>                          
                        </ul>
                        </section>
                    </main>
                    <footer>
                      <p>If you would like to become our supplier, please contact our <a href="https://www.google.com/" target="_blank" rel="noopener no-referrer">admin</a></p>
                    </footer>
                  </body>
                </html>
                """;
    }
}
