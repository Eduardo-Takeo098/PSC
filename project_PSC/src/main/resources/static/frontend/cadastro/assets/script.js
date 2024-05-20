document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();


    const formData = new FormData(event.target);

    const userData = {};
    formData.forEach((value, key) => {
        userData[key] = value;
    });

    if (userData.senha !== userData['confirma-senha']) {
        alert('Senhas não coincidem. Tente novamente.');
        return;
    }

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

    if (document.getElementById('remember-me').checked) {
        localStorage.setItem('rememberMe', JSON.stringify(userData));
    }
});

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