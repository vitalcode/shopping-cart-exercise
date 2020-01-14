package uk.vitalcode.hmrc

object ShoppingCart {
  private val appleUnitCost = BigDecimal(0.60)
  private val orangeUnitCost = BigDecimal(0.25)

  def cost(products: List[ShopProduct]): BigDecimal = {
    val appleCost = products.count(_ == Apple) * appleUnitCost
    val orangeCost = products.count(_ == Orange) * orangeUnitCost
    appleCost + orangeCost
  }
}