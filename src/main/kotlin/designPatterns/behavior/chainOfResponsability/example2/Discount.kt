package designPatterns.behavior.chainOfResponsability.example2

// Interface representing a discount handler in the chain
interface DiscountHandler {
    fun applyDiscount(purchaseAmount: Double): Double
}

// Concrete class representing a 10% discount handler
class TenPercentDiscountHandler(private val nextHandler: DiscountHandler) : DiscountHandler {
    override fun applyDiscount(purchaseAmount: Double): Double {
        return if (purchaseAmount >= 100 && purchaseAmount < 500) {
            val discount = purchaseAmount * 0.10
            println("Applied 10% discount: $discount")
            purchaseAmount - discount
        } else {
            nextHandler.applyDiscount(purchaseAmount)
        }
    }
}

// Concrete class representing a 20% discount handler
class TwentyPercentDiscountHandler(private val nextHandler: DiscountHandler) : DiscountHandler {
    override fun applyDiscount(purchaseAmount: Double): Double {
        return if (purchaseAmount >= 500 && purchaseAmount < 1000) {
            val discount = purchaseAmount * 0.20
            println("Applied 20% discount: $discount")
            purchaseAmount - discount
        } else {
            nextHandler.applyDiscount(purchaseAmount)
        }
    }
}

// Concrete class representing a 30% discount handler
class ThirtyPercentDiscountHandler : DiscountHandler {
    override fun applyDiscount(purchaseAmount: Double): Double {
        return if (purchaseAmount >= 1000) {
            val discount = purchaseAmount * 0.30
            println("Applied 30% discount: $discount")
            purchaseAmount - discount
        } else {
            purchaseAmount
        }
    }
}

fun main() {
    val thirtyPercentDiscountHandler = ThirtyPercentDiscountHandler()
    val twentyPercentDiscountHandler = TwentyPercentDiscountHandler(thirtyPercentDiscountHandler)
    val tenPercentDiscountHandler = TenPercentDiscountHandler(twentyPercentDiscountHandler)

    val purchaseAmount1 = 90.0
    val purchaseAmount2 = 200.0
    val purchaseAmount3 = 600.0
    val purchaseAmount4 = 1500.0

    println("Purchase amount: $purchaseAmount1")
    val discountedPrice1 = tenPercentDiscountHandler.applyDiscount(purchaseAmount1)
    println("Final price after discounts: $discountedPrice1")

    println("\nPurchase amount: $purchaseAmount2")
    val discountedPrice2 = tenPercentDiscountHandler.applyDiscount(purchaseAmount2)
    println("Final price after discounts: $discountedPrice2")

    println("\nPurchase amount: $purchaseAmount3")
    val discountedPrice3 = tenPercentDiscountHandler.applyDiscount(purchaseAmount3)
    println("Final price after discounts: $discountedPrice3")

    println("\nPurchase amount: $purchaseAmount4")
    val discountedPrice4 = tenPercentDiscountHandler.applyDiscount(purchaseAmount4)
    println("Final price after discounts: $discountedPrice4")
}
