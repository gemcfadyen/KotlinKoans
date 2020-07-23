// Return a customer who has placed the maximum amount of orders
fun Shop.getCustomerWithMaxOrders(): Customer? = customers.sortedByDescending { it.orders.size }.first()

// Return the most expensive product that has been ordered by the given customer
fun getMostExpensiveProductBy(customer: Customer): Product? {
    val orders: List<Order> = customer.orders

    val products: List<Product> = orders.map { it.products }.flatten()
    return products.maxBy { it.price }
}
