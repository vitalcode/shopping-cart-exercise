package uk.vitalcode.hmrc

trait CostEngine[P <: ShopProduct] {
  def cost(product: List[P]): BigDecimal
}

trait AppleCostEngine extends CostEngine[Apple.type]

trait OrangeCostEngine extends CostEngine[Orange.type]

object AppleCostEngine {
  private val unitCost = BigDecimal(0.60)

  val defaultAppleCost = new AppleCostEngine {
    override def cost(apples: List[Apple.type]) = apples.size * unitCost
  }

  val discountedAppleCost = new AppleCostEngine {
    override def cost(apples: List[Apple.type]) = {
      def costApples(apples: List[Apple.type], cost: BigDecimal = 0): BigDecimal = {
        apples match {
          case Apple :: Apple :: rest => costApples(rest, cost + unitCost)
          case Apple :: rest => costApples(rest, cost + unitCost)
          case Nil => cost
        }
      }

      costApples(apples)
    }
  }
}

object OrangeCostEngine {
  private val unitCost = BigDecimal(0.25)

  val defaultOrangeCost = new OrangeCostEngine {
    override def cost(oranges: List[Orange.type]) = oranges.size * unitCost
  }

  val discountedOrangeCost = new OrangeCostEngine {
    override def cost(oranges: List[Orange.type]) = {
      def costOranges(oranges: List[Orange.type], cost: BigDecimal = 0): BigDecimal = {
        oranges match {
          case Orange :: Orange :: Orange :: rest => costOranges(rest, cost + 2 * unitCost)
          case Orange :: rest => costOranges(rest, cost + unitCost)
          case Nil => cost
        }
      }

      costOranges(oranges)
    }
  }
}
