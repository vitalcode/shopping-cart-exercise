package uk.vitalcode.hmrc

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import uk.vitalcode.hmrc.CostEngine._

class CostEngineTest extends AnyFreeSpec with Matchers {

  private val zero = BigDecimal(0)

  "AppleCostEngine" - {
    "defaultAppleCost" - {
      "should calculate cost based on individual cost (60p) of apple" in {
        defaultAppleCost.cost( zero -> (Apple :: Nil)) shouldBe 0.60 -> Nil
      }
    }
    "discountedAppleCost" - {
      "should calculate cost applying discount rule: buy one, get one free" in {
        discountedAppleCost.cost(zero -> (Apple :: Apple :: Nil)) shouldBe 0.60 -> Nil
      }
    }
  }
  "OrangeCostEngine" - {
    "defaultOrangeCost" - {
      "should calculate total cost pbased on individual cost (25p) of orange" in {
        defaultOrangeCost.cost(zero -> (Orange :: Nil)) shouldBe 0.25 -> Nil
      }
    }
    "discountedOrangeCost" - {
      "should calculate cost applying discount rule: 3 for the price of 2" in {
        discountedOrangeCost.cost(zero -> (Orange :: Orange :: Orange :: Nil)) shouldBe 0.50 -> Nil
      }
    }
  }
}
