# InstaPay-Application
InstaPay App - Advanced Software Engineering Project

This project involves building a system similar to Instapay. Users can use this system to transfer money or pay their bills. The system offers the following services:
- Transfer to another Instapay account
- Transfer to a Bank Account
- Transfer to a Mobile Wallet through wallet providers (e.g., Vodafone Cash, CIB, Fawry)
- Pay utility bills (Gas, Electricity, Water)

## Requirements

### User Management

1. **User Signup**
   - Users can register in two ways:
     - Using their bank account and the registered mobile number. The app verifies the account through the bank's API.
     - Using their mobile number with a wallet from a wallet provider (e.g., Vodafone Cash, CIB). The mobile number is verified with the wallet provider.
   - After verifying the bank account or wallet, the system sends an OTP to the user's mobile number for verification.
   - The user then enters a unique username and a complex password.

2. **User Login**
   - Users can sign in using their Instapay username and password.
   - Upon logging in, the system loads the user profile based on their type (bank account user or wallet user).

3. **User Operations**
   - Both types of users can:
     - Transfer to a Wallet using the mobile number
     - Transfer to another Instapay account
     - Inquire about their balance
     - Pay bills
   - Transferring to a bank account is only available for users registered using their bank account.

4. **Utility Bill Payment**
   - The system supports the creation and payment of utility bills (Gas, Electricity, Water).
   - Bill payments involve creating the bill and deducting the amount from the user's account.
   - Assume the contents of the bills as needed, varying based on the type of bill.

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/MohamedEssam71/InstaPay-Application.git

## Team members
| Name | ID | Email | Linked-In |
|------|----|-------|-----------|
| Mohamed Essam Mahmoud Osman | `20210346` | messam.sde@gmail.com | <a href = "https://www.linkedin.com/in/mohamed-essam71/">mohamed-essam71</a> |
| Mina Hakim | `20210418` | -- | <a href = "--"> -- </a> |
| Alan Samir Hakoun | `20210755` | alanhakoun@gmail.com | <a href = "https://www.linkedin.com/in/alan-hakoun/"> alan-hakoun </a> |
| Salah Eddin Mohamed | `20210187` | -- | <a href = "--"> -- </a> |
