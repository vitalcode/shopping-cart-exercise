package uk.vitalcode.hmrc

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartTest extends AnyFreeSpec with Matchers {
  "ShoppingCart" - {
    "given collection of products" - {
      "should calclate the total cost the products correctly (each apple cost 60p and each orange cost 25p)" in {
        ShoppingCart.cost(Apple :: Apple :: Orange :: Apple :: Nil) shouldBe 2.05
      }
    }
  }
}

