document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evitar o envio do formulário

    // Obter dados do formulário
    const formData = new FormData(event.target);

    // Converter dados para objeto JSON
    const userData = {};
    formData.forEach((value, key) => {
        userData[key] = value;
    });

    // Verificar se as senhas coincidem
    if (userData.senha !== userData['confirma-senha']) {
        alert('Senhas não coincidem. Tente novamente.');
        return;
    }

    // Enviar dados para o backend
    fetch('/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
        .then(response => {
            if (response.ok) {
                alert('Usuário criado com sucesso!');
            } else {
                alert('Erro ao criar usuário. Por favor, tente novamente.');
            }
        })
        .catch(error => {
            console.error('Erro ao criar usuário:', error);
            alert('Erro ao criar usuário. Por favor, tente novamente.');
        });

    // Verificar se "Lembrar de mim" está marcado
    if (document.getElementById('remember-me').checked) {
        localStorage.setItem('rememberMe', JSON.stringify(userData));
    }
});

// Função para preencher o formulário automaticamente
window.addEventListener('DOMContentLoaded', () => {
    const rememberedUserData = JSON.parse(localStorage.getItem('rememberMe'));
    if (rememberedUserData) {
        for (const [key, value] of Object.entries(rememberedUserData)) {
            const input = document.querySelector(`[name="${key}"]`);
            if (input) {
                input.value = value;
            }
        }
    }
});

// Redirecionar para a página de login
document.getElementById('login-link').addEventListener('click', function(event) {
    event.preventDefault();
    window.location.href = '/login'; // Ajuste o caminho conforme necessário
});