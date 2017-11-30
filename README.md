# Stripe-Payment-Sample-Android
This is sample project for understanding how to use the stripe in our android application.
Use their official document from https://stripe.com/docs/mobile/android to implement stripe and gothrough this project for your reference

***************************
In this project there is homeactivity there you can enter the amount and a button to add your card detail.
In the addpayment activity we used strip CardMultilineWidget its the CardInputWidget provided by stripe.
It will capture card number and expiration date and cvc.
validate your card using card.validateCard() then call create token.

***************************
Befor calling the create token function we need a publishable key.
This is a demo test publishable key.
"pk_test_6pRNASCoBOKtIshFeQd4XMUh"
Sign in to see your own key.

Then call the create stripe function. You will get a stripe token. Pass this token to server.
