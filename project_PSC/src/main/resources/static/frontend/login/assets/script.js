// Adiciona um listener ao formulário com id 'loginForm' que será executado quando o formulário for submetido.
document.getElementById('loginForm').addEventListener('submit', function(event) {
    // Previna o comportamento padrão do formulário (que seria recarregar a página).
    event.preventDefault();

    // Cria um objeto FormData contendo os dados do formulário submetido.
    const formData = new FormData(event.target);

    // Cria um objeto vazio para armazenar os dados de login.
    const loginData = {};

    // Preenche o objeto loginData com os dados do formulário.
    formData.forEach((value, key) => {
        loginData[key] = value;
    });

    // Faz uma requisição POST para o endpoint '/users/login' enviando os dados de login em formato JSON.
    fetch('/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
        // Converte a resposta da requisição para JSON.
        .then(response => response.json())
        // Verifica se o login foi bem-sucedido.
        .then(data => {
            if (data.success) {
                // Verifica o tipo de usuário e redireciona para a página apropriada.
                if (data.userType === 'USER') {
                    // Se o login for bem-sucedido e o usuário for do tipo 'USER', redireciona para a página home.
                    alert('Login bem sucedido! Redirecionando para a página do usuário.');
                    window.location.href = '../home/index.html';
                } else if (data.userType === 'ADMIN') {
                    // Se o login for bem-sucedido e o usuário for do tipo 'ADMIN', redireciona para a página do administrador.
                    alert('Login bem sucedido! Redirecionando para a página de administrador.');
                    window.location.href = '../homeAdm/index.html';
                }
            } else {
                // Se o login não for bem-sucedido, exibe um alerta de erro.
                alert('Email ou senha incorretos. Tente novamente.');
            }
        })
        // Caso ocorra um erro na requisição, exibe um alerta de erro.
        .catch(error => {
            console.error('Erro ao realizar login:', error);
            alert('Erro ao realizar login. Por favor, tente novamente.');
        });
});