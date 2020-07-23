// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> {
//    val ab : Pair<List<Order>, List<Order>> = this.customers.map { it.orders }.flatten().partition { it.isDelivered }
//    val (isDelivered, isNotDelivered) = this.customers.flatMap { it.orders }.partition { it.isDelivered }


//    val customerOrders: List<List<Order>> = this.customers.map { it.orders }
//    val (isDelivered, isNotDelivered) = customerOrders.map { it.partition { order -> order.isDelivered } }


    return customers.filter { it ->
        val (isDelivered, isNotDelivered) = it.orders.partition { it.isDelivered }
        isNotDelivered.size > isDelivered.size
    }.toSet()
}
