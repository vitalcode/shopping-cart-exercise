package uk.vitalcode.hmrc

trait CostEngine {
  def cost: PartialFunction[(BigDecimal, List[ShopProduct]), (BigDecimal, List[ShopProduct])]
}

object CostEngine {
  private val appleUnitCost = BigDecimal(0.60)
  private val orangeUnitCost = BigDecimal(0.25)

  val defaultAppleCost = new CostEngine {
    override def cost = {
      case (c, Apple :: rest) => (c + appleUnitCost, rest)
    }
  }

  val defaultOrangeCost = new CostEngine {
    override def cost = {
      case (c, Orange :: rest) => (c + orangeUnitCost, rest)
    }
  }

  val discountedAppleCost = new CostEngine {
    override def cost = {
      case (c, Apple :: Apple :: rest) => (c + appleUnitCost, rest)
    }
  }

  val discountedOrangeCost = new CostEngine {
    override def cost = {
      case (c, Orange :: Orange :: Orange :: rest) => (c + 2 * orangeUnitCost, rest)
    }
  }
}

