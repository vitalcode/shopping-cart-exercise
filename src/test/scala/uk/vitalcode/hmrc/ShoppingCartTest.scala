package uk.vitalcode.hmrc

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import uk.vitalcode.hmrc.CostEngine._

class ShoppingCartTest extends AnyFreeSpec with Matchers {
  "ShoppingCart" - {
    "given collection of products" - {
      "should calculate the total cost the products correctly (each apple cost 60p and each orange cost 25p)" in {
        ShoppingCart()
          .cost(Apple :: Apple :: Orange :: Apple :: Nil) shouldBe 2.05
      }
    }
    "given collection of products and discounts" - {
      "should apply correct discount to Apples" in {
        ShoppingCart(discountedAppleCost :: Nil)
          .cost(Apple :: Apple :: Apple :: Apple :: Apple :: Nil) shouldBe 1.8
      }
      "should apply correct discount to Oranges" in {
        ShoppingCart(discountedOrangeCost :: Nil)
          .cost(Orange :: Orange :: Orange :: Orange :: Nil) shouldBe 0.75
      }
      "should apply correct discount to both Apples and Oranges" in {
        ShoppingCart(discountedAppleCost :: discountedOrangeCost :: Nil)
          .cost(Apple :: Apple :: Apple :: Orange :: Orange :: Orange :: Apple :: Apple :: Apple :: Orange :: Orange :: Nil) shouldBe 2.8
      }
    }
  }
}
