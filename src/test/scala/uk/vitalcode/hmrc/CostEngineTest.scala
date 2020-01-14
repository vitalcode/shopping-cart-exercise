package uk.vitalcode.hmrc

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import uk.vitalcode.hmrc.AppleCostEngine.{defaultAppleCost, discountedAppleCost}
import uk.vitalcode.hmrc.OrangeCostEngine.{defaultOrangeCost, discountedOrangeCost}

class CostEngineTest extends AnyFreeSpec with Matchers {
  "AppleCostEngine" - {
    val apples = Apple :: Apple :: Apple :: Nil
    "defaultAppleCost" - {
      "should calculate total cost by adding the individual cost (60p) of all apples" in {
        defaultAppleCost.cost(apples) shouldBe 1.80
      }
    }
    "discountedAppleCost" - {
      "should calculate cost applying discount rule: buy one, get one free" in {
        discountedAppleCost.cost(apples) shouldBe 1.20
      }
    }
  }
  "OrangeCostEngine" - {
    val oranges = Orange :: Orange :: Orange :: Orange :: Nil
    "defaultOrangeCost" - {
      "should calculate total cost by adding the individual cost (25p) of all oranges" in {
        defaultOrangeCost.cost(oranges) shouldBe 1.00
      }
    }
    "discountedOrangeCost" - {
      "should calculate cost applying discount rule: 3 for the price of 2" in {
        discountedOrangeCost.cost(oranges) shouldBe 0.75
      }
    }
  }
}
