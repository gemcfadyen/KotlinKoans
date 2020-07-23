// Return the sum of prices for all the products ordered by a given customer
fun moneySpentBy(customer: Customer): Double {
   val orders : List<Order> = customer.orders
   return orders.flatMap { it.products }.sumByDouble { it.price }
}
