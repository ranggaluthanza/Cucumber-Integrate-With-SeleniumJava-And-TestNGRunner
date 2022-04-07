Feature: Checkout Product	
	@CheckoutProduct
	Scenario: Add 3 items to cart and place the order
	Given user is on GreenKart Landing page
	When user add 3 items that their searched "Carrot" to cart
	And apply promo code in cart page
	Then Place order