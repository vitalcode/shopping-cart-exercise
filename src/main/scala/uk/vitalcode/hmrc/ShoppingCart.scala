package uk.vitalcode.hmrc

case class ShoppingCart(appleCostEngine: AppleCostEngine, orangeCostEngine: OrangeCostEngine) {
  def cost(products: List[ShopProduct]): BigDecimal = {
    val appleCost = appleCostEngine.cost(products.collect { case a: Apple.type => a })
    val orangeCost = orangeCostEngine.cost(products.collect { case o: Orange.type => o })
    appleCost + orangeCost
  }
}
