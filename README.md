Este código é uma projeto de aula em Android que permite aos usuários consultar informações de CEP (Código de Endereçamento Postal) usando a API do ViaCEP. Aqui está um resumo das principais funcionalidades deste código:

---
**Layout da Interface do Usuário**: O código define uma interface de usuário (UI) com elementos como EditText para inserir um CEP, um botão para iniciar a consulta, e várias TextViews para exibir informações relacionadas ao CEP, como endereço, bairro, estado e UF.

**OnClick Listeners**: O código configura um OnClickListener para o botão "consultarButton". Quando o botão é clicado, ele chama o método consultarCEP().

**Consultar CEP**: O método consultarCEP() obtém o CEP digitado pelo usuário a partir do EditText e verifica se ele está vazio. Se estiver vazio, exibe uma mensagem de erro usando Toast. Caso contrário, ele cria uma solicitação para a API do ViaCEP para buscar informações do CEP fornecido.

**Requisição da API**: O código utiliza a biblioteca Volley para criar uma solicitação HTTP GET à API do ViaCEP. Ele processa a resposta da API para obter informações como endereço, bairro, estado e UF e, em seguida, atualiza as TextViews correspondentes com essas informações.

**Botão de Saída**: O código também configura um botão "exit_button" com um OnClickListener. Quando esse botão é clicado, ele retorna para a tela inicial chamada "Tela Principal"

Em resumo, este código cria uma atividade Android que permite aos usuários inserir um CEP, consultar informações relacionadas a esse CEP usando a API do ViaCEP e, se desejado. É um exemplo de como interagir com uma API externa e manipular elementos de interface do usuário em um aplicativo Android. Certifique-se de que os layouts e recursos associados a esse código estejam configurados corretamente em seu projeto Android.

***
**Aqui está um exemplo do app rodando**:

<img src="https://github.com/cadunands/CEP-Explorer/assets/88720122/838308aa-2052-4781-959e-5d60e047aa70" width="300">

<img src="https://github.com/cadunands/CEP-Explorer/assets/88720122/61904ebb-e972-40ea-b649-455583be5c7f" width="300">

<img src="https://github.com/cadunands/CEP-Explorer/assets/88720122/1866eb86-7075-4241-b5ca-91d1a2b994f4" width="300">
