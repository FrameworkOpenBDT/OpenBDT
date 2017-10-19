Feature: Cadastrar um usuario no site Automation Practice

@usrum
Scenario Outline: Cadastrar usuario um
  Given estou na pagina inicial do site "<url>"
  When clico em 'Sign in'
  And sistema apresenta tela de cadastro
  And preencho 'Email address' "<email_address>"
  And clico no botão 'Create an account'
  And sistema apresenta tela 'YOUR PERSONAL INFORMATION'
  And preencho radio-button 'Title' "<title>"
  And preencho 'First name*' "<first_name>"
  And preencho 'Last name*' "<last_name>"
  And preencho 'Email*' "<email>" da tela de cadastro
  And preencho 'Password*' "<password>"
  And seleciono dia 'Date of Birth' "<day_of_birth>"
  And seleciono mês 'Date of Birth' "<month_of_birth>"
  And seleciono ano 'Date of Birth' "<year_of_birth>"
  And preencho check-box 'Sign up for our newsletter!' "<check_box_newsletter>"
  And preencho check-box 'Receive special offers from our partners!' "<check_box_offers_from_partners>"
  And preencho 'Address*' "<address>"
  And preencho 'City*' "<city>"
  And seleciono'State*' "<state>"
  And preencho 'Zip/Postal Code*' "<zip_postal_code>"
  And seleciono'Country*' "<country>"
  And preencho 'Additional information*' "<additional_information>"
  And preencho 'Mobile phone*' "<mobile_phone>"
  And preencho 'Assign an address alias for future reference. *' "<address_alias>"
  And clico no botão 'Register >'
  Then sistema apresente tela "<validacao>"

Examples:
   | url                                     | email_address      | title | first_name | last_name | email               | password | day_of_birth  | month_of_birth | year_of_birth    | check_box_newsletter | check_box_offers_from_partners | address   | city  | state | zip_postal_code | country       | additional_information  | mobile_phone | address_alias | validacao|
   | http://automationpractice.com/index.php | teste@teste.com.br | mr.   | Teste      | Teste     | teste9@teste.com.br | teste    | 9&nbsp;&nbsp; | November&nbsp; | 1999&nbsp;&nbsp; | sim                  | não                            | avenida 9 | Testa | Texas | 12999           | United States | Este é só mais um teste | 9990299      | avenida 9     |MY ACCOUNT| 
   | http://automationpractice.com/index.php | teste@teste.com.br | mr.   | Teste      | Teste     | teste9@teste.com.br | teste    | 9&nbsp;&nbsp; | November&nbsp; | 1999&nbsp;&nbsp; | sim                  | não                            | avenida 9 | Testa | Texas | 12999           | United States | Este é só mais um teste | 9990299      | avenida 9     |OK|
   #| http://automationpractice.com/index.php | teste@teste.com.br | mr.   | Teste      | Teste     | teste9@teste.com.br | teste    | 9&nbsp;&nbsp; | November&nbsp; | 1999&nbsp;&nbsp; | sim                  | não                            | avenida 9 | Testa | Texas | 12999           | United States | Este é só mais um teste | 9990299      | avenida 9     |MY account|
   #| http://automationpractice.com/index.php | teste@teste.com.br | mr.   | Teste      | Teste     | teste9@teste.com.br | teste    | 9&nbsp;&nbsp; | November&nbsp; | 1999&nbsp;&nbsp; | sim                  | não                            | avenida 9 | Testa | Texas | 12999           | United States | Este é só mais um teste | 9990299      | avenida 9     |MY ACCOUNT|


#@reprodois


#@reprotres
#Scenario: Cadastrar usuario tres
#  Given estou na pagina inicial do site
#  When bclico em 'Sign in'
#  And bsistema apresenta tela de cadastro
#  And bpreencho 'Email address' "<email_address>"
#  And bclico no botão 'Create an account'
#  And bsistema apresenta tela 'YOUR PERSONAL INFORMATION'
#  And bpreencho radio-button 'Title' "<title>"
#  And bpreencho 'First name*' "<first_name>"
#  And bpreencho 'Last name*' "<last_name>"
#  And bpreencho 'Email*' "<email>" da tela de cadastro
#  And bpreencho 'Password*' "<password>"
#  And bseleciono dia 'Date of Birth' "<day_of_birth>"
#  And bseleciono mês 'Date of Birth' "<month_of_birth>"
#  And bseleciono ano 'Date of Birth' "<year_of_birth>"
#  And bpreencho check-box 'Sign up for our newsletter!' "<check_box_newsletter>"
#  And bpreencho check-box 'Receive special offers from our partners!' "<check_box_offers_from_partners>"
#  And bpreencho 'Address*' "<address>"
#  And bpreencho 'City*' "<city>"
#  And bseleciono'State*' "<state>"
#  And bpreencho 'Zip/Postal Code*' "<zip_postal_code>"
#  And bseleciono'Country*' "<country>"
#  And bpreencho 'Additional information*' "<additional_information>"
#  And bpreencho 'Mobile phone*' "<mobile_phone>"
#  And bpreencho 'Assign an address alias for future reference. *' "<address_alias>"
#  And bclico no botão 'Register >'
#  Then bsistema apresente tela 'MY ACCOUNT'
#
#Examples:
#   | email_address     | title | first_name | last_name | email               | password | day_of_birth | month_of_birth | year_of_birth | check_box_newsletter | check_box_offers_from_partners | address   | city  | state | zip_postal_code | country       | additional_information  | mobile_phone | address_alias | 
#   | teste@teste.com.br | mr.   | Teste      | Teste     | teste9@teste.com.br | teste    | 9            | November       | 1999          | sim                  | não                            | avenida 9 | Testa | Texas | 12999           | United States | Este é só mais um teste | 9990299      | avenida 9     | 
# 
# 


#@sanity
#Scenario: Cadastrar usuario ignorar
#  Given estou na pagina inicial do site
#  When cclico em 'Sign in'
#  Then csistema apresenta tela de cadastro
