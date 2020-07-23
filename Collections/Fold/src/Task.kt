//// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val allOrderedProducts: Set<Product> = customers.flatMap { it.getOrderedProducts() }.toSet()
    return this.customers.fold(allOrderedProducts) { product, customer -> product.intersect(customer.getOrderedProducts()) }
}

fun Customer.getOrderedProducts(): List<Product> =
        this.orders.flatMap { it.products }

