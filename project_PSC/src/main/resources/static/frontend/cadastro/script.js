document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evitar o envio do formulário

    // Obter dados do formulário
    const formData = new FormData(event.target);

    // Converter dados para objeto JSON
    const userData = {};
    formData.forEach((value, key) => {
        userData[key] = value;
    });

    // Enviar dados para o backend
    fetch('/users' +
        '', {
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
});