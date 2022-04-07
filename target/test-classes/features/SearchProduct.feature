Feature: Search and Place the order for Products
	
	@ValidateProduct
	Scenario Outline: Search Experience for the product search in both homepage and offers page
	Given user is on GreenKart Landing page
	When user searched with Shortname <Name> and extracted actual name of product
	Then user searched for <Name> shortname in offers page to check if product exist with same name
	And validate product name in offers page matches with Landing Page
	
	Examples:
	| Name |
	| Tom  |
	| Beet |
	
	