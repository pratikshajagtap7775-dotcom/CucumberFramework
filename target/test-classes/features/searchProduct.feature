Feature:Search and place the order for products

@offersPage
Scenario Outline:Search experience for product search in both home and offers page

Given User is on GreenKart landing page
When User searched with shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname on offers page
And Validate product name in offers page matches with landing page

Examples:
| Name |
| Tom |
| Beetr |
