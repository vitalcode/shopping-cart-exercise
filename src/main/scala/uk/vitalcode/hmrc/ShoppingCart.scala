package uk.vitalcode.hmrc

import uk.vitalcode.hmrc.CostEngine._

case class ShoppingCart(costEngines: List[CostEngine] = Nil) {

  private val defaultCostEngines = defaultAppleCost :: defaultOrangeCost :: Nil

  def cost(products: List[ShopProduct]): BigDecimal = {

    def totalCost(cost: BigDecimal, products: List[ShopProduct]): BigDecimal = {

      val combinedCostEngines = costEngines ++ defaultCostEngines
      val combinedCostFn = combinedCostEngines.tail.foldLeft(combinedCostEngines.head.cost)((acc, e) => acc orElse e.cost)
      val costResult = combinedCostFn(cost, products.sortBy(_.toString))

      costResult match {
        case (c, Nil) => c
        case (c, l) => totalCost(c, l)
      }
    }

    totalCost(0, products)
  }
}
