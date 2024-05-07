# AccountManagementsystem
1.Import the whole account-management-system folder to the eclipse as existing maven project and start the application.
2.POST API for creating current account:
open post man and paste the url http://localhost:8080/accounts and select the method POST and give the below JSON data.
{
    "customerId": "123",
    "initialCredit": 100
}
3. GET API for fetching the user details:
  use the URL http://localhost:8080/users/123 and select the method GET . It will give the JSON response with the user user information like name ,surname, transactions and balance
4. open the Acoountmanagementsystem.html that will give open a UI page to create a account. give customer id as "456" adn initial credit as "200". It will create a account. 
